@StateList
Feature: Verify StateList API 
Scenario: Verify User Get StateList  through api
    Given User add headers for to StateList
    When User send "GET" request for StateList endpoint
    Then User should verify the status code is 200
    And User should verify the stateList response message matches "Tamil Nadu" and saved state id
