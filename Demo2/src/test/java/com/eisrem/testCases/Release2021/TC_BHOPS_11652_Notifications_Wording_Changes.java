package com.eisrem.testCases.Release2021;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11652_Notifications_Wording_Changes extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_Notifications_Wording_Changes_001() {
		
		SoftAssert = new SoftAssert();

		try{
					SeleniumHelper.log.info("Adding condition with format Is Edited & verifying successful addition of criteria");
					Expected = "When Type: 1000075916 Data Fix Form (V2)/ Assessment Page: 1000007696 DATA FIX FORM (V2) Question: 1000032010 Agency Name/ TEXT FIELD (80 VARCHARACTERS) TYPE/ANSWER IS EDITED";
					Actual = Source	.AdministratorNavigator()
									.clickNotifications()
									.clickAdd()
									.SetConditionsAccord()
									.setType(DataFixForm)
									.setPage(DataFixForm)
									.setQuestion("Agency Name")
									.selectFormat(NotificationFormat.IS_EDITED.getName())
									.clickSetConditionsAdd()
									.readSearchCriteria(1);
					SoftAssert.assertEquals(Actual, Expected);
					Source.SeleniumHelper().printResultIfFailed(Actual, Expected);

					SeleniumHelper.log.info("Adding condition with format Is Entered & verifying successful addition of criteria");
					Expected = "AND When Type: 1000075916 Data Fix Form (V2)/ Assessment Page: 1000007696 DATA FIX FORM (V2) Question: 1000032010 Agency Name/ TEXT FIELD (80 VARCHARACTERS) TYPE/ANSWER IS ENTERED";
					Actual = Source	.SetConditionsAccord()
									.setType(DataFixForm)
									.setPage(DataFixForm)
									.setQuestion("Agency Name")
									.selectFormat(NotificationFormat.IS_ENTERED.getName())
									.clickSetConditionsAdd()
									.readSearchCriteria(2);
					SoftAssert.assertEquals(Actual, Expected);
					Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
					
					SeleniumHelper.log.info("Adding condition with format Was Edited & verifying successful addition of criteria");
					Expected = "AND When Type: 1000075916 Data Fix Form (V2)/ Assessment Page: 1000007696 DATA FIX FORM (V2) Question: 1000032010 Agency Name/ TEXT FIELD (80 VARCHARACTERS) TYPE/ANSWER WAS EDITED";
					Actual = Source	.SetConditionsAccord()
									.setType(DataFixForm)
									.setPage(DataFixForm)
									.setQuestion("Agency Name")
									.selectFormat(NotificationFormat.WAS_EDITED.getName())
									.clickSetConditionsAdd()
									.readSearchCriteria(3);
					SoftAssert.assertEquals(Actual, Expected);
					Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
					
					SeleniumHelper.log.info("Adding condition with format Was Entered & verifying successful addition of criteria");
					Expected = "AND When Type: 1000075916 Data Fix Form (V2)/ Assessment Page: 1000007696 DATA FIX FORM (V2) Question: 1000032010 Agency Name/ TEXT FIELD (80 VARCHARACTERS) TYPE/ANSWER WAS ENTERED";
					Actual = Source	.SetConditionsAccord()
									.setType(DataFixForm)
									.setPage(DataFixForm)
									.setQuestion("Agency Name")
									.selectFormat(NotificationFormat.WAS_ENTERED.getName())
									.clickSetConditionsAdd()
									.readSearchCriteria(4);
					SoftAssert.assertEquals(Actual, Expected);
					Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
					
					SeleniumHelper.log.info("Adding condition with format Contains & verifying successful addition of criteria");
					Expected = "AND When Type: 1000075916 Data Fix Form (V2)/ Assessment Page: 1000007696 DATA FIX FORM (V2) Question: 1000032010 Agency Name/ TEXT FIELD (80 VARCHARACTERS) CONTAINS (TEXT AREA/NARRATIVE) null";
					Actual = Source	.SetConditionsAccord()
									.setType(DataFixForm)
									.setPage(DataFixForm)
									.setQuestion("Agency Name")
									.selectFormat(NotificationFormat.CONTAINS.getName())
									.clickSetConditionsAdd()
									.readSearchCriteria(5);
					SoftAssert.assertEquals(Actual, Expected);
					Source.SeleniumHelper().printResultIfFailed(Actual, Expected);

					SeleniumHelper.log.info("Removing all but Contains ");
					Source.SeleniumHelper().scrollToBottom();
					while(Source.SeleniumHelper().getSelectSize(Source.SetConditionsAccord().SearchCriteriaTextBox)>1)
						Source.SetConditionsAccord().clickSetConditionsRemove(1);
					
					SeleniumHelper.log.info("Selecting When Occurance and validating");
					List<String> occuranceType = new ArrayList<String>();
					for(NotificationWhenOccurance ot : NotificationWhenOccurance.values())
						occuranceType.add(ot.getName());
					System.out.println(occuranceType);
					Source			.NotificationsPage()
									.clickWhenAccord()
									.GetSource()
									.SeleniumHelper()
									.verifyAndClickAllDropDown(Source.WhenAccord().readOccurance(), occuranceType, true);

					SeleniumHelper.log.info("Confirming Notification Description");
					Expected = "Notification Description: *";
					Actual = Source	.NotificationsPage()
									.readCriteriaTitle();
					SoftAssert.assertEquals(Actual, Expected);
					Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
					
					SeleniumHelper.log.info("Confirming Notify In");
					Expected = "Notify In *";
					Actual = Source	.WhenAccord()
									.readFrequencyTitle();
					SoftAssert.assertEquals(Actual, Expected);
					Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
					
					SeleniumHelper.log.info("Confirming Days Till Expiration (Inbox)");
					Expected = "Days Till Expiration (Inbox) *";
					Actual = Source	.WhenAccord()
									.readDaysTillExpirationTitle();
					SoftAssert.assertEquals(Actual, Expected);
					Source.SeleniumHelper().printResultIfFailed(Actual, Expected);
					
					SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
		
}
	
	

