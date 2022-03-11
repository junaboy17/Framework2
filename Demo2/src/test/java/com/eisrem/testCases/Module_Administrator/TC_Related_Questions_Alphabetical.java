package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.AppUtils.Enumerations.QuestionType;

public class TC_Related_Questions_Alphabetical extends AdministratorPage{
	@Test(priority=1)
	public void TC_Related_Questions_Alphabetical_001() {		
		SoftAssert = new SoftAssert();
		
		int RandNum8 = SeleniumHelper.generateRandomNumber(8);
		String PageName= "TC_Pages_Selenium " + RandNum8;
		String SectionName= "TC_Section_Selenium " + RandNum8;
		String RowName= "TC_Row_Selenium " + RandNum8;

		try{	
			SeleniumHelper.log.info("Create a new page");
			Expected = True;
			Actual = Source		.PagesPage()
								.addPage(PageName, Today, null, F, null)
								.GetSource()
								.SectionsAvailableAccord()
								.addSection(SectionName, 1, null, T, T, T)
								.GetSource()
								.RowsAvailableAccord().addRow(RowName, 1, null, T, T, T)
								.GetSource()
								.QuestionsAvailableAccord()
								.addQuestion( QuestionType.CHECK_BOX.getName(), QuestionType.CHECK_BOX.getIndex(), 1, null, null, null, T, F)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.addQuestion( QuestionType.TEXT_FIELD.getName(), QuestionType.TEXT_FIELD.getIndex(), 2, null, null, null, T, F)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.addQuestion( QuestionType.DATE_FIELD.getName(), QuestionType.DATE_FIELD.getIndex(), 3, null, null, null, T, F)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.addQuestion( QuestionType.INTEGER_FIELD.getName(), QuestionType.INTEGER_FIELD.getIndex(), 4, null, null, null, T, F)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.isRelatedToQuestionAlphaSort();
			
			SoftAssert.assertEquals(Actual, Expected);	
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Create a new page");
			Expected = True;
			Actual = Source		.QuestionsAvailableAccord()
								.setQuestionLabel("Second".concat(QuestionType.INTEGER_FIELD.getName()))
								.selectQuestionType(QuestionType.INTEGER_FIELD.getIndex())
								.setSortOrder(FiveN)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.isRelatedToQuestionAlphaSort();
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);

			SeleniumHelper.log.info("End Date the new page");
			Source				.QuestionsAvailableAccord()
								.clickQABack()
								.clickRowSubmit()
								.clickPopupOk()
								.PagesPage()
								.endDatePageAndSubmit(PagePrefix, Today);
		
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}
