package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.OrganizationType;
import com.eisrem.Hooks.OrganizationPage;
import com.eisrem.pageFactory.CommonPage.IdentifiersPage;
import com.eisrem.pageFactory.Organization.UserStaffPage;

public class TC_Users_ActiveStaff_Confirmation_001 extends OrganizationPage{

	@Test(priority=1)
	public void TC_User_ActiveStaff_Confirmation_001() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Searching for a user and confirming the user is set to active");
			Expected = True;
					
			Actual = Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.DataTable()
								.setSearch("User, Selenium")
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.readStaffActiveToggle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Confirming the user is able to be selected in notifications");
			Expected = "My Home Page";
					
			Actual = Source		.Pagefactory()
								.clickSubmit()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickAdministrator()
								.GetSource()
								.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.clickWhoRecipientsAccord()
								.clickAdd()
								.WhoAccord()
								.setEndDate(FutureDate30)
								.selectType(1)
								.setUser("User, Selenium")
								.clickCancel()
								.NavigationMenuBar()
								.clickMyHomePage()
								.readMyHomePageTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}