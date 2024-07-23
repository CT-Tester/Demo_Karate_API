Feature: Api automated test cases
  Background:
    * def utilsClass = Java.type('classes.Utils')
  Scenario: 01 Get all available pets. Assert expected result
    * def expectedJSON = read("../data/expectedAvailablePets.json")
    Given url baseURL+'/pet/findByStatus?status=available'
    When method GET
    And status 200
    * string responseJSON = response
    * string expectedJSON = expectedJSON
    * print responseJSON
    * print expectedJSON
    * def testResult = utilsClass.assertPets(expectedJSON, responseJSON)
    * match testResult == true

  Scenario: 02 Post a new available pet to the store. Assert new pet added.
    * def postJSON = read("../data/newPet.json")
    * def expectedPlatypus = read("../data/expectedPlatypus.json")
    Given url baseURL+'/pet'
    And request postJSON
    When method POST
    And assert responseStatus == 201 || responseStatus == 200
    Then url baseURL+'/pet/9999'
    And method GET
    * string responseJSON = response
    * string expectedJSON = expectedPlatypus
    * print responseJSON
    * print expectedJSON
    * def testResult = utilsClass.assertPet(expectedJSON, responseJSON)
    * match testResult == true

  Scenario: 03 Update the state of the previously posted pet to "sold". Assert the new state.
    * def putJSON = read("../data/updatedPet.json")
    * def expectedPlatypus = read("../data/updatedPlatypus.json")
    Given  url baseURL + '/pet'
    And request putJSON
    When method PUT
    And assert responseStatus == 201 || responseStatus == 200
    Then url baseURL+'/pet/9999'
    And method GET
    * string responseJSON = response
    * string expectedJSON = expectedPlatypus
    * print responseJSON
    * print expectedJSON
    * def testResult = utilsClass.assertPet(expectedJSON, responseJSON)
    * match testResult == true

  Scenario: 04 Delete the previously posted pet. Assert deletion.
    Given url baseURL+'/pet/9999'
    And method DELETE
    When method GET
    Then status 404


