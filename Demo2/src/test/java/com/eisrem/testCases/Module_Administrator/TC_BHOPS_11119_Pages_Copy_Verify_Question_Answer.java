package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11119_Pages_Copy_Verify_Question_Answer extends AdministratorPage{


	@Test(priority=1)
	public void TC_Pages_Copy_Verify_Question_Answer_001() {
		SoftAssert = new SoftAssert();
		int RandNum6 = SeleniumHelper.generateRandomNumber(6);
		String PageName= "TC_Pages_Selenium " + RandNum6;
		String SectionName= "TC_Section_Selenium " + RandNum6;
		
		try{
			SeleniumHelper.log.info("Removing 1st Answer field after adding answer on Question Add Page & verifying if field was removed");
			Expected = Two;
			Actual = Source .AdministratorNavigator()
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
								.setRowName(SectionName, Clear)
								.setSortOrder(OneN, Clear)
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(1)
								.setQuestionLabel(SectionName, Clear)
								.setSortOrder(OneN, Clear)
								.setAnswerValue(1, One, Clear)
								.clickAddValueAnswer()
								.setAnswerValue(2, Two, Clear)
								.clickAddValueAnswer()
								.setAnswerValue(3, Three, Clear)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.clickQAFirstRow()
								.clickQAEdit()
								.clickRemoveAnswerField(1)
								.clickQASave()
								.GetSource()
								.QuestionsAvailableAccord()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.clickQAFirstRow()
								.clickQAEdit()
								.GetSource()
								.SeleniumHelper()
								.waitForPageAJAX()
								.GetSource()
								.QuestionsAvailableAccord()
								.readAnswerValue(1)
								.replace("\"", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Three;
			Actual = Source .QuestionsAvailableAccord()
							.readAnswerValue(2)
							.replace("\"", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = null;
			Actual = Source .QuestionsAvailableAccord()
							.readAnswerValue(3);
			SoftAssert.assertEquals(Actual, Expected);
			
			SizeExpected = 3;
			SizeActual = Source .QuestionsAvailableAccord()
								.AnswerValueTextBoxAll.size();
			SoftAssert.assertEquals(SizeActual, SizeExpected);	
			
			SeleniumHelper.log.info("Copying Question Page & verifying if answer field was copied correctely with answer field removed");
			Expected = Two;
			Actual = Source .QuestionsAvailableAccord()
							.clickSubmitExit()
							.clickPopupOk()
							.PagesPage()
							.setSearch(PageName, Clear)
							.clickFirstRow()
							.clickEdit()
							.PagesPage()
							.clickCopyPage()
							.clickPopupOk()
							.PagesPage()
							.clickBackToList()
							.DataTable()
							.setSearch(PageName, Clear)
							.clickFirstRow()
							.clickView()
							.SectionsAvailableAccord()
							.clickFirstRow()
							.clickView()
							.RowsAvailableAccord()
							.clickRowFirstRow()
							.clickRowView()
							.GetSource()
							.QuestionsAvailableAccord()
							.clickQAFirstRow()
							.clickQAView()
							.GetSource()
							.SeleniumHelper()
							.waitForPageAJAX()
							.GetSource()
							.QuestionsAvailableAccord()
							.readAnswerValue(1)
							.replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Three;
			Actual = Source .QuestionsAvailableAccord()
							.readAnswerValue(2)
							.replace("\"", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = null;
			Actual = Source .QuestionsAvailableAccord()
							.readAnswerValue(3);
			SoftAssert.assertEquals(Actual, Expected);
			
			SizeExpected = 3;
			SizeActual = Source .QuestionsAvailableAccord()
								.AnswerValueTextBoxAll.size();
			SoftAssert.assertEquals(SizeActual, SizeExpected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}