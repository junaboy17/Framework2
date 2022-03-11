package com.eisrem.pageFactory.Organization;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class ServicesSpecialtiesPage extends OrganizationNavigator{


	public ServicesSpecialtiesPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//select[@id='servicesspecialties-type']")
	public WebElement ServicesDropDown;
	
	@FindBy(xpath="//select[@id='servicesspecialties-specialties']")
	public WebElement SpecialtiesDropDown;
	
	
	@FindBy(xpath="//button[@aria-labelledby='servicesspecialties-countyId-label']")
	public WebElement CoverageButton;
	
	@FindBy(xpath="//ul[@class='multiselect-container dropdown-menu']//li[1]//input")
	public WebElement CoverageFirstOption;
	
	@FindBy(xpath="//button[contains(text(),'Back To Services/Specialties')]")
	public WebElement BackToServices;
	
	@FindBy(xpath="//input[@id='servicesspecialties-startdate']")
	public WebElement StartDateTextBox;
	
	@FindBy(xpath="//div[@id='servicesspecialties_ServicesSpecialtiesInfo_body_inner']/div[1]/div/div")
	public WebElement StartDateDropDown;
	
	@FindBy(xpath="//tbody/tr/td[1]")
	public WebElement CalenderFirstPosition;

	@FindBy(xpath="//input[contains(@id,'endDate')]")
	public WebElement EndDateTextBox;
	
//	@FindBy(xpath="//input[contains(@type,'checkbox')]")
//	public WebElement coverageCheckbox;
		
	public ServicesSpecialtiesPage selectServices(String value) {
		Source.SeleniumHelper().select(ServicesDropDown, value);
		return this;
	}
	
	public ServicesSpecialtiesPage selectSpecialties(String value) {
		Source.SeleniumHelper().select(SpecialtiesDropDown, value);
		return this;
	}
	
	public ObjectSource clickBackToServices() {
		Source.SeleniumHelper().clickElement(BackToServices);
		return new ObjectSource();
	}
	
	public ServicesSpecialtiesPage chooseFirstCovergeArea() {
		Source.SeleniumHelper().clickElement(CoverageButton);
		Source.SeleniumHelper().clickElement(CoverageFirstOption);
		return this;
	}
	
	public ServicesSpecialtiesPage chooseCovergeArea(String Area) {
		By location = By.xpath("//label[contains(text(), '" + Area + "')]//input");
		Source.SeleniumHelper().clickElement(CoverageButton);
		Source.SeleniumHelper().clickElement(location);
		return this;
	}
	
	public ServicesSpecialtiesPage chooseCovergeArea(int Area) {
		By location = By.xpath("//ul[@class='multiselect-container dropdown-menu']//li[" + Area + "]//input");
		Source.SeleniumHelper().clickElement(CoverageButton);
		Source.SeleniumHelper().clickElement(location);
		return this;
	}
	
	public ServicesSpecialtiesPage setStartDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(StartDateTextBox, date + Keys.TAB, Clear);
		return new ServicesSpecialtiesPage(DriverFactory.getDriver());
	}
	
	public ServicesSpecialtiesPage selectStartDate(String date, String... Clear) {
		Source.SeleniumHelper().clickElement(StartDateDropDown)
								.clickElement(CalenderFirstPosition);
		return new ServicesSpecialtiesPage(DriverFactory.getDriver());
	}
	
	//servicesspecialties-specialties-container
//	@FindBy(xpath="//li[@id='36_Classes_tab']")
//	public WebElement ClassesTab;
//		
//	public String readClassesTab() {
//		return Source.SeleniumHelper().getWebElement(ClassesTab).getText();
//	}
//	
//	public ClassesPage clickClasses() {
//		Source.SeleniumHelper().clickElement(ClassesTab);
//		return new ClassesPage(DriverFactory.getDriver());
//	}
	
	
}
