package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11575_Pages_Questions_Answer_Disabled extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_Pages_Questions_Answer_Disabled() {		
		SoftAssert = new SoftAssert();

			try{
				
				SeleniumHelper.log.info("Create a new page with a question type and verifying disabled answer box");
				Expected = True;
				Actual = Source   	.PagesPage()
									.addPageUnlocked()
									.GetSource()
									.SectionsAvailableAccord()
									.addSection(SectionName, 1, Description, T, T, T)
									.GetSource()
									.RowsAvailableAccord()
									.addRow(RowName, 1, Description, T, T, T)
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
							    	.selectQuestionType(QuestionType.EMAIL.getIndex())
							    	.isAnswerTextBoxDisabled();
				
				SoftAssert.assertEquals(Actual, Expected);
			
				SoftAssert.assertAll();
			
			}catch(Exception e) {
				Source	.SeleniumHelper()
						.assertFail();
			}
		}
		
	}
	
	

