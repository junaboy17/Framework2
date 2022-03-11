package com.eisrem.testCases.Business.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.BusinessUserLogIn;

public class ProviderUserMyClientsAddRemove extends BusinessUserLogIn {
	@Test(priority=1)
	public void MyClientsAddRemoveFunctionalityCheck() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding a client to My Client section in My HomePage DashBoard");
					Actual =	Source	.MyHomePage()
										.readDataTable("Clients", 1, 1);

					if(Actual.equalsIgnoreCase("No data available")) {
						Source	.MyHomePage()
								.clickMyClientsManage()
								.setAvailableFilter(JeanneClient, Clear)
								.selectAvailableClient(1)
								.clickAdd()
								.clickSaveMyClients()
								.clickGoBackToList();
					}
					
					Expected =	JeanneDOB;
					Actual =	Source	.MyHomePage()
										.readDataTable("Clients", 1, 2);
					SoftAssert.assertEquals(Actual, Expected);
					
			SeleniumHelper.log.info("Removing a client from My Client section in My HomePage DashBoard");
					Expected =	"No data available";
					Actual =	Source	.MyHomePage()
										.clickMyClientsManage()
										.setSelectedFilter(JeanneClient, Clear)
										.selectSelectedClient(1)
										.clickRemove()
										.clickSaveMyClients()
										.clickGoBackToList()
										.MyHomePage()
										.readDataTable("Clients", 1, 1);
					SoftAssert.assertEquals(Actual, Expected);
					

					SoftAssert.assertAll();


		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	
	
	
}
	
	

