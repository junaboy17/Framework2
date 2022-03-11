package com.eisrem.pageFactory.Classes;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class SchedulePage extends ClassesNavigator{


	public SchedulePage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[contains(text(),'Schedule')]")
	public WebElement PageTitle;
	
	@FindBy(xpath="//a[contains(text(),'Schedule')]")
	public WebElement ScheduleAccord;
	
	@FindBy(xpath="//label[@for='classDate']")
	public WebElement ClassDateTitle;
	
	@FindBy(xpath="//input[@id='classDate']")
	public WebElement ClassDateTextBox;
	
	@FindBy(xpath="//label[@for='classTime']")
	public WebElement ClassStartTimeTitle;
	
	//Start time
	@FindBy(xpath="//input[@id='classTime']/..//select[@class='form-control tp-hour']")
	public WebElement StartTimeHrDropDown;
	
	@FindBy(xpath="//input[@id='classTime']/..//select[@class='form-control tp-minute']")
	public WebElement StartTimeMinDropDown;
	
	@FindBy(xpath="//input[@id='classTime']/..//select[@class='form-control tp-second']")
	public WebElement StartTimeSecDropDown;
	
	@FindBy(xpath="//input[@id='classTime']/..//select[@class='form-control tp-ampm']")
	public WebElement StartTimeAmPmDropDown;
	
	//End time
	@FindBy(xpath="//label[@for='classEndTime']")
	public WebElement ClassEndTimeTitle;
	
	@FindBy(xpath="//input[@id='classEndTime']/..//select[@class='form-control tp-hour']")
	public WebElement EndTimeHrDropDown;
	
	@FindBy(xpath="//input[@id='classEndTime']/..//select[@class='form-control tp-minute']")
	public WebElement EndTimeMinDropDown;
	
	@FindBy(xpath="//input[@id='classEndTime']/..//select[@class='form-control tp-second']")
	public WebElement EndTimeSecDropDown;
	
	@FindBy(xpath="//input[@id='classEndTime']/..//select[@class='form-control tp-ampm']")
	public WebElement EndTimeAmPmDropDown;
	
	
	
	
	public String readPageTitle() {
		return Source.SeleniumHelper().readElement(PageTitle);
	}
	
	public String readScheduleAccord() {
		return Source.SeleniumHelper().readElement(ScheduleAccord);
	}
	
	public String readClassDateTitle() {
		return Source.SeleniumHelper().readElement(ClassDateTitle);
	}	
	
	public SchedulePage setClassDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(ClassDateTextBox, date + Keys.TAB, Clear);
		return this;
	}
	
	public String readClassStartTimeTitle() {
		return Source.SeleniumHelper().readElement(ClassStartTimeTitle);
	}	
	
	public SchedulePage selectStartTimeHr(int index) {
		Source.SeleniumHelper().select(StartTimeHrDropDown, index);
		return this;
	}
	
	public SchedulePage selectStartTimeHr(String value) {
		Source.SeleniumHelper().select(StartTimeHrDropDown, value);
		return this;
	}
	
	public SchedulePage selectStartTimeMin(int index) {
		Source.SeleniumHelper().select(StartTimeMinDropDown, index);
		return this;
	}
	
	public SchedulePage selectStartTimeMin(String value) {
		Source.SeleniumHelper().select(StartTimeMinDropDown, value);
		return this;
	}
	
	public SchedulePage selectStartTimeSec(int index) {
		Source.SeleniumHelper().select(StartTimeSecDropDown, index);
		return this;
	}
	
	public SchedulePage selectStartTimeSec(String value) {
		Source.SeleniumHelper().select(StartTimeSecDropDown, value);
		return this;
	}
	
	
	public SchedulePage selectStartTimeAmPm(int index) {
		Source.SeleniumHelper().select(StartTimeAmPmDropDown, index);
		return this;
	}
	
	public SchedulePage selectStartTimeAmPm(String value) {
		Source.SeleniumHelper().select(StartTimeAmPmDropDown, value);
		return this;
	}
	
	
	public String readClassEndTimeTitle() {
		return Source.SeleniumHelper().readElement(ClassEndTimeTitle);
	}
	
	public SchedulePage selectEndTimeHr(int index) {
		Source.SeleniumHelper().select(EndTimeHrDropDown, index);
		return this;
	}
	
	public SchedulePage selectEndTimeHr(String value) {
		Source.SeleniumHelper().select(EndTimeHrDropDown, value);
		return this;
	}
	
	public SchedulePage selectEndTimeMin(int index) {
		Source.SeleniumHelper().select(EndTimeMinDropDown, index);
		return this;
	}
	
	public SchedulePage selectEndTimeMin(String value) {
		Source.SeleniumHelper().select(EndTimeMinDropDown, value);
		return this;
	}
	
	public SchedulePage selectEndTimeSec(int index) {
		Source.SeleniumHelper().select(EndTimeSecDropDown, index);
		return this;
	}
	
	public SchedulePage selectEndTimeSec(String value) {
		Source.SeleniumHelper().select(EndTimeSecDropDown, value);
		return this;
	}
	
	public SchedulePage selectEndTimeAmPm(int index) {
		Source.SeleniumHelper().select(EndTimeAmPmDropDown, index);
		return this;
	}
	
	public SchedulePage selectEndTimeAmPm(String value) {
		Source.SeleniumHelper().select(EndTimeAmPmDropDown, value);
		return this;
	}
	
	public SchedulePage selectStartTime(int Hr, int Min, int Sec, int AmPm) {
		selectStartTimeHr(Hr);
		selectStartTimeMin(Min);
		selectStartTimeSec(Sec);
		selectStartTimeAmPm(AmPm);
		return this;
	}
	
	public SchedulePage selectStartTime(String Hr, String Min, String Sec, String AmPm) {
		selectStartTimeHr(Hr);
		selectStartTimeMin(Min);
		selectStartTimeSec(Sec);
		selectStartTimeAmPm(AmPm);
		return this;
	}
	
	public SchedulePage selectEndTime(int Hr, int Min, int Sec, int AmPm) {
		selectEndTimeHr(Hr);
		selectEndTimeMin(Min);
		selectEndTimeSec(Sec);
		selectEndTimeAmPm(AmPm);
		return this;
	}
	
	public SchedulePage selectEndTime(String Hr, String Min, String Sec, String AmPm) {
		selectEndTimeHr(Hr);
		selectEndTimeMin(Min);
		selectEndTimeSec(Sec);
		selectEndTimeAmPm(AmPm);
		return this;
	}
	
	
}
