package com.eisrem.testCases.Module_Administrator;

import org.codehaus.plexus.DuplicateChildContainerException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Role_Name_Caps extends AdministratorPage{
	@Test(priority=1)
	public void TC_Role_Name_Caps_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Adding a Role and verifying success message");
			Expected = Success;
			Actual = Source   	.AdministratorNavigator()
								.clickRoles()
								.clickAdd()
								.RolesPage()
								.setRoleName(RoleName)
								.setDescription(Description)
								.GetSource()
								.RolesPage()
								.clickAppAreaAccord()
								.clickAppToggle(AdministratorApp, True)
								.clickAppAreaModulesAccord()
								.clickModuleToggle("Types", Active, True)
								.clickModuleToggle("Types", Add, True)
								.clickModuleToggle("Types", View, True)
								.clickModuleToggle("Types", Edit, True)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying the record name is in uppercase");
			Expected = RoleName.toUpperCase();
			Actual = Source   	.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.setSearch(RoleName)
								.readFirstResultNameType();								
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}