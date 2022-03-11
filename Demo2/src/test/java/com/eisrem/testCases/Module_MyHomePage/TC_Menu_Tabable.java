package com.eisrem.testCases.Module_MyHomePage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_Menu_Tabable extends PeoplePage{

	@Test(priority=1)
	public void TC_Menu_Tabable_001() {
		SoftAssert = new SoftAssert();

		try{			
			SeleniumHelper.log.info("Verifying Assessment/Forms Info page is tabable");
			Expected = "1000063304";
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickAnchor()
								.NavigationMenuBar()
								.clickAssessmentForms()
								.clickAdd()
								.Assessment_FormsPage()
								.selectAssessmentType(5)
								.setTitle(Description)
								.clickStartAssessment()
								.GetSource()
								.SeleniumHelper()
								.sleep(3)
								.PressKeys(Keys.TAB, Keys.DOWN, Keys.TAB)
								.sleep(1)
								.GetSource()
								.FormPage()
								.readSelectValue(1, "Service Population").replace("\"", "");	
			SoftAssert.assertEquals(Actual, Expected);
	
			Expected = "1000063303";
			Actual = Source		.FormPage()
								.clickTopTab(2)
								.GetSource()
								.SeleniumHelper()
								.PressKeys(Keys.TAB, Keys.DOWN, Keys.TAB)
								.GetSource()
								.FormPage()
								.readSelectValue(1, "Service Population").replace("\"", "");					
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = "1000063302";
			Actual = Source		.FormPage()
								.clickTopTab(2)
								.GetSource()
								.SeleniumHelper()
								.PressKeys(Keys.TAB, Keys.DOWN, Keys.TAB)
								.GetSource()
								.FormPage()
								.readSelectValue(1, "Service Population").replace("\"", "");					
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Notifications page is tabable");
			Expected = "Notification";
			Actual = Source		.NavigationMenuBar()	
								.clickAdministrator()
								.clickDiscard()
								.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.clickNotificationsAccordian()
								.clickNotificationsAccordian()
								.GetSource()
								.SeleniumHelper()
								.pressTab()
								.readActiveElement();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = "Who";
			Actual = Source		.NotificationsPage()
								.clickWhoRecipientsAccord()
								.clickAdd()
								.NotificationsPage()
								.clickNotificationsAccordian()
								.clickNotificationsAccordian()
								.GetSource()
								.SeleniumHelper()
								.pressTab()
								.readActiveElement();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Organization page is tabable");
			Expected = Disabled;
			Actual = Source		.NavigationMenuBar()
								.clickOrganization()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.clickIdentifiersAccord()
								.clickIdentifiersAdd()
								.GetSource()
								.SeleniumHelper()
								.getAttribute(Source.UserInfoAccord().UserTab, "class");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Agreement page is tabable");
			Expected = "Agreement";
			Actual = Source		.NavigationMenuBar()
								.clickAgreement()
								.clickFirstRow()
								.clickView()
								.AgreementPage()
								.clickAgreementInfoAccord()
								.clickAgreementInfoAccord()
								.GetSource()
								.SeleniumHelper()
								.pressTab(1)
								.readActiveElement();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = "Claims";
			Actual = Source		.AgreementPage()
								.clickAgreementInfoAccord()
								.clickAgreementInfoAccord()
								.GetSource()
								.SeleniumHelper()
								.pressTab(2)
								.readActiveElement();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = "Errors";
			Actual = Source		.AgreementPage()
								.clickAgreementInfoAccord()
								.clickAgreementInfoAccord()
								.GetSource()
								.SeleniumHelper()
								.pressTab(3)
								.readActiveElement();
			SoftAssert.assertEquals(Actual, Expected);
								
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}
