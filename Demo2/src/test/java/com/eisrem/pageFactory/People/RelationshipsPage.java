package com.eisrem.pageFactory.People;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class RelationshipsPage extends PeopleNavigator{

	public RelationshipsPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//label[@for = 'type']")
	public WebElement TypeTitle;
	
	@FindBy(xpath="//select[@id='type']")
	public WebElement TypeDropdown;
	
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
	
	
	public String readTypeTitle() {
		return Source.SeleniumHelper().readElement(TypeDropdown);
	}
	
	public RelationshipsPage selectType(int value) {
		Source.SeleniumHelper().select(TypeDropdown, value);
		return this;
	}
	
	public String readFirstNameTitle() {
		return Source.SeleniumHelper().readElement(FirstNameTitle);
	}
	
	public String readFirstNameValue() {
		return Source.SeleniumHelper().readAttribute(FirstNameTextBox, "value");
	}

	public RelationshipsPage setFirstName(String name, String... Clear) {
		Source.SeleniumHelper().setText(FirstNameTextBox, name, Clear);
		return this;
	}

	public String readLastNameTitle() {
		return Source.SeleniumHelper().readElement(LastNameTitle);
	}
	
	public String readLastNameValue() {
		return Source.SeleniumHelper().readAttribute(LastNameTextBox, "value");
	}

	public RelationshipsPage setLastName(String name, String... Clear) {
		Source.SeleniumHelper().setText(LastNameTextBox, name, Clear);
		return this;
	}
	
//	@FindBy(xpath="//h3[contains(text(),'Add Association')]")
//	public WebElement AddAssociationTitle;	
//
//	@FindBy(xpath="//p[@class='required-note']")
//	public WebElement NoteTitle;

	
	
//	public String readBackToAssociationBtn() {
//		return Source.SeleniumHelper().getWebElement(BackToAssociationBtn).getText();
//	}
//
//	public EnrollmentStatusPage clickBackToAssociation() {
//		Source.SeleniumHelper().getWebElement(BackToAssociationBtn).click();
//		return this;
//	}

}
