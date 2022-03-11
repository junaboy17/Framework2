package com.eisrem.pageFactory.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.Classes.RosterPage;
import com.eisrem.pageFactory.CommonPage.IdentifiersPage;
import com.eisrem.pageFactory.CommonPage.RolesAvailableAccord;
import com.eisrem.pageFactory.CommonPage.ServicePopulationsAvailableAccord;

public class UserInfoAccord extends OrganizationNavigator{

	public UserInfoAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'User Info:')]")
	public WebElement UserInfoAccord;
	
	@FindBy(xpath="//a[contains(text(),'Users Home/Base Office:')]")
	public WebElement UserHomeOfficeAccord;
	
	@FindBy(xpath="//a[contains(text(),'Users Access/Associations to Additional Organizati')]")
	public WebElement AdditionalOrgLocAccord;
	
	@FindBy(xpath="//div[@id='SectionsAccordion_RolesAvailable_heading'] | //a[contains(text(),'Roles Available:')]")
	public WebElement RolesAvaiableAccord;
	
	@FindBy(xpath="//a[contains(text(),'Service Population')]")
	public WebElement ServicePopulationsAvailableAccord;
	
	@FindBy(xpath="//a[contains(text(),'Identifiers')]")
	public WebElement IdentifiersAccord;
	
	@FindBy(xpath="//li[@id='user-tab']")
	public WebElement UserTab;
	
	@FindBy(xpath="//label[contains(text(),'User Active')]")
	public WebElement UserActiveTitle;
	
	@FindBy(xpath="//label[contains(text(),'User Active')]/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement UserActiveToggle;
	
	@FindBy(xpath="//label[contains(text(),'User Active')]/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement UserActiveToggleAttribute;
	
	@FindBy(xpath="//input[@id='datepicker_startDate_user']")
	public WebElement UserStartDateTextBox;
	
	@FindBy(xpath="//input[@id='datepicker_endDate_user']")
	public WebElement UserEndDateTextBox;
		
	@FindBy(xpath="//label[@for='loc-loc-combobox']")
	public WebElement UsersHomeOfficeTitle;
	
	@FindBy(xpath="//input[@id='userName']")
	public WebElement UserNameTextBox;
	
	@FindBy(xpath="//input[@id='pwd']")
	public WebElement PasswordTextBox;
	
	@FindBy(xpath="//input[@id='confirmPwd']")
	public WebElement PasswordConfirmationTextBox;
	
	@FindBy(xpath="//input[@id = 'datepicker_passwordResetDate_user']")
	public WebElement DateofLastPWResetTextBox;
	
	@FindBy(xpath="//input[@id='daysSinceLastLogin']")
	public WebElement DaysSinceLastLoginTextBox;
			
	public UserInfoAccord clickUserInfo() {
		Source.SeleniumHelper().clickElement(UserInfoAccord);
		return new UserInfoAccord(DriverFactory.getDriver());
	}
	
	public UserHomeOfficeAccord clickUserHomeOfficeAccord() {
		Source.SeleniumHelper().clickElement(UserHomeOfficeAccord);
		return new UserHomeOfficeAccord(DriverFactory.getDriver());
	}
	
	public String readUserHomeOfficeAccord() {
		return Source.SeleniumHelper().readElement(UserHomeOfficeAccord);
	}
	
	public AdditionalOrgLocAccord clickAdditionalOrgLocationAccord() {
		Source.SeleniumHelper().clickElement(AdditionalOrgLocAccord);
		return new AdditionalOrgLocAccord(DriverFactory.getDriver());
	}
	
	public String readRolesAvailableAccord() {
		return Source.SeleniumHelper().readElement(RolesAvaiableAccord);
	}
	
	public RolesAvailableAccord clickRolesAvaiableAccord() {
		Source.SeleniumHelper().clickElement(RolesAvaiableAccord);
		return new RolesAvailableAccord(DriverFactory.getDriver());
	}
	
	public String readServicePopulationAvailableAccord() {
		return Source.SeleniumHelper().readElement(ServicePopulationsAvailableAccord);
	}
	
	public ServicePopulationsAvailableAccord clickServicePopulationAvailableAccord() {
		Source.SeleniumHelper().clickElement(ServicePopulationsAvailableAccord);
		return new ServicePopulationsAvailableAccord(DriverFactory.getDriver());
	}
	
	public IdentifiersPage clickIdentifiersAccord() {
		Source.SeleniumHelper().clickElement(IdentifiersAccord);
		return new IdentifiersPage(DriverFactory.getDriver());
	}
	
	public UserInfoAccord setUserStartDate(String userStartDate, String... Clear) {
		Source	.SeleniumHelper()
				.setText(UserStartDateTextBox, userStartDate, Clear);
		return this;
	}
	
	public UserInfoAccord setUserEndDate(String userEndDate, String... Clear) {
		Source	.SeleniumHelper()
				.setText(UserEndDateTextBox, userEndDate, Clear);
		return this;
	}
		
	public String isActiveUserTab() {
		return UserTab.getAttribute("class");
	}
	
	public UserInfoAccord setUserName(String name, String... Clear) {
		Source	.SeleniumHelper()
				.setText(UserNameTextBox, name, Clear);
		return this;
	}
	
	public UserInfoAccord setPassword(String password, String... Clear) {
		Source	.SeleniumHelper()
				.setText(PasswordTextBox, password, Clear);
		return this;
	}
	
	public UserInfoAccord setPasswordConfirmation(String pwsdCon, String... Clear) {
		Source	.SeleniumHelper()
				.setText(PasswordConfirmationTextBox, pwsdCon, Clear);
		return this;
	}
	
	public String readDateofLastPasswordReset() {
		return Source.SeleniumHelper().getAttribute(DateofLastPWResetTextBox, "last-val");
	}
	
	public String readDaysSinceLastLogin() {
		return Source.SeleniumHelper().getAttribute(DaysSinceLastLoginTextBox, "last-val");
	}
		
	public String readUserActiveTitle() {
		return Source.SeleniumHelper().readElement(UserActiveTitle);
	}
	
	public UserInfoAccord clickUserActiveToggle() {
		Source.SeleniumHelper().clickElement(UserActiveToggle);
		return this;
	}
	
	public String readUserActiveToggle() {
		return UserActiveToggleAttribute.getAttribute("last-val");
	}
	
	public UserInfoAccord clickUserActiveToggle(String value) {
		String UserActive = readUserActiveToggle();
		
		if(value.equalsIgnoreCase(UserActive)) {
			
		}
		else {
			clickUserActiveToggle();
		}
		return this;
	}
	
	public UserInfoAccord toggleUserActive(boolean active) {
		if((active && UserActiveToggleAttribute.getAttribute("last-val").equals("false"))
				|| (!active && UserActiveToggleAttribute.getAttribute("last-val").equals("true")))
			clickUserActiveToggle();
		return this;
	}
	
}
