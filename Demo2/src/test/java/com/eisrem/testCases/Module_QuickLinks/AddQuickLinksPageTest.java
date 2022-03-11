package com.eisrem.testCases.Module_QuickLinks;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.QuickLinksPage;


public class AddQuickLinksPageTest extends QuickLinksPage{


	@Test(priority=1)
	public void AddQuickLinksPageTitlesCheck() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'Add Quick Links' page title");
		Expected ="Add Quick Links";
		Actual = Source		.QuickLinksNavigator()
							.clickQuickLinks()
							.DataTable()
							.clickAdd()
							.QuickLinksPage()
							.readAddQuickLinksTitle();
		SoftAssert.assertEquals(Actual, Expected);		
		
		SeleniumHelper.log.info("Verifying 'Note' title");
		Expected ="Note: * indicates required field.";
		Actual = Source		.QuickLinksPage()
							.readNoteTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Link' link title");
		Expected ="Link";
		Actual = Source		.QuickLinksPage()
							.readLinkTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Link' tab title");
		Expected ="Link";
		Actual = Source		.QuickLinksPage()
							.readLinkTabTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Link Displayed Name' title");
		Expected ="Displayed Name *";
		Actual = Source		.QuickLinksPage()
							.readLinkDisplayedNameTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Link Url' title");
		Expected ="Link URL *";
		Actual = Source		.QuickLinksPage()
							.readLinkUrlTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Link Description' title");
		Expected ="Description:";
		Actual = Source		.QuickLinksPage()
							.readDescriptionTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Link Active' btn title");
		Expected ="Active?";
		Actual = Source		.QuickLinksPage()
							.readActiveTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Link 'Active' btn value");
		Expected ="true";
		Actual = Source		.QuickLinksPage()
							.readActiveToggle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available' link title");
		Expected ="Service Populations Available:";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.readServicePopulationsAvailableAccordTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Show entries' title");
		Expected ="Show\n"
				+ "10\n"
				+ "25\n"
				+ "50\n"
				+ "100\n"
				+ "entries";
		Actual = Source		.QuickLinksPage()
							.readShowEntriesTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Service Populations Available Add' button title");
		Expected = "Add";
		Actual = Source		.QuickLinksPage()
							.readAddBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Service Populations Available Edit' button title");
		Expected = "Edit";
		Actual = Source		.QuickLinksPage()
							.readEditBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Service Populations Available Excel' button title");
		Expected = "Excel";
		Actual = Source		.QuickLinksPage()
							.readExcelBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Id' list title");
		Expected = "Id";
		Actual = Source		.QuickLinksPage()
							.readIdList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Name/Type' list title");
		Expected = "Name/Type";
		Actual = Source		.QuickLinksPage()
							.readNameList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Start Date' list title");
		Expected = "Start Date";
		Actual = Source		.QuickLinksPage()
							.readStartDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available End Date' list title");
		Expected = "End Date";
		Actual = Source		.QuickLinksPage()
							.readEndDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Modified Date' list title");
		Expected = "Modified Date";
		Actual = Source		.QuickLinksPage()
							.readModifiedDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Previous' btn title");
		Expected = "Previous";
		Actual = Source		.QuickLinksPage()
							.readPreviousBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Next' btn title");
		Expected = "Next";
		Actual = Source		.QuickLinksPage()
							.readNextBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Submit & Exit' btn title");
		Expected ="Submit & Exit";
		Actual = Source		.QuickLinksPage()
							.readSubmitExitBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Back To List' btn title");
		Expected ="Back To List";
		Actual = Source		.QuickLinksPage()
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