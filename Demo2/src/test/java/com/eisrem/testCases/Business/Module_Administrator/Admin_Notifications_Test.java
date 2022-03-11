package com.eisrem.testCases.Business.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.BusinessUserLogIn;
import com.eisrem.pageFactory.Administrator.RolesPage;

public class Admin_Notifications_Test extends AdministratorPage {

	@Test(priority=1)
	public void Types() {
		
		SoftAssert = new SoftAssert();
		
		String title = "Data Fix " + RandNum4;
		String notificationName = "Business Selenium Data Fix Notification " + RandNum3;
		String message = "What needs to be fixed?";
		
		try{
			SeleniumHelper.log.info("Creating a Notification and assigning to a recipient");
			Expected =	Success;
			Actual =	Source		.AdministratorNavigator()
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
									.setWhenDaysTillExpiration("1")
									.selectWhenOccurance(3)
									.setDaysAfterOccurance("0")
									.GetSource()
									.NotificationsPage()
									.clickWhoRecipientsAccord()
									.clickAdd()
									.WhoAccord()
									.setStartDate(Today, Clear)
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
									.setSearch(JeanneID)
									.clickFirstRow()
									.clickAnchor()
									.NavigationMenuBar()
									.clickAssessmentForms()
									.clickAdd()
									.Assessment_FormsPage()
									.setStartDate(PastDate5, Clear)
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
			
			SeleniumHelper.log.info("Waiting for Notification and verifying Success");
			Expected =	message + JeanneID;
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
}