package com.eisrem.testCases.Release2022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11356_Sort_Question_Answers_Alpha extends AdministratorPage {

	@Test(priority=1)
	public void TC_BHOPS_11356_Sort_Question_Answers_Alpha_001() {		
		SoftAssert = new SoftAssert();

			try{
				LinkedList<String> answers = new LinkedList<String>();
				answers.add("C");
				answers.add("Z");
				answers.add("K");
				answers.add("A");
				answers.add("32");
				answers.add("1");
				
				SeleniumHelper.log.info("Create a new page with a question and answers and check if sorted");
				ExpectedB = T;
				ActualB = Source   	.PagesPage()
									.addPageUnlocked()
									.GetSource()
									.SectionsAvailableAccord()
									.addSection(SectionName, 1, Description, T, T, T)
									.GetSource()
									.RowsAvailableAccord()
									.addRow(RowName, 1, Description, T, T, T)
									.GetSource()
									.QuestionsAvailableAccord()
									.addQuestion(QuestionLabel, QuestionType.CHECK_BOX.getIndex(), 1, answers, null, null, T, F)
									.clickSortAlpha()
									.answersSorted(answers);
									
				SoftAssert.assertEquals(ActualB, ExpectedB);
				SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
				
				SeleniumHelper.log.info("Create a new page with a question and answers and check if sorted");
				Expected = Success;
				Actual = Source   	.QuestionsAvailableAccord()
									.clickQASave()
									.clickPopupOk()
									.RowsAvailableAccord()
									.clickRowSubmit()
									.readPopUpTitle();

				SoftAssert.assertEquals(Actual, Expected);
				SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
				
				Source.SeleniumHelper().Wait(5);
				
				SeleniumHelper.log.info("End Date the new pages");
				Source				.PagesPage()
									.endDatePageAndSubmit(PagePrefix, Tomorrow);
			
				SoftAssert.assertAll();
			
			}catch(Exception e) {
				Source	.SeleniumHelper()
						.assertFail();
			}
		}
		
	}
	
	

