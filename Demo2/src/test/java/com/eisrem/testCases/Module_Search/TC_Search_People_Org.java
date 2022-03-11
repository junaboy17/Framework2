package com.eisrem.testCases.Module_Search;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.SearchPage;


public class TC_Search_People_Org extends SearchPage{
	@Test(priority=1)
	public void TC_Search_People_Org_Restriction() {
		SoftAssert = new SoftAssert();
		
		try{
			
			String peoId = Source.PeoplePage().addPersonReturnId();
			
			SeleniumHelper.log.info("Generate asessment on person");
			String peoConductedTypeId = Source.ConductedTypes().addCompleteConductedTypeAndSubmit(ConductTypeOn.PEOPLE, AppModule.ASSESSMENT, peoId, null, null, 
					Today, null, DataFixFormV2Assessment, null, ConductedTypeTitle, Description, T).readFirstResultID().replaceAll("[^0-9]", EmptyString);
			
			SeleniumHelper.log.info("Generate assessment on location");
			String locConductedTypeId = Source.ConductedTypes().addCompleteConductedTypeAndSubmit(ConductTypeOn.LOCATION, AppModule.ASSESSMENT, null, OrgDHHS, CentralOffice, 
					Today, null, DataFixFormV2Assessment, null, ConductedTypeTitle, Description, T).readFirstResultID().replaceAll("[^0-9]", EmptyString);
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);

			SeleniumHelper.log.info("Verify Search generates results for person");
			Expected = peoConductedTypeId;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.CONDUCTED_TYPE.getName())
								.setSearchBy(SearchBy.ID.getName())
								.setSearchRestrictBy(SearchRestrictBy.PEOPLE.getName())
								.setValue(peoConductedTypeId)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Verify Search loads results");
			Expected = EditAssessmentHeader;					
			Actual = Source   	.SearchPage()					
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verify Search generates results for organization");
			Expected = locConductedTypeId;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.CONDUCTED_TYPE.getName())
								.setSearchBy(SearchBy.ID.getName())
								.setSearchRestrictBy(SearchRestrictBy.ORGANIZATION_LOCATION.getName())
								.setValue(locConductedTypeId)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Verify Search loads results");
			Expected = EditAssessmentHeader;					
			Actual = Source   	.SearchPage()					
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}