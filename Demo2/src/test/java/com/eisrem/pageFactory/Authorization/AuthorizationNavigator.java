package com.eisrem.pageFactory.Authorization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.Classes.ClassesPage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.MyHomePage.MyHomePage;

public class AuthorizationNavigator extends DataTable{

	public AuthorizationNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Authorization')]")
	public WebElement AuthorizationTab;
	
	public String readReportsTab() {
		return Source.SeleniumHelper().readElement(AuthorizationTab);
	}
	
	public AuthorizationNavigator clickReports() {
		Source.SeleniumHelper().clickElement(AuthorizationTab);
		return this;
	}
	
}
