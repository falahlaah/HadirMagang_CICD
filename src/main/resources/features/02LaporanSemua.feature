Feature: Laporan Semua

  Background: The admin has logged in and is on the Laporan Semua menu page
    Given The admin has logged in
    And The admin open Laporan Semua menu

  Scenario: Display data with select a valid date
    When The Admin select valid start and end dates
    And Clicks The Save Button
    And Clicks The Search Button
    Then The Data Is Displayed With The Corresponding Date

  Scenario: Displays Data With Input a Valid Name
    When The Admin Inputs a Valid Name in The Search Field
    And Clicks The Search Button
    Then The Data Is Displayed With The Corresponding Name

  Scenario: Admin Displays Data With a Valid Department Unit Filter
    When The Admin Clicks The Filter Icon Button
    And Inputs a Valid Department Name
    And Clicks The Terapkan Button
    Then The Data Is Displayed With The Corresponding Department Unit

  Scenario: Displays data with a valid name and date input
    When The Admin Inputs a Valid Name in The Search Field
    And The Admin select valid start and end dates
    And Clicks The Save Button
    And Clicks The Search Button
    Then The data is displayed with the corresponding name and date

  Scenario: Admin displays data with a valid name, date, and department unit filter
    When The Admin Inputs a Valid Name in The Search Field
    And The Admin select valid start and end dates
    And Clicks The Save Button
    And The Admin Clicks The Filter Icon Button
    And Inputs a Valid Department Name
    And Clicks The Terapkan Button
    And Clicks The Search Button
    Then The data is displayed with the corresponding name, date, and department unit

  Scenario: Does not display data with an invalid name
    When The Admin inputs an invalid name in the search field
    And Clicks The Search Button
    Then No data displayed

  Scenario: Does not display data with an invalid date
    When The Admin select invalid start and end dates
    And Clicks The Save Button
    And Clicks The Search Button
    Then No data displayed

  Scenario: Does not display data with an invalid department unit filter
    When The Admin Clicks The Filter Icon Button
    And Inputs an invalid department name
    And Clicks The Terapkan Button
    Then No data displayed

  Scenario: Does not display data with a valid name but an invalid date
    When The Admin Inputs a Valid Name in The Search Field
    And The Admin select invalid start and end dates
    And Clicks The Save Button
    And Clicks The Search Button
    Then No data displayed

  Scenario: Does not display data with a valid name but an invalid department unit filter
    When The Admin Inputs a Valid Name in The Search Field
    And The Admin Clicks The Filter Icon Button
    And Inputs an invalid department name
    And Clicks The Terapkan Button
    And Clicks The Search Button
    Then No data displayed

  Scenario: Does not display data with an invalid name but a valid date
    When The Admin inputs an invalid name in the search field
    And The Admin select valid start and end dates
    And Clicks The Save Button
    And Clicks The Search Button
    Then No data displayed

  Scenario: Does not display data with a valid date but an invalid department unit filter
    When The Admin select valid start and end dates
    And Clicks The Save Button
    And The Admin Clicks The Filter Icon Button
    And Inputs an invalid department name
    And Clicks The Terapkan Button
    And Clicks The Search Button
    Then No data displayed

  Scenario: Does not display data with a valid name and date but an invalid department unit filter
    When The Admin Inputs a Valid Name in The Search Field
    And The Admin select valid start and end dates
    And Clicks The Save Button
    And The Admin Clicks The Filter Icon Button
    And Inputs an invalid department name
    And Clicks The Terapkan Button
    And Clicks The Search Button
    Then No data displayed

  Scenario: The data display does not change when the department name, date, and unit filters are empty
    When The Admin Clicks The Filter Icon Button
    And Clicks The Terapkan Button
    Then The data display does not change after Click The search Button


  Scenario: Admin validates reset search fields
    When The Admin clicks the Reset button
    Then The name date and department unit filters are cleared

  Scenario: Admin validates exiting the filter form
    When The Admin Clicks The Filter Icon Button
    And Clicks the Batal button
    Then The filter form is not displayed


  Scenario: Admin navigates between pages
    Given The Admin is shown a lot of data
    And The Admin goes to the bottom of the page
    When The Admin clicks the next page icon
    Then The displayed data changes to the next page
    When The Admin clicks the previous page icon
    Then The displayed data changes to the previous page
    When The Admin clicks the last page icon
    Then The displayed data changes to the last page
    When The Admin clicks the first page icon
    Then The displayed data changes to the first page


  Scenario: Admin changes rows per page
    Given The Admin is shown a lot of data
    And The Admin goes to the bottom of the page
    When The Admin changes rows per page to 5
    Then Rows of data are displayed per page 5
    When The Admin changes rows per page to 25
    Then Rows of data are displayed per page 25









