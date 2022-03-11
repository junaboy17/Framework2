package com.eisrem.testCases.Module_Admin;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.LogInPage;

public class TC_Login_Error_Messages extends LogInPage{

	@Test(priority=1)
	public void TC_Login_Error_Messages_001() {
		SoftAssert = new SoftAssert();
		
		String OITEXPIREDACCOUNTWEMAIL = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		String OITEXPIREDACCOUNTNOEMAIL = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		String OITLOCKEDACCOUNT = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		
		String insertOITEXPIREDACCOUNTWEMAIL = "BEGIN Insert into EISPH.USER_REC (USER_ID,ORG_ID,STRT_DT,END_DT,DESCR,TERM_DT,EMP_DT,F_NME,L_NME,EMAL,TITL,TEL_NMBR,SPRVSR,USERNAME,PASSWORD,ACCOUNTNONEXPIRED,ACCOUNTNONLOCKED,CREDENTIALSNONEXPIRED,ENABLED,STAFF_FLAG,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,PASSWORD_UPDATED_DATE,PASSWORD_UPDATED_BY,PASSWORD_EXPIRATION_DATE,STATE_STAFF_FLAG,LST_LGN_DT) values (EISPH.USER_REC_ID.NEXTVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,null,null,'MAT','CAUTHON','roy.sawyer@maine.gov',null,null,null,'" + OITEXPIREDACCOUNTWEMAIL +"','$2a$10$YqHK1ZUdbXGfxgG9YHNR.eDJkTAf/BGkUWBWOal25kX/usprLejr6',0,1,1,1,'Y',to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),540958,to_date('DEC-20 14:00:35','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:55:01','MON-RR HH24:MI:SS'),1,to_date('MAR-19 12:55:01','MON-RR HH24:MI:SS'),'Y',to_date('DEC-20 12:55:37','MON-RR HH24:MI:SS'));"
			+ "	Insert into EISPH.USR_X_ROLE (USER_X_ROLE_ID,USER_ID,ROLE_ID,STRT_DT,END_DT,DESCR,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,ACTV_FLAG,RCRD_SRCE) values (EISPH.USER_X_ROLE_ID.NEXTVAL,EISPH.USER_REC_ID.CURRVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,'Y',null);"
			+ " Insert into EISPH.USER_ATTEMPTS (ID,USERNAME,ATTEMPTS,LASTMODIFIED) values (EISPH.USER_ATTEMPTS_ID.nextval,'" + OITEXPIREDACCOUNTWEMAIL + "',0,SYSDATE); END;;";
		
		String insertOITEXPIREDACCOUNTNOEMAIL = "BEGIN Insert into EISPH.USER_REC (USER_ID,ORG_ID,STRT_DT,END_DT,DESCR,TERM_DT,EMP_DT,F_NME,L_NME,EMAL,TITL,TEL_NMBR,SPRVSR,USERNAME,PASSWORD,ACCOUNTNONEXPIRED,ACCOUNTNONLOCKED,CREDENTIALSNONEXPIRED,ENABLED,STAFF_FLAG,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,PASSWORD_UPDATED_DATE,PASSWORD_UPDATED_BY,PASSWORD_EXPIRATION_DATE,STATE_STAFF_FLAG,LST_LGN_DT) values (EISPH.USER_REC_ID.NEXTVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,null,null,'MAT','CAUTHON',null,null,null,null,'" + OITEXPIREDACCOUNTNOEMAIL +"','$2a$10$YqHK1ZUdbXGfxgG9YHNR.eDJkTAf/BGkUWBWOal25kX/usprLejr6',0,1,1,1,'Y',to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),540958,to_date('DEC-20 14:00:35','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:55:01','MON-RR HH24:MI:SS'),1,to_date('MAR-20 12:55:01','MON-RR HH24:MI:SS'),'Y',to_date('DEC-20 12:55:37','MON-RR HH24:MI:SS'));"
				+ "	Insert into EISPH.USR_X_ROLE (USER_X_ROLE_ID,USER_ID,ROLE_ID,STRT_DT,END_DT,DESCR,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,ACTV_FLAG,RCRD_SRCE) values (EISPH.USER_X_ROLE_ID.NEXTVAL,EISPH.USER_REC_ID.CURRVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,'Y',null);"
				+ " Insert into EISPH.USER_ATTEMPTS (ID,USERNAME,ATTEMPTS,LASTMODIFIED) values (EISPH.USER_ATTEMPTS_ID.nextval,'" + OITEXPIREDACCOUNTNOEMAIL + "',0,SYSDATE); END;;";

		String insertOITLOCKEDACCOUNT = "BEGIN Insert into EISPH.USER_REC (USER_ID,ORG_ID,STRT_DT,END_DT,DESCR,TERM_DT,EMP_DT,F_NME,L_NME,EMAL,TITL,TEL_NMBR,SPRVSR,USERNAME,PASSWORD,ACCOUNTNONEXPIRED,ACCOUNTNONLOCKED,CREDENTIALSNONEXPIRED,ENABLED,STAFF_FLAG,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,PASSWORD_UPDATED_DATE,PASSWORD_UPDATED_BY,PASSWORD_EXPIRATION_DATE,STATE_STAFF_FLAG,LST_LGN_DT) values (EISPH.USER_REC_ID.NEXTVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,null,null,'MAT','CAUTHON','roy.sawyer@maine.gov',null,null,null,'" + OITLOCKEDACCOUNT +"','$2a$10$YqHK1ZUdbXGfxgG9YHNR.eDJkTAf/BGkUWBWOal25kX/usprLejr6',1,0,1,1,'Y',to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),540958,to_date('DEC-20 14:00:35','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:55:01','MON-RR HH24:MI:SS'),1,to_date('DEC-29 12:55:01','MON-RR HH24:MI:SS'),'Y',to_date('DEC-20 12:55:37','MON-RR HH24:MI:SS'));"
				+ "	Insert into EISPH.USR_X_ROLE (USER_X_ROLE_ID,USER_ID,ROLE_ID,STRT_DT,END_DT,DESCR,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,ACTV_FLAG,RCRD_SRCE) values (EISPH.USER_X_ROLE_ID.NEXTVAL,EISPH.USER_REC_ID.CURRVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,'Y',null);"
				+ " Insert into EISPH.USER_ATTEMPTS (ID,USERNAME,ATTEMPTS,LASTMODIFIED) values (EISPH.USER_ATTEMPTS_ID.nextval,'" + OITLOCKEDACCOUNT + "',4,SYSDATE); END;;";

		try
		{
			Source.DBConnect().executeScript(insertOITEXPIREDACCOUNTWEMAIL);
			Source.DBConnect().executeScript(insertOITEXPIREDACCOUNTNOEMAIL);
			Source.DBConnect().executeScript(insertOITLOCKEDACCOUNT);
		}catch (Exception e) {
			e.printStackTrace();
		}

		try {
			SeleniumHelper.log.info("test");
			Expected = "An email has been sent to your email with next steps to reactivate your account.";
			Actual = Source		.LogInPage()
								.setUserName(OITEXPIREDACCOUNTWEMAIL)
								.setPassword("Spring17#")
								.clickSignIn()
								.GetSource()
								.LogInPage()
								.readErrorMessage();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("test2");
			Expected = "Have your supervisor submit the \"Adding/Editing/Ending User's\" form in EIS to approve your password reset.\n"
					+ "For instructions go to this link: Enterprise Information System | Department of Health and Human Services";
			Actual = Source		.LogInPage()
								.setUserName(OITEXPIREDACCOUNTNOEMAIL, Clear)
								.setPassword("Spring17#", Clear)
								.clickSignIn()
								.GetSource()
								.LogInPage()
								.readErrorMessage();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("test3");
			Expected = "User account is locked! Try the Forgotten Password link below.\n\n"
					+ "Username : " + OITLOCKEDACCOUNT + "\n"
					+ "Last Attempts : "+ SeleniumHelper.dateCustom("yyyy-MM-dd") + "\n\n"
					+ "Please contact the appropriate Admin Staff:\n"
					+ "Childrens: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n"
					+ "OBH: EIS.OBH@maine.gov";
			Actual = Source		.LogInPage()
								.setUserName(OITLOCKEDACCOUNT, Clear)
								.setPassword("Spring17#", Clear)
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
