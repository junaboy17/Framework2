package com.eisrem.pageFactory.Assessment_Forms;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.pageFactory.CommonPage.FormPage;

public class Assessment_FormsPage extends Assessment_FormsNavigator{

	public Assessment_FormsPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	//Add Assesment

	@FindBy(xpath="//select[@id='type']")
	public WebElement AssessmentTypeDropDown;

	@FindBy(xpath="//select[@id='type']")
	public List<WebElement> AssessmentTypeValues;

	@FindBy(xpath="//select[@id='User-loc'] | //select[@id='user-loc']")
	public WebElement OrganizationDropDown;

	@FindBy(xpath="//input[@id='typeConductorName']")
	public WebElement TitleTextBox;

	@FindBy(xpath="//button[@id='startButton']")
	public WebElement StartAssessmentBtn;
	
	//------------------------------------------------------------------------------

	public Assessment_FormsPage selectAssessmentType(String assessmentType) {
		Source.SeleniumHelper().select(AssessmentTypeDropDown, assessmentType);
		return this;
	}

	public Assessment_FormsPage selectAssessmentType(int assessmentType) {
		Source.SeleniumHelper().select(AssessmentTypeDropDown, assessmentType);
		return this;
	}

	public Assessment_FormsPage selectAssessmentTypeById(String value) {
		Select select = new Select(AssessmentTypeDropDown);
		select.selectByValue(value);
		return this;
	}

	public Assessment_FormsPage selectOrganization(int organization) {
		Source.SeleniumHelper().select(OrganizationDropDown, organization);
		return this;
	}

	public Assessment_FormsPage setTitle(String title, String... Clear) {
		Source.SeleniumHelper().setText(TitleTextBox, title, Clear);
		return this;
	}

	public FormPage clickStartAssessment() {
		Source.SeleniumHelper().clickElement(StartAssessmentBtn);
		return new FormPage(DriverFactory.getDriver());
	}

}
