package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_BHOPS_11703_Users_No_Base_Loc_Edit_In_Edit_Mode extends OrganizationPage{

	@Test(priority=1)
	public void TC_Users_No_Base_Loc_Edit_In_Edit_Mode() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Verifying that User Base Locs cannot be Edited in User Edit mode.");
			
			String sevenDaysAgo = SeleniumHelper.dateOnlyPast(7);
			String yesterday = SeleniumHelper.dateOnlyPast(1);
			String UserName = "OIT" + SeleniumHelper.generateRandomAlpha(10);
			String password = UserPassword;
			
			String[] clear = {"clear", "clear"};
			
			
			
			/*
			 * ADD Mode
			 */
			Source		.NavigationMenuBar()
					.clickOrganization()
					.setSearch("DHHS")
					.clickFirstRow()
					.clickAnchor()
					.OrganizationNavigator()
					.clickUsersStaff()
					.clickAdd()
					.UserStaffPage()
					.setFirstName("FIRST")
					.setLastName("LAST")
					.setEmail("example.example@example.gov")
					.toggleStaffActive(F)
					.setEmploymentDate(sevenDaysAgo)
					.clickUserInfoAccord()
					.setUserStartDate(sevenDaysAgo, clear)
					.setUserName(UserName)
					.setPassword(password)
					.setPasswordConfirmation(password);
			
			/*Show buttons to tester*/
			Source.UserHomeOfficeAccord().readAddBtn();
			Source.UserHomeOfficeAccord().readEditBtn();
			Source.UserHomeOfficeAccord().readExcelBtn();
			
			
			SizeExpected = 1;
			SizeActual = Source		.SeleniumHelper()
					.getWebElementList("//div[@id='loc-picker-table_wrapper']/div/div/a/span[text()='Add']")
					.size();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			SizeExpected = 1;
			
			SizeActual = Source		.SeleniumHelper()
							.getWebElementList("//div[@id='loc-picker-table_wrapper']/div/div/a/span[text()='Edit']")
							.size();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			SizeExpected = 0;
			
			SizeActual = Source		.SeleniumHelper()
							.getWebElementList("//div[@id='loc-picker-table_wrapper']/div/div/a/span[text()='View']")
							.size();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			SizeExpected = 1;
			
			SizeActual = Source		.SeleniumHelper()
							.getWebElementList("//div[@id='loc-picker-table_wrapper']/div/div/a/span[text()='Excel']")
							.size();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			String userId = 
					Source		.UserHomeOfficeAccord()
					.clickUserHomeOfficeAdd()
					.setUserHomeOfficeStartDate(sevenDaysAgo, clear)
					.setUserBaseLocation("central office")
					.clickComplete()
					.UserStaffPage()
					.clickSubmit()
					.clickPopupOk()
					.DataTable()
					.readFirstResultID()
					.replaceAll("[^0-9]", EmptyString);
			
			
			
			/*
			 * EDIT Mode
			 */
			SizeExpected = 1;
			SizeActual = Source		.OrganizationNavigator()
							.clickUsersStaff()
							.setSearch(userId)
							.clickFirstRow()
							.clickEdit()
							.UserStaffPage()
							.clickUserInfoAccord()
							.GetSource()
							.SeleniumHelper()
							.getWebElementList("//div[@id='loc-picker-table_wrapper']/div/div/a/span[text()='Add']")
							.size();
			
			/*Show buttons to tester*/
			Source.UserHomeOfficeAccord().readAddBtn();
			Source.UserHomeOfficeAccord().readExcelBtn();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			SizeExpected = 0;
			
			SizeActual = Source		.SeleniumHelper()
							.getWebElementList("//div[@id='loc-picker-table_wrapper']/div/div/a/span[text()='Edit']")
							.size();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			SizeExpected = 0;
			
			SizeActual = Source		.SeleniumHelper()
							.getWebElementList("//div[@id='loc-picker-table_wrapper']/div/div/a/span[text()='View']")
							.size();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			SizeExpected = 1;
			
			SizeActual = Source		.SeleniumHelper()
							.getWebElementList("//div[@id='loc-picker-table_wrapper']/div/div/a/span[text()='Excel']")
							.size();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			
			Source.UserHomeOfficeAccord()
							.clickUserHomeOfficeAdd()
							.setUserHomeOfficeStartDate(Today, clear)
							.setUserBaseLocation("OCFS-CBH")
							.clickComplete()
							.UserStaffPage()
							.clickSubmit()
							.clickPopupOk();
			
			
			
			
			/*
			 * VIEW Mode
			 */
			SizeExpected = 0;
			SizeActual = Source		.OrganizationNavigator()
							.clickUsersStaff()
							.setSearch(userId)
							.clickFirstRow()
							.clickView()
							.UserStaffPage()
							.clickUserInfoAccord()
							.GetSource()
							.SeleniumHelper()
							.getWebElementList("//div[@id='loc-picker-table_wrapper']/div/div/a/span[text()='Add']")
							.size();
			/*Show buttons to tester*/
			Source.UserHomeOfficeAccord().readViewBtn();
			Source.UserHomeOfficeAccord().readExcelBtn();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			SizeExpected = 0;
			
			SizeActual = Source		.SeleniumHelper()
							.getWebElementList("//div[@id='loc-picker-table_wrapper']/div/div/a/span[text()='Edit']")
							.size();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			SizeExpected = 1;
			
			SizeActual = Source		.SeleniumHelper()
							.getWebElementList("//div[@id='loc-picker-table_wrapper']/div/div/a/span[text()='View']")
							.size();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			SizeExpected = 1;
			
			SizeActual = Source		.SeleniumHelper()
							.getWebElementList("//div[@id='loc-picker-table_wrapper']/div/div/a/span[text()='Excel']")
							.size();
			
			SoftAssert.assertEquals(SizeActual, SizeExpected);
			
			
			
			
			/*Validate End Date of old Base Loc*/
			Expected = yesterday;
			
			Actual = Source	.DataTable()
							.clickStartDateSort()
							.readDataTable(1, 4);
			
			SoftAssert.assertEquals(Expected, Actual);
			
			
			/*Validate Start Date of new Base Loc*/
			Expected = Today;
			
			Actual = Source	.DataTable()
							.readDataTable(2, 3);
			
			SoftAssert.assertEquals(Expected, Actual);
			
			
			
			

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}


}