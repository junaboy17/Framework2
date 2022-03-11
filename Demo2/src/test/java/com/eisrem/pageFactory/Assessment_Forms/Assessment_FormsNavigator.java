package com.eisrem.pageFactory.Assessment_Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.pageFactory.CommonPage.ConductedTypes;

public class Assessment_FormsNavigator extends ConductedTypes{

	public Assessment_FormsNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Assessment')]")
	public WebElement AssessmentsAccord;
	
	@FindBy(xpath="//li[@id='typeConductor-tab']/a")
	public WebElement AssessmentsFormsTab;
	
	public String readAssessmentsTab() {
		return Source.SeleniumHelper().readElement(AssessmentsAccord);
	}
	
	public Assessment_FormsNavigator clickAssessmentsAccord() {
		Source.SeleniumHelper().clickElement(AssessmentsAccord);
		return this;
	}
	
	public String readAssessmentsFormsTab() {
		return Source.SeleniumHelper().readElement(AssessmentsFormsTab);
	}
	
	public Assessment_FormsNavigator clickAssessmentsFormsTab() {
		Source.SeleniumHelper().clickElement(AssessmentsFormsTab);
		return this;
	}
}
