package com.eisrem.pageFactory.People;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.SetConditionsAccord;

public class DiagnosisPage extends PeopleNavigator{

	public DiagnosisPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	
	//	@FindBy(xpath="//h3[contains(text(),'Add Association')]")
	//	public WebElement AddAssociationTitle;	
	//
	//	@FindBy(xpath="//p[@class='required-note']")
	//	public WebElement NoteTitle;



	//	public String readBackToAssociationBtn() {
	//		return Source.SeleniumHelper().getWebElement(BackToAssociationBtn).getText();
	//	}
	//
	//	public EnrollmentStatusPage clickBackToAssociation() {
	//		Source.SeleniumHelper().getWebElement(BackToAssociationBtn).click();
	//		return this;
	//	}

	@FindBy(xpath="//input[@id='otherDx']")
	public WebElement OtherDiagnosisTextBox;
	
	//Will read
	public String readDiagnosisTitle(String DiagnosisTitle) {
		By data = By.xpath("//label[contains(text(),'" + DiagnosisTitle + "')]");
		return Source.SeleniumHelper().readElement(data);
	}
	
	public String readDiagnosisAttribute(String Attribute) {
		return Source.SeleniumHelper().getWebElement(By.xpath("//label[contains(text(),'Primary Diagnosis')]/../div/div/div//input")).getAttribute(Attribute);
	}
	
	public String readDiagnosisStartDateAttribute(String Attribute) {
		return Source.SeleniumHelper().getWebElement(By.xpath("//label[contains(text(),'Primary Diagnosis')]/../../div[2]//input")).getAttribute(Attribute);
	}
	
	public String readDiagnosisEndDateAttribute(String Attribute) {
		return Source.SeleniumHelper().getWebElement(By.xpath("//label[contains(text(),'Primary Diagnosis')]/../../div[3]//input")).getAttribute(Attribute);
	}
	
	public String readDiagnosisByAttribute(String Attribute) {
		return Source.SeleniumHelper().getWebElement(By.xpath("//label[contains(text(),'Primary Diagnosis')]/../../div[4]//input")).getAttribute(Attribute);
	}
	
	public DiagnosisPage setDiagnosis(String DiagnosisTitle, String Value, String... Clear) {
		By data = By.xpath("//label[contains(text(),'" + DiagnosisTitle + "')]/../div/div/div//input");
		Source.SeleniumHelper().setText(data, Value, Clear)
		.sleep(2)
		.Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public String readDiagnosisStartDateTitle(String DiagnosisTitle) {
		By data = By.xpath("//label[contains(text(),'" + DiagnosisTitle + "')]/../../div[2]//label");
		return Source.SeleniumHelper().readElement(data);
	}
	
	public DiagnosisPage setDiagnosisStartDate(String DiagnosisTitle, String Value, String... Clear) {
		By data = By.xpath("//label[contains(text(),'" + DiagnosisTitle + "')]/../../div[2]//input");
		Source.SeleniumHelper().setText(data, Value, true, Clear);
		return this;
	}

	public String readDiagnosisEndDateTitle(String DiagnosisTitle) {
		By data = By.xpath("//label[contains(text(),'" + DiagnosisTitle + "')]/../../div[3]//label");
		return Source.SeleniumHelper().readElement(data);
	}
	
	public DiagnosisPage setDiagnosisEndDate(String DiagnosisTitle, String Value, String... Clear) {
		By data = By.xpath("//label[contains(text(),'" + DiagnosisTitle + "')]/../../div[3]//input");
		Source.SeleniumHelper().setText(data, Value, true, Clear);
		return this;
	}

	public String readDiagnosisByTitle(String DiagnosisTitle) {
		By data = By.xpath("//label[contains(text(),'" + DiagnosisTitle + "')]/../../div[4]//label");
		return Source.SeleniumHelper().readElement(data);
	}
	
	public DiagnosisPage setDiagnosisBy(String DiagnosisTitle, String Value, String... Clear) {
		By data = By.xpath("//label[contains(text(),'" + DiagnosisTitle + "')]/../../div[4]//input");
		Source.SeleniumHelper().setText(data, Value, Clear);
		return this;
	}
	
	public String readDiagnosisBy(String DiagnosisTitle) {
		return Source.SeleniumHelper().getWebElement(By.xpath("//label[contains(text(),'" + DiagnosisTitle + "')]/../../div[4]//input")).getAttribute("last-val");
	}
	
	public DiagnosisPage setOtherDiagnosis(String type, String... Clear) {
		Source.SeleniumHelper().setText(OtherDiagnosisTextBox, type + Keys.TAB, Clear);
		return this;
	}

}
