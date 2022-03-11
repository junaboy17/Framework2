package com.eisrem.testCases.Module_ConductedTypes;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_BHOPS_10565_Conducted_Types_Add_PopupCheck extends PeoplePage {
	
	@Test(priority=1)
	public void Types_Add_PopupCheck() {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Verifying discard pop up after exiting with out saving");
					SeleniumHelper.log.info("Verifying Do you want to save your changes message");
					Expected =	"Do you want to save your changes?";
					Actual = 	Source		.DataTable()
											.setSearch(FirstName, "y")
											.clickFirstRow()
											.clickAnchor()
											.NavigationMenuBar()
											.clickAssessmentForms()
											.clickAdd()
											.Assessment_FormsPage()
											.selectAssessmentType(DataFixFormV2Assessment)
											.setTitle("SELENIUM TEST")
											.setDescription("DESCRIPTION FROM CREATION")
											.GetSource()
											.Assessment_FormsPage()
											.clickStartAssessment()
											.fillForm()
											.GetSource()
											.NavigationMenuBar()
											.clickMyHomePage()
											.GetSource()
											.DataTable()
											.readPopUpTitle();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Verifying Discard button title");
					Expected =	"Discard";
					Actual = 	Source		.DataTable()
											.readDiscardBtn();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Clicking discard and verifying page was discarded and next page was loaded");
					Expected ="My Home Page";
					Actual = 	Source		.DataTable()
											.clickDiscard()
											.MyHomePage()
											.readMyHomePageTitle();
					SoftAssert.assertEquals(Actual, Expected);
					
					SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
		
	}
	
	

