package com.eisrem.pageFactory.CommonPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * This page is used by both people and organizations
 */
public class DocumentsUserPage extends DataTable{

	public DocumentsUserPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//label[contains(@for,'documentUser-startdate')]")
	public WebElement DocumentUserStartDateTitle;

	@FindBy(xpath="//input[contains(@id,'documentUser-startdate')]")
	public WebElement DocumentUserStartDateTextBox;

	@FindBy(xpath="//label[contains(@for,'documentUser-enddate')]")
	public WebElement DocumentUserEndDateTitle;

	@FindBy(xpath="//input[contains(@id,'documentUser-enddate')]")
	public WebElement DocumentUserEndDateTextBox;
	
	@FindBy(xpath="//input[@id='documentUser-user-combobox']")
	public WebElement DocumentUserComboBox;
	
	public DocumentsUserPage setUser(String value, String... Clear) {
		Source.SeleniumHelper().setText(DocumentUserComboBox, value, Clear);
		Source.SeleniumHelper().sleep(2);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public String readStartDateTitle() {
		return Source.SeleniumHelper().readElement(DocumentUserStartDateTitle);
	}

	public DocumentsUserPage setStartDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(DocumentUserStartDateTextBox, date + Keys.TAB, Clear);
		return this;
	}

	public String readStartDateValue() {
		return Source.SeleniumHelper().getWebElement(DocumentUserStartDateTextBox).getAttribute("original-val");
	}

	public String readEndDateTitle() {
		return Source.SeleniumHelper().readElement(DocumentUserEndDateTitle);
	}

	public DocumentsUserPage setEndDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(DocumentUserEndDateTextBox, date + Keys.TAB, Clear);
		return this;
	}
	
	public String readEndDateValue() {
		return Source.SeleniumHelper().getWebElement(DocumentUserEndDateTextBox).getAttribute("original-val");
	}


}
