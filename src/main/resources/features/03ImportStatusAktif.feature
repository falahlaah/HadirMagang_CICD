Feature: Import Status Aktif

  Background: The admin has logged in and is on the Import Status Aktif menu menu page
    Given The admin has logged in
    And The admin open Import Status Aktif menu

  Scenario: Successfully import active status with a valid Excel file
    When The admin selects a valid Excel file
    And The admin clicks the Import button
    Then The system should display the message berhasil import excel


  Scenario: Download active status template file
    When The admin clicks on the Download Template button
    Then The system should download the template file successfully

  Scenario: Fail to import active status with an invalid file format
    When The admin selects a file with an invalid format
    And The admin clicks the Import button
    Then The system should display an error message File harus berupa file Excel

  Scenario: Fail to import active status without selecting a file
    When The admin clicks on the Import button without selecting a file
    Then The system should display an error message Please select a file

  Scenario: Fail to import active status with a file that does not match the template
    When The admin selects an invalid file that does not match the template
    And The admin clicks the Import button
    Then The system should display an error message File yang import tidak sesuai dengan template





