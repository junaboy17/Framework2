package com.eisrem.pageFactory.CommonPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.People.DemographicsPage;
import com.eisrem.pageFactory.People.PeopleNavigator;

public class AddressPage extends DataTable{

	public AddressPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h3[contains(text(),'Add Address')]")
	public WebElement AddAddressTitle;	

	@FindBy(xpath="//p[@class='required-note']")
	public WebElement NoteTitle;

	@FindBy(xpath="//a[contains(text(),'Address Info:')]")
	public WebElement AddressInfoLink;

	@FindBy(xpath="//label[@for='addType']")
	public WebElement AddressTypeTitle;

	@FindBy(xpath="//select[@id='addType']")
	public WebElement AddressTypeDropDown;

	@FindBy(xpath="//label[@for='dba']")
	public WebElement DBATitle;

	@FindBy(xpath="//input[@id='dba']")
	public WebElement DBATextBox;

	@FindBy(xpath="//label[@for='address']")
	public WebElement Address1Title;

	@FindBy(xpath="//input[@id='address']")
	public WebElement Address1TextBox;

	@FindBy(xpath="//label[@for='addressline']]")
	public WebElement Address2Title;

	@FindBy(xpath="//input[@id='addressline']")
	public WebElement Address2TextBox;

	@FindBy(xpath="//label[@for='state']")
	public WebElement StateTitle;

	@FindBy(xpath="//select[@id='state']")
	public WebElement StateDropDown;

	@FindBy(xpath="//label[@for='city']")
	public WebElement CityTownTitle;

	@FindBy(xpath="//select[@id='city']")
	public WebElement CityTownDropDown;

	@FindBy(xpath="//label[@for='county']")
	public WebElement CountyTitle;

	@FindBy(xpath="//input[@id='county']")
	public WebElement CountyDropDown;

	@FindBy(xpath="//label[@for='zip']")
	public WebElement ZipcodeTitle;

	@FindBy(xpath="//select[@id='zip']")
	public WebElement ZipcodeDropDown;

	@FindBy(xpath="//label[@for='country']")
	public WebElement CountryTitle;

	@FindBy(xpath="//select[@id='country']")
	public WebElement CountryDropDown;

	@FindBy(xpath="//label[@for='residencetype']")
	public WebElement ResidenceTypeTitle;

	@FindBy(xpath="//select[@id='residencetype']")
	public WebElement ResidenceTypeDropDown;

	@FindBy(xpath="//label[@for='email']")
	public WebElement EmailTitle;

	@FindBy(xpath="//input[@id='email']")
	public WebElement EmailTextBox;

	@FindBy(xpath="//label[@for='telNum']")
	public WebElement PhoneNumberTitle;

	@FindBy(xpath="//input[@id='phoneNumber']")
	public WebElement PhoneNumberTextBox;

	@FindBy(xpath="//label[@for='celNumber']")
	public WebElement CellNumberTitle;

	@FindBy(xpath="//input[@id='celNumber']")
	public WebElement CellNumberTextBox;

	@FindBy(xpath="//label[@for='addNumber']")
	public WebElement AdditionalNumberTitle;

	@FindBy(xpath="//input[@id='addNumber']")
	public WebElement AdditionalNumberTextBox;

	@FindBy(xpath="//label[@for='faxNumber']")
	public WebElement FaxNumberTitle;

	@FindBy(xpath="//input[@id='faxNumber']")
	public WebElement FaxNumberTextBox;

	@FindBy(xpath="//label[@for='ttyNumber']")
	public WebElement TTYTitle;

	@FindBy(xpath="//input[@id='ttyNumber']")
	public WebElement TTYTextBox;
	
	@FindBy(xpath="//textarea[contains(@id,'desc')]")
	public WebElement DescriptionTextBox;
	
	@FindBy(xpath="//button[contains(text(),'Print')]")
	public WebElement PrintBtn;

	@FindBy(xpath="//button[@id='bckBtn']")
	public WebElement BackToAddressBtn;

	@FindBy(xpath="//button[contains(text(),'OK')]")
	public WebElement OkBtn;
	
	public String readAddAddressTitleTitle() {
		return Source.SeleniumHelper().readElement(AddAddressTitle);
	}

	public String readNoteTitle() {
		return Source.SeleniumHelper().readElement(NoteTitle);
	}

	public String readAddressInfoLinkTitle() {
		return Source.SeleniumHelper().readElement(AddressInfoLink);
	}

	public DemographicsPage clickAddressInfoLinkTitle() {
		Source.SeleniumHelper().clickElement(AddressInfoLink);
		return new DemographicsPage(DriverFactory.getDriver());
	}

	public String readAddress1Title() {
		return Source.SeleniumHelper().readElement(Address1Title);
	}

	public AddressPage setAddress1TextBox(String address, String... Clear) {
		Source.SeleniumHelper().setText(Address1TextBox, address, Clear);
		return this;
	}
	
	public String readAddress1Value() {
		return Source.SeleniumHelper().readAttribute(Address1TextBox, "value");
	}

	public String readAddressTypeTitle() {
		return Source.SeleniumHelper().readElement(AddressTypeTitle);
	}

	public AddressPage selectAddressType(int type) {
		Source.SeleniumHelper().select(AddressTypeDropDown, type);
		return this;
	}

	public AddressPage selectState(String state) {
		Source.SeleniumHelper().select(StateDropDown, state);	
		return this;
	}

	public String readCityTitle() {
		return Source.SeleniumHelper().readElement(CityTownTitle);
	}

	public AddressPage selectCity(String city) {
		Source.SeleniumHelper().select(CityTownDropDown, city);	
		return this;
	}

	public String readZipTitle() {
		return Source.SeleniumHelper().readElement(ZipcodeTitle);
	}

	public AddressPage selectZipcode(int zip) {
		Source.SeleniumHelper().select(ZipcodeDropDown, zip);
		return this;	
		}
	
	public String readCounty() {
		return Source.SeleniumHelper().readElement(CountyTitle);
	}
	
	public String readCountry() {
		return Source.SeleniumHelper().readElement(CountryTitle);
	}
	
	public String readPhoneNumberTitle() {
		return Source.SeleniumHelper().readElement(ZipcodeTitle);
	}

	public AddressPage setPhoneNumberTextBox(String phoneNumber, String... Clear) {
		Source.SeleniumHelper().setText(PhoneNumberTextBox, phoneNumber, Clear);
		return this;
	}
	
	public AddressPage setDescription(String description, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, description + Keys.TAB, Clear);
		return new AddressPage(DriverFactory.getDriver());
	}
	
	public String readDescriptionTextBoxValue() {
		return Source.SeleniumHelper().readElement(DescriptionTextBox);
	}

	public String readSubmitBtn() {
		return Source.SeleniumHelper().readElement(SubmitBtn);
	}

	public AddressPage clickOkBtn() {
		Source.SeleniumHelper().clickElement(OkBtn);
		return this;
	}
	
	public String readBackToAddressBtn() {
		return Source.SeleniumHelper().readElement(BackToAddressBtn);
	}

	public AddressPage clickBackToAddress() {
		Source.SeleniumHelper().clickElement(BackToAddressBtn);
		return new AddressPage(DriverFactory.getDriver());
	}
	
	public AddressPage FillRequiredAddress() {
		 setAddress1TextBox(Address)
		.selectAddressType(LegalAddressType)
		.selectState(State)
		.selectCity(City)
		.selectZipcode(1)
		.setPhoneNumberTextBox(PhoneNumber)
		.setDescription(Description);
		return this;
	}
	
	public AddressPage FillRequiredAddress(String Address, int AddressType, String State, String City, int Zip, String PhoneNumber, String Description) {
		 setAddress1TextBox(Address)
		.selectAddressType(AddressType)
		.selectState(State)
		.selectCity(City)
		.selectZipcode(Zip)
		.setPhoneNumberTextBox(PhoneNumber)
		.setDescription(Description);
		return this;
	}
	
	public AddressPage AddAddress() {
		 clickAdd()
		.AddressPage()
		.FillRequiredAddress()
		.clickSubmit()
		.clickPopupOk();
		return this;
	}
	
	public AddressPage AddAddress(String Address, int AddressType, String State, String City, int Zip, String PhoneNumber, String Description) {
		 clickAdd()
		.AddressPage()
		.FillRequiredAddress(Address, AddressType, State, City, Zip, PhoneNumber, Description)
		.clickSubmit()
		.clickPopupOk();
		return this;
	}
	
	public AddressPage EditAddress(String Address, String State, String City, int Zip, String PhoneNumber, String Description) {
		 setAddress1TextBox(Address, "Y")
		.selectState(State)
		.selectCity(City)
		.selectZipcode(Zip)
		.setPhoneNumberTextBox(PhoneNumber, "Y")
		.setDescription(Description, "Y");
		return this;
	}

}
