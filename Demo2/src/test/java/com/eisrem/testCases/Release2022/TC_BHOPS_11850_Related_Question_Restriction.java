package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11850_Related_Question_Restriction extends AdministratorPage{

	@Test(priority=1)
	public void TC_Related_Question_Restriction() {		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Create a new page with related questions to start");
			Expected = "None";
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
								.clickQAAdd()
								.selectQuestionType(1)
								.setQuestionLabel(SectionName, Clear)
								.setSortOrder(OneN, Clear)
								.setAnswerValue(1, One, Clear)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(1)
								.setQuestionLabel("test123")
								.setSortOrder(OneN, Clear)
								.setAnswerValue(1, One, Clear)
								.selectRelateToQuestionDropDown(1)
								.selectRelateToAnswer(new String[] {"One"})
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQASave()
								.clickPopupOk()
								.RowsAvailableAccord()
								.clickRowSubmit()
								.clickPopupOk()
								//remove the related question
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.GetSource()
								.SectionsAvailableAccord()
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.clickRowFirstRow()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.setSearch("test")
								.clickQAFirstRow()
								.clickQAEdit()
								.selectRelateToQuestionDropDown(0)
								.clickQASave()
								.clickPopupOk()
								.RowsAvailableAccord()
								.clickRowSubmit()
								.clickPopupOk()
								//copy page and confirm the related question is not present
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.clickCopyPage()
								.clickPopupOk()
								.PagesPage()
								.clickBackTo()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.PagesPage()
								.GetSource()
								.SectionsAvailableAccord()
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.clickRowFirstRow()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.setSearch("test123")
								.clickQAFirstRow()
								.clickQAEdit()
								.readFirstRelateToQuestionDropDown();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
					
				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}
