package com.eisrem.testCases.Release2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.Organization.ServicesSpecialtiesPage;

public class TC_BHOPS_11809_People_Add_Association_Org_Error_Message extends PeoplePage{

	@Test(priority=1)
	public void TC_BHOPS_11809_People_Add_Association_Org_Error_Message_001() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying Error message after selecting invalid org assocation");
			
			SeleniumHelper.log.info("Creating new person to work with");
			String peoId = Source.PeoplePage().addPersonReturnId();
			
			Expected ="Please correct the following errors:";
			
			String associationId= Source.DataTable()
								.setSearch(peoId)
								.clickFirstRow()
								.clickAnchor()
								.PeopleNavigator()
			                    .clickAssociationsTab()
			                    .setSearch(ServicePopulations.CHILDRENS.getName())
			                    .readFirstResultID().replaceAll("[^0-9]", EmptyString);
			
			Actual=	Source		.DataTable()
			                    .clickAdd()
			                    .AssociationsPage()
			                    .selectAssociationType(AssociationType.ORGANIZATION.getName())
			                    .setOrganizationAssociationNoSelect("asdsdfsd", Clear)
			                    .clickSubmit().readTopErrorMessage(1);
			                 			                    
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected ="Field must have a value selected.";
		Actual = Source		.DataTable()
							.readTopErrorMessage(2);
		SoftAssert.assertEquals(Actual, Expected);
		
		Source.PeoplePage().endDateAndSubmit(peoId);

		SoftAssert.assertAll();

	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
}						
}
							    
								
								
	