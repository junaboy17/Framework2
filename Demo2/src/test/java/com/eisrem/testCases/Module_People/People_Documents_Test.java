package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class People_Documents_Test extends PeoplePage {
	@Test(priority=1)
	public void Documents_Add_001() {

		SoftAssert = new SoftAssert();
		
		String TestTitle = "TEST" + SeleniumHelper.generateRandomNumber(4);

		try{

			SeleniumHelper.log.info("Adding a Document, assigning to a user, and verifying success");
			Expected = Success;
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickDocumentsTab()
									.clickAdd()
									.DocumentsPage()
									.setTitle(TestTitle)
									.setDocumentFile(DocumentPath, DocumentFile)
									.setDescription(Description, Clear)
									.DataTable()
									.clickAdd()
									.DocumentsUserPage()
									.setUser("user, selenium")
									.clickComplete()
									.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying new Document record was added Successfully");
			Expected = TestTitle;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}	
	
	@Test(priority=2)
	public void Documents_Edit_001() {

		SoftAssert = new SoftAssert();
		
		String TestTitle = "TEST" + SeleniumHelper.generateRandomNumber(4);

		try{

			SeleniumHelper.log.info("Adding a Document, assigning to a user, and verifying success");
			Expected = Success;
			
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickDocumentsTab()
									.clickAdd()
									.DocumentsPage()
									.setTitle(TestTitle)
									.setDocumentFile(DocumentPath, DocumentFile)
									.setDescription(Description, Clear)
									.DataTable()
									.clickAdd()
									.DocumentsUserPage()
									.setUser("user, selenium")
									.clickComplete()
									.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Verifying new Document was added Successfully");
			Expected = TestTitle;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Editing the Document record and verifying record was successfully edited");
			Expected = Success;
			Actual =	Source		.DataTable()
									.setSearch(TestTitle)
									.clickFirstRow()
									.clickEdit()
									.DocumentsPage()
									.setDescription(UpdateDescription, Clear)
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.DocumentsUserPage()
									.setEndDate(Today)
									.clickComplete()
									.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			Expected = Today;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.DataTable()
									.readDataTable("usersTable", 1, 4);
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}	
	
	@Test(priority=3)
	public void Documents_View_001() {

		SoftAssert = new SoftAssert();
		
		String TestTitle = "TEST" + SeleniumHelper.generateRandomNumber(4);

		try{
		
			SeleniumHelper.log.info("Adding a Document, assigning to a user, and verifying success");
			Expected = Success;
			
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickDocumentsTab()
									.clickAdd()
									.DocumentsPage()
									.setTitle(TestTitle)
									.setDocumentFile(DocumentPath, DocumentFile)
									.setDescription(Description, Clear)
									.DataTable()
									.clickAdd()
									.DocumentsUserPage()
									.setUser("user, selenium")
									.clickComplete()
									.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			Expected = TestTitle;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying fields in View are disabled");
			Expected = True;
			Actual =	Source		.DataTable()
									.setSearch(TestTitle)
									.clickFirstRow()
									.clickView()
									.SeleniumHelper().getAttribute(Source.Pagefactory().StartDateTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual =	Source		.SeleniumHelper().getAttribute(Source.Pagefactory().EndDateTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual =	Source		.SeleniumHelper().getAttribute(Source.DocumentsPage().TitleTextbox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = True;
			Actual =	Source		.SeleniumHelper().getAttribute(Source.Pagefactory().DescriptionTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickView()
									.SeleniumHelper().getAttribute(Source.DocumentsUserPage().DocumentUserStartDateTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual =	Source		.SeleniumHelper().getAttribute(Source.DocumentsUserPage().DocumentUserEndDateTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = True;
			Actual =	Source		.SeleniumHelper().getAttribute(Source.DocumentsUserPage().DocumentUserComboBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=4)
	public void Documents_ServicePop_Check_001() {

		SoftAssert = new SoftAssert();
	
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
							.clickPeople()
				            .DataTable()
							.setSearch(LastName)
							.clickFirstColumnLink()
							.clickAnchor()
							.PeopleNavigator()
		                    .clickDocumentsTab()
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