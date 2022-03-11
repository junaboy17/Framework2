package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.Roles;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11362_Conducted_Types_Single_Submit extends AdministratorPage{


	@Test(priority=1)
	public void DataTableTitleCheck() {
		SoftAssert = new SoftAssert();
		
		int RandNum8 = SeleniumHelper.generateRandomNumber(8);
		String PeopleAssessName = "Conducted On People " + RandNum8;
		String PageName= "TC_Pages_Selenium " + RandNum8;
		String SectionName= "TC_Section_Selenium " + RandNum8;
		String RowName= "TC_Row_Selenium " + RandNum8;
		String QuestionLabel= "TC_Question_Selenium " + RandNum8;
		
		try{
			SeleniumHelper.log.info("Adding Questions Avaiable in Administration");
			SeleniumHelper.log.info("Editing question type to index 2 & verifying all answer values are reseted to empty");
			Expected = EmptyString;
//			Actual = 
					Source   	
								.AdministratorNavigator()
								.clickPages()
								.clickAdd()
								.PagesPage()
								.setPageName(PageName, "Y")
								.clickAdd()
								.SectionsAvailableAccord()
								.setSectionName(SectionName, "Y")
								.setSortOrder(OneN, "Y")
								.GetSource()
								.RowsAvailableAccord()
								.clickRowAdd()
								.setRowName(RowName, "Y")
								.setSortOrder(OneN, "Y")
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(1)
								.setQuestionLabel(QuestionLabel, "Y")
								.setSortOrder(OneN, "Y")
								.setAnswerValue(1, "One", "Y")
								.clickAddValueAnswer()
								.setAnswerValue(2, "Two", "Y")
								.clickSubmitExit()
								.clickPopupOk()
								.PagesPage()
								.setSearch(PageName)
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.clickLockForUseToggle()
								.clickYes()
								.PagesPage()
								.clickSubmitExit()
								.clickPopupOk()
								.AdministratorNavigator()
								.clickTypes()
								.clickAdd()
								.TypesPage()
								.selectAppModule(2)
								.setName(PeopleAssessName)
								.setDescription(Description)
								.selectLockTime(1)
								.selectAppAreaToConductType(2)
								.setEndDate(Tomorrow)
								.DataTable()
								.clickAdd()
								.PagesAvailableAccord()
								.setPage(PageName)
								.setSortOrder(OneN)
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(Roles.ALLAPPS.getName())
								.setDescription(Description)
								.clickRolesComplete()
								.TypesPage()
								.clickComplete()
								.DataTable()
								.clickPopupOk()
								.TypesPage()
								.clickSubmitExit()
								.clickPopupOk()
								.TypesPage()
								.setSearch(PeopleAssessName)
								.clickFirstRow()
								.clickEdit()
								.TypesPage()
								.clickLockForUseToggle(True)
								.clickYes()
								.TypesPage()
								.clickSubmitExit()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickPeople()
								.clickFirstRow()
								.clickAnchor()
								.NavigationMenuBar()
								.clickAssessmentForms()
								.clickAdd()
								.Assessment_FormsPage()
								.selectAssessmentType(PeopleAssessName)
								.setTitle("Test")
								.clickStartAssessment()
								.clickSubmitAllPages()
//								.readActiveList()
								;
			SoftAssert.assertEquals(Actual, Expected);

	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
			
		}
	
	}

}