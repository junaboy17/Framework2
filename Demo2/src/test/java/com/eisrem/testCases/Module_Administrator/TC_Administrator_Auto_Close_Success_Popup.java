package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.AppAreaConductType;
import com.eisrem.AppUtils.Enumerations.AppModule;
import com.eisrem.AppUtils.Enumerations.LockTime;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Administrator_Auto_Close_Success_Popup extends AdministratorPage{

	@Test(priority=1)
	public void TC_Administrator_Auto_Close_Success_Popup_Pages_001() {		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Add up to question, save, and check if popup appears");
			Expected = True;
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
								.addQuestion()
								.clickQASave()
								.isPopupPresent(0);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Popup dissapeared");
			Expected = False;
			Actual = Source		.PagesPage()
								.isPopupPresent(4);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Popup appears when saving row");
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.sleep(2)
								.GetSource()
								.RowsAvailableAccord()
								.clickRowSave()
								.isPopupPresent(0);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Popup dissapeared");
			Expected = False;
			Actual = Source		.RowsAvailableAccord()
								.isPopupPresent(4);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Popup appears when saving section");
			Expected = True;
			Actual = Source		.RowsAvailableAccord()
								.clickRowBack()
								.GetSource()
								.SeleniumHelper()
								.sleep(2)
								.GetSource()
								.SectionsAvailableAccord()
								.clickSave()
								.SectionsAvailableAccord()
								.isPopupPresent(0);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Popup dissapeared");
			Expected = False;
			Actual = Source		.SectionsAvailableAccord()
								.isPopupPresent(4);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);

			SeleniumHelper.log.info("Save Page and Navigate Back to question to edit and receive popup on save");
			Expected = True;
			Actual = Source   	.SectionsAvailableAccord()
								.clickSectionsBack()
								.clickSubmitExit()
								.clickPopupOk()
								.PagesPage()
								.setSearch(PagePrefix)
								.clickFirstRow()
								.clickEdit()
								.SectionsAvailableAccord()
								.setSearch(SectionPrefix)
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.setSearch(RowPrefix)
								.clickRowFirstRow()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.setSearch(QuestionPrefix)
								.clickQAFirstRow()
								.clickQAEdit()
								.clickQASave()
								.isPopupPresent(0);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Popup dissapeared");
			Expected = False;
			Actual = Source		.PagesPage()
								.isPopupPresent(4);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Popup appears when saving row");
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.sleep(2)
								.GetSource()
								.RowsAvailableAccord()
								.clickRowSave()
								.isPopupPresent(0);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Popup dissapeared");
			Expected = False;
			Actual = Source		.RowsAvailableAccord()
								.isPopupPresent(4);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Popup appears when saving section");
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.sleep(2)
								.GetSource()
								.RowsAvailableAccord()
								.clickRowBack()
								.clickSave()
								.SectionsAvailableAccord()
								.isPopupPresent(0);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Popup dissapeared");
			Expected = False;
			Actual = Source		.SectionsAvailableAccord()
								.isPopupPresent(4);
			
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("End Date the new page");
			Source				.SectionsAvailableAccord()
								.clickSectionSubmit()
								.clickPopupOk()
								.PagesPage()
								.endDatePageAndSubmit(PagePrefix, Today);
		
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2)
	public void TC_Administrator_Auto_Close_Success_Popup_Types_001() {		
		SoftAssert = new SoftAssert();
		String PageName;

		try{
			SeleniumHelper.log.info("Create a new page");
			Source.PagesPage().addCompletePage(true).clickSubmitExit().clickPopupOk();
			
			PageName = Source.DataTable().readDataTable(1, 2);

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
								.isPopupPresent(0);
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Confirm Popup dissapeared");
			Expected = False;
			Actual = Source		.TypesPage()
								.isPopupPresent(4);
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Confirm Popup is present when saving type");
			Expected = True;
			Actual = Source		.TypesPage()
								.clickSubmitExit()
								.isPopupPresent(0);
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Confirm Popup dissapeared");
			Expected = False;
			Actual = Source		.TypesPage()
								.isPopupPresent(4);
			
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("End Date Type and Pages");
			Source				.TypesPage()
								.setSearch(TypeName)
								.clickFirstRow()
								.clickEdit()
								.TypesPage()
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
	
}
