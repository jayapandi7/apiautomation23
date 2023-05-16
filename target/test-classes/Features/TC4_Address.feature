@Address
Feature: Address module API Automation

  @addUserAddress
  Scenario Outline: Verify add user address to the application through api
    Given User add header and bearer authorization for accessing address endpoints
    When User add requestbody for add new address "<First_name>","<last_name>","<mobile>","<apartment>", <state> , <city> , <country> ,"<zipcode>","<address>" and "<address_type>"
    And User send "POST" request for addUserAddress endpoint
    Then User should verify the statuscode is 200
    And User verify the addUserAddress response message matches "Address added successfully"

    Examples: 
      | First_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      | Jaya       | Pandi     | 8760138922 | prince    |    35 | 4324 |     101 |  600081 | Chennai | Home         |

  @updateUserAddress
  Scenario Outline: Verify update user address to the application through api
    Given User add header and bearer authorization for accessing address endpoints
    When User add requestbody for update user address "<address_id>","<First_name>","<last_name>","<mobile>","<apartment>", <state> , <city> , <country> ,"<zipcode>","<address>" and "<address_type>"
    And User send "PUT" request for updateUserAddress endpoint
    Then User should verify the statuscode is 200
    And User verify the updateUserAddress response message matches "Address updated successfully"

    Examples: 
      | address_id | First_name | last_name | mobile     | apartment | state | city | country | zipcode | address | address_type |
      |            | Jaya       | Pandi     | 8760138922 | prince    |    35 | 4324 |     101 |  600081 | Trichy  | Office       |

  @getUserAddress
  Scenario Outline: verify get user address to the application through api
    Given User add header and bearer authorization for accessing address endpoints for get user address
    When User send "GET" request for getUserAddress endpoint
    Then User should verify the statuscode is 200
    And User verify the getUserAddress response message matches "OK"

  @deleteUserAddress
  Scenario Outline: verify delete user address to the application through api
    Given User add header and bearer authorization for accessing address endpoints
    When User add requestbody for delete user address "<address_id>"
    When User send "DELETE" request for deleteUserAddress endpoint
    Then User should verify the statuscode is 200
    And User verify the deleteUseraddress response message matches "Address deleted successfully"

    Examples: 
      | address_id |
      |            |
