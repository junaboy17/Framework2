package com.eisrem.testCases.Module_Administrator.Add;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;


public class AddRolePageTest extends AdministratorPage{


	@Test(priority=1)
	public void AddRolePageTitlesCheck() {
		SoftAssert = new SoftAssert();

		try{		
		SeleniumHelper.log.info("Verifying 'Add Role' page title");
		Expected ="Add Role";
		Actual = Source		.AdministratorNavigator()
							.clickRoles()
							.DataTable()
							.clickAdd()
							.RolesPage()
							.readAddRolePageTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Note' title");
		Expected ="Note: * indicates required field.";
		Actual = Source		.RolesPage()
							.readNoteTitle();
		SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Verifying 'Roles Info' link title");
		Expected ="Role Info:";
		Actual = Source		.RolesPage()
							.readRoleInfoAccord();
		SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Verifying 'Role Info Start Date' title");
		Expected ="Start Date *";
		Actual = Source		.RolesPage()
							.readStartDateTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Role Info End Date' title");
		Expected ="End Date";
		Actual = Source		.RolesPage()
							.readEndDateTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Role Info Name' title");
		Expected = "Role Name *";
		Actual = Source		.RolesPage()
							.readRoleNameTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Role Info Active' btn title");
		Expected = "Active?";
		Actual = Source		.Pagefactory()
							.readActiveTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Role Info Active default value");
		Expected = True;
		Actual = Source		.Pagefactory()
							.readActiveToggle();
		SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Verifying 'Role Info Description' title");
		Expected ="Role Description";
		Actual = Source		.RolesPage()
							.readRoleDescriptionTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Role Info View All Clients' btn title");
		Expected ="View All Clients?";
		Actual = Source		.RolesPage()
							.readViewAllClientsToggleTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Role Info View All Clients default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readViewAllClientsToggle();
		SoftAssert.assertEquals(Actual, Expected);
	
		SeleniumHelper.log.info("Verifying 'App Area' link title");
		Expected ="App Area:";
		Actual = Source		.RolesPage()
							.clickAppAreaAccord()
							.readAppAreaLink();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying ' App Area Show entries' title");
		Expected ="Show\n"
				+ "10\n"
				+ "25\n"
				+ "50\n"
				+ "100\n"
				+ "entries";
		Actual = Source		.RolesPage()
							.readAppAreaShowEntriesTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Area App Name' list title");
		Expected = "App Name";
		Actual = Source		.RolesPage()
							.readAppAreaAppNameList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Area Active' list title");
		Expected = "Active";
		Actual = Source		.RolesPage()
							.readAppAreaActiveList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Administrator' title");
		Expected = AdministratorApp;
		Actual = Source		.RolesPage()
							.readAdministratorAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Administrator default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(AdministratorApp);
				SoftAssert.assertEquals(Actual, Expected);
		
		
		SeleniumHelper.log.info("Verifying 'App Name Agreement' title");
		Expected = AgreementApp;
		Actual = Source		.RolesPage()
							.readAgreementAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
				
		SeleniumHelper.log.info("Verifying 'App Name Agreement default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(AgreementApp);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name AssessmentForms' title");
		Expected = Assessment_FormsApp;
		Actual = Source		.RolesPage()
							.readAssessmentFormsAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name AssessmentForms default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(Assessment_FormsApp);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Authorization' title");
		Expected = AuthorizationApp;
		Actual = Source		.RolesPage()
							.readAuthorizationAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Authorization default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(AuthorizationApp);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Classes' title");
		Expected = ClassesApp;
		Actual = Source		.RolesPage()
							.readClassesAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Classes default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(ClassesApp);
		SoftAssert.assertEquals(Actual, Expected);	
		
		SeleniumHelper.log.info("Verifying 'App Name My Homepage' title");
		Expected = My_HomepageApp;
		Actual = Source		.RolesPage()
							.readMyHomepageAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name My Homepage default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(My_HomepageApp);
		SoftAssert.assertEquals(Actual, Expected);			
		
		SeleniumHelper.log.info("Verifying 'App Name Notes' title");
		Expected = NotesApp;
		Actual = Source		.RolesPage()
							.readNotesAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Notes default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(NotesApp);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Organization' title");
		Expected = OrganizationApp;
		Actual = Source		.RolesPage()
							.readOrganizationAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Organization default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(OrganizationApp);
		SoftAssert.assertEquals(Actual, Expected);
		
		
		SeleniumHelper.log.info("Verifying 'App Name People' title");
		Expected = PeopleApp;
		Actual = Source		.RolesPage()
							.readPeopleAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name People default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(PeopleApp);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Planning' title");
		Expected = PlanningApp;
		Actual = Source		.RolesPage()
							.readPlanningAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Planning default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(PlanningApp);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Process Wizard' title");
		Expected = Process_WizardApp;
		Source		.DataTable().clickPageTab3();
		Actual = Source		.RolesPage()	
							.readProcessWizardAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Process Wizard default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(Process_WizardApp);
		SoftAssert.assertEquals(Actual, Expected);
		
		
		SeleniumHelper.log.info("Verifying 'App Name Quick Links' title");
		Expected = Quick_LinksApp;
		Actual = Source		.RolesPage()
							.readQuickLinksAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Quick Links default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(Quick_LinksApp);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Reportable Event' title");
		Expected = Reportable_EventApp;
		Actual = Source		.RolesPage()
							.readReportableEventAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Reportable Event default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(Reportable_EventApp);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Reports' title");
		Expected = ReportsApp;
		Actual = Source		.RolesPage()
							.readReportsAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Reports default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(ReportsApp);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Search' title");
		Expected = SearchApp;
		Actual = Source		.RolesPage()
							.readSearchAppTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Name Search default value");
		Expected = False;
		Actual = Source		.RolesPage()
							.readAppToggle(SearchApp);
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Area Previous' btn title");
		Expected = "Previous";
		Actual = Source		.RolesPage()
							.readAppAreaPreviousBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Area Next' btn title");
		Expected = "Next";
		Actual = Source		.RolesPage()
							.readAppAreaNextBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Area Modules' link title");
		Expected ="App Area Modules:";
		Actual = Source		.RolesPage()
							.clickAppAreaModulesAccord()
							.readAppAreaModulesLink();
		SoftAssert.assertEquals(Actual, Expected);	
		
		SeleniumHelper.log.info("Verifying 'App Area Modules App Area' list title");
		Expected = "App Area";
		Actual = Source		.RolesPage()
							.readAppAreaModulesAppAreaList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Area Modules Modules' list title");
		Expected = "Modules";
		Actual = Source		.RolesPage()
							.readAppAreaModulesModulesList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Area Modules Active' list title");
		Expected = "Active";
		Actual = Source		.RolesPage()
							.readAppAreaModulesActiveList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Area Modules Add' list title");
		Expected = "Add";
		Actual = Source		.RolesPage()
							.readAppAreaModulesAddList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Area Modules View' list title");
		Expected = "View";
		Actual = Source		.RolesPage()
							.readAppAreaModulesViewList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Area Modules Edit' list title");
		Expected = "Edit";
		Actual = Source		.RolesPage()
							.readAppAreaModulesEditList();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Area Modules Previous' btn title");
		Expected = "Previous";
		Actual = Source		.RolesPage()
							.readAppAreaModulesPreviousBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'App Area Modules Next' btn title");
		Expected = "Next";
		Actual = Source		.RolesPage()
							.readAppAreaModulesNextBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Submit' btn title");
		Expected = "Submit";
		Actual = Source		.RolesPage()
							.readSubmitBtn();
		SoftAssert.assertEquals(Actual, Expected);	
		
		SeleniumHelper.log.info("Verifying 'Print' btn title");
		Expected = "Print";
		Actual = Source		.RolesPage()
							.readPrintBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Back To Roles' btn title");
		Expected = "Back To Roles";
		Actual = Source		.RolesPage()
							.readBackToRolesBtn();
				SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying 'Copyright' title");
		Expected = "Copyright © " + CopyRightYear + " State of Maine DHHS.\n"
						+ "All Rights Reserved.";
		Actual = Source		.DataTable()
							.readCopyright();
			SoftAssert.assertEquals(Actual, Expected);	
		
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	}
	
}