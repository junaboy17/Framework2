package com.eisrem.testCases.Module_Organization;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;




public class TC_Organization_Location_BaseLoc_NoAddLoc extends MyHomePage {

	@Test(priority=1)
	
	public  void User_BaseLocation_Only() {
		
		SoftAssert = new SoftAssert();
		String userName = "OIT" + SeleniumHelper.generateRandomNumber(4);
		String userPassword = "Spring12#";
		String newPassword = "Winter12#";
		String baseLoc = "1";		// "1 DHHS/ STATE OF MAINE % 1 CENTRAL OFFICE/ BASE";
		String servPopl = "ADULT MH";
		String roleSAMHS = "SAMHS STATE ROLE";
		
		try {
			SeleniumHelper.log.info("Creating a user with a base location only, no additional locations "
					+ "and verifying he can log in and has the location in his locations list");
			
			// create a test user
			Source	
				.UserStaffPage()
				.addCompleteUserAndRemainOnUserPage(OrgDHHS, null, null, null, null, T, null, null, null
											, null, T, null, null, userName, userPassword, userPassword, null);
				// add Base Location
			Source
				.UserHomeOfficeAccord()
				.clickUserHomeOfficeAdd()
				.setUserBaseLocation(baseLoc)
				.clickComplete()
				// add Service Population
				.UserInfoAccord()
				.clickServicePopulationAvailableAccord()
				.clickSpAdd()
				.selectServicePopulation(servPopl)
				.clickSpComplete()
				// add Role
				.UserInfoAccord()
				.clickRolesAvaiableAccord()
				.clickRolesAdd()
				.selectRole(roleSAMHS)
				.clickRolesComplete()
				.UserStaffPage()
				.clickSubmit()
				.clickPopupOk();
			
			// Log out
			Source
			.LogInPage().LogOut();

			// Log in as the new user and change password
			Source
				.LogInPage()
				.LogIn(userName, userPassword)
				.GetSource()
				.ChangePasswordPage()
				.setCurrentPassword(userPassword)
				.setNewPassword(newPassword)
				.setConfirmPassword(newPassword)
				.clickSubmit();
			// Log back in and confirm the user has the base location in the locations list
			Source
				.LogInPage()
				.LogIn(userName, newPassword)
				.clickOrganization()
				.setSearch(OrgDHHS)
				.clickFirstRow()
				.clickAnchor()
				.OrganizationNavigator()
				.clickLocations()
				.setSearch("Base")			
				.isEmptyThrowError()	
				;

			SoftAssert.assertAll();
		
		
		}catch(Exception e) {
			Source	.SeleniumHelper()		
					.assertFail();
		}
	}
}

