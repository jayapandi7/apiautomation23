@Login
Feature: Login module API automation

  Scenario: Get user Logtoken from login endpoint
    Given User add header
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User should verify the statuscode is 200
    And User verify the logic response body FirstName present as "Jaya" and get the logtoken saved
