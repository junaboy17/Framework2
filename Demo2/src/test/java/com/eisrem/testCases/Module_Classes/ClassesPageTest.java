package com.eisrem.testCases.Module_Classes;

import java.util.List;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.ClassesPage;

import edu.emory.mathcs.backport.java.util.Arrays;

public class ClassesPageTest extends ClassesPage{


	@Test(priority=1)
	public void DataTableTitleCheck() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'Classes' tab title");
		Expected = "Classes";
		Actual = Source   	.ClassesNavigator()
							.readClassesTab();
							
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Classes' tab is selected");
		Source		.ClassesPage()
					.clickClasses();
		Expected = "active";
		Actual = Source.SeleniumHelper().getAttribute(Source.ClassesPage().ClassesTab, "class");
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

		SeleniumHelper.log.info("Verifying 'Anchor' button title");
		Expected = "Anchor";
		Actual = Source		.DataTable()
							.readAnchorBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Add' button title");
		Expected = "Add";
		Actual = Source		.DataTable()
							.readAddBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Edit' button title");
		Expected = "Edit";
		Actual = Source		.DataTable()
							.readEditBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'View' button title");
		Expected = "View";
		Actual = Source		.DataTable()
							.readViewBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Excel' button title");
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
		
		SeleniumHelper.log.info("Verifying 'Previous' button title");
		Expected = "Previous";
		Actual = Source		.DataTable()
				 			.readPreviousBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Next' button title");
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

		Source		.ClassesPage()
					.clickClasses();
		
		Source		.SeleniumHelper()
					.verifyAndClickAllDropDown(Source.DataTable().ShowEntriesDropdown, values);
		
		Source		.DataTable()
					.selectShowEntries(0);
		
		Expected = "Showing 1 to";		
		Actual = Source.DataTable().readShowNoOfEntries();
		SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		
		
		Source		.DataTable()
					.selectShowEntries(1);

		Expected = "Showing 1 to";		
		Actual = Source.DataTable().readShowNoOfEntries();
		SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		

		Source		.DataTable()
					.selectShowEntries(2);

		Expected = "Showing 1 to";		
		Actual = Source.DataTable().readShowNoOfEntries();
		SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		
	
		Source		.DataTable()
					.selectShowEntries(3);
		
		Expected = "Showing 1 to";		
		Actual = Source.DataTable().readShowNoOfEntries();
		SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		

		SeleniumHelper.log.info("Verifying Add button function");
		Expected = "Add Classes";
		Actual = Source		.DataTable()
							.clickAdd()
							.ClassesPage()
							.readAddClassesTitle();
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source		.SeleniumHelper()
					.assertFail();
	}
	}	
	
	@Test(priority=3)
	public void SearchFunctionsCheck() {		
		SoftAssert = new SoftAssert();

		try{
		Source		.ClassesPage()
					.clickClasses();
		
		SeleniumHelper.log.info("Verifying 'Search:' title");
		Expected = "Search:";
		Actual = Source		.DataTable()
							.readSearchTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Search Text Box' function with letters");
		Source			.DataTable()
						.setSearch("Test", Clear);
		Source.SeleniumHelper().verifyAllText(Source.DataTable().allDataResult, "TEST", "Test", "test");
		
		SeleniumHelper.log.info("Verifying 'Search Text Box' function with numbers");
		Source			.DataTable()
						.setSearch("12321312", Clear);		
		Source.SeleniumHelper().verifyAllText(Source.DataTable().allDataResult, "No data available");
		
		SeleniumHelper.log.info("Verifying 'Search Text Box' function with special characters");
		Source			.DataTable()
						.setSearch("/", Clear);
		Source.SeleniumHelper().verifyAllText(Source.DataTable().allDataResult, "No data available");
		
		SeleniumHelper.log.info("Verifying 'Search Text Box' function with no result");
		Source			.DataTable()
						.setSearch("****************", Clear);
		Source.SeleniumHelper().verifyAllText(Source.DataTable().allDataResult, "No data available");
		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.quitBrowser()
				.assertFail();
	}
	}

	@Test(priority=4)
	public void ListSortingCheck() {		
		SoftAssert = new SoftAssert();

		try{	
		Source		.ClassesPage()
					.clickClasses();
		
		SeleniumHelper.log.info("Verifying 'Id' list function");
		Source		.DataTable()
					.clickIdSort();
		Expected = "Sorted Ascending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().IdSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		Source			.DataTable()
						.clickIdSort();
		Expected = "Sorted Descending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().IdSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);


		SeleniumHelper.log.info("Verifying 'Name/Type' list function");
		Source		.DataTable()
					.clickNameSort();
		Expected = "Sorted Ascending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().NameSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		Source			.DataTable()
						.clickNameSort();
		Expected = "Sorted Descending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().NameSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Modified Date' list function");
		Source		.DataTable()
					.clickModifiedDateSort();
		Expected = "Sorted Ascending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().ModifiedDateSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		Source		.DataTable()
					.clickModifiedDateSort();
		Expected = "Sorted Descending";
		Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().ModifiedDateSort, "alt");
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source		.SeleniumHelper()
					.assertFail();
	}
	}
	
	@Test(priority=5)
	public void DataTablePageTabCheck() {		
		SoftAssert = new SoftAssert();
	
		try{
				Source	.ClassesPage()
						.clickClasses()
						.GetSource()
						.DataTableTabTest()
						.TabTest();
						
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
//			SeleniumHelper.log.info("Verifying 'next' button is enabled when Tab 1 is selected");
//			Expected = "paginate_button next";
//			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().nextBtn, "class");
//			SoftAssert.assertEquals(Actual, Expected);
//
//			SeleniumHelper.log.info("Verifying 'Previous' button is enabled when next is clicked");
//			Source				.DataTable()
//								.clickNext();
//			Expected = "paginate_button previous";
//			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().PreviousBtn, "class");
//			SoftAssert.assertEquals(Actual, Expected);
//			
//			SeleniumHelper.log.info("Verifying 'next' button is disabled when last page tab is selected");
//			Source				.DataTable()
//								.clickPageTab2();
//			Expected = "paginate_button previous disabled";
//			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().nextBtn, "class");
//					
//			SeleniumHelper.log.info("Verifying Page Tab '1' function");
//			Expected = "paginate_button current";
//			Source				.DataTable()
//								.clickPageTab1();
//			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().pageTab1, "class");
//			SoftAssert.assertEquals(Actual, Expected);
//			
//			SizeExpected = 4;		
//			SizeActual = Source	.DataTable()
//								.getSizePageTabAll();
//			SoftAssert.assertEquals(Actual, Expected);
//			
//			Expected = "Showing 1 to";		
//			Actual = Source.DataTable().readShowNoOfEntries();
//			SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));		
//			
//			SeleniumHelper.log.info("Verifying Page Tab '2' function");
//			Expected = "paginate_button current";
//			Source				.DataTable()
//								.clickPageTab2();
//			Actual = Source.SeleniumHelper().getAttribute(Source.DataTable().pageTab2, "class");
//			SoftAssert.assertEquals(Actual, Expected);
//			
//			SizeExpected = 4;		
//			SizeActual = Source	.DataTable()
//								.getSizePageTabAll();
//			SoftAssert.assertEquals(Actual, Expected);
//			
//			Expected = "Showing 11 to";		
//			Actual = Source.DataTable().readShowNoOfEntries();
//			SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	
//		}
				
//	@Test(priority=6)
	public void ExcelDownloadCheck() {		
		SoftAssert = new SoftAssert();

		try{
		Source		.ClassesPage()
					.clickClasses();

		SeleniumHelper.log.info("Verifying 'Excel' btn title");
		Expected = "Excel";
		Actual = Source		.DataTable()
							.readExcelBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying complete Excel download for all result");
		List <String> data = Source.SeleniumHelper().getTextFromWebElements(Source.DataTable().allDataResult);
		System.out.println(data);
		Source		.DataTable()
					.clickExcel();
		
		Source		.SeleniumHelper()
					.verifyExcelText(data, "download/Classes_export.xlsx", "Data");
					
		SeleniumHelper.log.info("Verifying complete Excel download for search result");
		Source		.DataTable()
					.setSearch("Test" + Keys.TAB)
					.clickExcel();
		
		data = Source.SeleniumHelper().getTextFromWebElements(Source.DataTable().allDataResult);
		Source		.SeleniumHelper()
					.verifyExcelText(data, "download/Classes_export.xlsx", "Data");
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source		.SeleniumHelper()
					.assertFail();
	}

	}

}