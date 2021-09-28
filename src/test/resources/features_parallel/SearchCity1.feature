Feature: End to End test for Searching weather by the city name

  @InvalidCase
  Scenario Outline: Expect failed searching weather by invalid city keyword
    Given I launch the Homepage
    When I search the city by "<input_keyword>"
    Then Navigated to the finding result page
    And Verify city not found
    Examples:
      | input_keyword |
      | hanoiii       |