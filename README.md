# Demo_Karate_API
Maven project to automate the test cases of one API test project.


Objective
---------
This project has been created to automate the tests cases of a fictional online pet shop (https://petstore.swagger.io/#/store).
The tests have been automated using Karate API framework.

Test plan
---------
These are the functional test cases that have been implemented so far:

#### Tests feature

- 01 Get all available pets. Assert the list provided is correct.

- 02 Post a new pet in the shop. Assert the pet has been added correctly.

- 03 Update the state of the previously posted pet status to "sold". Assert the new state is correct

- 04 Delete the previously posted pet. Assert it has been deleted.

History
-------------
- July 23th 2024
  This project was developed to run using Karate API framework.

How to run it
-------------
You can run it using the maven command: "mvn test".

Test results-Report
-------------------
After the tests have been completed, a test report is generated in the folder ./target/karate-reports/karate-summary.html



