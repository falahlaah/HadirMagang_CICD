package com.myCompany;

import com.myCompany.drivers.DriverSingleton;
import com.myCompany.utils.Constants;
import com.myCompany.utils.ScenarioTests;
import com.myCompany.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;

import java.io.IOException;

public class Hooks {

    static WebDriver driver;
    static ExtentTest extentTest;
    static DevTools devTools;
    static ExtentReports reports = new ExtentReports("target/extent-report.html");

    @Before
    public void setUp(){
        DriverSingleton.getInstance(Constants.CHROME);
        driver = DriverSingleton.getDriver();
        DriverSingleton.setDevtools(Constants.CHROME);
        devTools = DriverSingleton.getDevToolsStrategy();
        ScenarioTests[] tests = ScenarioTests.values();
        extentTest = reports.startTest(tests[Utils.testCount].getScenarioTestName());
        Utils.testCount++;
    }

    @AfterStep
    public void getResultTest(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            String screenshotPath = Utils.getScreenshot(driver,scenario.getName()
                    .replace(" ","_"));
            extentTest.log(LogStatus.FAIL,scenario.getName()+"\n"
                +extentTest.addScreenCapture(screenshotPath));
        }
    }

    @After
    public void endScenarioTest(){
        reports.endTest(extentTest);
        reports.flush();

    }

    @AfterAll
    public static void finish(){
        Utils.delay(3);
        DriverSingleton.closeObjectInstance();
    }

}
