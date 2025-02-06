package com.myCompany.drivers;

import com.myCompany.drivers.strategies.DriverStrategy;
import com.myCompany.drivers.strategies.DriverStrategyImplementer;
import com.myCompany.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    private static DriverSingleton instance = null;
    private static WebDriver driver;
    private static DevTools devTools;

    public DriverSingleton(String driver){
        instantiate(driver);
    }

    public WebDriver instantiate(String strategy){
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }


    public static DriverSingleton getInstance(String driver) {
        if(instance == null){
            instance = new DriverSingleton(driver);
        }
        return instance;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void closeObjectInstance(){
        instance = null;
        driver.quit();
    }

    public static DevTools setDevtools(String strategy){
        switch (strategy){
            case Constants.CHROME:
                return devTools = ((ChromeDriver) driver).getDevTools();
            case Constants.FIREFOX:
                return devTools = ((FirefoxDriver) driver).getDevTools();
            default:
                return null;
        }
    }

    public static DevTools getDevToolsStrategy(){
        return devTools;
    }
}
