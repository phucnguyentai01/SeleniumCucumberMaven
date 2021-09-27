Feature: End to End test for Searching weather by the city name

  @ValidCase
  Scenario Outline: Expect successful searching weather and proper details info in the city link
    Given I launch the Homepage
    When I search the city by "<input_keyword>"
    And Click on the link of "<city_name_find_page>" in the result list
    Then Navigated to the city weather page
    And Verify the current date
    And Verify city name "<city_name_city_page>"
    And Verify forecast chart and day list
    And Verify temperature with fahrenheit/celsius degree format
    Examples:
      | input_keyword | city_name_find_page | city_name_city_page |
      | hanoi         | Ha Noi, VN          | Hanoi, VN           |