package com.eisrem.pageFactory.People;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.IdentifiersPage;

public class DemographicsPage extends PeopleNavigator{


	public DemographicsPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
//	public String FirstName2 = FirstName + SeleniumHelper.generateRandomNumber(4);
	public String FirstName3 = FirstName + SeleniumHelper.generateRandomAlpha(4);

	@FindBy(xpath="//h3[contains(text(),'Add Demographics')]")
	public WebElement AddDemographicsTitle;	
	
	@FindBy(xpath="//h3[contains(text(),'View Demographics')]")
	public WebElement ViewDemographicsTitle;	

	@FindBy(xpath="//p[@class='required-note']")
	public WebElement NoteTitle;

	@FindBy(xpath="//a[@aria-controls='collapseOne']")
	public WebElement DemographicsParentAccordion;

	@FindBy(xpath="//a[@aria-controls='Demographics_Demographics_body']")
	public WebElement DemographicsChildAccordion;

	@FindBy(xpath="//label[@for='firstName']")
	public WebElement FirstNameTitle;

	@FindBy(xpath="//input[@id='firstName']")
	public WebElement FirstNameTextBox;

	@FindBy(xpath="//label[@for='middleName']")
	public WebElement MiddleNameTitle;

	@FindBy(xpath="//input[@id='middleName']")
	public WebElement MiddleNameTextBox;

	@FindBy(xpath="//label[@for='lastName']")
	public WebElement LastNameTitle;

	@FindBy(xpath="//input[@id='lastName']")
	public WebElement LastNameTextBox;

	@FindBy(xpath="//label[@for='suffixName']")
	public WebElement SuffixTitle;

	@FindBy(xpath="//input[@id='suffixName'] | //input[@id='suffix']")
	public WebElement SuffixTextBox;

	@FindBy(xpath="//label[@for='gender']")
	public WebElement GenderTitle;

	@FindBy(xpath="//select[@id='gender']")
	public WebElement GenderDropDown;

	@FindBy(xpath="//label[@for='dob']")
	public WebElement DateOfBirthTitle;

	@FindBy(xpath="//input[@id='dob']")
	public WebElement DateOfBirthTextBox;

	@FindBy(xpath="//label[@for='dod']")
	public WebElement DateOfDeathTitle;

	@FindBy(xpath="//input[@id='dod']")
	public WebElement DateOfDeathTextBox;

	@FindBy(xpath="//label[contains(text(),'Contact?')]")
	public WebElement ContactBtnTitle;

	@FindBy(xpath="//div[@id='Demographics_Demographics_body_inner']/div[11]/div/div")
	public WebElement ContactToggle;

	@FindBy(xpath="//label[contains(text(),'Sensitive?')]")
	public WebElement SensitiveBtnTitle;

	@FindBy(xpath="//div[@id='Demographics_Demographics_body_inner']/div[12]/div/div")
	public WebElement SensitiveToggle;

	@FindBy(xpath="//div[@id='Demographics_Demographics_body_inner']/div[12]/div/div//input")
	public WebElement SensitiveYesNoBtnAttribute;

	@FindBy(xpath="//a[contains(text(),'Identifiers')]")
	public WebElement IdentifiersAccordion;

	@FindBy(xpath="//a[contains(text(),'Status')][@role='button']")
	public WebElement StatusLink;

	@FindBy(xpath="//label[@for='household']")
	public WebElement HouseholdTitle;

	@FindBy(xpath="//textarea[@id='household']")
	public WebElement HouseholdTextBox;

	@FindBy(xpath="//label[@for='marital']")
	public WebElement MaritalTitle;

	@FindBy(xpath="//select[@id='marital']")
	public WebElement MaritalDropDown;

	@FindBy(xpath="//label[@for='miltStatus']")
	public WebElement MilitaryTitle;

	@FindBy(xpath="//select[@id='miltStatus']")
	public WebElement MilitaryDropDown;

	@FindBy(xpath="//label[@for='citizenshipStatus']")
	public WebElement CitizenshipTitle;

	@FindBy(xpath="//select[@id='citizenshipStatus']")
	public WebElement CitizenshipDropDown;

	@FindBy(xpath="//label[@for='miltService']")
	public WebElement MilitaryServiceTitle;

	@FindBy(xpath="//select[@id='miltService']")
	public WebElement MilitaryServiceDropDown;

	@FindBy(xpath="//label[@for='countryOfCitizenship']")
	public WebElement CountryOfCitizenshipTitle;

	@FindBy(xpath="//select[@id='countryOfCitizenship']")
	public WebElement CountryOfCitizenshipDropDown;

	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement SubmitBtn;

	@FindBy(xpath="//button[contains(text(),'Print')]")
	public WebElement PrintBtn;

	@FindBy(xpath="//button[contains(text(),'Back To People')]")
	public WebElement BackToPeopleBtn;
	
	@FindBy(xpath="//div[contains(text(),'Date Of Birth cannot be in the future')]")
	public WebElement NoFutureDobDate;
	
	@FindBy(xpath="//div[contains(text(),'Please enter a valid Date. The format is MM/DD/YYYY')]")
	public WebElement InvalidDobDate;
	
	@FindBy(xpath="//div[contains(text(),'Date Of Death cannot be in the future')]")
	public WebElement NoFutureDodDate;
	
	@FindBy(xpath="//div[contains(text(),'Date Of Death cannot be before Date of Birth')]")
	public WebElement DodBeforeDobDate;
	
	@FindBy(xpath="//div[@class='popover-content']")
	public WebElement InvalidIDErrorMessage;
	

	public String readAddDemographicsTitle() {
		return Source.SeleniumHelper().readElement(AddDemographicsTitle);
	}
	
	public String readViewDemographicsTitle() {
		return Source.SeleniumHelper().readElement(ViewDemographicsTitle);
	}

	public String readNoteTitle() {
		return Source.SeleniumHelper().readElement(NoteTitle);
	}

	public String readDemographicsParentAccordionTitle() {
		return Source.SeleniumHelper().readElement(DemographicsParentAccordion);
	}

	public DemographicsPage clickDemographicsParentAccord() {
		Source.SeleniumHelper().clickElement(DemographicsParentAccordion);
		return this;
	}

	public String readDemographicsChildAccordionTitle() {
		return Source.SeleniumHelper().readElement(DemographicsChildAccordion);
	}

	public DemographicsPage clickDemographicsChildAccord() {
		Source.SeleniumHelper().clickElement(DemographicsChildAccordion);
		return this;
	}

	public String readFirstNameTitle() {
		return Source.SeleniumHelper().readElement(FirstNameTitle);
	}
	
	public String readFirstNameValue() {
		return Source.SeleniumHelper().readAttribute(FirstNameTextBox, "value");
	}

	public DemographicsPage setFirstName(String name, String... Clear) {
		Source.SeleniumHelper().setText(FirstNameTextBox, name, Clear);
		return this;
	}

	public String readMiddleNameTitle() {
		return Source.SeleniumHelper().readElement(MiddleNameTitle);
	}
	
	public String readMiddleNameValue() {
		return Source.SeleniumHelper().readAttribute(MiddleNameTextBox, "value");
	}

	public DemographicsPage setMiddleName(String name, String... Clear) {
		Source.SeleniumHelper().setText(MiddleNameTextBox, name, Clear);
		return this;
	}

	public String readLastNameTitle() {
		return Source.SeleniumHelper().readElement(LastNameTitle);
	}
	
	public String readLastNameValue() {
		return Source.SeleniumHelper().readAttribute(LastNameTextBox, "value");
	}

	public DemographicsPage setLastName(String name, String... Clear) {
		Source.SeleniumHelper().setText(LastNameTextBox, name, Clear);
		return this;
	}

	public String readSuffixTitle() {
		return Source.SeleniumHelper().readElement(SuffixTitle);
	}
	
	public DemographicsPage setSuffix(String suffix, String... Clear) {
		Source.SeleniumHelper().setText(SuffixTextBox, suffix, Clear);
		return this;
	}

	public String readGenderTitle() {
		return Source.SeleniumHelper().readElement(GenderTitle);
	}
	
	public String readGenderValue() {
		return Source.SeleniumHelper().readAttribute(GenderDropDown, "value");
	}

	public DemographicsPage selectDemographicsGender(int value) {
		Source.SeleniumHelper().select(GenderDropDown, value);
		return this;
	}

	public String readDateOfBirthTitle() {
		return Source.SeleniumHelper().readElement(DateOfBirthTitle);
	}
	
	public String readDateOfBirthValue() {
		return Source.SeleniumHelper().readAttribute(DateOfBirthTextBox, "value");
	}

	public DemographicsPage setDateOfBirth(String date, String... Clear) {
		Source.SeleniumHelper().setText(DateOfBirthTextBox, date, Clear);
		return this;
	}

	public String readDateOfDeathTitle() {
		return Source.SeleniumHelper().readElement(DateOfDeathTitle);
	}
	
	public DemographicsPage setDateOfDeath(String date, String... Clear) {
		Source.SeleniumHelper().setText(DateOfDeathTextBox, date, Clear);
		return this;
	}

	public String readContactBtnTitle() {
		return Source.SeleniumHelper().readElement(ContactBtnTitle);
	}

	public String readContactYesNoBtn() {
		return Source.SeleniumHelper().readElement(ContactToggle);
	}

	public String readSensitiveBtnTitle() {
		return Source.SeleniumHelper().readElement(SensitiveBtnTitle);
	}

	public String readSensitiveToggle() {
		return Source.SeleniumHelper().readElement(SensitiveToggle);
	}

	public String readIdentifiersAccord() {
		return Source.SeleniumHelper().readElement(IdentifiersAccordion);
	}

	public IdentifiersPage clickIdentifiersAccord() {
		Source.SeleniumHelper().clickElement(IdentifiersAccordion);
		return new IdentifiersPage(DriverFactory.getDriver());
	}

	public String readStatusAccord() {
		return Source.SeleniumHelper().readElement(StatusLink);
	}

	public DemographicsPage clickStatusAccord() {
		Source.SeleniumHelper().clickElement(StatusLink);
		return this;
	}

	public String readHouseholdTitle() {
		return Source.SeleniumHelper().readElement(HouseholdTitle);
	}
	
	public String readHouseholdValue() {
		return Source.SeleniumHelper().readAttribute(HouseholdTextBox, "value");
	}
	
	public DemographicsPage setHouseHold(String notes, String... Clear) {
		Source.SeleniumHelper().setText(HouseholdTextBox, notes, Clear);
		return this;
	}

	public String readMaritalTitle() {
		return Source.SeleniumHelper().readElement(MaritalTitle);
	}
	
	public String readMaritalValue() {
		return Source.SeleniumHelper().readAttribute(MaritalDropDown, "value");
	}
	
	public DemographicsPage selectMaritalStatus(int value) {
		Source.SeleniumHelper().select(MaritalDropDown, value);
		return this;
	}
	
	public String readMilitaryTitle() {
		return Source.SeleniumHelper().readElement(MilitaryTitle);
	}
	
	public String readMilitaryValue() {
		return Source.SeleniumHelper().readAttribute(MilitaryDropDown, "value");
	}

	public DemographicsPage selectMilitaryStatus(int value) {
		Source.SeleniumHelper().select(MilitaryDropDown, value);
		return this;
	}

	public String readCitizenshipTitle() {
		return Source.SeleniumHelper().readElement(CitizenshipTitle);
	}
	
	public String readCitizenshipValue() {
		return Source.SeleniumHelper().readAttribute(CitizenshipDropDown, "value");
	}
	
	public DemographicsPage selectCitizenshipStatus(int value) {
		Source.SeleniumHelper().select(CitizenshipDropDown, value);
		return this;
	}

	public String readMilitaryServiceTitle() {
		return Source.SeleniumHelper().readElement(MilitaryServiceTitle);
	}

	public String readMilitaryServiceValue() {
		return Source.SeleniumHelper().readAttribute(MilitaryServiceDropDown, "value");
	}
	
	public DemographicsPage selectMilitaryService(int value) {
		Source.SeleniumHelper().select(MilitaryServiceDropDown, value);
		return this;
	}

	public String readCountryOfCitizenshipTitle() {
		return Source.SeleniumHelper().readElement(CountryOfCitizenshipTitle);
	}
	
	public String readCountryOfCitizenshipValue() {
		return Source.SeleniumHelper().readAttribute(CountryOfCitizenshipDropDown, "value");
	}
	
	public DemographicsPage selectCountryOfCitizenship(int value) {
		Source.SeleniumHelper().select(CountryOfCitizenshipDropDown, value);
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

	public DemographicsPage clickPrint() {
		Source.SeleniumHelper().clickElement(PrintBtn);
		return this;
	}

	public String readBackToPeopleBtn() {
		return Source.SeleniumHelper().readElement(BackToPeopleBtn);
	}

	public PeoplePage clickBackToPeople() {
		Source.SeleniumHelper().clickElement(BackToPeopleBtn);
		return new PeoplePage(DriverFactory.getDriver());
	}

	public boolean confirmAccordionOrder() {
		String html = Source.SeleniumHelper().readAttribute(DemographicsParentAccordion, "innerHTML");
		int positionOfDem = html.indexOf("id=\"Demographics_Demographics_heading");
		int positionOfIdent = html.indexOf("id=\"Demographics_Identifiers_heading");
		int positionOfStatus = html.indexOf("id=\"Demographics_Status_heading");
		int positionOfLanguage = html.indexOf("id=\"Demographics_Language_heading");
		int positionOfOther = html.indexOf("id=\"Demographics_Other_heading");

		if(positionOfDem<positionOfIdent && positionOfIdent<positionOfStatus && positionOfStatus<positionOfLanguage && positionOfLanguage<positionOfOther) {
			return true;
		}else {
			return false;
		}
	}
	
	public DemographicsPage fillRequiredDemogrphics() {
		setFirstName(FirstName3)
		.setLastName(LastName)
		.selectDemographicsGender(Enumerations.Gender.MALE.getIndex())
		.setDateOfBirth(DateOfBirth);
		return this;
	}
	
	public DemographicsPage fillRequiredDemogrphics(String firstName, String lastName, Enumerations.Gender gender, String dateOfBirth) {
		 setFirstName(firstName)
		.setLastName(lastName)
		.selectDemographicsGender(gender.getIndex())
		.setDateOfBirth(dateOfBirth);
		return this;
	}
	
	public DemographicsPage fillRequiredDemogrphicsWithIdentifier() {
		String IdentifierNumber = SeleniumHelper.generateRandomMedicaidIdentifier();
		 setFirstName(FirstName3)
		.setLastName(LastName)
		.selectDemographicsGender(Enumerations.Gender.MALE.getIndex())
		.setDateOfBirth(DateOfBirth)
		.clickIdentifiersAccord()
		.DataTable()
		.clickAdd()
		.IdentifiersPage()
		.selectIdentifiersType(1)
		.setIdentifiersIdNumber(IdentifierNumber)
		.clickComplete();
		return this;
	}
	
	public DemographicsPage fillRequiredDemogrphicsWithIdentifier(String firstName, String lastName, Enumerations.Gender gender, String dateOfBirth, Identifier identifierType, String identifierNumber) {
		 setFirstName(firstName)
		.setLastName(lastName)
		.selectDemographicsGender(gender.getIndex())
		.setDateOfBirth(dateOfBirth)
		.clickIdentifiersAccord()
		.DataTable()
		.clickAdd()
		.IdentifiersPage()
		.selectIdentifiersType(identifierType.getIndex())
		.setIdentifiersIdNumber(identifierNumber)
		.clickComplete();
		return this;
	}
	
	public DemographicsPage fillAllDemogrphicsNoIdentifier() {
		 setFirstName(FirstName3, Clear)
		.setMiddleName(MiddleName, Clear)
		.setLastName(LastName, Clear)
		.selectDemographicsGender(Enumerations.Gender.MALE.getIndex())
		.setDateOfBirth(DateOfBirth, Clear)
		.clickStatusAccord()
		.setHouseHold(Household, Clear)
		.selectMaritalStatus(MaritalStatus.DIVORCED.getIndex())
		.selectMilitaryStatus(MilitaryStatus.ACTIVE_RESERVE.getIndex())
		.selectCitizenshipStatus(MilitaryService.AIR_FORCE.getIndex())
		.selectMilitaryService(CitizenshipStatus.NOT_A_US_CITIZEN.getIndex())
		.selectCountryOfCitizenship(Country.AFGHANISTAN.getIndex());
		return this;
	}
	
	public DemographicsPage fillAllDemogrphicsNoIdentifier(String firstName, String middleName, String lastName, Enumerations.Gender gender, String dateOfBirth, 
			String household, MaritalStatus maritalStatus, MilitaryStatus militaryStatus, MilitaryService militaryService, CitizenshipStatus citizenship, Country countryOfCitizenship, String... Clear) {
		
		setFirstName(firstName, Clear)
		.setMiddleName(middleName, Clear)
		.setLastName(lastName, Clear)
		.selectDemographicsGender(gender.getIndex())
		.setDateOfBirth(dateOfBirth, Clear)
		.clickStatusAccord()
		.setHouseHold(household, Clear)
		.selectMaritalStatus(maritalStatus.getIndex())
		.selectMilitaryStatus(militaryStatus.getIndex())
		.selectCitizenshipStatus(militaryService.getIndex())
		.selectMilitaryService(citizenship.getIndex())
		.selectCountryOfCitizenship(countryOfCitizenship.getIndex());
		return this;
	}
	
	public DemographicsPage fillAllDemogrphicsWithIdentifier() {
		String IdentifierNumber = SeleniumHelper.generateRandomMedicaidIdentifier();
		 setFirstName(FirstName3, Clear)
		.setMiddleName(MiddleName, Clear)
		.setLastName(LastName, Clear)
		.selectDemographicsGender(Enumerations.Gender.MALE.getIndex())
		.setDateOfBirth(DateOfBirth, Clear)
		.clickIdentifiersAccord()
		.DataTable()
		.clickAdd()
		.IdentifiersPage()
		.selectIdentifiersType(1)
		.setIdentifiersIdNumber(IdentifierNumber, Clear)
		.clickComplete()
		.DemographicsPage()
		.clickStatusAccord()
		.setHouseHold(Household, Clear)
		.selectMaritalStatus(MaritalStatus.DIVORCED.getIndex())
		.selectMilitaryStatus(MilitaryStatus.ACTIVE_RESERVE.getIndex())
		.selectCitizenshipStatus(MilitaryService.AIR_FORCE.getIndex())
		.selectMilitaryService(CitizenshipStatus.NOT_A_US_CITIZEN.getIndex())
		.selectCountryOfCitizenship(Country.AFGHANISTAN.getIndex());
		return this;
	}
	
	public DemographicsPage fillAllDemogrphicsWithIdentifier(String firstName, String middleName, String lastName, int gender, String dateOfBirth, int identifierType, String identifierNumber,
			String household, int marital, int militaryStatus, int militaryService, int citizenship, int countryOfCitizenship) {
		
		 setFirstName(firstName, Clear)
		.setMiddleName(middleName, Clear)
		.setLastName(lastName, Clear)
		.selectDemographicsGender(Enumerations.Gender.MALE.getIndex())
		.setDateOfBirth(dateOfBirth, Clear)
		.clickIdentifiersAccord()
		.DataTable()
		.clickAdd()
		.IdentifiersPage()
		.selectIdentifiersType(identifierType)
		.setIdentifiersIdNumber(identifierNumber, Clear)
		.clickComplete()
		.DemographicsPage()
		.clickStatusAccord()
		.setHouseHold(household, Clear)
		.selectMaritalStatus(marital)
		.selectMilitaryStatus(militaryStatus)
		.selectCitizenshipStatus(militaryService)
		.selectMilitaryService(citizenship)
		.selectCountryOfCitizenship(countryOfCitizenship);
		return this;
	}
	
	public String readNoFutureDobDateError() {
		return Source.SeleniumHelper().readElement(NoFutureDobDate);
	}
	
	public String readInvalidDobDateError() {
		return Source.SeleniumHelper().readElement(InvalidDobDate);
	}
	
	public String readNoFutureDodDateError() {
		return Source.SeleniumHelper().readElement(NoFutureDodDate);
	}
	
	public String readInvalidDodDateError() {
		return Source.SeleniumHelper().readElement(InvalidDobDate);
	}
	
	public String readDodBeforeDobDateError() {
		return Source.SeleniumHelper().readElement(DodBeforeDobDate);
	}
	
	public String readPopover() {
		return Source.SeleniumHelper().readElement(InvalidIDErrorMessage);
	}

}
