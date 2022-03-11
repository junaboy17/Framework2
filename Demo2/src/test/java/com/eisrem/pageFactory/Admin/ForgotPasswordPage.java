package com.eisrem.pageFactory.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.pageFactory.CommonPage.DataTable;

public class ForgotPasswordPage  extends DataTable{

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id='resetForgottenPasswordForm']/div[1]/div/div[2]/form/fieldset/legend")
	public WebElement verificationTitle;
	
	@FindBy(xpath="//h3[@id='forgotPasswordTitle']")
	public WebElement forgotPasswordTitle;

	@FindBy(xpath="//input[@id='username']")
	public WebElement usernameText;

	@FindBy(xpath="//label[@id='verificationCodeLbl']")
	public WebElement verificationLblText;

	@FindBy(xpath="//input[@id='verificationCode']")
	public WebElement verificationCodeText;

	@FindBy(xpath="//button[@id='resetForgottenPasswordBtn']")
	public WebElement resetForgottenPasswordBtn;

	@FindBy(xpath="//a[contains(text(),'Back To Login')]")
	public WebElement backToLoginBtn;

	@FindBy(xpath="//div[@id='errordiv']")
	public WebElement errorMessage;
	
	@FindBy(xpath="//h3[@id='forgotPasswordTitle']")
	public WebElement successMessageHeader;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]/p[1]")
	public WebElement successMessage;

	public String readVerificationTitle() {
		return Source.SeleniumHelper().readElement(verificationTitle);
	}
	
	public String readForgotPasswordTitle() {
		return Source.SeleniumHelper().readElement(forgotPasswordTitle);
	}

	public String readUsernameTitle() {
		return Source.SeleniumHelper().readElement(usernameText);
	}

	public String readVerificationLbl() {
		return Source.SeleniumHelper().readElement(verificationLblText);
	}

	public String readVerificationCodeTitle() {
		return Source.SeleniumHelper().readElement(verificationCodeText);
	}

	public ForgotPasswordPage setUsername(String password, String... Clear) {
		Source.SeleniumHelper().setText(usernameText, password, Clear);
		return this;
	}

	public ForgotPasswordPage setVerificationCode(String password, String... Clear) {
		Source.SeleniumHelper().setText(verificationCodeText, password, Clear);
		return this;
	}
	
	public ForgotPasswordPage setVerificationCodeOnScreen() {
		Source.SeleniumHelper().setText(verificationCodeText, Source.SeleniumHelper().readElement(verificationLblText).substring(19), Clear);
		return this;
	}

	public String readEmailMeMyForgottenPasswordBtn() {
		return Source.SeleniumHelper().readElement(resetForgottenPasswordBtn);
	}
	
	public String backToLoginBtn() {
		return Source.SeleniumHelper().readElement(backToLoginBtn);
	}

	public ForgotPasswordPage clickEmailMeMyForgottenPasswordBtn() {
		Source.SeleniumHelper().clickElement(resetForgottenPasswordBtn);
		return this;
	}

	public ForgotPasswordPage clickbackToLogin() {
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
