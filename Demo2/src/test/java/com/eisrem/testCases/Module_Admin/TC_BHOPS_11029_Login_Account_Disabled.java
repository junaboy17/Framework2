package com.eisrem.testCases.Module_Admin;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.LogInPage;

public class TC_BHOPS_11029_Login_Account_Disabled extends LogInPage {
	
	@Test(priority=1)
	public void Types_Add_PopupCheck() {
		
		SoftAssert = new SoftAssert();
		String selectUserRecQuery = "Select * from EISPH.USER_REC where USERNAME='OITDISABLEDACCOUNT'";
		String selectUserRoleQuery = "Select * from eisph.usr_x_role where user_id in (select user_id from eisph.user_rec where username = 'OITDISABLEDACCOUNT')";
		
		String insertQuery = "BEGIN Insert into eisph.USER_REC (USER_ID,ORG_ID,STRT_DT,END_DT,DESCR,TERM_DT,EMP_DT,F_NME,L_NME,EMAL,TITL,TEL_NMBR,SPRVSR,USERNAME,PASSWORD,ACCOUNTNONEXPIRED,ACCOUNTNONLOCKED,CREDENTIALSNONEXPIRED,ENABLED,STAFF_FLAG,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,PASSWORD_UPDATED_DATE,PASSWORD_UPDATED_BY,PASSWORD_EXPIRATION_DATE,STATE_STAFF_FLAG,LST_LGN_DT) values "
				+ "(EISPH.USER_REC_ID.NEXTVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),SYSDATE,null,null,null,'SELENIUM_USER_DISABLED_FIRST','SELENIUM_USER_DISABLED_LAST','aravind.basireddy@maine.gov',null,null,null,'OITDISABLEDACCOUNT','$2a$10$YqHK1ZUdbXGfxgG9YHNR.eDJkTAf/BGkUWBWOal25kX/usprLejr6',0,1,1,0,'N',to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),540958,to_date('DEC-20 14:00:35','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:55:01','MON-RR HH24:MI:SS'),1,to_date('MAR-19 12:55:01','MON-RR HH24:MI:SS'),'Y',to_date('DEC-20 12:55:37','MON-RR HH24:MI:SS'));"
				+ "Insert into EISPH.USR_X_ROLE (USER_X_ROLE_ID,USER_ID,ROLE_ID,STRT_DT,END_DT,DESCR,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,ACTV_FLAG,RCRD_SRCE) values (EISPH.USER_X_ROLE_ID.NEXTVAL,EISPH.USER_REC_ID.CURRVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,'Y',null); END;;";

		try{
			
			SeleniumHelper.log.info("Verifying if OITDISABLEDACCOUNT exist");
			if(Source.DBConnect().executeHasResultSetQuery(selectUserRecQuery))
			{
			}
			else
			{
				SeleniumHelper.log.info("OITDISABLEDACCOUNT does not exist in user_rec table and is being created");
				Source.DBConnect().executeScript(insertQuery);

			}

			SeleniumHelper.log.info("Executing sql querry & Verifying End Today is Not Null for current User");
			Expected = "[]";
			Actual = Source		.DBConnect()
								.getData("Select * from EISPH.USER_REC where USERNAME='OITDISABLEDACCOUNT'", "END_DT").toString();
			SoftAssert.assertFalse(Actual.contains(Expected));
			
			SeleniumHelper.log.info("Executing sql querry & Verifying Enabled column = 0 for current User");
			Expected = "[0]";
			Actual = Source		.DBConnect()
								.getData("Select * from EISPH.USER_REC where USERNAME='OITDISABLEDACCOUNT'", "ENABLED").toString();
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = "[N]";
			Actual = Source		.DBConnect()
								.getData("Select * from EISPH.USER_REC where USERNAME='OITDISABLEDACCOUNT'", "STAFF_FLAG").toString();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Logging in with User that has been end dated & verifying error message");	
			Expected = "Username is no longer active. Please have your supervisor submit the Adding/Editing/Ending Users form in EIS to request access.";
			Actual = Source		.LogInPage()	
								.setUserName("OITDISABLEDACCOUNT")
								.setPassword("Spring17#")
								.clickSignIn()
								.GetSource()
								.LogInPage()
								.readErrorMessage();
			SoftAssert.assertEquals(Actual, Expected);
					
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
		
	}
	
	

