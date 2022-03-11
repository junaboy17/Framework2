package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11611_Notifications_Non_Multi_Question_Answer_ID_Only extends AdministratorPage {
	
	@Test(priority=1)
	public void Non_Multi_Question_Answer_ID_Only() {
		
		SoftAssert = new SoftAssert();

		try{
				SeleniumHelper.log.info("Navigating to notificaiton, confirming that non multi-choice/multi-select Answers do not contain 'NULL' in the text.");
				Expected = EmptyString;
				Actual = Source	.AdministratorNavigator()
								.clickNotifications()
								.clickAdd()
								.NotificationsPage()
								.clickActiveToggle()
								.setNotificationName("SELENIUM NOTIFICATION")
								.setNotificationsCriteria("Data Fix Form")
								.GetSource()
								.SetConditionsAccord()
								.setType("Data Fix Form")
								.setPage("Data Fix Form")
								.setQuestion("Agency Name")
								.getAnswer()
								.getAttribute("innerText");
				SoftAssert.assertEquals(Actual, Expected);
				
				Expected = "true";
				Actual = Source	.NotificationsPage()
								.GetSource()
								.SetConditionsAccord()
								.AnswerDropDown
								.getAttribute("disabled");
				SoftAssert.assertEquals(Actual, Expected);
				
								
				
				
				
				String criteriaString = Source .NotificationsPage()
								.GetSource()
								.SetConditionsAccord()
								.selectFormat("TYPE/ANSWER IS ENTERED")
								.clickSetConditionsAdd()
								.readSearchCriteria();
				
				Expected = "-1";
				Actual = criteriaString.indexOf("Answer: ") + EmptyString;
				SoftAssert.assertEquals(Actual, Expected);
				
				Actual = criteriaString.indexOf("1000063291") + EmptyString;
				SoftAssert.assertEquals(Actual, Expected);
				
				Actual = criteriaString.indexOf("NULL") + EmptyString;
				SoftAssert.assertEquals(Actual, Expected);
				
				
				
				
				criteriaString =  Source.NotificationsPage()
								.clickWhenAccord()
								.setNotifyIn("5")
								.selectWhenFormat(1)
								.setWhenDaysTillExpiration("1")
								.GetSource()
								.NotificationsPage()
								.clickSubmitExit()
								.clickGoBackToList()
								.DataTable()
								.clickFirstRow()
								.clickEdit()
								.NotificationsPage()
								.GetSource()
								.SetConditionsAccord()
								.readSearchCriteria();
				
				Actual = criteriaString.indexOf("Answer: ") + EmptyString;
				SoftAssert.assertEquals(Actual, Expected);
				
				Actual = criteriaString.indexOf("1000063291") + EmptyString;
				SoftAssert.assertEquals(Actual, Expected);
				
				Actual = criteriaString.indexOf("NULL") + EmptyString;
				SoftAssert.assertEquals(Actual, Expected);
				
				
				
				
				criteriaString =  Source.NotificationsPage()
								.clickBackToNotifications()
								.DataTable()
								.clickFirstRow()
								.clickView()
								.NotificationsPage()
								.GetSource()
								.SetConditionsAccord()
								.readSearchCriteria();
				
				Actual = criteriaString.indexOf("Answer: ") + EmptyString;
				SoftAssert.assertEquals(Actual, Expected);
				
				Actual = criteriaString.indexOf("1000063291") + EmptyString;
				SoftAssert.assertEquals(Actual, Expected);
				
				Actual = criteriaString.indexOf("NULL") + EmptyString;
				SoftAssert.assertEquals(Actual, Expected);Expected = EmptyString;
				
				
				
				
				
				
				
				
				
				Expected = "1000063315 Completed";
				Actual = Source.NotificationsPage()
						.clickBackToNotifications()
						.DataTable()
						.clickAdd()
						.NotificationsPage()
						.clickActiveToggle()
						.setNotificationName("SELENIUM NOTIFICATION")
						.setNotificationsCriteria("Data Fix Form")
						.GetSource()
						.SetConditionsAccord()
						.setType("Data Fix Form")
						.setPage("Data Fix Form")
						.setQuestion("Data Fix Form Completed")
						.selectAnswer(1)
						.getAnswer()
						.getAttribute("innerText");
		SoftAssert.assertEquals(Actual, Expected);
		
		Actual = Source	.NotificationsPage()
						.GetSource()
						.SetConditionsAccord()
						.AnswerDropDown
						.getAttribute("disabled");
		SoftAssert.assertNull(Actual);
		
						
		
		
		
		criteriaString = Source .NotificationsPage()
						.GetSource()
						.SetConditionsAccord()
						.selectFormat("TYPE/ANSWER IS EDITED")
						.clickSetConditionsAdd()
						.readSearchCriteria();
		
		Expected = "-1";
		Actual = criteriaString.indexOf("Answer: 1000063315 Completed") + EmptyString;
		SoftAssert.assertNotEquals(Actual, Expected);
		
		
		
		
		criteriaString =  Source.NotificationsPage()
						.clickWhenAccord()
						.setNotifyIn("5")
						.selectWhenFormat(1)
						.setWhenDaysTillExpiration("1")
						.GetSource()
						.NotificationsPage()
						.clickSubmitExit()
						.clickGoBackToList()
						.DataTable()
						.clickFirstRow()
						.clickEdit()
						.NotificationsPage()
						.GetSource()
						.SetConditionsAccord()
						.readSearchCriteria();
		
		Actual = criteriaString.indexOf("Answer: 1000063315 Completed") + EmptyString;
		SoftAssert.assertNotEquals(Actual, Expected);
		
		
		
		
		criteriaString =  Source.NotificationsPage()
						.clickBackToNotifications()
						.DataTable()
						.clickFirstRow()
						.clickView()
						.NotificationsPage()
						.GetSource()
						.SetConditionsAccord()
						.readSearchCriteria();
		
		Actual = criteriaString.indexOf("Answer: 1000063315 Completed") + EmptyString;
		SoftAssert.assertNotEquals(Actual, Expected);
				
				
				
				
				SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
	}
	
	

