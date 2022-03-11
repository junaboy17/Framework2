package com.eisrem.testCases.Release2021;

import java.sql.SQLException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.DBConnect;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.LogInPage;

public class TC_BHOPS_11849_Forgot_Password_Page_Error_Msg extends LogInPage {
	
	@Test(priority=1)
	public void TC_Login_Forgot_Password_001() {
		SoftAssert = new SoftAssert();
		String username = "OITFPEXPIREDACCOUNT";
		
		String insertOITFORGOTTENPASSWORD = "BEGIN Insert into eisph.USER_REC (USER_ID,ORG_ID,STRT_DT,END_DT,DESCR,TERM_DT,EMP_DT,F_NME,L_NME,EMAL,TITL,TEL_NMBR,SPRVSR,USERNAME,PASSWORD,ACCOUNTNONEXPIRED,ACCOUNTNONLOCKED,CREDENTIALSNONEXPIRED,ENABLED,STAFF_FLAG,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,PASSWORD_UPDATED_DATE,PASSWORD_UPDATED_BY,PASSWORD_EXPIRATION_DATE,STATE_STAFF_FLAG,LST_LGN_DT) values "
				+ "(EISPH.USER_REC_ID.NEXTVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),SYSDATE,null,null,null,'SELENIUM_USER_EXPIREDFP_FIRST','SELENIUM_USER_EXPIREDFP_LAST','roy.sawyer@maine.gov',null,null,null,'OITFPEXPIREDACCOUNT','$2a$10$YqHK1ZUdbXGfxgG9YHNR.eDJkTAf/BGkUWBWOal25kX/usprLejr6',0,1,1,1,'N',to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),540958,to_date('DEC-20 14:00:35','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:55:01','MON-RR HH24:MI:SS'),1,to_date('MAR-19 12:55:01','MON-RR HH24:MI:SS'),'Y',to_date('DEC-20 12:55:37','MON-RR HH24:MI:SS'));"
				+ "Insert into EISPH.USR_X_ROLE (USER_X_ROLE_ID,USER_ID,ROLE_ID,STRT_DT,END_DT,DESCR,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,ACTV_FLAG,RCRD_SRCE) values (EISPH.USER_X_ROLE_ID.NEXTVAL,EISPH.USER_REC_ID.CURRVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,'Y',null);"
				+ " END;;";
		
		try {
			/*
			SeleniumHelper.log.info("OITFPEXPIREDACCOUNT exists - Getting resultset to confirm account status and resetting appropriate columns");
			try
			{
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.USER_ATTEMPTS WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%'");
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.USER_PASSWORD_HISTORY WHERE USER_ID IN (SELECT USER_ID FROM EISPH.USER_REC WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%')");
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.USR_X_ROLE WHERE USER_ID IN (SELECT USER_ID FROM EISPH.USER_REC WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%')");
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.usr_x_srvce_ppltn WHERE USER_ID IN (SELECT USER_ID FROM EISPH.USER_REC WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%')");
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.usr_x_bse_loc WHERE USER_ID IN (SELECT USER_ID FROM EISPH.USER_REC WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%')");
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.usr_x_addtnl_loc WHERE USER_ID IN (SELECT USER_ID FROM EISPH.USER_REC WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%')");
				DBConnect.connect().createStatement().executeQuery("DELETE FROM EISPH.USER_REC WHERE USERNAME LIKE '%OITFPEXPIREDACCOUNT%'");
				Source.DBConnect().executeScript(insertOITFORGOTTENPASSWORD);
			}catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}catch (Exception e) {
				e.printStackTrace();
			}
			*/
			
			
			SeleniumHelper.log.info("Confirm Navigation to Forgot Password");	
			Expected = "Reset Forgotten Password\nfor EIS.";
			Actual = Source		.LogInPage()	
								.clickForgotPassword()
								.GetSource()
								.ForgotPasswordPage()
								.readForgotPasswordTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("EXPIRED ACCOUNT EMAIL");
			Expected = "EXPIRED ACCOUNT EMAIL";
			Actual = Source		.ForgotPasswordPage()	
								.setUsername(username, EmptyString)
								.setVerificationCodeOnScreen()
								.clickEmailMeMyForgottenPasswordBtn()
								.readSuccessMessageHeader();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("An email has been sent to your email on file with the next steps to reactivate your account.");
			Expected = "An email has been sent to your email on file with the next steps to reactivate your account.";
			Actual = Source		.ForgotPasswordPage()	
								.readSuccessMessage();
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();
					
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
		
	}	
}	
	

