package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_BHOPS_11031_Org_Location_ServicePop_End_Date extends OrganizationPage{


	@Test(priority=1)
	public void TC_Org_Location_ServicePop_End_Date_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying the location has an end date title after editing");
			Expected = Source	.DataTable()
								.setSearch("36227")
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickLocations()
								.setSearch("SANTABASE")
								.clickFirstRow()
								.clickEdit()
								.ServicePopulationsAvailableAccord()
								.setSearch("Children", Clear)
								.clickFirstRow()
								.clickEdit()
								.ServicePopulationsAvailableAccord()
								.readEndDate();
			
			SeleniumHelper.log.info("Verifying the location has an end date title after editing");
			Actual = Source		.ServicePopulationsAvailableAccord()
//								.setDescription(Description, "Y")
								.clickComplete()
								.LocationsPage()
								.clickSubmit()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickUsersStaff()
								.setSearch("527999")
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.setAdditionalOrgLocSearch("SANTABASE")
								.clickAdditionalOrgLocFirstRow()
								.clickAdditionalOrgLocEdit()
								.readAdditionalOrgLocEndDateValue();		
			SoftAssert.assertEquals(Actual, Expected);
	
			SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	}

	

}