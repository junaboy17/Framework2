package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_BHOPS_11350_Conducted_Types_List_Order extends PeoplePage {
	
	
	@Test(priority=1)
	public void Assessment_List_Order() {
		
		SoftAssert = new SoftAssert();

		try{
			
					SeleniumHelper.log.info("Completing assesment form & verifying if it is sorting modified date descending");
					Expected =	Tomorrow;
					Actual = 	Source		.PeoplePage()
											.AddPeople()
											.GetSource()
											.NavigationMenuBar()
											.clickAssessmentForms()
											.clickAdd()
											.Assessment_FormsPage()
											.selectAssessmentType(DataFixFormV2Assessment)
											.setTitle("SELENIUM TEST")
											.setDescription("DESCRIPTION FROM CREATION")
											.GetSource()
											.Assessment_FormsPage()
											.clickStartAssessment()
											.fillForm()
											.clickSubmitAllPages()
											.GetSource()
											.SeleniumHelper()
											.GetSource()
											.Assessment_FormsPage()
											.clickGoBackToList()
											.DataTable()
											.clickAdd()
											.Assessment_FormsPage()
											.selectAssessmentType(DataFixFormV2Assessment)
											.setTitle("SELENIUM TEST2")
											.setDescription("DESCRIPTION FROM CREATION")
											.setEndDate(Tomorrow, "Y")
											.GetSource()
											.Assessment_FormsPage()
											.clickStartAssessment()
											.fillForm()
											.clickSubmitAllPages()
											.GetSource()
											.Assessment_FormsPage()
											.clickGoBackToList()
											.Assessment_FormsPage()
											.readFirstResultEndDate();
											
					SoftAssert.assertEquals(Actual, Expected);
					
					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
	@Test(priority=2)
	public void Notes_List_Order() {
		
		SoftAssert = new SoftAssert();

		try{

					SeleniumHelper.log.info("Completing Notes form & verifying if it is sorting modified date descending");
					Expected =	Tomorrow;
					Actual = 	Source		.PeoplePage()
											.AddPeople()
											.GetSource()
											.NavigationMenuBar()
											.clickNotes()
											.clickAdd()
											.NotesPage()
											.selectNotesType(6)
											.setTitle("SELENIUM TEST")
											.setDescription("DESCRIPTION FROM CREATION")
											.GetSource()
											.NotesPage()
											.clickStartNotes()
											.fillForm2()
											.setReferentPhone(RandNum10, Clear)
											.clickSubmitAllPages()
											.GetSource()
											.NotesPage()
											.clickGoBackToList()
											.DataTable()
											.clickAdd()
											.NotesPage()
											.selectNotesType(6)
											.setTitle("SELENIUM TEST2")
											.setDescription("DESCRIPTION FROM CREATION")
											.setEndDate(Tomorrow, "Y")
											.GetSource()
											.NotesPage()
											.clickStartNotes()
											.fillForm2()
											.setReferentPhone(RandNum10, Clear)
											.clickSubmitAllPages()
											.GetSource()
											.NotesPage()
											.clickGoBackToList()
											.NotesPage()
											.readFirstResultEndDate();

											
					SoftAssert.assertEquals(Actual, Expected);
					
					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}
	
	@Test(priority=3)
	public void Reportable_Events_List_Order() {
		
		SoftAssert = new SoftAssert();

		try{

					SeleniumHelper.log.info("Completing Reportable Events form & verifying if it is sorting modified date descending");
					Expected =	Tomorrow;
					Actual = 	Source		.PeoplePage()
											.AddPeople()
											.GetSource()
											.NavigationMenuBar()
											.clickReportableEvent()
											.clickAdd()
											.ReportableEventPage()
											.selectReportableEventType(1)
											.setTitle("SELENIUM TEST")
											.setDescription("DESCRIPTION FROM CREATION")
											.clickStartReportableEvent()
											.fillForm2()
											.clickContinue()
											.ReportableEventPage()
											.setText("1000003569", "Selenium Test")
											.GetSource()
											.FormPage()
											.clickSubmitAllPages()
											.GetSource()
											.ReportableEventPage()
											.clickGoBackToList()
											.DataTable()
											.clickAdd()
											.ReportableEventPage()
											.selectReportableEventType(1)
											.setTitle("SELENIUM TEST2")
											.setDescription("DESCRIPTION FROM CREATION")
											.setEndDate(Tomorrow, "Y")
											.GetSource()
											.ReportableEventPage()
											.clickStartReportableEvent()
											.fillForm2()
											.GetSource()
											.ReportableEventPage()
											.clickContinue()
											.ReportableEventPage()
											.setText("1000003569", "Selenium Test")
											.GetSource()
											.FormPage()
											.clickSubmitAllPages()
											.clickGoBackToList()
											.ReportableEventPage()
											.readFirstResultEndDate();

											
					SoftAssert.assertEquals(Actual, Expected);
					
					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}
}
	
	

