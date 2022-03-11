package com.eisrem.testCases.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;

public class TC_Role_Add_Edit_View extends AdministratorPage{

	@Test(priority=1)
	public void TC_Role_Add_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("Adding a new Role and verifiying Success");
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
								.setSearch(AdministratorApp)
								.GetSource()
								.RolesPage()
								.clickAppToggle(AdministratorApp, True)
								.clickAppAreaModulesAccord()
								.setSearchAppAreaModules("Types")
								.clickModuleToggle("Types", Active, True)
								.clickModuleToggle("Types", Add, True)
								.clickModuleToggle("Types", View, True)
								.clickModuleToggle("Types", Edit, True)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying Role was created successfully");
			Expected = RoleName.toUpperCase();
			Actual = Source   	.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.setSearch(RoleName)
								.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying Role is active and all permissions are granted");
			Expected = True;
			Actual = Source   	.DataTable()
								.clickFirstRow()
								.clickEdit()
								.RolesPage()
								.clickAppAreaAccord()
								.setSearchAppArea(AdministratorApp)
								.readAppToggle(AdministratorApp);
			SoftAssert.assertEquals(Actual, Expected);

			Expected = True;
			Actual = Source   	.RolesPage()
								.clickAppAreaModulesAccord()
								.setSearchAppAreaModules("Types")
								.readModuleToggle("Types", Active);								
			SoftAssert.assertEquals(Actual, Expected);

			Expected = True;
			Actual = Source   	.RolesPage()
								.readModuleToggle("Types", Add);								
			SoftAssert.assertEquals(Actual, Expected);

			Expected = True;
			Actual = Source   	.RolesPage()
								.readModuleToggle("Types", View);								
			SoftAssert.assertEquals(Actual, Expected);

			Expected = True;
			Actual = Source   	.RolesPage()
								.readModuleToggle("Types", Edit);								
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}


	@Test(priority=2)
	public void TC_Role_Edit_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("test");
			Expected = Success;
			String Name = Source   	.AdministratorNavigator()
									.clickRoles()
									.readFirstResultNameType();

			Actual = Source		.DataTable()
								.clickFirstRow()
								.clickEdit()
								.RolesPage()
								.setEndDate(FutureDate6)
								.setDescription(UpdateDescription, Clear)
								.GetSource()
								.RolesPage()
								.clickAppAreaAccord()
								.setSearch(AdministratorApp)
								.GetSource()
								.RolesPage()
								.clickAppToggle(AdministratorApp, True)
								.clickAppAreaModulesAccord()
								.setSearchAppAreaModules("Types")
								.clickModuleToggle("Types", Active, True)
								.clickModuleToggle("Types", Add, True)
								.clickModuleToggle("Types", View, True)
								.clickModuleToggle("Types", Edit, True)
								.clickSubmit()
								.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("test");
			Expected = True;
			Actual = Source		.Pagefactory()
								.clickPopupOk()
								.DataTable()
								.setSearch(Name)
								.clickFirstRow()
								.clickEdit()
								.RolesPage()
								.clickAppAreaAccord()
								.setSearchAppArea(AdministratorApp)
								.readAppToggle(AdministratorApp);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected = True;
			Actual = Source   	.RolesPage()
								.clickAppAreaModulesAccord()
								.setSearchAppAreaModules("Types")
								.readModuleToggle("Types", Active);								
			SoftAssert.assertEquals(Actual, Expected);

			Expected = True;
			Actual = Source   	.RolesPage()
								.readModuleToggle("Types", Add);								
			SoftAssert.assertEquals(Actual, Expected);

			Expected = True;
			Actual = Source   	.RolesPage()
								.readModuleToggle("Types", View);								
			SoftAssert.assertEquals(Actual, Expected);

			Expected = True;
			Actual = Source   	.RolesPage()
								.readModuleToggle("Types", Edit);								
			SoftAssert.assertEquals(Actual, Expected);
						
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=2)
	public void TC_Role_View_001() {		
		SoftAssert = new SoftAssert();

		try{	
			SeleniumHelper.log.info("test");
			Expected = True;
			Actual = Source		.AdministratorNavigator()
								.clickRoles()
								.clickFirstRow()
								.clickView()
								.SeleniumHelper().getAttribute(Source.RolesPage().RoleNameTextbox, Disabled);
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("test");
			Expected = True;
			Actual = Source		.SeleniumHelper().getAttribute(Source.Pagefactory().DescriptionTextBox, Disabled);
			SoftAssert.assertEquals(Actual, Expected);
									
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}

}