package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_BHOPS_11836_Conducted_Types_Clear_Anchor_Check extends PeoplePage {
	
	@Test(priority=1)
	public void TC_Conducted_Types_Clear_Anchor_Check() {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Clicking save and verifying form was saved without a peo_id after clicking clear anchor in Conducted types");
					Expected =	"Operation completed successfully.";
					Actual = 	Source		.DataTable()
											.setSearch(FirstName, Clear)
											.clickFirstColumnLink()
											.clickAnchor()
											.NavigationMenuBar()
											.clickAssessmentForms()
											.clickAdd()
											.Assessment_FormsPage()
											.selectAssessmentType(DataFixFormV2Assessment)
											.setTitle("SELENIUM TEST")
											.setDescription(Description)
											.GetSource()
											.Assessment_FormsPage()
											.clickStartAssessment()
											.fillForm()
											.releaseAnchor()
								            .readPopUpMessage();
											
					SoftAssert.assertEquals(Actual, Expected);
					
					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
		
	}
	
	

