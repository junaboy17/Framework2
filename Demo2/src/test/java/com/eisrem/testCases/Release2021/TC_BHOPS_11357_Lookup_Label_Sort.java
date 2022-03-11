package com.eisrem.testCases.Release2021;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11357_Lookup_Label_Sort extends AdministratorPage {
	
	@Test(priority=1)
	public void LookupGroup_Add() {
		
		SoftAssert = new SoftAssert();
		String groupName = "Selenium Test Group " + RandNum4;

		try{	
				SeleniumHelper.log.info("Add Lookup Group");
				Expected = Success;
				Actual = 
				Source
						.AdministratorNavigator()
						.clickLookups()
						.clickAdd()
						.LookupsPage()
						.setGroupName(groupName)
						.switchSystemLookUpToggle(F)
						.clickSubmit()
						.readPopUpTitle();
				SoftAssert.assertEquals(Actual, Expected);
				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
	
	@Test(priority=2)
	public void LookupLabels_Add() {

		SoftAssert = new SoftAssert();
		String lookUpsName = "Selenium Test" + RandNum4;
		String labelName1 = "A_Label";
		String labelName2 = "B_Label";
		String labelName3 = "C_Label";
		List<Integer> actuals;
		List<Integer> expecteds;
		

		try{	
				SeleniumHelper.log.info("Add Labels, sort labels alpha, change sort order for one of the labels.");
				Source	.AdministratorNavigator()
						.clickLookups()
						.clickAdd()
						.LookupsPage()
						.setGroupName(lookUpsName)
						.clickSubmit()
						.clickPopupOk()
						.DataTable()
						.setSearch(lookUpsName)
						.clickFirstRow()
						.clickEdit()
						.LookupsPage()
						.clickLabelsAvailableAccord()
						.clickAdd()
						.LabelsAvailableAccord()
						.setLabelName(labelName1)
						.switchLabelIndentFlag(F)
						.clickComplete()
						.LookupsPage()
						.clickPopupOk()
						.LookupsPage()
						.clickLabelsAvailableAccord()
						.clickAdd()
						.LabelsAvailableAccord()
						.setLabelName(labelName2)
						.switchLabelIndentFlag(F)
						.clickComplete()
						.LookupsPage()
						.clickPopupOk()
						.LookupsPage()
						.clickLabelsAvailableAccord()
						.clickAdd()
						.LabelsAvailableAccord()
						.setLabelName(labelName3)
						.switchLabelIndentFlag(F)
						.clickComplete()
						.LookupsPage()
						.clickPopupOk()
						.LookupsPage()
						.clickSortLabelsAlpha()	// sort order will be assigned according to alpha order
						.clickPopupOk()
						.LookupsPage()
						.clickLabelsAvailableAccord();
				
				actuals = Source.LabelsAvailableAccord().getLabelsSortOrder();
				expecteds = Arrays.asList(1,2,3);				
				SoftAssert.assertEquals(actuals, expecteds);
				
				Source	.LookupsPage()
						.DataTable()
						.clickSecondRow()
						.clickEdit()
						.LabelsAvailableAccord()
						.setLabelSortOrder(1,"y")	// changing sort order for the second label to be 1
						.clickComplete()
						.LookupsPage()
						.clickPopupOk()
						.LookupsPage()				
						.clickLabelsAvailableAccord();
				
				actuals = null;
				actuals = Source.LabelsAvailableAccord().getLabelsSortOrder();
				expecteds = Arrays.asList(2,1,3);	
				
				SoftAssert.assertEquals(actuals, expecteds);
				SoftAssert.assertAll();
				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}			
}