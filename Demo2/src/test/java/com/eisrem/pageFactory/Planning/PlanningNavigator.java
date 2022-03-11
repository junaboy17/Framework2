package com.eisrem.pageFactory.Planning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.pageFactory.CommonPage.ConductedTypes;

public class PlanningNavigator extends ConductedTypes{

	public PlanningNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Planning')]")
	public WebElement PlanningTab;
	
	public String readReportsTab() {
		return Source.SeleniumHelper().readElement(PlanningTab);
	}
	
	public PlanningNavigator clickReports() {
		Source.SeleniumHelper().clickElement(PlanningTab);
		return this;
	}
	
}
