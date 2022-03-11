package com.eisrem.testCases.Module_Search;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.SearchPage;


public class TC_Search_Conducted_Type extends SearchPage{
	@Test(priority=1)
	public void TC_Search_Conducted_Type_001() {
		SoftAssert = new SoftAssert();

		try{
			String peoId = Source.PeoplePage().addPersonReturnId();
			
			String ConductedTypeId = Source.ConductedTypes().addCompleteConductedTypeAndSubmit(ConductTypeOn.PEOPLE, AppModule.ASSESSMENT, peoId, null, null, 
					Today, null, DataFixFormV2Assessment, null, ConductedTypeTitle, Description, T).readFirstResultID().replaceAll("[^0-9]", EmptyString);

			SeleniumHelper.log.info("Verify Search generates results");
			Expected = ConductedTypeId;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.CONDUCTED_TYPE.getName())
								.setSearchBy(SearchBy.ID.getName())
								.setSearchRestrictBy(SearchRestrictBy.PEOPLE.getName())
								.setValue(ConductedTypeId)
								.clickSearchAdd()
								.clickSearch()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Verify Search generates results");
			Expected = EditAssessmentHeader;
			Actual =Source		.SearchPage()
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2)
	public void TC_Search_Conducted_Type_002() {
		SoftAssert = new SoftAssert();

		try{
			
			String peoId = Source.PeoplePage().addPersonReturnId();
			
			String ConductedTypeId = Source.ConductedTypes().addCompleteConductedTypeAndSubmit(ConductTypeOn.PEOPLE, AppModule.ASSESSMENT, peoId, null, null, 
					Today, null, DataFixFormV2Assessment, null, ConductedTypeTitle, Description, T).readFirstResultID().replaceAll("[^0-9]", EmptyString);

			SeleniumHelper.log.info("Verify Search generates results");
			Expected = ConductedTypeId;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.CONDUCTED_TYPE.getName())
								.setSearchBy(SearchBy.DATE_RANGE.getName())
								.setSearchRestrictBy(SearchRestrictBy.PEOPLE.getName())
								.setType(DataFixFormV2)
								.setStartDate(Today)
								.setEndDate(Today)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.setSearch(ConductedTypeId)
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Verify Search generates results");
			Expected = EditAssessmentHeader;
			Actual =Source		.SearchPage()
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=3)
	public void TC_Search_Conducted_Types_Submit_Range_001() {
		SoftAssert = new SoftAssert();
		
		try{
			
			String peoId = Source.PeoplePage().addPersonReturnId();
			
			SeleniumHelper.log.info("Generate reportable event ocfs form for test - this is a large form with multiple required pages and questions");
			Source.ConductedTypes().addConductedTypeStayOnForm(ConductTypeOn.PEOPLE, AppModule.REPORTABLE_EVENT, peoId, null, null, 
					Today, null, OcfsReportableEventForm, null, ConductedTypeTitle, Description);
			
			SeleniumHelper.log.info("Continued");
			String ConductedTypeId = Source   	
								.FormPage()
								.fillFormActivePage()
								.clickFormContinue()
								.fillFormActivePage()
								.clickFormContinue()
								.fillFormActivePage()
								.clickSubmitAllPages()
								.clickCTBackToList()
								.GetSource()
								.ConductedTypes()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);
			
//			SoftAssert.assertEquals(Actual, Expected);
//			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);

			SeleniumHelper.log.info("Verify Search generates results");
			Expected = ConductedTypeId;
			Actual = Source   	.NavigationMenuBar()
								.clickSearch()
								.setSearchFor(SearchFor.CONDUCTED_TYPE.getName())
								.setSearchBy(SearchBy.DATE_RANGE.getName())
								.setSearchRestrictBy(SearchRestrictBy.PEOPLE.getName())
								.setType(OcfsReportableEventForm)
								.setStartDate(Yesterday)
								.setEndDate(Tomorrow)
								.GetSource()
								.SearchPage()
								.clickSearchAdd()
								.clickSearch()
								.GetSource()
								.DataTable()
								.setSearch(ConductedTypeId, Clear)
								.GetSource()
								.SeleniumHelper()
								.Wait(5)
								.GetSource()
								.SearchPage()
								.readFirstResultID().replaceAll("[^0-9]", EmptyString);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
								
			SeleniumHelper.log.info("Verify Search loads results");
			Expected = EditReportableEventHeader;					
			Actual = Source   	.SearchPage()					
								.clickFirstRowIDLink()
								.readSearchResultTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}