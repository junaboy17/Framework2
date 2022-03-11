package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class People_CritInfo_Test extends PeoplePage {

	@Test(priority=1)
	public void CritInfo_Add_001() {

		SoftAssert = new SoftAssert();
		
		try{

			SeleniumHelper.log.info("Adding Critical Info and confirming success message");
			Expected =	Success;
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphics(FirstName, LastName, Enumerations.Gender.MALE, "05/16/1976")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickCriticalInformationTab()
									.clickAdd()
									.CriticalInformationPage()
									.selectType(1)
									.setDescription(Description)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Critical Info has been added successfully");
			Expected =	"Commissioner/Governor Involvement";
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
	public void CritInfo_Edit_001() {

		SoftAssert = new SoftAssert();
		
		try{

			SeleniumHelper.log.info("Adding Critical Info and confirming success message");
			Expected =	Success;
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphics(FirstName, LastName, Enumerations.Gender.MALE, "05/16/1976")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickCriticalInformationTab()
									.clickAdd()
									.CriticalInformationPage()
									.selectType(1)
									.setDescription(Description)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Critical Info has been added successfully");
			Expected =	"Commissioner/Governor Involvement";
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Editing Critical Information and verifying Success message");
			Expected =	Success;
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickEdit()
									.CriticalInformationPage()
									.setEndDate(Tomorrow)
									.GetSource()
									.CriticalInformationPage()
									.setDescription(UpdateDescription, Clear)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying End Date was changed successfully");
			Expected =	Tomorrow;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
	@Test(priority=3)
	public void CritInfo_View_001() {

		SoftAssert = new SoftAssert();
		
		try{

			SeleniumHelper.log.info("Adding Critical Info and confirming success message");
			Expected =	Success;
			Actual =	Source		.DataTable()
									.clickAdd()
									.DemographicsPage()
									.fillRequiredDemogrphics(FirstName, LastName, Enumerations.Gender.MALE, "05/16/1976")
									.clickSubmit()
									.clickPopupOk()
									.PeopleNavigator()
									.clickCriticalInformationTab()
									.clickAdd()
									.CriticalInformationPage()
									.selectType(1)
									.setDescription(Description)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying Critical Info has been added successfully");
			Expected =	"Commissioner/Governor Involvement";
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.readFirstResultNameType();
			SoftAssert.assertEquals(Actual, Expected);
			
			SeleniumHelper.log.info("Verifying fields in View cannot be edited");
			Expected =	True;
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickView()
									.SeleniumHelper().getWebElement(Source.Pagefactory().StartDateTextBox).getAttribute(Disabled);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	True;
			Actual =	Source		.SeleniumHelper().getWebElement(Source.Pagefactory().EndDateTextBox).getAttribute(Disabled);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	True;
			Actual =	Source		.SeleniumHelper().getWebElement(Source.CriticalInformationPage().TypeDropdown).getAttribute(Disabled);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	True;
			Actual =	Source		.SeleniumHelper().getWebElement(Source.CriticalInformationPage().DescriptionTextbox).getAttribute(Disabled);
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}
	
}
