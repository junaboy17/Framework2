package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.OrganizationType;
import com.eisrem.Hooks.OrganizationPage;

public class TC_Organization_Services_TryResources_001 extends OrganizationPage{

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
	public void TC_Organization_Services_TryResources_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Services_TryResources");
			Expected ="Operation completed successfully.";
			
			Actual=Source		.DataTable()
					            .clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
			                    .clickServicesSpecialties()
			                    .ServicesSpecialtiesPage()
			                    .clickAdd()
			                    .ServicesSpecialtiesPage()
			                    .selectServices("CRISIS")
			                    .selectSpecialties("CRISIS RESOLUTION-CHILDREN")
			                    .chooseFirstCovergeArea()
			                    .clickSubmit()
			                    .clickGoBackToList()
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
}
