package com.eisrem.testCases.Release2022;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_BHOPS_12167_Datepicker_Appears_Over_Elements extends PeoplePage {

	@Test(priority=1)
	public void TC_People_Demographics_Datepickers() {

		SoftAssert = new SoftAssert();
		
		By endDateInput = By.id("endDate"); 
		By divDatepicker = By.className("datepicker"); 

		String actual = null;
		String attribute = "z-index: 1010;";
		
		try{
			SeleniumHelper.log.info("Adding a Person and verifying detepicker has attribute z-index equal to 1010 "
					+ "so it would appear on the top of all elements on the screen.");

				Source.PeoplePage().clickAdd();
										
				Source.SeleniumHelper().clickElement(endDateInput);
					actual = Source.SeleniumHelper().readAttribute(divDatepicker, "style");
			
				SoftAssert.assertTrue(actual.contains(attribute)); 
	
		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

}