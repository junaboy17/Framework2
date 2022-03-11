package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_BHOPS_10742_Organization_ServicesSpecialties_View_001 extends OrganizationPage{

	@Test(priority=1)
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


