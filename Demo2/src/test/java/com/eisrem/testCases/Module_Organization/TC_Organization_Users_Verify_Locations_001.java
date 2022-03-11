package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.OrganizationType;
import com.eisrem.Hooks.OrganizationPage;
import com.eisrem.pageFactory.CommonPage.IdentifiersPage;
import com.eisrem.pageFactory.Organization.UserStaffPage;

public class TC_Organization_Users_Verify_Locations_001 extends OrganizationPage{

	@Test(priority=1)
	public void TC_Organization_Users_Verify_Locations() {
		SoftAssert = new SoftAssert();
		String fName = FirstName + SeleniumHelper.generateRandomAlpha(3);
		String lName = LastName + SeleniumHelper.generateRandomAlpha(3);

		try {
			SeleniumHelper.log.info("test");
			ExpectedB = F;
			ActualB =   Source		.DataTable()
						.setSearch(OrgDHHS)
						.clickFirstRow()
						.clickAnchor()
						.OrganizationNavigator()
						.clickUsersStaff()
						.clickAdd()
						.UserStaffPage()
						.setFirstName(fName)
						.setLastName(lName)
						.clickUserInfoAccord()
						.setUserName(UserName)
						.setPassword(TestPassword)
						.setPasswordConfirmation(TestPassword)
						.GetSource()
						.UserHomeOfficeAccord()
						.clickAdd()
						.UserHomeOfficeAccord()
						.setUserBaseLocation("base")
						.clickComplete()
						.UserInfoAccord()
						.clickAdditionalOrgLocationAccord()
						.clickAdditionalOrgLocAdd()
						.setAdditionalOrgLocOrganizaiton("36227")
						.verifyLocations();

			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}