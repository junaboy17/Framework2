package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.LocationType;
import com.eisrem.AppUtils.Enumerations.ServicePopulations;
import com.eisrem.Hooks.OrganizationPage;

public class TC_Organization_Identifiers_Edit_With_Service_Pop_001 extends OrganizationPage{

	@Test(priority=1)
	public void TC_Organization_Identifiers_Add_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Editing Identifiers with service pop");
			Expected ="Operation completed successfully.";

			Actual=Source		.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
			                    .clickLocations()
			                    .clickAdd()
			                    .LocationsPage()
			                    .setName("BHOPS-10749")
			                   	.selectType(LocationType.OTHER_LOCATION.getName())
								.toggleActive(T)
								.DataTable()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(ServicePopulations.ADULT_MH.getName())
								.setDescription(Description)
								.clickComplete()
								.DataTable()
								.clickSubmit()
								.clickPopupOk()
								.OrganizationNavigator()
			                    .clickLocations()
			                    .clickFirstRow()
			                    .clickAnchor()
			                    .OrganizationNavigator()
			                    .clickIdentifier()
			                    .clickAdd()
			                    .IdentifiersPage()
			                    .selectIdentifiersType(1)
			                    .setIdentifiersIdNumber("Test Ident")
			                    .clickSubmit()
			                    .clickPopupOk()
			                    .OrganizationNavigator()
			                    .clickIdentifier()
			                    .clickFirstRow()
			                    .clickEdit()
			                    .IdentifiersPage()
			                    .setEndDate(Tomorrow)
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
