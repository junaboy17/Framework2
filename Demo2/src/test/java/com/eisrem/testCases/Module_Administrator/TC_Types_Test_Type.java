package com.eisrem.testCases.Module_Administrator;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Types_Test_Type extends AdministratorPage{
	@Test(priority=1)
	public void TC_Types_Test_Type_001() {
		SoftAssert = new SoftAssert();
		int RandNum8 = SeleniumHelper.generateRandomNumber(8);
		String[] labels = new String[] {"INITIAL PAGE", "REQUIRED PAGE", "NOT REQUIRED QUESTION", "REQUIRED QUESTION"};
		String PageName= "TC_Pages_Selenium " + RandNum8;
		String TypeName = "TC_Types_Selenium " + RandNum8;
		try{
			
			SeleniumHelper.log.info("Create a new page with required and non required questions");
			Expected = Success;
			Actual = Source   	.PagesPage()
								.addPage(PageName.concat(" " + labels[0]), Today, null, F, null)
								.GetSource()
								.SectionsAvailableAccord()
								.addSection()
								.GetSource()
								.RowsAvailableAccord()
								.addRow()
								.GetSource()
								.QuestionsAvailableAccord()
								.addQuestion(labels[2], QuestionType.TEXT_AREA.getIndex(), 1, null, null, null, T, F)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.addQuestion(labels[3], QuestionType.TEXT_AREA.getIndex(), 2, null, null, null, T, T)
								.clickQASave()
								.clickPopupOk()
								.RowsAvailableAccord()
								.clickRowSubmit()
								.readPopUpTitle();		
			
			Source.PagesPage().lockPageAndSubmit(labels[0]);
			
			SeleniumHelper.log.info("Create a new required page");
			Expected = Success;
			Actual = Source   	.PagesPage()
								.addPage(PageName.concat(" " + labels[1]), Today, null, F, null)
								.GetSource()
								.SectionsAvailableAccord()
								.addSection()
								.GetSource()
								.RowsAvailableAccord()
								.addRow()
								.GetSource()
								.QuestionsAvailableAccord()
								.addQuestion(labels[2], QuestionType.TEXT_AREA.getIndex(), 1, null, null, null, T, F)
								.clickQASave()
								.clickPopupOk()
								.QuestionsAvailableAccord()
								.addQuestion(labels[3], QuestionType.TEXT_AREA.getIndex(), 2, null, null, null, T, T)
								.clickQASave()
								.clickPopupOk()
								.RowsAvailableAccord()
								.clickRowSubmit()
								.readPopUpTitle();		
			
			Source.PagesPage().lockPageAndSubmit("Required Page");
								
			SeleniumHelper.log.info("Create and lock Type");
			Expected = Success;
			Actual = Source 	.AdministratorNavigator()
								.clickTypes()
								.GetSource()
								.TypesPage()
								.addType(TypeName, Today, null, AppModule.NOTES.getIndex(), LockTime.NEVER.getIndex(), Description, F, F, AppAreaConductType.BOTH.getIndex())
								.GetSource()
								.PagesAvailableAccord()
								.addPage(PageName.concat(" " + labels[0]), 1, null, null, null, F, T)
								.clickCompleteAndOk()
								.PagesAvailableAccord()
								.addPage(PageName.concat(" " + labels[1]), 2, null, null, null, T, T)
								.clickCompleteAndOk()
								.TypesPage()
								.clickSubmitExit()
								.readPopUpTitle();
										
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Test Type and check for First Error message Initial Page");
			Expected = True;
			Actual = Source		.TypesPage()
								.setSearch(TypePrefix)
								.clickFirstRow()
								.clickEdit()
								.TypesPage()
								.clickTestForm()
								.clickTestFormFirstPage()
								.clickTestFormContinueBtn(1)
								.GetSource()
								.SeleniumHelper()
								.ifWebElementExistsBooleanString(By.xpath("//*[@id='container_header']/div/ul/li[contains(text(),'INITIAL PAGE')]"));
		
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Check for Error message Required Page does not exist");
			Expected = False;
			Actual = Source		.SeleniumHelper()
								.ifWebElementExistsBooleanString(By.xpath("//*[@id='container_header']/div/ul/li[contains(text(),'REQUIRED PAGE')]"));
		
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Fill form continue and check for Error message Initial Page not existing");
			Expected = False;
			Actual = Source		.TypesPage()
								.fillForm()
								.clickTestFormContinueBtn(1)
								.clearForm()
								.clickTestFormContinueBtn(2)
								.GetSource()
								.SeleniumHelper()
								.ifWebElementExistsBooleanString(By.xpath("//*[@id='container_header']/div/ul/li[contains(text(),'INITIAL PAGE')]"));
		
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("Check for Error message Required Page");
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.ifWebElementExistsBooleanString(By.xpath("//*[@id='container_header']/div/ul/li[contains(text(),'REQUIRED PAGE')]"));
		
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			SeleniumHelper.log.info("End Date Type and Pages");
			Source				.TypesPage()
								.clickTestBackBtn()
								.setEndDate(Today, "")
								.GetSource()
								.TypesPage()
								.clickSubmitExit()
								.clickPopupOk()
								.AdministratorNavigator()
								.clickPages()
								.GetSource()
								.PagesPage()
								.endDatePageAndSubmit(PageName.concat(" INITIAL PAGE"), Today)
								.endDatePageAndSubmit(PageName.concat(" REQUIRED PAGE"), Today);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}