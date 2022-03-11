package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_12189_Document_Search_Conducted_Type extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_People_Documents_User_Access() {
		
		SoftAssert = new SoftAssert();
				
		try{
			 String documentName = DocumentName.concat(SeleniumHelper.generateRandomAlpha(5));
				
				//Cannot add documents in development
				if(!Source.SeleniumHelper().isDev())
				{
					SeleniumHelper.log.info("Creating new person to work with if UAT else use Jeannes Person if Dev");
					String peoId = Source.PeoplePage().addPersonReturnId();
					
					SeleniumHelper.log.info("Adding Document and to person");		
					String docId = Source	.DataTable()
										.setSearch(peoId, Clear)	
										.clickFirstRow()
										.clickAnchor()
										.PeopleNavigator()
										.clickDocumentsTab()
										.clickAdd()
										.DocumentsPage()
										.setTitle(documentName)
										.setDocumentFile(DocumentPath, DocumentFile)
										.clickSubmit()
										.clickPopupOk()
										.DataTable()
										.readFirstResultID();
					
						
					SeleniumHelper.log.info("Test popup when no doc selected");	
					Expected = "No document is selected in document lookup.";
					Actual =Source		.NavigationMenuBar()		
										.clickAdministrator()
										.GetSource()
										.PagesPage()
										.addPage(documentName,null ,null , F, Description)
										.GetSource()
										.SectionsAvailableAccord()
										.addSection(documentName, 1, Description, F, F, T)
										.GetSource()
										.RowsAvailableAccord()
										.addRow(documentName, 1, null, F, F, T)
										.GetSource()
										.QuestionsAvailableAccord()
										.clickQAAdd()
										.selectQuestionType(QuestionType.DOCUMENT_LOOKUP.getIndex())
										.setQuestionLabel("DOCUMENT QUESTION")
										.setSortOrder(OneN)
										.clickQASave()
										.clickPopupOkIfExist()
										.RowsAvailableAccord()
										.clickRowsBack()
										.GetSource()
										.SectionsAvailableAccord()
										.clickSectionsBack()
										.GetSource()
										.PagesPage()
										.clickLockForUseToggle()
										.clickYes()
										.PagesPage()	
										.clickSubmitExit()
										.GetSource()
										.SeleniumHelper()
										.sleep(5)
											
											
										// add a new type with page created above
										.GetSource()
										.TypesPage()
										.addType(documentName, 
												null, null, AppModule.NOTES.getIndex(), LockTime.NEVER.getIndex(), 
												Description, F, F, AppAreaConductType.PEOPLE.getIndex())
										
										//Add Page
										.GetSource()
										.PagesAvailableAccord()
										.addPage(documentName, 1, null, null, null, T, T)
										.addRoleToPage(Roles.ALLAPPS.getIndex())
										.clickServicePopulationAvailableAccord()
										.GetSource()
										.PagesAvailableAccord()
										.addServicePopulationToPage(ServicePopulations.CHILDRENS.getIndex())
										.clickCompleteAndOk()
										
										//Lock type for use
										.TypesPage() 
										.clickLockForUseToggle()
										.clickYes()
										.TypesPage()
										.clickSubmitExit()
										.GetSource()
										.SeleniumHelper()
										.sleep(5)
										// anchor on a client and conduct the type
										.GetSource()
										.NavigationMenuBar()
										.clickPeople()
										.DataTable()
										.setSearch(peoId, Clear)
										.clickFirstRow()
										.clickAnchor()
										.NavigationMenuBar()
										.clickNotes()
										.clickAdd()
										.NotesPage()
										.selectType(documentName.concat("/ Notes"))
										.setTitle(documentName)
										.clickStartAssessment()
										.clickFormDownload()
										.readPopUpMessage();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Select document");
					Expected = "\"" + docId.concat(" ").concat(documentName) + "\"";
					Actual =Source		.DataTable()
										.clickPopupOk()
										.FormPage()
										.setComboBox("DOCUMENT QUESTION", docId, Clear)
										.readComboBoxValue(1, "DOCUMENT QUESTION");
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Save conducted type and check edit");	
					Expected = "\"" + docId.concat(" ").concat(documentName) + "\"";
					Source				.FormPage()
										.clickSubmitAllPages()
										.GetSource()
										.SeleniumHelper()
										.Wait(10)
										.GetSource()
										.FormPage()
										.clickBackToList()
										.DataTable()
										.clickFirstRow()
										.clickEdit()
										.FormPage()
										.clickFormDownload()
										.readComboBoxValue(1, "DOCUMENT QUESTION");
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Save conducted type and check view");	
					Expected = "\"" + docId.concat(" ").concat(documentName) + "\"";
					Source				.FormPage()
										.clickSubmitAllPages()
										.GetSource()
										.SeleniumHelper()
										.Wait(10)
										.GetSource()
										.FormPage()
										.clickBackToList()
										.DataTable()
										.clickFirstRow()
										.clickView()
										.FormPage()
										.clickFormDownload()
										.readComboBoxValue(1, "DOCUMENT QUESTION");
					SoftAssert.assertEquals(Actual, Expected);
					
					Source.NavigationMenuBar().clickAdministrator().GetSource().TypesPage().endDateType(documentName);
					
					SoftAssert.assertAll();
				}

				SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}
	
	

