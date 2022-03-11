package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Types_Add_Edit_View extends AdministratorPage{

	@Test(priority=1)
		public void TC_Types_Add_002() {		
			SoftAssert = new SoftAssert();
			String TypeName = "TC_Types_Selenium " + SeleniumHelper.generateRandomNumber(8);
	
			try{
			SeleniumHelper.log.info("Create Type with two pages and confirm test form loads on first tab");
			Expected = "DATA FIX FORM";
			Actual = Source		.NavigationMenuBar()
								.GetSource()
								.DataTable()
								.clickAdd()
								.TypesPage()
								.selectAppModule(AppModule.NOTES.getIndex())
								.setName(TypeName)
								.setDescription(Description)
								.selectLockTime(LockTime.NEVER.getIndex())
								.selectAppAreaToConductType(AppAreaConductType.BOTH.getIndex())
								.clickAdd()
								.PagesAvailableAccord()
								.setPage(DataFixForm)
								.setSortOrder(OneN)
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(Roles.ALLAPPS.getIndex())
								.setDescription(Description)
								.clickRolesComplete()
								.PagesAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation(ServicePopulations.CHILDRENS.getIndex())
								.setDescription(Description)
								.clickSpComplete()
								.PagesAvailableAccord()
								.clickComplete()
								.DataTable()
								.clickPopupOk()
								.TypesPage()
								.clickAdd()
								.PagesAvailableAccord()
								.setPage("Children's Client Access form")
								.setSortOrder(TwoN)
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(Roles.ALLAPPS.getIndex())
								.setDescription(Description)
								.clickRolesComplete()
								.PagesAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation(ServicePopulations.CHILDRENS.getIndex())
								.setDescription(Description)
								.clickSpComplete()
								.PagesAvailableAccord()
								.clickComplete()
//								.DataTable()
//								.clickPopupOk()
								.SeleniumHelper()
								.sleep(5)
								.GetSource()
								.TypesPage()
								.clickTestForm()
								.clickTestFormFirstPage()
								.readTestFormFirstPageBtn();
								
			SeleniumHelper.log.info("Confirm Second Tab");
			Expected = "Children's Client Access form";
			Actual = Source		.TypesPage()
								.clickTestFormFirstPage2()
								.readTestFormFirstPageBtn2();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Save Type");
			Expected = Success;	
			Actual = Source	.TypesPage()
								.clickTestBackBtn()
								.clickLockForUseToggle()
								.clickYes()
								.TypesPage()
								.clickSubmitExit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}

	@Test(priority=2)
	public void TC_Types_Edit_001() {		
		SoftAssert = new SoftAssert();

			try{
			SeleniumHelper.log.info("Create a new type");
			Source.TypesPage().addCompleteTypeUnlockedAndSubmit();	
				
			SeleniumHelper.log.info("Edit a Type, Role and Service Population");
			Expected = Success;
			Actual = Source		.NavigationMenuBar()
								.GetSource()
								.DataTable()
								.setSearch(TypePrefix)
								.clickFirstRow()
								.clickEdit()
								.TypesPage()
								.setDescription(DescriptionUpdated)
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.PagesAvailableAccord()
								.setSortOrder(TwoN)
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesRow(1)
								.clickRolesEdit()
								.setDescription(DescriptionUpdated, Clear)
								.clickRolesComplete()
								.PagesAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpRow(1)
								.clickSpEdit()
								.setDescription(DescriptionUpdated,Clear)
								.clickSpComplete()
								.PagesAvailableAccord()
								.clickComplete()
								.DataTable()
								.clickPopupOk()
								.TypesPage()
								.clickSubmitExit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("End Date the new type");
			Source.TypesPage().endDateType(TypePrefix);
			
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
		
	@Test(priority=3)
	public void TC_Types_View_001() {		
		SoftAssert = new SoftAssert();

			try{
			SeleniumHelper.log.info("Create a new type");
			Source.TypesPage().addCompleteTypeLockedAndSubmit();	
				
			SeleniumHelper.log.info("View a Type, Role and Service Population");
			Expected = "View";
			Actual = Source		.NavigationMenuBar()
								.GetSource()
								.DataTable()
								.setSearch(TypePrefix)
								.clickFirstRow()
								.clickView()
								.TypesPage()
								.DataTable()
								.clickFirstRow()
								.clickView()
								.PagesAvailableAccord()
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesRow(1)
								.clickRolesView()
								.clickRolesCancel()
								.GetSource()
								.PagesAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpRow(1)
								.clickSpView()
								.clickSpCancel()
								.GetSource()
								.PagesAvailableAccord()
								.clickCancel()
								.PagesAvailableAccord()
								.clickBackToTypes()
								.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("End Date the new type");
			Source.TypesPage().endDateType(TypePrefix);
			
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=4)
	public void TC_Types_View_Preview_TestForm_001() {		
		SoftAssert = new SoftAssert();

			try{
			SeleniumHelper.log.info("Create a new page ");
			Source.PagesPage().addCompletePage(PageName, Today, null, Description, true, //Page
					SectionName, 1, Description, T, T, T, // Section
					RowName, 1, Description, T, T, T, // Row
					QuestionLabel, QuestionType.TEXT_FIELD.getIndex(), 1, null, null, null, T, F, // Question
					Today, null, Roles.ALLAPPS.getName(), T, Description); // Role
			
			SeleniumHelper.log.info("Confirm after previewing a page then testing a page the first page is active and displayed");
			Expected = True;
			Actual = Source 	.AdministratorNavigator()
								.clickTypes()
								.GetSource()
								.TypesPage()
								.addType(TypeName, Today, null, AppModule.NOTES.getIndex(), LockTime.NEVER.getIndex(), Description, F, F, AppAreaConductType.BOTH.getIndex())
								.GetSource()
								.PagesAvailableAccord()
								.addPage(PageName, 1, null, null, null, F, T)
								.clickCompleteAndOk()
								.TypesPage()
								.clickPreview()
								.clickTestBackBtn()
								.clickTestForm()
								.clickTestFormFirstPage()
								.isTypesPageContentDisplayed();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);

			SeleniumHelper.log.info("End Date Type and Pages");
			Source				.TypesPage()
								.clickTestBackBtn2()
								.setEndDate(Today, "")
								.GetSource()
								.TypesPage()
								.clickSubmitExit()
								.clickPopupOk()
								.AdministratorNavigator()
								.clickPages()
								.GetSource()
								.PagesPage()
								.endDatePageAndSubmit(PagePrefix, Today);
			
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=5)
	public void TC_Types_Add_Triggered_Page_Questions_Answers_001() {		
		SoftAssert = new SoftAssert();
		try{
								
			SeleniumHelper.log.info("Create Type with two pages. Second page triggered by first page. Confirm No Triggered Questions");
			Expected = True;
			Actual = Source 	.AdministratorNavigator()
								.clickTypes()
								.GetSource()
								.TypesPage()
								.addType(TypeName, Today, null, AppModule.NOTES.getIndex(), LockTime.NEVER.getIndex(), Description, F, F, AppAreaConductType.BOTH.getIndex())
								.GetSource()
								.PagesAvailableAccord()
								.addPage("Transition Note (V4)", 1, null, null, null, F, T)
								.clickCompleteAndOk()
								.PagesAvailableAccord()
								.addPage(DataFixFormV2, 2, "Transition Note (V4)", null, null, F, T)
								.hasTriggeredQuestions();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Add Third page choosing first page and confirm no triggered questions");
			Expected = True;
			Actual = Source		.PagesAvailableAccord()
								.clickCompleteAndOk()
								.PagesAvailableAccord()
								.addPage("Children's Client Access form", 3, DataFixFormV2.toUpperCase(), null, null, F, T)
								.hasTriggeredQuestions();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			

			SeleniumHelper.log.info("Edit First page and confirm no triggered questions");
			Expected = True;
			Actual = Source		.PagesAvailableAccord()	
								.clickCompleteAndOk()
								.PagesAvailableAccord()
								.setSearch("Transition Note (V4)")
								.clickFirstRow()
								.clickEdit()
								.PagesAvailableAccord()
								.hasTriggeredQuestions();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Edit second page and confirm no triggered questions");
			Expected = True;
			Actual = Source		.PagesAvailableAccord()	
								.clickCancel()
								.PagesAvailableAccord()
								.setSearch(DataFixFormV2)
								.clickFirstRow()
								.clickEdit()
								.PagesAvailableAccord()
								.hasTriggeredQuestions();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Edit third page and confirm no triggered questions");
			Expected = True;
			Actual = Source		.PagesAvailableAccord()	
								.clickCancel()
								.PagesAvailableAccord()
								.setSearch("Children's Client Access form")
								.clickFirstRow()
								.clickEdit()
								.PagesAvailableAccord()
								.hasTriggeredQuestions();
										
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("End Date Type and Pages");
			Source				.PagesAvailableAccord()	
								.clickCancel()
								.PagesAvailableAccord()
								.GetSource()
								.TypesPage()
								.setEndDate(Today, "")
								.GetSource()
								.TypesPage()
								.clickSubmitExit()
								.clickPopupOk();
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}