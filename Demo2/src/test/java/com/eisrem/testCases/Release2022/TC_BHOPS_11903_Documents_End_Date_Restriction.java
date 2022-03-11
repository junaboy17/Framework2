package com.eisrem.testCases.Release2022;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11903_Documents_End_Date_Restriction extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_People_Documents_User_Access() {
		
		SoftAssert = new SoftAssert();
		
		SeleniumHelper.log.info("Creating new user to work with");
		String userName = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		String userPassword = "Spring12#";
		String newPassword = "Winter12#";
		String baseLoc = "CENTRAL";		// "1 DHHS/ STATE OF MAINE % 1 CENTRAL OFFICE/ BASE";
		String servPopl = "ADULT MH";
		String roleCS = "CS STATE ROLE";
		
		try{
				
				//Cannot add documents in development
				if(!Source.SeleniumHelper().isDev())
				{
					SeleniumHelper.log.info("Creating test user");
					// create a test user to add a document on
					Source	
						.UserStaffPage()
						.addCompleteUserAndRemainOnUserPage(OrgDHHS, null, null, null, null, T, null, null, null
													, null, T, null, null, userName, userPassword, userPassword, null);
						// add Base Location
					String userId = Source
										.UserHomeOfficeAccord()
										.clickUserHomeOfficeAdd()
										.setUserBaseLocation(baseLoc)
										.clickComplete()
						// add Service Population
										.UserInfoAccord()
										.clickServicePopulationAvailableAccord()
										.clickSpAdd()
										.selectServicePopulation(servPopl)
										.clickSpComplete()
						// add Role
										.UserInfoAccord()
										.clickRolesAvaiableAccord()
										.clickRolesAdd()
										.selectRole(roleCS)
										.clickRolesComplete()
										.UserStaffPage()
										.clickSubmit()
										.clickPopupOk()
										.DataTable()
										.readFirstResultID();
					
					//Add Document and grant access to new user
					SeleniumHelper.log.info("Adding Document and granting access to new user");
					String UserToAddDocumentOn = Source   	
										.NavigationMenuBar()
										.clickPeople()
										.AddPeople()
										.clickPeopleTab()
										.DataTable()
										.readFirstResultID();
					
					Expected = Source	.DataTable()
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
										.setUser(userId)
										.clickComplete()
										.DocumentsPage()
										.clickSubmit()
										.clickPopupOk()
										.DataTable()
										.readFirstResultID();
					
					SeleniumHelper.log.info("Log in as new user and check access");
					// Log out
					Source
									.LogInPage().LogOut();
				
					// Log in as the new user and change password
					Source
										.LogInPage()
										.LogIn(userName, userPassword)
										.GetSource()
										.ChangePasswordPage()
										.setCurrentPassword(userPassword)
										.setNewPassword(newPassword)
										.setConfirmPassword(newPassword)
										.clickSubmit();
					// Log back in and confirm the user has access to the document
					Actual = Source
										.LogInPage()
										.LogIn(userName, newPassword)
										.GetSource()
										.NavigationMenuBar()
										.clickPeople()
										.setSearch(UserToAddDocumentOn)
										.clickFirstRow()
										.clickAnchor()
										.PeopleNavigator()
										.clickDocumentsTab()
										.readFirstResultID();
					
					SoftAssert.assertEquals(Actual, Expected);
					
					Source
					.LogInPage().LogOut();
					
					Source.LogInPage().LogInSeleniumUser()
										.GetSource()
										.NavigationMenuBar()
										.clickPeople()
										.setSearch(UserToAddDocumentOn)
										.clickFirstRow()
										.clickAnchor()
										.PeopleNavigator()
										.clickDocumentsTab()
										.clickFirstRow()
										.clickEdit()
										.DocumentsPage()
										.setSearch("MASHED")
										.clickFirstRow()
										.clickEdit()
										.DocumentsUserPage()
										.setEndDate(Today)
										.clickComplete()
										.DocumentsPage()
										.clickSubmit()
										.clickPopupOk();
					
					SeleniumHelper.log.info("Log in as new user and check access");
					// Log out
					Source
										.LogInPage().LogOut();
				
					// Log back in and confirm the user does not have access to the document
					Actual = Source
										.LogInPage()
										.LogIn(userName, newPassword)
										.GetSource()
										.NavigationMenuBar()
										.clickPeople()
										.setSearch(UserToAddDocumentOn)
										.clickFirstRow()
										.clickAnchor()
										.PeopleNavigator()
										.clickDocumentsTab()
										.readFirstResultID();
					
					SoftAssert.assertNotEquals(Actual, Expected);
					
					Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
				}

				SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}