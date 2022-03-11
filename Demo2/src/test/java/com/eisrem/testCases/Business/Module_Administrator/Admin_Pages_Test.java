package com.eisrem.testCases.Business.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.BusinessUserLogIn;
import com.eisrem.pageFactory.Administrator.RolesPage;

public class Admin_Pages_Test extends AdministratorPage {

	@Test(priority=1)
	public void Pages() {
		
		SoftAssert = new SoftAssert();

		String pageName = "ACME SURVEY PAGE " + RandNum3;
		
		try{
			SeleniumHelper.log.info("Adding Pages and verifying success");
			Expected =	"Lock For Use";
			Actual =	Source		.AdministratorNavigator()
									.clickPages()
									.clickAdd()
									.PagesPage()
									.setPageName(pageName)
									.setStartDate(PastDate5, Clear)
									.setDescription(Description)
									.GetSource()
									.DataTable()
									.clickAdd()
									.SectionsAvailableAccord()
									.setSectionName("Section 1")
									.setSortOrder("1")
									.clickShowDescriptionToggle("false")
									.setDescription(Description)
									.GetSource()
									.RowsAvailableAccord()
									.clickRowAdd()
									.setRowName("Row 1")
									.setSortOrder("1")
									.clickShowDescriptionToggle("false")
									.setDescription("Selenium Row")
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(3)
									.setQuestionLabel("Today's Date")
									.setSortOrder("1")
									.clickRequiredToggle()
									.clickQASave()
									.GetSource()
									.SeleniumHelper()
									.sleep(5)
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(1)
									.setQuestionLabel("WHICH COLOR?")
									.setSortOrder("2")
									.setAnswerValue(1, "Red")
									.clickAddValueAnswer()
									.setAnswerValue(2, "Blue")
									.clickAddValueAnswer()
									.setAnswerValue(3, "Green")
									.clickAddValueAnswer()
									.setAnswerValue(4, "Purple")
									.clickQASave()
									.GetSource()
									.SeleniumHelper()
									.sleep(5)
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(2)
									.setQuestionLabel("WHO TO CHOOSE?")
									.setSortOrder("3")
									.setAnswerValue(1, "1000000622  CBH_Staff")
									.clickQASave()
									.GetSource()
									.SeleniumHelper()
									.sleep(5)
									.GetSource()
									.RowsAvailableAccord()
									.clickRowSubmit()
									.GetSource()
									.SeleniumHelper()
									.sleep(5)
									.GetSource()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.PagesPage()
									.clickLockForUseToggle("true")
									.readLockForUseTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Locking for Use and verifying Preview works properly");
			Expected =	pageName;
			Actual =	Source		.Pagefactory()
									.clickYes()
									.PagesPage()
									.clickSubmitExit()
									.GetSource()
									.SeleniumHelper()
									.Wait(5)
									.GetSource()
									.DataTable()
									.clickFirstRow()
									.clickView()
									.PagesPage()
									.clickPreview()
									.clickTestBack()
									.clickBackToList()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=2)
	public void Copy_Page_1() {
		
		SoftAssert = new SoftAssert();

		String pageName = "ACME SURVEY PAGE " + RandNum3;
		String pageName2 = "ACME SURVEY PAGE " + RandNum4;
		
		try{
			SeleniumHelper.log.info("Adding Pages and verifying success");
			Expected =	"Lock For Use";
			Actual =	Source		.AdministratorNavigator()
									.clickPages()
									.clickAdd()
									.PagesPage()
									.setPageName(pageName)
									.setStartDate(PastDate5, Clear)
									.setDescription(Description)
									.GetSource()
									.DataTable()
									.clickAdd()
									.SectionsAvailableAccord()
									.setSectionName("Section 1")
									.setSortOrder("1")
									.clickShowDescriptionToggle("false")
									.setDescription(Description)
									.GetSource()
									.RowsAvailableAccord()
									.clickRowAdd()
									.setRowName("Row 1")
									.setSortOrder("1")
									.clickShowDescriptionToggle("false")
									.setDescription("Selenium Row")
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(3)
									.setQuestionLabel("Today's Date")
									.setSortOrder("1")
									.clickRequiredToggle()
									.clickQASave()
									.GetSource()
									.SeleniumHelper()
									.sleep(5)
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(1)
									.setQuestionLabel("WHICH COLOR?")
									.setSortOrder("2")
									.setAnswerValue(1, "Red")
									.clickAddValueAnswer()
									.setAnswerValue(2, "Blue")
									.clickAddValueAnswer()
									.setAnswerValue(3, "Green")
									.clickAddValueAnswer()
									.setAnswerValue(4, "Purple")
									.clickQASave()
									.GetSource()
									.SeleniumHelper()
									.sleep(5)
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(2)
									.setQuestionLabel("WHO TO CHOOSE?")
									.setSortOrder("3")
									.setAnswerValue(1, "1000000622  CBH_Staff")
									.clickQASave()
									.GetSource()
									.SeleniumHelper()
									.sleep(5)
									.GetSource()
									.RowsAvailableAccord()
									.clickRowSubmit()
									.GetSource()
									.SeleniumHelper()
									.sleep(5)
									.GetSource()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.PagesPage()
									.clickLockForUseToggle("true")
									.readLockForUseTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Locking for Use, Copying Page and verifying Copied Page was created successfully");
			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickYes()
									.PagesPage()
									.clickSubmitExit()
									.GetSource()
									.SeleniumHelper()
									.Wait(6)
									.GetSource()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.PagesPage()
									.clickCopyPage()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected =	"Lock For Use";
			Actual =	Source		.Pagefactory()
									.clickPopupOkIfExist()
									.PagesPage()
									.setPageName(pageName2, Clear)
									.clickLockForUseToggle("true")
									.readLockForUseTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected =	pageName2;
			Actual =	Source		.Pagefactory()
									.clickYes()
									.Pagefactory()
									.clickSubmit()
									.GetSource()
									.SeleniumHelper()
									.sleep(5)
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

}