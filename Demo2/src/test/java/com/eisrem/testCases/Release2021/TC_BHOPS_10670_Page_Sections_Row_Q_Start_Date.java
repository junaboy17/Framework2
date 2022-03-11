package com.eisrem.testCases.Release2021;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.DataTableHeaders;
import com.eisrem.AppUtils.Enumerations.QuestionType;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.PeoplePage;

import edu.emory.mathcs.backport.java.util.Arrays;

public class TC_BHOPS_10670_Page_Sections_Row_Q_Start_Date extends AdministratorPage {

	@Test(priority=1)
	public void TC_Page_Sections_Row_Q_Start_Date() {		
		SoftAssert = new SoftAssert();

			try{
				
				SeleniumHelper.log.info("Create a new page with a question created before a required answer");
				Expected = Success;
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
									.addQuestion(QuestionLabel, QuestionType.TEXT_FIELD.getIndex(), 1, null, null, null, T, F)
									.GetSource()
									.RolesAvailableAccord()
									.addRole()
									.GetSource()
									.QuestionsAvailableAccord()
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
				
				SeleniumHelper.log.info("Edit page start date");
				Expected = Success;
				Actual = Source		.DataTable()
									.clickPopupOk()
									.PagesPage()
									.setStartDate(Tomorrow, Clear)		
									.clickSubmit()
									.readPopUpTitle();
				
				SoftAssert.assertEquals(Actual, Expected);
				SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
				
				SeleniumHelper.log.info("Continue test with edit - confirming start date");
				HashMap<DataTableHeaders, String> data = Source	
									.NavigationMenuBar()
									.setSearch(PagePrefix)
									.getDataByRow(OneN);
				
				SeleniumHelper.log.info("Check Copy Paged Edited Start Date is Equal to Tomorrow");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.START_DATE) != null && data.get(DataTableHeaders.START_DATE).equals(Tomorrow);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Edit page and check section start date equals tomorrow");
				Expected = Success;
				data = Source   	.PagesPage()
									.clickFirstRow()
									.clickEdit()
									.PagesPage()
									.getDataByRow(OneN,SectionsTable);
				
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.START_DATE) != null && data.get(DataTableHeaders.START_DATE).equals(Tomorrow);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Edit section and check row start date equals tomorrow");
				Expected = Success;
				data = Source   	.PagesPage()
									.clickFirstRow()
									.clickEdit()
									.SectionsAvailableAccord()
									.getDataByRow(OneN,RowsTable);
				
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.START_DATE) != null && data.get(DataTableHeaders.START_DATE).equals(Tomorrow);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Edit Question and check row start date remains null");
				Expected = Success;
				data = Source   	.RowsAvailableAccord()
									.clickRowFirstRow()
									.clickRowEdit()
									.getDataByRow(OneN,QuestionsTable);
				
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.START_DATE).isEmpty();				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Edit Question and check Role start date equals tomorrow");
				Expected = Success;
				data = Source   	.QuestionsAvailableAccord()
									.clickQAFirstRow()
									.clickQAEdit()
									.getDataByRow(OneN, RoleTable);
				
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.START_DATE) != null && data.get(DataTableHeaders.START_DATE).equals(Tomorrow);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				SeleniumHelper.log.info("Actual: " + ActualB + "   Expected: " + ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Submit Page successfully");
				Expected = Success;
				Actual = Source   	.QuestionsAvailableAccord()
									.clickSubmitExit()
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