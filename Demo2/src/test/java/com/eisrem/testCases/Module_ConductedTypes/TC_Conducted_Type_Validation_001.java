package com.eisrem.testCases.Module_ConductedTypes;

import java.util.LinkedList;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.LockTime;
import com.eisrem.Hooks.AdministratorPage;


public class TC_Conducted_Type_Validation_001 extends AdministratorPage  {

	@Test(priority=1)

	public void Type_Add_Conduct_Validate()  {
		
		SoftAssert = new SoftAssert();
		LinkedList<String> triggeredAnswers = new LinkedList<String>();       
		triggeredAnswers.add("THAT");
		try {
			SeleniumHelper.log.info("Creating two pages - required and non required with required and non required questions,"
					+ " creating a type with the pages, ancoring on a client, conducting the type,");
									
					Source			//Add First Page with required question	
									.PagesPage()
									.addPage("REQUIRED PAGE_1",null ,null , F,"TC_Conducted_Types_Validation_001 - page 1")
									.GetSource()
									.SectionsAvailableAccord()
									.addSection("Section 1", 1, "Section for Required Page", F, F, T)
									.GetSource()
									.RowsAvailableAccord()
									.addRow("Row 1", 1, null, F, F, T)
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(QuestionType.CHECK_BOX.getIndex())
									.setQuestionLabel("CHECK BOX 1")
									.setSortOrder("1")
									.setAnswerValue(1, "THIS")
									.clickAddValueAnswer()
									.setAnswerValue(2, "THAT")
									.setQuestionRequired()
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
									
									//Add Second Page with required and non-required questions
									.GetSource()
									.PagesPage()	
									.addPage("NON REQUIRED PAGE_2",null ,null , F,"TC_Conducted_Types_Validation_001 - page 2")
									.GetSource()
									.SectionsAvailableAccord()
									.addSection("Section 1", 1, "Section for Non-Required Page", F, F, T)
									.GetSource()
									.RowsAvailableAccord()
									.addRow("Row 1", 1, null, F, F, T)
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(QuestionType.TEXT_FIELD.getIndex())
									.setQuestionLabel("WRITE SOMETHING")
									.setSortOrder("1")
									.setQuestionRequired()
									.clickQASave()
									.clickPopupOkIfExist()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(QuestionType.TEXT_FIELD.getIndex())
									.setQuestionLabel("NON REQUIRED FIELD")
									.setSortOrder("2")
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
									
									// add a new type with 2 pages created above
									.GetSource()
									.TypesPage()
									.addType("Type with Required and Non-Required Pages", 
											null, null, AppModule.NOTES.getIndex(), LockTime.NEVER.getIndex(), 
											"TC_Conducted_Types_Validation_001", F, F, AppAreaConductType.PEOPLE.getIndex())
									
									//Add Page 1
									.GetSource()
									.PagesAvailableAccord()
									.addPage("REQUIRED PAGE_1", 1, null, null, null, T, T)
									.addRoleToPage(Roles.ALLAPPS.getIndex())
									.clickServicePopulationAvailableAccord()
									.GetSource()
									.PagesAvailableAccord()
									.addServicePopulationToPage(ServicePopulations.CHILDRENS.getIndex())
									.clickCompleteAndOk()
									
									//Add Page 2
									.PagesAvailableAccord()
									.addPage("NON REQUIRED PAGE_2", 2, "REQUIRED PAGE_1", "CHECK BOX 1",
											triggeredAnswers, F, T)
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
									.setSearch(TestClient2, "y")
									.clickFirstRow()
									.clickAnchor()
									.NavigationMenuBar()
									.clickNotes()
									.clickAdd()
									.NotesPage()
									.selectType("Type with Required and Non-Required Pages/ Notes")
									.setTitle("Selenium Test")
									.clickStartAssessment()
									.fillFormActivePage()
									.clickSubmitAllPages()
									.clickPopUpContinue()
									.FormPage()
									.fillFormActivePageSkipRequiredQstn()	// unhappy path
									.clickSubmitAllPages()
									.continueIfError()
									.fillFormActivePage()
									.clickSubmitAllPages()
									.clickGoBackToList()
									;	

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
