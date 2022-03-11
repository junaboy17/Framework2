package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_Organization_ServicesSpecialties_Add_Edit_View extends OrganizationPage{

	@Test(priority=1)
	public void TC_Organization_ServicesSpecialties_Add_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding ServicesSpecialties");
			Expected ="Operation completed successfully.";

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
			                    .clickServicesSpecialties()
			                    .ServicesSpecialtiesPage()
			                    .clickAdd()
			                    .ServicesSpecialtiesPage()
			                    .selectServices("CRISIS")
			                    .selectSpecialties("CRISIS RESOLUTION-CHILDREN")
			                    .chooseCovergeArea("1000001911")
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
	public void TC_Organization_ServicesSpecialties_Edit_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Editing ServicesSpecialties");
			Expected ="Operation completed successfully.";

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
			                    .clickServicesSpecialties()
			                    .ServicesSpecialtiesPage()
								.clickFirstColumnLink()
			                    .clickEdit()
			                    .ServicesSpecialtiesPage()
			                    .setDescription("SELENIUM TEST RECORD - UPDATED")		                    
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
	public void TC_Organization_ServicesSpecialties_View_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying coverage button is disabled while in view mode");
			Expected =True;
			Actual =Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickServicesSpecialties()
								.ServicesSpecialtiesPage()
								.clickFirstRow()
								.clickView()
								.SeleniumHelper()
								.getAttribute(Source.ServicesSpecialtiesPage().CoverageButton, "disabled");
			SoftAssert.assertEquals(Actual, Expected);

					Source		.ServicesSpecialtiesPage()
								.clickBackToServices();
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}

	}
}

