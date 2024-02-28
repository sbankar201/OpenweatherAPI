Feature: openwheather

  Scenario: API Automation Testing
    Then Test retrieving the current weather for a specific city
    Then Test retrieving the five day forecast for a specific city
    Then Test the response when querying with an invalid city name
    Then Test the response when querying with an invalid API key