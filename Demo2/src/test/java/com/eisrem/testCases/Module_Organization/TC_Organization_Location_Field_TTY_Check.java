package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_Organization_Location_Field_TTY_Check extends OrganizationPage{
	
	@Test(priority=1)
	public void TC_Location_AddEdit_TTY() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Adding a location, verifying TTY Number is saved, "
					+ "Editing Location by replacing TTY Number, verifying it is saved.");

			String orgName = "ACME";
			String locName = "SELENIUM_TEST_" + SeleniumHelper.generateRandomNumber(4);
			String ttyNumber1 = "1111111111";
			String ttyNumber1_formated = " (111) 111-1111";
			String ttyNumber2 = "2222222222";
			String ttyNumber2_formated = " (222) 222-2222";
			
			Source		.OrganizationPage()
						.setSearch(orgName).clickFirstRow().clickAnchor()
			
						.OrganizationNavigator()
						.clickLocations()					
						.clickAdd()
						.LocationsPage()
						.setName(locName)
						.selectType(LocationType.OTHER_LOCATION.getName())
						.toggleActive(T)
						.setTTY(ttyNumber1, "Y")
						.clickSubmit()
						.clickPopupOk();
			Actual = Source
						.OrganizationNavigator()
						.clickLocations()	
						.clickFirstRow()
						.clickView()
						.LocationsPage()
						.getTTYValue()
						;

			Expected = ttyNumber1_formated;
			SoftAssert.assertEquals(Actual, Expected);
			
			Source
						.LocationsPage()
						.clickBackTo()
						.DataTable()
						.clickFirstRow()
						.clickEdit()
						.LocationsPage()
						.setTTY(ttyNumber2, "Y")
						.clickSubmit()
						.clickPopupOk();
						;
						
			Actual = Source
						.OrganizationNavigator()
						.clickLocations()	
						.clickFirstRow()
						.clickView()
						.LocationsPage()
						.getTTYValue()
						;

					Expected = ttyNumber2_formated;
					SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}

