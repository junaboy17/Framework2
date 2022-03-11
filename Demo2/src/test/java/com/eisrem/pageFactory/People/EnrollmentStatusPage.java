package com.eisrem.pageFactory.People;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.Classes.ClassesPage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.Pagefactory;

public class EnrollmentStatusPage extends DataTable{

	public EnrollmentStatusPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[@for = 'statusType']")
	public WebElement StatusTitle;	
	
	@FindBy(xpath="//select[@id='statusType']")
	public WebElement StatusDropdown;	
	
	@FindBy(xpath="//label[@for = 'enrollStatusComment']")
	public WebElement DescriptionTitle;	
	
	@FindBy(xpath="//textarea[contains(@id,'enrollStatusComment')]")
	public WebElement DescriptionTextBox;	
	
	public String readDescriptionTextBoxValue() {
		return Source.SeleniumHelper().readElement(DescriptionTextBox);
	}

	public String readStatusTitle() {
		return Source.SeleniumHelper().readElement(StatusTitle);
	}
	
	public EnrollmentStatusPage selectStatus(int statusDropdown) {
		Source.SeleniumHelper().select(StatusDropdown, statusDropdown);	
		return this;
	}
	
	public String readDescriptionTitle() {
		return Source.SeleniumHelper().readElement(DescriptionTitle);
	}
	
	public EnrollmentStatusPage setDescription(String description, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, description + Keys.TAB, Clear);
		return new EnrollmentStatusPage(DriverFactory.getDriver());
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
