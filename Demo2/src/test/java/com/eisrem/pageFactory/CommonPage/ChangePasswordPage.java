package com.eisrem.pageFactory.CommonPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends DataTable{

	public ChangePasswordPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath="//legend[contains(text(),'Verification')]")
	public WebElement Legend;	

	@FindBy(xpath="//input[@id='currentpassword']")
	public WebElement CurrentPassword;
	
	@FindBy(xpath="//input[@id='newpassword']")
	public WebElement NewPassword;
	
	@FindBy(xpath="//input[@id='cnfnewpassword']")
	public WebElement ConfirmNewPassword;

	public ChangePasswordPage setCurrentPassword(String password, String... Clear) {
		Source.SeleniumHelper().setText(CurrentPassword, password + Keys.TAB, Clear);
		return this;
	}

	public ChangePasswordPage setNewPassword(String password, String... Clear) {
		Source.SeleniumHelper().setText(NewPassword, password + Keys.TAB, Clear);
		return this;
	}

	public ChangePasswordPage setConfirmNewPassword(String password, String... Clear) {
		Source.SeleniumHelper().setText(ConfirmNewPassword, password + Keys.TAB, Clear);
		return this;
	}
	
	public String checkLegendExists() {
		return Boolean.toString(Source.SeleniumHelper().getWebElement(Legend).isEnabled());
	}
	
	public ChangePasswordPage setCurrentPassword(String currentpw) {
		Source	.SeleniumHelper().setText(CurrentPassword, currentpw);
		return this;
	}
	
	public ChangePasswordPage setNewPassword(String newpw) {
		Source	.SeleniumHelper().setText(NewPassword, newpw);
		return this;
	}
	
	public ChangePasswordPage setConfirmPassword(String newpw) {
		Source	.SeleniumHelper().setText(ConfirmNewPassword, newpw);
		return this;
	}
}
