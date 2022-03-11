package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;
import com.eisrem.pageFactory.CommonPage.IdentifiersPage;
import com.eisrem.pageFactory.Organization.UserStaffPage;

public class TC_Organization_Users_Add_Edit_View extends OrganizationPage{

	@Test(priority=1)
	public void TC_Organization_User_Add_001() {
		SoftAssert = new SoftAssert();

		String Description = "SELENIUM DESCRIPTION" + RandNum3;

		try {
			SeleniumHelper.log.info("Adding Organization User and Verifying successful add");
			Expected = Success;
			Actual = Source		.UserStaffPage()
								.addCompleteUserAndRemainOnUserPage(OrgDHHS)
								.GetSource()
								.IdentifiersPage()
								.clickIdentifiersAccord()		
								.clickIdentifiersAdd()
								.selectIdentifiersType(1)
								.setIdentifiersIdNumber(RandNum9)
								.setDescription(Description)
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying User/Staff was added successfully");
			Expected = UserLastName + ", " + UserFirstName + ",";
			Actual = Source		.DataTable()
								.clickPopupOk()
								.DataTable()
								.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}

	@Test(priority=2)
	public void TC_Organization_User_Edit_001() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Editing Organization User info and Verifying changes were made successfully");
			Expected = Success;
			Actual = Source		.UserStaffPage()
								.addCompleteUserAndRemainOnUserPage(OrgDHHS)
								.GetSource()
								.IdentifiersPage()
								.clickIdentifiersAccord()
								.GetSource()
								.IdentifiersPage()
								.clickIdentifiersAdd()
								.selectIdentifiersType(1)
								.setIdentifiersIdNumber(RandNum9)
								.setDescription(Description)
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.setSearch(UserFirstName)
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.setDescription(UpdateDescription + RandNum4, Clear)
								.GetSource()
								.IdentifiersPage()
								.clickIdentifiersAccord()
								.clickRow("idnt-picker-table", 1)								
								.GetSource()
								.IdentifiersPage()
								.clickIdentifiersEdit()						
								.setDescription(UpdateDescription + RandNum3, Clear)
								.clickComplete()
								.DataTable()
								.clickSubmit()
								.readPopUpTitle();								
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying changes in User Info were made successfully");
			Expected = UpdateDescription + RandNum4;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.setSearch(UserFirstName)
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readDescriptionTextBoxValue();								
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying changes in Identifiers were made successfully");
			Expected = UpdateDescription + RandNum3;
			Actual = Source		.IdentifiersPage()	
								.clickIdentifiersAccord()
								.clickRow("idnt-picker-table", 1)
								.GetSource()
								.IdentifiersPage()
								.clickIdentifiersEdit()
								.readDescriptionTextBoxValue();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}


	@Test(priority=3)
	public void TC_Organization_User_View_001() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Viewing Organization User info and Verifying Text fields cannot be changed");
			Expected = True;
			Actual = Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationPage()
								.clickUsersStaff()
								.setSearch(OrgUserWithIdent)
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.GetSource()
								.SeleniumHelper()
								.getAttribute(Source.Pagefactory().DescriptionTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying Text fields cannot be changed");
			Expected = True;
			Actual = Source		.IdentifiersPage()
								.clickIdentifiersAccord()
								.clickRow("idnt-picker-table", 1)
								.GetSource()
								.IdentifiersPage()
								.clickIdentifiersView()
								.GetSource()
								.SeleniumHelper()
								.getAttribute(Source.IdentifiersPage().IdentifiersIdNumberTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);

			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.IdentifiersPage().DescriptionTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}


}