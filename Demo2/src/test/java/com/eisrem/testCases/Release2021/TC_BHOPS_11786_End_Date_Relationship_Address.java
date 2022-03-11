package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class TC_BHOPS_11786_End_Date_Relationship_Address extends PeoplePage{
	@Test(priority=1)
	public void TC_11786_End_Date_Relationship_Address_001() {

		SoftAssert = new SoftAssert();

		try{
			String lastName = LastName + SeleniumHelper.generateRandomAlpha(5);

			SeleniumHelper.log.info("Adding Relationships to an existing person");
			Expected = Today;
			Actual =	Source		.DataTable()
									.setSearch(LastName)
									.clickFirstRow()
									.clickAnchor()
									.PeopleNavigator()
									.clickRelationshipsTab()
									.clickAdd()
									.RelationshipsPage()
									.selectType(1)
									.setFirstName(FirstName2)
									.setLastName(lastName)
									.setDescription(Description)
									.DataTable()
									.clickAdd()
									.AddressPage()
									.FillRequiredAddress()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(lastName)
									.clickFirstRow()
									.clickEdit()
									.RelationshipsPage()
									.setEndDate(Today)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(lastName)
									.clickFirstRow()
									.clickEdit()
									.RelationshipsPage()
									
									.clickEdit()
									.Pagefactory()
									.clickSubmit()
																		
									.DataTable()
									.readFirstResultEndDate();
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}
