package com.eisrem.testCases.Module_Classes;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.ClassesPage;


public class AddClassesPageTest extends ClassesPage{


	@Test(priority=1)
	public void AddClassesPageTitlesCheck() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying 'Add Classes' page title");
		Expected ="Add Classes";
		Actual = Source		.DataTable()
							.clickAdd()
							.ClassesPage()
							.readAddClassesTitle();
		SoftAssert.assertEquals(Actual, Expected);		
		
		SeleniumHelper.log.info("Verifying 'Note' title");
		Expected ="Note: * indicates required field.";
		Actual = Source		.ClassesPage()
							.readNoteTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Classes' link title");
		Expected ="Classes";
		Actual = Source		.ClassesPage()
							.readClassesLinkTitle();
		SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Verifying 'Classes Class Name' title");
		Expected ="Class Name: *";
		Actual = Source		.ClassesPage()
							.readClassNameTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Classes Seats Available title");
		Expected ="Seats Available *";
		Actual = Source		.ClassesPage()
							.readSeatsAvailableTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Classes Seats Taken title");
		Expected ="Seats Taken";
		Actual = Source		.ClassesPage()
							.readSeatsTakenTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Classes Start Date title");
		Expected ="Start Date *";
		Actual = Source		.ClassesPage()
							.readStartDateTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Classes End Date title");
		Expected ="End Date *";
		Actual = Source		.ClassesPage()
							.readEndDateTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Classes Service Population title");
		Expected ="Service Population *";
		Actual = Source		.ClassesPage()
							.readServicePopulationTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Classes Program Type title");
		Expected ="Program Type";
		Actual = Source		.ClassesPage()
							.readProgramTypeTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Classes Organization/Location title");
		Expected ="Organization/Location *";
		Actual = Source		.ClassesPage()
							.readOrganizationLocationTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
//		SeleniumHelper.log.info("Verifying 'Classes Out of State' btn title");
//		Expected ="Out of State?";
//		Actual = Source		.ClassesPage()
//							.readOutOfStateBtnTitle();
//		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Classes Out Of State Yes No' btn title");
		Expected = False;
		Actual = Source		.ClassesPage()
							.readOutOfStateToggle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Classes Description' title");
		Expected ="Description:";
		Actual = Source		.ClassesPage()
							.readDescriptionTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Active' toggle title");
		Expected ="Active?";
		Actual = Source		.Pagefactory()
							.readActiveTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Classes Active Yes No' btn title");
		Expected = True;
		Actual = Source		.Pagefactory()
							.readActiveToggle();
		SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Verifying 'Submit & Exit' btn title");
		Expected ="Submit & Exit";
		Actual = Source		.Pagefactory()
							.readSubmitBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Back To Classes' btn title");
		Expected ="Back To Classes";
		Actual = Source		.Pagefactory()
							.readBackToBtn();
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