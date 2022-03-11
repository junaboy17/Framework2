package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_BHOPS_11465_Organization_User_Verify_End_Date extends OrganizationPage{


	@Test(priority=1)
	public void TC_Organization_User_Verify_End_Date_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying the location has an end date title after editing");
			Expected = Tomorrow;
			Actual = Source		.DataTable()
								.setSearch("DHHS")
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickAdd()
								.UserStaffPage()
								.setFirstName(FirstName)
								.setLastName(LastName)
								.setEmail(Email)
								.setTelephone(PhoneNumber)
								.setTitle("CS USER")
								.setTerminationDate(Tomorrow, Clear)
								.clickStaffActiveToggle(True)
								.GetSource()
								.UserStaffPage()
								.clickUserInfoAccord()
								.setUserName(TestUserName)
								.setPassword(TestPassword)
								.setPasswordConfirmation(TestPassword)
								.clickUserActiveToggle(True)
								.setEndDate(Tomorrow)
								.GetSource()
								.UserHomeOfficeAccord()
								.clickUserHomeOfficeAdd()
								.setUserBaseLocation("1", "Y")
								.setUserHomeOfficeEndDate(Tomorrow, "Y")
								.clickComplete()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.clickAdditionalOrgLocAdd()
								.selectAdditionalOrgLocServicePopulation(3)
								.setAdditionalOrgLocOrganizaiton("DHHS/ STATE OF MAINE")
								.chooseFirstAdditionalOrgLocLocations()
								.setAdditionalOrgLocEndDate(Tomorrow, Clear)
								.clickComplete()
								.RolesAvailableAccord()
								.clickRolesAvaiableAccord()
								.clickRolesAdd()
								.setEndDate(Tomorrow, Clear)
								.selectRole(Roles.ALLAPPS.getName())
								.clickComplete()
								.ServicePopulationsAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.setEndDate(Tomorrow, Clear)
								.selectServicePopulation(3)
								.clickComplete()
								.UserStaffPage()
								.clickSubmit()
								.clickPopupOk()
								.UserStaffPage()
								.setSearch(FirstName)
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readEndDateValue()
								.replace("\"", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Continuing");
			Expected = EmptyString;
			Actual = Source		.UserStaffPage()
								.setEndDate(EmptyString, Clear)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readEndDateValue()
								.replace("\"", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = EmptyString;
			Actual = Source		.UserHomeOfficeAccord()
								.readUserHomeOfficeFirstRowEndDate()
								.replace("\"", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = EmptyString;
			Actual = Source		.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.readAdditionalOrgLocFirstRowEndDate()
								.replace("\"", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = EmptyString;
			Actual = Source		.RolesAvailableAccord()
								.clickRolesAvaiableAccord()
								.readFirstRowEndDate()
								.replace("\"", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = EmptyString;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.readDataTable("sp-picker-table", 1, 4)
								.replace("\"", EmptyString);
			SoftAssert.assertEquals(Actual, Expected);
			
	
			SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	}

	

}