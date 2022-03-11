package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;

public class MyClientsManagePageTest extends MyHomePage{

	@Test(priority = 1)
	public void titleCheck() {
		
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'My Clients Manage' Page title");
		Expected = "My Clients";
		Actual = Source   	.MyHomePage()
							.clickMyClientsManage()
							.readMyClientsManagePageTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Clients' Link title");
		Expected = "My Clients";
		Actual = Source   	.MyClientsManagePage()
							.readMyClientsAccord();
							SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Available' title");
		Expected = "Available";
		Actual = Source   	.MyClientsManagePage()
							.readAvailableTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Add' title");
		Expected = "Add";
		Actual = Source   	.MyClientsManagePage()
							.readAddBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Remove' button title");
		Expected = "Remove";
		Actual = Source   	.MyClientsManagePage()
							.readRemoveBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Save' button title");
		Expected = "Save";
		Actual = Source   	.MyClientsManagePage()
							.readSaveBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Selected' title");
		Expected = "Selected";
		Actual = Source   	.MyClientsManagePage()
							.readSelectedTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
