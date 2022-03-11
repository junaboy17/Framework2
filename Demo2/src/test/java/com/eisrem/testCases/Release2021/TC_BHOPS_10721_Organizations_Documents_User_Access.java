package com.eisrem.testCases.Release2021;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_10721_Organizations_Documents_User_Access extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_Organizations_Documents_User_Access() {
		
		SoftAssert = new SoftAssert();
		String UserName = "OIT" + SeleniumHelper.generateRandomAlpha(10);

		try{
				SeleniumHelper.log.info("Creating new Org to work with");
				String newOrgId = Source.OrganizationPage().addCompleteOrganizationPageSubmitAndReturnId(OrganizationPrefix + SeleniumHelper.generateRandomNumber(8), OrganizationType.OTHER, Today, null, true, Description);
			
				//We will add a new user to work with and capture the user id and the name
				SeleniumHelper.log.info("Creating new user to work with");
				String newUserId = Source.UserStaffPage().addCompleteUserAndReturnId(OrganizationPrefix, "TOM", "HANKS", Email, PhoneNumber, T,
						null, null, Today, null, T, Today, null, UserName, UserPassword, UserPassword, Description);
				
				String newUserId2 = Source.UserStaffPage().addCompleteUserAndReturnId(OrganizationPrefix, FirstName, LastName, Email, PhoneNumber, T,
						null, null, Today, null, T, Today, null, UserName + 1, UserPassword, UserPassword, Description);
				//Added creation of second user due to line 179-182.  Unable to find the user (Full Name - Chris Bacon). Please review.  
				
				//Cannot add documents in development
				if(!Source.SeleniumHelper().isDev())
				{
					SeleniumHelper.log.info("Add Document");
					Expected = Success;
					Actual = Source   	.NavigationMenuBar()
										.clickOrganization()
										.setSearch(OrganizationPrefix)
										.clickFirstRow()
										.clickAnchor()
										.OrganizationNavigator()
										.clickDocuments()
										.clickAdd()
										.DocumentsPage()
										.setTitle(DocumentName)
										.setDocumentFile(DocumentPath, DocumentFile)
										.clickAdd()
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
										.clickOrganization()
										.setSearch(OrganizationPrefix)
										.clickFirstRow()
										.clickAnchor()
										.OrganizationNavigator()
										.clickDocuments()
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentIdDevOrg : DocumentName)
										.clickFirstRow()
										.clickEdit()
										.DocumentsPage()
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentUserDevOrg : SecondUserName)
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
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentIdDevOrg : DocumentName)
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
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentUserDevOrg : SecondUserName)
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
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentUserDevOrg : SecondUserName)
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
				
				SeleniumHelper.log.info("Confirm Document Label");
				Expected = "PDF Document";					
				Actual = Source.DocumentsPage().readDocumentLabel();				
				SoftAssert.assertEquals(Actual, Expected);
				Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
				
				SeleniumHelper.log.info("Continue test with edit - add new user with required fields empty and get error");
				data = Source			.DataTable()
										.clickAdd()
										.DocumentsUserPage()
										.setStartDate(EmptyString, Clear)
										.clickComplete()
										.SeleniumHelper()
										.continueIfErrors()
										.GetSource()
										.DocumentsUserPage()
										.setStartDate(Today, Clear)
										.setUser(FullName)
										.clickComplete()
										.DocumentsPage()
										.setSearch(FullName)
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
				
				SeleniumHelper.log.info("Check New Users End Date is Empty");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.END_DATE) != null && data.get(DataTableHeaders.END_DATE).equals(EmptyString);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Check New Users Name/Type Date contains name");
				ExpectedB = T;		
				ActualB = data.get(DataTableHeaders.NAME_TYPE) != null && data.get(DataTableHeaders.NAME_TYPE).contains(FullName);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ActualB);
				
				SeleniumHelper.log.info("Check New Users Id has no value");
				ExpectedB = T;					
				ActualB = data.get(DataTableHeaders.ID) != null && data.get(DataTableHeaders.ID).replaceAll("[^\\d.]", EmptyString).equals(EmptyString);				
				SoftAssert.assertEquals(ActualB, ExpectedB);
				Source.SeleniumHelper().printResultIfFailed(ActualB, ExpectedB);
				
				SeleniumHelper.log.info("Continue test saving edit - confirming modified date on document");
				data = Source			.DocumentsPage()
										.clickSubmit()
										.clickPopupOk()
										.DataTable()
										.setSearch(Source.SeleniumHelper().isDev() ? DocumentIdDevOrg : DocumentName)
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
				
				Source.DocumentsPage().endDateOrganizationDocument(OrganizationPrefix, DocumentName);
				Source.UserStaffPage().endDateUserAndSubmit(OrganizationPrefix, newUserId, T);
				Source.OrganizationPage().endDateOrganization(newOrgId);

				SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}
	
	

