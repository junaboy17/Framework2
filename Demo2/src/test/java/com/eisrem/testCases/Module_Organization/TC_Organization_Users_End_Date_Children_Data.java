package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.OrganizationType;
import com.eisrem.Hooks.OrganizationPage;
import com.eisrem.pageFactory.CommonPage.IdentifiersPage;
import com.eisrem.pageFactory.Organization.UserStaffPage;

public class TC_Organization_Users_End_Date_Children_Data extends OrganizationPage{

	@Test(priority=1)
	public void Users_End_Date_Children_Data() {
		SoftAssert = new SoftAssert();
		String randalph3 = SeleniumHelper.generateRandomAlpha(3);
		String fName = "First" + randalph3;
		String lName = "Last" + randalph3;
		String uName = fName + lName + SeleniumHelper.generateRandomNumber(3);
		
		try {
			SeleniumHelper.log.info("Creating a full User/Staff and verifying success");
			Expected = Success;
			Actual = Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickUsersStaff()
								.clickAdd()
								.UserStaffPage()
								.setFirstName(fName)
								.setLastName(lName)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Success;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.setSearch(fName)
								.clickFirstRow()
								.clickEdit()
								.UserStaffPage()
								.clickUserInfoAccord()
								.clickUserActiveToggle(True)
								.setUserName(uName)
								.setPassword(TestPassword, Clear)
								.setPasswordConfirmation(TestPassword, Clear)
								.clickAdd()
								.UserHomeOfficeAccord()
								.setUserBaseLocation("a")
								.clickComplete()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.clickAdditionalOrgLocAdd()
								.GetSource()
								.SeleniumHelper()
								.Wait(2)
								.GetSource()
								.AdditionalOrgLocAccord()
								.setAdditionalOrgLocOrganizaiton(OrgDHHS)
								.chooseAdditionalOrgLocLocations("AUGUSTA")
								.clickComplete()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.clickRolesAdd()
								.selectRole("ALLAPPS")
								.clickComplete()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation("CHILDRENS")
								.clickComplete()
								.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickIdentifiersAccord()
								.clickIdentifiersAdd()
								.selectIdentifiersType(1)
								.setIdentifiersIdNumber(RandNum9)
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirming Modified Date is Today");
			Expected = Today;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.setSearch(fName)
								.readDataTable(1, 5);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("test");
			Expected = Today;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickView()
								.UserStaffPage()
								.clickUserInfoAccord()
								.readDataTable("loc-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickAdditionalOrgLocationAccord()
								.DataTable()
								.readDataTable("addtnl-loc-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickRolesAvaiableAccord()
								.DataTable()
								.readDataTable("role-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);		

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickServicePopulationAvailableAccord()
								.DataTable()
								.readDataTable("sp-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);	

			Expected = Today;
			Actual = Source		.SeleniumHelper()
								.scrollToBottom()
								.GetSource()
								.UserInfoAccord()
								.clickIdentifiersAccord()
								.DataTable()
								.readDataTable("idnt-picker-table", 1, 5);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Today;
			Actual = Source		.Pagefactory()
								.clickBackTo()
								.DataTable()
								.setSearch(fName)
								.readDataTable(1, 5);
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}