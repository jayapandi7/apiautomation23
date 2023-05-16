@SearchProduct
Feature: Product module API Automation

  Scenario Outline: Verify search product to the application through api
    Given User add header for to SearchProduct endpoint
    When User add request body for search product "<text>"
    And User send "Post" request for searchProduct endpoint
    Then User should verify the statuscode is 200
    And User should verify the SearchProduct response message matches "OK"

    Examples: 
      | text |
      | nuts |
 