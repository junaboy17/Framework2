package com.eisrem.testCases.Module_MyHomePage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;

public class TC_MyHomePage_Inbox_Forward_Notification extends MyHomePage{

	@Test(priority=1)
	public void TC_MyHomePage_Inbox_Forward_Notification_001() {
		
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Forwarding Inbox Message and verifying Success message");
			
			String subject = Source		.MyHomePage()
										.clickMyInboxFirstResultID()
										.GetSource()
										.SeleniumHelper()
										.getAttribute(Source.MyInboxManagePage().SubjectTextBox, "value");
			
			Expected =	Success;						
			Actual = Source		.MyInboxManagePage()
								.clickForwardToAnotherRecipient()
								.setForwardMessage("Selenium Forward Message")
								.setAvailableSearch("1045616")
								.selectAvailableClient(0)
								.clickAddName()
								.clickForward()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Logging out and logging back in as different user to confirm Inbox Message successfully received");
			Expected =	"FWD: " + subject;	
			Actual = Source		.Pagefactory()
								.clickGoBackToInbox()
								.MyInboxManagePage()
								.clickBackToMyInbox()
								.GetSource()
								.NavigationMenuBar()
								.clickWelcomeUser()
								.clickLogOut()
								.setUserName(Configuration.User.BusinessUser)
								.setPassword(Configuration.Password.BusinessPass)
								.clickSignIn()
								.GetSource()
								.MyHomePage()
								.clickMyInboxFirstResultID()
								.GetSource()
								.SeleniumHelper()
								.getAttribute(Source.MyInboxManagePage().SubjectTextBox, "value");
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
				
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}

}
