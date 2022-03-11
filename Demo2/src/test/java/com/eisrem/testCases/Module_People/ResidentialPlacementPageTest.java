package com.eisrem.testCases.Module_People;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;


public class ResidentialPlacementPageTest extends PeoplePage{


	@Test(priority=1)
	public void ResidentialPlacementPageTitlesCheck() {
		SoftAssert = new SoftAssert();

		try{		
			SeleniumHelper.log.info("Verifying 'Residential Placement' link title");
			Expected ="Residential Placement";
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
								.clickResidentialPlacementTab()
								.readResidentialPlacementTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Admit Date' title");
			Expected ="Admit Date *";
			Actual = Source		.DataTable()
								.clickAdd()
								.ResidentialPlacementPage()
								.readAdmitDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Discharge Date' title");
			Expected ="Discharge Date";
			Actual = Source		.ResidentialPlacementPage()
								.readDischargeDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Placement Type' title");
			Expected ="Placement Type *";
			Actual = Source		.ResidentialPlacementPage()
								.readPlacementTypeDropdownTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Pnmi Placement Dropdown' title");
			Expected ="Residential Placement *";
			Actual = Source		.ResidentialPlacementPage()
								.readPnmiPlacementDropdownTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Level Dropdown' title");
			Expected ="Residential Level";
			Actual = Source		.ResidentialPlacementPage()
								.readLevelDropdownTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Description' title");
			Expected ="Description";
			Actual = Source		.ResidentialPlacementPage()
								.readDescriptionTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Submit' btn title");
			Expected ="Submit";
			Actual = Source		.ResidentialPlacementPage()
								.readSubmitBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Print' btn title");
			Expected ="Print";
			Actual = Source		.ResidentialPlacementPage()
								.readPrintBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Back To Residential Placement' btn title");
			Expected ="Back To Residential Placement";
			Actual = Source		.ResidentialPlacementPage()
								.readBackToResidentialPlacementBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
		
	
	
}