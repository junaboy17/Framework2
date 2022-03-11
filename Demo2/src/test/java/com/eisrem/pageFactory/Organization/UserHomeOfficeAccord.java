package com.eisrem.pageFactory.Organization;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;

public class UserHomeOfficeAccord extends OrganizationNavigator{


	public UserHomeOfficeAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Users Home/Base Office:')]")
	public WebElement UserHomeOfficeAccord;
	
	@FindBy(xpath="//table[@id='loc-picker-table']//tbody//tr[@role='row'][1]")
	public WebElement UserHomeOfficeFirstRow;
	
	@FindBy(xpath="//table[@id='loc-picker-table']//tr[1]//td[1]")
	public WebElement UserHomeOfficeFirstRowID;
	
	@FindBy(xpath="//table[@id='loc-picker-table']//tr[1]//td[2]")
	public WebElement UserHomeOfficeFirstRowLocation;
	
	@FindBy(xpath="//table[@id='loc-picker-table']//tr[1]//td[4]")
	public WebElement UserHomeOfficeFirstRowEndDate;
	
	@FindBy(xpath="//div[@id='loc-picker-table_wrapper']//span[contains(text(),'Add')]")
	public WebElement UserHomeOfficeAddButton;
	
	@FindBy(xpath="//div[@id='loc-picker-table_wrapper']//span[contains(text(),'Edit')]")
	public WebElement UserHomeOfficeEditButton;
	
	@FindBy(xpath="//div[@id='loc-picker-table_wrapper']//span[contains(text(),'Excel')]")
	public WebElement UserHomeOfficeExcelButton;
	
	@FindBy(xpath="//div[@id='loc-picker-table_filter']//input[@type='search']")
	public WebElement UserHomeOfficeSearch;
	
	@FindBy(xpath="//input[@id='loc-enddate']")
	public WebElement UserHomeOfficeEndDateTextBox;
	
	@FindBy(xpath="//input[@id='loc-startdate']")
	public WebElement UserHomeOfficeStartDateTextBox;
	
	@FindBy(xpath="//input[@id='loc-loc-combobox']")
	public WebElement UserHomeOfficeLocationTextBox;
	
	@FindBy(xpath="//*[@id='loc-loc-combobox']/div/div/ul/li")
	public List<WebElement> OrganizationSearchList;
	
	@FindBy(xpath="//div[@class='input-group date ']//div")
	public WebElement UserHomeOfficeStartDateTextBoxTemp;
	
	@FindBy(xpath="//div[@class='datepicker-days']/table/tbody/tr/td[6]")
	public WebElement FirstCalenderBox;
	
	public UserHomeOfficeAccord clickUserHomeOfficeAccord() {
		Source.SeleniumHelper().clickElement(UserHomeOfficeAccord);
		return new UserHomeOfficeAccord(DriverFactory.getDriver());
	}
	
	public UserHomeOfficeAccord setUserHomeOfficeSearch(String value, String... Clear) {
		Source	.SeleniumHelper()
				.setText(UserHomeOfficeSearch, value, Clear);
		return this;
	}
	
	public UserHomeOfficeAccord clickUserHomeOfficeAdd() {
		Source.SeleniumHelper().clickElement(UserHomeOfficeAddButton);
		return new UserHomeOfficeAccord(DriverFactory.getDriver());
	}
	
	public UserHomeOfficeAccord clickUserHomeOfficeEdit() {
		Source.SeleniumHelper().clickElement(UserHomeOfficeEditButton);
		return new UserHomeOfficeAccord(DriverFactory.getDriver());
	}
	
	public UserHomeOfficeAccord clickUserHomeOfficeExcel() {
		Source.SeleniumHelper().clickElement(UserHomeOfficeExcelButton);
		return new UserHomeOfficeAccord(DriverFactory.getDriver());
	}
	
	public UserHomeOfficeAccord clickUserHomeOfficeFirstRow() {
		Source.SeleniumHelper().clickElement(UserHomeOfficeFirstRow);
		return new UserHomeOfficeAccord(DriverFactory.getDriver());
	}
	
	public String readUserHomeOfficeFirstRowID() {
		return Source.SeleniumHelper().getWebElement(UserHomeOfficeFirstRowID).getText();
	}
	
	public String readUserHomeOfficeFirstRowEndDate() {
		return Source.SeleniumHelper().getWebElement(UserHomeOfficeFirstRowEndDate).getText();
	}
	
	public String readUserHomeOfficeFirstRowLocation() {
		return Source.SeleniumHelper().getWebElement(UserHomeOfficeFirstRowLocation).getText();
	}

	public String readUserHomeOfficeEndDateValue() {
		return Source.SeleniumHelper().getWebElement(UserHomeOfficeEndDateTextBox).getAttribute("value");
	}
	
	public UserHomeOfficeAccord setUserHomeOfficeStartDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(UserHomeOfficeStartDateTextBox, date, true, Clear);
		return this;
	}
	
	public UserHomeOfficeAccord setUserHomeOfficeEndDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(UserHomeOfficeEndDateTextBox, date, true, Clear);
		return this;
	}
	
	public UserHomeOfficeAccord setUserHomeOfficeStartDateTEMP() {
		Source.SeleniumHelper().clickElement(UserHomeOfficeStartDateTextBoxTemp).clickElement(FirstCalenderBox);
		return this;
	}
	
	public UserHomeOfficeAccord setUserBaseLocation(String baseloc, String... Clear) {
		Source.SeleniumHelper().setText(UserHomeOfficeLocationTextBox, baseloc, true, Clear);
		return this;
	}
	
	public UserHomeOfficeAccord checkIfBaseLocsFirst() throws Exception {
		List<WebElement> locations = Source.SeleniumHelper().getWebElementList(By.xpath("//*[@id='loc-loc-combobox']/../ul/li"));
		int listSize = locations.size();
		boolean isOtherLoc = false;
		for(int i = 0; i <= listSize - 1; i++) {
			if(locations.get(i).getAttribute("data-value").endsWith("/ BASE")) {
				if(isOtherLoc) throw new Exception("Base Location not in order!");	// if Base location appears after Other location, throw error
			}
			if(!locations.get(i).getAttribute("data-value").endsWith("/ BASE") && !isOtherLoc) {
				isOtherLoc = true;
			}
		}
		return this;
	}
	
	public String isOrgAssociationInDropdown(String comparisonText, String searchTerm)
	{
		return Boolean.toString(Source.SeleniumHelper().isInComboboxBySimilarText(UserHomeOfficeLocationTextBox, OrganizationSearchList, comparisonText, searchTerm));
	}

}
