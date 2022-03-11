package com.eisrem.pageFactory.QuickLinks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.Administrator.RolesPage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.ServicePopulationsAvailableAccord;

public class QuickLinksPage extends QuickLinksNavigator{

	public QuickLinksPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[contains(text(),'Add Quick Links')]")
	public WebElement AddQuickLinksTitle;
	
	@FindBy(xpath="//p[@class='required-note']")
	public WebElement NoteTitle;
	
	@FindBy(xpath="//a[contains(text(),'Link')]")
	public WebElement LinkAccord;
	
	@FindBy(xpath="//a[@href='#link-tab-pane']")
	public WebElement LinkTab;
				
	@FindBy(xpath="//label[@for='name']")
	public WebElement DisplayedNameTitle;
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement DisplayedNameTextBox;
		
	@FindBy(xpath="//label[@for='linkUrl']")
	public WebElement LinkURLTitle;
	
	@FindBy(xpath="//input[@id='linkUrl']")
	public WebElement LinkURLTextBox;
	
	@FindBy(xpath="//button[contains(text(),'Submit & Exit')]")
	public WebElement SubmitExitBtn;
		
	public String readAddQuickLinksTitle() {
		return Source.SeleniumHelper().readElement(AddQuickLinksTitle);
	}
	
	public String readNoteTitle() {
		return Source.SeleniumHelper().readElement(NoteTitle);
	}
	
	public String readLinkTitle() {
		return Source.SeleniumHelper().readElement(LinkAccord);
	}
	
	public QuickLinksPage clickLinkTitle() {
		Source.SeleniumHelper().clickElement(LinkAccord);
		return this;
	}
	
	public String readLinkTabTitle() {
		return Source.SeleniumHelper().readElement(LinkTab);
	}
	
	public String readLinkDisplayedNameTitle() {
		return Source.SeleniumHelper().readElement(DisplayedNameTitle);
	}
	
	public QuickLinksPage setDisplayedName(String DisplayedName, String... clear) {
		Source.SeleniumHelper().setText(DisplayedNameTextBox, DisplayedName + Keys.TAB, clear);
		return new QuickLinksPage(DriverFactory.getDriver());
	}
	
	public String readLinkUrlTitle() {
		return Source.SeleniumHelper().readElement(LinkURLTitle);
	}
	
	public QuickLinksPage setLinkURL(String URL, String... clear) {
		Source.SeleniumHelper().setText(LinkURLTextBox, URL + Keys.TAB, clear);
		return new QuickLinksPage(DriverFactory.getDriver());
	}
	
	public String readLinkURLValue() {
		return Source.SeleniumHelper().readAttribute(LinkURLTextBox, "last-val");
	}

	public String readSubmitExitBtn() {
		return Source.SeleniumHelper().readElement(SubmitExitBtn);
	}
	
	public QuickLinksPage clickSubmitExit() {
		Source.SeleniumHelper().clickElement(SubmitExitBtn);
		return this;
	}
	
}
