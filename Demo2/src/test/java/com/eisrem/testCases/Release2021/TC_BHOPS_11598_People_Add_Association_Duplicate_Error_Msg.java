package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.OrganizationPage;
import com.eisrem.Hooks.PeoplePage;
import com.eisrem.pageFactory.Organization.ServicesSpecialtiesPage;

public class TC_BHOPS_11598_People_Add_Association_Duplicate_Error_Msg extends PeoplePage{

	@Test(priority=1)
	public void TC_People_Add_Association_Duplicate_Error_Message() {
		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("Verifying Error message after adding duplicate People Associations");
			
			SeleniumHelper.log.info("Creating new person to work with if UAT else use Jeannes Person if Dev");
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
			                    .selectAssociationType(AssociationType.SERVICE_POPULATION.getName())
			                    .selectServicePopulation(ServicePopulations.CHILDRENS.getName())
			                    .clickSubmit().readTopErrorMessage(1);
			                 			                    
		SoftAssert.assertEquals(Actual, Expected);
		
		Expected ="Conflict with existing Association, "+ associationId +", Start Date="+ Today +", End Date=null. If you cannot resolve the conflict, Please contact the appropriate Admin Staff:\n"
				+ "Children's: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n"
				+ "OBH: EIS.OBH@maine.gov";
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
							    
								
								
	