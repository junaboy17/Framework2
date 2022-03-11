package com.eisrem.testCases.Module_Administrator.Add;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;


public class AddPagesPageTest extends AdministratorPage{


	@Test(priority=1)
	public void AddPagesPageTitlesCheck() {
		SoftAssert = new SoftAssert();
		
		try {
		SeleniumHelper.log.info("Verifying 'Add Pages' page title");
		Expected ="Add Pages";
		Actual = Source		.PagesPage()
							.clickPages()
							.DataTable()
							.clickAdd()
							.PagesPage()
							.readAddPagesTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Note' title");
		Expected ="Note: * indicates required field.";
		Actual = Source		.PagesPage()
							.readNoteTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		
		SeleniumHelper.log.info("Verifying 'Add Page/Complete' title");
		Expected ="Add Page/Complete will not save the data. Please click Submit to Save.";
		Actual = Source		.PagesPage()
							.readAddPageCompleteTitle();
		SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Verifying 'Pages Info' link title");
		Expected ="Pages Info:";
		Actual = Source		.PagesPage()
							.readPagesInfoLink();
		SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Verifying 'Pages Info Page' tab title");
		Expected ="Page";
		Actual = Source		.PagesPage()
							.readPageTab();
		SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Verifying 'Pages Info Page Name' title");
		Expected ="Page Name *";
		Actual = Source		.PagesPage()
							.readPageNameTitle();
		SoftAssert.assertEquals(Actual, Expected);		
		
		SeleniumHelper.log.info("Verifying 'Pages Info Start Date' title");
		Expected ="Start Date *";
		Actual = Source		.PagesPage()
							.readStartDateTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Pages Info End Date' title");
		Expected ="End Date";
		Actual = Source		.PagesPage()
							.readEndDateTitle();
		SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Verifying 'Pages Info Lock For Use' btn title");
		Expected ="Lock For Use";
		Actual = Source		.PagesPage()
							.readLockForUseBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Pages Info Lock For Use Yes No' btn title");
		Expected ="YES NO";
		Actual = Source		.PagesPage()
							.readLockForUseToggle();
		SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Verifying 'Pages Info Description' title");
		Expected ="Description";
		Actual = Source		.PagesPage()
							.readDescriptionTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Pages Info Preview' btn title");
		Expected ="Preview";
		Actual = Source		.PagesPage()
							.readPreviewBtn();
		SoftAssert.assertEquals(Actual, Expected);
	
		SeleniumHelper.log.info("Verifying 'Pages Info Copy Page' btn title");
		Expected ="Copy Page";
		Actual = Source		.PagesPage()
							.readCopyPageBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Pages Info Test Page' btn title");
		Expected ="Test Page";
		Actual = Source		.PagesPage()
							.readTestPageBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available' link title");
		Expected ="Sections Available:";
		Actual = Source		.PagesPage()
							.readSectionsAvailableLink();							
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying ' Sections Available Show entries' title");
		Expected ="Show\n"
				+ "10\n"
				+ "25\n"
				+ "50\n"
				+ "100\n"
				+ "entries";
		Actual = Source		.SectionsAvailableAccord()
							.readShowEntriesTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available Add' btn title");
		Expected ="Add";
		Actual = Source		.SectionsAvailableAccord()
							.readAddBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available Edit' btn title");
		Expected ="Edit";
		Actual = Source		.SectionsAvailableAccord()
							.readEditBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available Excel' btn title");
		Expected ="Excel";
		Actual = Source		.SectionsAvailableAccord()
							.readExcelBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available ID' list title");
		Expected = "ID";
		Actual = Source		.SectionsAvailableAccord()
							.readIdList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available Name' list title");
		Expected = "Name";
		Actual = Source		.SectionsAvailableAccord()
							.readNameList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available Start Date' list title");
		Expected = "Start Date";
		Actual = Source		.SectionsAvailableAccord()
							.readStartDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available End Date' list title");
		Expected = "End Date";
		Actual = Source		.SectionsAvailableAccord()
							.readEndDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available Modified Date' list title");
		Expected = "Modified Date";
		Actual = Source		.SectionsAvailableAccord()
							.readModifiedDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available Active' list title");
		Expected = "Active";
		Actual = Source		.SectionsAvailableAccord()
							.readActiveList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available Sort Order' list title");
		Expected = "Sort Order";
		Actual = Source		.SectionsAvailableAccord()
							.readSortOrderList();
		SoftAssert.assertEquals(Actual, Expected);
		

		SeleniumHelper.log.info("Verifying 'Sections Available Submit And Exit' btn title");
		Expected = "Submit & Exit";
		Actual = Source		.PagesPage()
							.readSubmitExitBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available Reset' btn title");
		Expected = "Reset";
		Actual = Source		.PagesPage()
							.readResetBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Sections Available Reset' btn title");
		Expected = "Back To List";
		Actual = Source		.PagesPage()
							.readBackToListBtn();
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
	
}