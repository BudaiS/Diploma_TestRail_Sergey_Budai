# Product description

TestRail is a web-based test case management tool. It is used by testers, developers and team leads to manage, track, and organize software testing efforts.

# Checklist

### Login
- check if all fields of the form can be filled;
- check the ability to log in to the site
- check if errors occur due to incorrect data entry

### Project
- check the possibility of creating a new Project
- check if the new Project can be deleted
- check for the presence and consistency of messages about creating and deleting a Project

### Milestones
- check the possibility of creating a new Milestones
- check if the new Milestones can be deleted
- check for the presence and consistency of messages about creating and deleting a Milestones

### Test Case
- check the possibility of creating a new Test Case
- check that all fields in the new Test Case are true
- check if the new Test Case can be deleted
- check for the presence and consistency of messages about creating and deleting a Test Case
- check the possibility of creating a new Test Section
- check if the new Test Section can be deleted
- check for the presence and consistency of messages about creating and deleting a Test Section

### Test Run
- check the possibility of creating a new Test Run
- check if the new Test Run can be deleted
- check for the presence and consistency of messages about creating and deleting a Test Run
- check the possibility of creating a new Test Plan
- check if the new Test Plan can be deleted
- check for the presence and consistency of messages about creating and deleting a Test Plan

### Reports
- check the possibility of creating a new Report
- check that all fields in the new Report are true
- check if the new Report can be deleted



# Stack
- [Java 18.0.1.1]
- [Selenium 3.141.59]
- [Maven 4.0.0]
- [TestNG 7.6.0]
- [Lombok 1.18.8]
- [WebDriveManage 5.2.0]
- [Allure TestNG 2.18.1]
- [Java Faker 1.0.2]
- [Jackson Dataformat 2.13.3]
- [Aspectj 1.9.8]
- [Log4j 2.18.0]


# Patterns Used: 
- Page Object Model
- Builder 
- Decorator
- Data Provider
- Value Object


# Running tests:

- TestNG command for run all test: - mvn clean test
- mvn clean test -DsuiteXmlFile=’smokeTest.xml’
- mvn clean test -DsuiteXmlFile=’negativeTest.xml’






