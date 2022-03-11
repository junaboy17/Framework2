package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.Administrator.NotificationsPage;

public class TC_BHOPS_11443_Notifications_Criteria_Error_Message extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_Notifications_Criteria_Error_Message_001() {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Navigating to notificaiton, adding condition with all fields blank & verifying error message");
					Expected = "Missing values for Type and Format to create criteria.";
					Actual = Source	.AdministratorNavigator()
									.clickNotifications()
									.clickAdd()
									.NotificationsPage()
									.setNotificationsCriteria(DataFixForm)
									.GetSource()
									.SetConditionsAccord()
									.clickSetConditionsAdd()
									.readPopUpMessage();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Adding condition with type only & verifying error message");
					Expected = "Missing values for Format to create criteria.";
					Actual = Source	.Pagefactory()
									.clickPopupOk()
									.SetConditionsAccord()
									.setType(DataFixForm)
									.clickSetConditionsAdd()
									.readPopUpMessage();
					SoftAssert.assertEquals(Actual, Expected);
									
					SeleniumHelper.log.info("Adding condition with type, page, & verifying error message");
					Expected = "Missing values for Question to create criteria.";
					Actual = Source	.Pagefactory()
									.clickPopupOk()
									.SetConditionsAccord()
									.setPage(DataFixForm)
									.clickSetConditionsAdd()
									.readPopUpMessage();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Adding condition with type, page, question, & verifying error message");
					Expected = "Missing values for Format to create criteria.";
					Actual = Source	.Pagefactory()
									.clickPopupOk()
									.SetConditionsAccord()
									.setQuestion("Agency Name")
									.clickSetConditionsAdd()
									.readPopUpMessage();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Adding condition with format 'Is Related To antoher Type' with missig 2nd type");
					Expected = "Missing values for Type2 to create criteria.";
					Actual = Source	.Pagefactory()
									.clickPopupOk()
									.SetConditionsAccord()
									.selectFormat("IS RELATED TO ANOTHER CONDUCTED TYPE ID")
									.clickSetConditionsAdd()
									.readPopUpMessage();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Adding condition with type2 only, & verifying error message");
					Expected = "Missing values for Page2, Question2, Answer2, Format2 to create criteria.";
					Actual = Source	.Pagefactory()
									.clickPopupOk()
									.SetConditionsAccord()
									.setType2(DataFixFormV2)
									.clickSetConditionsAdd()
									.readPopUpMessage();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Adding condition with type2, page2, & verifying error message");
					Expected = "Missing values for Question2, Answer2, Format2 to create criteria.";
					Actual = Source	.Pagefactory()
									.clickPopupOk()
									.SetConditionsAccord()
									.setPage2(DataFixForm)
									.clickSetConditionsAdd()
									.readPopUpMessage();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Adding condition with type2, page2, question2, & verifying error message");
					Expected = "Missing values for Format2 to create criteria.";
					Actual = Source	.Pagefactory()
									.clickPopupOk()
									.SetConditionsAccord()
									.setQuestion2("Agency Name")
									.clickSetConditionsAdd()
									.readPopUpMessage();
					SoftAssert.assertEquals(Actual, Expected);
					
					SeleniumHelper.log.info("Adding condition with type 1, type 2, & verifying successful addition of criteria");
					Expected = "When Type: 1000075916 Data Fix Form (V2)/ Assessment Page: 1000007696 DATA FIX FORM (V2) Question: 1000032010 Agency Name/ TEXT FIELD (80 VARCHARACTERS) "
							+ "IS RELATED TO ANOTHER CONDUCTED TYPE ID 1000075916 Data Fix Form (V2)/ Assessment AND Page: 1000007696 DATA FIX FORM (V2) AND Question: "
							+ "1000032010 Agency Name/ TEXT FIELD (80 VARCHARACTERS) Answer: TYPE/ANSWER IS ENTERED";
					Actual = Source	.Pagefactory()
									.clickPopupOk()
									.SetConditionsAccord()
									.selectFormat2(NotificationFormat.IS_ENTERED.getName())
									.clickSetConditionsAdd()
									.readSearchCriteria();
					SoftAssert.assertEquals(Actual, Expected);


					SoftAssert.assertAll();
				
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
	}
	
	

