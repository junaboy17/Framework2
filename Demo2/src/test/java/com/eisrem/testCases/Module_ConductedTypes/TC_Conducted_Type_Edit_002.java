package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.SearchPage;

public class TC_Conducted_Type_Edit_002 extends SearchPage {

	@Test(priority=1)
	public void ReportableEvent_Add() {
		// this test requires SeleniumUser to have additional location 'DHHS/Region 3 - Childrens' 
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Searching for a conducted type based on end-dated Type "
							+ "and confirm all fields are disabled even if it is open in Edit mode after the search.");
					
					Source		.SearchPage()
								.setSearchFor(SearchFor.CONDUCTED_TYPE.getName())
								.setSearchBy(SearchBy.ID.getName())
								.setSearchRestrictBy(SearchRestrictBy.PEOPLE.getName())
								.setValue("2173935")		// ct Id 2173935 - for ANSA assessment type 5831 that is end-dated
								.clickSearchAdd()
								.clickSearch()
								.isEmptyThrowError()
								.clickFirstColumnLink()
								.GetSource()
								.FormPage()
								.checkAllWebElementsDisabled()
								.checkSubmitAllPagesBtnInvisible()
								.GetSource()
								.Assessment_FormsPage() 
								.clickAssessmentsFormsTab()
								.GetSource()
								.FormPage()
								.checkAllWebElementsDisabled()
								.checkSubmitBtnDisabled()
								.clickBackToAssessment();
											
								SoftAssert.assertAll();

			} catch(Exception e) {
				Source	.SeleniumHelper()
						.assertFail();
			}	
	}
}