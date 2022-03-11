package com.eisrem.testCases.Release2021;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_10721_People_Documents_User_Access extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_People_Documents_User_Access() {
		
		SoftAssert = new SoftAssert();

		try{
				//We will add a new user to work with and capture the user id and the name
				SeleniumHelper.log.info("Creating new user to work with");
				String UserName = "OIT" + SeleniumHelper.generateRandomAlpha(10);
				
				String newUserId = Source.UserStaffPage().addCompleteUserAndReturnId(OrgDHHS, "TOM", "HANKS", Email, PhoneNumber, T,
						null, null, Today, null, T, Today, null, UserName, UserPassword, UserPassword, Description);
				
				SeleniumHelper.log.info("Creating new person to work with if UAT else use Jeannes Person if Dev");
				String peoId = Source.SeleniumHelper().isDev() ? peoId = "333415"  : Source.PeoplePage().addPersonReturnId();
				
				//Cannot add documents in development
				if(!Source.SeleniumHelper().isDev())
				{
					SeleniumHelper.log.info("Add Document");
					Expected = Success;
					Actual = Source   	.NavigationMenuBar()
										.clickPeople()
										.setSearch(peoId)
										.clickFirstRow()
										.clickAnchor()
										.PeopleNavigator()
										.clickDocumentsTab()
										.clickAdd()
										.DocumentsPage()
										.setTitle(DocumentName)
										.setDocumentFile(DocumentPath, DocumentFile)
										.clickAdd()
										.DocumentsUserPage()
										.setStartDate(EmptyString, Clear)
										.clickComplete()
										.SeleniumHelper()
										.continueIfErrors()
										.GetSource()
										.DocumentsUserPage()
										.setStartDate(Today, Clear)
										.setUser(SecondUserName)
										.clickComplete()
										.DocumentsPage()
										.clickSubmit()
										.readPopUpTitle();
					SoftAssert.assertEquals(Actual, Expected);
					Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
					
					Source.DataTable().clickPopupOk();
				}
				
				SeleniumHelper.log.info("Continue test with edit - editing existing user and confirming modified date");
				HashMap<DataTableHeaders, String> data = Source	.NavigationMenuBar()
										.clickPeople()
										.setSearch(peoId)
										.clickFirstRow()
										.clickAnchor()
										.PeopleNavigator()
										.clickDocumentsTab()
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentIdDevPeo : DocumentName)
										.clickFirstRow()
										.clickEdit()
										.DocumentsPage()
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentUserDevPeo : SecondUserName)
										.clickFirstRow()
										.clickEdit()
										.DocumentsUserPage()
										.setEndDate(Today, Clear)
										.clickComplete()
										.DocumentsPage()
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentUserDevPeo : SecondUserName)
										.getDataByRow(OneN, UsersTable);
									
				SeleniumHelper.log.info("Check Edited Users Modified Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.MODIFIED_DATE) != null && data.get(DataTableHeaders.MODIFIED_DATE).equals(Today);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Check Edited Users End Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.END_DATE) != null && data.get(DataTableHeaders.END_DATE).equals(Today);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Check Edited Users End Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.END_DATE) != null && data.get(DataTableHeaders.END_DATE).equals(Today);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Confirm Document Label");
				Expected = "PDF Document";					
				Actual = Source.DocumentsPage().readDocumentLabel();				
				SoftAssert.assertEquals(Actual, Expected);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Continue test with edit -  confirming created user");
				data = Source			.DocumentsPage()
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentUserDevPeo : UserFullName, Clear)
										.getDataByRow(OneN, UsersTable);
									
				SeleniumHelper.log.info("Check Edited Users Modified Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.MODIFIED_DATE) != null && data.get(DataTableHeaders.MODIFIED_DATE).equals(Today);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Continue test with edit - editing existing user and confirming modified date");
				data = Source			.DocumentsPage()
										.clickSubmit()
										.clickPopupOk()
										.DataTable()
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentIdDevPeo : DocumentName)
										.clickFirstRow()
										.getDataByRow(OneN);
				
				SeleniumHelper.log.info("Check Edited Documents Modified Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.MODIFIED_DATE) != null && data.get(DataTableHeaders.MODIFIED_DATE).equals(Today);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
										
				SeleniumHelper.log.info("Continue test with edit - confirm existing user edit saved confirming modified date and end date");
				data = Source			.DataTable()
										.clickEdit()
										.DocumentsPage()
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentUserDevPeo : SecondUserName)
										.clickFirstRow()
										.getDataByRow(OneN, UsersTable);	
				
				SeleniumHelper.log.info("Check Users Modified Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.MODIFIED_DATE) != null && data.get(DataTableHeaders.MODIFIED_DATE).equals(Today);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Check Users End Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.END_DATE) != null && data.get(DataTableHeaders.END_DATE).equals(Today);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Continue test with edit - edit user to have no end date - mostly for reuse with dev user");
				data = Source			.DataTable()
										.clickEdit()
										.DocumentsUserPage()
										.setEndDate(EmptyString, Clear)
										.clickComplete()
										.DocumentsPage()
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentUserDevPeo : SecondUserName)
										.clickFirstRow()
										.getDataByRow(OneN, UsersTable);	
				
				SeleniumHelper.log.info("Check Edited Users Modified Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.MODIFIED_DATE) != null && data.get(DataTableHeaders.MODIFIED_DATE).equals(Today);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Check Edited Users End Date is empty");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.END_DATE) != null && data.get(DataTableHeaders.END_DATE).equals(EmptyString);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);

				SeleniumHelper.log.info("Continue test saving edit - confirming modified date on document");
				data = Source			.DocumentsPage()
										.clickSubmit()
										.clickPopupOk()
										.DataTable()
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentIdDevPeo : DocumentName)
										.clickFirstRow()
										.getDataByRow(OneN);
				
				SeleniumHelper.log.info("Check Edited Documents Modified Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.MODIFIED_DATE) != null && data.get(DataTableHeaders.MODIFIED_DATE).equals(Today);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				

				SeleniumHelper.log.info("Continue test view - confirming user exists and has id and correct data");
				data = Source			.DataTable()
										.clickView()
										.DocumentsPage()
										.setSearch(SecondUserName)
										.clickFirstRow()
										.getDataByRow(OneN, UsersTable);
				
				SeleniumHelper.log.info("Check New Users Start Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.START_DATE) != null && data.get(DataTableHeaders.START_DATE).equals(Today);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Check New Users Modified Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.MODIFIED_DATE) != null && data.get(DataTableHeaders.MODIFIED_DATE).equals(Today);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Check New Users End Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.END_DATE) != null && data.get(DataTableHeaders.END_DATE).equals(EmptyString);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Check New Users Name/Type Date is Equal to Today");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.NAME_TYPE) != null && data.get(DataTableHeaders.NAME_TYPE).contains(SecondUserName);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Check Edited Users Id Date is Equal to not empty");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.ID) != null && !data.get(DataTableHeaders.ID).replaceAll("[^\\d.]", EmptyString).equals(EmptyString);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Continue test view - navigate to user and back");
				Source					.DocumentsPage()
										.clickView()
										.DocumentsUserPage()
										.clickBack()
										.DocumentsPage()
										.clickBackTo();
				
				SeleniumHelper.log.info("End Date data");
				
				if(!Source.SeleniumHelper().isDev())
				{
					Source.DocumentsPage().endDatePeopleDocument(peoId, DocumentName);
					Source.PeoplePage().endDateAndSubmit(peoId);
				}

				Source.UserStaffPage().endDateUserAndSubmit(OrgDHHS, newUserId, T);

				SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}
	
	

