package com.myCompany.pages.Admin;

import com.myCompany.drivers.DriverSingleton;
import com.myCompany.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class ImportStatusAktifPage {

    private WebDriver driver;

    public ImportStatusAktifPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".css-5lyhfd")
    private WebElement btn_Import;

    @FindBy(css = ".css-yebgwc")
    private WebElement btn_download;

    @FindBy(id = "selfie")
    private WebElement input_file;

    @FindBy(id = "selfie-helper-text")
    private WebElement txt_invalid;

    @FindBy(css = ".css-1w0ym84")
    private WebElement txt_confirmation;


    public void clickbtnImport(){
        btn_Import.click();
        Utils.delay(1);
    }

    public void clickbtnDownload(){
        btn_download.click();
    }

    public String getTxTInvalid(){
        Utils.delay(2);
        return txt_invalid.getText();
    }

    public String getTxTConfirmation(){
        Utils.delay(2);
        return txt_confirmation.getText();
    }

    public void setInput_file(String pathfile){
        input_file.sendKeys(pathfile);
    }

    public Boolean getValidateisDownloaded(String pathfile, String fileName) {
        Utils.delay(2);
        File f = new File(pathfile+"\\"+fileName);
        return f.exists();
    }

    public String getTxTInvalidWarning(){
        Utils.delay(2);
        return input_file.getAttribute("validationMessage");
    }












}
