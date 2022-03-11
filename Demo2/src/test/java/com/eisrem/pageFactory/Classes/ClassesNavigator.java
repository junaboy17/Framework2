package com.eisrem.pageFactory.Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class ClassesNavigator extends DataTable{


	public ClassesNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@id='36_Classes_tab']")
	public WebElement ClassesTab;
	
	@FindBy(xpath="//li[@id='38_ClassesSchedule_tab']")
	public WebElement ScheduleTab;
	
	@FindBy(xpath="//li[@id='37_ClassesRoster_tab']")
	public WebElement RosterTab;
	
	@FindBy(xpath="//li[@id='41_ClassesOutcome_tab']")
	public WebElement OutcomeTab;
	
	@FindBy(xpath="//li[@id='39_ClassesAttendance_tab']")
	public WebElement AttendanceTab;
		
	public String readClassesTab() {
		return Source.SeleniumHelper().readElement(ClassesTab);
	}
	
	public ClassesPage clickClasses() {
		Source.SeleniumHelper().clickElement(ClassesTab);
		return new ClassesPage(DriverFactory.getDriver());
	}
	
	public String readScheduleTab() {
		return Source.SeleniumHelper().readElement(ScheduleTab);
	}
	
	public ClassesPage clickSchedule() {
		Source.SeleniumHelper().clickElement(ScheduleTab);
		return new ClassesPage(DriverFactory.getDriver());
	}
	
	public String readRosterTab() {
		return Source.SeleniumHelper().readElement(RosterTab);
	}
	
	public ClassesPage clickRoster() {
		Source.SeleniumHelper().clickElement(RosterTab);
		return new ClassesPage(DriverFactory.getDriver());
	}
	
	public String readOutcomeTab() {
		return Source.SeleniumHelper().readElement(OutcomeTab);
	}
	
	public ClassesPage clickOutcome() {
		Source.SeleniumHelper().clickElement(OutcomeTab);
		return new ClassesPage(DriverFactory.getDriver());
	}
	
	public String readAttendanceTab() {
		return Source.SeleniumHelper().readElement(AttendanceTab);
	}
	
	public ClassesPage clickAttendance() {
		Source.SeleniumHelper().clickElement(AttendanceTab);
		return new ClassesPage(DriverFactory.getDriver());
	}
	
}
