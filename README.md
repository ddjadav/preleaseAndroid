# appium-cucumberbdd-testng
Appium mobile test automation framework with Page Object Model design using Java + Cucumber + Maven + TestNG.
Framework follows many of the industry best practices and supports Android and iOS in a single code base.

Technologies/Tools used in building the framework
=================================================
- IntelliJ - IDE
- Appium - Mobile Automation library
- Maven - Build automation tool
- Java - Programming language
- Cucumber - BDD
- Gherkin - DSL
- TestNG - Test Management library
- Log4J - Logging framework
- Extent Reports - Reporting framework
- JSON - Test Data
- XML - Static text

Configration
=============
- set your app parms in config file
- Use test ng suite for parameter input
- input device id and platform
- run maven command as below
- for manual run MyRunnerTest runner
- set global parameter for run test in intellij



Compile Build or Run Tests
==========================

Command Line

cd to root of automationFramework project directory

To clean and compile the build
-----------------------------
- mvn clean install -DskipTests

To run all tests parallel
------------------------
- mvn clean install  
