package com.eisrem.pageFactory.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.Pagefactory;

public class LocationsPage extends OrganizationNavigator{


	public LocationsPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='locName']")
	public WebElement NameTextBox;
	
	@FindBy(xpath="//select[@id='type']")
	public WebElement TypeDropDown;
	
	@FindBy(xpath="//input[@id='faxNumber']")
	public WebElement FaxTextBox;
	
	@FindBy(xpath="//input[@id='ttyNumber']")
	public WebElement TTYTextBox;
	
	@FindBy(xpath="//input[@id='phoneNumber']")
	public WebElement PhoneTextBox;
	
	@FindBy(xpath="//label[contains(text(),'State Users?')]")
	public WebElement AddLocStateUserToggleTitle;
	
	@FindBy(xpath="//div[contains(@class,'switch-id-autoAddtnlLocFlag')]")
	public WebElement AddLocStateUserToggle;
	
	@FindBy(xpath="//div[contains(@class,'switch-id-autoAddtnlLocFlag')]//input")
	public WebElement AddLocStateUserToggleAttribute;
	
	@FindBy(xpath="//label[contains(text(),'Provider Users?')]")
	public WebElement AddLocProviderUserToggleTitle;
	
	@FindBy(xpath="//div[contains(@class,'switch-id-autoAddtnlLocOrgFlag')]")
	public WebElement AddLocProviderUserToggle;
	
	@FindBy(xpath="//div[contains(@class,'switch-id-autoAddtnlLocOrgFlag')]//input")
	public WebElement AddLocProviderUserToggleAttribute;
	
	@FindBy(xpath="//input[@id='activeFlag']")
	public WebElement ActiveFlag;
	
	@FindBy(xpath="//input[@id='autoAddtnlLocFlag']")
	public WebElement AutoAddtnlLocFlag;
	
	@FindBy(xpath="//input[@id='autoAddtnlLocOrgFlag']")
	public WebElement AutoAddtnlLocOrgFlag;
	
	@FindBy(xpath="//label[@for='locName']")
	public WebElement NameTitle;
	
	@FindBy(xpath="//label[@for='locName']")
	public WebElement TitleTitle;
	
	@FindBy(xpath="//label[@for='type']")
	public WebElement TypeTitle;
	
	@FindBy(xpath="//label[@for='telNum']")
	public WebElement PhoneTitle;
	
	@FindBy(xpath="//label[@for='faxNum']")
	public WebElement FaxTitle;
	
	@FindBy(xpath="//label[@for='ttyNum']")
	public WebElement TTYTitle;
	
	public LocationsPage setName(String name, String... Clear) {
		Source.SeleniumHelper().setText(NameTextBox, name, Clear);
		return this;
	}
	
	public String readNameTitle() {
		return Source.SeleniumHelper().readElement(NameTitle);
	}
	
	public LocationsPage selectType(int index) {
		Source.SeleniumHelper().select(TypeDropDown, index);
		return this;
	}
	
	public LocationsPage selectType(String name) {
		Source.SeleniumHelper().select(TypeDropDown, name);
		return this;
	}
	
	public String readTypeTitle() {
		return Source.SeleniumHelper().readElement(TypeTitle);
	}
	
	public LocationsPage setPhone(String phone, String... Clear) {
		Source.SeleniumHelper().setText(PhoneTextBox, phone, Clear);
		return this;
	}
	
	public String readPhoneTitle() {
		return Source.SeleniumHelper().readElement(PhoneTitle);
	}
	
	public LocationsPage setFaxText(String fax, String... Clear) {
		Source.SeleniumHelper().setText(FaxTextBox, fax, Clear);
		return this;
	}
	
	public String readFaxTitle() {
		return Source.SeleniumHelper().readElement(FaxTitle);
	}
	
	public LocationsPage setTTY(String tty, String... Clear) {
		Source.SeleniumHelper().setText(TTYTextBox, tty, Clear);
		return this;
	}
	
	public String readTTYTitle() {
		return Source.SeleniumHelper().readElement(TTYTitle);
	}
	
	public String readAddLocStateUserToggleTitle() {
		return Source.SeleniumHelper().readElement(AddLocStateUserToggleTitle);
	}
	
	public LocationsPage clickAddLocStateUserToggle() {
		Source.SeleniumHelper().clickElement(AddLocStateUserToggle);
		return this;
	}
	
	public LocationsPage clickAddLocStateUserToggle(String value) {
		String active = readAddLocStateUserToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickAddLocStateUserToggle();
		}
		return this;
	}
	
	public String readAddLocStateUserToggle() {
		return AddLocStateUserToggleAttribute.getAttribute("last-val");
	}
	

	public String readAddLocProviderUserToggleTitle() {
		return Source.SeleniumHelper().readElement(AddLocProviderUserToggleTitle);
	}
	
	public LocationsPage clickAddLocProviderUserToggle() {
		Source.SeleniumHelper().clickElement(AddLocProviderUserToggle);
		return this;
	}
	
	public LocationsPage clickAddLocProviderUserToggle(String value) {
		String active = readAddLocProviderUserToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickAddLocProviderUserToggle();
		}
		return this;
	}
	
	public String readAddLocProviderUserToggle() {
		return AddLocProviderUserToggleAttribute.getAttribute("last-val");
	}
	
	public LocationsPage toggleActive(boolean active) {
		if((active && ActiveFlag.getAttribute("last-val").equals("false"))
				|| (!active && ActiveFlag.getAttribute("last-val").equals("true")))
			clickActiveToggle();
		return this;
	}
	
	public LocationsPage toggleStateUser(boolean stateUser) {
		if((stateUser && AutoAddtnlLocFlag.getAttribute("last-val").equals("false"))
				|| (!stateUser && AutoAddtnlLocFlag.getAttribute("last-val").equals("true")))
			clickAddLocStateUserToggle();
		return this;
	}
	
	public LocationsPage toggleProviderUser(boolean providerUser) {
		if((providerUser && AutoAddtnlLocOrgFlag.getAttribute("last-val").equals("false"))
				|| (!providerUser && AutoAddtnlLocOrgFlag.getAttribute("last-val").equals("true")))
			clickAddLocProviderUserToggle();
		return this;
	}
	
	public LocationsPage addCompleteLocationAndSubmit(String orgSearchTerm, String name, LocationType type, String startDate, String endDate, 
			 String phone, String fax, String tty, String description, Boolean active, Boolean stateUser, Boolean providerUser, String servicePop,
			 String servicePopStartDate, String servicePopEndDate, String servicePopDescrription)
	{
		Source.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationName : orgSearchTerm).clickFirstRow().clickAnchor().OrganizationNavigator().clickLocations().clickAdd();
		
		Source		.LocationsPage()
					.setName(name == null ? LocationName : name, EmptyString)
					.selectType(type == null ? LocationType.OTHER_LOCATION.getName() : type.getName())
					.setStartDate(startDate == null ? Today : startDate, EmptyString)
					.setEndDate(endDate == null ? EmptyString : endDate, EmptyString)
					.setDescription(description == null ? Description : description, EmptyString)
					.GetSource()
					.LocationsPage()
					.setPhone(phone == null ? PhoneNumber : phone, EmptyString)
					.setFaxText(fax == null ? PhoneNumber : fax, EmptyString)
					.setTTY(tty == null ? PhoneNumber : tty, EmptyString);
					
		toggleActive(active);
		toggleStateUser(stateUser);
		toggleProviderUser(providerUser);
					
		Source.ServicePopulationsAvailableAccord().addServicePopulation(servicePopStartDate, servicePopEndDate, servicePop, servicePopDescrription);
		
		Source		.LocationsPage()
					.clickSubmit()
					.clickPopupOk()
					.OrganizationNavigator()
					.clickLocations();
		
		return this;
	}
	
	public String addCompleteLocationSubmitAndReturnId(String orgSearchTerm, String name, LocationType type, String startDate, String endDate, 
			 String phone, String fax, String tty, String description, Boolean active, Boolean stateUser, Boolean providerUser, ServicePopulations servicePop,
			 String servicePopStartDate, String servicePopEndDate, String servicePopDescrription)
	{
		Source.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationName : orgSearchTerm).clickFirstRow().clickAnchor().OrganizationNavigator().clickLocations().clickAdd();
		
		Source		.LocationsPage()
					.setName(name == null ? LocationName : name, EmptyString)
					.selectType(type == null ? LocationType.OTHER_LOCATION.getName() : type.getName())
					.setStartDate(startDate == null ? Today : startDate, EmptyString)
					.setEndDate(endDate == null ? EmptyString : endDate, EmptyString)
					.setDescription(description == null ? Description : description, EmptyString)
					.GetSource()
					.LocationsPage()
					.setPhone(phone == null ? PhoneNumber : phone, EmptyString)
					.setFaxText(fax == null ? PhoneNumber : fax, EmptyString)
					.setTTY(tty == null ? PhoneNumber : tty, EmptyString);
					
		toggleActive(active);
		toggleStateUser(stateUser);
		toggleProviderUser(providerUser);
					
		Source.ServicePopulationsAvailableAccord().addServicePopulation(servicePopStartDate, servicePopEndDate, servicePop.getName(), servicePopDescrription);
		
		Source		.LocationsPage()
					.clickSubmit()
					.clickPopupOk()
					.OrganizationNavigator()
					.clickLocations();
		
		return Source.DataTable().readFirstResultID().replaceAll("[^0-9]", EmptyString);
	}
	
	public LocationsPage addCompleteLocationAndSubmit(String orgSearchTerm)
	{
		Source.NavigationMenuBar()
			.clickOrganization()
			.setSearch(orgSearchTerm == null ? OrganizationName : orgSearchTerm)
			.clickFirstRow()
			.clickAnchor()
			.OrganizationNavigator().clickLocations().clickAdd();
		
		Source		.LocationsPage()
					.setName(LocationName)
					.selectType(LocationType.OTHER_LOCATION.getName())
					.setDescription(Description, EmptyString)
					.GetSource()
					.LocationsPage()
					.setPhone(PhoneNumber, EmptyString)
					.setFaxText(PhoneNumber, EmptyString)
					.setTTY(PhoneNumber, EmptyString);
					
		Source.ServicePopulationsAvailableAccord().addServicePopulation();
		
		Source		.LocationsPage()
					.clickSubmit()
					.clickPopupOk()
					.OrganizationNavigator()
					.clickLocations();
		
		return this;
	}
	
	public String addCompleteLocationSubmitAndReturnId(String orgSearchTerm)
	{
		Source.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationName : orgSearchTerm).clickFirstRow().clickAnchor().OrganizationNavigator().clickLocations().clickAdd();
		
		Source		.LocationsPage()
					.setName(LocationName)
					.selectType(LocationType.OTHER_LOCATION.getName())
					.setDescription(Description, EmptyString)
					.GetSource()
					.LocationsPage()
					.setPhone(PhoneNumber, EmptyString)
					.setFaxText(PhoneNumber, EmptyString)
					.setTTY(PhoneNumber, EmptyString);
					
		Source.ServicePopulationsAvailableAccord().addServicePopulation();
		
		Source		.LocationsPage()
					.clickSubmit()
					.clickPopupOk()
					.OrganizationNavigator()
					.clickLocations();
		
		return Source.DataTable().readFirstResultID().replaceAll("[^0-9]", EmptyString);
	}
	
	public LocationsPage endDateLocation(String orgSearchTerm, String locSearchTerm)
	{
		Source			.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationName : orgSearchTerm).clickFirstRow().clickAnchor();
		Source			.OrganizationNavigator().clickLocations().setSearch(locSearchTerm == null ? OrganizationName : locSearchTerm).clickFirstRow().clickEdit();
		Source			.LocationsPage().setEndDate(Today, EmptyString);
		Source			.LocationsPage().clickSubmit().clickPopupOk();	
		return this;
	}
	
	public LocationsPage endDateLocation(String orgSearchTerm, String locSearchTerm, String endDate)
	{
		Source			.NavigationMenuBar().clickOrganization().setSearch(orgSearchTerm == null ? OrganizationName : orgSearchTerm).clickFirstRow().clickAnchor();
		Source			.OrganizationNavigator().clickLocations().setSearch(locSearchTerm == null ? OrganizationName : locSearchTerm).clickFirstRow().clickEdit();
		Source			.LocationsPage().setEndDate(endDate == null ? Today : endDate, EmptyString);
		Source			.LocationsPage().clickSubmit().clickPopupOk();	
		return this;
	}
	
	public String getTTYValue() {
		return Source.SeleniumHelper().getWebElement(TTYTextBox).getAttribute("value");
	}
	
}
