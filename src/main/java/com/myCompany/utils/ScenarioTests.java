package com.myCompany.utils;

public enum ScenarioTests {

    // T1 - T14
    // feature login logout
    T1("Successful login with valid email and password"),
    T2("Login fails with unregistered email"),
    T3("Login fails with email missing the '@' symbol"),
    T4("Login fails with email containing double '@' symbols"),
    T5("Login fails with email missing domain extensions"),
    T6("Login fails with an email that is not activated"),
    T7("Login fails without entering email and password"),
    T8("Login fails with empty email"),
    T9("Login fails with empty password"),
    T10("Login fails with invalid password"),
    T11("Verify password masking while entering the password"),
    T12("Verify disabling password masking"),
    T13("Login fails when internet is offline"),
    T14("Verify successful logout"),


    // T15 - T32
    // feature Laporan Semua
    T15("Display data with select a valid date"),
    T16("Displays Data With Input a Valid Name"),
    T17("Admin Displays Data With a Valid Department Unit Filter"),
    T18("Displays data with a valid name and date input"),
    T19("Admin displays data with a valid name, date, and department unit filter"),
    T20("Does not display data with an invalid name"),
    T21("Does not display data with an invalid date"),
    T22("Does not display data with an invalid department unit filter"),
    T23("Does not display data with a valid name but an invalid date"),
    T24("Does not display data with a valid name but an invalid department unit filter"),
    T25("Does not display data with an invalid name but a valid date"),
    T26("Does not display data with a valid date but an invalid department unit filter"),
    T27("Does not display data with a valid name and date but an invalid department unit filter"),
    T28("The data display does not change when the department name, date, and unit filters are empty"),
    T29("Admin validates reset search fields"),
    T30("Admin validates exiting the filter form"),
    T31("Admin navigates between pages"),
    T32("Admin changes rows per page"),


    // T33 - T37
    // feature Import Status Aktif

    T33("Successfully import active status with a valid Excel file"),
    T34("Download active status template file"),
    T35("Fail to import active status with an invalid file format"),
    T36("Fail to import active status without selecting a file"),
    T37("Fail to import active status with a file that does not match the template");


    private String scenarioTestName;

    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }

}
