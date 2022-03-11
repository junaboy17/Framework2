package com.eisrem.pageFactory.ReportableEvent;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.CommonPage.FormPage;
import com.eisrem.pageFactory.ReportableEvent.ReportableEventPage;

public class ReportableEventPage extends ReportableEventNavigator{

	public ReportableEventPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	//Add Reportable Event

	@FindBy(xpath="//select[@id='type']")
	public WebElement ReportableEventTypeDropDown;

	@FindBy(xpath="//select[@id='type']")
	public List<WebElement> ReportableEventTypeValues;

	@FindBy(xpath="//select[@id='user-loc']")
	public WebElement OrganizationDropDown;

	@FindBy(xpath="//input[@id='typeConductorName']")
	public WebElement TitleTextBox;

	@FindBy(xpath="//textarea[@id='typeConductorDesc']")
	public WebElement DescriptionTextBox;

	@FindBy(xpath="//button[@id='startButton']")
	public WebElement StartReportableEventBtn;

	@FindBy(xpath="//button[@id='typeConductorSubmit']")
	public WebElement SubmitBtn;

	@FindBy(xpath="//div[@class='tab-pane type-page type-page-render active in']//button[contains(text(), 'Submit All Pages')]")
	public WebElement SubmitAllPagesBtn;
	
	@FindBy(xpath = "//div[@id='maincontent2']/h1")
	public WebElement ReportableEventsChildTitle;



	public ReportableEventPage selectReportableEventType(String ReportableEventType) {
		Source.SeleniumHelper().select(ReportableEventTypeDropDown, ReportableEventType);
		return this;
	}

	public ReportableEventPage selectReportableEventType(int ReportableEventType) {
		Source.SeleniumHelper().select(ReportableEventTypeDropDown, ReportableEventType);
		return this;
	}

	public ReportableEventPage selectOrganization(int organization) {
		Source.SeleniumHelper().select(OrganizationDropDown, organization);
		return this;
	}

	public ReportableEventPage setTitle(String title, String... clear) {
		Source.SeleniumHelper().setText(TitleTextBox, title, clear);
		return this;
	}

	public ReportableEventPage setDescription(String description, String... clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, description, clear);
		return this;
	}

	public FormPage clickStartReportableEvent() {
		Source.SeleniumHelper().clickElement(StartReportableEventBtn);
		return new FormPage(DriverFactory.getDriver());
	}

	public ReportableEventPage clickSubmit() {
		Source.SeleniumHelper().clickElement(SubmitBtn);
		return this;
	}
	
	public String readReportableEventsTitle() {
		return Source.SeleniumHelper().readElement(ReportableEventsChildTitle);
		
	}
	
	public ReportableEventPage setText(String TextBoxName, String Text, String... Clear ) {
		By TextBox = By.xpath("//textarea[@name = '" + TextBoxName + "']");
		Source.SeleniumHelper().setText(TextBox, Text, Clear);
		return this;
	}


}
