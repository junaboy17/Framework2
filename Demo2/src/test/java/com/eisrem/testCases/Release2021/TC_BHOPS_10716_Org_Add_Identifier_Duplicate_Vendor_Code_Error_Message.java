package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_BHOPS_10716_Org_Add_Identifier_Duplicate_Vendor_Code_Error_Message extends OrganizationPage{


	@Test(priority=1)
	public void Add_Identifier_Duplicate_Error_Message() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying Error message after adding duplicate Organization Identifier");
			Expected ="Please correct the following errors:";
			ID = Source			.DataTable()
								.setSearch(OrgDHHS)
								.clickFirstRow()
								.clickAnchor()
								.OrganizationNavigator()
								.clickLocations()
								.clickAdd()
								.LocationsPage()
								.setName(LocationName)
								.selectType(2)
								.setPhone(PhoneNumber)
								.clickAddLocStateUserToggle()
								.GetSource()
								.ServicePopulationsAvailableAccord()
								.clickAdd()
								.ServicePopulationsAvailableAccord()
								.selectServicePopulation(3)
								.clickComplete()
								.LocationsPage()
								.clickSubmit()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickLocations()
								.setSearch(LocationName)
								.readFirstResultID()
								.replace("Select", EmptyString)
								.replace(" ", EmptyString);
			
			Actual = Source		.OrganizationNavigator()
								.clickIdentifier()
								.clickAdd()
								.IdentifiersPage()
								.selectIdentifiersType(1)
								.setIdentifiersIdNumber(RandNum8)
								.clickSubmit()
								.clickPopupOk()
								.OrganizationNavigator()
								.clickIdentifier()
								.clickAdd()
								.IdentifiersPage()
								.selectIdentifiersType(1)
								.setIdentifiersIdNumber(RandNum8)
								.clickSubmit()
								.readTopErrorMessage(1);
			
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected ="ERROR Message:\n"
					+ "Conflict with existing identifier:\n"
					+ "Organization =" + OrgDHHS  + ", Location ID=" + ID + ", CS VENDOR CODE ID=" + RandNum8 + ", Start Date=" + Today + ", End Date=null";
			Actual = Source		.DataTable()
								.readTopErrorMessage(2);
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}