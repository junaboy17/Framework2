package com.eisrem.testCases.Module_Organization;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;


public class TC_Organization_Location_End_Date extends OrganizationPage {

	@Test(priority=1)
	
	public  void Location_ServicePopulation_EndDate() {
		
		SoftAssert = new SoftAssert();

		String locName = "SELENIUM_Test_SrvPopEndDate #" + SeleniumHelper.generateRandomNumber(4);
		String PastDate10 = SeleniumHelper.dateOnlyPast(10);

		try {
			SeleniumHelper.log.info("Adding Location with Service Population to an organization, " 
					+ "end-dating Location and verifying Service Population got end-dated.");
			
			//Anchor on Organization
			Source	
				.OrganizationPage()
				.setSearch(OrgDHHS)
				.clickFirstRow()
				.clickAnchor()
				
			//Add Active Location				
				.OrganizationNavigator()
				.clickLocations()
				.clickAdd()
				.LocationsPage()
				.setName(locName)
				.selectType("OTHER_LOCATION")
				.toggleActive(T)
				.setStartDate(PastDate10, "Y")
			// Add Location Service Population
				.GetSource()
				.ServicePopulationsAvailableAccord()
				.clickSpAdd()				
				
				.setStartDate(PastDate10, "Y")
				.selectServicePopulation("ADULT MH")
				.setDescription("SELENIUM")
				.clickComplete()
				.LocationsPage()
				.clickSubmit()
				.clickPopupOk()
				;
			// End date Location and verify Service Population end date
			Expected = Today;
			Actual = Source
				.OrganizationNavigator()
				.clickLocations()
				.clickFirstRow()
				.clickEdit()
				.LocationsPage()
				.setEndDate(Today)
				.clickSubmit()
				.clickPopupOk()
				.OrganizationNavigator()
				.clickLocations()
				.clickFirstRow()
				.clickView()
				.ServicePopulationsAvailableAccord()
				.DataTable()
				.readFirstResultEndDate()				
				;

			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();
				
		}catch(Exception e) {
			Source	.SeleniumHelper()		
					.assertFail();
		}
	}
}
