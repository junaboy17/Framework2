package com.eisrem.testCases.Business.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.BusinessUserLogIn;
import com.eisrem.pageFactory.Administrator.RolesPage;

public class Admin_Administrator_Messages extends AdministratorPage {

	@Test(priority=1)
	public void Add_Warning_Message() {
		
		SoftAssert = new SoftAssert();

		String WarningMessage = "EIS is under constructions at this time." + SeleniumHelper.generateRandomNumber(3);

		try{
			SeleniumHelper.log.info("Adding a Warning message and verifying Warning message displays successfully on the Login Page");
			Expected =	WarningMessage;
			Actual =	Source		.AdministratorNavigator()
									.clickAdministratorMessages()
									.GetSource()
									.AdministratorMessagesPage()
									.AddAdministratorMessageAndRolesAvailableAndSP(1, WarningMessage, False, True, "SYSTEM ADMIN", True, Description, 3, True)
									.GetSource()
									.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.GetSource()
									.SeleniumHelper()
									.goToUrl(Configuration.Url.testPortal)
									.GetSource()
									.LogInPage()
									.readTopWarningMessage2();
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Deactivating Administrator Messages That Was Just Created");
			Expected =	Success;
			Actual =	Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.GetSource()
									.NavigationMenuBar()
									.clickAdministrator()
									.clickAdministratorMessages()
									.setSearch(WarningMessage)
									.clickFirstRow()
									.clickEdit()
									.AdministratorMessagesPage()
									.clickActiveToggle(False)
									.clickSubmit()
									.readPopUpTitle();									
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

	@Test(priority=2)
	public void Edit_Warning_Message() {
		
		SoftAssert = new SoftAssert();

		String WarningMessage = "EIS is under constructions at this time." + SeleniumHelper.generateRandomNumber(3);
		String EditWarningMessage = "EIS upgrades will be completed today." + SeleniumHelper.generateRandomNumber(3);

		try{
			SeleniumHelper.log.info("Adding and editing a Warning message and verifying added/edited Warning message displays successfully on the Login Page");
			Expected =	WarningMessage;
			Actual =	Source		.AdministratorNavigator()
									.clickAdministratorMessages()
									.GetSource()
									.AdministratorMessagesPage()
									.AddAdministratorMessageAndRolesAvailableAndSP(1, WarningMessage, False, True, "SYSTEM ADMIN", True, Description, 3, True)
									.GetSource()
									.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.GetSource()
									.SeleniumHelper()
									.goToUrl(Configuration.Url.testPortal)
									.GetSource()
									.LogInPage()
									.readTopWarningMessage2();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Editing Warning message and verifying Warning message successfully displays on the Login Page");
			Expected =	EditWarningMessage;
			Actual =	Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.GetSource()
									.NavigationMenuBar()
									.clickAdministrator()
									.clickAdministratorMessages()
									.setSearch(WarningMessage)
									.clickFirstRow()
									.clickEdit()
									.AdministratorMessagesPage()
									.setMessages(EditWarningMessage, Clear)
									.clickSubmit()
									.clickPopupOk()
									.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.GetSource()
									.SeleniumHelper()
									.goToUrl(Configuration.Url.testPortal)
									.GetSource()
									.LogInPage()
									.readTopWarningMessage2();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Deactivating Administrator Messages That Was Just Created");
			Expected =	Success;
			Actual =	Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.GetSource()
									.NavigationMenuBar()
									.clickAdministrator()
									.clickAdministratorMessages()
									.setSearch(EditWarningMessage)
									.clickFirstRow()
									.clickEdit()
									.AdministratorMessagesPage()
									.clickActiveToggle(False)
									.clickSubmit()
									.readPopUpTitle();									
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=3)
	public void End_Date_Warning_Message() {
		
		SoftAssert = new SoftAssert();

		String WarningMessage = "EIS upgrades will be completed today." + SeleniumHelper.generateRandomNumber(3);
		
		try{
			SeleniumHelper.log.info("Adding a Warning message, verifying Warning message displays successfully, setting an End Date and then verifying successful removal of Warning Message");
			Expected =	WarningMessage;
			Actual =	Source		.AdministratorNavigator()
									.clickAdministratorMessages()
									.GetSource()
									.AdministratorMessagesPage()
									.AddAdministratorMessageAndRolesAvailableAndSP(1, WarningMessage, False, True, "SYSTEM ADMIN", True, Description, 3, True)
									.GetSource()
									.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.GetSource()
									.SeleniumHelper()
									.goToUrl(Configuration.Url.testPortal)
									.GetSource()
									.LogInPage()
									.readTopWarningMessage2();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Setting an End Date for Warning Message");
			Expected =	Today;
			Actual =	Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.GetSource()
									.NavigationMenuBar()
									.clickAdministrator()
									.clickAdministratorMessages()
									.setSearch(WarningMessage)
									.clickFirstRow()
									.clickEdit()
									.AdministratorMessagesPage()
									.setEndDate(Today)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(WarningMessage)
									.clickFirstRow()
									.clickView()
									.AdministratorMessagesPage()
									.readEndDateValue().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying successful removal of Warning Message on Login Page");
			ExpectedB =	F;
			ActualB =	Source		.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.GetSource()
									.SeleniumHelper()
									.goToUrl(Configuration.Url.testPortal)
									.checkWebElementExists(Source.LogInPage().topWarningMessage2);
			SoftAssert.assertEquals(ActualB, ExpectedB);	
			
			SeleniumHelper.log.info("Deactivating Administrator Messages That Was Just Created");
			Expected =	Success;
			Actual =	Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.GetSource()
									.NavigationMenuBar()
									.clickAdministrator()
									.clickAdministratorMessages()
									.setSearch(WarningMessage)
									.clickFirstRow()
									.clickEdit()
									.AdministratorMessagesPage()
									.clickActiveToggle(False)
									.clickSubmit()
									.readPopUpTitle();									
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=4)
	public void Add_Notification_Message() {
		
		SoftAssert = new SoftAssert();

		String NotificationMessage = "EIS has completed the upgrade." + SeleniumHelper.generateRandomNumber(3);

		try{
			SeleniumHelper.log.info("Adding a Notification message and verifying Notification message displays successfully on the Login Page");
			Expected =	NotificationMessage;
			Actual =	Source		.AdministratorNavigator()
									.clickAdministratorMessages()
									.GetSource()
									.AdministratorMessagesPage()
									.AddAdministratorMessageAndRolesAvailableAndSP(2, NotificationMessage, False, True, "SYSTEM ADMIN", True, Description, 3, True)
									.GetSource()
									.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.GetSource()
									.SeleniumHelper()
									.goToUrl(Configuration.Url.testPortal)
									.GetSource()
									.LogInPage()
									.readTopNotificationMessage1();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Deactivating Administrator Messages That Was Just Created");
			Expected =	Success;
			Actual =	Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.GetSource()
									.NavigationMenuBar()
									.clickAdministrator()
									.clickAdministratorMessages()
									.setSearch(NotificationMessage)
									.clickFirstRow()
									.clickEdit()
									.AdministratorMessagesPage()
									.clickActiveToggle(False)
									.clickSubmit()
									.readPopUpTitle();									
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

	@Test(priority=5)
	public void Edit_Notification_Message() {
		
		SoftAssert = new SoftAssert();

		String NotificationMessage = "EIS has completed the upgrade." + SeleniumHelper.generateRandomNumber(3);
		String EditNotificationMessage = "EIS upgrades were successful" + SeleniumHelper.generateRandomNumber(3);

		try{
			SeleniumHelper.log.info("Adding and editing a Notification message and verifying added/edited Notification message displays successfully on the Login Page");
			Expected =	NotificationMessage;
			Actual =	Source		.AdministratorNavigator()
									.clickAdministratorMessages()
									.GetSource()
									.AdministratorMessagesPage()
									.AddAdministratorMessageAndRolesAvailableAndSP(2, NotificationMessage, False, True, "SYSTEM ADMIN", True, Description, 3, True)
									.GetSource()
									.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.GetSource()
									.SeleniumHelper()
									.goToUrl(Configuration.Url.testPortal)
									.GetSource()
									.LogInPage()
									.readTopNotificationMessage1();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Editing Notification message and verifying Notification message successfully displays on the Login Page");
			Expected =	EditNotificationMessage;
			Actual =	Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.GetSource()
									.NavigationMenuBar()
									.clickAdministrator()
									.clickAdministratorMessages()
									.setSearch(NotificationMessage)
									.clickFirstRow()
									.clickEdit()
									.AdministratorMessagesPage()
									.setMessages(EditNotificationMessage, Clear)
									.clickSubmit()
									.clickPopupOk()
									.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.GetSource()
									.SeleniumHelper()
									.goToUrl(Configuration.Url.testPortal)
									.GetSource()
									.LogInPage()
									.readTopNotificationMessage1();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Deactivating Administrator Messages That Was Just Created");
			Expected =	Success;
			Actual =	Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.GetSource()
									.NavigationMenuBar()
									.clickAdministrator()
									.clickAdministratorMessages()
									.setSearch(EditNotificationMessage)
									.clickFirstRow()
									.clickEdit()
									.AdministratorMessagesPage()
									.clickActiveToggle(False)
									.clickSubmit()
									.readPopUpTitle();									
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=6)
	public void End_Date_Notification_Message() {
		
		SoftAssert = new SoftAssert();

		String NotificationMessage = "EIS upgrades were successful." + SeleniumHelper.generateRandomNumber(3);
		
		try{
			SeleniumHelper.log.info("Adding a Notification message, verifying Notification message displays successfully, setting an End Date and then verifying successful removal of Notification Message");
			Expected =	NotificationMessage;
			Actual =	Source		.AdministratorNavigator()
									.clickAdministratorMessages()
									.GetSource()
									.AdministratorMessagesPage()
									.AddAdministratorMessageAndRolesAvailableAndSP(2, NotificationMessage, False, True, "SYSTEM ADMIN", True, Description, 3, True)
									.GetSource()
									.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.GetSource()
									.SeleniumHelper()
									.goToUrl(Configuration.Url.testPortal)
									.GetSource()
									.LogInPage()
									.readTopNotificationMessage1();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Setting an End Date for Notification Message");
			Expected =	Today;
			Actual =	Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.GetSource()
									.NavigationMenuBar()
									.clickAdministrator()
									.clickAdministratorMessages()
									.setSearch(NotificationMessage)
									.clickFirstRow()
									.clickEdit()
									.AdministratorMessagesPage()
									.setEndDate(Today)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(NotificationMessage)
									.clickFirstRow()
									.clickView()
									.AdministratorMessagesPage()
									.readEndDateValue().replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying successful removal of Notification Message on Login Page");
			ExpectedB =	F;
			ActualB =	Source		.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.GetSource()
									.SeleniumHelper()
									.goToUrl(Configuration.Url.testPortal)
									.checkWebElementExists(Source.LogInPage().topNotificationMessage1);
			SoftAssert.assertEquals(ActualB, ExpectedB);	
			
			SeleniumHelper.log.info("Deactivating Administrator Messages That Was Just Created");
			Expected =	Success;
			Actual =	Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.GetSource()
									.NavigationMenuBar()
									.clickAdministrator()
									.clickAdministratorMessages()
									.setSearch(NotificationMessage)
									.clickFirstRow()
									.clickEdit()
									.AdministratorMessagesPage()
									.clickActiveToggle(False)
									.clickSubmit()
									.readPopUpTitle();									
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=7)
	public void Add_Warning_Internal() {
		
		SoftAssert = new SoftAssert();

		String WarningMessage = "EIS is under constructions at this time." + SeleniumHelper.generateRandomNumber(3);

		try{
			SeleniumHelper.log.info("Adding an Internal Warning Message and verifying Internal Warning Message does not display on the Login Page");
			ExpectedB =	F;
			ActualB =	Source		.AdministratorNavigator()
									.clickAdministratorMessages()
									.GetSource()
									.AdministratorMessagesPage()
									.AddAdministratorMessageAndRolesAvailableAndSP(1, WarningMessage, True, True, "SYSTEM ADMIN", True, Description, 3, True)
									.GetSource()
									.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.GetSource()
									.SeleniumHelper()
									.goToUrl(Configuration.Url.testPortal)
									.checkWebElementExists(Source.LogInPage().topWarningMessage2);
			SoftAssert.assertEquals(ActualB, ExpectedB);	

			SeleniumHelper.log.info("Deactivating Administrator Messages That Was Just Created");
			Expected =	Success;
			Actual =	Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.GetSource()
									.NavigationMenuBar()
									.clickAdministrator()
									.clickAdministratorMessages()
									.setSearch(WarningMessage)
									.clickFirstRow()
									.clickEdit()
									.AdministratorMessagesPage()
									.clickActiveToggle(False)
									.clickSubmit()
									.readPopUpTitle();									
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=8)
	public void Add_Notification_Internal() {
		
		SoftAssert = new SoftAssert();

		String NotificationMessage = "EIS has completed the upgrade." + SeleniumHelper.generateRandomNumber(3);

		try{
			SeleniumHelper.log.info("Adding an Internal Notification and verifying Internal Notification does not display on the Login Page");
			ExpectedB =	F;
			ActualB =	Source		.AdministratorNavigator()
									.clickAdministratorMessages()
									.GetSource()
									.AdministratorMessagesPage()
									.AddAdministratorMessageAndRolesAvailableAndSP(1, NotificationMessage, True, True, "SYSTEM ADMIN", True, Description, 3, True)
									.GetSource()
									.NavigationMenuBar()
									.clickWelcomeUser()
									.clickLogOut()
									.GetSource()
									.SeleniumHelper()
									.goToUrl(Configuration.Url.testPortal)
									.checkWebElementExists(Source.LogInPage().topWarningMessage2);
			SoftAssert.assertEquals(ActualB, ExpectedB);	

			SeleniumHelper.log.info("Deactivating Administrator Messages That Was Just Created");
			Expected =	Success;
			Actual =	Source		.LogInPage()
									.setUserName(Configuration.User.testUser)
									.setPassword(Configuration.Password.testPassword)
									.clickSignIn()
									.GetSource()
									.NavigationMenuBar()
									.clickAdministrator()
									.clickAdministratorMessages()
									.setSearch(NotificationMessage)
									.clickFirstRow()
									.clickEdit()
									.AdministratorMessagesPage()
									.clickActiveToggle(False)
									.clickSubmit()
									.readPopUpTitle();									
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
}