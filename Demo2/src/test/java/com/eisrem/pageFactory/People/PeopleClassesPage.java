package com.eisrem.pageFactory.People;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.Classes.ClassesPage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.Pagefactory;
import com.eisrem.pageFactory.Reports.ReportsPage;

public class PeopleClassesPage extends DataTable{

	public PeopleClassesPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='class-combobox']")
	public WebElement ClassTypeTextBox;

	@FindBy(xpath="//input[@id='processedDate']")
	public WebElement PaymentProcessDateTeXtBox;

	@FindBy(xpath="//input[@id='paymentConfirmationNumber']")
	public WebElement PaymentConfirmationNumberTextBox;
	
	@FindBy(xpath="//label[contains(text(),'Payment Processed?')]")
	public WebElement PaymentProcessedToggleTitle;

	@FindBy(xpath="//label[contains(text(),'Payment')]/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement PaymentProcessedToggle;

	@FindBy(xpath="//label[contains(text(),'Payment')]/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement PaymentProcessedToggleAttribute;
	
	@FindBy(xpath="//textarea[@id='desc']")
	public WebElement NotesTestBox;
	
	@FindBy(xpath="//button[contains(@class,'multiselect dropdown')]")
	public WebElement SpecialAccomodationsDropDown;

	@FindBy(xpath="//button[contains(text(),'Submit & Exit')]")
	public WebElement SubmitExitBtn;

	@FindBy(xpath="//button[contains(text(),'Back To Classes')]")
	public WebElement BackToClassesBtn;
	
	
	@FindBy(xpath="//ul[@class='typeahead typeahead-long dropdown-menu']//li")
	public WebElement FirstClassOption ;
	
	public String readPaymnetProcessToggleTitle() {
		return Source.SeleniumHelper().readElement(PaymentProcessedToggleTitle);
	}

	public String readPaymentProcessedToggle() {
		return PaymentProcessedToggleAttribute.getAttribute("last-val");
	}

	public PeopleClassesPage clickPaymentProcessedToggle() {
		Source.SeleniumHelper().clickElement(PaymentProcessedToggle);
		return this;
	}

	public PeopleClassesPage clickPaymentProcessedToggle(String value) {
		String lock = readPaymentProcessedToggle();

		if(value.equalsIgnoreCase(lock)) {

		}
		else {
			clickPaymentProcessedToggle();
		}
		return this;
	}

	public PeopleClassesPage clickSpecialAccomodations() {
		Source.SeleniumHelper().clickElement(SpecialAccomodationsDropDown);
		return this;
	}

	public PeopleClassesPage clickSubmitExit() {
		Source.SeleniumHelper().clickElement(SubmitExitBtn);
		return this;	
	}

	public PeopleClassesPage clickBackToClasses() {
		Source.SeleniumHelper().clickElement(BackToClassesBtn);
		return this;
	}
	
	public PeopleClassesPage setClassType(String className,String... Clear) {
		Source.SeleniumHelper().setText(ClassTypeTextBox, className, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	public PeopleClassesPage setPaymentProcessDate(String date,String... Clear) {
		Source.SeleniumHelper().setText(PaymentProcessDateTeXtBox, date + Keys.TAB, Clear);	
		return this;
	}
	
	public PeopleClassesPage setPaymentConfirmationNumber(String ConfirmationNumber,String... Clear) {
		Source.SeleniumHelper().setText(PaymentConfirmationNumberTextBox, ConfirmationNumber, Clear);	
		return this;
	}
	

	public PeopleClassesPage setNotes(String notes, String... Clear) {
		Source.SeleniumHelper().setText(NotesTestBox, notes, Clear);	
		return this;
	}
	
	public PeopleClassesPage clicFirstClass() {
		Source.SeleniumHelper().clickElement(FirstClassOption);
		return this;	
	}
	
}
