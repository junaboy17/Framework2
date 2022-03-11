package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Question_Required_Default extends AdministratorPage{
	@Test(priority=20)
	public void TC_Question_Required_Default_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Create a new page");
			Expected = False;
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
								.readRequired();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
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
