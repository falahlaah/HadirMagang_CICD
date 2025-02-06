package com.myCompany;

import com.myCompany.pages.Admin.HomePage;
import com.myCompany.pages.Admin.LoginPage;
import com.myCompany.utils.Constants;
import com.myCompany.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    private static WebDriver driver;
    private static DevTools devTools;
    private static ExtentTest extentTest;

    private static LoginPage loginPage = new LoginPage();

    private static HomePage homePage = new HomePage();

    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
        devTools = Hooks.devTools;
    }

    @Given("The admin navigates to the admin login page")
    public void the_admin_navigates_to_the_admin_login_page(){
        loginPage.gotoApps(Constants.URL);
        Utils.delay(3);
        extentTest.log(LogStatus.PASS,"The admin navigates to the admin login page");
    }

    @When("The admin enters a valid email and password")
    public void the_admin_enters_a_valid_email_and_password(){
        loginPage.loginAdmin("admin@hadir.com","admin@hadir");
        extentTest.log(LogStatus.PASS,"The admin enters a valid email and password");
    }

    @And("Clicks the masuk button")
    public void clicks_the_masuk_button(){
        loginPage.clickBtnMasuk();
        extentTest.log(LogStatus.PASS,"Clicks the masuk button");
    }

    @Then("The admin is successfully logged in redirected to the admin dashboard")
    public void the_admin_is_successfully_logged_in_redirected_to_the_admin_dashboard(){
        Utils.delay(3);
        Assert.assertEquals(homePage.getCurrentUrl(),"https://magang.dikahadir.com/dashboards/dashboard");
        extentTest.log(LogStatus.PASS,"The admin is successfully logged in redirected to the admin dashboard");

    }

    @When("The admin enters an unregistered email and a valid password")
    public void the_admin_enters_an_unregistered_email_and_a_valid_password(){
        loginPage.loginAdmin("adminbaru@hadir.com","adminbaru@hadir");
        extentTest.log(LogStatus.PASS,"The admin enters an unregistered email and a valid password");

    }

    @Then("The admin sees an error message Akun tidak ditemukan")
    public void the_admin_sees_an_error_message_Akun_tidak_ditemukan(){
        Utils.delay(3);
        Assert.assertEquals(loginPage.getTxtInvalid(),"Akun tidak ditemukan");
        extentTest.log(LogStatus.PASS,"The admin sees an error message Akun tidak ditemukan");

    }

    @When("The admin enters an email without the At symbol and a valid password")
    public void the_admin_enters_an_email_without_the_At_symbol_and_a_valid_password(){
        Utils.delay(3);
        loginPage.loginAdmin("adminhadir.com","admin@hadir");
        extentTest.log(LogStatus.PASS,"The admin enters an email without the At symbol and a valid password");
    }

    @Then("The admin sees an error message Please include the At symbol in the email address")
    public void the_admin_sees_an_error_message_Please_include_the_At_symbol_in_the_email_address(){
        Utils.delay(3);
        Assert.assertEquals(loginPage.getTxtInvalidWarning(),"Please include an '@' in the email address. 'adminhadir.com' is missing an '@'.");
        extentTest.log(LogStatus.PASS,"The admin sees an error message Please include an the At symbol in the email address");

    }

    @When("The admin enters an email with double At symbols and a valid password")
    public void the_admin_enters_an_email_with_double_At_symbols_and_a_valid_password(){
        loginPage.loginAdmin("admin@@hadir.com","admin@hadir");
        extentTest.log(LogStatus.PASS,"The admin enters an email with double At symbols and a valid password");
    }

    @Then("The admin sees an error message A part following the At symbol should not contain the At symbol")
    public void the_admin_sees_an_error_message_A_part_following_the_At_symbol_should_not_contain_the_At_symbol(){
        Utils.delay(3);
        Assert.assertEquals(loginPage.getTxtInvalidWarning(),"A part following '@' should not contain the symbol '@'.");
        extentTest.log(LogStatus.PASS,"The admin sees an error message A part following the At symbol should not contain the At symbol");

    }

    @When("The admin enters an email without a domain and a valid password")
    public void the_admin_enters_an_email_without_a_domain_and_a_valid_password(){
        loginPage.loginAdmin("Admin@hadir","admin@hadir");
        extentTest.log(LogStatus.PASS,"The admin enters an email without a domain and a valid password");
    }

    @When("The admin enters an unactivated email and a valid password")
    public void the_admin_enters_an_unactivated_email_and_a_valid_password(){
        loginPage.loginAdmin("elvayundra9@gmail.com","12345678");
        extentTest.log(LogStatus.PASS,"The admin enters an unactivated email and a valid password");
    }

    @Then("The admin sees an error message Pendaftaran akun belum di aktivasi, mohon menunggu aktivasi akun")
    public void the_admin_sees_an_error_message_Pendaftaran_akun_belum_di_aktivasi_mohon_menunggu_aktivasi_akun(){
        Utils.delay(3);
        Assert.assertEquals(loginPage.getTxtInvalid(),"Pendaftaran akun belum di aktivasi, mohon menunggu aktivasi akun");
        extentTest.log(LogStatus.PASS,"The admin sees an error message Pendaftaran akun belum di aktivasi, mohon menunggu aktivasi akun");

    }

    @When("The admin clicks the masuk button without entering email and password")
    public void the_admin_clicks_the_masuk_button_without_entering_email_and_password(){
        loginPage.clickBtnMasuk();
        extentTest.log(LogStatus.PASS,"The admin clicks the masuk button without entering email and password");
    }

    @When("The admin enters an empty email and a valid password")
    public void the_admin_enters_an_empty_email_and_a_valid_password(){
        loginPage.enterPassword("admin@hadir");
        extentTest.log(LogStatus.PASS,"The admin enters an empty email and a valid password");
    }

    @When("The admin enters a valid email and an empty password")
    public void the_admin_enters_a_valid_email_and_an_empty_password(){
        loginPage.enterEmail("admin@hadir.com");
        extentTest.log(LogStatus.PASS,"The admin enters a valid email and an empty password");
    }

    @Then("The admin sees an error message Email atau password salah")
    public void the_admin_sees_an_error_message_Email_atau_password_salah(){
        Utils.delay(3);
        Assert.assertEquals(loginPage.getTxtInvalid(),"Email atau password salah");
        extentTest.log(LogStatus.PASS,"The admin sees an error message Email atau password salah");

    }

    @When("The admin enters a valid email and an invalid password")
    public void the_admin_enters_a_valid_email_and_an_invalid_password(){
        loginPage.loginAdmin("admin@hadir.com","adminbaru@hadir");
        extentTest.log(LogStatus.PASS,"The admin enters a valid email and an invalid password");
    }

    @When("The admin enters a password in the password field")
    public void the_admin_enters_a_password_in_the_password_field(){
        loginPage.enterPassword("admin@hadir");
        extentTest.log(LogStatus.PASS,"The admin enters a password in the password field");
    }

    @Then("The password is masked by default")
    public void the_password_is_masked_by_default(){
        Utils.delay(3);
        Assert.assertEquals(loginPage.getAttributePassword("type"),"password");
        extentTest.log(LogStatus.PASS,"The password is masked by default");

    }

    @And("Clicks the Mask Password icon")
    public void click_the_Mask_Password_icon(){
        loginPage.clickMaskPasswordIcon();
        extentTest.log(LogStatus.PASS,"Clicks the Mask Password icon");
    }

    @Then("The password is displayed in plain text")
    public void the_password_is_displayed_in_plain_text(){
        Utils.delay(3);
        Assert.assertEquals(loginPage.getAttributePassword("type"),"text");
        extentTest.log(LogStatus.PASS,"The password is displayed in plain text");

    }

    @And("The internet connection is offline")
    public void the_internet_connection_is_offline(){
        loginPage.internetOffline();
        extentTest.log(LogStatus.PASS,"The internet connection is offline");
    }

    @Then("The admin sees an error message Terjadi kesalahan pada server")
    public void the_admin_sees_an_error_message_Terjadi_kesalahan_pada_server(){
        Utils.delay(3);
        Assert.assertEquals(loginPage.getTxtInvalid(),"Terjadi kesalahan pada server");
        extentTest.log(LogStatus.PASS,"The admin sees an error message Terjadi kesalahan pada server");

    }

    @Given("The admin is logged in")
    public void the_admin_is_logged_in(){
        loginPage.internetONline();
        loginPage.gotoApps(Constants.URL);
        loginPage.loginAdmin("admin@hadir.com","admin@hadir");
        loginPage.clickBtnMasuk();
        extentTest.log(LogStatus.PASS,"The admin is logged in");
    }

    @When("The admin clicks the user profile")
    public void the_admin_clicks_the_user_profile(){
        homePage.clickUserProfile();
        extentTest.log(LogStatus.PASS,"The admin clicks the user profile");
    }

    @And("The admin clicks the Logout button")
    public void the_admin_clicks_the_Logout_button(){
        Utils.delay(2);
        homePage.clickLogoutbtn();
        extentTest.log(LogStatus.PASS,"The admin clicks the Logout button");
    }

    @Then("The admin is successful logout redirected to the admin login page")
    public void the_admin_is_successful_logout_redirected_to_the_admin_login_page(){
        Utils.delay(4);
        Assert.assertEquals(loginPage.getCurrentUrl(),"https://magang.dikahadir.com/authentication/login");
        extentTest.log(LogStatus.PASS,"The admin is successful logout redirected to the admin login page");
    }

    //BackGround LaporanSemua ImportStatusAktif
    @Given("The admin has logged in")
    public void the_admin_has_logged_in(){
        loginPage.gotoApps(Constants.URL);
        loginPage.loginAdmin("admin@hadir.com","admin@hadir");
        loginPage.clickBtnMasuk();
        Utils.delay(2);
    }












}
