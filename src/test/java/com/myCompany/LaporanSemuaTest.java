package com.myCompany;

import com.myCompany.pages.Admin.HomePage;
import com.myCompany.pages.Admin.LaporanSemuaPage;
import com.myCompany.pages.Admin.LoginPage;
import com.myCompany.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LaporanSemuaTest {

    private static final Logger log = LoggerFactory.getLogger(LaporanSemuaTest.class);
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static HomePage homePage = new HomePage();
    private static LaporanSemuaPage laporanSemuaPage = new LaporanSemuaPage();

    public LaporanSemuaTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;

    }


    @And("The admin open Laporan Semua menu")
    public void the_admin_open_Laporan_Semua_menu(){
        homePage.goTOLaporanSemua();
        Utils.delay(2);
    }

    @When("The Admin select valid start and end dates")
    public void the_admin_select_valid_start_and_end_Dates(){
        laporanSemuaPage.selectStartDate("18","December","2024");
        laporanSemuaPage.selectEndDate("24","December","2024");
        extentTest.log(LogStatus.PASS,"The Admin select valid start and end dates");
    }

    @And("Clicks The Save Button")
    public void click_The_Save_Button(){
        laporanSemuaPage.clickSavebutton();
        extentTest.log(LogStatus.PASS,"Clicks The Save Button");
    }

    @And("Clicks The Search Button")
    public void clicks_The_Search_Button(){
        laporanSemuaPage.clickSearchbutton();
        extentTest.log(LogStatus.PASS,"Clicks The Search Button");
    }

    @Then("The Data Is Displayed With The Corresponding Date")
    public void the_Data_Is_Displayed_With_The_Corresponding_Date(){
        Assert.assertEquals(laporanSemuaPage.getValidateDates(),true);
        extentTest.log(LogStatus.PASS,"The Data Is Displayed With The Corresponding Date");
    }

    @When("The Admin Inputs a Valid Name in The Search Field")
    public void the_Admin_Inputs_a_Valid_Name_in_The_Search_Field(){
        laporanSemuaPage.setSearchName("budi");
        extentTest.log(LogStatus.PASS,"The Admin Inputs a Valid Name in The Search Field");
    }

    @Then("The Data Is Displayed With The Corresponding Name")
    public void the_Data_Is_Displayed_With_The_Corresponding_Name(){
        Assert.assertEquals(laporanSemuaPage.getValidateNames(),true);
        extentTest.log(LogStatus.PASS,"The Data Is Displayed With The Corresponding Name");
    }

    @When("The Admin Clicks The Filter Icon Button")
    public void the_Admin_Clicks_The_Filter_Icon_Button(){
        laporanSemuaPage.clickFilterIconButton();
        extentTest.log(LogStatus.PASS,"The Admin Clicks The Filter Icon Button");
    }

    @And("Inputs a Valid Department Name")
    public void inputs_Valid_Departement_Name(){
        laporanSemuaPage.setUnitDepartement("IT Programmer");
        extentTest.log(LogStatus.PASS,"Inputs a Valid Department Name");
    }

    @And("Clicks The Terapkan Button")
    public void clicks_The_Terapkan_Button(){
        laporanSemuaPage.clickTerapkanButton();
        extentTest.log(LogStatus.PASS,"Clicks The Terapkan Button");
    }

    @Then("The Data Is Displayed With The Corresponding Department Unit")
    public void the_Data_Is_Displayed_With_The_Corresponding_Department_Unit(){
        Assert.assertEquals(laporanSemuaPage.getValidateUnitDepartement(),true);
        extentTest.log(LogStatus.PASS,"The Data Is Displayed With The Corresponding Department Unit");
    }

    @Then("The data is displayed with the corresponding name and date")
    public void the_data_is_displayed_with_the_corresponding_name_and_date(){
        Assert.assertEquals(laporanSemuaPage.getValidateNames(),true);
        Assert.assertEquals(laporanSemuaPage.getValidateDates(),true);
        extentTest.log(LogStatus.PASS,"The data is displayed with the corresponding name and date");
    }

    @Then("The data is displayed with the corresponding name, date, and department unit")
    public void the_data_is_displayed_with_the_corresponding_name_date_and_department_unit(){
        Assert.assertEquals(laporanSemuaPage.getValidateUnitDepartement(),true);
        Assert.assertEquals(laporanSemuaPage.getValidateNames(),true);
        Assert.assertEquals(laporanSemuaPage.getValidateDates(),true);
        extentTest.log(LogStatus.PASS,"The data is displayed with the corresponding name, date, and department unit");
    }

    @When("The Admin inputs an invalid name in the search field")
    public void the_Admin_inputs_an_invalid_name_in_the_search_field(){
        laporanSemuaPage.setSearchName("Megachan");
        extentTest.log(LogStatus.PASS,"The Admin inputs an invalid name in the search field");
    }

    @Then("No data displayed")
    public void no_data_is_displayed(){
        Assert.assertEquals(laporanSemuaPage.getSumData(),"0-0 of 0");
        extentTest.log(LogStatus.PASS,"No data displayed");
    }

    @When("The Admin select invalid start and end dates")
    public void the_Admin_select_invalid_start_and_end_dates(){
        laporanSemuaPage.selectStartDate("7","December","2024");
        laporanSemuaPage.selectEndDate("8","December","2024");
        extentTest.log(LogStatus.PASS,"The Admin select invalid start and end dates");
    }

    @And("Inputs an invalid department name")
    public void input_an_invalid_departement_name(){
        laporanSemuaPage.setUnitDepartement("SQA-RPA Benhil");
        extentTest.log(LogStatus.PASS,"Inputs an invalid department name");
    }

    @Then("The data display does not change after Click The search Button")
    public void the_data_display_does_not_change_after_Click_The_search_Button(){
        String sumDataBefore = laporanSemuaPage.getSumData();
        laporanSemuaPage.clickSearchbutton();
        String sumDataAfter = laporanSemuaPage.getSumData();
        Assert.assertEquals(sumDataAfter,sumDataBefore);
        extentTest.log(LogStatus.PASS,"The data display does not change after Click The search Button");
    }


    @When("The Admin clicks the Reset button")
    public void the_Admin_clicks_the_Reset_button(){
        laporanSemuaPage.clickResetButton();
        extentTest.log(LogStatus.PASS,"The Admin clicks the Reset button");
    }

    @Then("The name date and department unit filters are cleared")
    public void the_name_date_and_department_unit_filters_are_cleared(){
        Assert.assertEquals(laporanSemuaPage.getValidateNameisEmpty(),true);
        Assert.assertEquals(laporanSemuaPage.getValidateDatesisEmpty(),true);
        Assert.assertEquals(laporanSemuaPage.getValidateFilterisEmpty(),true);
        extentTest.log(LogStatus.PASS,"The name date and department unit filters are cleared");
    }

    @And("Clicks the Batal button")
    public void clicks_the_Batal_button(){
        laporanSemuaPage.clickBatalButton();
        extentTest.log(LogStatus.PASS,"Clicks the Batal button");
    }

    @Then("The filter form is not displayed")
    public void the_filter_form_is_not_displayed(){
        Assert.assertEquals(laporanSemuaPage.getTxtFilterisDisplayed(),false);
        extentTest.log(LogStatus.PASS,"The filter form is not displayed");
    }

    @Given("The Admin is shown a lot of data")
    public void the_Admin_is_shown_a_lot_of_data(){
        laporanSemuaPage.selectStartDate("1","January","2023");
        laporanSemuaPage.selectEndDate("24","December","2024");
        laporanSemuaPage.clickSavebutton();
        laporanSemuaPage.clickSearchbutton();
        extentTest.log(LogStatus.PASS,"The Admin is shown a lot of data");
    }
    @And("The Admin goes to the bottom of the page")
    public void the_Admin_goes_to_the_bottom_of_the_page(){
        laporanSemuaPage.scrollDownPage("1000");
        extentTest.log(LogStatus.PASS,"The Admin goes to the bottom of the page");
    }

    @When("The Admin clicks the next page icon")
    public void the_Admin_clicks_the_next_page_icon(){
        laporanSemuaPage.clickNextPageIcon();
        extentTest.log(LogStatus.PASS,"The Admin clicks the next page icon");
    }

    @Then("The displayed data changes to the next page")
    public void the_displayed_data_changes_to_the_next_page(){
        Assert.assertEquals(laporanSemuaPage.getSumData(),"11-20 of 6989");
        extentTest.log(LogStatus.PASS,"The displayed data changes to the next page");
    }

    @When("The Admin clicks the previous page icon")
    public void the_Admin_clicks_the_prev_page_icon(){
        laporanSemuaPage.clickPrevPageIcon();
        extentTest.log(LogStatus.PASS,"The Admin clicks the previous page icon");
    }

    @Then("The displayed data changes to the previous page")
    public void the_displayed_data_changes_to_the_prev_page(){
        Assert.assertEquals(laporanSemuaPage.getSumData(),"1-10 of 6989");
        extentTest.log(LogStatus.PASS,"The displayed data changes to the previous page");
    }

    @When("The Admin clicks the last page icon")
    public void the_Admin_clicks_the_last_page_icon(){
        laporanSemuaPage.clickLastPageIcon();
        extentTest.log(LogStatus.PASS,"The Admin clicks the last page icon");
    }

    @Then("The displayed data changes to the last page")
    public void the_displayed_data_changes_to_the_last_page(){
        Assert.assertEquals(laporanSemuaPage.getSumData(),"6981-6989 of 6989");
        extentTest.log(LogStatus.PASS,"The displayed data changes to the last page");
    }

    @When("The Admin clicks the first page icon")
    public void the_Admin_clicks_the_first_page_icon(){
        laporanSemuaPage.clickFirstPageIcon();
        extentTest.log(LogStatus.PASS,"The Admin clicks the first page icon");
    }

    @Then("The displayed data changes to the first page")
    public void the_displayed_data_changes_to_the_first_page(){
        Assert.assertEquals(laporanSemuaPage.getSumData(),"1-10 of 6989");
        extentTest.log(LogStatus.PASS,"The displayed data changes to the first page");
    }

    @When("The Admin changes rows per page to 5")
    public void the_Admin_changes_rows_per_page_to_5(){
        laporanSemuaPage.changeRowDatato5();
        extentTest.log(LogStatus.PASS,"The Admin changes rows per page to 5");
    }

    @Then("Rows of data are displayed per page 5")
    public void rows_of_data_are_displayed_per_page_5(){
        Assert.assertEquals(laporanSemuaPage.getSizeRowDisplayed(),5);
        extentTest.log(LogStatus.PASS,"Rows of data are displayed per page 5");
    }

    @When("The Admin changes rows per page to 25")
    public void the_Admin_changes_rows_per_page_to_25(){
        laporanSemuaPage.changeRowDatato25();
        extentTest.log(LogStatus.PASS,"The Admin changes rows per page to 25");
    }

    @Then("Rows of data are displayed per page 25")
    public void rows_of_data_are_displayed_per_page_25(){
        Assert.assertEquals(laporanSemuaPage.getSizeRowDisplayed(),25);
        extentTest.log(LogStatus.PASS,"Rows of data are displayed per page 25");
    }





























}
