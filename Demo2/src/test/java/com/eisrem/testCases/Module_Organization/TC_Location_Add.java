package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_Location_Add extends OrganizationPage{
	
	@Test(priority=1)
	public void TC_Location_Add_001() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Add Organization to work with");
			String orgId = Source.OrganizationPage().addCompleteOrganizationPageSubmitAndReturnId();
			
			SeleniumHelper.log.info("Verifying Successful Adding Location");
			Expected = Success;
			Actual = Source		.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.clickSubmit()
								.GetSource()
								.SeleniumHelper()
								.continueIfErrors()
								.GetSource()
								.LocationsPage()
								.setName(LocationName)
								.selectType(LocationType.OTHER_LOCATION.getName())
								.toggleActive(T)
								.DataTable()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(ServicePopulations.ADULT_MH.getName())
								.setDescription(Description)
								.clickComplete()
								.DataTable()
								.clickSubmit()
								.readPopUpTitle();
			
			SoftAssert.assertEquals(Actual, Expected);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			
			Source.DataTable().clickPopupOk();
			
			Source.LocationsPage().endDateLocation(orgId, LocationName);
			Source.OrganizationPage().endDateOrganization(orgId);
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	
}
