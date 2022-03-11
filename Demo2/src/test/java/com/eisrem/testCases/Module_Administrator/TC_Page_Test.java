package com.eisrem.testCases.Module_Administrator;

import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

import edu.emory.mathcs.backport.java.util.Arrays;

public class TC_Page_Test extends AdministratorPage{

	@Test(priority=1)
	public void TC_Page_Test_Page_001() {		
		SoftAssert = new SoftAssert();

		try{
			LinkedList<String> relateToAnswer = new LinkedList<String>();
			relateToAnswer.add("Trigger Related Question");
			SeleniumHelper.log.info("Create a new page with questions to test");
			Expected = Success;
			Actual = Source   	.PagesPage()
								.addPageUnlocked()
								.GetSource()
								.SectionsAvailableAccord()
								.addSection()
								.GetSource()
								.RowsAvailableAccord()
								.addRow()
								.GetSource()
								.QuestionsAvailableAccord()
								.addQuestion("Selenium Question", QuestionType.CHECK_BOX.getIndex(), 1, relateToAnswer, null, null, T, F)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.addQuestion("Question to be Triggered", QuestionType.INTEGER_FIELD.getIndex(), 2, null, "Selenium Question", relateToAnswer, T, F)
								.clickQASave()
								.clickPopupOk()
								.RowsAvailableAccord()
								.clickRowSubmit()
								.readPopUpTitle();	
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Edit page and click test tab");
			Expected = True;
			Actual = Source   	.PagesPage()
								.setSearch(PagePrefix)
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.clickTestPage()
								.isTriggeredExist();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("End Date the new page");
			Source				.PagesPage()
								.clickTestBack()
								.clickBackToList()
								.PagesPage()
								.endDatePageAndSubmit(PagePrefix, Today);
		
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Test(priority=2)
	public void TC_Pages_Copy_001() {		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Create an array to hold value for names. ex Section name: A, Row name: A, Question name: A");
			List<String> names =  Arrays.asList(new String[]{"A", "B", "C"});
			
			SeleniumHelper.log.info("Create a new page with a question created before a required answer");
			Expected = Success;
			Actual = Source   	.PagesPage()
								.addPageUnlocked()
								.GetSource()
								.SectionsAvailableAccord()
								.addSection(names.get(0), 1, Description, T, T, T)
								.GetSource()
								.RowsAvailableAccord()
								.addRow(names.get(0), 1, Description, T, T, T)
								.GetSource()
								.QuestionsAvailableAccord()
								.addQuestion(names.get(0), QuestionType.TEXT_FIELD.getIndex(), 1, null, null, null, T, F)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.addQuestion(names.get(1), QuestionType.TEXT_FIELD.getIndex(), 2, null, null, null, T, F)
								.clickQASave()
								.clickPopupOk()
								.RowsAvailableAccord()
								.clickRowsBack()
								.clickSectionsBack()
								.GetSource()
								.SectionsAvailableAccord()
								.addSection(names.get(1), 1, Description, T, T, T)
								.GetSource()
								.RowsAvailableAccord()
								.addRow(names.get(1), 2, Description, T, T, T)
								.GetSource()
								.QuestionsAvailableAccord()
								.addQuestion(names.get(2), QuestionType.TEXT_FIELD.getIndex(), 1, null, null, null, T, F)
								.clickQASave()
								.clickPopupOk()
								.RowsAvailableAccord()
								.clickRowsBack()
								.clickSectionsBack()
								.setSearch(names.get(0))
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.setSearch(names.get(0))
								.clickRowFirstRow()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.setSearch(names.get(0))
								.clickQAFirstRow()
								.clickQAEdit()
								.selectRelateToQuestionDropDown(names.get(1))
								.selectRelateToAnswer(new Integer[] {1})
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.setSearch(names.get(1) + "/")
								.clickQAFirstRow()
								.clickQAEdit()
								.selectRelateToQuestionDropDown(names.get(2))
								.selectRelateToAnswer(new Integer[] {1})
								.clickQASave()
								.clickPopupOk()
								.RowsAvailableAccord()
								.clickRowSubmit()
								.readPopUpTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Edit page and click copy");
			Expected = Success;
			Actual = Source   	.PagesPage()
								.setSearch(PagePrefix)
								.clickFirstRow()
								.clickEdit()
								.PagesPage()								
								.clickCopyPage()
								.readPopUpTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("End Date the new pages");
			Source				.PagesPage()
								.clickPopupOk()
								.PagesPage()
								.setPageName(Source.SeleniumHelper().generateRandomAlphaNumeric(12),EmptyString)
								.setEndDate(Today)
								.clickSubmit()
								.clickPopupOk()
								.PagesPage()
								.endDatePageAndSubmit(PagePrefix, Today);
		
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=3)
	public void  TC_Page_Test_Form_Conducted_Type_Field_001() {		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Create a page and test if conducted type question field is disabled");
			Expected = True;
			Actual = Source		.PagesPage()
								.addPageUnlocked()
								.GetSource()
								.SectionsAvailableAccord()
								.addSection()
								.GetSource()
								.RowsAvailableAccord()
								.addRow()
								.GetSource()
								.QuestionsAvailableAccord()
								.addQuestion(QuestionLabel, QuestionType.CONDUCTED_TYPE_SEARCH.getIndex(), 1, null, null, null, T, F)
								.clickQASave()
								.clickPopupOk()
								.RowsAvailableAccord()
								.clickRowSubmit()
								.clickPopupOk()
								.PagesPage()
								.setSearch(PagePrefix)
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.clickTestPage()
								.isQuestionDisabled();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
	
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}
