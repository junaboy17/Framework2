package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;


public class TC_BHOPS_11859_Notifications_Equal_Value extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_BHOPS_11859_Notifications_Equal_Value_001() {
		
		SoftAssert = new SoftAssert();
		int RandNum4 = SeleniumHelper.generateRandomNumber(4);
		String Page_Type_Name = "TC_BHOPS_11859_Notifications_Equal_Value." + RandNum4;
		String Lookup_Question = "LuQuestion" + RandNum4;
		String Date_Question = "DaQuestion" + RandNum4;
		String Select_Question = "SeQuestion" + RandNum4;

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
									.selectQuestionType(QuestionType.USER_LOOKUP.getName())
									.setQuestionLabel(Lookup_Question)
									.setSortOrder(OneN)
									.clickQASave()
									.clickPopupOk()
									.RowsAvailableAccord()
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(QuestionType.DATE_FIELD.getName())
									.setQuestionLabel(Date_Question)
									.setSortOrder(OneN)
									.clickQASave()
									.clickPopupOk()
									.RowsAvailableAccord()
									.GetSource()
									.QuestionsAvailableAccord()
									.clickQAAdd()
									.selectQuestionType(QuestionType.CHOICE_BOX.getName())
									.setQuestionLabel(Select_Question)
									.setSortOrder(OneN)
									.setAnswerValue(1, "A", "Y")
									.clickAddValueAnswer()
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
									.selectAppModule(AppModule.NOTES.getIndex())
									.selectAppAreaToConductType(AppAreaConductType.PEOPLE.getIndex())
									.selectLockTime(LockTime.NEVER.getIndex())
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
									
					SeleniumHelper.log.info("Creating notification with all three question types");				
					
							Source	.AdministratorNavigator()
									.clickNotifications()
									.DataTable()
									.clickAdd()
									.NotificationsPage()
									.setNotificationName(Page_Type_Name)
									.setNotificationsCriteria(Page_Type_Name)
									.setEndDate(Tomorrow, "Y")
									.GetSource()
									.SetConditionsAccord()
									//.setType(Page_Type_Name)
									//.setPage(Page_Type_Name)
									//.setQuestion(Lookup_Question)
									//.selectFormat(NotificationFormat.ANSWER_LOOKUP_VALUE_IS.getName())
									//.setValue("540958")
									//.clickSetConditionsAdd()
									.setType(Page_Type_Name)
									.setPage(Page_Type_Name)
									.setQuestion(Date_Question)
									.selectFormat(NotificationFormat.ANSWER_DATE_VALUE_IS.getName())
									.setValue(Today)
									.clickSetConditionsAdd()
									.setType(Page_Type_Name)
									.setPage(Page_Type_Name)
									.setQuestion(Select_Question)
									.selectAnswer(1)
									.selectFormat(NotificationFormat.ANSWER_IS_SELECTED.getName())
									.clickSetConditionsAdd()
									.clickWhenAccord()
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
									.setMessageContentValue(Page_Type_Name)
									.clickSubmitExit()
									.clickGoBackToList();
									
							
				SeleniumHelper.log.info("Submitting 'Was Submitted Answer' Assessment & verifying if notification was received");
							
				ActualB = Source	.NavigationMenuBar()
									.clickPeople()
									.AddPeople()
									.GetSource()
									.NavigationMenuBar()
									.clickNotes()
									.clickAdd()
									.NotesPage()
									.selectNotesType(Page_Type_Name + "/ Notes")
									.setTitle(Page_Type_Name)
									.clickStartNotes()
									//.setQuestion1("540958", "Y")
									.setQuestion2(Today, "Y")
									.setQuestion3("A", "Y")
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
									.setSearchMyInbox("TC_BHOPS_11859_Notifications_Equal")
									.GetSource()
									.SeleniumHelper()
									.ifWebElementExists(Source.MyHomePage().MyInboxFirstResultNameValue);
					
					if(ActualB == true) {
							Expected = Page_Type_Name;
							Actual = Source
									.MyHomePage()
									.readMyInboxFirstResultNameValue();
							SoftAssert.assertEquals(Actual, Expected);

					}else {
						SoftAssert.assertTrue(false, Page_Type_Name + ": Notification was not found in Inbox");
					}


					SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
	}
	
	

