package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Types_Test_Lock_Check extends AdministratorPage{
	@Test(priority=1)
	public void TC_Types_Test_Lock_Check_001() {		
		SoftAssert = new SoftAssert();
		try{
			
			
			SeleniumHelper.log.info("Search for and test Initial Contact Type");
			Expected = False;
			Actual = Source		.TypesPage()
								.setSearch("INITIAL CONTACT")
								.clickFirstRow()
								.clickEdit()
								.TypesPage()
								.isTestFormEnabled();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}