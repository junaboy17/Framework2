package com.eisrem.testCases.Module_QuickLinks;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AgreementPage;
import com.eisrem.Hooks.QuickLinksPage;


public class TC_Links_Service_Pop_Add_Edit_View extends QuickLinksPage{


	@Test(priority=1)
	public void TC_Links_Service_Populations_Add_001() {
		SoftAssert = new SoftAssert();

		String Description = "SELENIUM TEST DESCRIPTION" + SeleniumHelper.generateRandomNumber(4);
		
		try{
		SeleniumHelper.log.info("Adding Quick Links and verifying successful add");
		Expected =Success;
		Actual = Source		.DataTable()
							.clickFirstRow()
							.clickEdit()
							.DataTable()
							.clickAdd()
							.ServicePopulationsAvailableAccord()
							.setDescription(Description, Clear)
							.GetSource()
							.ServicePopulationsAvailableAccord()
							.selectServicePopulation("CHILDRENS")
							.clickComplete()
							.DataTable()
							.readPopUpTitle();																
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Service Population was added successfully");
		Expected = "CHILDRENS";
		Actual = Source		.DataTable()
							.clickPopupOk()
							.DataTable()
							.clickIdSort()
							.clickIdSort()
							.GetSource()
							.ServicePopulationsAvailableAccord()
							.readDataTable("servicePopTable", 1, 2);							
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	}
	
	@Test(priority=2)
	public void TC_Links_Service_Populations_Edit_001() {
		SoftAssert = new SoftAssert();

		String Description = "UPDATED SELENIUM TEST DESCRIPTION" + SeleniumHelper.generateRandomNumber(4);
		
		try{
		SeleniumHelper.log.info("Editing Quick Links and verifying edit was successful");
		Expected =Success;
		Actual = Source		.DataTable()
							.clickFirstRow()
							.clickEdit()
							.DataTable()
							.clickFirstRow()
							.clickEdit()
							.ServicePopulationsAvailableAccord()
							.setEndDate(FutureDate7, Clear)
							.setDescription(Description, Clear)
							.GetSource()
							.ServicePopulationsAvailableAccord()
							.clickComplete()
							.DataTable()
							.readPopUpTitle();																
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Service Population End Date was edited successfully");
		Expected = FutureDate7;
		Actual = Source		.DataTable()
							.clickPopupOk()
							.DataTable()
							.readDataTable("servicePopTable", 1, 4);			
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Service Population Description was edited successfully");
		Expected = Description;
		Actual = Source		.DataTable()
							.clickFirstRow()
							.clickEdit()
							.ServicePopulationsAvailableAccord()				
							.readDescriptionTextBoxValue();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	}
	
	
	@Test(priority=3)
	public void TC_Links_Service_Populations_View_001() {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Verifying Service Populations View function is working properly");
		Expected = True;
		Actual = Source		.DataTable()
							.clickFirstRow()
							.clickView()
							.DataTable()
							.clickFirstRow()
							.clickView()
							.SeleniumHelper()
							.readAttribute(Source.ServicePopulationsAvailableAccord().EndDateTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying text fields cannot be changed");
		Expected = True;
		Actual = Source		.SeleniumHelper()
							.readAttribute(Source.ServicePopulationsAvailableAccord().DescriptionTextBox, "disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = True;
		Actual = Source		.ServicePopulationsAvailableAccord()
							.ActiveToggleAttribute.getAttribute("disabled");
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	}
	
}