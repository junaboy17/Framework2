package com.eisrem.pageFactory.ProcessWizard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.Classes.ClassesPage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.MyHomePage.MyHomePage;

public class ProcessWizardNavigator extends DataTable{

	public ProcessWizardNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Process')]")
	public WebElement ProcessTab;
	
	public String readReportsTab() {
		return Source.SeleniumHelper().readElement(ProcessTab);
	}
	
	public ProcessWizardNavigator clickReports() {
		Source.SeleniumHelper().clickElement(ProcessTab);
		return this;
	}
	
}
