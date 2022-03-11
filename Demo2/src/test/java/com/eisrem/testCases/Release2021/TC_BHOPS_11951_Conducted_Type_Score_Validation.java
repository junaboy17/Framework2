package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;


public class TC_BHOPS_11951_Conducted_Type_Score_Validation extends AdministratorPage  {

	@Test(priority=1)

	public void Type_Add_Conduct_Score()  {
		
		SoftAssert = new SoftAssert();
		try {
			SeleniumHelper.log.info("Creating one page with two score questions and a principle score question,"
					+ " creating a type with the page, ancoring on a client, conducting the type,");		
			Expected =	"67%";
									
			Actual = Source			//Add page with required question	
									.PagesPage()
									.addPage("SCORE TEST PAGE",null ,null , F,"SELENIUM DESCRIPTION")
									.GetSource()
									.SectionsAvailableAccord()
									.addSection("SCORE TEST SECTION", 1, "SELENIUM DESCRIPTION", F, F, T)
									.GetSource()
									.RowsAvailableAccord()
									.addRow("SCORE TEST ROW", 1, null, F, F, T)
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(QuestionType.SCORE.getIndex())
									.setQuestionLabel("SCORE QUESTION 1")
									.setSortOrder("1")
									.clickQASave()
									.clickPopupOkIfExist()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(QuestionType.SCORE.getIndex())
									.setQuestionLabel("SCORE QUESTION 2")
									.setSortOrder("2")
									.clickQASave()
									.clickPopupOkIfExist()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(QuestionType.PRINCIPLE_SCORE.getIndex())
									.setQuestionLabel("PRINCIPLE SCORE QUESTION")
									.setSortOrder("3")
									.selectCalculationStyle(1)
									.setMinValue("0")
									.setMaxValue("3")
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
									.clickPopupOkIfExist()
														
									// add a new type with page created above
									.TypesPage()
									.addType("SCORE TEST TYPE", 
											null, null, AppModule.NOTES.getIndex(), LockTime.NEVER.getIndex(), 
											"SELENIUM DESCRIPTION", F, F, AppAreaConductType.PEOPLE.getIndex())
									
									//Add Page
									.GetSource()
									.PagesAvailableAccord()
									.addPage("SCORE TEST PAGE", 1, null, null, null, T, T)
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
									.clickPopupOkIfExist()

									// anchor on a client and conduct the type
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
									.selectType("SCORE TEST TYPE/ Notes")
									.setTitle("Selenium Test")
									.clickStartAssessment()
									.selectValue(1, "SCORE QUESTION 1", 2)
									.selectValue(1, "SCORE QUESTION 2", 2)
									.readTextBoxValue(1, "PRINCIPLE SCORE QUESTION");	
					
			SoftAssert.assertEquals(Actual, Expected);
					
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
