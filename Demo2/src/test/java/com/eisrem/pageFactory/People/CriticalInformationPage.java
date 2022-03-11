package com.eisrem.pageFactory.People;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class CriticalInformationPage extends DataTable{

	public CriticalInformationPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
		
	@FindBy(xpath="//label[@for = 'type']")
	public WebElement TypeTitle;
	
	@FindBy(xpath="//select[@groupname = 'PEOPLE_NA.PEO_NA_TYPE_CODE']")
	public WebElement TypeDropdown;
	
	
	@FindBy(xpath="//label[@for = 'type']")
	public WebElement DescriptionTitle;
	
	@FindBy(xpath="//textarea[contains(@id,'criticInfoComment')]")
	public WebElement DescriptionTextbox;

	public CriticalInformationPage selectType(int value) {
		Source.SeleniumHelper().select(TypeDropdown, value);
		return this;
	}
	
	public CriticalInformationPage setDescription(String description, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextbox, description, Clear);
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
