package com.myCompany.pages.Admin;

import com.myCompany.drivers.DriverSingleton;
import com.myCompany.utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class LaporanSemuaPage {

    private WebDriver driver;
    private JavascriptExecutor jse;

    public LaporanSemuaPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search")
    private WebElement searchName;

    @FindBy(css = "button[type='submit']")
    private WebElement btn_search;

    @FindBy(xpath = "//p[normalize-space()='Laporan']")
    private WebElement sidemenu_laporan;

    @FindBy(xpath = "//p[normalize-space()='Semua']")
    private WebElement sidemenu_semua;

    @FindBy(xpath = "(//button[@aria-label='toggle password visibility'])[1]")
    private WebElement btn_startDateCal;

    @FindBy(css = "span[class='rdrMonthPicker'] select")
    private WebElement select_Month;

    @FindBy(css = "span[class='rdrYearPicker'] select")
    private WebElement select_Year;

    @FindBy(css = ".rdrDayNumber")
    private List<WebElement> list_day;

    @FindBy(css = ".css-4075ia")
    private WebElement btn_save;

    @FindBy(css = ".css-1gjiym0")
    private WebElement btn_reset;

    @FindBy(css = ".css-1k0lhp1")
    private WebElement btn_filter;

    @FindBy(id = "job_departement")
    private WebElement unitDepartement;

    @FindBy(css = ".css-18ozr2e")
    private WebElement btn_batal;

    @FindBy(xpath = "//button[normalize-space()='Terapkan']")
    private WebElement btn_terapkan;

    @FindBy(xpath = "//td[2]/h6")
    private List<WebElement> list_Nama;

    @FindBy(xpath = "//td[3]/h6")
    private List<WebElement> list_Unit;

    @FindBy(xpath = "//td[4]/h6[1]")
    private List<WebElement> list_Dates;

    @FindBy(css = "input[placeholder='Start Date']")
    private WebElement inputStartDate;

    @FindBy(css = "input[placeholder='End Date']")
    private WebElement inputEndDate;

    @FindBy(css = "button[title='Go to first page']")
    private WebElement firstPageIcon;

    @FindBy(css = "button[title='Go to previous page']")
    private WebElement prevPageIcon;

    @FindBy(css = "button[title='Go to next page']")
    private WebElement nextPageIcon;

    @FindBy(css = "button[title='Go to last page']")
    private WebElement lastPageIcon;

    @FindBy(xpath = "//div[1]/p[2]")
    private WebElement txtSumData;

    @FindBy(id = "mui-1")
    private WebElement txtFilterby;

    @FindBy(css = "div[role='combobox']")
    private WebElement optionRowIcon;

    @FindBy(xpath = "//li[normalize-space()='5']")
    private WebElement optionRow5;

    @FindBy(xpath = "//li[normalize-space()='25']")
    private WebElement optionRow25;

    @FindBy(xpath = "//li[normalize-space()='10']")
    private WebElement optionRow10;


    public void selectStartDate(String date, String month, String year) {
        btn_startDateCal.click();
        selectMonthSearch(month);
        selectYearSearch(year);
        for (WebElement listDay : list_day) {
            if (listDay.getText().equalsIgnoreCase(date)) {
                listDay.click();
                break;
            }
        }
    }

    public void selectEndDate(String date, String month, String year) {
        selectMonthSearch(month);
        selectYearSearch(year);
        for (WebElement listDay : list_day) {
            if (listDay.getText().equalsIgnoreCase(date)) {
                listDay.click();
                break;
            }
        }
    }

    public void selectMonthSearch(String value) {
        Select month = new Select(select_Month);
        month.selectByVisibleText(value);
    }

    public void selectYearSearch(String value) {
        Select year = new Select(select_Year);
        year.selectByValue(value);
    }

    public void clickSavebutton() {
        btn_save.click();
    }

    public void clickSearchbutton() {
        btn_search.click();
        Utils.delay(2);
    }



    public boolean getValidateDates() {
        String startDate = inputStartDate.getAttribute("value");
        if (startDate.contains("Agt")){
            startDate = startDate.replace("Agt","Agu");
        }
        String endDate = inputEndDate.getAttribute("value");
        if (endDate.contains("Agt")){
            endDate = endDate.replace("Agt","Agu");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.forLanguageTag("id-ID"));
        LocalDate awalDate = LocalDate.parse(startDate, formatter);
        LocalDate akhirDate = LocalDate.parse(endDate, formatter);
        if (list_Dates.isEmpty()){
            return false;
        }else {
            for (WebElement dataDates : list_Dates) {
                String ActualdateDisplay = dataDates.getText();
                if (ActualdateDisplay.contains("Agt")){
                    ActualdateDisplay = ActualdateDisplay.replace("Agt","Agu");
                }
                LocalDate dateDisplay = LocalDate.parse(ActualdateDisplay, formatter);
                if (dateDisplay.isBefore(awalDate) || dateDisplay.isAfter(akhirDate)) {
                    return false;
                }
            }
            return true;
        }

    }

    public boolean getValidateNames() {
        Utils.delay(1);
        if (list_Nama.isEmpty()){
            return false;
        }else{
            for (WebElement name : list_Nama) {
                if (!name.getText().contains(searchName.getText())){
                    return false;
                }
            }
            return true;
        }

    }

    public void setSearchName(String name){
        searchName.sendKeys(name);
    }

    public void clickFilterIconButton(){
        btn_filter.click();
        Utils.delay(1);
    }

    public void setUnitDepartement(String departement){
        unitDepartement.sendKeys(departement);
        Utils.delay(1);
        unitDepartement.sendKeys(Keys.DOWN);
        unitDepartement.sendKeys(Keys.ENTER);
    }

    public void clickTerapkanButton(){
        btn_terapkan.click();
        Utils.delay(1);
    }
    public void clickBatalButton(){
       btn_batal.click();
    }

    public boolean getValidateUnitDepartement(){
        clickFilterIconButton();
        String target = unitDepartement.getText();
        btn_batal.click();
        Utils.delay(1);
        if (list_Unit.isEmpty()){
            return false;
        }else{
            for (WebElement unit : list_Unit) {
                if (!unit.getText().contains(target)){
                    return false;
                }
            }
            return true;
        }

    }

    public void clickNextPageIcon(){
        nextPageIcon.click();
        Utils.delay(1);
    }

    public void clickPrevPageIcon(){
        prevPageIcon.click();
        Utils.delay(1);
    }

    public void clickLastPageIcon(){
        lastPageIcon.click();
        Utils.delay(1);
    }

    public void clickFirstPageIcon(){
        firstPageIcon.click();
        Utils.delay(1);
    }

    public String getSumData(){
        return txtSumData.getText();
    }

    public void clickResetButton(){
        btn_reset.click();
    }

    public boolean getValidateNameisEmpty(){
        return searchName.getText().isEmpty();
    }

    public boolean getValidateDatesisEmpty(){
        if (inputStartDate.getText().isEmpty() && inputEndDate.getText().isEmpty()){
            return true;
        }
        return false;
    }

    public boolean getValidateFilterisEmpty(){
        clickFilterIconButton();
        return unitDepartement.getText().isEmpty();
    }

    public boolean getTxtFilterisDisplayed(){
        try {
            return txtFilterby.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void changeRowDatato5(){
        optionRowIcon.click();
        Utils.delay(1);
        optionRow5.click();
        Utils.delay(1);
    }

    public void changeRowDatato25(){
        optionRowIcon.click();
        Utils.delay(1);
        optionRow25.click();
        Utils.delay(1);
    }

    public int getSizeRowDisplayed(){
        return list_Nama.size();
    }

    public void scrollDownPage(String pixel){
        jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy({top: "+pixel+", behavior: 'smooth'})");
        Utils.delay(1);
    }
}



