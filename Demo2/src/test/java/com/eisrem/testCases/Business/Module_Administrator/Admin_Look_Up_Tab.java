package com.eisrem.testCases.Business.Module_Administrator;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.BusinessUserLogIn;
import com.eisrem.pageFactory.Administrator.RolesPage;

public class Admin_Look_Up_Tab extends AdministratorPage {

	@Test(priority=1)
	public void Add_Look_Up() {

		SoftAssert = new SoftAssert();

		String groupName = "Look Up Test" + SeleniumHelper.generateRandomNumber(4);

		try{
			SeleniumHelper.log.info("Creating a Look Up, adding 3 Labels, and verifying success message");
			Expected =	Success;
			Actual =	Source		.AdministratorNavigator()
									.clickLookups()
									.clickAdd()
									.LookupsPage()
									.setGroupName(groupName)
									.setDescription(Description)
									.GetSource()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Hot")
									.setLabelSortOrder(1)
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Cold")
									.setLabelSortOrder(2)
									.clickIndentInListToggle()
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Warm")
									.setLabelSortOrder(3)
									.clickIndentInListToggle()
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

	@Test(priority=2)
	public void Change_Sort_Order() {

		SoftAssert = new SoftAssert();

		String groupName = "Look Up Test" + SeleniumHelper.generateRandomNumber(4);

		try{
			SeleniumHelper.log.info("Creating a Look Up, adding 3 Labels, editing sort order and verifying successful edit of sort order");
			Expected =	"2";
			Actual =	Source		.AdministratorNavigator()
									.clickLookups()
									.clickAdd()
									.LookupsPage()
									.setGroupName(groupName)
									.setDescription(Description)
									.GetSource()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Hot")
									.setLabelSortOrder(1)
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Cold")
									.setLabelSortOrder(2)
									.clickIndentInListToggle()
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Warm")
									.setLabelSortOrder(3)
									.clickIndentInListToggle()
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(groupName)
									.clickFirstRow()
									.clickEdit()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.setSearch("Warm")
									.clickFirstRow()
									.clickEdit()
									.LabelsAvailableAccord()
									.setLabelSortOrder(2, Clear)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.DataTable()
									.setSearch("Cold")
									.clickFirstRow()
									.clickEdit()
									.LabelsAvailableAccord()
									.setLabelSortOrder(3, Clear)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(groupName)
									.clickFirstRow()
									.clickView()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickSortOrder()
									.readDataTable(2, 3);
			SoftAssert.assertEquals(Actual, Expected);	

			SeleniumHelper.log.info("Verifiying sort order has been changed successfully");
			Expected =	"3";
			Actual =	Source	.SeleniumHelper()
								.scrollToBottom()
								.DataTable()
								.readDataTable(3, 3);
			SoftAssert.assertEquals(Actual, Expected);
			
			Expected =	"Warm";
			Actual =	Source	.DataTable()
								.readDataTable(2, 2);
			SoftAssert.assertEquals(Actual, Expected);

			Expected =	"COLD";
			Actual =	Source	.DataTable()
								.readDataTable(3, 2);
			SoftAssert.assertEquals(Actual, Expected);
			
			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

	@Test(priority=3)
	public void Add_Label_To_Look_Up() {

		SoftAssert = new SoftAssert();

		String groupName = "Look Up Test" + SeleniumHelper.generateRandomNumber(4);

		try{
			SeleniumHelper.log.info("Creating a Look Up, adding 3 Labels, adding an additional Label and verifying successful addition of Label");
			Expected =	Success;
			Actual =	Source		.AdministratorNavigator()
									.clickLookups()
									.clickAdd()
									.LookupsPage()
									.setGroupName(groupName)
									.setDescription(Description)
									.GetSource()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Hot")
									.setLabelSortOrder(1)
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Cold")
									.setLabelSortOrder(2)
									.clickIndentInListToggle()
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Warm")
									.setLabelSortOrder(3)
									.clickIndentInListToggle()
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(groupName)
									.clickFirstRow()
									.clickEdit()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Steamy")
									.setLabelSortOrder(4)
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.Pagefactory()
									.clickSubmit()
									.readPopUpTitle();
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

	@Test(priority=4)
	public void Inactivate_Label() {

		SoftAssert = new SoftAssert();

		String groupName = "Look Up Test" + SeleniumHelper.generateRandomNumber(4);

		try{
			SeleniumHelper.log.info("Creating a Look Up, adding 3 Labels, setting one Label to disactive and verifying successful change of Label");
			Expected =	"N";
			Actual =	Source		.AdministratorNavigator()
									.clickLookups()
									.clickAdd()
									.LookupsPage()
									.setGroupName(groupName)
									.setDescription(Description)
									.GetSource()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Hot")
									.setLabelSortOrder(1)
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Cold")
									.setLabelSortOrder(2)
									.clickIndentInListToggle()
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Warm")
									.setLabelSortOrder(3)
									.clickIndentInListToggle()
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(groupName)
									.clickFirstRow()
									.clickEdit()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.setSearch("Hot")
									.clickFirstRow()
									.clickEdit()
									.LabelsAvailableAccord()
									.clickActiveToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(groupName)
									.clickFirstRow()
									.clickView()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.setSearch("Hot")
									.readDataTable(1, 6);
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
	
	@Test(priority=5)
	public void End_Dating_Look_Up() {

		SoftAssert = new SoftAssert();

		String groupName = "Look Up Test" + SeleniumHelper.generateRandomNumber(4);

		try{
			SeleniumHelper.log.info("Creating a Look Up, adding 3 Labels, editing the Look Up and verifying successful edit");
			Expected =	Today;
			Actual =	Source		.AdministratorNavigator()
									.clickLookups()
									.clickAdd()
									.LookupsPage()
									.setGroupName(groupName)
									.setDescription(Description)
									.GetSource()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Hot")
									.setLabelSortOrder(1)
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Cold")
									.setLabelSortOrder(2)
									.clickIndentInListToggle()
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.LookupsPage()
									.clickLabelsAvailableAccord()
									.clickAdd()
									.LabelsAvailableAccord()
									.setLabelName("Warm")
									.setLabelSortOrder(3)
									.clickIndentInListToggle()
									.clickIndentInListToggle(False)
									.clickComplete()
									.Pagefactory()
									.clickPopupOk()
									.Pagefactory()
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(groupName)
									.clickFirstRow()
									.clickEdit()
									.LookupsPage()
									.setEndDate(Today)
									.GetSource()
									.Pagefactory()
									.clickActiveToggle(False)
									.clickSubmit()
									.clickPopupOk()
									.DataTable()
									.setSearch(groupName)
									.clickFirstRow()
									.clickView()
									.LookupsPage()
									.readEndDateValue().replace("\"", "");
			
			SoftAssert.assertEquals(Actual, Expected);	
			
			SeleniumHelper.log.info("Verifying changes were made successfully");
			Expected =	False;
			Actual =	Source		.LookupsPage()
									.readActiveToggle();
			SoftAssert.assertEquals(Actual, Expected);	

			SoftAssert.assertAll();		

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

}