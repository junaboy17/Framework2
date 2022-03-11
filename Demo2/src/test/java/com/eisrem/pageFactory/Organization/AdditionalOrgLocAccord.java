package com.eisrem.pageFactory.Organization;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.Agreement.AgreementPage;

public class AdditionalOrgLocAccord extends OrganizationNavigator{


	public AdditionalOrgLocAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Users Access/Associations to Additional Organizati')]")
	public WebElement AdditionalOrgLocAccord;
	
	@FindBy(xpath="//table[@id='addtnl-loc-picker-table']//tbody//tr[@role='row'][1]")
	public WebElement AdditionalOrgLocFirstRow;
	
	@FindBy(xpath="//table[@id='addtnl-loc-picker-table']//tr[1]//td[1]")
	public WebElement AdditionalOrgLocFirstRowID;
	
	@FindBy(xpath="//table[@id='addtnl-loc-picker-table']//tr[1]//td[2]")
	public WebElement AdditionalOrgLocFirstRowLocation;
	
	@FindBy(xpath="//table[@id='addtnl-loc-picker-table']//tr[1]//td[4]")
	public WebElement AdditionalOrgLocFirstRowEndDate;
	
	@FindBy(xpath="//div[@id='addtnl-loc-picker-table_wrapper']//span[contains(text(),'Add')]")
	public WebElement AdditionalOrgLocAddButton;
	
	@FindBy(xpath="//div[@id='addtnl-loc-picker-table_wrapper']//span[contains(text(),'Edit')]")
	public WebElement AdditionalOrgLocEditButton;
	
	@FindBy(xpath="//div[@id='addtnl-loc-picker-table_wrapper']//span[contains(text(),'Excel')]")
	public WebElement AdditionalOrgLocExcelButton;
		
	@FindBy(xpath="//div[@id='addtnl-loc-picker-table_filter']//input[@type='search']")
	public WebElement AdditionalOrgLocSearch;
	
	@FindBy(xpath="//input[@id='addtnl-loc-enddate']")
	public WebElement AdditionalOrgLocEndDateTextBox;
	
	@FindBy(xpath="//select[@id='sp']")
	public WebElement AdditionalOrgLocServicePopulationDropDown;
	
	@FindBy(xpath="//input[@id='addtnl-loc-org-combobox']")
	public WebElement AdditionalOrgLocOrganizaitonTextBox;
	
	@FindBy(xpath="//button[@class='multiselect dropdown-toggle btn btn-default']")
	public WebElement AdditionalOrgLocLocationsBtn;
	
	@FindBy(xpath="//ul[@class='multiselect-container dropdown-menu']//li[2]//input")
	public WebElement AdditionalOrgLocLocationsOption2;

	
	
	@FindBy(xpath="//button[contains(text(),'Back To User/Staff')]")
	public WebElement BackToUserStaffBtn;
	
	
	public AdditionalOrgLocAccord clickAdditionalOrgLocationAccord() {
		Source.SeleniumHelper().clickElement(AdditionalOrgLocAccord);
		return new AdditionalOrgLocAccord(DriverFactory.getDriver());
	}
	
	public AdditionalOrgLocAccord setAdditionalOrgLocSearch(String value, String... Clear) {
		Source	.SeleniumHelper()
				.setText(AdditionalOrgLocSearch, value, Clear);
		return this;
	}
	
	public AdditionalOrgLocAccord clickAdditionalOrgLocAdd() {
		Source.SeleniumHelper().clickElement(AdditionalOrgLocAddButton);
		return new AdditionalOrgLocAccord(DriverFactory.getDriver());
	}
	
	public AdditionalOrgLocAccord clickAdditionalOrgLocEdit() {
		Source.SeleniumHelper().clickElement(AdditionalOrgLocEditButton);
		return new AdditionalOrgLocAccord(DriverFactory.getDriver());
	}
	
	public AdditionalOrgLocAccord clickAdditionalOrgLocExcel() {
		Source.SeleniumHelper().clickElement(AdditionalOrgLocExcelButton);
		return new AdditionalOrgLocAccord(DriverFactory.getDriver());
	}
	
	public AdditionalOrgLocAccord clickAdditionalOrgLocFirstRow() {
		Source.SeleniumHelper().clickElement(AdditionalOrgLocFirstRow);
		return new AdditionalOrgLocAccord(DriverFactory.getDriver());
	}
	
	public String readAdditionalOrgLocFirstRowID() {
		return Source.SeleniumHelper().readElement(AdditionalOrgLocFirstRowID);
	}
	
	public String readAdditionalOrgLocFirstRowEndDate() {
		return Source.SeleniumHelper().readElement(AdditionalOrgLocFirstRowEndDate);
	}
	
	public String readAdditionalOrgLocFirstRowLocation() {
		return Source.SeleniumHelper().readElement(AdditionalOrgLocFirstRowLocation);
	}

	public String readAdditionalOrgLocEndDateValue() {
		return Source.SeleniumHelper().getWebElement(AdditionalOrgLocEndDateTextBox).getAttribute("value");
	}
	
	public AdditionalOrgLocAccord setAdditionalOrgLocEndDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(AdditionalOrgLocEndDateTextBox, date + Keys.TAB, Clear);
		return this;
	}
	
	public AdditionalOrgLocAccord selectAdditionalOrgLocServicePopulation(int index) {
		Source.SeleniumHelper().select(AdditionalOrgLocServicePopulationDropDown, index);
		return this;
	}
	
	public AdditionalOrgLocAccord setAdditionalOrgLocOrganizaiton(String Organization, String... Clear) {
		Source.SeleniumHelper().setText(AdditionalOrgLocOrganizaitonTextBox, Organization, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public AdditionalOrgLocAccord chooseFirstAdditionalOrgLocLocations() {
		Source.SeleniumHelper().clickElement(AdditionalOrgLocLocationsBtn);
		Source.SeleniumHelper().clickElement(AdditionalOrgLocLocationsOption2);
		return this;
	}
	
	public AdditionalOrgLocAccord chooseAdditionalOrgLocLocations(String Location) {
		By location = By.xpath("//label[contains(text(), '" + Location + "')]//input");
		Source.SeleniumHelper().clickElement(AdditionalOrgLocLocationsBtn);
		Source.SeleniumHelper().clickElement(location);
		return this;
	}
	
	public AdditionalOrgLocAccord clickBackToUserStaff() {
		Source.SeleniumHelper().clickElement(BackToUserStaffBtn);
		return new AdditionalOrgLocAccord(DriverFactory.getDriver());
	}
	
	public AdditionalOrgLocAccord checkIfBaseLocsFirst() throws Exception {
		List<WebElement> locations= Source.SeleniumHelper().getWebElementList(By.xpath("//*[@id='addtnl-loc-picker-pane']/div[1]/div[6]/span/div/ul/li/a/label"));
		int listSize = locations.size();
		boolean isOtherLoc = false;
		// skipping element 0 as it is "Select All" option not a location
		for(int i = 1; i <= listSize - 1; i++) {			
			if(locations.get(i).getAttribute("innerText").endsWith("/ BASE")) {
				if(isOtherLoc) throw new Exception("Base Location not in order!");	// if Base location appears after Other location, throw error
			}
			else if (!locations.get(i).getAttribute("innerText").endsWith("/ BASE") && !isOtherLoc) {
				isOtherLoc = true;
			}
		}
		return this;
	}

	@SuppressWarnings("unchecked")
	public boolean verifyLocations() throws ParseException {
		Map<String, Object> locCache = (Map<String, Object>) Source.SeleniumHelper().runJavascriptWithReturn("return locCache");
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
		for(Entry<String, Object> loc : locCache.entrySet())
		{
			Date startDate = null;
			Date endDate = null;
			String enabled = null;
			Map<String, Object> locValues =  (Map<String, Object>) loc.getValue();
		    startDate = locValues.get("startDate") != null ? sdf.parse(locValues.get("startDate").toString()) : null;
			endDate = locValues.get("endDate") != null ? sdf.parse(locValues.get("endDate").toString()) : null;
			enabled = locValues.get("enabled") != null ? locValues.get("endDate").toString() : null;
			
			if (enabled == null || startDate == null || startDate.after(today) || endDate.before(today) || !enabled.equals("Y") )
				return true;
		}
		return false;
	}
	
}
