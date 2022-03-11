package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Role_Questions_Add_Role extends AdministratorPage{
	@Test(priority=1)
	public void Role_Question_Add_Role_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Adding a new Role and verifying Success");
			Expected = Success;
			Actual = Source   	.AdministratorNavigator()
								.clickPages()
								.setSearch("selenium")
								.clickFirstRow()
								.clickEdit()
								.DataTable()
								.clickRow("section_table", 1)
								.clickEdit()
								.DataTable()
								.clickRow("row_table", 1)
								.GetSource()
								.RowsAvailableAccord()
								.clickRowEdit()
								.GetSource()
								.QuestionsAvailableAccord()
								.clickQAAdd()
								.selectQuestionType(12)
								.setQuestionLabel("Selenium Question")
								.setSortOrder("1")
								.GetSource()
								.RolesAvailableAccord()
								.clickRolesAdd()
								.selectRole(3)
								.clickRolesComplete()
								.QuestionsAvailableAccord()
								.clickQASave()
								.GetSource()
								.SeleniumHelper()
								.sleep(5)
								.GetSource()
								.RowsAvailableAccord()
								.clickSubmitExit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}