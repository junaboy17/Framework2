package com.eisrem.testCases.Module_Administrator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.NotificationFormat;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Notifications_Add_Edit_View extends AdministratorPage{

	@Test(priority=1)
	public void TC_Notifications_Add_002() {
		
		SoftAssert = new SoftAssert();
		
		String notificationName = "Test Notification " + RandNum4;
		String message = "Test Message";
		String title = "Test Title " + RandNum4;
		System.out.println(notificationName);
		System.out.println(title);
		try{	
			SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
			System.out.println(notificationName);
			Expected = Success;
			Actual = Source   	.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.setNotificationName(notificationName)
								.setDescription(Description)
								.setStartDate(PastDate5, Clear)
								.GetSource()
								.Pagefactory()
								.clickActiveToggle(True)
								.GetSource()
								.NotificationsPage()
								.clickSendEmailToggle(True)
								.GetSource()
								.SetConditionsAccord()
								.setType("1000075916")
								.setPage("1000007696")
								.setQuestion("1000032018")
								.selectAnswer(1)
								.selectFormat("ANSWER IS SELECTED")
								.clickSetConditionsAdd()
								.GetSource()
								.NotificationsPage()
								.clickWhenAccord()
								.selectWhenFormat(1)
								.setWhenDaysTillExpiration("3")
								.selectWhenOccurance(3)
								.setDaysAfterOccurance("0")
								.GetSource()
								.NotificationsPage()
								.clickWhoRecipientsAccord()
								.clickAdd()
								.WhoAccord()
								.setStartDate(FutureDate30, Clear)
								.selectType(1)
								.setUser(SeleniumUserID)
								.clickComplete()
								.NotificationsPage()
								.clickMessageContent()
								.selectMessageContentType(1)
								.setMessageContentValue(message)
								.clickMessageContentAddCriteria()
								.GetSource()
								.MessageContentAccord()
								.selectMessageContentType(2,2)
								.selectMessageContentValue(2, 1)
								.clickMessageContentAddCriteria(2)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Adding an Assessment, filling Form and Starting Assessment");
			Expected =	Success;
			Actual =	Source		.Pagefactory()
									.clickGoBackToList()
									.NavigationMenuBar()
									.clickPeople()
									.setSearch("270930")
									.clickFirstRow()
									.clickAnchor()
									.NavigationMenuBar()
									.clickAssessmentForms()
									.clickAdd()
									.Assessment_FormsPage()
									.setStartDate(Today, Clear)
									.GetSource()
									.Assessment_FormsPage()
									.selectAssessmentType("Data Fix Form (V2)/ Assessment")
									.setTitle(title)
									.clickStartAssessment()
									.GetSource()
									.FormPage()
									.selectValue(1, "Service", "Childrens")
									.setText(2, "Name", JeanneSignature)
									.setText(2, "Email", Email)
									.setText(2, "Agency", OrgDHHS)
									.setText(2, "Phone", PhoneNumber)
									.selectValue(3, "App", "Assessment/Forms")
									.clickSubmitAllPages()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Waiting 5 Minutes for Notification and verifying Success");
			Expected =	"What needs to be fixed?270930";
			Actual =	Source		.FormPage()
									.clickGoBackToPeople()
									.GetSource()
									.NavigationMenuBar()
									.clickMyHomePage()
									.GetSource()
									.SeleniumHelper()
									.sleep(300)
									.refreshPage()
									.GetSource()
									.MyHomePage()
									.readMyInboxFirstResultNameValue();
			SoftAssert.assertEquals(Actual, Expected);	
									
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}
	
	@Test(priority=2)
	public void TC_Notifications_Add_003() {		
		SoftAssert = new SoftAssert();
		
		String notificationName = "Test Notification " + RandNum5;
		String message = "Test Message";
		String title = "Test Title " + RandNum4;
		
		try{	
			SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
			Expected = Success;
			Actual = Source   	.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.setNotificationName(notificationName)
								.setDescription(Description)
								.setStartDate(PastDate5, Clear)
								.GetSource()
								.Pagefactory()
								.clickActiveToggle(True)
								.GetSource()
								.NotificationsPage()
								.clickSendEmailToggle(True)
								.GetSource()
								.SetConditionsAccord()
								.setType("1000075916")
								.setPage("1000007696")
								.setQuestion("1000032018")
								.selectAnswer(1)
								.selectFormat("ANSWER IS SELECTED")
								.clickSetConditionsAdd()
								.GetSource()
								.NotificationsPage()
								.clickWhenAccord()
								.selectWhenFormat(1)
								.setWhenDaysTillExpiration("3")
								.selectWhenOccurance(3)
								.setDaysAfterOccurance("0")
								.GetSource()
								.NotificationsPage()
								.clickWhoRecipientsAccord()
								.clickAdd()
								.WhoAccord()
								.setStartDate(FutureDate30, Clear)
								.selectType(1)
								.setUser(SeleniumUserID)
								.clickComplete()
								.NotificationsPage()
								.clickMessageContent()
								.selectMessageContentType(1)
								.setMessageContentValue(message)
								.clickMessageContentAddCriteria()
								.GetSource()
								.MessageContentAccord()
								.selectMessageContentType(2,2)
								.selectMessageContentValue(2, 1)
								.clickMessageContentAddCriteria(2)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Copying Notification and Verifying Success");
			Expected =	Success;
			Actual =	Source	.Pagefactory()
								.clickGoBackToList()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.NotificationsPage()
								.clickCopyNotification()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Adding an Assessment, filling Form and Starting Assessment");
			Expected =	notificationName + " - copy";
			Actual =	Source	.Pagefactory()
								.clickPopupOk()
								.NotificationsPage()
								.clickBackToNotifications()
								.DataTable()
								.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
									
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=3)
	public void TC_Notifications_Edit_001() {		
		SoftAssert = new SoftAssert();
		
		String testRole = "SELENIUM TEST ROLE " + RandNum4;
		
		try{	
			SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
			Expected = Success;
			Actual = Source   	.AdministratorNavigator()
								.clickRoles()
								.clickAdd()
								.RolesPage()
								.setRoleName(testRole, Clear)
								.clickAppAreaAccord()
								.setSearchAppArea("ADMINISTRATOR")
								.GetSource()
								.RolesPage()
								.clickAppToggle("ADMINISTRATOR", "true")
								.clickAppAreaModulesAccord()
								.setSearchAppAreaModules("Types")
								.clickModuleToggle("Types", "Active", "true")
								.clickModuleToggle("Types", "Add", "true")
								.clickModuleToggle("Types", "View", "true")
								.clickModuleToggle("Types", "Edit", "true")
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
			Expected = Success;
			Actual = Source   	.Pagefactory()
								.clickPopupOk()
								.AdministratorNavigator()
								.clickNotifications()
								
								.clickFirstRow()
								.clickEdit()
								.NotificationsPage()
								.clickWhoRecipientsAccord()
								
								.clickAdd()
								.WhoAccord()
								.selectType(2)
								.selectRole(testRole)
								.clickComplete()
								.NotificationsPage()
								.clickSubmitExit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
			Expected = testRole + "/ ROLE";
			Actual = Source   	.Pagefactory()
								.clickGoBackToList()
								.DataTable()
								.clickFirstRow()
								.clickView()
								.NotificationsPage()
								.clickWhoRecipientsAccord()
								.setSearch(testRole)
								.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
									
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=4)
	public void TC_Notifications_Edit_002() {		
		SoftAssert = new SoftAssert();
				
		try{	
			SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
			
			String origNotiName = Source.AdministratorNavigator()
										.clickNotifications()
										.clickFirstRow()
										.clickEdit()
										.NotificationsPage()
										.GetSource()
										.SeleniumHelper()
										.readAttribute(Source.NotificationsPage().NotificationNameTextBox, "value");
			
			String updatedOrigNotiName = origNotiName + " Updated";
			
			SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
			Expected = Success;
			Actual = Source		.NotificationsPage()
								.clickCopyNotification()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
			Expected = Success;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.NotificationsPage()
								.setNotificationName(updatedOrigNotiName, Clear)
								.setDescription(UpdateDescription, Clear)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
			Expected = updatedOrigNotiName;
			Actual = Source		.Pagefactory()
								.clickGoBackToList()
								.DataTable()
								.setSearch(updatedOrigNotiName)
								.clickFirstRow()
								.clickView()
								.SeleniumHelper()
								.readAttribute(Source.NotificationsPage().NotificationNameTextBox, "last-val").replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
			Expected = UpdateDescription;
			Actual = Source		.SeleniumHelper()
								.readAttribute(Source.Pagefactory().DescriptionTextBox, "last-val").replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);
												
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}

	@Test(priority=5)
	public void TC_Notifications_View_001() {		
		SoftAssert = new SoftAssert();
				
		try{	
			SeleniumHelper.log.info("Navigating to View Notifications and Verifying fields are Disabled");
			Expected = True;
			Actual = Source		.AdministratorNavigator()
								.clickNotifications()
								.clickFirstRow()
								.clickView()
								.SeleniumHelper()
								.getAttribute(Source.NotificationsPage().NotificationNameTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.Pagefactory().DescriptionTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.Pagefactory().StartDateTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.Pagefactory().EndDateTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.NotificationsPage().LastRunDateTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.Pagefactory()
								.readIfActiveToggleDisabled();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.NotificationsPage()
								.readIfSendEmailToggleDisabled();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying Back Button is Enabled");
			ExpectedB = T;
			ActualB = Source		.NotificationsPage()
								.readIfBackBtnDisabled();
			SoftAssert.assertEquals(ActualB, ExpectedB);	
			//
			SeleniumHelper.log.info("Verifying Set Conditions Accordion fields are Disabled ");
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.SetConditionsAccord().TypeTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.SetConditionsAccord().PageTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.SetConditionsAccord().QuestionTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.SetConditionsAccord().AnswerDropDown, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.SetConditionsAccord().FormatDropDown, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.SetConditionsAccord().ValueTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.SetConditionsAccord().CountyDropDown, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.SetConditionsAccord().CityTownDropDown, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.SetConditionsAccord().AddBtn, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.SetConditionsAccord().RemoveBtn, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.SetConditionsAccord().SearchCriteriaTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying When Accordion fields are Disabled ");
			Expected = True;
			Actual = Source		.NotificationsPage()
								.clickWhenAccord()
								.GetSource()
								.SeleniumHelper()
								.getAttribute(Source.WhenAccord().NotifyInTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.WhenAccord().FormatSelectBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.WhenAccord().DaysTillExpirationTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.WhenAccord().OccuranceSelectBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.WhenAccord().DaysAfterOccuranceTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying Who Accordion");
			Expected = "No data available";
			Actual = Source		.NotificationsPage()
								.clickWhoRecipientsAccord()
								.GetSource()
								.DataTable()
								.readFirstResultID();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying Message Content Accordion fields are Disabled");
			Expected = True;
			Actual = Source		.NotificationsPage()
								.clickMessageContent()
								.GetSource()
								.SeleniumHelper()
								.getAttribute(Source.MessageContentAccord().TypeDropDown, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.MessageContentAccord().ValueTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.MessageContentAccord().AddCriteriaBtn, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.MessageContentAccord().RemoveCriteriaBtn, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual = Source		.SeleniumHelper()
								.getAttribute(Source.MessageContentAccord().MessagePreviewTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = "Save & Test";
			Actual = Source		.NotificationsPage()
								.readSaveTestBtn();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = "Back To Notifications";
			Actual = Source		.NotificationsPage()
								.readBackToNotificationsBtn();
			SoftAssert.assertEquals(Actual, Expected);	
					
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=6)
	public void TC_Notifications_Confirm_Questions_001() {		
		SoftAssert = new SoftAssert();
		
		String notificationName = "Test Notification Name " + RandNum3;
				
		try{	
			SeleniumHelper.log.info("Navigating to View Notifications and Verifying fields are Disabled ");
			Expected = "Warning";
			Actual = Source		.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.setNotificationName(notificationName)
								.setNotificationsCriteria(Description)
								.GetSource()
								.SetConditionsAccord()
								.setType("1")
								.setPage("1")
								.setQuestion("1")
								.clickSetConditionsAdd()
								.readPopUpTitle();								
			SoftAssert.assertEquals(Actual, Expected);	
								
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=7)
	public void TC_Notifications_Criteria_Check_001() {		
		SoftAssert = new SoftAssert();
		
		List<String> formatValues = new ArrayList<String>();
		for(NotificationFormat name : NotificationFormat.values())
			formatValues.add(name.getName());
		
		String notificationName = "Test Notification Name " + RandNum3;
		String type = "1000075937";
		String page = "1000007716";
		String question = "1000032040";
				
		try{	
			SeleniumHelper.log.info("test ");
			
			Expected = "When Type: " + type + " SOC Provider Form V2/ Notes Page: " + page + " SOC Provider Form V2 Question: " + question + " # of clinician(s)/ INTEGER FIELD " + formatValues.get(1);
			Actual = 
					Source		.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.setNotificationName(notificationName)
								.setNotificationsCriteria(Description)
								.GetSource()
								.SetConditionsAccord()
								.addSetConditionAndVerify(type, page, question, 1);
			SoftAssert.assertEquals(Actual, Expected);	
			
			for(int i = 2; i<10; i++) {
				Expected = "When Type: " + type + " SOC Provider Form V2/ Notes Page: " + page + " SOC Provider Form V2 Question: " + question + " # of clinician(s)/ INTEGER FIELD " + formatValues.get(i);
				Actual = Source		.SetConditionsAccord()
									.clickSetConditionsRemove(1)
									.addSetConditionAndVerify(type, page, question, i);
				SoftAssert.assertEquals(Actual, Expected);	
			}
			
			Expected = "When Type: " + type + " SOC Provider Form V2/ Notes Page: " + page + " SOC Provider Form V2 Question: " + question + " # of clinician(s)/ INTEGER FIELD " + formatValues.get(10) + " " + type + " SOC Provider Form V2/ Notes AND Page: " + page + " SOC Provider Form V2 AND Question: " + question + " # of clinician(s)/ INTEGER FIELD Answer: " + formatValues.get(1);
			Actual = Source		.SetConditionsAccord()
								.clickSetConditionsRemove(1)
								.setType(type)
								.setPage(page)
								.setQuestion(question)
								.selectFormat(10)
								.setType2(type)
								.setPage2(page)
								.setQuestion2(question)
								.selectFormat2(1)
								.clickSetConditionsAdd()
								.readSearchCriteria();
			SoftAssert.assertEquals(Actual, Expected);	
			
			for(int i = 11; i<14; i++) {
				Expected = "When Type: " + type + " SOC Provider Form V2/ Notes Page: " + page + " SOC Provider Form V2 Question: " + question + " # of clinician(s)/ INTEGER FIELD " + formatValues.get(i);
				Actual = Source		.SetConditionsAccord()
									.clickSetConditionsRemove(1)
									.addSetConditionAndVerify(type, page, question, i);
				SoftAssert.assertEquals(Actual, Expected);	
			}
			
			Expected = "When Type: " + type + " SOC Provider Form V2/ Notes Page: " + page + " SOC Provider Form V2 Question: " + question + " # of clinician(s)/ INTEGER FIELD " + formatValues.get(14) + " undefined";
			Actual = Source		.SetConditionsAccord()
								.clickSetConditionsRemove(1)
								.setType(type)
								.setPage(page)
								.setQuestion(question)
								.selectFormat(14)
								.clickSetConditionsAdd()
								.readSearchCriteria();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = "When Type: " + type + " SOC Provider Form V2/ Notes Page: " + page + " SOC Provider Form V2 Question: " + question + " # of clinician(s)/ INTEGER FIELD " + formatValues.get(15);
			Actual = Source		.SetConditionsAccord()
								.clickSetConditionsRemove(1)
								.setType(type)
								.setPage(page)
								.setQuestion(question)
								.selectFormat(15)
								.clickSetConditionsAdd()
								.readSearchCriteria();
			SoftAssert.assertEquals(Actual, Expected);	
														
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=8)
	public void TC_Notifications_Fire_Correctly_Check_001() {		
		SoftAssert = new SoftAssert();
		
		String notificationName = "Notification Name" + RandNum3;
		String criteria = "Criteria" + RandNum4;
		String notificationName2 = "Notification Name" + RandNum4;
		String criteria2 = "Criteria" + RandNum5;
								
		try{	
			SeleniumHelper.log.info("test");
			Expected = Success;
			Actual = Source		.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.setNotificationName(notificationName)
								.setNotificationsCriteria(criteria)
								.GetSource()
								.SetConditionsAccord()
								.setType("a")
								.setPage("a")
								.setQuestion("a")
								.selectFormat(8)
								.clickSetConditionsAdd()
								.clickWhenAccord()
								.setNotifyIn(FiveN, Clear)
								.selectWhenFormat(1)
								.setWhenDaysTillExpiration(OneN)
								.clickWhoRecipientsAccord()
								.clickAdd()
								.WhoAccord()
								.selectType(1)
								.setUser(SeleniumUserID)
								.clickComplete()
								.NotificationsPage()
								.clickMessageContent()
								.selectMessageContentType(1)
								.setMessageContentValue("TYPE/ANSWER IS EDITED")
								.clickMessageContentAddCriteria()
								.clickSubmitExit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("test");
			Expected = Success;
			Actual = Source		.Pagefactory()
								.clickGoBackToList()
								.DataTable()
								.clickAdd()
								.NotificationsPage()
								.setNotificationName(notificationName2)
								.setNotificationsCriteria(criteria2, Clear)
								.GetSource()
								.SetConditionsAccord()
								.setType("a")
								.setPage("a")
								.setQuestion("a")
								.selectFormat(8)
								.clickSetConditionsAdd()
								.clickWhenAccord()
								.setNotifyIn(FiveN, Clear)
								.selectWhenFormat(1)
								.setWhenDaysTillExpiration(OneN)
								.clickWhoRecipientsAccord()
								.clickAdd()
								.WhoAccord()
								.selectType(1)
								.setUser(SeleniumUserID)
								.clickComplete()
								.NotificationsPage()
								.clickMessageContent()
								.selectMessageContentType(1)
								.setMessageContentValue("TYPE/ANSWER IS ENTERED")
								.clickMessageContentAddCriteria()
								.clickSubmitExit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("test");
			Expected = Success;
//			Actual = Source		.NavigationMenuBar()	
//								.clickPeople()
//								.
//			SoftAssert.assertEquals(Actual, Expected);	
										
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=9)
	public void TC_Notifications_When_Frequency_001() {		
		SoftAssert = new SoftAssert();
								
		try{	
			SeleniumHelper.log.info("test");
			Expected = String.valueOf(RandNum2);
			Actual = Source		.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.clickWhenAccord()
								.setNotifyIn(String.valueOf(RandNum2), true, Clear)
								.selectWhenFormat(1)
								.GetSource()
								.SeleniumHelper()
								.getAttribute(Source.WhenAccord().NotifyInTextBox, "last-val").replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("test");
			Expected = String.valueOf(RandNum3);
			Actual = Source		.WhenAccord()
								.setNotifyIn(String.valueOf(RandNum3), true, Clear)
								.selectWhenFormat(1)
								.GetSource()
								.SeleniumHelper()
								.getAttribute(Source.WhenAccord().NotifyInTextBox, "last-val").replace("\"", "");
			SoftAssert.assertEquals(Actual, Expected);	
										
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=10)
	public void TC_Notifications_Search_001() {		
		SoftAssert = new SoftAssert();
								
		try{	
			SeleniumHelper.log.info("test");
			
			Expected = Source	.AdministratorNavigator()
								.clickNotifications()
								.readFirstResultNameType();
			
			Actual = Source		.DataTable()
								.setSearch(Expected)
								.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
													
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=13)
	public void TC_Notifications_Add_Edit_Fire_Correctly() {		
		SoftAssert = new SoftAssert();
		
		String title = "TC_Notifications_" + RandNum6;
		String testNotification = "Test Notification " + RandNum4;
						
		try{	
			SeleniumHelper.log.info("test");
			Expected = Success;
			Actual = Source		.NavigationMenuBar()
								.clickPeople()
								.setSearch(LastName)
								.clickFirstRow()
								.clickAnchor()
								.NavigationMenuBar()
								.clickAssessmentForms()
								.clickAdd()
								.Assessment_FormsPage()
								.setTitle(title)
								.selectAssessmentType(DataFixFormV2Assessment)
								.clickStartAssessment()
								.fillForm()
								.clickSubmitAllPages()
								.clickGoBackToList()
								.NavigationMenuBar()
								.clickAdministrator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.setNotificationName(title)
								.setNotificationsCriteria(Description)
								.GetSource()
								.SetConditionsAccord()
								.setType("1000075916")
								.setPage("1")
								.setQuestion("1")
								.selectFormat(8)
								.selectFormat(1)
								.clickSetConditionsAdd()
								.clickWhenAccord()
								.setWhenDaysTillExpiration("5")
								.clickWhoRecipientsAccord()
								.clickAdd()
								.WhoAccord()
								.selectType(1)
								.setUser(SeleniumUserID)
								.clickComplete()
								.NotificationsPage()
								.clickMessageContent()
								.selectMessageContentType(1)
								.setMessageContentValue(testNotification + " Created")
								.clickSubmitExit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("test");
			Expected = "No data available";
			Actual = Source		.Pagefactory()
								.clickGoBackToList()
								.NavigationMenuBar()
								.clickMyHomePage()
								.GetSource()
								.SeleniumHelper()
								.Wait(300)
								.GetSource()
								.SeleniumHelper()
								.refreshPage()
								.GetSource()
								.DataTable()
								.readFirstResultID();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("test");
			Expected = Success;
			Actual = Source		.NavigationMenuBar()
								.clickPeople()
								.setSearch(LastName)
								.clickFirstRow()
								.clickAnchor()
								.NavigationMenuBar()
								.clickAssessmentForms()
								.clickAdd()
								.Assessment_FormsPage()
								.selectAssessmentType(DataFixFormV2Assessment)
								.setTitle(title)
								.clickStartAssessment()
								.fillForm()
								.clickSubmitAllPages()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("test");
			Expected = testNotification + " Created";
			Actual = Source		.Pagefactory()
								.clickGoBackToList()
								.NavigationMenuBar()
								.clickMyHomePage()
								.GetSource()
								.SeleniumHelper()
								.Wait(300)
								.GetSource()
								.SeleniumHelper()
								.refreshPage()
								.GetSource()
								.DataTable()
								.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("test");
			Expected = Success;
			Actual = Source		.NavigationMenuBar()
								.clickAdministrator()
								.clickNotifications()
								.setSearch(testNotification)
								.clickFirstRow()
								.clickEdit()
								.NotificationsPage()
								.clickMessageContent()
								.setMessageContentValue(testNotification + " Modified")
								.GetSource()
								.NavigationMenuBar()
								.clickMyHomePage()
								.clickDiscard()
								.SeleniumHelper()
								.Wait(300)
								.GetSource()
								.SeleniumHelper()
								.refreshPage()
								.GetSource()
								.DataTable()
								.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("test");
//			Expected = Success;
//			Actual = Source		.NavigationMenuBar()
//								.clickPeople()
//								.setSearch(LastName)
//								.clickFirstRow()
//								.clickAnchor()
//								.NavigationMenuBar()
//								.clickNotes()
//								.clickAdd()
//								.NotesPage()
//								.selectType(assessmentType)
			SoftAssert.assertEquals(Actual, Expected);	
										
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=14)
	public void TC_Notifications_IsCreated_Check() {		
		SoftAssert = new SoftAssert();
				
		try{	
			SeleniumHelper.log.info("test");
			Expected = Success;
			Actual = Source		.AdministratorNavigator()
								.clickPages()
								.clickAdd()
								.PagesPage()
								.setPageName("TYPE/ANSWER IS ENTERED Page")
								.setDescription(Description)
								.DataTable()
								.clickAdd()
								.SectionsAvailableAccord()
								.setSectionName("TYPE/ANSWER IS ENTERED Page")
								.setSortOrder("1")
								.GetSource()
								.RowsAvailableAccord()
								.clickRowAdd()
								.setRowName(RowName)
								.setSortOrder("1")
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(3)
								.setQuestionLabel("DATE FIELD")
								.setSortOrder("1")
								.clickQASave()
								.clickPopupOkIfExist()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(4)
								.setQuestionLabel("DECIMAL FIELD")
								.setSortOrder("2")
								.clickQASave()
								.clickPopupOkIfExist()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(8)
								.setQuestionLabel("ORG LOOKUP")
								.setSortOrder("3")
								.clickQASave()
								.clickPopupOkIfExist()
								.RowsAvailableAccord()
								.clickSubmitExit()
								.clickPopupOkIfExist()
								.DataTable()
								.readFirstResultID();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("test");
			Expected = Success;
			Actual = Source		.AdministratorNavigator()
								.clickTypes()
								.clickAdd()
								.TypesPage()
								.selectAppModule(2)
								.selectAppAreaToConductType(3)
								.setName("TYPE/ANSWER IS ENTERED TYPE")
								.selectLockTime(2)
								.setDescription(Description)
								.clickAdd()
								.PagesAvailableAccord()
								.setPage("pageID")
								.setSortOrder("1")
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(2)
								.clickRolesComplete()
								.PagesAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation(3)
								.clickSpComplete()
								.PagesAvailableAccord()
								.clickComplete()
								.Pagefactory()
								.readTopErrorMessage(1);
			SoftAssert.assertEquals(Actual, Expected);
										
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=15)
	public void TC_Notifications_IsSubmitted_Check() {		
		SoftAssert = new SoftAssert();
				
		try{	
			SeleniumHelper.log.info("test");
			Expected = "Lock Type!";
			String ID = Source		.AdministratorNavigator()
								.clickPages()
								.clickAdd()
								.PagesPage()
								.setPageName("TYPE/ANSWER IS EDITED Page")
								.setDescription("TC_Notifications_IsSubmitted_Check")
								.DataTable()
								.clickAdd()
								.SectionsAvailableAccord()
								.setSectionName("TYPE/ANSWER IS EDITED Page")
								.setSortOrder("1")
								.GetSource()
								.RowsAvailableAccord()
								.clickRowAdd()
								.setRowName("TYPE/ANSWER IS EDITED Page")
								.setSortOrder("1")
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.setQuestionLabel("CHECK BOX FIELD")
								.setSortOrder("1")
								.selectQuestionType(1)
								.clickQASave()
								.clickPopupOkIfExist()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.setQuestionLabel("DATE FIELD")
								.setSortOrder("2")
								.selectQuestionType(3)
								.clickQASave()
								.clickPopupOkIfExist()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.setQuestionLabel("DECIMAL FIELD")
								.setSortOrder("3")
								.selectQuestionType(4)
								.clickQASave()
								.clickPopupOkIfExist()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.setQuestionLabel("ORG LOOKUP")
								.setSortOrder("4")
								.selectQuestionType(8)
								.clickQASave()
								.clickPopupOkIfExist()
								.RowsAvailableAccord()
								.clickSubmitExit()
								.clickPopupOkIfExist()
								.DataTable()
								.readFirstResultID();
			
			SeleniumHelper.log.info("test");
			Actual = Source		.AdministratorNavigator()
								.clickTypes()
								.clickAdd()
								.TypesPage()
								.setName("TYPE/ANSWER IS EDITED TYPE")
								.selectAppModule(2)
								.selectAppAreaToConductType(3)
								.selectLockTime(1)
								.setDescription("TC_Notifications_IsSubmitted_Check")
								
								.clickAdd()
								.PagesAvailableAccord()
								.setPage(ID)
								
								.setSortOrder("1")
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(2)
								.clickRolesComplete()
								.ServicePopulationsAvailableAccord()
								.clickServicePopulationAvailableAccord()
								.clickSpAdd()
								.selectServicePopulation(3)
								.clickSpComplete()
								.PagesAvailableAccord()
								.clickComplete()
								.TypesPage()
								.clickLockForUseToggle("true")
								.readPopUpTitle();
								
			SoftAssert.assertEquals(Actual, Expected);
										
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
}