package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;


public class TC_Organization_Location_Loading_Queries extends OrganizationPage {

	@Test(priority=1)
	
	public void OrganizationList_Anchor() {
		
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Moving through Organization data table pages, anchoring on an organization, verifying Location tab.");
			Source	
					//click on Organization area, scroll through five pages					
					.OrganizationPage()
					.clickPageTab1()
					.clickPageTab2()
					.clickPageTab3()
					.clickPageTab4()
					.clickPageTab5()
					// anchoring on an organization on different pages of data table
					.clickPageTab1()
					.DataTable()
					.clickFirstRow()
					.clickAnchor()
					.OrganizationNavigator()
					.clickLocations()
					.clickOrganizations()
					
					.clickPageTab2()
					.DataTable()
					.clickFirstRow()
					.clickAnchor()
					.OrganizationNavigator()
					.clickLocations()
					.clickOrganizations()
					
					.clickPageTab3()
					.DataTable()
					.clickFirstRow()
					.clickAnchor()
					.OrganizationNavigator()
					.clickLocations()
					.clickOrganizations()
					;

			SoftAssert.assertAll();	
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
			
					.assertFail();
		}
	}
}