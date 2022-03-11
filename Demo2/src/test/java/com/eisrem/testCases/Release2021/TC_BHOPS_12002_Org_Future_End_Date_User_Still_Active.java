package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_BHOPS_12002_Org_Future_End_Date_User_Still_Active extends OrganizationPage{

	@Test(priority=1)
	public void TC_Org_Future_End_Date_User_Still_Active() {
		SoftAssert = new SoftAssert();
		
		String orgName = OrganizationName + RandNum2;
		String sevenDaysAgo = SeleniumHelper.dateOnlyPast(7);
		String tomorrow = SeleniumHelper.dateOnlyFuture(1);
		String UserName = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		String password = UserPassword;
		
		String[] clear = {"clear", "clear"};

		try {
			SeleniumHelper.log.info("Verifying Successful Adding Organization");
			String userId = Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(orgName)
								.selectOrganizationType(OrganizationType.OTHER.getName())
								.setStartDate(sevenDaysAgo, clear)
								.clickSubmit()
								.DataTable()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickAdd()
								.UserStaffPage()
								.setFirstName("FIRST")
								.setLastName("LAST")
								.setEmail("example.example@example.gov")
								.setEmploymentDate(sevenDaysAgo)
								.clickUserInfoAccord()
								.setUserStartDate(sevenDaysAgo, clear)
								.setUserName(UserName)
								.setPassword(password)
								.setPasswordConfirmation(password)
								.toggleUserActive(T)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.readFirstResultID();
			
			
			Expected = "true";
			Actual = Source.OrganizationNavigator()
								.clickOrganizations()
								.setSearch(orgName, clear)
								.clickFirstRow()
								.clickEdit()
								.OrganizationPage()
								.setEndDate(tomorrow, clear)
								.clickSubmit()
								.DataTable()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickUsersStaff()
								.setSearch(userId, clear)
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.readStaffActiveToggle();
			
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = "true";
			Actual = Source.UserStaffPage()
								.clickUserInfoAccord()
								.readUserActiveToggle();
			
			SoftAssert.assertEquals(Actual, Expected);
			
			
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
