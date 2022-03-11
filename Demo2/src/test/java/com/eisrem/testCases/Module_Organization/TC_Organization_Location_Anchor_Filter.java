package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;

public class TC_Organization_Location_Anchor_Filter extends OrganizationPage{
	
	@Test(priority=1)
	public void TC_Location_AddEdit_TTY() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Comparing Location count before and after anchoring on Location. ");

			String numbEntriesString;
			String count1 = "0";
			String count2 = "0";
			
			Source	// Anchoring on Organization
					.OrganizationPage().setSearch(OrgDHHS)
					.clickFirstRow()
					.clickAnchor()
					;
					// Reading Number of Entries label
			numbEntriesString = Source
					.OrganizationNavigator()
					.clickLocations()	
					.readShowNoOfEntries()
					.replace(" entries", EmptyString)
					;
					// Retrieving Number of Locations
			count1 = numbEntriesString.substring(numbEntriesString.lastIndexOf(" ") + 1);
					// Anchoring on Location
			Source
					.OrganizationPage()
					.clickFirstRow()
					.clickAnchor()
					;
					// Reading Number of Entries label
			numbEntriesString = Source
					.OrganizationNavigator()
					.clickLocations()	
					.readShowNoOfEntries()
					.replace(" entries", EmptyString)
					;
					// Retrieving Number of Locations
			count2 = numbEntriesString.substring(numbEntriesString.lastIndexOf(" ") + 1);
	
			SoftAssert.assertEquals(count1, count2);
			
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}
