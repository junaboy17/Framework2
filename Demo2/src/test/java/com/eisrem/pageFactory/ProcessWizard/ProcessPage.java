package com.eisrem.pageFactory.ProcessWizard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.pageFactory.Classes.ClassesPage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.MyHomePage.MyHomePage;

public class ProcessPage extends ProcessWizardNavigator{

	public ProcessPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	
}
