package com.eisrem.testCases.Business.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Enumerations;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class People_Associations_Fields_Required extends PeoplePage {

	@Test(priority=1)
	public void TC_Association_Fields_Required_001() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying Individual, Organization, and Service Population required fields in Associations");
			SeleniumHelper.log.info("Verifying Individual required field");
			Expected =	"Please enter a Individual";
			Actual =	Source			.DataTable()
										.clickFirstRow()
										.clickAnchor()
										.PeopleNavigator()
										.clickAssociationsTab()
										.clickAdd()
										.AssociationsPage()
										.selectAssociationType(1)
										.clickSubmit()
										.readTopErrorMessage(1);
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying Organization required field");
			Expected =	"Please enter a Organization";
			Actual =	Source			.AssociationsPage()
										.selectAssociationType(2)
										.clickSubmit()
										.readTopErrorMessage(1);
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying Service Population required field");
			Expected =	"Please enter a Service Population";
			Actual =	Source			.AssociationsPage()
										.selectAssociationType(3)
										.clickSubmit()
										.readTopErrorMessage(1);
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	"Associations";
			Actual =	Source			.AssociationsPage()
										.clickBackToAssociation()
										.clickDiscard()
										.PeopleNavigator()
										.readAssociationsTab();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

}