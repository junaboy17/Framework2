package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;
import com.eisrem.Hooks.PeoplePage;

public class TC_MyClients_Medicaid_Check extends PeoplePage{

	@Test(priority=1)
	public void TC_MyClients_Medicaid_Check_001() {
		SoftAssert = new SoftAssert();
		
		String MedicaidIdentifierNumber1 = SeleniumHelper.generateRandomMedicaidIdentifier();
		String MedicaidIdentifierNumber2 = SeleniumHelper.generateRandomMedicaidIdentifier();

		try{
		SeleniumHelper.log.info("Adding a person and verifying Success message");
		Expected = Success;
		Actual = Source		.DataTable()
							.clickAdd()
							.DemographicsPage()
							.setStartDate(PastDate30, Clear)
							.GetSource()
							.DemographicsPage()
							.fillRequiredDemogrphics()
							.clickSubmit()
							.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = Success;
		String IDNum = Source	.Pagefactory()
								.clickPopupOk()
								.PeopleNavigator()
								.clickPeopleTab()
								.DataTable()
								.readFirstResultID().replace("Select", "");
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Adding Identifier to newly created People");
		Expected = Success;
		Actual = Source			.NavigationMenuBar()
								.clickMyHomePage()
								.clickMyClientsManage()
								.setAvailableFilter(IDNum)
								.selectAvailableClient(1)
								.clickAdd()
								.clickSaveMyClients()
								.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected = Success;
		Actual = Source			.Pagefactory()
								.clickGoBackToList()
								.NavigationMenuBar()
								.clickPeople()
								.setSearch(IDNum)
								.clickFirstRow()
								.clickEdit()
								.PeopleNavigator()
								.clickIdentifierTab()
								.clickAdd()
								.IdentifiersPage()
								.setStartDate(PastDate5, Clear)
								.GetSource()
								.IdentifiersPage()
								.selectIdentifiersType(1)
								.setIdentifiersIdNumber(MedicaidIdentifierNumber1)
								.clickSubmit()
								.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Identifier was added successfully");
		Expected = MedicaidIdentifierNumber1 + "/ MEDICAID";
		Actual = Source			.Pagefactory()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickMyHomePage()
								.readDataTable("Clients", 1, 5);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Editing existing Identifier, adding new Identifier and verifying Success");
		Expected = Success;
		Actual = Source			.NavigationMenuBar()
								.clickPeople()
								.setSearch(IDNum)
								.clickFirstRow()
								.clickEdit()
								.PeopleNavigator()
								.clickIdentifierTab()
								.clickFirstRow()
								.clickEdit()
								.Pagefactory()
								.setEndDate(PastDate4)
								.GetSource()
								.IdentifiersPage()
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.clickAdd()
								.IdentifiersPage()
								.selectIdentifiersType(1)
								.setIdentifiersIdNumber(MedicaidIdentifierNumber2)
								.setStartDate(PastDate3, Clear)
								.clickSubmit()
								.readPopUpTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying new Identifier was added successfully");
		Expected = MedicaidIdentifierNumber2 + "/ MEDICAID";
		Actual = Source			.Pagefactory()
								.clickPopupOk()
								.NavigationMenuBar()
								.clickMyHomePage()
								.readDataTable("Clients", 1, 5);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Removing added Client from My Homepage");
		Source			.MyHomePage()
						.removeClient(IDNum);
		
		SoftAssert.assertAll();
		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
}
