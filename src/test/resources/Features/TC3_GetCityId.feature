@City
Feature: City module API Automation

  Scenario: Verify User Get CityList through api
    Given User add headers for to CityList
    When User add Request body for CityList to get StateId 
    When User send "POST" request for CityList endpoint
    Then User should verify the statuscode is 200
    And User verify the CityList response message matches "Yercaud" and saved City id
