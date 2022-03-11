package com.eisrem.pageFactory.Agreement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class AgreementNavigator extends DataTable{


	public AgreementNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@id='32_Agreement_tab']")
	public WebElement AgreementTab;
		
	public String readAgreementTab() {
		return Source.SeleniumHelper().readElement(AgreementTab);
	}
	
	public AgreementPage clickAgreement() {
		Source.SeleniumHelper().clickElement(AgreementTab);
		return new AgreementPage(DriverFactory.getDriver());
	}
	
	
	
}
