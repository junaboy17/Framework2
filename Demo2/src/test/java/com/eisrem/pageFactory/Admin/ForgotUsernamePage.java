package com.eisrem.pageFactory.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.pageFactory.CommonPage.DataTable;

public class ForgotUsernamePage  extends DataTable{

	public ForgotUsernamePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h3[@id='emailUsernameTitle']")
	public WebElement emailUsernameTitle;

	@FindBy(xpath="//input[@id='email']")
	public WebElement emailText;

	@FindBy(xpath="//label[@id='verificationCodeLbl']")
	public WebElement verificationLblText;

	@FindBy(xpath="//input[@id='verificationCode']")
	public WebElement verificationCodeText;

	@FindBy(xpath="//button[@id='emailUsernameBtn']")
	public WebElement emailMeMyUsernameBtn;

	@FindBy(xpath="//a[contains(text(),'Back To Login')]")
	public WebElement backToLoginBtn;

	@FindBy(xpath="//div[@id='errordiv']")
	public WebElement errorMessage;
	
	@FindBy(xpath="//h3[@id='emailUsernameTitle']")
	public WebElement successMessageHeader;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/p[1]")
	public WebElement successMessage;

	public String readForgotUsernameTitle() {
		return Source.SeleniumHelper().readElement(emailUsernameTitle);
	}

	public String readEmailTitle() {
		return Source.SeleniumHelper().readElement(emailText);
	}

	public String readVerificationLbl() {
		return Source.SeleniumHelper().readElement(verificationLblText);
	}

	public String readVerificationCodeTitle() {
		return Source.SeleniumHelper().readElement(verificationCodeText);
	}

	public ForgotUsernamePage setEmail(String password, String... Clear) {
		Source.SeleniumHelper().setText(emailText, password, Clear);
		return this;
	}

	public ForgotUsernamePage setVerificationCode(String password, String... Clear) {
		Source.SeleniumHelper().setText(verificationCodeText, password, Clear);
		return this;
	}
	
	public ForgotUsernamePage setVerificationCodeOnScreen(String... Clear) {
		Source.SeleniumHelper().setText(verificationCodeText, Source.SeleniumHelper().readElement(verificationLblText).substring(19), Clear);
		return this;
	}

	public String readEmailMeMyUsernameBtn() {
		return Source.SeleniumHelper().readElement(emailMeMyUsernameBtn);
	}
	
	public String backToLoginBtn() {
		return Source.SeleniumHelper().readElement(backToLoginBtn);
	}

	public ForgotUsernamePage clickEmailMeMyUsernameBtn() {
		Source.SeleniumHelper().clickElement(emailMeMyUsernameBtn);
		return this;
	}

	public ForgotUsernamePage clickbackToLogin() {
		Source.SeleniumHelper().clickElement(backToLoginBtn);
		return this;
	}

	public String errorMessage() {
		return Source.SeleniumHelper().readElement(errorMessage);
	}
	
	public String readSuccessMessage() {
		return Source.SeleniumHelper().readElement(successMessage);
	}
	
	public String readSuccessMessageHeader() {
		return Source.SeleniumHelper().readElement(successMessageHeader);
	}

}
