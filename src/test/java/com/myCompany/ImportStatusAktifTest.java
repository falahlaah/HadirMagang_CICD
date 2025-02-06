package com.myCompany;

import com.myCompany.pages.Admin.HomePage;
import com.myCompany.pages.Admin.ImportStatusAktifPage;
import com.myCompany.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ImportStatusAktifTest {

    private static final Logger log = LoggerFactory.getLogger(ImportStatusAktifTest.class);
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static HomePage homePage = new HomePage();
    private static ImportStatusAktifPage importStatusAktifPage = new ImportStatusAktifPage();
    public ImportStatusAktifTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;

    }


    @And("The admin open Import Status Aktif menu")
    public void the_admin_open_Import_Status_Aktif_menu(){
        homePage.goTOImportStatusAktif();
        Utils.delay(2);
    }


    @When("The admin selects a valid Excel file")
    public void the_admin_selects_a_valid_Excel_file(){
        importStatusAktifPage.setInput_file("C:\\Users\\User\\Downloads\\DATA_STATUS_USER_Edited.xlsx");
        extentTest.log(LogStatus.PASS,"The admin selects a valid Excel file");
    }

    @And("The admin clicks the Import button")
    public void the_admin_clicks_the_Import_button(){
        importStatusAktifPage.clickbtnImport();
        extentTest.log(LogStatus.PASS,"The admin clicks the Import button");
    }

    @Then("The system should display the message berhasil import excel")
    public void the_system_should_display_the_message_berhasil_import_excel(){
        Assert.assertEquals(importStatusAktifPage.getTxTConfirmation(),"Berhasil import excel");
        extentTest.log(LogStatus.PASS,"The system should display the message berhasil import excel");
    }


    @When("The admin clicks on the Download Template button")
    public void the_admin_clicks_on_the_Download_Template_button(){
        importStatusAktifPage.clickbtnDownload();
        extentTest.log(LogStatus.PASS,"The admin clicks on the Download Template button");
    }

    @Then("The system should download the template file successfully")
    public void the_system_should_download_the_template_file_successfully(){
        Assert.assertEquals(importStatusAktifPage.getValidateisDownloaded("C:\\Users\\User\\Downloads","DATA_STATUS_USER.xlsx"),true);
        extentTest.log(LogStatus.PASS,"The system should download the template file successfully");
    }


    @When("The admin selects a file with an invalid format")
    public void the_admin_selects_an_invalid_file_format(){
        importStatusAktifPage.setInput_file("C:\\Users\\User\\Downloads\\DATA_STATUS_USER.docx");
        extentTest.log(LogStatus.PASS,"The admin selects a file with an invalid format");
    }

    @Then("The system should display an error message File harus berupa file Excel")
    public void the_system_should_display_an_error_message_File_harus_berupa_file_Excel_xls_atau_xlsx(){
        Assert.assertEquals(importStatusAktifPage.getTxTInvalid(),"*File harus berupa file Excel (.xls atau .xlsx)");
        extentTest.log(LogStatus.PASS,"The system should display an error message File harus berupa file Excel");
    }

    @When("The admin clicks on the Import button without selecting a file")
    public void the_admin_clicks_on_the_Import_button_without_selecting_a_file(){
        importStatusAktifPage.clickbtnImport();
        extentTest.log(LogStatus.PASS,"The admin clicks on the Import button without selecting a file");
    }

    @Then("The system should display an error message Please select a file")
    public void the_system_should_display_an_error_message_Please_select_a_file(){
        Assert.assertEquals(importStatusAktifPage.getTxTInvalidWarning(),"Please select a file.");
        extentTest.log(LogStatus.PASS,"The system should display an error message Please select a file");
    }

    @When("The admin selects an invalid file that does not match the template")
    public void the_admin_select_an_invalid_file_that_does_not_match_the_template(){
        importStatusAktifPage.setInput_file("C:\\Users\\User\\Downloads\\DATA_STATUS_USER2.xlsx");
        extentTest.log(LogStatus.PASS,"The admin selects an invalid file that does not match the template");
    }

    @Then("The system should display an error message File yang import tidak sesuai dengan template")
    public void the_system_should_display_an_error_message_File_yang_import_tidak_sesuai_dengan_template(){
        Assert.assertEquals(importStatusAktifPage.getTxTConfirmation(),"File yang import tidak sesuai dengan template");
        extentTest.log(LogStatus.PASS,"The system should display an error message File yang import tidak sesuai dengan template");
    }






































}
