package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;

public class TC_MyHomePage_Manage extends MyHomePage{

	@Test(priority=1)
	public void TC_MyHomePage_Manage_001() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Dismissing My Inbox Entry and verifying Success");
		Expected = Success;
		Actual = Source		.DataTable()
							.clickFirstRow()
							.GetSource()
							.MyHomePage()
							.clickMyInboxDismiss()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Adding My Clients and verifying Success");
		Expected = Success;
		Actual = Source		.Pagefactory()
							.clickGoBackToList()
							.MyHomePage()
							.clickMyClientsManage()
							.selectAvailableClient(1)
							.clickAdd()
							.clickSaveMyClients()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Adding My Reports and verifying Success");
		Expected = Success;
		Actual = Source		.Pagefactory()
							.clickGoBackToList()
							.MyHomePage()
							.clickMyReportsManage()
							.selectAvailableReport(1)
							.clickMyReportsAdd()
							.clickSaveMyReports()
							.readPopUpTitle(); 
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Running My Reports and verifying Success");
		Expected = "Type in your last name ";
		Actual = Source		.Pagefactory()
							.clickGoBackToList()
							.DataTable()
							.clickRow("my-reports-table", 1)
							.GetSource()
							.MyHomePage()
							.clickMyReportsRun()
							.GetSource()
							.SeleniumHelper()
							.switchWindow()
							.GetSource()
							.MyReportsManagePage()
							.readTransitionReportTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Running My Reports and verifying Success");
		Expected = "My Home Page";
		Actual = Source		.SeleniumHelper()
							.switchWindow()
							.GetSource()
							.MyHomePage()
							.readMyHomePageTitle();
		SoftAssert.assertEquals(Actual, Expected);
							
		SeleniumHelper.log.info("Cleaning up");
		Expected = "My Home Page";
		Actual = Source		.MyHomePage()
							.clickMyClientsManage()
							.RemoveAllSelectedClients(T)
							.GetSource()
							.MyHomePage()
							.clickMyReportsManage()
							.RemoveAllSelectedReports(T)
							.GetSource()
							.MyHomePage()
							.readMyHomePageTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}
	

}
