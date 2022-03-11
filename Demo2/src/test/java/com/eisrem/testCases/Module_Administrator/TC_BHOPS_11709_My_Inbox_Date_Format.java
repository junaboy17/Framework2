package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.PeoplePage;

public class TC_BHOPS_11709_My_Inbox_Date_Format extends AdministratorPage {
	
	@Test(priority=1)
	public void My_Inbox_Date_Format_001() {
		
		SoftAssert = new SoftAssert();
		int RandNum4 = SeleniumHelper.generateRandomNumber(4);
		String NotificationName = "TC_My_Inbox_Date_Format_" + RandNum4 ;

		try{
					SeleniumHelper.log.info("Logging in to system & adding new  medicaid ID to an individual with smaller case letter in identifier tab");
					
					ActualB = Source.AdministratorNavigator()
									.clickNotifications()
									.DataTable()
									.clickAdd()
									.NotificationsPage()
									.setNotificationName(NotificationName)
									.setNotificationsCriteria("MY CRITERIA")
									.clickWhenAccord()
									.setNotifyIn("5")
									.selectWhenFormat(1)
									.setWhenDaysTillExpiration("1")
									.selectWhenOccurance(3)
									.clickWhoRecipientsAccord()
									.DataTable()
									.clickAdd()
									.WhoAccord()
									.selectType(1)
									.setUser("USER, SELENIUM")
									.clickComplete()
									.WhoAccord()
									.clickMessageContent()
									.selectMessageContentType(1)
									.setMessageContentValue(NotificationName)
									.GetSource()
									.SetConditionsAccord()
									.setType(DataFixForm)
									.setPage(DataFixForm)
									.setQuestion("1000032010")
									.selectAnswer(1)
									.selectFormat(9)	
									.clickSetConditionsAdd()
									.clickSubmitExit()
									.clickGoBackToList()
									.NavigationMenuBar()
									.clickPeople()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphics()
									.clickSubmit()
									.clickPopupOk()
									.NavigationMenuBar()
									.clickAssessmentForms()
									.clickAdd()
									.Assessment_FormsPage()
									.selectAssessmentType(DataFixFormV2Assessment)
									.setTitle(NotificationName)
									.clickStartAssessment()
									.fillForm()
									.clickSubmitAllPages()
									.GetSource()
									.SeleniumHelper()
									.sleep(6)
									.GetSource()
									.FormPage()
									.clickGoBackToPeople()
									.GetSource()
									.NavigationMenuBar()
									.clickMyHomePage()
									.GetSource()
									.SeleniumHelper()
									.sleep(360)
									.refreshPage()
									.ifWebElementExists(Source.MyHomePage().MyInboxFirstResultNameValue);
					
					if(ActualB == true) {
						Expected = NotificationName;
						Actual = Source
								.MyHomePage()
								.readMyInboxFirstResultNameValue();
						SoftAssert.assertEquals(Actual, Expected);
						
						Expected = FullDateRegEx;
						Actual = Source	.MyHomePage()
										.readMyInboxFirstResultDateValue();
						SoftAssert.assertTrue(Actual.matches(Expected));
						
						Expected = OnlyDateRegEx;
						Actual = Source	.MyHomePage()
										.clickMyInboxFirstResultID()
										.readNotificationDate();
						SoftAssert.assertTrue(Actual.matches(Expected));
					}
					
					
					Actual = Source	.NavigationMenuBar()
									.clickAdministrator()
									.clickNotifications()
									.readFirstResultNameType();
					
					if(Actual.equalsIgnoreCase(NotificationName)) {
						Source	.NotificationsPage()
								.clickFirstRow();
										
					}else {
						Source	.NotificationsPage()
								.clickSecondRow();
					}
					
					Actual = Source	.NotificationsPage()
									.clickEdit()
									.SeleniumHelper()
									.sleep(4)
									.GetSource()
									.NotificationsPage()
									.readActiveToggleBtn();
					
					if(Actual.equalsIgnoreCase("true")) {
						Source	.NotificationsPage()
								.clickActiveToggle()
								.clickSubmitExit()
								.clickGoBackToList();
					}

					SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
	}
	
	

