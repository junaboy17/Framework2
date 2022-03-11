package com.eisrem.testCases.Release2021;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Enumerations.ServicePopulations;
import com.eisrem.Hooks.AdministratorPage;

public class TC_BHOPS_11653_Notifications_Format_Options_002 extends AdministratorPage {
	
	@Test(priority=1)
	public void TC_Notifications_Format_Options_002() {
		
		SoftAssert = new SoftAssert();

		try{
			
			SeleniumHelper.log.info("Add a new page with one of each question");
			Expected = Success;
			Actual = Source	.PagesPage()
							.addPage(PageName, Today, null, F, Description)
							.GetSource()
							.SectionsAvailableAccord()
							.addSection(SectionName, 1, Description, T, T, T)
							.GetSource()
							.RowsAvailableAccord()
							.addRow(RowName, 1, Description, T, T, T)
							.GetSource()
							.QuestionsAvailableAccord()
							.addQuestion(QuestionType.CHECK_BOX.getName(), QuestionType.CHECK_BOX.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.CHOICE_BOX.getName(), QuestionType.CHOICE_BOX.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.DATE_FIELD.getName(), QuestionType.DATE_FIELD.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.DECIMAL_FIELD.getName(), QuestionType.DECIMAL_FIELD.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.FIELD.getName(), QuestionType.FIELD.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.INTEGER_FIELD.getName(), QuestionType.INTEGER_FIELD.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.LIST_BOX.getName(), QuestionType.LIST_BOX.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.ORGANIZATION_LOOKUP.getName(), QuestionType.ORGANIZATION_LOOKUP.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.PERSON_LOOKUP.getName(), QuestionType.PERSON_LOOKUP.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.TIME_FIELD.getName(), QuestionType.TIME_FIELD.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.RADIO_BUTTON.getName(), QuestionType.RADIO_BUTTON.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.TEXT_AREA.getName(), QuestionType.TEXT_AREA.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.TEXT_FIELD.getName(), QuestionType.TEXT_FIELD.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.USER_LOOKUP.getName(), QuestionType.USER_LOOKUP.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.EMAIL.getName(), QuestionType.EMAIL.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.PHONE_NUMBER.getName(), QuestionType.PHONE_NUMBER.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.addQuestion(QuestionType.CONDUCTED_TYPE_SEARCH.getName(), QuestionType.CONDUCTED_TYPE_SEARCH.getIndex(), 1, null, null, null, T, F)
							.clickQASave().GetSource().SeleniumHelper().Wait(4).GetSource().QuestionsAvailableAccord()
							.GetSource()
							.RowsAvailableAccord()
							.clickRowBack()
							.clickSectionsBack()
							.clickLockForUseToggle()
							.clickYes()
							.PagesPage()
							.clickSubmitExit()
							.readPopUpTitle();
		
			SeleniumHelper.log.info("Add a new type with the created page");
			 		Source	.TypesPage()
			 				.addCompleteTypeAndSubmit(TypeName, Today, null, AppModule.NOTES.getIndex(), LockTime.NEVER.getIndex(), Description, T, T, AppAreaConductType.BOTH.getIndex(), //Type
			 						PageName, 1, null, null, null, F, T, //Page
			 						Roles.ALLAPPS.getName(), Today, null, T, T, T, Description, //Role
			 						ServicePopulations.SUBSTANCE_USE.getName(), StartDate, null, Description); //Service Population
			
			SeleniumHelper.log.info("Confirm Checkbox format options. Soft asserts in method call");
					Source	.AdministratorNavigator()
							.clickNotifications()
							.clickAdd()
							.SetConditionsAccord()
							.setType(TypeName)
							.setPage(PageName)
							.setQuestion(QuestionType.CHECK_BOX.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionDisabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
						
			SeleniumHelper.log.info("Confirm Choicebox format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.CHOICE_BOX.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionDisabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
							
			SeleniumHelper.log.info("Confirm Date Field format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.DATE_FIELD.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionEnabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm Decimal Field format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.DECIMAL_FIELD.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionEnabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionEnabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionEnabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionEnabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionEnabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionEnabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionEnabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionEnabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			//The way I search works it selects the first match so we need to be more specific due to date field appearing first
			SeleniumHelper.log.info("Confirm Field format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.FIELD.getName()+"/ "+ QuestionType.FIELD.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionDisabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm Integer Field format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.INTEGER_FIELD.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionEnabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionEnabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionEnabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionEnabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionEnabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionEnabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionEnabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionEnabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm Integer Field format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.LIST_BOX.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionDisabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm Org lookup format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.ORGANIZATION_LOOKUP.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionEnabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm Person lookup format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.PERSON_LOOKUP.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionEnabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm Time field format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.TIME_FIELD.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionEnabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm radio button format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.RADIO_BUTTON.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionDisabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm Text Area format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.TEXT_AREA.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionEnabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionEnabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm Text field format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.TEXT_FIELD.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionEnabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionEnabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm User lookup format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.USER_LOOKUP.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionEnabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionEnabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm email format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.EMAIL.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionDisabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm phone number format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.PHONE_NUMBER.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionDisabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
			
			SeleniumHelper.log.info("Confirm conducted type search format options. Soft asserts in method call");		
			Source			.SetConditionsAccord()				
							.setQuestion(QuestionType.CONDUCTED_TYPE_SEARCH.getName())
							.formatHighlight(true).clickFormatDropDown()
							.formatOptionDisabled(NotificationFormat.EQUALS.getName(), NotificationFormat.EQUALS.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN.getName(), NotificationFormat.LESS_THEN.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN.getName(), NotificationFormat.GREATER_THEN.getId())
							.formatOptionDisabled(NotificationFormat.NOT_EQUAL.getName(), NotificationFormat.NOT_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.LESS_THEN_OR_EQUAL.getName(), NotificationFormat.LESS_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.GREATER_THEN_OR_EQUAL.getName(), NotificationFormat.GREATER_THEN_OR_EQUAL.getId())
							.formatOptionDisabled(NotificationFormat.CONTAINS.getName(), NotificationFormat.CONTAINS.getId())
							.formatOptionEnabled(NotificationFormat.IS_EDITED.getName(), NotificationFormat.IS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.IS_ENTERED.getName(), NotificationFormat.IS_ENTERED.getId())
							.formatOptionDisabled(NotificationFormat.IS_RELATED.getName(), NotificationFormat.IS_RELATED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_EDITED.getName(), NotificationFormat.WAS_EDITED.getId())
							.formatOptionDisabled(NotificationFormat.WAS_ENTERED.getName(), NotificationFormat.WAS_ENTERED.getId())
							.formatHighlight(false)
							.clickQuestionXbtn();
							
			SeleniumHelper.log.info("Discard notification and end date page and type");	
			Source			.NotificationsPage()
							.clickBackToNotifications()
							.clickDiscard()
							.PagesPage()
							.endDatePageAndSubmit(PageName, Today)
							.GetSource()
							.TypesPage()
							.endDateType(TypeName);
							
					SoftAssert.assertAll();
		}catch(Exception e) {
			Source	.SeleniumHelper()
					.assertFail();
		}
	}	
}
	
	

