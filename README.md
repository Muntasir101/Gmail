### selenium-cucumber-java

This repository contains a collection of sample `selenium-cucumber-java` projects and libraries that demonstrate how to
use the tool and develop automation script using the Cucumber (v 3.0.0) BDD framework with Java as programming language.
It generate Allure, HTML and JSON reporters as well. It also generate `screen shots` for your tests if you enable it and
also generate `error shots` for your failed test cases as well.

### Installation (pre-requisites)

1. JDK 1.8+ (make sure Java class path is set)
2. Maven (make sure .m2 class path is set)
3. IntelliJ
4. IntelliJ Plugins for
    - Maven
    - TestNG
5. Browser driver (make sure you have your desired browser driver and class path is set)
6. Real Browser(Chrome, Firefox)

### Framework set up

Fork / Clone repository from [here]( https://github.com/Muntasir101/Gmai) or download zip and set
it up in your local workspace.

### Run Some Sample Tests

Open terminal (MAC OSX) or command prompt / power shell (for windows OS) and navigate to the project directory
type `mvn clean test` command to run tests. With this command it will invoke the default Firefox browser and will
execute the tests.

### Logs

Once you ran your tests, Log auto generate. This framework `Gmail` Log4J for log management.

### Reporters

Once you ran your tests you can generate the reports. This framework `Gmail` uses
several different types of test reporters to communicate pass/failure.


##### HTML Report:

To generate HTML report use  `mvn test -Dcucumber.options="–plugin html:target/result.html"`

##### JSON Report:

To generate a JSON report Use `mvn test -Dcucumber.options="–plugin json:target/result.json"`

##### Extent Spark Reports

The Framework uses [Spark Reports Framework](http://www.extentreports.com/docs/versions/4/java/spark-reporter.html) to
generate the HTML Test Reports

