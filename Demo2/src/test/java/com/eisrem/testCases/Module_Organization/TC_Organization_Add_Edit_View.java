package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_Organization_Add_Edit_View extends OrganizationPage{

	@Test(priority=1)
	public void TC_Organization_Add_001() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Verifying Successful Adding Organization");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrganizationName + RandNum2)
								.selectOrganizationType(OrganizationType.OTHER.getName())
								.setDescription(Description)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			Source.DataTable().clickPopupOk();
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2)
	public void TC_Organization_Edit_001() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Create Organization");
			String orgId = Source.OrganizationPage().addCompleteOrganizationPageSubmitAndReturnId();
			
			SeleniumHelper.log.info("Verifying Successful Editing Organization");
			Expected = Success;
			Actual = Source		.DataTable()
								.setSearch(orgId)
								.clickFirstRow()
								.clickEdit()
								.OrganizationPage()
								.setDescription(DescriptionUpdated, EmptyString)
								.setEndDate(Today, EmptyString)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			Source.DataTable().clickPopupOk();
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=3)
	public void TC_Organization_View_001() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Create Organization");
			String orgId = Source.OrganizationPage().addCompleteOrganizationPageSubmitAndReturnId(OrganizationName + RandNum1, OrganizationType.OTHER, Today, null, 
					T, Description);
			
			SeleniumHelper.log.info("Verifying Successful Editing Organization");
			Expected = View;
			Actual = Source		.DataTable()
								.setSearch(orgId)
								.clickFirstRow()
								.clickView()
								.OrganizationPage()
								.clickBackToOrganizations()
								.readViewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			Source.OrganizationPage().endDateOrganization(orgId);
	
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
