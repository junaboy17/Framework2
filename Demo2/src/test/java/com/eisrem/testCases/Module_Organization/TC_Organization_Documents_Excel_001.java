package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;


public class TC_Organization_Documents_Excel_001 extends OrganizationPage{
	
	@Test(priority=1)
	public void TC_Organization_Documents_Excel_001() {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Downloading Excel file");

			   Source           .DataTable()
								.setSearch(OrgDHHS)
								.clickFirstColumnLink()
								.clickAnchor()
								.OrganizationNavigator()
			                    .clickDocuments()
			                    .clickExcel();
			                    
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	 }

   }
}