package com.eisrem.pageFactory.Admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class PasswordChangePage  extends DataTable{

	public PasswordChangePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h3[contains(text(),'Password Change')]")
	public WebElement passwordChangeTitle;

	@FindBy(xpath="//label[contains(text(),'Current Password')]")
	public WebElement currentPasswordText;

	@FindBy(xpath="//label[text()='New Password']")
	public WebElement newPasswordText;

	@FindBy(xpath="//label[contains(text(),'Confirm New Password')]")
	public WebElement confirmNewPasswordText;

	@FindBy(xpath="//input[@id='currentpassword']")
	public WebElement currentPasswordTextBox;

	@FindBy(xpath="//input[@id='newpassword']")
	public WebElement newPasswordTextBox;

	@FindBy(xpath="//input[@id='cnfnewpassword']")
	public WebElement confirmNewPasswordTextBox;

	@FindBy(xpath="//div[@id='msgDiv']")
	public WebElement errorMessage;

	public String readPasswordChangeTitle() {
		return Source.SeleniumHelper().readElement(passwordChangeTitle);
	}

	public String readCurrentPasswordTitle() {
		return Source.SeleniumHelper().readElement(currentPasswordText);
	}

	public String readNewPasswordTitle() {
		return Source.SeleniumHelper().readElement(newPasswordText);
	}

	public String readConfirmNewPasswordTitle() {
		return Source.SeleniumHelper().readElement(confirmNewPasswordText);
	}

	public PasswordChangePage setCurrentPassword(String password, String... Clear) {
		Source.SeleniumHelper().setText(currentPasswordTextBox, password, Clear);
		return this;
	}

	public PasswordChangePage setNewPassword(String password, String... Clear) {
		Source.SeleniumHelper().setText(newPasswordTextBox, password, Clear);
		return this;
	}

	public PasswordChangePage setConfirmNewPassword(String password, String... Clear) {
		Source.SeleniumHelper().setText(confirmNewPasswordTextBox, password, Clear);
		return this;
	}

	public String errorMessage() {
		return Source.SeleniumHelper().readElement(errorMessage);
	}

}
