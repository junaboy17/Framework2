package com.eisrem.testCases.Module_MyHomePage;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;
import com.eisrem.Hooks.PeoplePage;

public class TC_MyHomePage_MyClient_Validation extends MyHomePage{

	@Test(priority=1)
	public void TC_MyHomePage_MyClient_Validation_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Adding a person to My Clients and verifying Success");
			Expected = Success;
			
			String IDNum = 			Source	.MyHomePage()
											.clickMyClientsManage()
											.setAvailableFilter(LastName)
											.selectAvailableClient(1)
											.GetSource()
											.SeleniumHelper()
											.getAttribute(Source.MyClientsManagePage().AvailableFirstRow, "value");

			String SelectedRowText = Source	.MyClientsManagePage()
											.readAvailableFirstRow().replace(IDNum + " ", "");
			
			Actual = Source		.MyClientsManagePage()						
								.clickAdd()
								.clickSaveMyClients()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying My Clients was added successfully");
			Expected = SelectedRowText;
			Actual = Source		.Pagefactory()
								.clickGoBackToList()
								.MyHomePage()
								.readDataTable("Clients", 1, 2);
			SoftAssert.assertEquals(Actual, Expected);
						
			SeleniumHelper.log.info("Adding all Available entries to My Clients and verifying success");
			Expected = Success;
			Actual = Source		.MyHomePage()
								.clickMyClientsManage()
								.selectAllAvailableClients()
								.clickAdd()
								.clickSaveMyClients()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = "Showing 1 to 10 of 101 entries";
			Actual = Source		.Pagefactory()
								.clickGoBackToList()
								.MyHomePage()
								.readMyClientsShowingNumOfEntries();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Removing the first entry into My Clients and verifying successful removal");
			Expected = Success;
			Actual = Source		.MyHomePage()
								.clickMyClientsManage()
								.setSelectedFilter(LastName)
								.GetSource()
								.SeleniumHelper()
								.sleep(2)
								.GetSource()
								.MyClientsManagePage()
								.selectSelectedClient(1)
								.clickRemove()
								.clickSave()
								.Pagefactory()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			Expected = "Showing 1 to 10 of 100 entries";
			Actual = Source		.Pagefactory()
								.clickGoBackToList()
								.MyHomePage()
								.readMyClientsShowingNumOfEntries();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = "No matching records found";
			Actual = Source		.MyHomePage()
								.setSearchMyClients(LastName)
								.readDataTable("Clients", 1, 1);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Removing all Clients from My Clients and verifying successful removal");
			Expected = "Showing 0 to 0 of 0 entries";
			Actual = Source		.MyHomePage()
								.RemoveAllSelectedClientsAndSave()
								.readMyClientsShowingNumOfEntries();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}
