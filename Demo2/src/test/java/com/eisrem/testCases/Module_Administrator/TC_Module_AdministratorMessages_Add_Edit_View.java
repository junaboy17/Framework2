package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Module_AdministratorMessages_Add_Edit_View extends AdministratorPage{

	@Test(priority=1)
	public void TC_Messages_Add_001() {		
		SoftAssert = new SoftAssert();

		String message = "SELENIUM TEST MESSAGE" + RandNum3;

		try{	
			SeleniumHelper.log.info("Verifying Message add functionality");
			Expected = Success;
			Actual = Source   	.AdministratorNavigator()
								.clickAdministratorMessages()
								.clickAdd()
								.AdministratorMessagesPage()
								.selectMessagesType(2)
								.clickInternalToggle(True)
								.clickActiveToggle(True)
								.setMessages(message)
								.setEndDate(Today)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
		
			SeleniumHelper.log.info("Verifying Message was created successfully");
			Expected = message;
			Actual = Source 	.Pagefactory()
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
	public void TC_Messages_Edit_001() {		
		SoftAssert = new SoftAssert();

		String Message = "SELENIUM TEST MESSAGE" + RandNum3;
		String Message2 = "SELENIUM TEST MESSAGE" + RandNum8;

		try{	
			SeleniumHelper.log.info("Verifying Message edit function");
			Expected = Success;
			Actual = Source   	.AdministratorNavigator()
								.clickAdministratorMessages()
								.clickAdd()
								.AdministratorMessagesPage()
								.selectMessagesType(2)
								.clickInternalToggle(True)
								.clickActiveToggle(True)
								.setMessages(Message)
								.setEndDate(Today)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.setSearch(Message)
								.clickFirstRow()
								.clickEdit()
								.AdministratorMessagesPage()
								.selectMessagesType(1)
								.clickInternalToggle(False)
								.setMessages(Message2, Clear)
								.clickSubmit()
								.readPopUpTitle();							

			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Navigating back to edit page and verifying updated value");
			Expected = False;
			Actual = Source   	.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.setSearch(Message2)
								.clickFirstRow()
								.clickEdit()
								.AdministratorMessagesPage()
								.readInternalToggle();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = "1000003134";
			Actual = Source   	.SeleniumHelper()
								.readAttribute(Source.AdministratorMessagesPage().MessageTypeDropDown, "value")
								.replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = Message2;
			Actual = Source   	.SeleniumHelper()
								.readAttribute(Source.Pagefactory().DescriptionTextBox, "last-val")
								.replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}

	@Test(priority=3)
	public void TC_Messages_View_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Verifying Adminstrator Messages view functionality");
			Expected = True;
			Actual = Source	.AdministratorNavigator()
							.clickAdministratorMessages()
							.DataTable()
							.clickFirstRow()
							.clickView()
							.SeleniumHelper()
							.readAttribute(Source.Pagefactory().EndDateTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying if editing is disabled in view mode");
			
			Expected = True;
			Actual = Source	.SeleniumHelper()
							.readAttribute(Source.AdministratorMessagesPage().MessageTypeDropDown, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = True;
			Actual = Source	.SeleniumHelper()
							.readAttribute(Source.Pagefactory().DescriptionTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
				
			Source.AdministratorMessagesPage().clickBackToAdministratorMessages();
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=4)
	public void TC_Messages_Roles_Add_001() {		
		SoftAssert = new SoftAssert();

		String stm = "Selenium Test Message" + RandNum3;
		String Message = "SELENIUM TEST MESSAGE" + RandNum3;
		
		try{	
			SeleniumHelper.log.info("Verifying Message Roles add functionality");
			Expected = Success;
			Actual = Source   	.AdministratorNavigator()
								.clickAdministratorMessages()
								.clickAdd()
								.AdministratorMessagesPage()
								.selectMessagesType(2)
								.clickInternalToggle(True)
								.clickActiveToggle(True)
								.setMessages(Message)
								.setEndDate(Today)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.setSearch(Message)
								.clickFirstRow()
								.clickEdit()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(Enumerations.Roles.ALLAPPS.getIndex())
								.GetSource()
								.RolesAvailableAccord()
								.clickActiveToggle(True)
								.setDescription(stm)
								.clickComplete()
								.Pagefactory()
								.readPopUpTitle();

			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying Message Role was created successfully");
			Expected = "ALLAPPS";
			Actual = Source 	.Pagefactory()
								.clickPopupOk()
								.RolesAvailableAccord()
								.readDataTable("rolesTable", 1, 2);
								
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}

	@Test(priority=4)
	public void TC_Messages_Srvpop_Add_001() {		
		SoftAssert = new SoftAssert();

		String stm = "Selenium Test Message" + RandNum3;
		String Message = "SELENIUM TEST MESSAGE" + RandNum3;
		
		try{	
			SeleniumHelper.log.info("Verifying Messages Roles add functionality");
			Expected = Success;
			Actual = Source   	.AdministratorNavigator()
								.clickAdministratorMessages()
								.clickAdd()
								.AdministratorMessagesPage()
								.selectMessagesType(2)
								.clickInternalToggle(True)
								.clickActiveToggle(True)
								.setMessages(Message)
								.setEndDate(Today)
								.clickSubmit()
								.clickPopupOk()
								.DataTable()
								.setSearch(Message)
								.clickFirstRow()
								.clickEdit()
								.ServicePopulationsAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation(1)
								.clickActiveToggle(True)
								.setDescription(stm)
								.clickSpComplete()
								.Pagefactory()
								.readPopUpTitle();							
								
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying Messages Srvpop Add was created successfully");
			Expected = "ADULT MH";
			Actual = Source 	.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.readDataTable("servicePopTable", 1, 2);
								
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}

	
}