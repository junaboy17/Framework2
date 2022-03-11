package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_BHOPS_11897_ResidentialPlacement_Date_Overlap extends PeoplePage{

	@Test(priority=1)
	public void TC_ResidentialPlacement_Date_Overlap_No_End_Date() {
		SoftAssert = new SoftAssert();

		try {
			Source.PeoplePage().AddPeople();
			
			SeleniumHelper.log.info("Verifying Successful Adding of Residential Placement record");
			Expected = "There is already an active record for this time period: IN STATE PLACEMENT / AMERICAN SCHOOL FOR THE DEAF - CT [" + Today + " - null]";
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
								.clickPopupOk()
								
								.DataTable()
								.clickAdd()
								.ResidentialPlacementPage()
								.setAdmitDate(Today, Clear)
								.selectPlacementType(PlacementType.IN_STATE_PLACEMENT.getIndex())
								.selectResidentialPlacement(PNMIPlacement.AMERICAN_SCHOOL_FOR_THE_DEAF_CT.getIndex())
								.selectResidentialLevel(PNMILevel.MH_I.getIndex())
								.setDescription(Description)
								.clickSubmit()
								.readTopErrorMessage(2);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2)
	public void TC_ResidentialPlacement_Date_Overlap_With_End_Date() {
		SoftAssert = new SoftAssert();

		try {
			Source.PeoplePage().AddPeople();
			
			SeleniumHelper.log.info("Verifying Successful Adding of Residential Placement record");
			Expected = "There is already an active record for this time period: IN STATE PLACEMENT / AMERICAN SCHOOL FOR THE DEAF - CT [" + Today + " - " + FutureDate2 + "]";
			Actual = Source		.PeopleNavigator()
								.clickResidentialPlacementTab()
							    .DataTable()
							    .clickAdd()
								.ResidentialPlacementPage()
								.setAdmitDate(Today, Clear)
								.selectPlacementType(PlacementType.IN_STATE_PLACEMENT.getIndex())
								.selectResidentialPlacement(PNMIPlacement.AMERICAN_SCHOOL_FOR_THE_DEAF_CT.getIndex())
								.selectResidentialLevel(PNMILevel.MH_I.getIndex())
								.setDischargeDate(FutureDate2, Clear)
								.setDescription(Description)
								.clickSubmit()
								.clickPopupOk()
								
								.DataTable()
								.clickAdd()
								.ResidentialPlacementPage()
								.setAdmitDate(Tomorrow, Clear)
								.selectPlacementType(PlacementType.IN_STATE_PLACEMENT.getIndex())
								.selectResidentialPlacement(PNMIPlacement.AMERICAN_SCHOOL_FOR_THE_DEAF_CT.getIndex())
								.selectResidentialLevel(PNMILevel.MH_I.getIndex())
								.setDescription(Description)
								.clickSubmit()
								.readTopErrorMessage(2);
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
