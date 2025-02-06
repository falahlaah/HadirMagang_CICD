package com.myCompany.pages.Admin;

import com.myCompany.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v130.network.Network;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Optional;

public class LoginPage {

    private WebDriver driver;
    private DevTools devTools;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        this.devTools = DriverSingleton.getDevToolsStrategy();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnMasuk;

    @FindBy(css = ".css-1qamc72")
    private WebElement txtInvalid;

    @FindBy(css = ".css-1yhx7lq")
    private WebElement iconMaskPassword;




    public void loginAdmin(String email, String password){
        this.email.sendKeys(email);
        this.password.sendKeys(password);
    }

    public void enterEmail(String email){
        this.email.sendKeys(email);
    }
    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickBtnMasuk(){
        btnMasuk.click();
    }

    public String getTxtInvalid(){
        return txtInvalid.getText();
    }

    public String getAttributePassword(String atrribute){
        return password.getAttribute(atrribute);
    }

    public void clickMaskPasswordIcon(){
        iconMaskPassword.click();
    }

    public void internetOffline(){
        {
            devTools.createSession();
            // Enable network emulation for offline mode
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
            devTools.send(Network.emulateNetworkConditions(
                    true,0,0,0,Optional.empty()
                    ,Optional.empty(), Optional.empty(), Optional.empty()));
        }
    }


    public  String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void gotoApps(String url){
        driver.get(url);
    }

    public void internetONline(){
        devTools.send(Network.emulateNetworkConditions(
                false,0,0,0,Optional.empty()
                ,Optional.empty(), Optional.empty(), Optional.empty()));
    }
    public String getTxtInvalidWarning(){
        return email.getAttribute("validationMessage");
    }



}
