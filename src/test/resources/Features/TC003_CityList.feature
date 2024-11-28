@CityList
Feature: Verify CityList API

Scenario: Verify User Get City list  through api
    Given User add header  for to get CityList
    When User add request body state id for  get city list
    And User send "POST" request for CityList endpoint
    Then User should verify the status code is 200
    And User verify the cityList response message matches "Adikaratti" and saved city id
