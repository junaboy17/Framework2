package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;

public class MyHomePageTest extends MyHomePage{

	@Test(priority=1)
	public void MyHomePageTitleCheck() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'My Home Page' title");
		Expected = "My Home Page";
		Actual =	 Source	.MyHomePage()
							.readMyHomePageTitle();			
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Dashboard' tab title");
		Expected = "My Dashboard";
		Actual = 	Source	.MyHomePage()
							.readMyDashboardTab();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Inbox' link title");
		Expected = "My Inbox";
		Actual = 	Source	.MyHomePage()
							.readMyInboxLink();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Inbox Show entries' title");
		Expected ="Show\n"
				+ "10\n"
				+ "25\n"
				+ "50\n"
				+ "100\n"
				+ "entries";
		Actual = 	Source	.MyHomePage()
							.readMyInboxShowEntriesTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'My Inbox Dismiss' button title");
		Expected = "Dismiss";
		Actual = 	Source	.MyHomePage()
							.readMyInboxDismissBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Inbox Excel' button title");
		Expected = "Excel";
		Actual = 	Source	.MyHomePage()
							.readMyInboxExcelBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying ' My Inbox Id' list title");
		Expected = "ID";
		Actual = 	Source	.MyHomePage()
							.readMyInboxIdList();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'My Inbox Name' list title");
		Expected = "Name";
		Actual = 	Source	.MyHomePage()
							.readMyInboxNameList();
		SoftAssert.assertEquals(Actual, Expected);


		SeleniumHelper.log.info("Verifying 'My Inbox Date' list title");
		Expected = "Date";
		Actual = 	Source	.MyHomePage()
							.readMyInboxDateList();
		SoftAssert.assertEquals(Actual, Expected);


		SeleniumHelper.log.info("Verifying 'My Inbox Source' list title");
		Expected = "Source";
		Actual = 	Source	.MyHomePage()
							.readMyInboxSourceList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Clients' link title");
		Expected = "My Clients:";
		Actual = 	Source	.MyHomePage()
							.readMyClientsLink();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Clients Show entries' title");
		Expected ="Show\n"
				+ "10\n"
				+ "25\n"
				+ "50\n"
				+ "100\n"
				+ "entries";
		Actual = 	Source	.MyHomePage()
							.readMyClientsShowEntriesTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'My Clients Manage' button title");
		Expected = "Manage";
		Actual = 	Source	.MyHomePage()
							.readMyClientsManageBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Clients Excel' button title");
		Expected = "Excel";
		Actual = 	Source	.MyHomePage()
							.readMyClientsExcelBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying ' My Clients Id' list title");
		Expected = "ID";
		Actual =	 Source	.MyHomePage()
							.readMyClientsId();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'My Clients Name' list title");
		Expected = "Name";
		Actual = 	Source	.MyHomePage()
							.readMyClientsNameList();
		SoftAssert.assertEquals(Actual, Expected);


		SeleniumHelper.log.info("Verifying 'My Clients DOB' list title");
		Expected = "DOB";
		Actual = 	Source	.MyHomePage()
							.readMyClientsDOBList();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'My Clients Gender' list title");
		Expected = "Gender";
		Actual = 	Source	.MyHomePage()
							.readMyClientsGenderList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Clients Medicaid ID' list title");
		Expected = "Medicaid ID";
		Actual = 	Source	.MyHomePage()
							.readMyClientsMedicaidIDList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Reports' link title");
		Expected = "My Reports:";
		Actual = 	Source	.MyHomePage()
							.readMyReportsLink();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Reports Show entries' title");
		Expected ="Show\n"
				+ "10\n"
				+ "25\n"
				+ "50\n"
				+ "100\n"
				+ "entries";
		Actual =	 Source	.MyHomePage()
							.readMyReportsShowEntriesTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'My Reports Run' button title");
		Expected = "Run";
		Actual =	 Source	.MyHomePage()
							.readMyReportsRunBtn();
		SoftAssert.assertEquals(Actual, Expected); 
		
		SeleniumHelper.log.info("Verifying 'My Reports Manage' button title");
		Expected = "Manage";
		Actual = 	Source	.MyHomePage()
							.readMyReportsManageBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Reports Excel' button title");
		Expected = "Excel";
		Actual = 	Source	.MyHomePage()
							.readMyReportsExcelBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying ' My Reports Id' list title");
		Expected = "ID";
		Actual =	 Source	.MyHomePage()
							.readMyReportsIdList();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'My Reports Name/Type' list title");
		Expected = "Name/Type";
		Actual = 	Source	.MyHomePage()
							.readMyReportsNameTypeList();
		SoftAssert.assertEquals(Actual, Expected);


		SeleniumHelper.log.info("Verifying 'My Reports Created Date' list title");
		Expected = "Created Date";
		Actual =	 Source	.MyHomePage()
							.readMyReportsCreatedDateList();
		SoftAssert.assertEquals(Actual, Expected);


		SeleniumHelper.log.info("Verifying 'My Reports Modified Date' list title");
		Expected = "Modified Date";
		Actual = 	Source	.MyHomePage()
							.readMyReportsModifiedDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Reports Medicaid ID' list title");
		Expected = "Report Type";
		Actual = 	Source	.MyHomePage()
							.readMyReportsReportTypeList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Previous' button title");
		Expected = "Previous";
		Actual =	 Source	.MyHomePage()
							.readMyReportsPreviousBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Next' button title");
		Expected = "Next";
		Actual =	 Source	.MyHomePage()
				 			.readMyReportsNextBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Copyright' title");
		Expected = "Copyright © " + CopyRightYear + " State of Maine DHHS.\n"
						+ "All Rights Reserved.";
		Actual = Source		.DataTable()
							.readCopyright();
		SoftAssert.assertEquals(Actual, Expected);


		SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

	@Test(priority= 2)
	public void MyHomePageFunctionsCheck() {
		
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'Dashboard' tab function");
		Expected = "false";
		Actual =	Source	.MyHomePage()
							.clickMyDashboard()
							.GetSource()
							.SeleniumHelper()
							.getAttribute(Source.MyHomePage().MyDashboardTab, "aria-expanded");
		SoftAssert.assertEquals(Actual, Expected);
	
		Expected = "true";
		Actual = 	Source	.MyHomePage()
							.clickMyDashboard()
							.GetSource()
							.SeleniumHelper()
							.getAttribute(Source.MyHomePage().MyDashboardTab, "aria-expanded");
		SoftAssert.assertEquals(Actual, Expected);
	
		SeleniumHelper.log.info("Verifying 'My Inbox' link function");
		Expected = "false";
		Actual = 	Source	.MyHomePage()
							.clickMyInbox()
							.GetSource()
							.SeleniumHelper()
							.getAttribute(Source.MyHomePage().MyInboxLink, "aria-expanded");
		SoftAssert.assertEquals(Actual, Expected);
	
		Expected = "true";
		Actual = 	Source	.MyHomePage()
							.clickMyInbox()
							.GetSource()
							.SeleniumHelper()
							.getAttribute(Source.MyHomePage().MyInboxLink, "aria-expanded");
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Clients' link function");
		Expected = "false";
		Actual = 	Source	.MyHomePage()
							.clickMyClients()
							.GetSource()
							.SeleniumHelper()
							.getAttribute(Source.MyHomePage().MyClientsLink, "aria-expanded");
		SoftAssert.assertEquals(Actual, Expected);
	
		Expected = "true";
		Actual =  	Source	.MyHomePage()
							.clickMyClients()
							.GetSource()
							.SeleniumHelper()
							.getAttribute(Source.MyHomePage().MyClientsLink, "aria-expanded");
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'My Reports' link function");
		Expected = "false";
		Actual =	Source	.MyHomePage()
							.clickMyReports()
							.GetSource()
							.SeleniumHelper()
							.getAttribute(Source.MyHomePage().MyReportsLink, "aria-expanded");
		SoftAssert.assertEquals(Actual, Expected);
	
		Expected = "true";
		Actual = 	Source	.MyHomePage()
							.clickMyReports()
							.GetSource()
							.SeleniumHelper()
							.getAttribute(Source.MyHomePage().MyReportsLink, "aria-expanded");
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	
	}
	

}
