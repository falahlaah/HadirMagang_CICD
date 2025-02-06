package com.myCompany.pages.Admin;

import com.myCompany.drivers.DriverSingleton;
import com.myCompany.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".css-6eu2y8")
    private WebElement userProfile;

    @FindBy(css = ".css-uajqx8")
    private WebElement btnLogout;

    @FindBy(xpath = "//p[normalize-space()='Laporan']")
    private WebElement sidemenu_laporan;

    @FindBy(xpath = "//p[normalize-space()='Semua']")
    private WebElement sidemenu_semua;

    @FindBy(xpath = "//p[normalize-space()='Import']")
    private WebElement sidemenu_import;

    @FindBy(xpath = "//p[normalize-space()='Import Status Aktif']")
    private WebElement sidemenu_importStatusAktif;





    public void clickUserProfile(){
        userProfile.click();
    }

    public void clickLogoutbtn(){
        btnLogout.click();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void goTOLaporanSemua(){
        sidemenu_laporan.click();
        Utils.delay(1);
        sidemenu_semua.click();
    }

    public void goTOImportStatusAktif(){
        sidemenu_import.click();
        Utils.delay(1);
        sidemenu_importStatusAktif.click();
    }


}
