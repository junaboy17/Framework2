package com.eisrem.pageFactory.People;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.Pagefactory;
import com.eisrem.pageFactory.Organization.ServicesSpecialtiesPage;

public class LivingArrangementPage extends DataTable{

	public LivingArrangementPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[contains(text(), 'Add Living Arrangement')]")
	public WebElement AddLivingArangementTitle;	
	
	@FindBy(xpath="//a[contains(text(),'Living Arrangement Info:')]")
	public WebElement LivingArangementInfoAccord;	
	
	@FindBy(xpath="//label[@for='livingArrType']")
	public WebElement TypeTitle;	
	
	@FindBy(xpath="//select[@id='livingArrType']")
	public WebElement TypeDropDown;	
	
	@FindBy(xpath="//label[contains(text(),'Description')]")
	public WebElement DescriptionTitle;	
	
	@FindBy(xpath="//textarea[@id='livingArrComment']")
	public WebElement DescriptionTextBox;	
	
	public LivingArrangementPage selectType(String value) {
		Source.SeleniumHelper().select(TypeDropDown, value);
		return this;
	}

	public LivingArrangementPage selectType(int value) {
		Source.SeleniumHelper().select(TypeDropDown, value);
		return this;
	}
	
	public String readDescriptionTitle() {
		return Source.SeleniumHelper().readElement(DescriptionTitle);
	}
	
	public Pagefactory setDescription(String description, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, description + Keys.TAB, Clear);
		return new Pagefactory(DriverFactory.getDriver());
	}
	
	public String readDescriptionTextBoxValue() {
		return Source.SeleniumHelper().readElement(DescriptionTextBox);
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

}
