package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;


public class TC_BHOPS_11462_Notifications_Occurance extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_Notifications_Occurance_001() {
		
		SoftAssert = new SoftAssert();
		int RandNum4 = SeleniumHelper.generateRandomNumber(4);
		String Was_Submitted_Answer = "Notification Answer was Submitted" + RandNum4;
		String Was_Created_Answer = "Notification Answer was Created" + RandNum4;
		String Was_Submitted_Type = "Notification Type was Submitted" + RandNum4;
		String Was_Created_Type = "Notification Type was Created" + RandNum4;
		String Page_Type_Name = "TC_Notifications_Occurance_001." + RandNum4;
		String Question = "Question" + RandNum4;

		try{
					SeleniumHelper.log.info("Creating page & type");
					
					ID = Source		.AdministratorNavigator()
									.clickPages()
									.clickAdd()
									.PagesPage()
									.setPageName(Page_Type_Name)
									.clickAdd()
									.SectionsAvailableAccord()
									.setSectionName(Page_Type_Name)
									.setSortOrder(OneN)
									.GetSource()
									.RowsAvailableAccord()
									.clickRowAdd()
									.setRowName(Page_Type_Name)
									.setSortOrder(OneN)
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(13)
									.setQuestionLabel(Page_Type_Name)
									.setSortOrder(OneN)
									.clickQASave()
									.clickPopupOk()
									.RowsAvailableAccord()
									.clickRowsBack()
									.clickSectionsBack()
									.clickLockForUseToggle(True)
									.clickYes()
									.PagesPage()
									.clickSubmitExit()
									.clickPopupOk()
									.AdministratorNavigator()
									.clickTypes()
									.clickAdd()
									.TypesPage()
									.setName(Page_Type_Name)
									.selectAppModule(AppModule.ASSESSMENT.getIndex())
									.selectAppAreaToConductType(AppAreaConductType.PEOPLE.getIndex())
									.selectLockTime(LockTime.NEVER.getIndex())
//									.setEndDate(Tomorrow, "Y")
									.clickAdd()
									.PagesAvailableAccord()
									.setPage(Page_Type_Name)
									.setSortOrder(OneN)
									.GetSource()
									.RolesAvailableAccord()
									.clickRolesAdd()
									.selectRole(Roles.ALLAPPS.getName())
									.clickRolesComplete()
									.ServicePopulationsAvailableAccord()
									.clickServicePopulationAvailableAccord()
									.clickSpAdd()
									.selectServicePopulation(ServicePopulations.CHILDRENS.getIndex())
									.clickSpComplete()
									.TypesPage()
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.TypesPage()
									.clickLockForUseToggle(True)
									.clickYes()
									.TypesPage()
									.clickSubmitExit()
									.clickPopupOk()
									.DataTable()
									.setSearch(Page_Type_Name)
									.readFirstResultID()
									.replace("Select", EmptyString)
									.replace(" ", EmptyString);
									
					SeleniumHelper.log.info("Creating 4 different notification with 4 different instance");				
					
							Source	.AdministratorNavigator()
									.clickNotifications()
									.DataTable()
									.clickAdd()
									.NotificationsPage()
									.setNotificationName(Was_Created_Answer)
									.setNotificationsCriteria(Was_Created_Answer)
									.setEndDate(Tomorrow, "Y")
									.GetSource()
									.SetConditionsAccord()
									.setType(Page_Type_Name)
									.setPage(Page_Type_Name)
									.setQuestion(Question)
									.selectFormat(NotificationFormat.WAS_ENTERED.getIndex())
									.setValue(ZeroN)
									.clickSetConditionsAdd()
									.setType(Page_Type_Name)
									.setPage(Page_Type_Name)
									.setQuestion(Question)
									.selectFormat(NotificationFormat.CONTAINS.getIndex())
									.setValue(Was_Created_Answer)
									.clickSetConditionsAdd()
									.clickWhenAccord()
//									.setNotifyIn(FiveN)
//									.selectWhenFormat(NotificationWhenFormat.MINUTES.getIndex())
									.setWhenDaysTillExpiration(OneN)
									.clickWhoRecipientsAccord()
									.DataTable()
									.clickAdd()
									.WhoAccord()
									.selectType(1)
									.setUser("USER, SELENIUM")
									.clickComplete()
									.NotificationsPage()
									.clickMessageContent()
									.selectMessageContentType(1)
									.setMessageContentValue(Was_Created_Answer)
									.clickSubmitExit()
									.clickGoBackToList()
									.DataTable()
									.clickAdd()
									.NotificationsPage()
									.setNotificationName(Was_Submitted_Answer)
									.setNotificationsCriteria(Was_Submitted_Answer)
									.setEndDate(Tomorrow, "Y")
									.GetSource()
									.SetConditionsAccord()
									.setType(Page_Type_Name)
									.setPage(Page_Type_Name)
									.setQuestion(Question)
									.selectFormat(NotificationFormat.WAS_ENTERED.getIndex())
									.setValue(ZeroN)
									.clickSetConditionsAdd()
									.setType(Page_Type_Name)
									.setPage(Page_Type_Name)
									.setQuestion(Question)
									.selectFormat(NotificationFormat.CONTAINS.getIndex())
									.setValue(Was_Submitted_Answer)
									.clickSetConditionsAdd()
									.clickWhenAccord()
//									.setNotifyIn(FiveN)
//									.selectWhenFormat(NotificationWhenFormat.MINUTES.getIndex())
									.setWhenDaysTillExpiration(OneN)
									.clickWhoRecipientsAccord()
									.DataTable()
									.clickAdd()
									.WhoAccord()
									.selectType(1)
									.setUser("USER, SELENIUM")
									.clickComplete()
									.NotificationsPage()
									.clickMessageContent()
									.selectMessageContentType(1)
									.setMessageContentValue(Was_Submitted_Answer)
									.clickSubmitExit()
									.clickGoBackToList()
									.DataTable()
									.clickAdd()
									.NotificationsPage()
									.setNotificationName(Was_Created_Type)
									.setNotificationsCriteria(Was_Created_Type)
									.setEndDate(Tomorrow, "Y")
									.GetSource()
									.SetConditionsAccord()
									.setType(Page_Type_Name)
									.setPage(Page_Type_Name)
									.setQuestion(Question)
									.selectFormat(NotificationFormat.CONTAINS.getIndex())
									.setValue(Was_Created_Type)
									.clickSetConditionsAdd()
									.clickWhenAccord()
//									.setNotifyIn(FiveN)
//									.selectWhenFormat(NotificationWhenFormat.MINUTES.getIndex())
									.setWhenDaysTillExpiration(OneN)
									.selectWhenOccurance(2)
									.setDaysAfterOccurance(ZeroN)
									.clickWhoRecipientsAccord()
									.DataTable()
									.clickAdd()
									.WhoAccord()
									.selectType(1)
									.setUser("USER, SELENIUM")
									.clickComplete()
									.NotificationsPage()
									.clickMessageContent()
									.selectMessageContentType(1)
									.setMessageContentValue(Was_Created_Type)
									.clickSubmitExit()
									.clickGoBackToList()
									.DataTable()
									.clickAdd()
									.NotificationsPage()
									.setNotificationName(Was_Submitted_Type)
									.setNotificationsCriteria(Was_Submitted_Type)
									.setEndDate(Tomorrow, "Y")
									.GetSource()
									.SetConditionsAccord()
									.setType(Page_Type_Name)
									.setPage(Page_Type_Name)
									.setQuestion(Question)
									.selectFormat(NotificationFormat.CONTAINS.getIndex())
									.setValue(Was_Submitted_Type)
									.clickSetConditionsAdd()
									.clickWhenAccord()
//									.setNotifyIn(FiveN)
//									.selectWhenFormat(NotificationWhenFormat.MINUTES.getIndex())
									.setWhenDaysTillExpiration(OneN)
									.selectWhenOccurance(1)
									.setDaysAfterOccurance(ZeroN)
									.clickWhoRecipientsAccord()
									.DataTable()
									.clickAdd()
									.WhoAccord()
									.selectType(1)
									.setUser("USER, SELENIUM")
									.clickComplete()
									.NotificationsPage()
									.clickMessageContent()
									.selectMessageContentType(1)
									.setMessageContentValue(Was_Submitted_Type)
									.clickSubmitExit()
									.clickGoBackToList();
							
				SeleniumHelper.log.info("Submitting 'Was Submitted Answer' Assessment & verifying if notification was received");
							
				ActualB = Source	.NavigationMenuBar()
									.clickPeople()
									.AddPeople()
									.GetSource()
									.NavigationMenuBar()
									.clickAssessmentForms()
									.clickAdd()
									.Assessment_FormsPage()
									.selectAssessmentType(Page_Type_Name + "/ Assessment")
									.setTitle(Was_Submitted_Answer)
									.clickStartAssessment()
									.setQuestion1(Was_Submitted_Answer, "Y")
									.clickSubmitAllPages()
									.clickGoBackToList()
									.NavigationMenuBar()
									.clickMyHomePage()
									.GetSource()
									.SeleniumHelper()
									.sleep(360)
									.refreshPage()
									.Wait(2)
									.GetSource()
									.MyHomePage()
									.setSearchMyInbox("Answer was Submitted")
									.GetSource()
									.SeleniumHelper()
									.ifWebElementExists(Source.MyHomePage().MyInboxFirstResultNameValue);
					
					if(ActualB == true) {
							Expected = Was_Submitted_Answer;
							Actual = Source
									.MyHomePage()
									.readMyInboxFirstResultNameValue();
							SoftAssert.assertEquals(Actual, Expected);

					}else {
						SoftAssert.assertTrue(false, Was_Submitted_Answer + ": Notification was not found in Inbox");
					}
					
					SeleniumHelper.log.info("Submitting 'Was Created Answer' Assessment & verifying if notification was received");
					
					ActualB = Source	.NavigationMenuBar()
										.clickPeople()
										.AddPeople()
										.GetSource()
										.NavigationMenuBar()
										.clickAssessmentForms()
										.clickAdd()
										.Assessment_FormsPage()
										.selectAssessmentType(Page_Type_Name + "/ Assessment")
										.setTitle(Was_Created_Answer)
										.clickStartAssessment()
										.setQuestion1(Was_Created_Answer, "Y")
										.clickSubmitAllPages()
										.clickGoBackToList()
										.NavigationMenuBar()
										.clickMyHomePage()
										.GetSource()
										.SeleniumHelper()
										.sleep(360)
										.refreshPage()
										.Wait(2)
										.GetSource()
										.MyHomePage()
										.setSearchMyInbox("Answer was Created")
										.GetSource()
										.SeleniumHelper()
										.ifWebElementExists(Source.MyHomePage().MyInboxFirstResultNameValue);

					
					if(ActualB == true) {
						Expected = Was_Created_Answer;
						Actual = Source
								.MyHomePage()
								.readMyInboxFirstResultNameValue();
						SoftAssert.assertEquals(Actual, Expected);
		
					}else {
						SoftAssert.assertTrue(false, Was_Created_Answer + ": Notification was not found in Inbox");
					}
					
					SeleniumHelper.log.info("Submitting 'Was Created Type' Assessment & verifying if notification was received");
					
					ActualB = Source	.NavigationMenuBar()
										.clickPeople()
										.AddPeople()
										.GetSource()
										.NavigationMenuBar()
										.clickAssessmentForms()
										.clickAdd()
										.Assessment_FormsPage()
										.selectAssessmentType(Page_Type_Name + "/ Assessment")
										.setTitle(Was_Created_Type)
										.clickStartAssessment()
										.setQuestion1(Was_Created_Type, "Y")
										.clickSubmitAllPages()
										.clickGoBackToList()
										.NavigationMenuBar()
										.clickMyHomePage()
										.GetSource()
										.SeleniumHelper()
										.sleep(360)
										.refreshPage()
										.Wait(2)
										.GetSource()
										.MyHomePage()
										.setSearchMyInbox("Type was Created")
										.GetSource()
										.SeleniumHelper()
										.ifWebElementExists(Source.MyHomePage().MyInboxFirstResultNameValue);

						if(ActualB == true) {
							Expected = Was_Created_Type;
							Actual = Source
									.MyHomePage()
									.readMyInboxFirstResultNameValue();
							SoftAssert.assertEquals(Actual, Expected);
				
						}else {
							SoftAssert.assertTrue(false, Was_Created_Type + ": Notification was not found in Inbox");
						}
						
						SeleniumHelper.log.info("Submitting 'Was Submitted Type' Assessment & verifying if notification was received");
		
						ActualB = Source	.NavigationMenuBar()
											.clickPeople()
											.AddPeople()
											.GetSource()
											.NavigationMenuBar()
											.clickAssessmentForms()
											.clickAdd()
											.Assessment_FormsPage()
											.selectAssessmentType(Page_Type_Name + "/ Assessment")
											.setTitle(Was_Submitted_Type)
											.clickStartAssessment()
											.setQuestion1(Was_Submitted_Type, "Y")
											.clickSubmitAllPages()
											.clickGoBackToList()
											.NavigationMenuBar()
											.clickMyHomePage()
											.GetSource()
											.SeleniumHelper()
											.sleep(360)
											.refreshPage()
											.Wait(2)
											.GetSource()
											.MyHomePage()
											.setSearchMyInbox("Type was Submitted")
											.GetSource()
											.SeleniumHelper()
											.ifWebElementExists(Source.MyHomePage().MyInboxFirstResultNameValue);
				
							if(ActualB == true) {
							Expected = Was_Submitted_Type;
							Actual = Source
									.MyHomePage()
									.readMyInboxFirstResultNameValue();
							SoftAssert.assertEquals(Actual, Expected);
							
							}else {
								SoftAssert.assertTrue(false, Was_Submitted_Type + ": Notification was not found in Inbox");
							}


					SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
	}
	
	

