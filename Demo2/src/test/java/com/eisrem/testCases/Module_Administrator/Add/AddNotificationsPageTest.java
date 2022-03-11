package com.eisrem.testCases.Module_Administrator.Add;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;


public class AddNotificationsPageTest extends AdministratorPage{
	@Test(priority=1)
	public void AddNotificationsPageTitlesCheck() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying 'Add Notifications' page title");
			Expected ="Add Notifications";
			Actual = Source		.NotificationsPage()
								.clickNotifications()
								.DataTable()
								.clickAdd()
								.NotificationsPage()
								.readAddNotificationsTitle();
			SoftAssert.assertEquals(Actual, Expected);		
			
			SeleniumHelper.log.info("Verifying 'Notifications' link title");
			Expected ="Notifications";
			Actual = Source		.NotificationsPage()
								.readAccord();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Notification' tab title");
			Expected ="Notification";
			Actual = Source		.NotificationsPage()
								.readNotificationTab();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Notification Name' title");
			Expected ="Notification Name: *";
			Actual = Source		.NotificationsPage()
								.readNameTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Notification Save' btn title");
			Expected ="Save";
			Actual = Source		.NotificationsPage()
								.readSaveBtnTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Notification Back' btn title");
			Expected ="Back";
			Actual = Source		.NotificationsPage()
								.readBackBtnTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Notification Criteria' title");
			Expected ="Notification Description: *";
			Actual = Source		.NotificationsPage()
								.readCriteriaTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Notification Active' btn title");
			Expected ="Active?";
			Actual = Source		.NotificationsPage()
								.readActiveTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Notification Active Yes No' btn title");
			Expected ="YES NO";
			Actual = Source		.NotificationsPage()
								.readActiveToggle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Notification Send Email' btn title");
			Expected ="Send Email?";
			Actual = Source		.NotificationsPage()
								.readSendEmailBtnTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Notification Send Email Yes No' btn title");
			Expected ="YES NO";
			Actual = Source		.NotificationsPage()
								.readSendEmailToggle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Notification Start Date' title");
			Expected ="Start Date *";
			Actual = Source		.NotificationsPage()
								.readStartDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Notification End Date' title");
			Expected ="End Date";
			Actual = Source		.NotificationsPage()
								.readEndDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Notification Last Run Date' title");
			Expected ="Last Run Date";
			Actual = Source		.NotificationsPage()
								.readLastRunDateTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Set Conditions' link title");
			Expected ="Set Conditions";
			Actual = Source		.NotificationsPage()
								.readSetConditionsLink();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Set Conditions Type' title");
			Expected ="Type";
			Actual = Source		.SetConditionsAccord()
								.readTypeTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Set Conditions Page' title");
			Expected ="Page";
			Actual = Source		.SetConditionsAccord()
								.readPageTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Set Conditions Question' title");
			Expected ="Question";
			Actual = Source		.SetConditionsAccord()
								.readQuestionTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Set Conditions Answer' title");
			Expected ="Answer";
			Actual = Source		.SetConditionsAccord()
								.readAnswerTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Set Conditions Format' title");
			Expected ="Format";
			Actual = Source		.SetConditionsAccord()
								.readFormatTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Set Conditions Value' title");
			Expected ="Value";
			Actual = Source		.SetConditionsAccord()
								.readValueTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Set Conditions County' title");
			Expected ="County";
			Actual = Source		.SetConditionsAccord()
								.readCountyTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Set Conditions City/Town' title");
			Expected ="City/Town";
			Actual = Source		.SetConditionsAccord()
								.readCityTownTitle();
			SoftAssert.assertEquals(Actual, Expected);		
			
			SeleniumHelper.log.info("Verifying 'Set Conditions Add' btn title");
			Expected ="Add";
			Actual = Source		.SetConditionsAccord()
								.readAddBtnTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Set Conditions Remove' btn title");
			Expected ="Remove";
			Actual = Source		.SetConditionsAccord()
								.readRemoveBtnTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Set Conditions Search Criteria' title");
			Expected ="Search Criteria";
			Actual = Source		.SetConditionsAccord()
								.readSearchCriteriaTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'When' link title");
			Expected ="When (Frequency, Occurance, Expiry Date)";
			Actual = Source		.SetConditionsAccord()
								.readWhenLinkTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'When Check For Notifications' title");
			Expected ="Check For Notifications";
			Actual = Source		.WhenAccord()
								.clickWhenAccord()
								.readCheckForNotificationsTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'When Frequency' title");
			Expected ="Notify In *";
			Actual = Source		.WhenAccord()
								.readFrequencyTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'When Format' title");
			Expected ="Format *";
			Actual = Source		.WhenAccord()
								.readFormatTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'When Expiration Of Notifications' title");
			Expected ="Expiration of Notifications";
			Actual = Source		.WhenAccord()
								.readExpirationOfNotificationsTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'When Days Till Expiration' title");
			Expected ="Days Till Expiration (Inbox) *";
			Actual = Source		.WhenAccord()
								.readDaysTillExpirationTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'When Occurance Of Notifications' title");
			Expected ="Occurance of Notifications";
			Actual = Source		.WhenAccord()
								.readOccuranceOfNotificationsTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'When Occurance' title");
			Expected ="Occurance *";
			Actual = Source		.WhenAccord()
								.readOccuranceTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Who Recipients' link title");
			Expected ="Who (Recipients)";
			Actual = Source		.WhoAccord()
								.readWhoRecipientsLink();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying ' Who Recipients Show entries' title");
			Expected ="Show\n"
					+ "10\n"
					+ "25\n"
					+ "50\n"
					+ "100\n"
					+ "entries";
			Actual = Source		.WhoAccord()
								.clickWhoRecipientsAccord()
								.readShowEntriesTitle();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Who Recipients Add'  title");
			Expected = "Add";
			Actual = Source		.DataTable()
								.readAddBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying ' Who Recipients Edit'  title");
			Expected = "Edit";
			Actual = Source		.DataTable()
								.readEditBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying ' Who Recipients Excel'  title");
			Expected = "Excel";
			Actual = Source		.DataTable()
								.readExcelBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Who Recipients Id' list title");
			Expected = "ID";
			Actual = Source		.WhoAccord()
								.readIdList();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Who Recipients Name Type' list title");
			Expected = "Name/Type";
			Actual = Source		.WhoAccord()
								.readNameList();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Who Recipients Start Date' list title");
			Expected = "Start Date";
			Actual = Source		.WhoAccord()
								.readStartDateList();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Who Recipients End Date' list title");
			Expected = "End Date";
			Actual = Source		.WhoAccord()
								.readEndDateList();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Who Recipients Active' list title");
			Expected = "Active";
			Actual = Source		.WhoAccord()
								.readActiveList();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Who Recipients Previous' btn title");
			Expected = "Previous";
			Actual = Source		.WhoAccord()
								.readPreviousBtn();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Verifying 'Who Recipients Next' btn title");
			Expected = "Next";
			Actual = Source		.WhoAccord()
								.readNextBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Message Content'link title");
			Expected = "Message Content";
			Actual = Source		.MessageContentAccord()
								.readMessageContentLink();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Message Content Type' title");
			Expected = "Type";
			Actual = Source		.MessageContentAccord()
								.clickMessageContent()
								.readMessageContentTypeTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Message Content Value' title");
			Expected = "Value";
			Actual = Source		.MessageContentAccord()
								.readMessageContentValueTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Message Content Controls' title");
			Expected = "Controls";
			Actual = Source		.MessageContentAccord()
								.readMessageContentControlsTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Message Content Add Criteria' btn title");
			Expected = "Add Criteria";
			Actual = Source		.MessageContentAccord()
								.readMessageContentAddCriteriaBtnTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Message Content Remove Criteria' btn title");
			Expected = "Remove Criteria";
			Actual = Source		.MessageContentAccord()
								.readMessageContentRemoveCriteriaBtnTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Message Content Message Preview' btn title");
			Expected = "Message Preview";
			Actual = Source		.MessageContentAccord()
								.readMessageContentMessagePreviewBtnTitle();
			SoftAssert.assertEquals(Actual, Expected);
					
			SeleniumHelper.log.info("Verifying 'Copyright' title");
			Expected = "Copyright © " + CopyRightYear + " State of Maine DHHS.\n"
					+ "All Rights Reserved.";
			Actual = Source		.DataTable()
					 			.readCopyright();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'SubmitExit' btn title");
			Expected ="Submit & Exit";
			Actual = Source		.SetConditionsAccord()
								.readSubmitExitBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Save & Test' btn title");
			Expected ="Save & Test";
			Actual = Source		.SetConditionsAccord()
								.readSaveTestBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying 'Back To Notifications' btn title");
			Expected ="Back To Notifications";
			Actual = Source		.SetConditionsAccord()
								.readBackToNotificationsBtn();
			SoftAssert.assertEquals(Actual, Expected);
			
			
			SoftAssert.assertAll();
			
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
}