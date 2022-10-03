# UnitedCloudTest by Branislav Guduric

## Short introduction to Serenity

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.

## Executing the tests

First of all, you need to clone project to your local repository.

To run the all of the tests at once, you can simply type in Terminal:

mvn verify

If you are getting error: 

"The term 'mvn' is not recognized as the name of a cmdlet, function, script file, or operable program. Check the spelling of the name, or if a path was included, verify that the path is correct and try again."

you can run the tests from IntelliJ by clicking on: Run -> Run Maven Goal -> Verify

To run tests separately, in IntelliJ navigate to folder:

src/test/java/testcases

and right-click on any of the tests you want to run, and click on: Run '$TESTNAME'

## Generating the reports

Since the Serenity reports contain aggregate information about all of the tests, they are not generated after each individual test (as this would be extremenly inefficient). They reports are also integrated into the Maven build process: the following code in the pom.xml file causes the reports to be generated automatically once all the tests have completed when you run:

mvn verify

<plugin>
                <groupId>net.serenity-bdd.maven.plugins</groupId>
                <artifactId>serenity-maven-plugin</artifactId>
                <version>${serenity.maven.version}</version>
                <configuration>
                    <tags>${tags}</tags>
                </configuration>
                <executions>
                    <execution>
                        <id>serenity-reports</id>
                        <phase>post-integration-test</phase>
                        <goals>
                            <goal>aggregate</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
            
            
When all tests are completed, a new folder "target" will be generated. You can check for all test results and reports by opening file:

target/site/index.html
