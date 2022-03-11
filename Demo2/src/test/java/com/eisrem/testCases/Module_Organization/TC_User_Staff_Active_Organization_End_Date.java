package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.OrganizationType;
import com.eisrem.Hooks.OrganizationPage;
import com.eisrem.pageFactory.CommonPage.IdentifiersPage;
import com.eisrem.pageFactory.Organization.UserStaffPage;

public class TC_User_Staff_Active_Organization_End_Date extends OrganizationPage{

	@Test(priority=1)
	public void TC_User_Staff_Active_Organization_End_Date_001() {
		SoftAssert = new SoftAssert();
		
		String OrganizationName = "ACME GROUP HOME "+ SeleniumHelper.generateRandomNumber(4);

		try {
			SeleniumHelper.log.info("Creating organization and verifying end date is null");
			Expected = EmptyString;
			Actual = Source		.OrganizationPage()
								.addCompleteOrganizationPageAndSubmit(OrganizationName, OrganizationType.OTHER, PastDate30, null, true, Description)
								.clickOrganizations()
								.setSearch(OrganizationName)
								.clickFirstRow()
								.clickView()
								.OrganizationPage()
								.readEndDateValue()
								.replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Creating User/Staff and end dating an organization");
			Expected = Success;
			Actual = Source		.UserStaffPage()
								.addCompleteUserAndSubmit(OrganizationName)
								.GetSource()
								.OrganizationNavigator()
								.clickOrganizations()
								.clickFirstRow()
								.clickEdit()
								.OrganizationPage()
								.setEndDate(Today)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying User/Staff Active toggle is set to false due to organization being end dated");
			Expected = False;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.OrganizationPage()
								.clickUsersStaff()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.readStaffActiveToggle();
			SoftAssert.assertEquals(Actual, Expected);	
						
			Expected = False;
			Actual = Source		.UserStaffPage()
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