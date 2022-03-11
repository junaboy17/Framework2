package com.eisrem.pageFactory.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.CommonPage.DataTable;


public class LoginAssistance extends DataTable{

	public LoginAssistance(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h4[@id='loginAssistanceTitle']")
	public WebElement LoginAssistanceTitle;

	@FindBy(xpath="//button[contains(text(),'Back To Login')]")
	public WebElement backToLoginBtn;

	public String readLogInTitle() {
		return Source.SeleniumHelper().readElement(LoginAssistanceTitle);
	}

	public NavigationMenuBar clickBackToLogin() {
		Source.SeleniumHelper().clickElement(backToLoginBtn);
		return new NavigationMenuBar(DriverFactory.getDriver());
	}
}
