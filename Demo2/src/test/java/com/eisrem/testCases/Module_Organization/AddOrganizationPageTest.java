package com.eisrem.testCases.Module_Organization;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;


public class AddOrganizationPageTest extends OrganizationPage{

	@Test(priority=1)
	public void AddOrganizationTitleCheck() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Verifying 'Add Organization' title");
			Expected ="Add Organization";
			Actual = Source		.DataTable()
								.clickAdd()
								.OrganizationPage()
								.readAddOrganizationTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
	
			SeleniumHelper.log.info("Verifying Note title");
			Expected = "Note: * indicates required field.";
			Actual = Source   	.OrganizationPage()
								.readNoteTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
	
			SeleniumHelper.log.info("Verifying 'Org General Info' Link title");
			Expected = "Org General Info:";
			Actual = Source		.OrganizationPage()
								.readLinkTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
	
			SeleniumHelper.log.info("Verifying 'Org General Info Start Date' title");
			Expected = "Start Date *";
			Actual = Source		.OrganizationPage()
								.readStartDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
	
			SeleniumHelper.log.info("Verifying 'Org General Info End Date' title");
			Expected = "End Date";
			Actual = Source		.OrganizationPage()
								.readEndDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
	
			SeleniumHelper.log.info("Verifying 'Org General Info Organization Name*' title");
			Expected = "Organization Name *";
			Actual = Source		.OrganizationPage()
								.readOrganizationNameTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
	
			SeleniumHelper.log.info("Verifying 'Org General Info Organization Type*' title");
			Expected = "Organization Type *";
			Actual = Source		.OrganizationPage()
								.readOrganizationTypeTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
	
			SeleniumHelper.log.info("Verifying 'Org General Info Active' btn title");
			Expected = "Active";
			Actual = Source		.OrganizationPage()
								.readActiveTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Org General Info Active Yes No' btn title");
			Expected = "true";
			Actual = Source		.OrganizationPage()
								.readActiveToggle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
	
	
			SeleniumHelper.log.info("Verifying 'Org General Info Description' title");
			Expected = "Description";
			Actual = Source		.OrganizationPage()
								.readDescriptionTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
	
	
			SeleniumHelper.log.info("Verifying 'Tax info' Link title");
			Expected = "Tax Info:";
			Actual = Source		.OrganizationPage()
								.clickTaxInfoLinkTitle()
								.readTaxInfoLinkTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
	
			SeleniumHelper.log.info("Verifying 'Tax info Industry Classification' title");
			Expected = "Industry Classification";
			Actual = Source		.OrganizationPage()
								.readTaxInfoIndustryClassificationTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Tax info Tax Status' title");
			Expected = "Tax Status";
			Actual = Source		.OrganizationPage()
								.readTaxInfoTaxStatusTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Tax info Fiscal Year Start Month' title");
			Expected = "Fiscal Year Start Month";
			Actual = Source		.OrganizationPage()
								.readTaxInfoFiscalYearStartMonthTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Tax info Fiscal Year End Month' title");
			Expected = "Fiscal Year End Month";
			Actual = Source		.OrganizationPage()
								.readTaxInfoFiscalYearEndMonthTitle();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Submit' btn text");
			Expected = "Submit";
			Actual = Source		.OrganizationPage()
								.readSubmitBtn();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			SeleniumHelper.log.info("Verifying 'Back To Organizations' TitleTextbox");
			Expected = "Back To Organizations";
			Actual = Source		.OrganizationPage()
					 			.readBackToOrganizationsBtn();
			SoftAssert.assertEquals(Actual, Expected);
			SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
			
			
			SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}