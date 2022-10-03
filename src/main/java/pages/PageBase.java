package pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.NoSuchElementException;
import java.time.Duration;
import java.util.List;

public class PageBase extends PageObject {
    @SuppressWarnings("FieldCanBeLocal")

    private int WAIT_TIME = 5;

    //region Methods for returning WebElement(s)
    public WebElement getElement(String locator) {
        try {
            return getDriver().findElement(By.xpath(locator));

        } catch (NoSuchElementException exception) {
            exception.getMessage();
        }

        return null;
    }

    public List<WebElement> getElements(String locator) {
        try {
            return getDriver().findElements(By.xpath(locator));
        } catch (NoSuchElementException exception) {
            exception.getMessage();
        }

        return null;
    }

    //endregion

    //region Actions
    public void click(String locator) {
        waitFor(getElement(locator)).withTimeoutOf(Duration.ofSeconds(5)).waitUntilEnabled().waitUntilClickable().click();
    }

    public void type(String locator, String value) {
        waitFor(getElement(locator)).waitUntilClickable().sendKeys(value);
    }

    public String getText(String locator) {
        return waitFor(getElement(locator)).waitUntilClickable().getText();
    }

    public void scroolToElementAndClick(String locator) {
        WebElement element = waitFor(getElement(locator));
        withAction().scrollToElement(element).perform();
        click(locator);
    }
    //endregion

    //region Methonds for checking of availability

    public boolean isVisible(String locator) {
        return getDriver().findElement(By.xpath(locator)).isDisplayed();
    }
    public boolean isPageActive(String newPageURL) {
        try {
            waitForCondition().withTimeout(Duration.ofSeconds(WAIT_TIME)).until(ExpectedConditions.urlContains(newPageURL));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    //endregion
}