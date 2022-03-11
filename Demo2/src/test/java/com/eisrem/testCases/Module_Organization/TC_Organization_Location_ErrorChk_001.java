package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.OrganizationType;
import com.eisrem.Hooks.OrganizationPage;

public class TC_Organization_Location_ErrorChk_001 extends OrganizationPage{
	
	@Test(priority=1)
	public void TC_Location_Add_StateUser_003() {
		SoftAssert = new SoftAssert();
		
		String LocationOne = LocationName + SeleniumHelper.generateRandomAlpha(4);

		try {
			SeleniumHelper.log.info("Add a new organization");
			Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.setOrganizationName(OrganizationName + SeleniumHelper.generateRandomAlpha(4))
								.selectOrganizationType(OrganizationType.OTHER.getName())
								.setDescription(Description)
								.clickSubmit()
								.clickPopupOk();
			
			SeleniumHelper.log.info("Create first location");
			String locId = Source
						// Adding a location 
						.OrganizationNavigator()
						.clickLocations()					
						.clickAdd()
						.LocationsPage()
						.setName(LocationOne)
						.selectType(LocationType.BASE.getName())
						.toggleActive(T)
						.setEndDate(Tomorrow, Clear)
						.DataTable()
						.clickAdd()
						.ServicePopulationsAvailableAccord()					
						.selectServicePopulation(ServicePopulations.CHILDRENS.getName())
						.setDescription(Description)
						.clickComplete()
						.LocationsPage()
						.clickSubmit()
						.clickPopupOk()
						.OrganizationNavigator()
						.clickLocations()
						.DataTable()
						.readFirstResultID();
			
			SeleniumHelper.log.info("Create second location and look at error message");
			Expected = "This Organization already has a base location for the specific date range: " + LocationOne.toUpperCase() + " (" + locId + ")";
			Actual = Source
					.OrganizationNavigator()
					.clickLocations()					
					.clickAdd()
					.LocationsPage()
					.setName(LocationName + SeleniumHelper.generateRandomAlpha(4))
					.selectType(LocationType.BASE.getName())
					.toggleActive(T)
					.setEndDate(Tomorrow, Clear)
					.DataTable()
					.clickAdd()
					.ServicePopulationsAvailableAccord()					
					.selectServicePopulation(ServicePopulations.CHILDRENS.getName())
					.setDescription(Description)
					.clickComplete()
					.LocationsPage()
					.clickSubmit()
					.readTopErrorMessage(2);
			Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}
