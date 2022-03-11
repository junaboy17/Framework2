package com.eisrem.testCases.Module_Organization;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;




public class TC_Organization_LocDropdown_BaseLoc_First extends PeoplePage {

	@Test(priority=1)
	
	public  void AssessmentTypeList_BaseLocation_Verify() {
		
		SoftAssert = new SoftAssert();
		String title = "Selenium Test #" + SeleniumHelper.generateRandomNumber(4);
		String reType = "CRCF BHPC Consult Form/ Notes";
		
		try {
			SeleniumHelper.log.info("Starting reportable event and verifying org dropdown has Base locations at the top of the list.");
									
				Source	
						// Anchor on a client
						.PeoplePage()
						.AddPeople()
						// conduct a reportable event
						.GetSource()
						.NavigationMenuBar()
						.clickNotes()
						.clickAdd()
						.NotesPage()
						.selectNotesType(reType)
						.setTitle(title)
						.GetSource()
						.NotesPage()
						.clickStartNotes()
						.setComboBox("Referent Agency Name:", "AROOSTOOK")
						.checkIfBaseLocsFirst("Referent Agency Name:")
						.GetSource()
						.NavigationMenuBar()
						.clickAgreement()
						.clickDiscard();
				
				SeleniumHelper.log.info("Adding an agreement and verifying org dropdown has Base locations at the top of the list.");			
						// Add Agreement
				Source						
						.AgreementNavigator()
						.clickAdd()
						.AgreementPage()
						.setAgreementName(title)
						.setOrgNameAgreements("AROOSTOOK", 1)
						.checkIfBaseLocsFirst()
						.clickBackToAgreements()
						.clickDiscard();
				
				SoftAssert.assertAll();	
				
}catch(Exception e) {
	Source	.SeleniumHelper()		
			.assertFail();
}
}
	
@Test(priority=2)
	
	public  void AddUser_OrgLocList_BaseLocation_Verify() {
		
		SoftAssert = new SoftAssert();
		
		try {	
				SeleniumHelper.log.info("Adding user and verifying org dropdown has Base locations at the top of the list.");
				Source
						//Add User
						.NavigationMenuBar()
						.clickOrganization()
						.setSearch(OrgDHHS)
						.clickFirstRow()
						.clickAnchor()
						.OrganizationNavigator()
						.clickUsersStaff()
						.clickAdd()
						.UserStaffPage()
						.setFirstName(UserFirstName)
						.setLastName(UserLastName)
						.toggleStaffActive(F)
						.clickUserInfoAccord()
						.setUserName(UserName)
						.setPassword(UserPassword)
						.setPasswordConfirmation(UserPassword)
						// Add a base location
						.GetSource()
						.UserHomeOfficeAccord()
						.clickAdd()
						.UserHomeOfficeAccord()
						.setUserBaseLocation("Central")
						.checkIfBaseLocsFirst()
						.clickComplete()
						.UserInfoAccord()
						// Add an additional location
						.clickAdditionalOrgLocationAccord()
						.clickAdditionalOrgLocAdd()
						.setAdditionalOrgLocOrganizaiton(OrgDHHS)
						.checkIfBaseLocsFirst()
						.clickCancel()
						.AdditionalOrgLocAccord()
						.clickBackTo()
						.UserStaffPage()
						.clickDiscard()							
						;
						
				SoftAssert.assertAll();	
						
		}catch(Exception e) {
			Source	.SeleniumHelper()		
					.assertFail();
		}
	}
}