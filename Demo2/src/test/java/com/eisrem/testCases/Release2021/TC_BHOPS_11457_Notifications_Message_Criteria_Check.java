package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11457_Notifications_Message_Criteria_Check extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_Notifications_Message_Criteria_Check_002() {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Confirm default select is disabled for value");
					Expected = False;
					Actual = Source	.AdministratorNavigator()
									.clickNotifications()
									.clickAdd()
									.NotificationsPage()
									.clickMessageContent()
									.isMessageContentValueEnabled();
					
					SoftAssert.assertEquals(Actual, Expected);
					SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
					
					SeleniumHelper.log.info("Confirm Text after Select is enabled for value");
					Expected = True;
					Actual = Source	.MessageContentAccord()
									.selectMessageContentType(NotificationMessageType.TEXT.getIndex())
									.isMessageContentValueEnabled();
					
					SoftAssert.assertEquals(Actual, Expected);
					SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
					
					SeleniumHelper.log.info("Confirm Select after Text is disabled for value");
					Expected = False;
					Actual = Source	.MessageContentAccord()
									.selectMessageContentType(NotificationMessageType.SELECT.getIndex())
									.isMessageContentValueEnabled();
					
					SoftAssert.assertEquals(Actual, Expected);
					SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
					
					SeleniumHelper.log.info("Confirm Attribute after Select is enabled for value");
					Expected = True;
					Actual = Source	.MessageContentAccord()
									.selectMessageContentType(NotificationMessageType.ATTRIBUTE.getIndex())
									.isMessageContentValueEnabled();
					
					SoftAssert.assertEquals(Actual, Expected);
					SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
					
					SeleniumHelper.log.info("Confirm Text after Attribute is enabled for value");
					Expected = True;
					Actual = Source	.MessageContentAccord()
									.selectMessageContentType(NotificationMessageType.ATTRIBUTE.getIndex())
									.isMessageContentValueEnabled();
					
					SoftAssert.assertEquals(Actual, Expected);
					SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
					
					SeleniumHelper.log.info("Confirm Select after Attribute is enabled for value");
					Expected = False;
					Actual = Source	.MessageContentAccord()
									.selectMessageContentType(NotificationMessageType.SELECT.getIndex())
									.isMessageContentValueEnabled();
					
					SoftAssert.assertEquals(Actual, Expected);
					SeleniumHelper.log.info("Actual: " + Actual + "   Expected: " + Expected);
					
					SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
}
	
	

