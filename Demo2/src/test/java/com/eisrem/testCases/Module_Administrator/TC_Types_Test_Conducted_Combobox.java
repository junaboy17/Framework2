package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Types_Test_Conducted_Combobox extends AdministratorPage{
	@Test(priority=1)
	public void TC_Types_Test_Conducted_Combobox_001() {		
		SoftAssert = new SoftAssert();

			try{
			SeleniumHelper.log.info("Create a new page with a conducted type search question");
			Source.PagesPage().addCompletePage(PageName, Today, null, Description, true, //Page
					SectionName, 1, Description, T, T, T, // Section
					RowName, 1, Description, T, T, T, // Row
					QuestionLabel, QuestionType.CONDUCTED_TYPE_SEARCH.getIndex(), 1, null, null, null, T, F, // Question
					Today, null, Roles.ALLAPPS.getName(), T, Description); // Role
			
			SeleniumHelper.log.info("Create Type to use page created");	
			Source.TypesPage().addCompleteTypeAndSubmit(TypeName, Today, null, AppModule.NOTES.getIndex(), LockTime.NEVER.getIndex(), Description, F, F, AppAreaConductType.BOTH.getIndex(), //Type 
					PageName, 1, null, null, null, F, T, Roles.ALLAPPS.getName(), Today, null, T, T, T, Description, //Role
					ServicePopulations.CHILDRENS.getName(), Today, null, Description); //Service Population
			
			SeleniumHelper.log.info("Confirm successfully filled form, continued went back and submitted type");
			Expected = Success;
			Actual = Source		.TypesPage()
								.setSearch(TypeName)
								.clickFirstRow()
								.clickEdit()
								.TypesPage()
								.clickTestForm()
								.clickTestFormFirstPage()
								.fillForm()
								.clickContinue()
								.TypesPage()
								.clickTestBackBtn()
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
	
}