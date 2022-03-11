package com.eisrem.testCases.Business.Module_ReportableEvents;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BusinessUserLogIn;
import edu.emory.mathcs.backport.java.util.Arrays;

public class ReportableEvents_Add_Edit_View extends BusinessUserLogIn {

	@Test(priority=1)
	public void ReportableEventsBackToList() {

		SoftAssert = new SoftAssert();
		
		String ReportTitle = "Death of Client Test" + SeleniumHelper.generateRandomNumber(3);	
		String[] Value =  {"Select", OCFSType};
		@SuppressWarnings("unchecked")
		List<String> Values = Arrays.asList(Value);

		try{
				SeleniumHelper.log.info("Anchoring a person & verifying Add Edit View Excel tab in Reportable Event Module");

					Expected =	Add;
					Actual =	Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(JeanneClient, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickReportableEvent()
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
					
					SeleniumHelper.log.info("Verifying 'Reportable Event Type' Drop Down");
					
					Expected =	Submit;
					Actual =	Source	.DataTable()
										.clickAdd()
										.SeleniumHelper()
										.verifyAllDropDown(Source.ReportableEventPage().ReportableEventTypeDropDown, Values)
										.GetSource()
										.ReportableEventPage()
										.selectReportableEventType(OCFSType)
										.setTitle(ReportTitle)
										.setDescription(Description)
										.GetSource()
										.ReportableEventPage()
										.readSubmitBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Print;
					Actual =	Source	.DataTable()
										.readPrintBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	BackToReportableEvent;
					Actual =	Source	.FormPage()
										.readBackToReportableEvent();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Continue;
					Actual =	Source	.ReportableEventPage()
										.clickStartReportableEvent()
										.setText(1, "EVENT NAME", "Death of Client Test")
										.setText(1, "EVENT DATE", Today)
										.selectValue(1, "START TIME", 10, 1)
										.selectValue(1, "START TIME", 6, 2)
										.selectValue(1, "START TIME", 21, 3)
										.selectValue(1, "START TIME", 1, 4)
										.selectValue(1, "END TIME", 11, 1)
										.selectValue(1, "END TIME", 16, 2)
										.selectValue(1, "END TIME", 26, 3)
										.selectValue(1, "END TIME", 2, 4)
										.selectValue(2, "PROGRAM COMPLETING", 1)
										.selectValue(2, "INCIDENT LOCATION", 2)
										.setText(3, "DATA ENTERER", JeanneClient)
										.setText(3, "DATA ENTERER PHONE", PhoneNumber)
										.setText(3, "DATA ENTERER EMAIL", Email)
										.selectValue(3, "DOES THIS", 1)
										.setText(4, "REPORTER NAME", JeanneClient)
										.setText(4, "REPORTER TITLE", "MA2")
										.setText(4, "REPORTER PHONE", PhoneNumber)
										.selectValue(4, "REPORTER ROLE", 4)
										.selectValue(4, "WERE THEIR", 1)
										.selectValue(4, "GUARDIAN NOTIFIED?", 1)
										.clickCheckBoxFromDropDown(5, "CATEGORY OF EVENT", 3)
										.clickOption(5, "CATEGORY OF EVENT")
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
					
					Expected =	"active";
					Actual =	Source	.FormPage()
										.clickFormContinue()
										.isActiveTopTab(5);
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	"DEATH OF CLIENT(*required)";
					Actual =	Source	.FormPage()
										.readTopTab(5);
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	GoBackToPeople;
					Actual =	Source	.FormPage()
										.setText(1, "SUMMARY OF DEATH OF CLIENT", "Testing")
										.selectValue(1, "DEATH DUE TO", "ACCIDENT")
										.clickSubmitAllPages()
										.readGoBackToPeople();
					SoftAssert.assertEquals(Actual, Expected);
										
					Expected =	Continue;
					Actual =	Source	.ReportableEventPage()
										.readPopUpContinueBtn();
					SoftAssert.assertEquals(Actual, Expected);
										
					Expected =	GoBackToList;
					Actual =	Source	.ReportableEventPage()
										.readGoBackToListBtn();
					SoftAssert.assertEquals(Actual, Expected);
										
					Expected =	"Reportable Event";
					Actual =	Source	.ReportableEventPage()
										.clickGoBackToList()
										.ReportableEventPage()
										.readReportableEventTab();
					SoftAssert.assertEquals(Actual, Expected);
					

					SoftAssert.assertAll();


		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=2)
	public void ReportableEventsBackToPeople() {

		SoftAssert = new SoftAssert();
		
		String ReportTitle = "Death of Client Test" + SeleniumHelper.generateRandomNumber(3);
		String[] Value =  {"Select", OCFSType};
		@SuppressWarnings("unchecked")
		List<String> Values = Arrays.asList(Value);

		try{
					SeleniumHelper.log.info("Anchoring a person & verifying Add Edit View Excel tab in Reportable Event Module");
		
					Expected =	Add;
					Actual =	Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(JeanneClient, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickReportableEvent()
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
					
					SeleniumHelper.log.info("Verifying 'Reportable Event Type' Drop Down");
					
					Expected =	Submit;
					Actual =	Source	.DataTable()
										.clickAdd()
										.SeleniumHelper()
										.verifyAllDropDown(Source.ReportableEventPage().ReportableEventTypeDropDown, Values)
										.GetSource()
										.ReportableEventPage()
										.selectReportableEventType(OCFSType)
										.setTitle(ReportTitle)
										.setDescription(Description)
										.GetSource()
										.ReportableEventPage()
										.readSubmitBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Print;
					Actual =	Source	.DataTable()
										.readPrintBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	BackToReportableEvent;
					Actual =	Source	.FormPage()
										.readBackToReportableEvent();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Continue;
					Actual =	Source	.ReportableEventPage()
										.clickStartReportableEvent()
										.setText(1, "EVENT NAME", "Death of Client Test")
										.setText(1, "EVENT DATE", Today)
										.selectValue(1, "START TIME", 10, 1)
										.selectValue(1, "START TIME", 6, 2)
										.selectValue(1, "START TIME", 21, 3)
										.selectValue(1, "START TIME", 1, 4)
										.selectValue(1, "END TIME", 11, 1)
										.selectValue(1, "END TIME", 16, 2)
										.selectValue(1, "END TIME", 26, 3)
										.selectValue(1, "END TIME", 2, 4)
										.selectValue(2, "PROGRAM COMPLETING", 1)
										.selectValue(2, "INCIDENT LOCATION", 2)
										.setText(3, "DATA ENTERER", JeanneClient)
										.setText(3, "DATA ENTERER PHONE", PhoneNumber)
										.setText(3, "DATA ENTERER EMAIL", Email)
										.selectValue(3, "DOES THIS", 1)
										.setText(4, "REPORTER NAME", JeanneClient)
										.setText(4, "REPORTER TITLE", "MA2")
										.setText(4, "REPORTER PHONE", PhoneNumber)
										.selectValue(4, "REPORTER ROLE", 4)
										.selectValue(4, "WERE THEIR", 1)
										.selectValue(4, "GUARDIAN NOTIFIED?", 1)
										.clickCheckBoxFromDropDown(5, "CATEGORY OF EVENT", 3)
										.clickOption(5, "CATEGORY OF EVENT")
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
					
					Expected =	"active";
					Actual =	Source	.FormPage()
										.clickFormContinue()
										.isActiveTopTab(5);
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	"DEATH OF CLIENT(*required)";
					Actual =	Source	.FormPage()
										.readTopTab(5);
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	GoBackToPeople;
					Actual =	Source	.FormPage()
										.setText(1, "SUMMARY OF DEATH OF CLIENT", "Testing")
										.selectValue(1, "DEATH DUE TO", "ACCIDENT")
										.clickSubmitAllPages()
										.readGoBackToPeople();
					SoftAssert.assertEquals(Actual, Expected);
										
					Expected =	Continue;
					Actual =	Source	.ReportableEventPage()
										.readPopUpContinueBtn();
					SoftAssert.assertEquals(Actual, Expected);
										
					Expected =	GoBackToList;
					Actual =	Source	.ReportableEventPage()
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
	
	@Test(priority=3)
	public void ReportableEventEditFunctionalityCheck() {

		SoftAssert = new SoftAssert();
		
		String ReportTitle = "Death of Client Test" + SeleniumHelper.generateRandomNumber(3);

		try{
					SeleniumHelper.log.info("Anchoring a person & verifying Add Edit View Excel tab in Reportable Event Module");
					SeleniumHelper.log.info("Verifying 'Reportable Event Type' Drop Down");
					String[] Value =  {"Select", OCFSType};
					List<String> Values = Arrays.asList(Value);
					
					Expected =	"Reportable Event";
					Actual =	Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(JeanneClient, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickReportableEvent()
										.clickAdd()
										.SeleniumHelper()
										.verifyAllDropDown(Source.ReportableEventPage().ReportableEventTypeDropDown, Values)
										.GetSource()
										.ReportableEventPage()
										.selectReportableEventType(OCFSType)
										.setTitle(ReportTitle)
										.setDescription(Description)
										.GetSource()
										.ReportableEventPage()
										.clickStartReportableEvent()
										.setText(1, "EVENT NAME", "Death of Client Test")
										.setText(1, "EVENT DATE", Today)
										.selectValue(1, "START TIME", 10, 1)
										.selectValue(1, "START TIME", 6, 2)
										.selectValue(1, "START TIME", 21, 3)
										.selectValue(1, "START TIME", 1, 4)
										.selectValue(1, "END TIME", 11, 1)
										.selectValue(1, "END TIME", 16, 2)
										.selectValue(1, "END TIME", 26, 3)
										.selectValue(1, "END TIME", 2, 4)
										.selectValue(2, "PROGRAM COMPLETING", 1)
										.selectValue(2, "INCIDENT LOCATION", 2)
										.setText(3, "DATA ENTERER", JeanneClient)
										.setText(3, "DATA ENTERER PHONE", PhoneNumber)
										.setText(3, "DATA ENTERER EMAIL", Email)
										.selectValue(3, "DOES THIS", 1)
										.setText(4, "REPORTER NAME", JeanneClient)
										.setText(4, "REPORTER TITLE", "MA2")
										.setText(4, "REPORTER PHONE", PhoneNumber)
										.selectValue(4, "REPORTER ROLE", 4)
										.selectValue(4, "WERE THEIR", 1)
										.selectValue(4, "GUARDIAN NOTIFIED?", 1)
										.clickCheckBoxFromDropDown(5, "CATEGORY OF EVENT", 3)
										.clickOption(5, "CATEGORY OF EVENT")					
										.clickFormContinue()
										.setText(1, "SUMMARY OF DEATH OF CLIENT", "Testing")
										.selectValue(1, "DEATH DUE TO", "ACCIDENT")
										.clickSubmitAllPages()
										.clickGoBackToList()
										.ReportableEventPage()
										.readReportableEventTab();
					SoftAssert.assertEquals(Actual, Expected);
					
					ID =	Source		.DataTable()
										.setSearch(ReportTitle, Clear)
										.readFirstResultID()
										.replace("Select", EmptyString)
										.replace(" ", EmptyString);
					
					SeleniumHelper.log.info("Verifying Reportable Event is anchored after clicking edit");
					Expected = JeanneAnchoredData + ReportTitle + ":  " + ID;
					Actual = Source		.DataTable()
										.clickFirstRow()
										.clickEdit()
										.Pagefactory()
										.readAnchoredInfo();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying chosen Reportable Event type tab is anchored");
					Expected = "active";
					Actual = Source		.FormPage()
										.isActiveTopTab(2);
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Editing name in Reportable Event Form & verifying reflected changes");
					Expected = "Death of Client";
					Actual = Source		.FormPage()
										.setText(1, "EVENT NAME", "Death of Client", Clear)
										.clickSubmitAllPages()
										.clickGoBackToList()
										.DataTable()
										.setSearch(ReportTitle, Clear)
										.clickFirstRow()
										.clickEdit()
										.FormPage()
										.readTextBoxValue(1, "EVENT NAME");
					SoftAssert.assertEquals(Actual, Expected);

					SoftAssert.assertAll();


		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=4)
	public void ReportableEventViewFunctionalityCheck() {

		SoftAssert = new SoftAssert();
		
		String ReportTitle = "Death of Client Test" + SeleniumHelper.generateRandomNumber(3);
		String Person = "Bambino, Jeanne";

		try{
					SeleniumHelper.log.info("Anchoring a person & verifying Add Edit View Excel tab in Reportable Event Module");
					SeleniumHelper.log.info("Verifying 'Reportable Event Type' Drop Down");
					String[] Value =  {"Select", OCFSType};
					List<String> Values = Arrays.asList(Value);
					
					Expected =	"Reportable Event";
					Actual =	Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(JeanneClient, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickReportableEvent()
										.clickAdd()
										.SeleniumHelper()
										.verifyAllDropDown(Source.ReportableEventPage().ReportableEventTypeDropDown, Values)
										.GetSource()
										.ReportableEventPage()
										.selectReportableEventType(OCFSType)
										.setTitle(ReportTitle)
										.setDescription(Description)
										.GetSource()
										.ReportableEventPage()
										.clickStartReportableEvent()
										.setText(1, "EVENT NAME", "Death of Client Test")
										.setText(1, "EVENT DATE", Today)
										.selectValue(1, "START TIME", 10, 1)
										.selectValue(1, "START TIME", 6, 2)
										.selectValue(1, "START TIME", 21, 3)
										.selectValue(1, "START TIME", 1, 4)
										.selectValue(1, "END TIME", 11, 1)
										.selectValue(1, "END TIME", 16, 2)
										.selectValue(1, "END TIME", 26, 3)
										.selectValue(1, "END TIME", 2, 4)
										.selectValue(2, "PROGRAM COMPLETING", 1)
										.selectValue(2, "INCIDENT LOCATION", 2)
										.setText(3, "DATA ENTERER", JeanneClient)
										.setText(3, "DATA ENTERER PHONE", PhoneNumber)
										.setText(3, "DATA ENTERER EMAIL", Email)
										.selectValue(3, "DOES THIS", 1)
										.setText(4, "REPORTER NAME", JeanneClient)
										.setText(4, "REPORTER TITLE", "MA2")
										.setText(4, "REPORTER PHONE", PhoneNumber)
										.selectValue(4, "REPORTER ROLE", 4)
										.selectValue(4, "WERE THEIR", 1)
										.selectValue(4, "GUARDIAN NOTIFIED?", 1)
										.clickCheckBoxFromDropDown(5, "CATEGORY OF EVENT", 3)
										.clickOption(5, "CATEGORY OF EVENT")
										.clickFormContinue()
										.setText(1, "SUMMARY OF DEATH OF CLIENT", "Testing")
										.selectValue(1, "DEATH DUE TO", "ACCIDENT")
										.clickSubmitAllPages()
										.clickGoBackToList()
										.ReportableEventPage()
										.readReportableEventTab();
					SoftAssert.assertEquals(Actual, Expected);
					
					ID =	Source		.DataTable()
										.setSearch(ReportTitle, Clear)
										.readFirstResultID()
										.replace("Select", EmptyString)
										.replace(" ", EmptyString);
					
					SeleniumHelper.log.info("Verifying Reportable Event is anchored after clicking view");
					Expected = JeanneAnchoredData + ReportTitle + ":  " + ID;
					Actual = Source		.DataTable()
										.clickFirstRow()
										.clickView()
										.Pagefactory()
										.readAnchoredInfo();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying chosen Reportable Event type tab is anchored");
					Expected = "active";
					Actual = Source		.FormPage()
										.isActiveTopTab(2);
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying if text box entry is disabled");
					Expected = True;
					Actual = Source		.FormPage()
										.ifDisabledTextBox(1, "EVENT NAME");
					SoftAssert.assertEquals(Actual, Expected);
					

					SoftAssert.assertAll();


		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
		
}
	
	

