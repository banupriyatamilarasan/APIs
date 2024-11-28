@Product
Feature: Verify Product Search API

Scenario Outline: Verify User Search product through api
    Given User add headers for search product
    When User add request body for search product "<search_keyword>"
    And User send "POST" request for search product endpoint
    Then User should verify the status code is 200
    And User should verify the search product response message matches "OK" and category id saved
    
Examples:
	|search_keyword|
	|nuts          |

