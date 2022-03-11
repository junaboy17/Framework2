package com.eisrem.pageFactory.Notes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.Classes.ClassesPage;
import com.eisrem.pageFactory.CommonPage.ConductedTypes;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.MyHomePage.MyHomePage;

public class NotesNavigator extends ConductedTypes{

	public NotesNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[contains(text(),'Notes')]")
	public WebElement NotesTab;
	
	public String readNotesTab() {
		return Source.SeleniumHelper().readElement(NotesTab);
	}
	
	public NotesNavigator clickNotesTab() {
		Source.SeleniumHelper().clickElement(NotesTab);
		return this;
	}
	
}
