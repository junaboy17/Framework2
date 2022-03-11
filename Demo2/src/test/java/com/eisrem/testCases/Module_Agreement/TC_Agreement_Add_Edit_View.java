package com.eisrem.testCases.Module_Agreement;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AgreementPage;


public class TC_Agreement_Add_Edit_View extends AgreementPage{


	@Test(priority=1)
	public void TC_Agreement_Add_001() {
		SoftAssert = new SoftAssert();

		int RandNum3 = SeleniumHelper.generateRandomNumber(3);
		int RandNum7 = SeleniumHelper.generateRandomNumber(7);
		String AgreementName = "Agreement Test" + RandNum3;
		
		try{
		SeleniumHelper.log.info("Verifying success add Agreement");
		Expected =Success;
		Actual = Source		.DataTable()
							.clickAdd()
							.AgreementPage()
							.selectType(2)
							.setAgreementName(AgreementName)
							.setAgreementContractNum(RandNum7)
							.setOrgName("DHHS")
							.setOrgContactEmailAdress(Email)
							.setAgreementManager("T")
							.selectOrgFederallBillingId(1)
							.clickSubmit()
							.readPopUpTitle();
		
		
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Agreement Add was successful");
		Expected = AgreementName.toUpperCase() + "/ " + Enumerations.AgreementType.SPECIAL_SERVICES.getName() + "/ " + RandNum7 + "/ " + "1";
		Actual = Source		.DataTable()
							.clickPopupOk()
							.DataTable()
							.readFirstResultNameType();
				SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=2)
	public void TC_Agreement_Add_002() {
		SoftAssert = new SoftAssert();

		int RandNum3 = SeleniumHelper.generateRandomNumber(3);
		int RandNum7 = SeleniumHelper.generateRandomNumber(7);
		String AgencyName = "Test" + RandNum3;
		String AgreementName = "Agreement Test" + RandNum3;
		
		try{
		SeleniumHelper.log.info("Adding Agreement with Service Type and verifying success title");
		Expected =Success;
		Actual = Source		.DataTable()
							.clickAdd()
							.AgreementPage()
							.setStartDate(Today, Clear)
							.setEndDate(FutureDate7)
							.GetSource()
							.AgreementPage()
							.selectType(2)
							.setAgreementName(AgreementName)
							.setAgreementContractNum(RandNum7)
							.setOrgName("REACT BEHAVIORAL")
							.setAgreementManager("REVO")
							.selectOrgFederallBillingId(1)
							.setOrgContactEmailAdress(Email)
							.setDescription("Selenium test.")
							.DataTable()
							.clickAdd()
							.FundSourceAccord()
							.setStartDate(Today, Clear)
							.setEndDate(FutureDate7)
							.selectServiceType(6)	
							.setAmount(RandMoneyAmount)
							.selectProgramArea(9)
							.setFiscalYear("2018")
							.selectFundingType(3)
							.setAgency(AgencyName)
							.selectAppropriationUnit(17)
							.setObject(RandNum7)
							.selectReportingOrganization(4)
							.selectActivity(4)
							.selectSettlementType(2)
							.selectAccountingString(2)
							.clickComplete()
							.Pagefactory()
							.clickSubmit()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Agreement Add was successful");
		Expected = AgreementName.toUpperCase() + "/ " + Enumerations.AgreementType.SPECIAL_SERVICES.getName() + "/ " + RandNum7 + "/ " + "1";
		Actual = Source		.DataTable()
							.clickPopupOk()
							.DataTable()
							.readFirstResultNameType();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Fund Source Add was successful");
		Expected = "FREEPORT TOWN SQUARE, DAILY LIVING SUPPORT";
		Actual = Source		.DataTable()
							.setSearch(AgreementName)
							.clickFirstRow()
							.clickEdit()
							.DataTable()
							.readFirstResultNameType();
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=3)
	public void TC_Agreement_Edit_001() {
		SoftAssert = new SoftAssert();
		
		int RandNum3 = SeleniumHelper.generateRandomNumber(3);
		int RandNum7 = SeleniumHelper.generateRandomNumber(7);
		String AgencyName = "Test" + RandNum3;
		String AgreementName = "Selenium Agreement Edit" + RandNum3;
		
		try{
		SeleniumHelper.log.info("Editing Agreement with Service Type and verifying success title");
		Expected =Success;
		Actual = Source		.DataTable()
							.clickFirstRow()
							.clickEdit()
							.AgreementPage()
							.setEndDate(FutureDate30, Clear)
							.setAgreementName(AgreementName, Clear)
							.setAgreementContractNum(RandNum7, Clear)
							.setOrgName("ABC BEHAVE", Clear)
							.setAgreementManager("HARD", Clear)
							.selectOrgFederallBillingId(1)
							.setOrgContactEmailAdress(Email , Clear)
							.setDescription("Selenium Test Edit" + RandNum7, Clear)
							.DataTable()
							.clickAdd()
							.FundSourceAccord()
							.setEndDate(FutureDate30)
							.selectServiceType(4)	
							.setAmount(RandMoneyAmount)
							.selectProgramArea(6)
							.setFiscalYear("2017")
							.selectFundingType(2)
							.setAgency(AgencyName)
							.selectAppropriationUnit(10)
							.setObject(RandNum7)
							.selectReportingOrganization(2)
							.selectActivity(2)
							.selectSettlementType(1)
							.selectAccountingString(1)
							.clickComplete()
							.DataTable()
							.clickAdd()
							.FundSourceAccord()
							.setStartDate(Today, Clear)
							.setEndDate(FutureDate7)
							.selectServiceType(7)	
							.setAmount(RandMoneyAmount)
							.selectProgramArea(9)
							.setFiscalYear("2018")
							.selectFundingType(3)
							.setAgency(AgencyName)
							.selectAppropriationUnit(17)
							.setObject(RandNum7)
							.selectReportingOrganization(4)
							.selectActivity(4)
							.selectSettlementType(2)
							.selectAccountingString(2)
							.clickComplete()
							.Pagefactory()
							.clickSubmit()
							.readPopUpTitle();		
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Agreement Edit was successful");
		Expected = AgreementName.toUpperCase() + "/ " + "/ " + RandNum7 + "/ " + "82585";
		Actual = Source		.DataTable()
							.clickPopupOk()
							.DataTable()
							.readFirstResultNameType();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Fund Source Edit #1 was successful");
		Expected = "FREEPORT TOWN SQUARE, COMMUNITY REHABILITATION SERVICES SECTION 17 OAMHS";
		Actual = Source		.DataTable()
							.clickFirstRow()
							.clickEdit()
							.DataTable()
							.setSearch("FREEPORT TOWN SQUARE")
							.readFirstResultNameType();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Fund Source Edit #2 was successful");
		Expected = "ELDER AND ADULT SERVICES, MEDICATION SERVICES";
		Actual = Source		.DataTable()
							.setSearch("ELDER AND ADULT SERVICES", Clear)
							.readFirstResultNameType();
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=4)
	public void TC_Agreement_View_001() {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Viewing Agreement and verifying fields cannot be edited");
		Expected = True;
		Actual = Source		.DataTable()
							.clickFirstRow()
							.clickView()
							.SeleniumHelper()
							.readAttribute(Source.AgreementPage().EndDateSelectBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source		.SeleniumHelper()
							.readAttribute(Source.AgreementPage().AgreementNameTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source		.SeleniumHelper()
							.readAttribute(Source.AgreementPage().DescriptionTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source		.SeleniumHelper()
							.readAttribute(Source.AgreementPage().OrganizationContactEmailAddressTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Source.AgreementPage().clickBackToAgreements();

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=5)
	public void TC_Agreement_View_002() {
		SoftAssert = new SoftAssert();

		String AgencyName = "Test" + RandNum4;

		try{

			SeleniumHelper.log.info("Adding a Fund Source to an existing Agreement and verifying view functionality in Fund Source Accord");
			Expected = True;
			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickEdit()
								.DataTable()
								.clickAdd()
								.FundSourceAccord()
								.setStartDate(Today, Clear)
								.setEndDate(FutureDate7)
								.selectServiceType(6)	
								.setAmount(RandMoneyAmount)
								.selectProgramArea(9)
								.setFiscalYear("2018")
								.selectFundingType(3)
								.setAgency(AgencyName)
								.selectAppropriationUnit(17)
								.setObject(RandNum7)
								.selectReportingOrganization(4)
								.selectActivity(4)
								.selectSettlementType(2)
								.selectAccountingString(2)
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickFirstRow()
								.clickView()
								.DataTable()
								.clickFirstRow()
								.clickView()
								.FundSourceAccord()
								.EndDateTextBox.getAttribute("disabled");			
			SoftAssert.assertEquals(Actual, Expected);

			Expected = True;
			Actual = Source		.FundSourceAccord()
								.AgencyTextBox.getAttribute("disabled");
			SoftAssert.assertEquals(Actual, Expected);

			Expected = True;
			Actual = Source		.FundSourceAccord()
								.SettlementTypeDropDown.getAttribute("disabled");
			SoftAssert.assertEquals(Actual, Expected);		

			Expected = True;
			Actual = Source		.FundSourceAccord()
								.ActivityDropDown.getAttribute("disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			Source.AgreementPage().BackToAgreementsBtn.click();
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
}