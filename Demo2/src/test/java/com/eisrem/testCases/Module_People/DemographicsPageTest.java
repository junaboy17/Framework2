package com.eisrem.testCases.Module_People;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;


public class DemographicsPageTest extends PeoplePage{


	@Test(priority=1)
	public void DemographicsPageTitleCheck() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'Add Demographics' page title");
		Expected ="Add Demographics";
		Actual = Source		.DataTable()
							.clickAdd()
							.DemographicsPage()
							.readAddDemographicsTitle();
		SoftAssert.assertEquals(Actual, Expected);		
		
		SeleniumHelper.log.info("Verifying 'Note' title");
		Expected ="Note: * indicates required field.";
		Actual = Source		.DemographicsPage()
							.readNoteTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics' link title");
		Expected ="Demographics";
		Actual = Source		.DemographicsPage()
							.readDemographicsParentAccordionTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics Demographics' link title");
		Expected ="Demographics";
		Actual = Source		.DemographicsPage()
							.readDemographicsChildAccordionTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics Start Date' title");
		Expected ="Start Date *";
		Actual = Source		.DemographicsPage()
							.readStartDateTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics End Date' title");
		Expected ="End Date";
		Actual = Source		.DemographicsPage()
							.readEndDateTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics First Name' title");
		Expected ="First Name *";
		Actual = Source		.DemographicsPage()
							.readFirstNameTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics Middle Name' title");
		Expected ="Middle Name";
		Actual = Source		.DemographicsPage()
							.readMiddleNameTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics Last Name' title");
		Expected ="Last Name *";
		Actual = Source		.DemographicsPage()
							.readLastNameTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics Name Suffix' title");
		Expected ="Name Suffix";
		Actual = Source		.DemographicsPage()
							.readSuffixTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics Gender' title");
		Expected ="Gender *";
		Actual = Source		.DemographicsPage()
							.readGenderTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics Date Of Birth' title");
		Expected ="Date Of Birth *";
		Actual = Source		.DemographicsPage()
							.readDateOfBirthTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		
		SeleniumHelper.log.info("Verifying 'Demographics Date Of Death' title");
		Expected ="Date Of Death";
		Actual = Source		.DemographicsPage()
							.readDateOfDeathTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics Contact' btn title");
		Expected ="Contact?";
		Actual = Source		.DemographicsPage()
							.readContactBtnTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics Contact Yes No' btn title");
		Expected ="YES NO";
		Actual = Source		.DemographicsPage()
							.readContactYesNoBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics Sensitive' btn title");
		Expected ="Sensitive?";
		Actual = Source		.DemographicsPage()
							.readSensitiveBtnTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Demographics Contact Yes No' btn title");
		Expected ="YES NO";
		Actual = Source		.DemographicsPage()
							.readSensitiveToggle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Identifiers' link title");
		Expected ="Identifiers";
		Actual = Source		.DemographicsPage()
							.readIdentifiersAccord();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Identifiers Show entries' title");
		Expected ="Show\n"
				+ "10\n"
				+ "25\n"
				+ "50\n"
				+ "100\n"
				+ "entries";
		Actual = Source		.DemographicsPage()
							.clickIdentifiersAccord()
							.DataTable()
							.readShowEntriesTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Identifiers Add' button title");
		Expected = "Add";
		Actual = Source		.DataTable()
							.readAddBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Identifiers Edit' button title");
		Expected = "Edit";
		Actual = Source		.DataTable()
							.readEditBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying 'Identifiers Excel' button title");
		Expected = "Excel";
		Actual = Source		.DataTable()
							.readExcelBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Identifiers Id' list title");
		Expected = "ID";
		Actual = Source		.DataTable()
							.readIdList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Identifiers Type' list title");
		Expected = "Name";
		Actual = Source		.DataTable()
							.readNameList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Identifiers Start Date' list title");
		Expected = "Start Date";
		Actual = Source		.DataTable()
							.readStartDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Identifiers End Date' list title");
		Expected = "End Date";
		Actual = Source		.DataTable()
							.readEndDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Identifiers Modified Date' list title");
		Expected = "Modified Date";
		Actual = Source		.DataTable()
							.readModifiedDateList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Identifiers Previous' btn title");
		Expected = "Previous";
		Actual = Source		.DataTable()
							.readPreviousBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Identifiers Next' btn title");
		Expected = "Next";
		Actual = Source		.DataTable()
							.readNextBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Status' link title");
		Expected ="Status";
		Actual = Source		.DemographicsPage()
							.clickStatusAccord()
							.readStatusAccord();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Status Household' title");
		Expected ="Household";
		Actual = Source		.DemographicsPage()
							.readHouseholdTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Status Marital' title");
		Expected ="Marital";
		Actual = Source		.DemographicsPage()
							.readMaritalTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Status Military' title");
		Expected ="Military";
		Actual = Source		.DemographicsPage()
							.readMilitaryTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Status Citizenship' title");
		Expected ="Citizenship";
		Actual = Source		.DemographicsPage()
							.readCitizenshipTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Status Military Service' title");
		Expected ="Military Service";
		Actual = Source		.DemographicsPage()
							.readMilitaryServiceTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Status Country Of Citizenship' title");
		Expected ="Country Of Citizenship";
		Actual = Source		.DemographicsPage()
							.readCountryOfCitizenshipTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Submit' btn title");
		Expected ="Submit";
		Actual = Source		.DemographicsPage()
							.readSubmitBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Print' btn title");
		Expected ="Print";
		Actual = Source		.DemographicsPage()
							.readPrintBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Back To Demographics' btn title");
		Expected ="Back To People";
		Actual = Source		.DemographicsPage()
							.readBackToPeopleBtn();
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