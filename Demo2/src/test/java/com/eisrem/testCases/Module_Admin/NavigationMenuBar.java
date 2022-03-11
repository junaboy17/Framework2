package com.eisrem.testCases.Module_Admin;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;


public class NavigationMenuBar extends MyHomePage{

	@Test(priority=1)
	public void AppAreasTitle() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying App Areas title text");
		Expected = "App Areas";
		Actual = Source.NavigationMenuBar().readAppAreasTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=2)
	public void MyHomePageLink() {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Verifying My Home Page link text");
		Expected = "MY HOMEPAGE";
		Actual = Source.NavigationMenuBar().readMyHomePageTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying My Home Page link function");
		Source				.NavigationMenuBar()
							.clickMyHomePage();

		Expected = "My Home Page";
		Actual = Source.MyHomePage().readMyHomePageTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=3)
	public void ReportsLink() {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Verifying Reports link text");
		Expected = "REPORTS";
		Actual = Source.NavigationMenuBar().readReports();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Reports link function");
		Source				.NavigationMenuBar()
							.clickReports();

		Expected = "Reports";
		Actual = Source.ReportsPage().readReportsTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}

	@Test(priority=4)
	public void ProcessWizardLink() {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Verifying Process Wizard link text");
		Expected = "PROCESS WIZARD";
		Actual = Source.NavigationMenuBar().readProcessWizardTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=5)
	public void PeopleLink() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying People link text");
		Expected = "PEOPLE";
		Actual = Source.NavigationMenuBar().readPeopleTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying People link function");
		Source				.NavigationMenuBar()
							.clickPeople();

		Expected = "People";
		Actual = Source.PeopleNavigator().readPeopleTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=6)
	public void OrganizationLink() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Organization link text");
		Expected = "ORGANIZATION";
		Actual = Source.NavigationMenuBar().readOrganizationTitle();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Organization link function");
		Source				.NavigationMenuBar()
							.clickOrganization();

		Expected = "Organizations";
		Actual = Source.OrganizationPage().readOrganizationsTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=7)
	public void AssessmentFormsLink() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Assessment/Forms link text");
		Expected = "ASSESSMENT/FORMS";
		Actual = Source.NavigationMenuBar().readAssessmentFormsLink();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=8)
	public void AuthorizationLink() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Authorization link text");
		Expected = "AUTHORIZATION";
		Actual = Source.NavigationMenuBar().readAuthorization();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	

	@Test(priority=9)
	public void NotesLink() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Notes link text");
		Expected = "NOTES";
		Actual = Source.NavigationMenuBar().readNotesLink();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=10)
	public void PlanningLink() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Planning link text");
		Expected = "PLANNING";
		Actual = Source.NavigationMenuBar().readPlanningLink();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=11)
	public void ReportableEventLink() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Reportable event link text");
		Expected = "REPORTABLE EVENT";
		Actual = Source.NavigationMenuBar().readReportableEventLink();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	

	@Test(priority=12)
	public void SearchLink() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Search link text");
		Expected = "SEARCH";
		Actual = Source.NavigationMenuBar().readSearchLink();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Search link function");
		Source				.NavigationMenuBar()
							.clickSearch();

		Expected = "Search";
		Actual = Source.SearchPage().readSearchBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=13)
	public void AgreementLink() {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Verifying Agreement link text");
		Expected = "AGREEMENT";
		Actual = Source.NavigationMenuBar().readAgreementLink();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Agreement link function");
		Source				.NavigationMenuBar()
							.clickAgreement();

		Expected = "Agreement";
		Actual = Source.AgreementPage().readAgreementTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=14)
	public void ClassesLink() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Classes link text");
		Expected = "CLASSES";
		Actual = Source.NavigationMenuBar().readClassesLink();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Classes link function");
		Source				.NavigationMenuBar()
							.clickClasses();

		Expected = "Classes";
		Actual = Source.ClassesPage().readClassesTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=15)
	public void QuickLink() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Quick Links link text");
		Expected = "QUICK LINKS";
		Actual = Source.NavigationMenuBar().readQuickLinksLink();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Quick Links function");
		Source				.NavigationMenuBar()
							.clickQuickLinks();

		Expected = "Quick Links";
		Actual = Source.QuickLinksNavigator().readQuickLinksTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=16)
	public void AdministratorLink() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Administrator Links link text");
		Expected = "ADMINISTRATOR";
		Actual = Source.NavigationMenuBar().readAdministratorLink();
		SoftAssert.assertEquals(Actual, Expected);

		SeleniumHelper.log.info("Verifying Administrator function");
		Source				.NavigationMenuBar()
							.clickAdministrator();

		Expected = "Types";
		Actual = Source.TypesPage().readTypesTab();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
}
