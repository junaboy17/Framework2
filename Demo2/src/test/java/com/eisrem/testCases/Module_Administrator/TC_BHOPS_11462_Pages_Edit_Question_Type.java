package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11462_Pages_Edit_Question_Type extends AdministratorPage{


	@Test(priority=1)
	public void TC_Pages_Edit_Question_Type_001() {
		SoftAssert = new SoftAssert();
		
		int RandNum8 = SeleniumHelper.generateRandomNumber(8);
		String PageName= "TC_Pages_Selenium " + RandNum8;
		String SectionName= "TC_Section_Selenium " + RandNum8;
		String RowName= "TC_Row_Selenium " + RandNum8;
		String QuestionLabel= "TC_Question_Selenium " + RandNum8;

		try{
			SeleniumHelper.log.info("Adding Questions Avaiable in Administration");
			SeleniumHelper.log.info("Editing question type to index 2 & verifying all answer values are reseted to empty");
			Expected = null;
			Actual = Source   	.AdministratorNavigator()
								.clickPages()
								.clickAdd()
								.PagesPage()
								.setPageName(PageName, Clear)
								.clickAdd()
								.SectionsAvailableAccord()
								.setSectionName(SectionName, Clear)
								.setSortOrder(OneN, Clear)
								.GetSource()
								.RowsAvailableAccord()
								.clickRowAdd()
								.setRowName(RowName, Clear)
								.setSortOrder(OneN, Clear)
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(1)
								.setQuestionLabel(QuestionLabel, Clear)
								.setSortOrder(OneN, Clear)
								.setAnswerValue(1, One, Clear)
								.clickAddValueAnswer()
								.setAnswerValue(2, Two, Clear)
								.clickQASave()
								.clickPopupOkIfExist()
								.QuestionsAvailableAccord()
								.clickQAFirstRow()
								.clickQAEdit()
								.selectQuestionType(2)
								.readAnswerValue(1);
			SoftAssert.assertEquals(Actual, Expected);
						
			ExpectedB = false;
			ActualB = Source   	.SeleniumHelper()
								.ifWebElementExists(Source.QuestionsAvailableAccord().AnswerValue2TB, 1);				
			SoftAssert.assertEquals(ActualB, ExpectedB);
			
			SeleniumHelper.log.info("Editing question type to index 3 & verifying all answer values are reseted to empty");
			Expected = null;
			Actual = Source   	.QuestionsAvailableAccord()
								.setAnswerValue(1, Three, Clear)
								.clickAddValueAnswer()
								.setAnswerValue(2, Four, Clear)
								.clickQASave()
								.clickPopupOkIfExist()					
								.QuestionsAvailableAccord()
								.clickQAFirstRow()
								.clickQAEdit()
								.selectQuestionType(3)
								.readAnswerValue(1);
			SoftAssert.assertEquals(Actual, Expected);
			
			ExpectedB = false;
			ActualB = Source   	.SeleniumHelper()
								.ifWebElementExists(Source.QuestionsAvailableAccord().AnswerValue2TB, 1);
			SoftAssert.assertEquals(ActualB, ExpectedB);
			
			SeleniumHelper.log.info("Verifying if all fields are disabled after lock is enabled");
								
			ExpectedB = false;
			ActualB = 	Source  .QuestionsAvailableAccord()
								.clickQASave()
								.clickPopupOkIfExist()				
								.RowsAvailableAccord()
								.clickRowsBack()
								.clickSectionsBack()
								.clickLockForUseToggle()
								.clickYes()
								.PagesPage()
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.clickRowFirstRow()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAFirstRow()
								.clickQAEdit()
								.allFieldsDisabled();
			SoftAssert.assertEquals(ActualB, ExpectedB);
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
			
		}
	
	}

}