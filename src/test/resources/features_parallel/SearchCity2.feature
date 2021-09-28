Feature: End to End test for Searching weather by the city name

  @ValidCase
  Scenario Outline: Expect successful searching weather by valid city keyword
    Given I launch the Homepage
    When I search the city by "<input_keyword>"
    Then Navigated to the finding result page
    And Verify the city name "<city_name_find_page>" and temperature
    Examples:
      | input_keyword | city_name_find_page |  |
      | hanoi         | Ha Noi, VN          |  |