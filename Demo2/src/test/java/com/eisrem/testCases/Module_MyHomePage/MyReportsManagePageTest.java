package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;

public class MyReportsManagePageTest extends MyHomePage{

	@Test(priority = 1)
	public void titleCheck() {
		
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'My Reports Manage' Page title");
		Expected = "My Reports";
		Actual = Source   	.MyHomePage()
							.clickMyReportsManage()
							.readMyReportsManagePageTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Reports' Link title");
		Expected = "My Reports";
		Actual = Source   	.MyReportsManagePage()
							.readMyReportsLinkTitle();
							SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Available' title");
		Expected = "Available";
		Actual = Source   	.MyReportsManagePage()
							.readAvailableTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Add' title");
		Expected = "Add";
		Actual = Source   	.MyReportsManagePage()
							.readAddBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Remove' button title");
		Expected = "Remove";
		Actual = Source   	.MyReportsManagePage()
							.readRemoveBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Save' button title");
		Expected = "Save";
		Actual = Source   	.MyReportsManagePage()
							.readSaveBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Selected' title");
		Expected = "Selected";
		Actual = Source   	.MyReportsManagePage()
							.readSelectedTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
