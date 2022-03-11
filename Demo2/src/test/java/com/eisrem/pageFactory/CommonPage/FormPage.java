package com.eisrem.pageFactory.CommonPage;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalTime;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.Assessment_Forms.Assessment_FormsPage;
import com.eisrem.pageFactory.Notes.NotesPage;
import com.eisrem.pageFactory.People.PeoplePage;
import com.eisrem.pageFactory.ReportableEvent.ReportableEventPage;

import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

public class FormPage extends Pagefactory{

	public FormPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h3[@class='addEditHeader']")
	public WebElement HeaderTitle;
	
	@FindBy(xpath="//input[contains(@id,'renderTypeQuestion')]")
	public WebElement Question1TextBox;
	
	@FindBy(xpath="//input[contains(@questype,'8358')]")
	public WebElement Question2TextBox;
	
	@FindBy(xpath="//select[contains(@questype,'8135')]")
	public WebElement Question3TextBox;
	
	@FindBy(xpath="//div[contains(@class,'render active')]//button[contains(text(), 'Continue')]")
	public WebElement ContinueBtn;

	@FindBy(xpath="//div[@class='tab-pane type-page type-page-render active in']//button[contains(text(), 'Submit All Pages')]")
	public WebElement SubmitAllPagesBtn;
	
	@FindBy(xpath="//div[@class='tab-pane type-page type-page-render active in']//button[contains(@onClick,'Print')]")
	public WebElement PrintBtn;
	
	@FindBy(xpath="//div[@class='tab-pane type-page type-page-render active in']//button[contains(@onClick,'prepareDocumentDownload')]")
	public WebElement DownloadBtn;

	@FindBy(xpath="//button[contains(text(), 'Go back to People')]")
	public WebElement GoBackToPeopleBtn;
	
	@FindBy(xpath="//button[contains(text(),'Back To Reportable Event')]")
	public WebElement BackToReportableEventBtn;

	@FindBy(xpath="//button[contains(text(),'Back To Assessment')]")
	public WebElement BackToAssessmentBtn;
	
	@FindBy(xpath="//button[contains(text(),'Back To Notes')]")
	public WebElement BackToNotesBtn;
	
	@FindBy(xpath="//button[@id='typeConductorSubmit']")
	public WebElement SubmitConductedTypeBtn;
	
	@FindBy(xpath="//div[@id='container_header']")
	public WebElement ErrorMessages;
	
	@FindBy(xpath="//div[@id='container_error']")
	public WebElement ErrorMessages2;
	
	@FindBy(xpath="//button[contains(text(),'Go back to List')]")
	public WebElement BackToListBtn;
	
	@FindBy(xpath="//input[@id='renderTypeQuestion-1000033629']")
	public WebElement ReferentPhone;
	
	public String readHeader() {
		return Source.SeleniumHelper().readElement(HeaderTitle);
	}
	
	public FormPage clickCTBackToList() {
		Source.SeleniumHelper().clickElement(BackToListBtn);
		return this;
	}

	public FormPage setQuestion1(String question, String... Clear) {
		Source.SeleniumHelper().setText(Question1TextBox, question, Clear);
		return this;
	}
	
	public FormPage setQuestion2(String question, String... Clear) {
		Source.SeleniumHelper().setText(Question2TextBox, question, Clear);
		return this;
	}
	
	public FormPage setQuestion3(String question, String... Clear) {
		Source.SeleniumHelper().select(Question3TextBox, question);
		return this;
	}

	public String readTopTab(int TabIndex) {
		By Tab = By.xpath("//ul[@id='asPills']//li[" + TabIndex + "]");
		return Source.SeleniumHelper().getWebElement(Tab).getText();
	}

	public FormPage clickTopTab(int TabIndex) {
		By Tab = By.xpath("//ul[@id='asPills']//li[" + TabIndex + "]");
		Source.SeleniumHelper().clickElement(Tab);
		return this;
	}
	
	public String isActiveTopTab(int TabIndex) {
		By Tab = By.xpath("//ul[@id='asPills']//li[" + TabIndex + "]");
		return Source.SeleniumHelper().getWebElement(Tab).getAttribute("class");
	}
	
	public FormPage clickTopTab() {
		Source.SeleniumHelper().clickElement(SubmitAllPagesBtn);
		return new FormPage(DriverFactory.getDriver());
	}

	public FormPage clickSubmitAllPages() {
		Source.SeleniumHelper().clickElement(SubmitAllPagesBtn).sleep(2);
		return new FormPage(DriverFactory.getDriver());
	}

	public FormPage clickSubmitAllPages(boolean forNotifications) {
		LocalTime time = LocalTime.now();
		int minutesPassed = time.getMinuteOfHour() % 5;
		int secondsPassed = time.getSecondOfMinute();
		try {
			if(minutesPassed == 4 && secondsPassed > 30) {
				TimeUnit.SECONDS.sleep(60-secondsPassed);
				TimeUnit.MINUTES.sleep(1);
			}
			else if(minutesPassed < 1) {
				TimeUnit.SECONDS.sleep(60-secondsPassed);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickSubmitAllPages();
		return this;
	}

	public String readSubmitAllPages() {
		return Source.SeleniumHelper().readElement(SubmitAllPagesBtn);
	}
	
	public FormPage clickFormPrint() {
		Source.SeleniumHelper().clickElement(PrintBtn);
		return this;
	}
	
	public FormPage clickFormDownload() {
		Source.SeleniumHelper().clickElement(DownloadBtn);
		return this;
	}

	public String readFormPrintBtn() {
		return Source.SeleniumHelper().readElement(PrintBtn);
	}
	
	public FormPage clickFormContinue() {
		Source.SeleniumHelper().clickElement(ContinueBtn);
		return this;
	}

	public String readContinueBtn() {
		return Source.SeleniumHelper().readElement(ContinueBtn);
	}

	public PeoplePage clickGoBackToPeople() {
		Source.SeleniumHelper().clickElement(GoBackToPeopleBtn);
		return new PeoplePage(DriverFactory.getDriver());
	}

	public String readGoBackToPeople() {
		return Source.SeleniumHelper().readElement(GoBackToPeopleBtn);
	}
	
	public ReportableEventPage clickBackToReportableEvent() {
		Source.SeleniumHelper().clickElement(BackToReportableEventBtn);
		return new ReportableEventPage(DriverFactory.getDriver());
	}

	public String readBackToReportableEvent() {
		return Source.SeleniumHelper().readElement(BackToReportableEventBtn);
	}

	public Assessment_FormsPage clickBackToAssessment() {
		Source.SeleniumHelper().clickElement(BackToAssessmentBtn);
		return new Assessment_FormsPage(DriverFactory.getDriver());
	}

	public String readBackToAssessmentBtn() {
		return Source.SeleniumHelper().readElement(BackToAssessmentBtn);
	}
	
	public NotesPage clickBackToNotes() {
		Source.SeleniumHelper().clickElement(BackToNotesBtn);
		return new NotesPage(DriverFactory.getDriver());
	}
	
	public String readBackToNotesBtn() {
		return Source.SeleniumHelper().readElement(BackToNotesBtn);
	}

	public FormPage setText(int Section, String TextBoxName, String Text, String... Clear ) {
		
		
		//@FindBy(xpath="//label[@for='searchFor']")
		//By lable = By.xpath("//label[contains(text(),'"+TextBoxName+"')]");
	//	String id= Source.SeleniumHelper().getWebElement(lable).getAttribute("for");
		
		//xpath="//input[@id='startDate']"
	//	public WebElement SearchCriteriaTitle;
	//	By TextBox = By.xpath("////input[@id='"+id+"']");
		By TextBox = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + TextBoxName + "')]/..//input | //div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + TextBoxName + "')]/..//textarea");
		Source.SeleniumHelper().setText(TextBox, Text, Clear);
		return this;
	}
	
	public FormPage setText2(int Section, String TextBoxName, String Text, String... Clear ) {
		By TextBox = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + TextBoxName + "')]/..//input | //div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + TextBoxName + "')]/..//input");
		Source.SeleniumHelper().setText(TextBox, Text, Clear);
		return this;
	}

	public FormPage selectValue(int Section, String DropDownName, String Value) {
		By DropDown = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + DropDownName + "')]/..//select");
		Source.SeleniumHelper().select(DropDown, Value);
		return this;
	}
	
	public FormPage selectValue(int Section, String DropDownName, int Value) {
		By DropDown = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + DropDownName + "')]/..//select");
		Source.SeleniumHelper().select(DropDown, Value);
		return this;
	}
	
	public FormPage selectValue(int Section, String DropDownName, String Value, int TimeSection) {
		By DropDown = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + DropDownName + "')]/../div//div[" + TimeSection + "]/select");
		Source.SeleniumHelper().select(DropDown, Value);
		return this;
	}
	
	public FormPage selectValue(int Section, String DropDownName, int Value, int TimeSection) {
		By DropDown = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + DropDownName + "')]/../div//div[" + TimeSection + "]/select");
		Source.SeleniumHelper().select(DropDown, Value);
		return this;
	}
	
	public FormPage clickOption(int Section, String ButtonName) {
		By Button = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + ButtonName + "')]/..//button");
		Source.SeleniumHelper().clickElement(Button);
		return this;
	}
	
	public FormPage clickCheckBox(int Section, String checkboxname, int checkbox) {
		By Button = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + checkboxname + "')]/../div["+ checkbox + "]//input");
		Source.SeleniumHelper().clickElement(Button);
		return this;
	}
	
	public FormPage clickCheckBoxFromDropDown(int Section, String DropDown, int CheckBoxOption) {
		clickOption(Section, DropDown);
		By Button = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + DropDown + "')]/..//ul//li[" + CheckBoxOption + "]//input");
		Source.SeleniumHelper().clickElement(Button);
		return this;
	}

	public String readTextBoxOriginalValue(int Section, String TextBoxName) {
		By TextBox = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + TextBoxName + "')]/..//input");
		return Source.SeleniumHelper().getWebElement(TextBox).getAttribute("original-val");
	}
	
	public String readTextBoxValue(int Section, String TextBoxName) {
		By TextBox = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + TextBoxName + "')]/..//input");
		return Source.SeleniumHelper().getWebElement(TextBox).getAttribute("value");
	}
	
	public String readComboBoxValue(int Section, String TextBoxName) {
		By TextBox = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + TextBoxName + "')]/../div/div//input");
		return Source.SeleniumHelper().getWebElement(TextBox).getAttribute("last-val");
	}
	
	
	public String readSelectValue(int Section, String DropDownName) {
		By SelectBox = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + DropDownName + "')]/..//select");
		return Source.SeleniumHelper().getWebElement(SelectBox).getAttribute("last-val");
	}
	
	public String ifDisabledTextBox(int Section, String TextBoxName, String... DropDown) {
		By TextBox;
		if(DropDown.length>0) {
			TextBox = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + TextBoxName + "')]/..//select");
		}else {
			TextBox = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" + Section + "]//label[contains(text(), '" + TextBoxName + "')]/..//input");
		}
		return Source.SeleniumHelper().getWebElement(TextBox).getAttribute("disabled");
	}

	//Will fill required field for all answers and make 3 attempts
	public FormPage fillForm() {
		Source.SeleniumHelper().Wait();
		int attempts = 0;
		Source.SeleniumHelper().runJavascript(
				"!function(){var r = $.Deferred();$('.tab-content > .tab-pane').not('[id=\\\"typeConductor-tabs\\\"]').filter(function(){var that = this;var isNotHidden = true;$.each(currentHiddenPages,function(indx, chp){if(chp[0].pageId.toString() === that.id.split('-')[1].toString()){isNotHidden = false;}});return isNotHidden;}).find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled').each(function(idx, thing) {var quesType = $(thing).attr('quesType');if ($.inArray(quesType, ['8132', '8131', '8368', '8378']) > -1) {$(thing).val('SELENIUM TEST');} else if ($.inArray(quesType, ['8358']) > -1) {$(thing).val('01/01/2001');} else if ($.inArray(quesType, ['579548']) > -1) {setTime($(thing).parent(), '12:00:00');} else if ($.inArray(quesType, ['8138']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8137']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8133', '8134']) > -1) {$(thing).prop('checked', true);} else if ($.inArray(quesType, ['8135']) > -1) {$(thing).val($(thing).find('option:last-child').val());} else if ($.inArray(quesType, ['8136', '8135']) > -1) {while($(thing).parent().find('button').length == 0){console.log('waiting');}$(thing).find('option:first').attr('selected', true);} else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) {$(thing).data('combobox').$target.val(1);}});return r;}().done(!function(){var r = $.Deferred();ContinuePagesForTypeConductor();return r;}()).done(!function(){var r = $.Deferred();$('.tab-content > .tab-pane').not('[id=\\\"typeConductor-tabs\\\"]').filter(function(){var that = this;var isNotHidden = true;$.each(currentHiddenPages,function(indx, chp){if(chp[0].pageId.toString() === that.id.split('-')[1].toString()){isNotHidden = false;}});return isNotHidden;}).find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled').each(function(idx, thing) {var quesType = $(thing).attr('quesType');if ($.inArray(quesType, ['8132', '8131', '8368', '8378']) > -1) {$(thing).val('SELENIUM TEST');} else if ($.inArray(quesType, ['8358']) > -1) {$(thing).val('01/01/2001');} else if ($.inArray(quesType, ['579548']) > -1) {setTime($(thing).parent(), '12:00:00');} else if ($.inArray(quesType, ['8138']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8137']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8133', '8134']) > -1) {$(thing).prop('checked', true);} else if ($.inArray(quesType, ['8135']) > -1) {$(thing).val($(thing).find('option:last-child').val());} else if ($.inArray(quesType, ['8136', '8135']) > -1) {while($(thing).parent().find('button').length == 0){console.log('waiting');}$(thing)"
						+".find('option:first').attr('selected', true);} else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) {$(thing).data('combobox').$target.val(1);}});return r;}());");

		while (!Source.SeleniumHelper().areRequiredFieldsFilled() && attempts < 2) {
			Source.SeleniumHelper().runJavascript(
					"!function(){var r = $.Deferred();$('.tab-content > .tab-pane').not('[id=\\\"typeConductor-tabs\\\"]').filter(function(){var that = this;var isNotHidden = true;$.each(currentHiddenPages,function(indx, chp){if(chp[0].pageId.toString() === that.id.split('-')[1].toString()){isNotHidden = false;}});return isNotHidden;}).find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled').each(function(idx, thing) {var quesType = $(thing).attr('quesType');if ($.inArray(quesType, ['8132', '8131', '8368', '8378']) > -1) {$(thing).val('SELENIUM TEST');} else if ($.inArray(quesType, ['8358']) > -1) {$(thing).val('01/01/2001');} else if ($.inArray(quesType, ['579548']) > -1) {setTime($(thing).parent(), '12:00:00');} else if ($.inArray(quesType, ['8138']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8137']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8133', '8134']) > -1) {$(thing).prop('checked', true);} else if ($.inArray(quesType, ['8135']) > -1) {$(thing).val($(thing).find('option:last-child').val());} else if ($.inArray(quesType, ['8136', '8135']) > -1) {while($(thing).parent().find('button').length == 0){console.log('waiting');}$(thing).find('option:first').attr('selected', true);} else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) {$(thing).data('combobox').$target.val(1);}});return r;}().done(!function(){var r = $.Deferred();ContinuePagesForTypeConductor();return r;}()).done(!function(){var r = $.Deferred();$('.tab-content > .tab-pane').not('[id=\\\"typeConductor-tabs\\\"]').filter(function(){var that = this;var isNotHidden = true;$.each(currentHiddenPages,function(indx, chp){if(chp[0].pageId.toString() === that.id.split('-')[1].toString()){isNotHidden = false;}});return isNotHidden;}).find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled').each(function(idx, thing) {var quesType = $(thing).attr('quesType');if ($.inArray(quesType, ['8132', '8131', '8368', '8378']) > -1) {$(thing).val('SELENIUM TEST');} else if ($.inArray(quesType, ['8358']) > -1) {$(thing).val('01/01/2001');} else if ($.inArray(quesType, ['579548']) > -1) {setTime($(thing).parent(), '12:00:00');} else if ($.inArray(quesType, ['8138']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8137']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8133', '8134']) > -1) {$(thing).prop('checked', true);} else if ($.inArray(quesType, ['8135']) > -1) {$(thing).val($(thing).find('option:last-child').val());} else if ($.inArray(quesType, ['8136', '8135']) > -1) {while($(thing).parent().find('button').length == 0){console.log('waiting');}$(thing)"
							+ ".find('option:first').attr('selected', true);} else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) {$(thing).data('combobox').$target.val(1);}});return r;}());");
			attempts++;
		}
		return this;
	}

	public FormPage fillForm2() {
		Source.SeleniumHelper().Wait();
		Source.SeleniumHelper().runJavascript(
				"!function(){ " + 
						"    var r = $.Deferred(); " + 
						"    $('.tab-content > .tab-pane').not('[id=\\\"typeConductor-tabs\\\"]').filter(function() { " + 
						"        var that = this; " + 
						"        var isNotHidden = true; " + 
						"        $.each(currentHiddenPages, function(indx, chp) { " + 
						"            if (chp[0].pageId.toString() === that.id.split('-')[1].toString()) { " + 
						"                isNotHidden = false; " + 
						"           } " + 
						"       }); " + 
						"        return isNotHidden; " + 
						"    }).find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled').each(function(idx, thing) { " + 
						"        var quesType = $(thing).attr('quesType'); " + 
						"        if ($.inArray(quesType, ['8132', '8131', '8378']) > -1) { " + 
						"            $(thing).val('SELENIUM TEST'); " + 
						"        } else if ($.inArray(quesType, ['8368']) > -1) { " + 
						"            $(thing).val('SELENIUMEMAIL@EMAIL.GOV'); " + 
						"        } else if ($.inArray(quesType, ['8358']) > -1) { " + 
						"            $(thing).val('01/01/2001'); " + 
						"        } else if ($.inArray(quesType, ['579548']) > -1) { " + 
						"            setTime($(thing).parent(), '12:00:00'); " + 
						"        } else if ($.inArray(quesType, ['8138']) > -1) { " + 
						"            $(thing).val(1); " + 
						"        } else if ($.inArray(quesType, ['8137']) > -1) { " + 
						"            $(thing).val(1); " + 
						"        } else if ($.inArray(quesType, ['8133', '8134']) > -1) { " + 
						"            $(thing).prop('checked', true); " + 
						"        } else if ($.inArray(quesType, ['8135']) > -1) { " + 
						"            $(thing).val($(thing).find('option:last-child').val()); " + 
						"        } else if ($.inArray(quesType, ['8136']) > -1) { " +   
						"				$(thing).next('div').find('input:first').click(); " + 
						"        } else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) { " + 
						"            $(thing).data('combobox').$target.val(1); " + 
						"        } " + 
						"    }); " + 
						"    return r; " + 
						"}(); ");
		return this;
	}
	
	public FormPage fillFormActivePage() {
		Source.SeleniumHelper().Wait();
		Source.SeleniumHelper().runJavascript(
						"	!function(){ " + 
						"    var r = $.Deferred(); " + 
						"    $('.tab-content > .tab-pane.active')" +
						"	.find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled').each(function(idx, thing) { " + 
						"        var quesType = $(thing).attr('quesType'); " + 
						"        if ($.inArray(quesType, ['8132', '8131', '8378']) > -1) { " + 
						"            $(thing).val('SELENIUM TEST'); " + 
						"        } else if ($.inArray(quesType, ['8368']) > -1) { " + 
						"            $(thing).val('SELENIUMEMAIL@EMAIL.GOV'); " + 
						"        } else if ($.inArray(quesType, ['8358']) > -1) { " + 
						"            $(thing).val('01/01/2001'); " + 
						"        } else if ($.inArray(quesType, ['579548']) > -1) { " + 
						"            setTime($(thing).parent(), '12:00:00'); " + 
						"        } else if ($.inArray(quesType, ['8138']) > -1) { " + 
						"            $(thing).val(1); " + 
						"        } else if ($.inArray(quesType, ['8137']) > -1) { " + 
						"            $(thing).val(1); " + 
						"        } else if ($.inArray(quesType, ['8133', '8134']) > -1) { " + 
						"            $(thing).prop('checked', true); " + 
						"        } else if ($.inArray(quesType, ['8135']) > -1) { " + 
						"            $(thing).val($(thing).find('option:last-child').val()); " + 
						"        } else if ($.inArray(quesType, ['8136']) > -1) { " +   
						"				$(thing).next('div').find('input:first').click(); " + 
						"        } else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) { " + 
						"            $(thing).data('combobox').$target.val(1); " + 
						"        } " + 
						"    }); " + 
						"    return r; " + 
						"}(); ");
		return this;
	}

	public FormPage fillFormScoreValidate() {
		Source.SeleniumHelper().Wait();
		Source.SeleniumHelper().runJavascript(
						"	!function(){ " + 
						"    var r = $.Deferred(); " + 
						"    $('.tab-content > .tab-pane.active')" +
						"	.find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled').each(function(idx, thing) { " + 
						"        var quesType = $(thing).attr('quesType'); " + 
						"        if ($.inArray(quesType, ['1000004897']) > -1) { " + 
						"            $(thing).val($(thing).find('option:last-child').val()); " + 
						"        } " + 
						"    }); " + 
						"    return r; " + 
						"}(); ");
		return this;
	}
	
	public FormPage fillFormActivePageSkipRequiredQstn() {
		Source.SeleniumHelper().Wait();
		Source.SeleniumHelper().runJavascript(
						"	!function(){ " + 
						"    var r = $.Deferred(); " + 
						"    $('.tab-content > .tab-pane.active')" +
						"	.find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled, [aria-required]').each(function(idx, thing) { " + 
						"        var quesType = $(thing).attr('quesType'); " + 
						"        if ($.inArray(quesType, ['8132', '8131', '8378']) > -1) { " + 
						"            $(thing).val('SELENIUM TEST'); " + 
						"        } else if ($.inArray(quesType, ['8368']) > -1) { " + 
						"            $(thing).val('SELENIUMEMAIL@EMAIL.GOV'); " + 
						"        } else if ($.inArray(quesType, ['8358']) > -1) { " + 
						"            $(thing).val('01/01/2001'); " + 
						"        } else if ($.inArray(quesType, ['579548']) > -1) { " + 
						"            setTime($(thing).parent(), '12:00:00'); " + 
						"        } else if ($.inArray(quesType, ['8138']) > -1) { " + 
						"            $(thing).val(1); " + 
						"        } else if ($.inArray(quesType, ['8137']) > -1) { " + 
						"            $(thing).val(1); " + 
						"        } else if ($.inArray(quesType, ['8133', '8134']) > -1) { " + 
						"            $(thing).prop('checked', true); " + 
						"        } else if ($.inArray(quesType, ['8135']) > -1) { " + 
						"            $(thing).val($(thing).find('option:last-child').val()); " + 
						"        } else if ($.inArray(quesType, ['8136']) > -1) { " +   
						"				$(thing).next('div').find('input:first').click(); " + 
						"        } else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) { " + 
						"            $(thing).data('combobox').$target.val(1); " + 
						"        } " + 
						"    }); " + 
						"    return r; " + 
						"}(); ");
		return this;
	}

	public FormPage checkAllWebElementsDisabled() throws Exception  {
		ArrayList<WebElement> allElements = new ArrayList<WebElement>();
		String errorMsg;
		Source.SeleniumHelper().sleep(5);
		allElements.addAll(Source.SeleniumHelper().getWebElementList("//select"));
		allElements.addAll(Source.SeleniumHelper().getWebElementList("//input"));
		allElements.addAll(Source.SeleniumHelper().getWebElementList("//textarea"));
		for(WebElement wb : allElements) {
			Source.SeleniumHelper().highLightElement(wb);
			Source.SeleniumHelper().unhighLightElement(wb);
			if(wb.isDisplayed() && wb.isEnabled()) {
				errorMsg = "Element type " + wb.getTagName() + ", id - " +  wb.getAttribute("id") + " is enabled when should be disabled";
				System.out.println(errorMsg);
				throw new Exception(errorMsg);
			}
		}
		return this;
	}
	public FormPage checkSubmitBtnInvisible() throws Exception {
		String errorMsg = "Submit button is present when should not";
		if(Source.SeleniumHelper().checkWebElementExists(SubmitConductedTypeBtn)) {
			System.out.println(errorMsg);
			throw new Exception(errorMsg);
		}
		return this;
	}
	
	public FormPage checkSubmitBtnDisabled() throws Exception {
		String errorMsg = "Submit button is enabled when should be disabled.";
		if(SubmitConductedTypeBtn.isDisplayed() && SubmitConductedTypeBtn.isEnabled()) {
			System.out.println(errorMsg);
			throw new Exception(errorMsg);
		}
		return this;
	}

	public FormPage checkSubmitAllPagesBtnInvisible() throws Exception {
		if(Source.SeleniumHelper().checkWebElementExists(SubmitAllPagesBtn)) {
			System.out.println("SubmitAllPages button is present when should not");
			throw new Exception("SubmitAllPages button is present when should not");
		}
		return this;
	}
	
	public FormPage checkFieldRequired(int Section, String LabelName) throws Exception {
		By asterisk = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" 
					+ Section + "]//label[contains(text(), '" 
					+ LabelName + "')]/span[@class='red-bold'] | //div[@class='tab-pane type-page type-page-render active in']/div[" 
					+ Section + "]//label[contains(text(), '" + LabelName + "')]/span[@class='red-bold']");
		
		if(Source.SeleniumHelper().checkWebElementExists(asterisk, 1)) {
			System.out.println("Presence of asterisk confirmed.");
		}
		else {
			System.out.println("Asterisk is not present when should be.");
			throw new Exception("Asterisk is not present when should be.");
		}
		return this;
	}
	
	public FormPage checkFieldNonRequired(int Section, String LabelName) throws Exception {
		By asterisk = By.xpath("//div[@class='tab-pane type-page type-page-render active in']/div[" 
					+ Section + "]//label[contains(text(), '" 
					+ LabelName + "')]/span[@class='red-bold'] | //div[@class='tab-pane type-page type-page-render active in']/div[" 
					+ Section + "]//label[contains(text(), '" + LabelName + "')]/span[@class='red-bold']");
		
		if(!Source.SeleniumHelper().checkWebElementExists(asterisk, 1)) {
			System.out.println("Asterisk is not present, success.");
		}
		else {
			System.out.println("Asterisk is present when should not be.");
			throw new Exception("Asterisk is present when should not be.");
		}
		return this;
	}
	
	public FormPage continueIfError() throws Exception {
		if(Source.SeleniumHelper().checkWebElementExists(ErrorMessages)
				|| Source.SeleniumHelper().checkWebElementExists(ErrorMessages2)) {
			System.out.println("Presence of error messages confirmed.");
		}
		else {
			System.out.println("Error messages are not present when should be.");
			throw new Exception("Error messages are not present when should be.");
		}
		return this;
	}

	public FormPage fillFormWithRequired() {
		int attempts = 0;
		Source.SeleniumHelper().Wait();
		Source.SeleniumHelper().runJavascript(
				"!function(){var r = $.Deferred();$('.tab-content > .tab-pane').not('[id=\\\"typeConductor-tabs\\\"]').filter(function(){var that = this;var isNotHidden = true;$.each(currentHiddenPages,function(indx, chp){if(chp[0].pageId.toString() === that.id.split('-')[1].toString()){isNotHidden = false;}});return isNotHidden;}).find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled').each(function(idx, thing) {var quesType = $(thing).attr('quesType');if ($.inArray(quesType, ['8132', '8131', '8368', '8378']) > -1) {$(thing).val('SELENIUM TEST');} else if ($.inArray(quesType, ['8358']) > -1) {$(thing).val('01/01/2001');} else if ($.inArray(quesType, ['579548']) > -1) {setTime($(thing).parent(), '12:00:00');} else if ($.inArray(quesType, ['8138']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8137']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8133', '8134']) > -1) {$(thing).prop('checked', true);} else if ($.inArray(quesType, ['8135']) > -1) {$(thing).val($(thing).find('option:last-child').val());} else if ($.inArray(quesType, ['8136', '8135']) > -1) {while($(thing).parent().find('button').length == 0){console.log('waiting');}$(thing).find('option:first').attr('selected', true);} else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) {$(thing).data('combobox').$target.val(1);}});return r;}().done(!function(){var r = $.Deferred();ContinuePagesForTypeConductor();return r;}()).done(!function(){var r = $.Deferred();$('.tab-content > .tab-pane').not('[id=\\\"typeConductor-tabs\\\"]').filter(function(){var that = this;var isNotHidden = true;$.each(currentHiddenPages,function(indx, chp){if(chp[0].pageId.toString() === that.id.split('-')[1].toString()){isNotHidden = false;}});return isNotHidden;}).find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled').each(function(idx, thing) {var quesType = $(thing).attr('quesType');if ($.inArray(quesType, ['8132', '8131', '8368', '8378']) > -1) {$(thing).val('SELENIUM TEST');} else if ($.inArray(quesType, ['8358']) > -1) {$(thing).val('01/01/2001');} else if ($.inArray(quesType, ['579548']) > -1) {setTime($(thing).parent(), '12:00:00');} else if ($.inArray(quesType, ['8138']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8137']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8133', '8134']) > -1) {$(thing).prop('checked', true);} else if ($.inArray(quesType, ['8135']) > -1) {$(thing).val($(thing).find('option:last-child').val());} else if ($.inArray(quesType, ['8136', '8135']) > -1) {while($(thing).parent().find('button').length == 0){console.log('waiting');}$(thing)"
						+".find('option:first').attr('selected', true);} else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) {$(thing).data('combobox').$target.val(1);}});return r;}());");
		
		while (!areRequiredFieldsFilled() && attempts < 2) {
			Source.SeleniumHelper().runJavascript(
					"!function(){var r = $.Deferred();$('.tab-content > .tab-pane').not('[id=\\\"typeConductor-tabs\\\"]').filter(function(){var that = this;var isNotHidden = true;$.each(currentHiddenPages,function(indx, chp){if(chp[0].pageId.toString() === that.id.split('-')[1].toString()){isNotHidden = false;}});return isNotHidden;}).find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled').each(function(idx, thing) {var quesType = $(thing).attr('quesType');if ($.inArray(quesType, ['8132', '8131', '8368', '8378']) > -1) {$(thing).val('SELENIUM TEST');} else if ($.inArray(quesType, ['8358']) > -1) {$(thing).val('01/01/2001');} else if ($.inArray(quesType, ['579548']) > -1) {setTime($(thing).parent(), '12:00:00');} else if ($.inArray(quesType, ['8138']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8137']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8133', '8134']) > -1) {$(thing).prop('checked', true);} else if ($.inArray(quesType, ['8135']) > -1) {$(thing).val($(thing).find('option:last-child').val());} else if ($.inArray(quesType, ['8136', '8135']) > -1) {while($(thing).parent().find('button').length == 0){console.log('waiting');}$(thing).find('option:first').attr('selected', true);} else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) {$(thing).data('combobox').$target.val(1);}});return r;}().done(!function(){var r = $.Deferred();ContinuePagesForTypeConductor();return r;}()).done(!function(){var r = $.Deferred();$('.tab-content > .tab-pane').not('[id=\\\"typeConductor-tabs\\\"]').filter(function(){var that = this;var isNotHidden = true;$.each(currentHiddenPages,function(indx, chp){if(chp[0].pageId.toString() === that.id.split('-')[1].toString()){isNotHidden = false;}});return isNotHidden;}).find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled').each(function(idx, thing) {var quesType = $(thing).attr('quesType');if ($.inArray(quesType, ['8132', '8131', '8368', '8378']) > -1) {$(thing).val('SELENIUM TEST');} else if ($.inArray(quesType, ['8358']) > -1) {$(thing).val('01/01/2001');} else if ($.inArray(quesType, ['579548']) > -1) {setTime($(thing).parent(), '12:00:00');} else if ($.inArray(quesType, ['8138']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8137']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8133', '8134']) > -1) {$(thing).prop('checked', true);} else if ($.inArray(quesType, ['8135']) > -1) {$(thing).val($(thing).find('option:last-child').val());} else if ($.inArray(quesType, ['8136', '8135']) > -1) {while($(thing).parent().find('button').length == 0){console.log('waiting');}$(thing)"
					+ ".find('option:first').attr('selected', true);} else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) {$(thing).data('combobox').$target.val(1);}});return r;}());");
			attempts++;
		}
		return this;
	}
	
	public boolean areRequiredFieldsFilled() {
		Object returnedValue =Source.SeleniumHelper().runJavascript("return checkRequiredPages()");
		if (returnedValue	.toString()
							.equalsIgnoreCase("TRUE")) {
			return true;
		} else {
			return false;
		}
	}

	public FormPage fillEventDetailsPage() {
		Source.SeleniumHelper().runJavascript(
				"!function(){var r = $.Deferred();$('.tab-content > .tab-pane').not('[id=\\\"typeConductor-tabs\\\"]').filter(function(){var that = this;var isNotHidden = true;$.each(currentHiddenPages,function(indx, chp){if(chp[0].pageId.toString() === that.id.split('-')[1].toString()){isNotHidden = false;}});return isNotHidden;})"
  				+".find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled')"
				+".each(function(idx, thing) {var quesType = $(thing).attr('quesType');"
  				+"if ($.inArray(quesType, ['8132', '8131', '8368', '8378']) > -1) {$(thing).val('SELENIUM ANSWER');} else if ($.inArray(quesType, ['8358']) > -1) {$(thing).val('81/01/2001');} else if ($.inArray(quesType, ['579548']) > -1) {setTime($(thing).parent(), '12:00:00');} else if ($.inArray(quesType, ['8138']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8137']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8133', '8134']) > -1) {$(thing).prop('checked', true);} "
  				+"else if ($.inArray(quesType, ['8135']) > -1) "
  				+"{$(thing).val($(thing).find('option:last-child').val());} " 
  				+"else if ($.inArray(quesType, ['8136']) > -1) "
				+"{$(thing).val($(this).find('option:first').val());$(thing).multiselect('refresh');"
  				+"$(thing).attr('last-val',$(this).find('option:first').val());}"
				+"else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) " 
				+"{$(thing).data('combobox').$target.val(1);}});return r;}()"
				);
		Source.SeleniumHelper().sleep(5);			
  		return this;
  	}
	
	public FormPage fillEventDetailsNoErrors() {
		Source.SeleniumHelper().runJavascript(
				"!function(){var r = $.Deferred();$('.tab-content > .tab-pane').not('[id=\\\"typeConductor-tabs\\\"]').filter(function(){var that = this;var isNotHidden = true;$.each(currentHiddenPages,function(indx, chp){if(chp[0].pageId.toString() === that.id.split('-')[1].toString()){isNotHidden = false;}});return isNotHidden;})"
  				+".find('input:not([id$=\\\"-combobox\\\"], [id=\\\"typeConductorId\\\"], [id=\\\"typeId\\\"], [id=\\\"operation\\\"]),textarea,select,select[combobox]').not('disabled')"
				+".each(function(idx, thing) {var quesType = $(thing).attr('quesType');"
  				+"if ($.inArray(quesType, ['8132', '8131', '8368', '8378']) > -1) {$(thing).val('SELENIUM ANSWER');} else if ($.inArray(quesType, ['8358']) > -1) {$(thing).val('81/01/2001');} else if ($.inArray(quesType, ['579548']) > -1) {setTime($(thing).parent(), '12:00:00');} else if ($.inArray(quesType, ['8138']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8137']) > -1) {$(thing).val(1);} else if ($.inArray(quesType, ['8133', '8134']) > -1) {$(thing).prop('checked', true);} "
  				+"else if ($.inArray(quesType, ['8135']) > -1) "
  				+"{$(thing).val($(thing).find('option:last-child').val());} " 
  				+"else if ($.inArray(quesType, ['8136']) > -1) "
				+"{$(thing).val($(this).find('option:first').val());$(thing).multiselect('refresh');"
  				+"$(thing).attr('last-val',$(this).find('option:first').val());}"
				+"else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) " 
				+"{$(thing).data('combobox').$target.val(1);}});return r;}()"
				);
		Source.SeleniumHelper().sleep(5);	
  		return this;
  	}
	
	public FormPage setComboBox(String label, String searchText, String... Clear) {
		WebElement combobox = Source.SeleniumHelper().getWebElement(By.xpath("//label[text()='" + label + "']/../div/div/input"));
		Source.SeleniumHelper().setText(combobox, searchText, Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().clickElement(By.xpath("//label[text()='" + label + "']/../div/div/ul/li[1]/a"));
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public FormPage clearComboBox(String label) {
		WebElement combobox = Source.SeleniumHelper().getWebElement(By.xpath("//label[text()='" + label + "']/../div/div/input"));
		Source.SeleniumHelper().setText(combobox, "", Clear);
		Source.SeleniumHelper().sleep(1);
		Source.SeleniumHelper().Actions().sendKeys(Keys.TAB).build().perform();
		return this;
	}
	
	public FormPage searchComboBoxWithoutSetting(String label, String searchText, String... Clear) {
		WebElement combobox = Source.SeleniumHelper().getWebElement(By.xpath("//label[text()='" + label + "']/../div/div/input"));
		Source.SeleniumHelper().setText(combobox, searchText, Clear);
		Source.SeleniumHelper().sleep(1);
		return this;
	}
	
	public FormPage checkIfBaseLocsFirst(String label) throws Exception{
		List<WebElement> elements= Source.SeleniumHelper().getWebElementList(By.xpath("//label[text()='" + label + "']/../div/div/ul/li"));
		int listSize = elements.size();
		boolean isOtherLoc = false;
			for(int i = 0; i <= listSize - 1; i++) {
				if(elements.get(i).getAttribute("data-value").endsWith("/ BASE")) {
					if(isOtherLoc) throw new Exception("Base Location not in order!");	// if Base location appears after Other location, throw error
				}
				else if(!elements.get(i).getAttribute("data-value").endsWith("/ BASE") && !isOtherLoc) {
					isOtherLoc = true;
				}
			}
 		return this;
	}
    
//	public String isReadOnly() {
//		String id=Source.SeleniumHelper().getWebElement(Question1).getAttribute("for");
//		String readOnly =Source.SeleniumHelper().getWebElement(By.id(id)).getAttribute("readOnly");
//	//	return readOnly==null;
//		return this;
//	}
	
	public String readPrincipleScoreValue() {
		WebElement principleScoreQuestion = Source.SeleniumHelper().getWebElement(By.xpath("//input[@quesType='" + "1000004898" + "']"));
		return principleScoreQuestion.getText();
	}
	
	public FormPage setReferentPhone(int PhoneNum, String... Clear) {
		Source.SeleniumHelper().setText(ReferentPhone, PhoneNum, Clear);
		return this;
	}
}
