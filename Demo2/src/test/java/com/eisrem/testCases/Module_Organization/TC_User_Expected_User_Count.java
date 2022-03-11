package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.OrganizationType;
import com.eisrem.Hooks.OrganizationPage;
import com.eisrem.pageFactory.CommonPage.IdentifiersPage;
import com.eisrem.pageFactory.Organization.UserStaffPage;

public class TC_User_Expected_User_Count extends OrganizationPage{

	@Test(priority=1)
	public void TC_User_Expected_User_Count_001() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Anchoring to DHHS and checking number of entries in Users/Staff");
			Expected = Source		.DataTable()
									.setSearch(OrgDHHS)
									.clickFirstRow()
									.clickAnchor()
									.OrganizationNavigator()
									.clickUsersStaff()
									.DataTable()
									.readShowNoOfEntries();

			SeleniumHelper.log.info("Anchoring any Location under DHHS and confirming number of entries has not changed in Users/Staff");
			Actual = 	Source		.OrganizationNavigator()
									.clickLocations()
									.DataTable()
									.clickFirstRow()
									.clickAnchor()
									.OrganizationNavigator()
									.clickUsersStaff()
									.DataTable()
									.readShowNoOfEntries();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}