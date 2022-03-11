package com.eisrem.testCases.Module_ConductedTypes;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v85.console.model.ConsoleMessage.Source;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;



public class TC_Conducted_Type_Org_Loc_Dropdown extends OrganizationPage {

	@Test(priority=1)
	
	public void NewUser_Add_BaseLoc_AddtnLoc_Add() {
		
		SoftAssert = new SoftAssert();
		String userLastName = "TestUser" + SeleniumHelper.generateRandomAlpha(4);
		String userTitle = "EHHHH";
		String userName = "OITUSER" + System.currentTimeMillis();
		
		String baseLoc = "1";		// "1 DHHS/ STATE OF MAINE % 1 CENTRAL OFFICE/ BASE";
		String addtnLocOrg = "DHHS/ STATE OF MAINE";
		String addtnLoc1 = "AROOSTOOK RESIDENTIAL CENTER/ OTHER_LOCATION";
		
		try {
			SeleniumHelper.log.info("Creating a new user.");
									
					Source	
							// Anchor on DHHS org.
							.DataTable()
							.setSearch(OrgDHHS)
							.clickFirstRow()
							.clickAnchor()
							
							// Add user
							.OrganizationNavigator()
							.clickUsersStaff()
							.clickAdd()
							.UserStaffPage()
							.setFirstName("My")
							.setLastName(userLastName)
							.setTelephone(UserPhoneNumber)
							.setTitle(userTitle)
							.setEmploymentDate("12/12/2019")
							.setTerminationDate("12/12/2025")							
							.clickUserInfoAccord()
							.setStartDate("12/12/2019", "y")
							.GetSource()
							.UserInfoAccord()
							.clickUserActiveToggle(True)
							.setUserName(userName)
							.setPassword(TestPassword)
							.setPasswordConfirmation(TestPassword)
							
							// add user base location
							.GetSource()
							.UserHomeOfficeAccord()
							.clickUserHomeOfficeAdd()
							.setUserBaseLocation(baseLoc)
							.clickComplete()
							
							// add user additional location
							.UserInfoAccord()
							.clickAdditionalOrgLocationAccord()
							.clickAdditionalOrgLocAdd()
							.setAdditionalOrgLocOrganizaiton(addtnLocOrg)
							.chooseAdditionalOrgLocLocations(addtnLoc1)
							.clickComplete()
							.DataTable()
							.clickSubmit()
							.clickPopupOk()
							;
							
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2)
	public void User_Edit_AddtnLoc_Add() {
		
		SoftAssert = new SoftAssert();
		String userTitle = "EHHHH";
		String addtnLocOrg = "DHHS/ STATE OF MAINE";
//		String addtnLoc2 = "REGION 2 LEWISTON/ OTHER_LOCATION";
		try {
			SeleniumHelper.log.info("Adding another additional location to the user");
									
					Source	
							// Anchor on DHHS org.
							.DataTable()
							.setSearch(OrgDHHS)
							.clickFirstRow()
							.clickAnchor()
							.OrganizationNavigator()
							.clickUsersStaff()
							.setSearch(userTitle)
							.clickFirstRow()
							.clickEdit()
							.UserStaffPage()
							.clickUserInfoAccord()
							.clickAdditionalOrgLocationAccord()
							.clickAdditionalOrgLocAdd()
							.setAdditionalOrgLocOrganizaiton(addtnLocOrg)
							.chooseFirstAdditionalOrgLocLocations()
							.clickComplete()
							.DataTable()
							.clickSubmit()
							.clickPopupOk();				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
}

	@Test(priority=3)
	public void ConductType_AddEdit() {
	
	SoftAssert = new SoftAssert();

	String reType = "CRCF BHPC Consult Form/ Notes";
	String title = "Conducted Type "  + SeleniumHelper.generateRandomNumber(4);
	String description = "Description from Selenium test";
	String phoneLabel ="Referent Phone";
	String emailLabel ="Referent Email";
	String agencyName = "1 DHHS/ STATE OF MAINE % 92705 OFFICE OF SUBSTANCE ABUSE AND MENTAL HEALTH SERVICES (SAMHS)/ OTHER_LOCATION";
	By txbAgencyName = By.xpath("//fieldset/div[2]/div/div/input");
	
	try {
		SeleniumHelper.log.info("Conducting a Reportable Event");
								
				Source	
						// Anchor on a client
						.NavigationMenuBar()
						.clickPeople()
						.AddPeople()
						.GetSource()

						// Start Notes
						.NavigationMenuBar()
						.clickNotes()
						.clickAdd()
						.NotesPage()
						.selectNotesType(reType)
						.setTitle(title)
						.setDescription(description)
						.GetSource()
						.NotesPage()
						.clickStartNotes()

						// Fill the rest of the form
						.fillForm()
						.setText(2, phoneLabel, "", "Y")	// clear phone input as fillForm() function puts 'SELENIUM ...' which causes error
						.setText(2,emailLabel,"", "Y")		// same for email
						.clickSubmitAllPages()
						.clickGoBackToList()
						
						//Modify Conducted Type by selecting another Org/Location from Agency Name combobox
						.DataTable()
						.setSearch(title)
						.clickFirstRow()
						.clickEdit()
						.SeleniumHelper()
						.setText(txbAgencyName, OrgDHHS, "y")
						.clickElement(By.linkText(agencyName))
						.GetSource()
						.FormPage()
						.clickSubmitAllPages()
						.clickGoBackToList()
						;
				
				
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
}

	@Test(priority=4)
	
	public void Client_Association_Add() {
	
	SoftAssert = new SoftAssert();

	String orgName1 = "1 DHHS/ STATE OF MAINE % 1000000544 OCFS-CBH/ OTHER_LOCATION";
	String orgName2 = "1 DHHS/ STATE OF MAINE % 92705 OFFICE OF SUBSTANCE ABUSE AND MENTAL HEALTH SERVICES (SAMHS)/ OTHER_LOCATION";

	try {
		SeleniumHelper.log.info("Adding org associations to a client");
								
				Source	
						// Anchor on a client
						.NavigationMenuBar()
						.clickPeople()
						.AddPeople()
						.GetSource()
						// add association
						.PeopleNavigator()
						.clickAssociationsTab()
						.clickAdd()
						.AssociationsPage()
						.selectAssociationType(2)
						.setOrganizationAssociation(OrgDHHS, orgName1)
						.clickSubmit()
						// add  another org association 
						.clickPopupOk()
						.DataTable()
						.clickAdd()
						.AssociationsPage()
						.selectAssociationType(2)
						.setOrganizationAssociation(OrgDHHS,orgName2)
						.clickSubmit()
						.clickPopupOk()
						;
				
	

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

@Test(priority=5)

public void Agreement_AddEdit() {
	
	SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Adding Agreement");
									
					Source	
							// Add Agreement
							.NavigationMenuBar()
							.clickAgreement()
							.DataTable()
							.clickAdd()
							.AgreementPage()
							.setAgreementName("Selenium Test")
							.setOrgNameAgreements(OrgDHHS, 5)
							.clickSubmit()
							.clickPopupOk()
							.DataTable()
							.clickFirstRow()
							.clickEdit()
							.AgreementPage()
							.setOrgNameAgreements("ADAM", 1)
							.clickSubmit()
							.clickPopupOk()
							;
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

	@Test(priority=6)		/*NON-ADMIN TEST CASE*/			
	public void NonAdmin_ConductType_Agreement_AddEdit() {
	
	SoftAssert = new SoftAssert();
	String reType = "CRCF BHPC Consult Form/ Notes";
	String title = "Conducted Type "  + SeleniumHelper.generateRandomNumber(4);
	String description = "Description from Selenium test";
	String phoneLabel ="Referent Phone";
	String emailLabel ="Referent Email";
	String agencyName1 = "1 DHHS/ STATE OF MAINE % 1000000544 OCFS-CBH/ OTHER_LOCATION";
	String agencyName2 = "1 DHHS/ STATE OF MAINE % 92705 OFFICE OF SUBSTANCE ABUSE AND MENTAL HEALTH SERVICES (SAMHS)/ OTHER_LOCATION";
	By txbAgencyName = By.xpath("//fieldset/div[2]/div/div/input");
	
		try {
			SeleniumHelper.log.info("Logging in as non-admin user, conducting type, adding agreement");
									
					Source
					.LogInPage()
					.LogOut()
					.LogIn(userName2, userPassword2)
					.GetSource()
					.NavigationMenuBar()
					.clickPeople()
					.DataTable()
					.setSearch(TestClient2)
					.clickFirstRow()
					.clickAnchor()
					.NavigationMenuBar()
					.clickNotes()
					.clickAdd()
					.NotesPage()
					.selectNotesType(reType)
					.setTitle(title)
					.setDescription(description)
					.GetSource()
					.NotesPage()
					.clickStartNotes()

					// Fill the rest of the form
					.fillForm()	
					.setText(2, phoneLabel, "", "Y")	// clear phone input as fillForm() function puts 'SELENIUM ...' which causes error
					.setText(2, emailLabel, "", "Y")		// same for email
					
					.GetSource()
					.SeleniumHelper()
					.setText(txbAgencyName, OrgDHHS, "y")
					.clickElement(By.linkText(agencyName1))
					.GetSource()
					.FormPage()
					.clickSubmitAllPages()
					.clickGoBackToList()
					
					//Modify Conducted Type by selecting another Org/Location from Agency Name combobox
					.DataTable()
					.setSearch(title)
					.clickFirstRow()
					.clickEdit()
					.SeleniumHelper()
					.setText(txbAgencyName, OrgDHHS, "y")
					.clickElement(By.linkText(agencyName2))
					.GetSource()
					.FormPage()
					.clickSubmitAllPages()
					.clickGoBackToList()
					
					// Add Agreement
					.NavigationMenuBar()
					.clickAgreement()
					.DataTable()
					.clickAdd()
					.AgreementPage()
					.setAgreementName("Selenium Test")
					.setOrgNameAgreements(OrgDHHS, 3)
					.clickSubmit()
					.clickPopupOk()
					.DataTable()
					.clickFirstRow()
					.clickEdit()
					.AgreementPage()
					.setOrgNameAgreements("ANGLEZ", 1)
					.clickSubmit()
					.clickPopupOk()
					;
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}		// End of non-admin test 
}


