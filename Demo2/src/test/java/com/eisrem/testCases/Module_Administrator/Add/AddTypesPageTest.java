package com.eisrem.testCases.Module_Administrator.Add;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;


public class AddTypesPageTest extends AdministratorPage{


	@Test(priority=1)
	public void AddTypesPageTitlesCheck() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying 'Add Types' page title");
			Expected ="Add Types";
			Actual = Source		.TypesPage()
								.clickTypes()
								.DataTable()
								.clickAdd()
								.TypesPage()
								.readAddTypesPageTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Note' title");
			Expected ="Note: * indicates required field.";
			Actual = Source		.TypesPage()
								.readNoteTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Add Page/Complete' title");
			Expected ="Add Page/Complete will not save the data. Please click Submit to Save.";
			Actual = Source		.TypesPage()
								.readAddPageCompleteTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Types Info' link title");
			Expected ="Types Info:";
			Actual = Source		.TypesPage()
								.readTypesInfoLink();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Type' tab title");
			Expected ="Type";
			Actual = Source		.TypesPage()
								.readTypeTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Start Date' title");
			Expected ="Start Date *";
			Actual = Source		.TypesPage()
								.readStartDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'End Date' title");
			Expected ="End Date";
			Actual = Source		.TypesPage()
								.readEndDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'App Module' title");
			Expected ="App Module *";
			Actual = Source		.TypesPage()
								.readAppModuleTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Name' title");
			Expected ="Name *";
			Actual = Source		.TypesPage()
								.readNameTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Lock Time' title");
			Expected ="Lock Time *";
			Actual = Source		.TypesPage()
								.readLockTimeTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Description' title");
			Expected ="Description";
			Actual = Source		.TypesPage()
								.readDescriptionTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Multiple Allowed' title");
			Expected ="Multiple Allowed?";
			Actual = Source		.TypesPage()
								.readMultipleAllowedTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Multiple Allowed' Yes No title");
			Expected ="false";
			Actual = Source		.TypesPage()
								.readMultipleAllowedToggle();
					SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Lock For Use' title");
			Expected ="Lock For Use";
			Actual = Source		.TypesPage()
								.readLockForUseTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Lock For Use' Yes No title");
			Expected ="false";
			Actual = Source		.TypesPage()
								.readLockforUseToggle();
					SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Preview' btn title");
			Expected ="Preview";
			Actual = Source		.TypesPage()
								.readPreviewBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Test Form' btn title");
			Expected ="Test Form";
			Actual = Source		.TypesPage()
								.readTestFormBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Pages Available' link title");
			Expected ="Pages Available:";
			Actual = Source		.TypesPage()
								.readPagesAvailableLinkTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Show entries' title");
			Expected ="Show\n"
					+ "10\n"
					+ "25\n"
					+ "50\n"
					+ "100\n"
					+ "entries";
			Actual = Source		.TypesPage()
								.readShowEntriesTitle();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Add' button title");
			Expected = "Add";
			Actual = Source		.TypesPage()
								.readAddBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Edit' button title");
			Expected = "Edit";
			Actual = Source		.TypesPage()
								.readEditBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Excel' button title");
			Expected = "Excel";
			Actual = Source		.TypesPage()
								.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Id' list title");
			Expected = "ID";
			Actual = Source		.TypesPage()
								.readIdList();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Name' list title");
			Expected = "Name";
			Actual = Source		.TypesPage()
								.readNameList();
			SoftAssert.assertEquals(Actual, Expected);
	
	
			SeleniumHelper.log.info("Verifying 'Sort Order' list title");
			Expected = "Sort Order";
			Actual = Source		.TypesPage()
								.readSortOrderList();
			SoftAssert.assertEquals(Actual, Expected);
	
	
			SeleniumHelper.log.info("Verifying 'Required' list title");
			Expected = "Required";
			Actual = Source		.TypesPage()
								.readRequiredList();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Active On Type' list title");
			Expected = "Active On Type";
			Actual = Source		.TypesPage()
								.readActiveList();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Page Locked' list title");
			Expected = "Page Locked";
			Actual = Source		.TypesPage()
								.readPageLockedList();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Previous' button title");
			Expected = "Previous";
			Actual = Source		.TypesPage()
					 			.readPreviousBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Next' button title");
			Expected = "Next";
			Actual = Source		.TypesPage()
					 			.readNextBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Copyright' title");
			Expected = "Copyright © " + CopyRightYear + " State of Maine DHHS.\n"
					+ "All Rights Reserved.";
			Actual = Source		.DataTable()
					 			.readCopyright();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'SubmitExit' btn title");
			Expected ="Submit & Exit";
			Actual = Source		.TypesPage()
								.readSubmitExitBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Print' btn title");
			Expected ="Print";
			Actual = Source		.TypesPage()
								.readPrintBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Back To Types' btn title");
			Expected ="Back To Types";
			Actual = Source		.TypesPage()
								.readBackToTypesBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			
			SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
}