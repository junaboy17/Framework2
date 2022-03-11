package com.eisrem.testCases.Business.Module_Notes;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.BusinessUserLogIn;
import com.eisrem.Hooks.PeoplePage;

import edu.emory.mathcs.backport.java.util.Arrays;

public class ProviderUserNotes_Add_Edit_View extends BusinessUserLogIn {

	@Test(priority=1)
	public void Notes_Add_Go_Back_To_List() {

		SoftAssert = new SoftAssert();
		
		String NoteTitle = "Transition Note " + SeleniumHelper.generateRandomNumber(3);

		try{
				SeleniumHelper.log.info("Anchoring a person & verifying Add Edit View Excel tab in Notes Module");

					Expected =	Add;
					Actual =	Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(JeanneClient, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickNotes()
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
					
					SeleniumHelper.log.info("Verifying 'Notes Type' Drop Down");
					
					String[] Value =  {"Select", NotesType};
					List<String> Values = Arrays.asList(Value);
					
					Expected =	Submit;
					Actual =	Source	.DataTable()
										.clickAdd()
										.SeleniumHelper()
										.verifyAllDropDown(Source.NotesPage().NotesTypeDropDown, Values)
										.GetSource()
										.NotesPage()
										.selectNotesType(NotesType)
										.setTitle(NoteTitle)
										.setDescription(Description)
										.GetSource()
										.NotesPage()
										.readSubmitBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Print;
					Actual =	Source	.DataTable()
										.readPrintBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	BackToNotes;
					Actual =	Source	.FormPage()
										.readBackToNotesBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	"active";
					Actual =	Source	.NotesPage()
										.clickStartNotes()
										.isActiveTopTab(2);;
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	"Transition Note (V4)";
					Actual =	Source	.FormPage()
										.readTopTab(2);
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Continue;
					Actual =	Source	.FormPage()
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
					
					SeleniumHelper.log.info("Verifying Current Tab");
					
					Expected =	GoBackToPeople;
					Actual =	Source	.FormPage()
										.selectValue(1, "District", 1)
										.selectValue(1, "Youth", 1)
										.setText(2, "Phone", PhoneNumber, Clear)
										.setText(8, "Signature", JeanneSignature, Clear)
										.clickSubmitAllPages()
										.readGoBackToPeople();
					SoftAssert.assertEquals(Actual, Expected);
										
					Expected =	Continue;
					Actual =	Source	.NotesPage()
										.readPopUpContinueBtn();
					SoftAssert.assertEquals(Actual, Expected);
										
					Expected =	GoBackToList;
					Actual =	Source	.NotesPage()
										.readGoBackToListBtn();
					SoftAssert.assertEquals(Actual, Expected);
										
					Expected =	"Notes";
					Actual =	Source	.NotesPage()
										.clickGoBackToList()
										.NotesNavigator()
										.readNotesTab();
					SoftAssert.assertEquals(Actual, Expected);
					

					SoftAssert.assertAll();


		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=2)
	public void Notes_Add_Go_Back_To_People() {

		SoftAssert = new SoftAssert();
		
		String NoteTitle = "Transition Note" + SeleniumHelper.generateRandomNumber(3);

		try{
					SeleniumHelper.log.info("Anchoring a person & verifying Add Edit View Excel tab in Notes Module");
		
					Expected =	Add;
					Actual =	Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(JeanneClient, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickNotes()
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
					
					SeleniumHelper.log.info("Verifying 'Notes Type' Drop Down");
					
					String[] Value =  {"Select", NotesType};
					List<String> Values = Arrays.asList(Value);
					
					Expected =	Submit;
					Actual =	Source	.DataTable()
										.clickAdd()
										.SeleniumHelper()
										.verifyAllDropDown(Source.NotesPage().NotesTypeDropDown, Values)
										.GetSource()
										.NotesPage()
										.selectNotesType(NotesType)
										.setTitle(NoteTitle)
										.setDescription(Description)
										.GetSource()
										.NotesPage()
										.readSubmitBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Print;
					Actual =	Source	.DataTable()
										.readPrintBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	BackToNotes;
					Actual =	Source	.FormPage()
										.readBackToNotesBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	"active";
					Actual =	Source	.NotesPage()
										.clickStartNotes()
										.isActiveTopTab(2);;
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	"Transition Note (V4)";
					Actual =	Source	.FormPage()
										.readTopTab(2);
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected =	Continue;
					Actual =	Source	.FormPage()
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
					
					SeleniumHelper.log.info("Verifying Current Tab");
					
					Expected =	GoBackToPeople;
					Actual =	Source	.FormPage()
										.selectValue(1, "District", 1)
										.selectValue(1, "Youth", 1)
										.setText(2, "Phone", PhoneNumber, Clear)
										.setText(8, "Signature", JeanneSignature, Clear)
										.clickSubmitAllPages()
										.readGoBackToPeople();
					SoftAssert.assertEquals(Actual, Expected);
										
					Expected =	Continue;
					Actual =	Source	.NotesPage()
										.readPopUpContinueBtn();
					SoftAssert.assertEquals(Actual, Expected);
										
					Expected =	GoBackToList;
					Actual =	Source	.NotesPage()
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
	public void NotesEditFunctionalityCheck() {

		SoftAssert = new SoftAssert();
		
		String NoteTitle = "Transition Note" + SeleniumHelper.generateRandomNumber(3);

		try{
					SeleniumHelper.log.info("Anchoring a person & Verifying 'Notes Type' Drop Down");
					String[] Value =  {"Select", NotesType};
					List<String> Values = Arrays.asList(Value);
					
					Expected =	"Notes";
					Actual =	Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(JeanneClient, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickNotes()
										.DataTable()
										.clickAdd()
										.SeleniumHelper()
										.verifyAllDropDown(Source.NotesPage().NotesTypeDropDown, Values)
										.GetSource()
										.NotesPage()
										.selectNotesType(NotesType)
										.setTitle(NoteTitle)
										.setDescription(Description)
										.GetSource()
										.NotesPage()
										.clickStartNotes()
										.selectValue(1, "District", 1)
										.selectValue(1, "Youth", 1)
										.setText(2, "Phone", PhoneNumber, Clear)
										.setText(8, "Signature", JeanneSignature, Clear)
										.clickSubmitAllPages()
										.clickGoBackToList()
										.NotesNavigator()
										.readNotesTab();
					SoftAssert.assertEquals(Actual, Expected);
					
					ID =	Source		.DataTable()
										.setSearch(NoteTitle, Clear)
										.readFirstResultID()
										.replace("Select", EmptyString)
										.replace(" ", EmptyString);
					
					SeleniumHelper.log.info("Verifying Notes is anchored after clicking edit");
					Expected = JeanneAnchoredData + NoteTitle + ":  " + ID;
					Actual = Source		.DataTable()
										.clickFirstRow()
										.clickEdit()
										.Pagefactory()
										.readAnchoredInfo();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying chosen Notes type tab is anchored");
					Expected = "active";
					Actual = Source		.FormPage()
										.isActiveTopTab(2);
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Editing name in Notes Form & verifying reflected changes");
					Expected = "Jeanne Santa Maria";
					Actual = Source		.FormPage()
										.setText(2, "Guardian Name:", "Jeanne Santa Maria", Clear)
										.clickSubmitAllPages()
										.clickGoBackToList()
										.DataTable()
										.setSearch(NoteTitle, Clear)
										.clickFirstRow()
										.clickEdit()
										.FormPage()
										.readTextBoxValue(2, "Guardian Name:");
					SoftAssert.assertEquals(Actual, Expected);

					SoftAssert.assertAll();


		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=4)
	public void NotesViewFunctionalityCheck() {

		SoftAssert = new SoftAssert();
		
		String NoteTitle = "Transition Note" + SeleniumHelper.generateRandomNumber(3);

		try{
					SeleniumHelper.log.info("Anchoring a person & Verifying 'Notes Type' Drop Down");
					String[] Value =  {"Select", NotesType};
					List<String> Values = Arrays.asList(Value);
					
					Expected =	"Notes";
					Actual =	Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(JeanneClient, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickNotes()
										.DataTable()
										.clickAdd()
										.SeleniumHelper()
										.verifyAllDropDown(Source.NotesPage().NotesTypeDropDown, Values)
										.GetSource()
										.NotesPage()
										.selectNotesType(NotesType)
										.setTitle(NoteTitle)
										.setDescription(Description)
										.GetSource()
										.NotesPage()
										.clickStartNotes()
										.selectValue(1, "District", 1)
										.selectValue(1, "Youth", 1)
										.setText(2, "Phone", PhoneNumber, Clear)
										.setText(8, "Signature", JeanneSignature, Clear)
										.clickSubmitAllPages()
										.clickGoBackToList()
										.NotesNavigator()
										.readNotesTab();
					SoftAssert.assertEquals(Actual, Expected);
					
					ID =	Source		.DataTable()
										.setSearch(NoteTitle, Clear)
										.readFirstResultID()
										.replace("Select", EmptyString)
										.replace(" ", EmptyString);
					
					SeleniumHelper.log.info("Verifying Notes is anchored after clicking view");
					Expected = JeanneAnchoredData + NoteTitle + ":  " + ID;
					Actual = Source		.DataTable()
										.clickFirstRow()
										.clickView()
										.Pagefactory()
										.readAnchoredInfo();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying chosen Notes type tab is active");
					Expected = "active";
					Actual = Source		.FormPage()
										.isActiveTopTab(2);
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying if text box entry is disabled in view mode");
					Expected = True;
					Actual = Source		.FormPage()
										.ifDisabledTextBox(2, "Guardian Name:");
					SoftAssert.assertEquals(Actual, Expected);
					

					SoftAssert.assertAll();


		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
		
}
	
	

