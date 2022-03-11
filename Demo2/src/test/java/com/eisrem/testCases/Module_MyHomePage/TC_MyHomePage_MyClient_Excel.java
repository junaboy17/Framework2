package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_MyHomePage_MyClient_Excel extends PeoplePage{

	@Test(priority=1)
	public void TC_MyHomePage_MyClient_Excel_001() {
		SoftAssert = new SoftAssert();

		try{			
			SeleniumHelper.log.info("Verifying My Clients was added successfully");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickAdd()
								.DemographicsPage()
								.fillRequiredDemogrphics(FirstName, LastName, Gender.MALE, DateOfBirth)
								.setStartDate(PastDate30, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			
			String IDNum = Source		.Pagefactory()
										.clickPopupOk()
										.PeopleNavigator()
										.clickPeopleTab()
										.readFirstResultID().replace("Select", "");
			
			SeleniumHelper.log.info("Verifying My Clients was added successfully");
			Expected = Success;
			Actual = Source		.DataTable()
								.clickSecondRow()
								.clickEdit()
								.DemographicsPage()
								.clickIdentifiersAccord()
								.clickIdentifiersAdd()
								.selectIdentifiersType(1)
								.setIdentifiersIdNumber(MedicaidIdentifierNumber)
								.clickComplete()
								.Pagefactory()
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying My Clients was added successfully");
			Expected = Success;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickMyHomePage()
								.RemoveAllSelectedClientsAndSave()
								.GetSource()
								.NavigationMenuBar()
								.clickPeople()
								.clickAdd()
								.DemographicsPage()
								.fillRequiredDemogrphics()
								.setStartDate(PastDate7, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying My Clients was added successfully");
			Expected = Success;
			String IDNum2 = Source		.Pagefactory()
										.clickPopupOk()
										.PeopleNavigator()
										.clickPeopleTab()
										.readFirstResultID().replace("Select", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying My Clients was added successfully");
			Expected = Success;
			Actual = Source		.NavigationMenuBar()
								.clickMyHomePage()
								.clickMyClientsManage()
								.setAvailableFilter(IDNum, Clear)
								.selectAvailableClient(1)
								.clickAdd()
								.setAvailableFilter(IDNum2, Clear)
								.selectAvailableClient(1)
								.clickAdd()
								.clickSaveMyClients()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying My Clients was added successfully");
			Expected = Success;
//			String HeaderData = Source.SeleniumHelper().readElement(Source.MyHomePage().MyClientsAllHeader);
//			List <String> data = Source.SeleniumHelper().getTextFromWebElements(Source.MyHomePage().MyClientsAllData);
			
//			Actual = 
			Source				.Pagefactory()
								.clickGoBackToList()		
								.MyHomePage()
								.GetSource()
								.SeleniumHelper()
								.cleanDownloadDirectory();
								
			String HeaderData = Source.SeleniumHelper().readElement(Source.MyHomePage().MyClientsAllHeader);				
			Source				.MyHomePage()
								.clickMyClientsExcel()
								.GetSource()
								.SeleniumHelper()
								.verifyExcelHeader(HeaderData, "download/MyClients_export.xlsx", "Data" , 4);
			SoftAssert.assertEquals(Actual, Expected);
		
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}
