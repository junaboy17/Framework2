package com.eisrem.testCases.Business.Module_Assessment;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.BusinessUserLogIn;
import com.eisrem.Hooks.PeoplePage;

import edu.emory.mathcs.backport.java.util.Arrays;

public class ProviderUserAssessment_Add_Edit_View extends BusinessUserLogIn {

	@Test(priority=1)
	public void Add_Func_Back_To_People() {

		SoftAssert = new SoftAssert();
		
		String AssessmentTitle = "Data Fix Form" + SeleniumHelper.generateRandomNumber(3);

		try{
			SeleniumHelper.log.info("Anchoring a person & verifying Add Edit View Excel tab in Association Module");

					Expected =	Add;
					Actual =	Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(JeanneClient, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickAssessmentForms()
										.readAddBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Edit;
					Actual =	Source	.DataTable()
										.readEditBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	View;
					Actual =	Source	.DataTable()
										.readViewBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Excel;
					Actual =	Source	.DataTable()
										.readExcelBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying 'Assessment Type' Drop Down");
					
					String[] Value =  {"Select", "CS INDIVIDUAL PLANNING FUNDS FORM V2/ Assessment", "Data Fix Form (V2)/ Assessment"};
					@SuppressWarnings("unchecked")
					List<String> Values = Arrays.asList(Value);
					
					Expected =	Submit;
					Actual =	Source	.DataTable()
										.clickAdd()
										.SeleniumHelper()
										.verifyAllDropDown(Source.Assessment_FormsPage().AssessmentTypeDropDown, Values)
										.GetSource()
										.Assessment_FormsPage()
										.selectAssessmentType(DataFixFormV2Assessment)
										.setTitle(AssessmentTitle)
										.setDescription(Description)
										.GetSource()
										.Assessment_FormsPage()
										.readSubmitBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Print;
					Actual =	Source	.DataTable()
										.readPrintBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	BackToAssessment;
					Actual =	Source	.FormPage()
										.readBackToAssessmentBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Continue;
					Actual =	Source	.Assessment_FormsPage()
										.clickStartAssessment()
										.fillForm()
										.GetSource()
										.Assessment_FormsPage()
										.readContinueBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Print;
					Actual =	Source	.FormPage()
										.readFormPrintBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	SubmitAllPages;
					Actual =	Source	.FormPage()
										.readSubmitAllPages();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	GoBackToPeople;
					Actual =	Source	.FormPage()
										.clickSubmitAllPages()
										.readGoBackToPeople();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Continue;
					Actual =	Source	.Assessment_FormsPage()
										.readPopUpContinueBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	GoBackToList;
					Actual =	Source	.Assessment_FormsPage()
										.readGoBackToListBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	"People";
					Actual =	Source	.FormPage()
										.clickGoBackToPeople()
										.readPeopleTab();
					SoftAssert.assertEquals(Actual, Expected);
					

					SoftAssert.assertAll();


		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=2)
	public void Add_Func_Go_Back_To_List() {

		SoftAssert = new SoftAssert();
		
		String AssessmentTitle = "Data Fix Form" + SeleniumHelper.generateRandomNumber(3);

		try{
			SeleniumHelper.log.info("Anchoring a person & verifying Add Edit View Excel tab in Association Module");

					Expected =	Add;
					Actual =	Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(JeanneClient, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickAssessmentForms()
										.readAddBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Edit;
					Actual =	Source	.DataTable()
										.readEditBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	View;
					Actual =	Source	.DataTable()
										.readViewBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Excel;
					Actual =	Source	.DataTable()
										.readExcelBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying 'Assessment Type' Drop Down");
					
					String[] Value =  {"Select", "CS INDIVIDUAL PLANNING FUNDS FORM V2/ Assessment", "Data Fix Form (V2)/ Assessment"};
					@SuppressWarnings("unchecked")
					List<String> Values = Arrays.asList(Value);
					
					Expected =	Submit;
					Actual =	Source	.DataTable()
										.clickAdd()
										.SeleniumHelper()
										.verifyAllDropDown(Source.Assessment_FormsPage().AssessmentTypeDropDown, Values)
										.GetSource()
										.Assessment_FormsPage()
										.selectAssessmentType(DataFixFormV2Assessment)
										.setTitle(AssessmentTitle)
										.setDescription(Description)
										.GetSource()
										.Assessment_FormsPage()
										.readSubmitBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Print;
					Actual =	Source	.DataTable()
										.readPrintBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	BackToAssessment;
					Actual =	Source	.FormPage()
										.readBackToAssessmentBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Continue;
					Actual =	Source	.Assessment_FormsPage()
										.clickStartAssessment()
										.fillForm()
										.GetSource()
										.Assessment_FormsPage()
										.readContinueBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Print;
					Actual =	Source	.FormPage()
										.readFormPrintBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	SubmitAllPages;
					Actual =	Source	.FormPage()
										.readSubmitAllPages();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	GoBackToPeople;
					Actual =	Source	.FormPage()
										.clickSubmitAllPages()
										.readGoBackToPeople();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Continue;
					Actual =	Source	.Assessment_FormsPage()
										.readPopUpContinueBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	GoBackToList;
					Actual =	Source	.Assessment_FormsPage()
										.readGoBackToListBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	"Assessments";
					Actual =	Source	.Assessment_FormsPage()
										.clickGoBackToList()
										.Assessment_FormsPage()
										.readAssessmentsTab();
					SoftAssert.assertEquals(Actual, Expected);
					

					SoftAssert.assertAll();


		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=3)
	public void Assessment_Form_Edit() {

		SoftAssert = new SoftAssert();
		
		String AssessmentTitle = "Data Fix Form" + SeleniumHelper.generateRandomNumber(3);

		try{
			SeleniumHelper.log.info("Filling out a new assessment for existing person");

					String[] Value =  {"Select", "CS INDIVIDUAL PLANNING FUNDS FORM V2/ Assessment", "Data Fix Form (V2)/ Assessment"};
					@SuppressWarnings("unchecked")
					List<String> Values = Arrays.asList(Value);
					Expected =	"Assessments";
					Actual =	Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(JeanneClient, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickAssessmentForms()
										.clickAdd()
										.SeleniumHelper()
										.verifyAllDropDown(Source.Assessment_FormsPage().AssessmentTypeDropDown, Values)
										.GetSource()
										.Assessment_FormsPage()
										.selectAssessmentType(DataFixFormV2Assessment)
										.setTitle(AssessmentTitle)
										.setDescription(Description)
										.GetSource()
										.Assessment_FormsPage()
										.clickStartAssessment()
										.fillForm()
										.GetSource()
										.FormPage()
										.clickSubmitAllPages()
										.clickGoBackToList()
										.Assessment_FormsPage()
										.readAssessmentsTab();
					SoftAssert.assertEquals(Actual, Expected);
					
					ID =	Source		.DataTable()
										.setSearch(AssessmentTitle, Clear)
										.readFirstResultID()
										.replace("Select", EmptyString)
										.replace(" ", EmptyString);
					
					SeleniumHelper.log.info("Verifying assessment is anchored after clicking edit");
					Expected = JeanneAnchoredData + AssessmentTitle + ":  " + ID;
					Actual = Source		.DataTable()
										.clickFirstRow()
										.clickEdit()
										.Pagefactory()
										.readAnchoredInfo();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying chosen assessment type tab is anchored");
					Expected = "active";
					Actual = Source		.FormPage()
										.isActiveTopTab(2);
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Editing name in Assessment Form & verifying reflected changes");
					Expected = "Jeanne Santa Maria";
					Actual = Source		.FormPage()
										.setText(2, "Name", "Jeanne Santa Maria", Clear)
										.clickSubmitAllPages()
										.clickGoBackToList()
										.DataTable()
										.setSearch(AssessmentTitle, Clear)
										.clickFirstRow()
										.clickEdit()
										.FormPage()
										.readTextBoxValue(2, "Name");
					SoftAssert.assertEquals(Actual, Expected);
					

					SoftAssert.assertAll();


		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=4)
	public void Assessment_Form_View() {

		SoftAssert = new SoftAssert();
		
		String AssessmentTitle = "Data Fix Form" + SeleniumHelper.generateRandomNumber(3);

		try{
			SeleniumHelper.log.info("Filling out a new assessment for existing person");

					String[] Value =  {"Select", "CS INDIVIDUAL PLANNING FUNDS FORM V2/ Assessment", "Data Fix Form (V2)/ Assessment"};
					@SuppressWarnings("unchecked")
					List<String> Values = Arrays.asList(Value);
					Expected =	"Assessments";
					Actual =	Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(JeanneClient, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickAssessmentForms()
										.clickAdd()
										.SeleniumHelper()
										.verifyAllDropDown(Source.Assessment_FormsPage().AssessmentTypeDropDown, Values)
										.GetSource()
										.Assessment_FormsPage()
										.selectAssessmentType(DataFixFormV2Assessment)
										.setTitle(AssessmentTitle)
										.setDescription(Description)
										.GetSource()
										.Assessment_FormsPage()
										.clickStartAssessment()
										.fillForm()
										.GetSource()
										.FormPage()
										.clickSubmitAllPages()
										.clickGoBackToList()
										.Assessment_FormsPage()
										.readAssessmentsTab();
					SoftAssert.assertEquals(Actual, Expected);
					
					ID =	Source		.DataTable()
										.setSearch(AssessmentTitle, Clear)
										.readFirstResultID()
										.replace("Select", EmptyString)
										.replace(" ", EmptyString);
					
					SeleniumHelper.log.info("Verifying assessment is anchored after clicking view");
					Expected = JeanneAnchoredData + AssessmentTitle + ":  " + ID;
					Actual = Source		.DataTable()
										.clickFirstRow()
										.clickView()
										.Pagefactory()
										.readAnchoredInfo();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying chosen assessment type tab is anchored");
					Expected = "active";
					Actual = Source		.FormPage()
										.isActiveTopTab(2);
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying if text box entry is disabled");
					Expected = True;
					Actual = Source		.FormPage()
										.ifDisabledTextBox(2, "Name");
					SoftAssert.assertEquals(Actual, Expected);
					

					SoftAssert.assertAll();


		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
		
}
	
	

