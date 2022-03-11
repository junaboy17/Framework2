package com.eisrem.pageFactory.Classes;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.Administrator.RolesPage;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class ClassesPage extends ClassesNavigator{
	public ClassesPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[contains(text(),'Add Classes')]")
	public WebElement AddClassesTitle;
	
	@FindBy(xpath="//p[@class='required-note']")
	public WebElement NoteTitle;
	
	@FindBy(xpath="//a[contains(text(),'Classes')]")
	public WebElement ClassesLink;
				
	@FindBy(xpath="//label[@for='classes-name']")
	public WebElement ClassNameTitle;
	
	@FindBy(xpath="//input[@id='classes-name']")
	public WebElement ClassNameTextBox;
		
	@FindBy(xpath="//label[@for='classes-seatsAvailable']")
	public WebElement SeatsAvailableTitle;
	
	@FindBy(xpath="//input[@id='classes-seatsAvailable']")
	public WebElement SeatsAvailableTextBox;
	
	@FindBy(xpath="//label[@for='classes-seatsTaken']")
	public WebElement SeatsTakenTitle;
	
	@FindBy(xpath="//input[@id='classes-seatsTaken']")
	public WebElement SeatsTakenTextBox;
	
	@FindBy(xpath="//label[@for='classes-servicePopulation']")
	public WebElement ServicePopulationTitle;
	
	@FindBy(xpath="//select[@id='classes-servicePopulation']")
	public WebElement ServicePopulationDropDown; 
	
	@FindBy(xpath="//label[@for='programType']")
	public WebElement ProgramTypeTitle;
	
	@FindBy(xpath="//select[@id='programType']")
	public WebElement ProgramTypeDropDown;
	
	@FindBy(xpath="//label[@for='loc']")
	public WebElement OrganizationLocationTitle;
	
	@FindBy(xpath="//select[@id='loc']")
	public WebElement OrganizationLocationDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Out of State?')]")
	public WebElement OutOfStateBtn;
	
	@FindBy(xpath="//div[3]/div[1]//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper')]")
	public WebElement OutOfStateToggleTemp;
	
	@FindBy(xpath="//div[3]/div[1]//div[contains(@class,'bootstrap-switch bootstrap-switch-wrapper')]//input")
	public WebElement OutOfStateToggleAttributeTemp;
	
	@FindBy(xpath="//label[contains(text(),'Out Of State')]")
	public WebElement OutOfStateToggleTitle;

	@FindBy(xpath="//label[contains(text(),'Out Of State')]/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement OutOfStateToggle;

//	@FindBy(xpath="//label[contains(text(),'Out Of State')]/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
//	public WebElement OutOfStateToggleAttribute;
	
	@FindBy(xpath="//div[@class='row'][3]//div[@class='bootstrap-switch-container']//input")
	public WebElement OutOfStateYesNoBtnAttribute;
				
	@FindBy(xpath="//button[contains(text(),'Go back to List')]")
	public WebElement GoBackToListBtn;
		
	public String readAddClassesTitle() {
		return Source.SeleniumHelper().readElement(AddClassesTitle);
	}
	
	public String readNoteTitle() {
		return Source.SeleniumHelper().readElement(NoteTitle);
	}
	
	public String readClassesLinkTitle() {
		return Source.SeleniumHelper().readElement(ClassesLink);
	}
	
	public ClassesPage clickClassesLinkTitle() {
		Source.SeleniumHelper().clickElement(ClassesLink);
		return this;
	}
	
	public String readClassNameTitle() {
		return Source.SeleniumHelper().readElement(ClassNameTitle);
	}
	
	public String readSeatsAvailableTitle() {
		return Source.SeleniumHelper().readElement(SeatsAvailableTitle);
	}
	
	public String readSeatsTakenTitle() {
		return Source.SeleniumHelper().readElement(SeatsTakenTitle);
	}
	
	public String readServicePopulationTitle() {
		return Source.SeleniumHelper().readElement(ServicePopulationTitle);
	}
	
	public String readProgramTypeTitle() {
		return Source.SeleniumHelper().readElement(ProgramTypeTitle);
	}
	
	public String readOrganizationLocationTitle() {
		return Source.SeleniumHelper().readElement(OrganizationLocationTitle);
	}
	
	public String readOutOfStateTitle() {
		return Source.SeleniumHelper().readElement(OutOfStateBtn);
	}
	
	public ClassesPage clickOutOfStateToggle() {
		Source.SeleniumHelper().clickElement(OutOfStateToggleTemp);
		return new ClassesPage(DriverFactory.getDriver());
	}
	
	public String readOutOfStateToggle() {
		return OutOfStateToggleAttributeTemp.getAttribute("last-val");
	}
	
	public ClassesPage setClassName(String name,String... Clear) {
		Source.SeleniumHelper().setText(ClassNameTextBox, name, Clear);	
		return this;
	}
	
	public ClassesPage setSeatsAvailable(String seat, String... Clear) {
		Source.SeleniumHelper().setText(SeatsAvailableTextBox, seat, Clear);	
		return this;
	}
	
	public ClassesPage selectServicePopulation(int servicePopulation) {
		Source.SeleniumHelper().select(ServicePopulationDropDown, servicePopulation);	
		return this;
	}
	
	public ClassesPage selectProgramType(int programTypeDropDown) {
		Source.SeleniumHelper().select(ProgramTypeDropDown, programTypeDropDown);	
		return this;
	}
	
	public ClassesPage selectOrganizationLocation(int organizationLocationDropDown) {
		Source.SeleniumHelper().select(OrganizationLocationDropDown, organizationLocationDropDown);	
		return this;
	}

}
