package com.eisrem.pageFactory.People;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.Admin.LogInPage;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class LanguagePage extends PeopleNavigator{


	public LanguagePage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h4//a[contains(text(),'Language')]")
	public WebElement LanguageLink;

	@FindBy(xpath="//label[@for='primLang']")
	public WebElement PrimaryLanguageTitle;

	@FindBy(xpath="//select[@id='primLang']")
	public WebElement PrimaryLanguageDropDown;

	@FindBy(xpath="//label[@for='engProf']")
	public WebElement EnglishProficiencyTitle;

	@FindBy(xpath="//select[@id='engProf']")
	public WebElement EnglishProficiencyDropDown;

	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement SubmitBtn;

	@FindBy(xpath="//button[contains(text(),'Print')]")
	public WebElement PrintBtn;

	@FindBy(xpath="//button[contains(text(),'Back To People')]")
	public WebElement BackToPeopleBtn;


	public String readLanguageTabTitle() {
		return Source.SeleniumHelper().readElement(LanguageLink);
	}

	public LanguagePage clickLanguageAccord() {
		Source.SeleniumHelper().clickElement(LanguageLink);
		return this;
	}

	public String readPrimaryLanguageTitle() {
		return Source.SeleniumHelper().readElement(PrimaryLanguageTitle);
	}

	public String readEnglishProficiencyValue() {
		return Source.SeleniumHelper().readAttribute(EnglishProficiencyDropDown, "value");
	}
	
	public String readEnglishProficiencyTitle() {
		return Source.SeleniumHelper().readElement(EnglishProficiencyTitle);
	}

	public String readPrimaryLanguageValue() {
		return Source.SeleniumHelper().readAttribute(PrimaryLanguageDropDown, "value");
	}
	
	public LanguagePage selectEnglishProficiency(int value) {
		Source.SeleniumHelper().select(EnglishProficiencyDropDown, value);
		return this;
	}

	public LanguagePage selectPrimaryLanguage(int value) {
		Source.SeleniumHelper().select(PrimaryLanguageDropDown, value);
		return this;
	}
	
	public LanguagePage selectPrimaryLanguage(String value) {
		Source.SeleniumHelper().select(PrimaryLanguageDropDown, value);
		return this;
	}

	public String readSubmitBtn() {
		return Source.SeleniumHelper().readElement(SubmitBtn);
	}

	public DataTable clickSubmit() {
		Source.SeleniumHelper().clickElement(SubmitBtn);
		return new DataTable(DriverFactory.getDriver());
	}

	public String readPrintBtn() {
		return Source.SeleniumHelper().readElement(PrintBtn);
	}

	public LanguagePage clickPrint() {
		Source.SeleniumHelper().clickElement(PrintBtn);
		return this;
	}

	public String readBackToPeopleBtn() {
		return Source.SeleniumHelper().readElement(BackToPeopleBtn);
	}

	public LanguagePage clickBackToPeople() {
		Source.SeleniumHelper().clickElement(BackToPeopleBtn);
		return this;
	}
	
	public LanguagePage FillLanguage() {
				 selectPrimaryLanguage(Language.AMHARIC.getIndex())
				.selectEnglishProficiency(EnglishProficiency.NOT_PROFICIENT.getIndex());
		return this;
	}
	
	public LanguagePage FillLanguage(int PrimaryLanguage, int EnglishProficiency) {
				 selectPrimaryLanguage(PrimaryLanguage)
				.selectEnglishProficiency(EnglishProficiency);
		return this;
	}

}
