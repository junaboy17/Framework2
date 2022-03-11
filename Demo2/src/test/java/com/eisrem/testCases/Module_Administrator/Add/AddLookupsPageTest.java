package com.eisrem.testCases.Module_Administrator.Add;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;


public class AddLookupsPageTest extends AdministratorPage{


	@Test(priority=1)
	public void AddLookupsPageTitlesCheck() {
		SoftAssert = new SoftAssert();

		try{	
		SeleniumHelper.log.info("Verifying 'Add Lookups' page title");
		Expected ="Add Lookups";
		Actual = Source		.AdministratorNavigator()
							.clickLookups()
							.DataTable()
							.clickAdd()
							.LookupsPage()
							.readAddLookupsPageTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Note' title");
		Expected ="Note: * indicates required field.";
		Actual = Source		.LookupsPage()
							.readNoteTitle();
		SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Verifying 'Lookups Info' link title");
		Expected ="Lookups Info:";
		Actual = Source		.LookupsPage()
							.readLookupsInfoLink();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Group' tab title");
		Expected ="Group";
		Actual = Source		.LookupsPage()
							.readGroupTab();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Start Date' title");
		Expected ="Start Date *";
		Actual = Source		.LookupsPage()
							.readStartDateTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'End Date' title");
		Expected ="End Date";
		Actual = Source		.LookupsPage()
							.readEndDateTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Group Name' title");
		Expected ="Group Name *";
		Actual = Source		.LookupsPage()
							.readGroupNameTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		
		SeleniumHelper.log.info("Verifying 'Category' title");
		Expected ="Category";
		Actual = Source		.LookupsPage()
							.readCategoryTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Description' title");
		Expected ="Description";
		Actual = Source		.LookupsPage()
							.readDescriptionTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Multiple Allowed' title");
		Expected ="Multiple Allowed";
		Actual = Source		.LookupsPage()
							.readMultipleAllowedTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Multiple Allowed' toggle default value");
		Expected = True;
		Actual = Source		.LookupsPage()
							.readMultipleAllowedToggle();
				SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Active' btn title");
		Expected ="Active?";
		Actual = Source		.LookupsPage()
							.readActiveTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Active' toggle default value");
		Expected = True;
		Actual = Source		.Pagefactory()
							.readActiveToggle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'System Lookup' btn title");
		Expected ="System Lookup";
		Actual = Source		.LookupsPage()
							.readSystemLookupTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'System Lookup' toggle default value");
		Expected =	True;
		Actual = Source		.LookupsPage()
							.readSystemLookUpToggle();
		SoftAssert.assertEquals(Actual, Expected);		
		
		SeleniumHelper.log.info("Verifying 'Labels Available' link title");
		Expected ="Labels Available:";
		Actual = Source		.LookupsPage()		
							.readLabelsAvailableLinkTitle();
								
		SoftAssert.assertEquals(Actual, Expected);
		

		SeleniumHelper.log.info("Verifying 'Labels Available Show entries' title");
		Expected ="Show\n"
				+ "10\n"
				+ "25\n"
				+ "50\n"
				+ "100\n"
				+ "entries";
		Actual = Source		.LookupsPage()
							.clickLabelsAvailableAccord()
							.readShowEntriesTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Labels Available Add'  title");
		Expected = "Add";
		Actual = Source		.LookupsPage()
							.readAddBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Labels Available Edit'  title");
		Expected = "Edit";
		Actual = Source		.LookupsPage()
							.readEditBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Labels Available Excel'  title");
		Expected = "Excel";
		Actual = Source		.LookupsPage()
							.readExcelBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Labels Available Id' list title");
		Expected = "ID";
		Actual = Source		.LookupsPage()
							.readIdList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Labels Available Name' list title");
		Expected = "Name";
		Actual = Source		.LookupsPage()
							.readNameList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Labels Available Sort Order' list title");
		Expected = "Sort Order";
		Actual = Source		.LookupsPage()
							.readSortOrderList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Labels Available Lookup Score' list title");
		Expected = "Lookup Score";
		Actual = Source		.LookupsPage()
							.readLookupScoreList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Labels Available Indent' list title");
		Expected = "Indent";
		Actual = Source		.LookupsPage()
							.readIndentList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Labels Available Previous'  title");
		Expected = "Previous";
		Actual = Source		.LookupsPage()
							.readPreviousBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Labels Available Next'  title");
		Expected = "Next";
		Actual = Source		.LookupsPage()
							.readNextBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
			
		SeleniumHelper.log.info("Verifying 'Copyright' title");
		Expected = "Copyright © " + CopyRightYear + " State of Maine DHHS.\n"
				+ "All Rights Reserved.";
		Actual = Source		.DataTable()
				 			.readCopyright();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Submit' btn title");
		Expected ="Submit";
		Actual = Source		.LookupsPage()
							.readSubmitBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Print' btn title");
		Expected ="Print";
		Actual = Source		.LookupsPage()
							.readPrintBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Back To Lookups' btn title");
		Expected ="Back To Lookups";
		Actual = Source		.LookupsPage()
							.readBackToLookupsBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		
		SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	}
	
