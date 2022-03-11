package com.eisrem.pageFactory.CommonPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.pageFactory.Administrator.NotificationsPage;

public class WhoAccord extends NotificationsPage{

	public WhoAccord(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@id='who-startdate']")
	public WebElement StartDateTextBox;

	@FindBy(xpath="//input[@id='who-enddate']")
	public WebElement EndDateTextBox;

	@FindBy(xpath="//select[@id='role']")
	public WebElement RoleDropdown;

	@FindBy(xpath="//select[@id='who-service-population']")
	public WebElement ServicePopulationDropdwon;

	@FindBy(xpath="//input[@id='who-user-combobox']")
	public WebElement UserTextBox;

	@FindBy(xpath="//select[@id='relationshipType']")
	public WebElement NameTypeDropdown;

	@FindBy(xpath="//button[contains(text(),'Complete')]")
	public WebElement WhoRecipientCompleteBtn;

	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	public WebElement CancelBtn;

	@FindBy(xpath="//textarea[@id='who-desc']")
	public WebElement DecriptionTextBox;

	@FindBy(xpath="//div[@id='Who-tab-pane']//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper')]")
	public WebElement ActiveToggle;

	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	public WebElement CancleBtn;

	public WhoAccord setStartDate(String value, String... Clear) {
		Source.SeleniumHelper().setText(StartDateTextBox, value, Clear);
		return this;
	}

	public WhoAccord setEndDate(String value, String... Clear) {
		Source.SeleniumHelper().setText(EndDateTextBox, value, Clear);
		return this;
	}

	public WhoAccord selectRole(int index) {
		Source.SeleniumHelper().select(RoleDropdown, index);
		return this;
	}
	
	public WhoAccord selectRole(String index) {
		Source.SeleniumHelper().select(RoleDropdown, index);
		return this;
	}

	public WhoAccord selectServicePopulation(int index) {
		Source.SeleniumHelper().select(ServicePopulationDropdwon, index);
		return this;
	}

	public WhoAccord setUser(String value, String... Clear) {
		Source.SeleniumHelper().setText(UserTextBox, value, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}

	public WhoAccord searchForUser(String value, String... Clear) {
		Source.SeleniumHelper().setText(UserTextBox, value, Clear);
		Source.SeleniumHelper().sleep(1);
		return this;
	}

	public WhoAccord selectType(int index) {
		Source.SeleniumHelper().select(NameTypeDropdown, index);
		return this;
	}

	public WhoAccord setDecription(String description, String... Clear) {
		Source.SeleniumHelper().setText(DecriptionTextBox, description, Clear);
		return this;
	}

	public WhoAccord clickActiveToggle() {
		Source.SeleniumHelper().clickElement(ActiveToggle);
		return this;
	}

	public WhoAccord clickCancle() {
		Source.SeleniumHelper().clickElement(CancleBtn);
		return this;
	}

}
