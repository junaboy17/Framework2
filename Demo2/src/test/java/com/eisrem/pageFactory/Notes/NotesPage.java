package com.eisrem.pageFactory.Notes;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.FormPage;
import com.eisrem.pageFactory.MyHomePage.MyHomePage;

public class NotesPage extends NotesNavigator{

	public NotesPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	//Add Notes

	@FindBy(xpath="//select[@id='type']")
	public WebElement NotesTypeDropDown;

	@FindBy(xpath="//select[@id='type']")
	public List<WebElement> NotesTypeValues;

	@FindBy(xpath="//select[@id='user-loc']")
	public WebElement OrganizationDropDown;

	@FindBy(xpath="//input[@id='typeConductorName']")
	public WebElement TitleTextBox;

	@FindBy(xpath="//button[@id='startButton']")
	public WebElement StartNotesBtn;


	public NotesPage selectNotesType(String NotesType) {
		Source.SeleniumHelper().select(NotesTypeDropDown, NotesType);
		return this;
	}

	public NotesPage selectNotesType(int NotesType) {
		Source.SeleniumHelper().select(NotesTypeDropDown, NotesType);
		return this;
	}

	public NotesPage selectOrganization(int organization) {
		Source.SeleniumHelper().select(OrganizationDropDown, organization);
		return this;
	}

	public NotesPage setTitle(String title, String... clear) {
		Source.SeleniumHelper().setText(TitleTextBox, title, clear);
		return this;
	}

	public FormPage clickStartNotes() {
		Source.SeleniumHelper().getWebElement(StartNotesBtn).click();
		return new FormPage(DriverFactory.getDriver());
	}

}
