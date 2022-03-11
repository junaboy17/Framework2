package com.eisrem.pageFactory.Planning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PlanningPage extends PlanningNavigator{

	public PlanningPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	
}
