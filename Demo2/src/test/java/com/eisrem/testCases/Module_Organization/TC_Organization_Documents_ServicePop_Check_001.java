package com.eisrem.testCases.Module_Organization;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.ServicePopulations;
import com.eisrem.Hooks.OrganizationPage;


public class TC_Organization_Documents_ServicePop_Check_001 extends OrganizationPage{
	
	@Test(priority=1)
	public void TC_Organization_Documents_ServicePop_Check() {
		
		SoftAssert = new SoftAssert();

		String username = "OIT" + SeleniumHelper.generateRandomAlpha(10);
		String docUser = "BEGIN INSERT INTO EISPH.USER_REC (USER_ID,ORG_ID,STRT_DT,END_DT,DESCR,TERM_DT,EMP_DT,F_NME,L_NME,EMAL,TITL,TEL_NMBR,SPRVSR,USERNAME,PASSWORD,ACCOUNTNONEXPIRED,ACCOUNTNONLOCKED,CREDENTIALSNONEXPIRED,ENABLED,STAFF_FLAG,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,PASSWORD_UPDATED_DATE,PASSWORD_UPDATED_BY,PASSWORD_EXPIRATION_DATE,STATE_STAFF_FLAG,LST_LGN_DT) values (EISPH.USER_REC_ID.NEXTVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,null,null,'MAT','CAUTHON','roy.sawyer@maine.gov',null,null,null,'" + username + "','$2a$10$YqHK1ZUdbXGfxgG9YHNR.eDJkTAf/BGkUWBWOal25kX/usprLejr6',1,1,1,1,'Y',to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),540958,to_date('DEC-20 14:00:35','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:55:01','MON-RR HH24:MI:SS'),1,to_date('DEC-29 12:55:01','MON-RR HH24:MI:SS'),'Y',to_date('DEC-20 12:55:37','MON-RR HH24:MI:SS'));"
			+ "	Insert into EISPH.USR_X_ROLE (USER_X_ROLE_ID,USER_ID,ROLE_ID,STRT_DT,END_DT,DESCR,CRTD_DT,CRTD_BY,UPTD_DT,UPTD_BY,ACTV_FLAG,RCRD_SRCE) values (EISPH.USER_X_ROLE_ID.NEXTVAL,EISPH.USER_REC_ID.CURRVAL,1,to_date('DEC-20 00:00:00','MON-RR HH24:MI:SS'),null,null,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,to_date('DEC-20 12:47:54','MON-RR HH24:MI:SS'),1,'Y',null);"
			+ " Insert into EISPH.USER_ATTEMPTS (ID,USERNAME,ATTEMPTS,LASTMODIFIED) values (EISPH.USER_ATTEMPTS_ID.nextval,'" + username + "',0,SYSDATE); END;;";


		try{
			//Create an active user with no service population
			SeleniumHelper.log.info("Creating new user to work with no service populaion");
			try
			{
				Source.DBConnect().executeScript(docUser);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		   SeleniumHelper.log.info("Read error message");
		   Expected = "User must have at least one service population to upload documents.";
	       Actual = Source		
		    		    .NavigationMenuBar()	
		    		    .clickWelcomeUser()
	    		   		.clickLogout()
	    		   		.GetSource()
	    		   		.LogInPage()	
			            .setUserName(username)
			            .setPassword("Spring17#")
			            .clickSignIn()
			            .GetSource()
			            .NavigationMenuBar()
						.clickOrganization()
			            .DataTable()
						.setSearch(OrgDHHS)
						.clickFirstColumnLink()
						.clickAnchor()
						.OrganizationNavigator()
	                    .clickDocuments()
	                    .clickAdd()
	                    .DocumentsPage()
	                    .setTitle(DocumentName)
						.setDocumentFile(DocumentPath, DocumentFile)
						.clickAdd()
						.DocumentsUserPage()
						.setUser(UserFullName)
						.clickComplete()
						.DocumentsPage()
						.clickSubmit()
						.readTopErrorMessage(2);
	       
	       SoftAssert.assertEquals(Actual, Expected);
	       SoftAssert.assertAll();	
			                    
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	 }

   }
}