package com.eisrem.pageFactory.People;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class RaceEthnicityPage extends PeopleNavigator{


	public RaceEthnicityPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@id='other-tab']//a")
	public WebElement OtherLink;

	@FindBy(xpath="//label[@for='pob']")
	public WebElement PlaceOfBirthTitle;

	@FindBy(xpath="//input[@id='pob']")
	public WebElement PlaceOfBirthDropDown;

	@FindBy(xpath="//label[@for='religion']")
	public WebElement ReligionTitle;

	@FindBy(xpath="//select[@id='religion']")
	public WebElement ReligionDropDown;

	@FindBy(xpath="//label[@for='race']")
	public WebElement RaceTitle;

	@FindBy(xpath="//select[@id='race']")
	public WebElement RaceDropDown;

	@FindBy(xpath="//label[@for='ethnicity']")
	public WebElement EthnicityTitle;

	@FindBy(xpath="//select[@id='ethnicity']")
	public WebElement EthnicityDropDown;

	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement SubmitBtn;

	@FindBy(xpath="//button[contains(text(),'Print')]")
	public WebElement PrintBtn;

	@FindBy(xpath="//button[contains(text(),'Back To People')]")
	public WebElement BackToPeopleBtn;
	
	public String readLinkTitle() {
		return Source.SeleniumHelper().readElement(OtherLink);
	}

	public RaceEthnicityPage clickOtherLinkTitle() {
		Source.SeleniumHelper().clickElement(OtherLink);
		return this;
	}

	public String readPlaceOfBirthTitle() {
		return Source.SeleniumHelper().readElement(PlaceOfBirthTitle);
	}	
	
	public String readPlaceOfBirthValue() {
		return Source.SeleniumHelper().readAttribute(PlaceOfBirthDropDown, "value");
	}

	public RaceEthnicityPage setPlaceOfBirth(String place, String... Clear) {
		Source.SeleniumHelper().setText(PlaceOfBirthDropDown, place, Clear);
		return this;
	}

	public String readReligionTitle() {
		return Source.SeleniumHelper().readElement(ReligionTitle);
	}
	
	public String readReligionValue() {
		return Source.SeleniumHelper().readAttribute(ReligionDropDown, "value");
	}

	public RaceEthnicityPage selectReligion(int value) {
		Source.SeleniumHelper().select(ReligionDropDown, value);
		return this;
	}
	
	public RaceEthnicityPage selectReligion(String value) {
		Source.SeleniumHelper().select(ReligionDropDown, value);
		return this;
	}

	public String readRaceTitle() {
		return Source.SeleniumHelper().readElement(RaceTitle);
	}
	
	public String readRaceValue() {
		return Source.SeleniumHelper().readAttribute(RaceDropDown, "value");
	}

	public RaceEthnicityPage selectRace(int value) {
		Source.SeleniumHelper().select(RaceDropDown, value);
		return this;
	}

	public String readEthnicityTitle() {
		return Source.SeleniumHelper().readElement(EthnicityTitle);
	}
	
	public String readEthnicityValue() {
		return Source.SeleniumHelper().readAttribute(EthnicityDropDown, "value");
	}

	public RaceEthnicityPage selectEthncity(int value) {
		Source.SeleniumHelper().select(EthnicityDropDown, value);
		return this;
	}
	
	public RaceEthnicityPage selectEthncity(String value) {
		Source.SeleniumHelper().select(EthnicityDropDown, value);
		return this;
	}

	public String readSubmitBtn() {
		return Source.SeleniumHelper().readElement(SubmitBtn);
	}

	public DataTable clickSubmit() {
		Source.SeleniumHelper().clickElement(SubmitBtn);
		return new DataTable(DriverFactory.getDriver());
	}

	public String readPrintBtn() {
		return Source.SeleniumHelper().readElement(PrintBtn);
	}

	public RaceEthnicityPage clickPrint() {
		Source.SeleniumHelper().clickElement(PrintBtn);
		return this;
	}

	public String readBackToPeopleBtn() {
		return Source.SeleniumHelper().readElement(BackToPeopleBtn);
	}

	public RaceEthnicityPage clickBackToPeople() {
		Source.SeleniumHelper().clickElement(BackToPeopleBtn);
		return this;
	}
	
	public RaceEthnicityPage FillRaceEthnicity() {
				 setPlaceOfBirth(PlaceOfBirth, "Y")
				.selectReligion(Religion.AGNOSTIC.getIndex())
				.selectRace(Race.AMERICAN_INDIAN_ALASKAN_NATIVE.getIndex())
				.selectEthncity(Ethnicity.AMERICAN_INDIAN_ALASKAN_NATIVE.getIndex());
		return this;
	}
	
	public RaceEthnicityPage FillRaceEthnicity(String PlaceOfBirth, int Religion, int Race, int Ethnicity) {
				 setPlaceOfBirth(PlaceOfBirth, "Y")
				.selectReligion(Religion)
				.selectRace(Race)
				.selectEthncity(Ethnicity);
		return this;
	}

}
