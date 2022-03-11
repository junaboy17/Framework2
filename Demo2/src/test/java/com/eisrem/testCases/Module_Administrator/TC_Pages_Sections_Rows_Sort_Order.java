package com.eisrem.testCases.Module_Administrator;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Pages_Sections_Rows_Sort_Order extends AdministratorPage{
	@Test(priority=18)
	public void TC_Pages_Sections_Rows_Sort_Order_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Create a new unlocked page");
			HashMap<String, String> names = Source.PagesPage().addCompletePageGetNames(F);
			 
			SeleniumHelper.log.info("Confirm Sort Order exists for Section");	
			Expected = "Sort Order";
			Actual = Source		.PagesPage()
								.setSearch(names.get("PageName"))
								.clickFirstRow()
								.clickEdit()
								.DataTable()
								.readSortOrderList();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Confirm Sort Order exists for Row");
			Expected = "Sort Order";
			Actual = Source   	.PagesPage()
								.setSearch(names.get("SectionName"))
								.clickFirstRow()
								.clickEdit()
								.RowsAvailableAccord()
								.readSortOrderList();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("End Date the new page");
			Source				.SectionsAvailableAccord()
								.clickSectionsBack()
								.clickBackToList()
								.PagesPage()
								.endDatePageAndSubmit(names.get("PageName"), Today);
		
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=19)
	public void TC_Pages_Sections_Rows_Sort_Order_002() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Create a new unlocked page");
			HashMap<String, String> names = Source.PagesPage().addCompletePageGetNames(F);
			 
			SeleniumHelper.log.info("Confirm Sort Order exists for Section");	
			Expected = SortOrderText;
			Actual = Source		.PagesPage()
								.setSearch(names.get("PageName"))
								.clickFirstRow()
								.clickEdit()
								.DataTable()
								.readSortOrderList();
			
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Confirm Sort Order exists for Row");
			Expected = Success;
			Actual = Source   	.SectionsAvailableAccord()
								.addSection()
								.GetSource()
								.RowsAvailableAccord()
								.addRow()
								.clickRowSubmit()
								.readPopUpTitle();
					
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("End Date the new page");
			Source				.PagesPage()
								.endDatePageAndSubmit(names.get("PageName"), Today);
		
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}
