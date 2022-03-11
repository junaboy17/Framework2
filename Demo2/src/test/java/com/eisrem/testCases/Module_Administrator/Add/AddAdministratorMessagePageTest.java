package com.eisrem.testCases.Module_Administrator.Add;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.pageFactory.CommonPage.ServicePopulationsAvailableAccord;


public class AddAdministratorMessagePageTest extends AdministratorPage{


	@Test(priority=1)
	public void AddAdministratorMessagePageTitlesCheck() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'Add Administrator Message' page title");
		Expected ="Add Administrator Message";
		Actual = Source		.AdministratorMessagesPage()
							.clickAdministratorMessages()
							.DataTable()
							.clickAdd()
							.AdministratorMessagesPage()
							.readAddAdministratorMessagePageTitle();
		SoftAssert.assertEquals(Actual, Expected);		
		
		SeleniumHelper.log.info("Verifying 'Note' title");
		Expected ="Note: * indicates required field.";
		Actual = Source		.AdministratorMessagesPage()
							.readNoteTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Administrator Message' link title");
		Expected ="Administrator Message:";
		Actual = Source		.AdministratorMessagesPage()
							.readAdministratorMessagelinkTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Message' tab title");
		Expected ="Message";
		Actual = Source		.AdministratorMessagesPage()
							.readAdministratorMessageMessageTabTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Administrator Message Start Date' title");
		Expected ="Start Date *";
		Actual = Source		.AdministratorMessagesPage()
							.readStartDateTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Administrator Message End Date' title");
		Expected ="End Date";
		Actual = Source		.AdministratorMessagesPage()
							.readEndDateTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Administrator Message Message Type' title");
		Expected ="Message Type *";
		Actual = Source		.AdministratorMessagesPage()
							.readMessageTypeTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Administrator Message Message' title");
		Expected ="Message:";
		Actual = Source		.AdministratorMessagesPage()
							.readMessageTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		
		SeleniumHelper.log.info("Verifying 'Administrator Message Internal'  title");
		Expected ="Internal?";
		Actual = Source		.AdministratorMessagesPage()
							.readInternalToggleTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Administrator Message Internal Yes No'  title");
		Expected =True;
		Actual = Source		.AdministratorMessagesPage()
							.readInternalToggle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Add Administrator Message Active'  title");
		Expected ="Active?";
		Actual = Source		.AdministratorMessagesPage()
							.readActiveTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Administrator Message Active Yes No'  title");
		Expected = False;
		Actual = Source		.AdministratorMessagesPage()
							.readActiveToggle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Roles Available' link title");
		Expected ="Roles Available:";
		Actual = Source		.AdministratorMessagesPage()
							.readRolesAvailablelinkTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Roles Available Show entries' title");
		Expected ="Show\n"
				+ "10\n"
				+ "25\n"
				+ "50\n"
				+ "100\n"
				+ "entries";
		Actual = Source		.RolesAvailableAccord()
							.readShowEntriesTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Roles Available Add'  title");
		Expected = "Add";
		Actual = Source		.RolesAvailableAccord()
							.readAddBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Roles Available Edit'  title");
		Expected = "Edit";
		Actual = Source		.RolesAvailableAccord()
							.readEditBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Roles Available Excel'  title");
		Expected = "Excel";
		Actual = Source		.RolesAvailableAccord()
							.readExcelBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Roles Available Id' list title");
		Expected = "Id";
		Actual = Source		.RolesAvailableAccord()
							.readIdList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Roles Available Name/Type' list title");
		Expected = "Name/Type";
		Actual = Source		.RolesAvailableAccord()
							.readNameTypeList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Roles Available Start Date' list title");
		Expected = "Start Date";
		Actual = Source		.RolesAvailableAccord()
							.readStartDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Roles Available End Date' list title");
		Expected = "End Date";
		Actual = Source		.RolesAvailableAccord()
							.readEndDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Roles Available Modified Date' list title");
		Expected = "Modified Date";
		Actual = Source		.RolesAvailableAccord()
							.readModifiedDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Roles Available Previous'  title");
		Expected = "Previous";
		Actual = Source		.RolesAvailableAccord()
							.readPreviousBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Roles Available Next'  title");
		Expected = "Next";
		Actual = Source		.RolesAvailableAccord()
							.readNextBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available' link title");
		Expected ="Service Populations Available:";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.clickServicePopulationAvailableAccord()
							.readServicePopulationsAvailableAccordTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Show entries' title");
		Expected ="Show\n"
				+ "10\n"
				+ "25\n"
				+ "50\n"
				+ "100\n"
				+ "entries";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.readShowEntriesTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Service Populations Available Add'  title");
		Expected = "Add";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.readAddBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Service Populations Available Edit'  title");
		Expected = "Edit";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.readEditBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Service Populations Available Excel'  title");
		Expected = "Excel";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.readExcelBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Id' list title");
		Expected = "Id";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.readIdList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Name/Type' list title");
		Expected = "Name/Type";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.readNameTypeList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Start Date' list title");
		Expected = "Start Date";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.readStartDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available End Date' list title");
		Expected = "End Date";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.readEndDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Modified Date' list title");
		Expected = "Modified Date";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.readModifiedDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Previous'  title");
		Expected = "Previous";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.readPreviousBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Service Populations Available Next'  title");
		Expected = "Next";
		Actual = Source		.ServicePopulationsAvailableAccord()
							.readNextBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Submit & Exit'  title");
		Expected ="Submit & Exit";
		Actual = Source		.TypesPage()
							.readSubmitExitBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Back To Administrator Messages'  title");
		Expected ="Back To Administrator Messages";
		Actual = Source		.AdministratorMessagesPage()
							.readBackToAdministratorMessagesBtn();
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
	
