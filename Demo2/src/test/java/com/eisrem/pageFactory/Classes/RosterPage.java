package com.eisrem.pageFactory.Classes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.Pagefactory;
import com.eisrem.pageFactory.Organization.AdditionalOrgLocAccord;

public class RosterPage extends ClassesNavigator{


	public RosterPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h3[contains(text(),'Roster')]")
	public WebElement PageTitle;
	
	@FindBy(xpath="//a[contains(text(),'Roster')]")
	public WebElement RosterAccord;
	
	@FindBy(xpath="//label[contains(text(),'Member')]")
	public WebElement TypeOfMemberTitle;
	
	@FindBy(xpath="//select[@id='rosterType']")
	public WebElement TypeOfMemberDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Processed Date')]")
	public WebElement PaymentProcessedDateTitle;
	
	@FindBy(xpath="//input[@id='processedDate']")
	public WebElement PaymentProcessedDateTextBox;
	
	@FindBy(xpath="//label[contains(text(),'Payment Confirmation Number')]")
	public WebElement PaymentConfirmationTitle;
	
	@FindBy(xpath="//input[@id='paymentConfirmationNumber']")
	public WebElement PaymentConfirmationTextBox;
	
	@FindBy(xpath="//label[contains(text(),'Payment Processed?')]")
	public WebElement PaymentProcessedToggleTitle;
	
	@FindBy(xpath="//label[contains(text(),'Payment')]/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement PaymentProcessedToggle;

	@FindBy(xpath="//label[contains(text(),'Payment')]/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement PaymentProcessedToggleAttribute;
	
	@FindBy(xpath="//label[@id='specialAccomodations-label']")
	public WebElement SpecialAccomodationsTitle;
	
	@FindBy(xpath="//button[@class = 'multiselect dropdown-toggle btn btn-default']")
	public WebElement SpecialAccomodationsBtn;
	
	@FindBy(xpath="//ul[@class='multiselect-container dropdown-menu']//li[1]//input")
	public WebElement SpecialAccomdationsOption1;

	//	
	public String readPageTitle() {
		return Source.SeleniumHelper().readElement(PageTitle);
	}
	
	public String readRosterAccord() {
		return Source.SeleniumHelper().readElement(RosterAccord);
	}
	
	public RosterPage clickRosterAccord() {
		Source.SeleniumHelper().clickElement(RosterAccord);
		return this;
	}
	
	public String readTypeOfMemberTitle() {
		return Source.SeleniumHelper().readElement(TypeOfMemberTitle);
	}
	
	public RosterPage selectTypeOfMemberDropDown(int index) {
		Source.SeleniumHelper().select(TypeOfMemberDropDown, index);
		return this;
	}
	
	public RosterPage selectTypeOfMemberDropDown(String value) {
		Source.SeleniumHelper().select(TypeOfMemberDropDown, value);
		return this;
	}
	
	public String readPaymentProcessedDateTitle() {
		return Source.SeleniumHelper().readElement(PaymentProcessedDateTitle);
	}
	
	public RosterPage setPaymentProcessedDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(PaymentProcessedDateTextBox, date + Keys.TAB, Clear);
		return this;
	}
	
	public String readPaymentConfirmationTitle() {
		return Source.SeleniumHelper().readElement(PaymentConfirmationTitle);
	}
	
	public RosterPage setPaymentConfirmationNum(String confirmationNum, String... Clear) {
		Source.SeleniumHelper().setText(PaymentConfirmationTextBox, confirmationNum + Keys.TAB, Clear);
		return this;
	}
	
	public String readPaymentProcessedToggleTitle() {
		return Source.SeleniumHelper().readElement(PaymentProcessedToggleTitle);
	}
	
	public RosterPage clickPaymentProcessedToggle() {
		Source.SeleniumHelper().clickElement(PaymentProcessedToggle);
		return this;
	}

	public String readPaymentProcessedToggle() {
		return PaymentProcessedToggleAttribute.getAttribute("last-val");
	}

	public RosterPage clickPaymentProcessedToggle(String value) {
		String active = readPaymentProcessedToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickPaymentProcessedToggle();
		}
		return this;
	}
		
	public String SpecialAccomodationsTitle() {
		return Source.SeleniumHelper().readElement(SpecialAccomodationsTitle);
	}
	
	public RosterPage chooseFirstSpecialAccomdations() {
		Source.SeleniumHelper().clickElement(SpecialAccomodationsBtn);
		Source.SeleniumHelper().clickElement(SpecialAccomdationsOption1);
		return this;
	}
	
	public RosterPage chooseSpecialAccomdations(String Accomodations) {
		By Accomodation = By.xpath("//label[contains(text(), '" + Accomodations + "')]//input");
		Source.SeleniumHelper().clickElement(SpecialAccomodationsBtn);
		Source.SeleniumHelper().clickElement(Accomodation);
		return this;
	}
	

	
}
