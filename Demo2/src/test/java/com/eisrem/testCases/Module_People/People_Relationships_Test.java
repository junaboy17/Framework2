package com.eisrem.testCases.Module_People;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PeoplePage;

public class People_Relationships_Test extends PeoplePage {
	@Test(priority=1)
	public void Relationships_Add_001() {

		SoftAssert = new SoftAssert();

		try{

			SeleniumHelper.log.info("Adding Relationships to an existing person and verifying success message");
			Expected = Success;
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
									.setLastName(LastName2)
									.setDescription(Description)
									.DataTable()
									.clickAdd()
									.AddressPage()
									.FillRequiredAddress()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying Relationships was successfully added");
			Expected = LastName2.toUpperCase() + ", " + FirstName2.toUpperCase() + "/ BHPC";
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
	public void Relationships_Edit_001() {

		SoftAssert = new SoftAssert();

		String FName = FirstName2.toUpperCase() + RandAlpha1;
		String LName = LastName2.toUpperCase() + RandAlpha1;
		String NewAddress = RandNum4 + "Selenium Road";
		
		try{

			SeleniumHelper.log.info("Adding Relationships to an existing person and verifying success message");
			Expected = Success;
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
									.setLastName(LastName2)
									.setDescription(Description)
									.DataTable()
									.clickAdd()
									.AddressPage()
									.FillRequiredAddress()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Editing Relationships and verifying success message");
			Expected = Success;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.setSearch(LastName2)
									.clickFirstRow()
									.clickEdit()
									.RelationshipsPage()
									.setFirstName(FName, Clear)
									.setLastName(LName, Clear)
									.setDescription(UpdateDescription, Clear)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(LName)
									.clickFirstRow()
									.clickEdit()
									.DataTable()
									.clickFirstRow()
									.clickEdit()
									.AddressPage()
									.setAddress1TextBox(NewAddress, Clear)
									.setDescription(UpdateDescription, Clear)
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying Relationships was edited successfully");
			Expected = FName;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.PeopleNavigator()
									.clickRelationshipsTab()
									.DataTable()
									.setSearch(LName)
									.clickFirstRow()
									.clickView()
									.RelationshipsPage()
									.readFirstNameValue();
			SoftAssert.assertEquals(Actual, Expected);	

			Expected = LName;
			Actual =	Source		.RelationshipsPage()
									.readLastNameValue();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = NewAddress;
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickView()
									.AddressPage()
									.readAddress1Value();
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = UpdateDescription;
			Actual =	Source		.AddressPage()
									.readDescriptionTextBoxValue();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=3)
	public void Relationships_View_001() {

		SoftAssert = new SoftAssert();
		
		try{

			SeleniumHelper.log.info("Adding Relationships to an existing person and verifying success message");
			Expected = Success;
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
									.setLastName(LastName2)
									.setDescription(Description)
									.DataTable()
									.clickAdd()
									.AddressPage()
									.FillRequiredAddress()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Viewing Relationships and verifying fields cannot be edited");
			Expected = True;
			Actual =	Source		.Pagefactory()
									.clickPopupOk()
									.DataTable()
									.clickFirstRow()
									.clickView()
									.SeleniumHelper().readAttribute(Source.RelationshipsPage().FirstNameTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
		
			Expected = True;
			Actual =	Source		.SeleniumHelper().readAttribute(Source.RelationshipsPage().LastNameTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual =	Source		.SeleniumHelper().readAttribute(Source.Pagefactory().DescriptionTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual =	Source		.DataTable()
									.clickFirstRow()
									.clickView()
									.SeleniumHelper().readAttribute(Source.AddressPage().Address1TextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);	
			
			Expected = True;
			Actual =	Source		.SeleniumHelper().readAttribute(Source.AddressPage().DescriptionTextBox, "disabled");
			SoftAssert.assertEquals(Actual, Expected);
						
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
}