package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_Organization_Identifiers_Add_Edit_View extends OrganizationPage{

	@Test(priority=1)
	public void TC_Organization_Identifiers_Add_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding Identifiers");
			Expected ="Operation completed successfully.";

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
			                    .clickLocations()
								.clickFirstColumnLink()
			                    .clickAnchor()
			                    .LocationsPage()
			                    .clickIdentifier()
			                    .clickAdd()
			                    .IdentifiersPage()
			                    .selectIdentifiersType(1)
			                    .setIdentifiersIdNumber("Test Ident")
			                    .clickSubmit()
			                    .readPopUpMessage();
	
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

}
	
	@Test(priority=2)
	public void TC_Organization_Identifiers_Edit_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Editing Identifiers");
			Expected ="Operation completed successfully.";

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
								.clickLocations()
								.clickFirstColumnLink()
				                .clickAnchor()
				                .LocationsPage()
				                .clickIdentifier()
								.clickFirstColumnLink()
				                .clickEdit()
				                .IdentifiersPage()
				                .setDescription("Updated")
				                .clickSubmit()
				                .readPopUpMessage();
	
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

}
	
	@Test(priority=3)
	public void TC_Organization_Identifiers_View_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Viewing Identifiers");
			ExpectedB =true;

			ActualB=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
								.clickLocations()
								.clickFirstColumnLink()
				                .clickAnchor()
				                .LocationsPage()
				                .clickIdentifier()
								.clickFirstColumnLink()
				                .clickView()
				                .IdentifiersPage()
				                .clickBackToIdentifiersList()
				                .isActiveTab("Identifier");

		SoftAssert.assertEquals(ActualB, ExpectedB);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}

}
	}

