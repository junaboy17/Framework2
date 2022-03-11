package com.eisrem.testCases.Module_Admin;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.DBConnect;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.LogInPage;

public class TC_BHOPS_11227_Login_Bad_Credentials extends LogInPage {
	
	@Test(priority=1)
	public void TC_Login_Bad_Credentials_001() {
		
		//In case it was altered reset flags
		String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
			String insertOitBadCredentials = "BEGIN INSERT INTO EISPH.USER_REC (USER_ID,ORG_ID,STRT_DT,END_DT,DESCR,TERM_DT,EMP_DT,F_NME,L_NME,EMAL,TITL,TEL_NMBR,SPRVSR,USERNAME,PASSWORD,ACCOUNTNONEXPIRED,ACCOUNTNONLOCKED,CREDENTIALSNONEXPIRED,ENABLED,STAFF_FLAG,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,PASSWORD_UPDATED_DATE,PASSWORD_UPDATED_BY,PASSWORD_EXPIRATION_DATE,STATE_STAFF_FLAG,LST_LGN_DT) values (EISPH.USER_REC_ID.NEXTVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,null,null,'MAT','CAUTHON','roy.sawyer@maine.gov',null,null,null,'" + username + "','$2a$10$YqHK1ZUdbXGfxgG9YHNR.eDJkTAf/BGkUWBWOal25kX/usprLejr6',1,1,1,1,'Y',to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),540958,to_date('DEC-20 14:00:35','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:55:01','MON-RR HH24:MI:SS'),1,to_date('DEC-29 12:55:01','MON-RR HH24:MI:SS'),'Y',to_date('DEC-20 12:55:37','MON-RR HH24:MI:SS'));"
				+ "	Insert into EISPH.USR_X_ROLE (USER_X_ROLE_ID,USER_ID,ROLE_ID,STRT_DT,END_DT,DESCR,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,ACTV_FLAG,RCRD_SRCE) values (EISPH.USER_X_ROLE_ID.NEXTVAL,EISPH.USER_REC_ID.CURRVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,'Y',null);"
				+ " Insert into EISPH.USER_ATTEMPTS (ID,USERNAME,ATTEMPTS,LASTMODIFIED) values (EISPH.USER_ATTEMPTS_ID.nextval,'" + username + "',0,SYSDATE); END;;";

		SoftAssert = new SoftAssert();
		
		try{
			try
			{
				Source.DBConnect().executeScript(insertOitBadCredentials);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			SeleniumHelper.log.info("Logging in with User that has incorrect credentials & verifying error message. First Attempt");	
			Expected = "Invalid username or password. Click Here for instructions for log in assistance.";
			Actual = Source		.LogInPage()	
								.setUserName(username)
								.setPassword(RandAlpha1)
								.clickSignIn()
								.GetSource()
								.LogInPage()
								.readErrorMessage();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Logging in with User that has incorrect credentials & verifying error message. Second Attempt");
			Expected = "Invalid username or password. Click Here for instructions for log in assistance.";
			Actual = Source		.LogInPage()	
								.setUserName(username)
								.setPassword(RandAlpha1)
								.clickSignIn()
								.GetSource()
								.LogInPage()
								.readErrorMessage();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Logging in with User that has incorrect credentials & verifying error message. Third Attempt");
			Expected = "Invalid username or password. Click Here for instructions for log in assistance. If you continue to have trouble with logging in please contact:\n"
					+ "Childrens: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n"
					+ "OBH: EIS.OBH@maine.gov";
			Actual = Source		.LogInPage()	
								.setUserName(username)
								.setPassword(RandAlpha1)
								.clickSignIn()
								.GetSource()
								.LogInPage()
								.readErrorMessage();
			SoftAssert.assertEquals(Actual, Expected);
			
			
			SeleniumHelper.log.info("Click link to login assistance and navigate to page");
			Expected = "Login Assistance\n"
					+ "for EIS.";
			Actual = Source		.LogInPage()
								.clickLoginAssistance()
								.GetSource()
								.LoginAssistance()
								.readLogInTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Return to login page");
			Expected = "Login Assistance";
			Actual = Source		.LoginAssistance()
								.clickBackToLogin()
								.GetSource()
								.LogInPage()
								.readLogInTitle();
						
			SoftAssert.assertAll();		
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}
	
		
}
	
	

