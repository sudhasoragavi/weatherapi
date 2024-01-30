This project demonstrates how to perform API testing using the Rest Assured library with Cucumber in a Java project.

Introduction
This project aims to showcase best practices for API testing using Rest Assured, a popular Java library for RESTful API testing, and Cucumber, a behavior-driven development (BDD) tool that allows for easy-to-read test scenarios written in a natural language style.

Setup
To run the tests in this project, you'll need:

Java Development Kit (JDK) installed on your machine
Maven for dependency management

The project structure is organized as follows:


.
├── src
│   ├── main
│   │   └── java
│   │       └── (source code)
│   └── test
│       └── java
│           ├── features
│           │   └── (Cucumber feature files)
│           ├── stepdefinitions
│           │   └── (Cucumber step definitions)
│           └── runners
│               └── (Cucumber test runners)
└── pom.xml
src/main/java: Contains the source code for the application.
src/test/java/features: Contains Cucumber feature files describing test scenarios.
src/test/java/stepdefinitions: Contains Cucumber step definitions implementing test steps.
src/test/java/runners: Contains Cucumber test runners for executing tests.

Cucumber HTML Reports
After running the tests, HTML reports are generated in the target/cucumber-reports directory. You can open the index.html file in a web browser to view the detailed test results, including passed, failed, and skipped scenarios.
