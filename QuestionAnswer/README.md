# QuestionAnswerDemo

This project will take user inputs as 1 & 2 and provide answers for questions asked by user if it is available in repository.
If answer is not available a generic answer will be provided.
# Points to be noted

a.) While adding a question format should be as question?"answer1""answer2"....

b.)	Web has been enabled currently only to connect to In memory database console H2.

# How to build

Prerequisite :  maven should be installed and enabled.
For executing the project directly from directory please follow steps mentioned below :

Windows :
1.) Go to project directory .
2.) Open command prompt.
3.) Type mvnw clean install
4.) type mvnw spring-boot:run

Unix : 
1. cd to project directory.
2.) ./mvnw clean install
3.) ./mvnw spring-boot:run
