package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Add_View_Page_Section_Row_Question extends AdministratorPage{
	@Test(priority=1)
	public void TC_Add_Page_Section_Row_Question_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Create a new page");
			String pageName = Source.PagesPage().addPageUnlockedGetNameAndSubmit();	
			
			SeleniumHelper.log.info("Create a new section");
			String sectionName = Source.SectionsAvailableAccord().addSectionGetNameAndSubmit(pageName);	
			
			SeleniumHelper.log.info("Create a new row");
			String rowName = Source.RowsAvailableAccord().addRowGetNameAndSubmit(pageName, sectionName);	
			
			SeleniumHelper.log.info("Create a new question");
			String questionName = Source.QuestionsAvailableAccord().addQuestionGetNameAndSubmit(pageName, sectionName, rowName);	
			
			SeleniumHelper.log.info("Add a Role");
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
								.setSearch(questionName)
								.clickQAFirstRow()
								.clickQAEdit()
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(Roles.ALLAPPS.getName())
								.clickRolesComplete()
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
	public void TC_View_Page_Section_Row_Question_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Create a new page");
			String pageName = Source.PagesPage().addPageUnlockedGetNameAndSubmit();	
			
			SeleniumHelper.log.info("Create a new section");
			String sectionName = Source.SectionsAvailableAccord().addSectionGetNameAndSubmit(pageName);	
			
			SeleniumHelper.log.info("Create a new row");
			String rowName = Source.RowsAvailableAccord().addRowGetNameAndSubmit(pageName, sectionName);	
			
			SeleniumHelper.log.info("Create a new question");
			String questionName = Source.QuestionsAvailableAccord().addQuestionGetNameAndSubmit(pageName, sectionName, rowName);	
			
			SeleniumHelper.log.info("Create a new role");
			Source.RolesAvailableAccord().addQARoleAndSubmit(pageName, sectionName, rowName, questionName);	
			
			SeleniumHelper.log.info("View a Role");
			Expected = Success;
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
								.setSearch(questionName)
								.clickQAFirstRow()
								.clickQAView()
								.GetSource()
								.RolesAvailableAccord()
								.clickQuestionRolesFirstRow()
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesView()
								.clickRolesCancel()
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

}