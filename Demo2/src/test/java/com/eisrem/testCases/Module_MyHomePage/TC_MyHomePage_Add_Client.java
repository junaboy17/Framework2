package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;
import com.eisrem.Hooks.PeoplePage;

public class TC_MyHomePage_Add_Client extends MyHomePage{

	@Test(priority=1)
	public void TC_MyClients_Add_Client_001() {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Adding a Person onto My Clients list on My Homepage");
	
		String IDNum = Source	.MyHomePage()
								.clickMyClientsManage()
								.GetSource()
								.SeleniumHelper()
								.getAttribute(Source.MyClientsManagePage().AvailableFirstRow, "value");
		
		String SelectedRowText = Source		.MyClientsManagePage()
											.readAvailableFirstRow().replace(IDNum + " ", "");
		
		Expected = Success;
		Actual = Source		.MyClientsManagePage()
							.setAvailableFilter(IDNum)
							.selectAvailableClient(1)
							.clickAdd()
							.clickSaveMyClients()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying newly Client was added successfully");
		Expected = SelectedRowText;
		Actual = Source		.Pagefactory()
							.clickGoBackToList()
							.MyHomePage()
							.setSearchMyClients(IDNum)
							.GetSource()
							.MyHomePage()
							.readDataTable("Clients", 1, 2);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Removing added Client from My Clients");
		Source			.MyHomePage()
						.removeClient(IDNum);
		
		SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}