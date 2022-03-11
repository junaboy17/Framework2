package com.eisrem.pageFactory.CommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.Organization.OrganizationNavigator;

import com.eisrem.pageFactory.Organization.UserInfoAccord;
import com.eisrem.pageFactory.People.DemographicsPage;
import com.eisrem.pageFactory.People.PeopleNavigator;

public class IdentifiersPage extends OrganizationNavigator{

	public IdentifiersPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h3[contains(text(),'Add Identifiers')]")
	public WebElement AddIdentifiersTitle;	
	
	@FindBy(xpath="//a[@aria-controls='idnt-picker-table']//span[contains(text(),'Add')]")
	public WebElement AddButton;
	
	@FindBy(xpath="//a[@aria-controls='idnt-picker-table']//span[contains(text(),'Edit')]")
	public WebElement EditButton;
	
	@FindBy(xpath="//a[@aria-controls='idnt-picker-table']//span[contains(text(),'View')]")
	public WebElement ViewButton;
	
	@FindBy(xpath="//a[contains(text(),'Identifiers')]")
	public WebElement IdentifiersAccord;
	
	@FindBy(xpath="//table[contains(@id,'idnt-picker-table')]//tbody//tr[@role='row'][1]")
	public WebElement IdentifiersFirstRow;

	@FindBy(xpath="//p[@class='required-note']")
	public WebElement NoteTitle;

	@FindBy(xpath="//a[contains(text(),'Identifiers Info:')]")
	public WebElement IdentifiersInfoLink;
	
	@FindBy(xpath="//label[@for='ident_startDate']")
	public WebElement StartDateTitle;
	
//	@FindBy(xpath="//input[@id='ident_startDate']")
//	public WebElement StartDateTextBox;
	
	@FindBy(xpath="//label[@for='ident_endDate']")
	public WebElement EndDateTitle;
	
	@FindBy(xpath="//input[@id='ident_endDate']")
	public WebElement EndDateTextBox;

	@FindBy(xpath="//label[@for='type']")
	public WebElement IdentifiersTypeTitle;

	@FindBy(xpath="//select[contains(@id,'type')]")
	public WebElement IdentifiersTypeDropDown;
	
	@FindBy(xpath="//label[@for='idNumber']")
	public WebElement IdentifiersIdNumberTitle;

	@FindBy(xpath="//input[contains(@id,'idNumber')]")
	public WebElement IdentifiersIdNumberTextBox;

	@FindBy(xpath="//label[@for='desc']")
	public WebElement DescriptionTitle;

	@FindBy(xpath="//textarea[@id='idntDesc']")
	public WebElement DescriptionTextBox;

	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement SubmitBtn;

	@FindBy(xpath="//div[@class='popover fade top in']")
	public WebElement InvalidIDErrorMessage;
	
	@FindBy(xpath="//button[contains(text(),'Print')]")
	public WebElement PrintBtn;

	@FindBy(xpath="//button[@id='bckBtn']")
	public WebElement BackToIdentifiersBtn;
	
	@FindBy(xpath="//button[contains(text(),'Back To Identifiers')]")
	public WebElement BackToIdentifiers;
	
//	public IdentifiersPage clickIdentifiersLink() {
//		Source.SeleniumHelper().getWebElement(IdentifiersAccord).click();
//	}	
	
	public IdentifiersPage clickIdentifiersAccord() {
		Source.SeleniumHelper().clickElement(IdentifiersAccord);
		return new IdentifiersPage(DriverFactory.getDriver());
	}

	public String readAddIdentifiersTitleTitle() {
		return Source.SeleniumHelper().readElement(AddIdentifiersTitle);
	}
	
	public IdentifiersPage clickIdentifiersAdd() {
		Source.SeleniumHelper().clickElement(AddButton);
		return new IdentifiersPage(DriverFactory.getDriver());
	}
	
	public IdentifiersPage clickIdentifiersEdit() {
		Source.SeleniumHelper().clickElement(EditButton);
		return new IdentifiersPage(DriverFactory.getDriver());
	}
	
	public IdentifiersPage clickIdentifiersView() {
		Source.SeleniumHelper().clickElement(ViewButton);
		return new IdentifiersPage(DriverFactory.getDriver());
	}
	
	public IdentifiersPage clickIdentifiersFirstRow() {
		Source.SeleniumHelper().clickElement(IdentifiersFirstRow);
		return this;
	}

	public String readNoteTitle() {
		return Source.SeleniumHelper().readElement(NoteTitle);
	}

	public String readIdentifiersInfoLinkTitle() {
		return Source.SeleniumHelper().readElement(IdentifiersInfoLink);
	}

	public DemographicsPage clickIdentifiersInfoLinkTitle() {
		Source.SeleniumHelper().clickElement(IdentifiersInfoLink);
		return new DemographicsPage(DriverFactory.getDriver());
	}

//	public IdentifiersPage setStartDate(String StartDate, String... Clear) {
//		Source	.SeleniumHelper()
//				.setText(StartDateTextBox, StartDate, Clear);
//		return this;
//	}
	
	public IdentifiersPage setEndDate(String EndDate, String... Clear) {
		Source	.SeleniumHelper()
				.setText(EndDateTextBox, EndDate, Clear);
		return this;
	}
	
	public String readIdentifiersTypeTitle() {
		return Source.SeleniumHelper().readElement(IdentifiersTypeTitle);
	}

	public IdentifiersPage selectIdentifiersType(int Identifiers) {
		Source.SeleniumHelper().select(IdentifiersTypeDropDown, Identifiers);
		return this;
	}
	
	public IdentifiersPage selectIdentifiersType(String Identifier) {
		Source.SeleniumHelper().select(IdentifiersTypeDropDown, Identifier);
		return this;
	}
	
	public String readIdNumberTitle() {
		return Source.SeleniumHelper().readElement(IdentifiersIdNumberTitle);
	}

	public IdentifiersPage setIdentifiersIdNumber(String identNumber, String... Clear) {
		Source.SeleniumHelper().setText(IdentifiersIdNumberTextBox, identNumber, Clear);
		return this;
	}
	
	public IdentifiersPage setIdentifiersIdNumber(int identNumber, String... Clear) {
		Source.SeleniumHelper().setText(IdentifiersIdNumberTextBox, identNumber, Clear);
		return this;
	}
	
	public String readIdentifiersIdNumber() {
		return Source.SeleniumHelper().getWebElement(IdentifiersIdNumberTextBox).getAttribute("value");
	}
	
	public String readDescriptionTitle() {
		return Source.SeleniumHelper().readElement(DescriptionTitle);
	}

	public IdentifiersPage setDescription(String description, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, description, Clear);
		return this;
	}
	
	public String readDescriptionTextBoxValue() {
		return Source.SeleniumHelper().readElement(DescriptionTextBox);
	}

	public String readSubmitBtn() {
		return Source.SeleniumHelper().readElement(SubmitBtn);
	}

	public IdentifiersPage clickSubmit() {
		Source.SeleniumHelper().clickElement(SubmitBtn);
		return this;
	}
	
	public String readInvalidIDErrorMessage() {
		return Source.SeleniumHelper().readElement(InvalidIDErrorMessage);
	}

	public String readBackToIdentifiersBtn() {
		return Source.SeleniumHelper().readElement(BackToIdentifiersBtn);
	}

	public IdentifiersPage clickBackToIdentifiers() {
		Source.SeleniumHelper().clickElement(BackToIdentifiersBtn);
		return this;
	}
	
	public IdentifiersPage clickBackToIdentifiersList() {
		Source.SeleniumHelper().getWebElement(BackToIdentifiers).click();
		return this;
	}

}
