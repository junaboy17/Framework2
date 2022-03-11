package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;



public class TC_Conducted_Type_AlphaOrder extends PeoplePage {

	@Test(priority=1)
	
	public void AssessmentTypeList_AlphaOrder_Verify() {
		
		SoftAssert = new SoftAssert();
		String title = "Selenium Test #" + SeleniumHelper.generateRandomNumber(4);
		
		try {
			SeleniumHelper.log.info("Starting assessment and verifying type dropdown values are in alpha order");
									
					Source	
							// Anchor on a client
							.PeoplePage()
							.AddPeople()
							
							// Add conducted type (assessment)
							.GetSource()
							.NavigationMenuBar()
							.clickAssessmentForms()
							.clickAdd()
							.Assessment_FormsPage()
							.setTitle(title)
							// Verify Assessment Type list items are in alpha order
							.GetSource()
							.SeleniumHelper()
		                    .verifyDropDownIsInOrderAlpha(Source
		                 	.Assessment_FormsPage()
		                 	.AssessmentTypeDropDown)
							;
							
						SoftAssert.assertAll();	
							
		}catch(Exception e) {
			Source	.SeleniumHelper()		
					.assertFail();
		}
	}
}