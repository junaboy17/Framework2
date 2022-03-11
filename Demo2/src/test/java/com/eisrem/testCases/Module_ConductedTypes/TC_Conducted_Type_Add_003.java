package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_Conducted_Type_Add_003 extends PeoplePage {

	@Test(priority=1)
	public void ReportableEvent_Add() {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Anchoring a person & verifying Add Reportable Event with required questions functionality");
					Expected =	"TC_Conducted_Types_Add_003/ OCFS REPORTABLE EVENT FORM";
					Actual = 	Source		.DataTable()
											.setSearch(TestClient2)
											.clickFirstRow()
											.clickAnchor()
											.NavigationMenuBar()
											.clickReportableEvent()
											.clickAdd()
											.ReportableEventPage()
											.selectReportableEventType("OCFS REPORTABLE EVENT FORM/ Reportable Event")
											.setTitle("TC_Conducted_Types_Add_003")
											.setDescription("Testing required questions with OCFS REPORTABLE EVENT FORM/ Reportable Event")
											.GetSource()
											.Assessment_FormsPage()
											.clickStartAssessment()
											.clickSubmitAllPages() 	// unhappy path
											.continueIfError()
											.fillForm2()
											.clickFormContinue()
											.clickSubmitAllPages() 	// unhappy path
											.continueIfError()
											.fillFormActivePage()
											.clickSubmitAllPages()
											.clickGoBackToList()
											.DataTable()
											.readFirstResultNameType();
					SoftAssert.assertEquals(Actual, Expected);

					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
}