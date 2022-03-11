package com.eisrem.pageFactory.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.CommonPage.DataTable;


public class LogInPage extends DataTable{

	public LogInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class = \"alert alert-warning alert-dismissable banner-message-warning-color\"]//li[@class='banner-message-font-size '][1]")
	public WebElement topWarningMessage1;
	
	@FindBy(xpath="//div[@class = \"alert alert-warning alert-dismissable banner-message-warning-color\"]//li[@class='banner-message-font-size '][2]")
	public WebElement topWarningMessage2;
	
	@FindBy(xpath="//div[@class = \"alert alert-info alert-dismissable banner-message-notification-color\"]//li[@class='banner-message-font-size '][1]")
	public WebElement topNotificationMessage1;
	
	@FindBy(xpath="//div[@class = \"alert alert-info alert-dismissable banner-message-notification-color\"]//li[@class='banner-message-font-size '][2]")
	public WebElement topNotificationMessage2;
	
	@FindBy(xpath="//legend[contains(text(),'Login')]")
	public WebElement logInTitle;

	@FindBy(xpath="//label[@for='username']")
	public WebElement usernameTitle;

	@FindBy(xpath="//input[@id='username']")
	public WebElement usernameTextBox;

	@FindBy(xpath="//label[@for='password']")
	public WebElement passwordTitle;

	@FindBy(xpath="//input[@id='password']")
	public WebElement passwordTextBox;

	@FindBy(xpath="//button[@id='shSignIn']")
	public WebElement signInBtn;

	@FindBy(xpath="//a[@id='forgotPasswordLink']")
	public WebElement forgotPasswordLink;
	
	@FindBy(xpath="//a[@id='forgotUsernameLink']")
	public WebElement forgotUsernameLink;

	@FindBy(xpath="//div[@id='errordiv']")
	public WebElement errorMessage;
	
	@FindBy(xpath="//div[contains(text(),'Caps Lock is enabled!')]")
	public WebElement capsLockErrorMessage;
	
	@FindBy(xpath="//*[@id=\"errordiv\"]/h5/b/a")
	public WebElement loginAssistanceLink;

	public String readLogInTitle() {
		return Source.SeleniumHelper().readElement(logInTitle);
	}
	
	public String readUsernameTitle() {
		return Source.SeleniumHelper().readElement(usernameTitle);
	}

	public String redPasswordTitle() {
		return Source.SeleniumHelper().readElement(passwordTitle);
	}

	public LogInPage setUserName(String userName, String... Clear) {
		Source.SeleniumHelper().setText(usernameTextBox, userName, Clear);
		return this;
	}

	public LogInPage setPassword(String password, String... Clear) {
		Source.SeleniumHelper().setText(passwordTextBox, password, Clear);
		return this;
	}

	public NavigationMenuBar clickSignIn() {
		Source.SeleniumHelper().clickElement(signInBtn);
		return new NavigationMenuBar(DriverFactory.getDriver());
	}

	public String readTopWarningMessage1() {
		return Source.SeleniumHelper().readElement(topWarningMessage1);
	}
	
	public String readTopWarningMessage2() {
		return Source.SeleniumHelper().readElement(topWarningMessage2);
	}
	
	public String readTopNotificationMessage1() {
		return Source.SeleniumHelper().readElement(topNotificationMessage1);
	}
	
	public String readTopNotificationMessage2() {
		return Source.SeleniumHelper().readElement(topNotificationMessage2);
	}
	
	public String readCapsLockErrorMessage() {
		return Source.SeleniumHelper().readElement(capsLockErrorMessage);
	}
	
	public String readErrorMessage() {
		return Source.SeleniumHelper().readElement(errorMessage);
	}
		
	public LoginAssistance clickLoginAssistance() {
		Source.SeleniumHelper().clickElement(loginAssistanceLink);
		return new LoginAssistance(DriverFactory.getDriver());
	}
	
	public LoginAssistance clickforgotUsername() {
		Source.SeleniumHelper().clickElement(forgotUsernameLink);
		return new LoginAssistance(DriverFactory.getDriver());
	}
	
	public ForgotPasswordPage clickForgotPassword() {
		Source.SeleniumHelper().clickElement(forgotPasswordLink);
		return new ForgotPasswordPage(DriverFactory.getDriver());
	}

	public NavigationMenuBar LogIn(String userName, String password, String... Clear) {
		 setUserName(userName, Clear)
		.setPassword(password, Clear)
		.clickSignIn();
		return new NavigationMenuBar(DriverFactory.getDriver());
	}
	
	public NavigationMenuBar LogInSeleniumUser() {
		setUserName(Configuration.User.testUser)
		.setPassword(Configuration.Password.testPassword)
		.clickSignIn();
		return new NavigationMenuBar(DriverFactory.getDriver());
	}
	
	public LogInPage LogOut() {
		Source.SeleniumHelper().runJavascript("formSubmit();");
		return this;
	}
}
