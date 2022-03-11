package com.eisrem.testCases.Module_People;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;


public class RaceEthnicityPageTest extends PeoplePage{


	@Test(priority=1)
	public void RaceEthnicityPageTitlesCheck() {
		SoftAssert = new SoftAssert();

		try{		
			SeleniumHelper.log.info("Verifying 'Other' link title");
			Expected ="Other";
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
								.clickRaceEthinicityTab()
								.readLinkTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Other Place Of Birth' title");
			Expected ="Place Of Birth";
			Actual = Source		.RaceEthnicityPage()
								.readPlaceOfBirthTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Other Religion' title");
			Expected ="Religion";
			Actual = Source		.RaceEthnicityPage()
								.readReligionTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Other Race' title");
			Expected ="Race";
			Actual = Source		.RaceEthnicityPage()
								.readRaceTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Other Ethnicity' title");
			Expected ="Ethnicity";
			Actual = Source		.RaceEthnicityPage()
								.readEthnicityTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Submit' btn title");
			Expected ="Submit";
			Actual = Source		.RaceEthnicityPage()
								.readSubmitBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Print' btn title");
			Expected ="Print";
			Actual = Source		.RaceEthnicityPage()
								.readPrintBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Back To Demographics' btn title");
			Expected ="Back To People";
			Actual = Source		.RaceEthnicityPage()
								.readBackToPeopleBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
		
	
	
}