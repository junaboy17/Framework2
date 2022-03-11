package com.eisrem.testCases.Module_Administrator;

import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

import edu.emory.mathcs.backport.java.util.Arrays;

public class NotificationsPageTest extends AdministratorPage{


	@Test(priority=1)
	public void DataTableTitleCheck() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'Notifications'tab title");
		Expected = "Notifications";
		Actual = Source   	.AdministratorNavigator()
							.clickNotifications()
							.readNotificationsTab();
							
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Notifications' tab is selected");
		Source		.NotificationsPage()
					.clickNotifications();
		Expected = "active";
		Actual = Source.SeleniumHelper().getAttribute(Source.NotificationsPage().NotificationsTab, "class");
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Show entries' title");
		Expected ="Show\n"
				+ "10\n"
				+ "25\n"
				+ "50\n"
				+ "100\n"
				+ "entries";
		Actual = Source		.DataTable()
							.readShowEntriesTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Add'  title");
		Expected = "Add";
		Actual = Source		.DataTable()
							.readAddBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Edit'  title");
		Expected = "Edit";
		Actual = Source		.DataTable()
							.readEditBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'View'  title");
		Expected = "View";
		Actual = Source		.DataTable()
							.readViewBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Excel'  title");
		Expected = "Excel";
		Actual = Source		.DataTable()
							.readExcelBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Id' list title");
		Expected = "Id";
		Actual = Source		.DataTable()
							.readIdList();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Name/Type' list title");
		Expected = "Name/Type";
		Actual = Source		.DataTable()
							.readNameList();
		SoftAssert.assertEquals(Actual, Expected);


		SeleniumHelper.log.info("Verifying 'Start Date' list title");
		Expected = "Start Date";
		Actual = Source		.DataTable()
							.readStartDateList();
		SoftAssert.assertEquals(Actual, Expected);


		SeleniumHelper.log.info("Verifying 'End Date' list title");
		Expected = "End Date";
		Actual = Source		.DataTable()
							.readEndDateList();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Modified Date' list title");
		Expected = "Modified Date";
		Actual = Source		.DataTable()
							.readModifiedDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Previous'  title");
		Expected = "Previous";
		Actual = Source		.DataTable()
				 			.readPreviousBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Next'  title");
		Expected = "Next";
		Actual = Source		.DataTable()
				 			.readNextBtn();
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

	@Test(priority=2)
	public void DataTableFunctionsCheck() {		
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'Show Entries' Drop Down");
		String[] value =  {"10", "25", "50", "100"};
		@SuppressWarnings("unchecked")
		List<String> values = Arrays.asList(value);

		Source		.NotificationsPage()
					.clickNotifications();
		
		Source		.SeleniumHelper()
					.verifyAndClickAllDropDown(Source.DataTable().ShowEntriesDropdown, values)
					.sleep(25);
		
		Source		.DataTable()
					.selectShowEntries(0)
					.GetSource()
					.SeleniumHelper()
					.sleep(3);
		
		Expected = "Showing 1 to 10 of";		
		Actual = Source.DataTable().readShowNoOfEntries();
		SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		
	
		Source		.DataTable()
					.selectShowEntries(1)
					.GetSource()
					.SeleniumHelper()
					.sleep(8);

		Expected = "Showing 1 to 25 of";		
		Actual = Source.DataTable().readShowNoOfEntries();
		SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		

		Source		.DataTable()
					.selectShowEntries(2)
					.GetSource()
					.SeleniumHelper()
					.sleep(25);

		Expected = "Showing 1 to 50 of";		
		Actual = Source.DataTable().readShowNoOfEntries();
		SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		
		
		Expected = "Showing 1 to";		
		Actual = Source		.DataTable()
							.selectShowEntries(3)
							.GetSource()
							.SeleniumHelper()
							.sleep(25)
							.GetSource()
							.DataTable()
							.readShowNoOfEntries();
		SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		

		SeleniumHelper.log.info("Verifying Add  function");
		Expected = "Add Notifications";
		Actual = Source		.DataTable()
							.clickAdd()
							.NotificationsPage()
							.readAddNotificationsTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	}	
	
	@Test(priority=3)
	public void SearchFunctionsCheck() {		
		SoftAssert = new SoftAssert();

		try{
		Source		.NotificationsPage()
					.clickNotifications();
		
		SeleniumHelper.log.info("Verifying 'Search:' title");
		Expected = "Search:";
		Actual = Source		.DataTable()
							.readSearchTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Search Text Box' function with letters");
		Source.DataTable().setSearch("Created"+ Keys.TAB);
		Source.SeleniumHelper().sleep(2).verifyAllText(Source.DataTable().allDataResult, "Created", "CREATED", "created");
		
		SeleniumHelper.log.info("Verifying 'Search Text Box' function with numbers");
		Source			.DataTable()
						.setSearch("10", Clear);		
		Source.SeleniumHelper().sleep(5).verifyAllText(Source.DataTable().allDataResult, "10", "No data available");
		
		SeleniumHelper.log.info("Verifying 'Search Text Box' function with special characters");
		Source			.DataTable()
						.setSearch("/", Clear);
		Source.SeleniumHelper().sleep(2).verifyAllText(Source.DataTable().allDataResult, "/", "No data available");
		
		SeleniumHelper.log.info("Verifying 'Search Text Box' function with no result");
		Source			.DataTable()
						.setSearch("****************", Clear);
		Source.SeleniumHelper().sleep(2).verifyAllText(Source.DataTable().allDataResult, "No data available");
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	}

	@Test(priority=4)
	public void ListSortingCheck() {		
		SoftAssert = new SoftAssert();

		try{
		Source		.NotificationsPage()
					.clickNotifications()
					.GetSource()
					.SeleniumHelper()
					.sleep(3);
		
		SeleniumHelper.log.info("Verifying 'Id' list function");
		Source		.DataTable()
					.clickIdSort()
					.GetSource()
					.SeleniumHelper()
					.sleep(SleepSec);
		Expected = "Sorted Ascending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().IdSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		Source			.DataTable()
						.clickIdSort()
						.GetSource()
						.SeleniumHelper()
						.sleep(SleepSec);
		Expected = "Sorted Descending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().IdSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);


		SeleniumHelper.log.info("Verifying 'Name/Type' list function");
		Source		.DataTable()
					.clickNameSort()
					.GetSource()
					.SeleniumHelper()
					.sleep(SleepSec);
		Expected = "Sorted Ascending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().NameSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		Source			.DataTable()
						.clickNameSort()
						.GetSource()
						.SeleniumHelper()
						.sleep(SleepSec);
		Expected = "Sorted Descending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().NameSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Start Date' list function");
		Source		.DataTable()
					.clickStartDateSort()
					.GetSource()
					.SeleniumHelper()
					.sleep(SleepSec);
		Expected = "Sorted Ascending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().StartDateSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		Source		.DataTable()
					.clickStartDateSort()
					.GetSource()
					.SeleniumHelper()
					.sleep(SleepSec);
		Expected = "Sorted Descending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().StartDateSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'End Date' list function");
		Source		.DataTable()
					.clickEndDateSort()
					.GetSource()
					.SeleniumHelper()
					.sleep(SleepSec);
		Expected = "Sorted Ascending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().EndDateSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		Source		.DataTable()
					.clickEndDateSort()
					.GetSource()
					.SeleniumHelper()
					.sleep(SleepSec);
		Expected = "Sorted Descending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().EndDateSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Modified Date' list function");
		Source		.DataTable()
					.clickModifiedDateSort()
					.GetSource()
					.SeleniumHelper()
					.sleep(SleepSec);
		Expected = "Sorted Ascending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().ModifiedDateSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		Source		.DataTable()
					.clickModifiedDateSort()
					.GetSource()
					.SeleniumHelper()
					.sleep(SleepSec);
		Expected = "Sorted Descending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().ModifiedDateSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	}
	
	@Test(priority=5)
	public void DataTablePageTabCheck() {		
		SoftAssert = new SoftAssert();
		
		try{
			Source		.NotificationsPage()
						.clickNotifications()
						.GetSource()
						.DataTableTabTest()
						.TabTest();

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
//	@Test(priority=6)********Taking too long to load*********
//	public void ExcelDownloadCheck() {		
//		SoftAssert = new SoftAssert();
//		
//		Source		.NotificationsPage()
//					.clickNotifications();
//
//		SeleniumHelper.log.info("Verifying 'Excel' btn title");
//		Expected = "Excel";
//		Actual = Source		.DataTable()
//							.readExcel();
//		SoftAssert.assertEquals(Actual, Expected);
//
//		SeleniumHelper.log.info("Verifying complete Excel download for all result");
//		List <String> data = Source.SeleniumHelper().getTextFromWebElements(Source.DataTable().allDataResult);
//		
//		Source		.DataTable()
//					.clickExcel();
//				
//		Source		.SeleniumHelper()
//					.verifyExcelText(data, "download/Notifications_export.xlsx", "Data");
//		Source		.SeleniumHelper().sleep(3);
//					
//		SeleniumHelper.log.info("Verifying complete Excel download for search result");
//		Source		.DataTable()
//					.enterSearch("Notification" + Keys.TAB)
//					.clickExcel();
//		
//		data = Source.SeleniumHelper().getTextFromWebElements(Source.DataTable().allDataResult);
//		Source		.SeleniumHelper()
//					.verifyExcelText(data, "download/Notifications_export (1).xlsx", "Data");
//		
//		SoftAssert.assertAll();
//
//	}

}