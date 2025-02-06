Feature: Login and Logout Admin


  Scenario: Successful login with valid email and password
    Given The admin navigates to the admin login page
    When The admin enters a valid email and password
    And Clicks the masuk button
    Then The admin is successfully logged in redirected to the admin dashboard

  Scenario: Login fails with unregistered email
    Given The admin navigates to the admin login page
    When The admin enters an unregistered email and a valid password
    And Clicks the masuk button
    Then The admin sees an error message Akun tidak ditemukan

  Scenario: Login fails with email missing the "@" symbol
    Given The admin navigates to the admin login page
    When The admin enters an email without the At symbol and a valid password
    And Clicks the masuk button
    Then The admin sees an error message Please include the At symbol in the email address

  Scenario: Login fails with email containing double "@" symbols
    Given The admin navigates to the admin login page
    When The admin enters an email with double At symbols and a valid password
    And Clicks the masuk button
    Then The admin sees an error message A part following the At symbol should not contain the At symbol

  Scenario: Login fails with email missing domain extensions
    Given The admin navigates to the admin login page
    When The admin enters an email without a domain and a valid password
    And Clicks the masuk button
    Then The admin sees an error message Akun tidak ditemukan

  Scenario: Login fails with an email that is not activated
    Given The admin navigates to the admin login page
    When The admin enters an unactivated email and a valid password
    And Clicks the masuk button
    Then The admin sees an error message Pendaftaran akun belum di aktivasi, mohon menunggu aktivasi akun

  Scenario: Login fails without entering email and password
    Given The admin navigates to the admin login page
    When The admin clicks the masuk button without entering email and password
    Then The admin sees an error message Akun tidak ditemukan

  Scenario: Login fails with empty email
    Given The admin navigates to the admin login page
    When The admin enters an empty email and a valid password
    And Clicks the masuk button
    Then The admin sees an error message Akun tidak ditemukan

  Scenario: Login fails with empty password
    Given The admin navigates to the admin login page
    When The admin enters a valid email and an empty password
    And Clicks the masuk button
    Then The admin sees an error message Email atau password salah

  Scenario: Login fails with invalid password
    Given The admin navigates to the admin login page
    When The admin enters a valid email and an invalid password
    And Clicks the masuk button
    Then The admin sees an error message Email atau password salah

  Scenario: Verify password masking while entering the password
    Given The admin navigates to the admin login page
    When The admin enters a password in the password field
    Then The password is masked by default

  Scenario: Verify disabling password masking
    Given The admin navigates to the admin login page
    When The admin enters a password in the password field
    And Clicks the Mask Password icon
    Then The password is displayed in plain text

  Scenario: Login fails when internet is offline
    Given The admin navigates to the admin login page
    When The admin enters a valid email and password
    And The internet connection is offline
    And Clicks the masuk button
    Then The admin sees an error message Terjadi kesalahan pada server

  Scenario: Verify successful logout
    Given The admin is logged in
    When The admin clicks the user profile
    And The admin clicks the Logout button
    Then The admin is successful logout redirected to the admin login page









