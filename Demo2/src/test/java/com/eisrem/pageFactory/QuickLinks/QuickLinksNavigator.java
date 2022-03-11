package com.eisrem.pageFactory.QuickLinks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.CommonPage.DataTable;

public class QuickLinksNavigator extends DataTable{


	public QuickLinksNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@id='47_Links_tab']")
	public WebElement QuickLinksTab;
	
	public String readQuickLinksTab() {
		return Source.SeleniumHelper().readElement(QuickLinksTab);
	}
	
	public ObjectSource clickQuickLinks() {
		Source.SeleniumHelper().clickElement(QuickLinksTab);
		return new ObjectSource();
	}
	
}
