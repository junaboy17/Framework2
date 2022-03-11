package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_BHOPS_11814_ResidentialPlacement_Add_Edit_View extends PeoplePage{

	@Test(priority=1)
	public void TC_ResidentialPlacement_Add_001() {
		SoftAssert = new SoftAssert();

		try {
			Source.PeoplePage().AddPeople();
			
			SeleniumHelper.log.info("Verifying Successful Adding of Residential Placement record");
			Expected = Success;
			Actual = Source		.PeopleNavigator()
								.clickResidentialPlacementTab()
							    .DataTable()
							    .clickAdd()
								.ResidentialPlacementPage()
								.setAdmitDate(Today, Clear)
								.selectPlacementType(PlacementType.IN_STATE_PLACEMENT.getIndex())
								.selectResidentialPlacement(PNMIPlacement.AMERICAN_SCHOOL_FOR_THE_DEAF_CT.getIndex())
								.selectResidentialLevel(PNMILevel.MH_I.getIndex())
								.setDescription(Description)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			Source.DataTable().clickPopupOk();
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	
	@Test(priority=2)
	public void TC_ResidentialPlacement_Edit_001() {
		SoftAssert = new SoftAssert();

		try {						
			SeleniumHelper.log.info("Verifying Successful Editing of Residential Placement record");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
							    .clickResidentialPlacementTab()
							    .createResidentialPlacementIfNoData()
							    .DataTable()					    
							    .clickFirstRow()
							    .clickEdit()
								.ResidentialPlacementPage()
								.setDischargeDate(Today)
								.setDescription(UpdateDescription)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			Source.DataTable().clickPopupOk();
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=3)
	public void TC_ResidentialPlacement_View_001() {
		SoftAssert = new SoftAssert();

		try {		
			SeleniumHelper.log.info("Verifying Successful Viewing of Residential Placement record");
			Expected = View;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
							    .clickResidentialPlacementTab()
							    .createResidentialPlacementIfNoData()
							    .DataTable()
							    .clickFirstRow()
							    .clickView()
								.ResidentialPlacementPage()
								.clickBackToResidentialPlacementBtn()
								.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
