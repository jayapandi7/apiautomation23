@State
Feature: State module API Automation

  Scenario: Verify User Get StateList through api
    Given User add headers for to StateList
    When User send "GET" request for stateList endpoint
    Then User should verify the statuscode is 200
    And User verify the StateList response message matches "Tamil Nadu" and saved State id
