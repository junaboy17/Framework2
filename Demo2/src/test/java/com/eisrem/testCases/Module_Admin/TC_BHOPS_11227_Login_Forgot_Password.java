package com.eisrem.testCases.Module_Admin;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.LogInPage;

public class TC_BHOPS_11227_Login_Forgot_Password extends LogInPage {
	
	@Test(priority=1)
	public void TC_Login_Forgot_Password_001() {
		SoftAssert = new SoftAssert();
		
		String passwordHash = "$2a$10$fafJj2/MB8oZbfZGG/64u.I3arrKBZnNberAbvVF8jvYjttLC/FJm"; //Spring17#
		String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		
		String insertOITFORGOTTENPASSWORD = "BEGIN INSERT INTO EISPH.USER_REC (USER_ID,ORG_ID,STRT_DT,END_DT,DESCR,TERM_DT,EMP_DT,F_NME,L_NME,EMAL,TITL,TEL_NMBR,SPRVSR,USERNAME,PASSWORD,ACCOUNTNONEXPIRED,ACCOUNTNONLOCKED,CREDENTIALSNONEXPIRED,ENABLED,STAFF_FLAG,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,PASSWORD_UPDATED_DATE,PASSWORD_UPDATED_BY,PASSWORD_EXPIRATION_DATE,STATE_STAFF_FLAG,LST_LGN_DT) values (EISPH.USER_REC_ID.NEXTVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,null,null,'MAT','CAUTHON','roy.sawyer@maine.gov',null,null,null, '" + username + "','" + passwordHash + "',1,1,1,1,'Y',SYSDATE,540958,SYSDATE,1,SYSDATE,1,SYSDATE+90,'Y',SYSDATE);"
				+ "	Insert into EISPH.USR_X_ROLE (USER_X_ROLE_ID,USER_ID,ROLE_ID,STRT_DT,END_DT,DESCR,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,ACTV_FLAG,RCRD_SRCE) values (EISPH.USER_X_ROLE_ID.NEXTVAL,EISPH.USER_REC_ID.CURRVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,'Y',null);"
				+ " Insert into EISPH.USER_ATTEMPTS (ID,USERNAME,ATTEMPTS,LASTMODIFIED) values (EISPH.USER_ATTEMPTS_ID.nextval,'" + username + "',0,SYSDATE); END;;";
		
		try {
		
			SeleniumHelper.log.info("OITFORGOTTENPASSWORD exists - Getting resultset to confirm account status and resetting appropriate columns");
			try
			{
				Source.DBConnect().executeScript(insertOITFORGOTTENPASSWORD);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			SeleniumHelper.log.info("Confirm Navigation to Forgot Password");	
			Expected = "Reset Forgotten Password\nfor EIS.";
			Actual = Source		.LogInPage()	
								.clickForgotPassword()
								.GetSource()
								.ForgotPasswordPage()
								.readForgotPasswordTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Navigation To Success Screen");
			Expected = "Successful Reset";
			Actual = Source		.ForgotPasswordPage()	
								.setUsername(username, EmptyString)
								.setVerificationCodeOnScreen()
								.clickEmailMeMyForgottenPasswordBtn()
								.readSuccessMessageHeader();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Success Message text");
			Expected = "An email has been sent to the user on file with the new temporary password. On first logon, you will be prompted to change your password. If you do not receive an email within the next 10 minutes, please contact:";
			Actual = Source		.ForgotPasswordPage()
								.readSuccessMessage();
			SoftAssert.assertEquals(Actual, Expected);
	
			SeleniumHelper.log.info("Confirm Navigation and Error for no email");	
			Expected = "Invalid email. Please contact the appropriate Admin Staff to reset your password and provide an updated email address:\n"
					+ "Childrens: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n"
					+ "EIS.OBH@maine.gov";
			Actual = Source		.ForgotPasswordPage()
								.clickbackToLogin()
								.GetSource()
								.LogInPage()	
								.clickForgotPassword()
								.GetSource()
								.ForgotPasswordPage()
								.clickbackToLogin()
								.GetSource()
								.LogInPage()
								.clickForgotPassword()
								.GetSource()
								.ForgotPasswordPage()
								.setUsername(SeleniumHelper.generateRandomAlpha(7), EmptyString)
								.setVerificationCodeOnScreen()
								.clickEmailMeMyForgottenPasswordBtn()
								.errorMessage();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Confirm Navigation To Login");	
			Expected = "Login";
			Actual = Source		.ForgotPasswordPage()
								.clickbackToLogin()
								.GetSource()
								.LogInPage()
								.readLogInTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}	
}	
	

