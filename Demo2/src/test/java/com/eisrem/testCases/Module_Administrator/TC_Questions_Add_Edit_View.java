package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Questions_Add_Edit_View extends AdministratorPage{
	
	@Test(priority=1)
	public void TC_Question_Add_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Create a new page");
			String pageName = Source.PagesPage().addPageUnlockedGetNameAndSubmit();	
			
			SeleniumHelper.log.info("Create a new section");
			String sectionName = Source.SectionsAvailableAccord().addSectionGetNameAndSubmit(pageName);	
			
			SeleniumHelper.log.info("Create a new row");
			String rowName = Source.RowsAvailableAccord().addRowGetNameAndSubmit(pageName, sectionName);	
			
			SeleniumHelper.log.info("Add a Question");
			Expected = "\"W\"";
			Actual = Source   	.NavigationMenuBar()
								.GetSource()
								.DataTable()
								.setSearch(pageName)
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.GetSource()
								.DataTable()
								.setSearch(sectionName)
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.setSearch(rowName)
								.clickRowFirstRow()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.setQuestionLabel(QuestionType.TEXT_AREA.getName())
								.selectQuestionType(QuestionType.TEXT_AREA.getIndex())
								.setSortOrder(OneN)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.setQuestionLabel(QuestionType.CONDUCTED_TYPE_SEARCH.getName())
								.selectQuestionType(QuestionType.CONDUCTED_TYPE_SEARCH.getIndex())
								.setSortOrder(TwoN)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.setQuestionLabel(QuestionType.CHOICE_BOX.getName())
								.selectQuestionType(QuestionType.CHOICE_BOX.getIndex())
								.setSortOrder(ThreeN)
								.setAnswerValue(1, "W")
								.clickAddValueAnswer()
								.setAnswerValue(2, "M")
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.setSearch(QuestionType.CHOICE_BOX.getName())
								.clickQAFirstRow()
								.clickQAEdit()
								.readAnswerValue();
			SoftAssert.assertEquals(Actual, Expected);	
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
								
			SeleniumHelper.log.info("Save Questions");
			Expected = Success;
			Actual = Source   	.NavigationMenuBar()
								.GetSource()					
								.QuestionsAvailableAccord()
								.clickSubmitExit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("End Date the new page");
			Source.PagesPage().endDatePageAndSubmit(pageName, Today);
		
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2)
	public void TC_Question_Add_Multi_Value_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Create a new page");
			String pageName = Source.PagesPage().addPageUnlockedGetNameAndSubmit();	
			
			SeleniumHelper.log.info("Create a new section");
			String sectionName = Source.SectionsAvailableAccord().addSectionGetNameAndSubmit(pageName);	
			
			SeleniumHelper.log.info("Create a new row");
			String rowName = Source.RowsAvailableAccord().addRowGetNameAndSubmit(pageName, sectionName);	
			
			SeleniumHelper.log.info("Add a Question");
			Expected = Success;
			Actual = Source   	.NavigationMenuBar()
								.GetSource()
								.DataTable()
								.setSearch(pageName)
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.GetSource()
								.DataTable()
								.setSearch(sectionName)
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.setSearch(rowName)
								.clickRowFirstRow()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.setQuestionLabel(QuestionType.CHECK_BOX.getName())
								.selectQuestionType(QuestionType.CHECK_BOX.getIndex())
								.setSortOrder(OneN)
								.setAnswerValue(1, One)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.setQuestionLabel(QuestionType.CHOICE_BOX.getName())
								.selectQuestionType(QuestionType.CHOICE_BOX.getIndex())
								.setSortOrder(TwoN)
								.setAnswerValue(1, One)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.setQuestionLabel(QuestionType.LIST_BOX.getName())
								.selectQuestionType(QuestionType.LIST_BOX.getIndex())
								.setSortOrder(ThreeN)
								.setAnswerValue(1, One)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.setQuestionLabel(QuestionType.RADIO_BUTTON.getName())
								.selectQuestionType(QuestionType.RADIO_BUTTON.getIndex())
								.setSortOrder(FourN)
								.setAnswerValue(1, One)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.setSearch(QuestionType.CHECK_BOX.getName())
								.clickQAFirstRow()
								.clickQAEdit()
								.setAnswerValue(2, Two)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.setSearch(QuestionType.CHOICE_BOX.getName())
								.clickQAFirstRow()
								.clickQAEdit()
								.setAnswerValue(2, Two)
								.clickQASave()
								.GetSource()
								.SeleniumHelper()
								.Wait(5)
								.GetSource()
								.Pagefactory()
								.clickPopupOkIfExist()
								.QuestionsAvailableAccord()
								.setSearch(QuestionType.LIST_BOX.getName())
								.clickQAFirstRow()
								.clickQAEdit()
								.setAnswerValue(2, Two)
								.clickQASave()
								.GetSource()
								.SeleniumHelper()
								.Wait(5)
								.GetSource()
								.Pagefactory()
								.clickPopupOkIfExist()
								.QuestionsAvailableAccord()
								.setSearch(QuestionType.RADIO_BUTTON.getName())
								.clickQAFirstRow()
								.clickQAEdit()
								.setAnswerValue(2, Two)
								.clickQASave()
								.GetSource()
								.SeleniumHelper()
								.Wait(5)
								.GetSource()
								.Pagefactory()
								.clickPopupOkIfExist()
								.RowsAvailableAccord()
								.clickSubmitExit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("End Date the new page");
			Source.PagesPage().endDatePageAndSubmit(pageName, Today);
		
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=3)
	public void TC_Questions_View_002() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Create a new page");
			String pageName = Source.PagesPage().addPageUnlockedGetNameAndSubmit();	
			
			SeleniumHelper.log.info("Create a new section");
			String sectionName = Source.SectionsAvailableAccord().addSectionGetNameAndSubmit(pageName);	
			
			SeleniumHelper.log.info("Create a new row");
			String rowName = Source.RowsAvailableAccord().addRowGetNameAndSubmit(pageName, sectionName);	
			
			SeleniumHelper.log.info("Add a Question");
			Expected = Success;
			Actual = Source   	.NavigationMenuBar()
								.GetSource()
								.DataTable()
								.setSearch(pageName)
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.GetSource()
								.DataTable()
								.setSearch(sectionName)
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.setSearch(rowName)
								.clickRowFirstRow()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.setQuestionLabel(QuestionType.CHECK_BOX.getName())
								.selectQuestionType(QuestionType.CHECK_BOX.getIndex())
								.setSortOrder(OneN)
								.clickQASave()
								.clickPopupOk()
								.RowsAvailableAccord()
								.clickRowSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			

			SeleniumHelper.log.info("Add a Question");
			Expected = True;
			Actual = Source   	.NavigationMenuBar()
								.GetSource()
								.DataTable()
								.setSearch(pageName)
								.clickFirstRow()
								.clickView()
								.PagesPage()
								.GetSource()
								.DataTable()
								.setSearch(sectionName)
								.clickFirstRow()
								.clickView()
								.RowsAvailableAccord()
								.setSearch(rowName)
								.clickRowFirstRow()
								.clickRowView()
								.GetSource()
								.QuestionsAvailableAccord()
								.setSearch(QuestionType.CHECK_BOX.getName())
								.clickQAFirstRow()
								.clickQAView()
								.isRemoveButtonHidden();
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Add a Question");
			Expected = Success;
			Actual = Source		.QuestionsAvailableAccord()
								.clickSubmitExit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("End Date the new page");
			Source.PagesPage().endDatePageAndSubmit(pageName, Today);
		
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}