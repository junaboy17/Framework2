package com.eisrem.pageFactory.Administrator;

import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.pageFactory.CommonPage.PagesAvailableAccord;

public class TypesPage extends AdministratorNavigator{

	public TypesPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@id='23_Types_tab']")
	public WebElement typesTab;
	
	@FindBy(xpath="//h3[contains(text(),'Add Types')]")
	public WebElement AddTypesPageTitle;
	
	@FindBy(xpath="//p[@class='required-note']")
	public WebElement NoteTitle;
	
	@FindBy(xpath="//p[@class='required-note'][2]")
	public WebElement AddPageCompleteTitle;
	
	@FindBy(xpath="//a[contains(text(),'Types Info:')]")
	public WebElement TypesInfoLink;
	
	@FindBy(xpath="//li[@id='types-tab']")
	public WebElement TypeTab;
	
	@FindBy(xpath="//label[@for='module']")
	public WebElement AppModuleTitle;
	
	@FindBy(xpath="//select[@id='module']")
	public WebElement AppModuleDropDown;
	
	@FindBy(xpath="//label[@for='typesName']")
	public WebElement NameTitle;
	
	@FindBy(xpath="//input[@id='typesName']")
	public WebElement NameTextBox;
	
	@FindBy(xpath="//label[@for='lockTime']")
	public WebElement LockTimeTitle;
	
	@FindBy(xpath="//*[@id='activeFlag']")
	public WebElement LockedForUseFlag;
	
	@FindBy(xpath="//select[@id='lockTime']")
	public WebElement LockTimeDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Description')]")
	public WebElement DescriptionTitle;
	
	@FindBy(xpath="//textarea[@id='typesDesc']")
	public WebElement DescriptionTextBox;
	
	@FindBy(xpath="//label[@for='conductBy']")
	public WebElement AppAreaToConductTypeTitle;
	
	@FindBy(xpath="//select[@id='conductBy']")
	public WebElement AppAreaToConductTypeDropDown;
	
	@FindBy(xpath="//label[contains(text(),'Multiple Allowed?')]")
	public WebElement MultipleAllowedTitle;
	
	@FindBy(xpath="//*[@id='multiple-allowed']")
	public WebElement MultipleAllowedFlag;
	
	@FindBy(xpath="//div[@class='form-group col-lg-2 col-md-3 col-xs-12'][1]//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement MultipleAllowedToggle;
	
	@FindBy(xpath="//div[@class='form-group col-lg-2 col-md-3 col-xs-12'][1]//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement MultipleAllowedBtnAttribute;
	
	@FindBy(xpath="//button[contains(text(),'Preview')]")
	public WebElement PreviewBtn;
	
	@FindBy(xpath="//button[contains(text(),'Test Form')]")
	public WebElement TestFormBtn;
	
	@FindBy(xpath="//ul[@id='types-pages-pills']//li[1]/a")
	public WebElement TestFormFirstPageBtn;
	
	@FindBy(xpath="//ul[@id='types-pages-pills']//li[2]/a")
	public WebElement TestFormFirstPageBtn2;
	
	@FindBy(xpath="//a[contains(text(),'Pages Available:')]")
	public WebElement PagesAvailableLink;
	
	@FindBy(xpath="//button[contains(text(),'Submit & Exit')]")
	public WebElement SubmitExitBtn;
	
	@FindBy(xpath="//button[contains(text(),'Print')]")
	public WebElement PrintBtn;
	
	@FindBy(xpath="//button[contains(text(),'Back To Types')]")
	public WebElement BackToTypesBtn;
	
	@FindBy(xpath="//button[contains(text(),'Back')]")
	public WebElement BackBtn;
		
	@FindBy(xpath="//button[@id='btnWarning']")
	public WebElement TestPreviewFormBackBtn;
	
	@FindBy(xpath="(//button[@id='btnWarning'])[2]")
	public WebElement TestPreviewFormBackBtn2;

	@FindBy(xpath="//*[starts-with(@id,'test-renderTypePage')][contains(@class,'active')]")
	public WebElement TestRenderTypePageActive;
	
	@FindBy(css="div[class='tab-pane type-page type-page-render active']")
	public WebElement TestRenderTypePageContent;
	
	//*[@id="btnWarning"]
	
	public String readTypesTab() {
		return Source.SeleniumHelper().readElement(typesTab);
	}
	
	public String readAddTypesPageTitle() {
		return Source.SeleniumHelper().readElement(AddTypesPageTitle);
	}
	
	public String readNoteTitle() {
		return Source.SeleniumHelper().readElement(NoteTitle);
	}
	
	public String readAddPageCompleteTitle() {
		return Source.SeleniumHelper().readElement(AddPageCompleteTitle);
	}
	
	public String readTypesInfoLink() {
		return Source.SeleniumHelper().readElement(TypesInfoLink);
	}
	
	public TypesPage clickTypesInfo() {
		Source.SeleniumHelper().clickElement(TypesInfoLink);
		return this;
	}
	
	public String readTypeTab() {
		return Source.SeleniumHelper().readElement(TypeTab);
	}
	
	public String readAppModuleTitle() {
		return Source.SeleniumHelper().readElement(AppModuleTitle);
	}
	
	public TypesPage selectAppModule(int index) {
		Source.SeleniumHelper().select(AppModuleDropDown, index);
		return this;
	}
	
	public TypesPage clickAppModule() {
		Source.SeleniumHelper().clickElement(AppModuleDropDown);
		return this;
	}
	
	public TypesPage selectAppModule(String appModule) {
		Source.SeleniumHelper().select(AppModuleDropDown, appModule);
		return this;
	}

	public String readNameTitle() {
		return Source.SeleniumHelper().readElement(NameTitle);
	}

	public TypesPage setName(String name, String... Clear) {
		Source.SeleniumHelper().setText(NameTextBox, name, Clear);
		return this;
	}
	
	public String readLockTimeTitle() {
		return Source.SeleniumHelper().readElement(LockTimeTitle);
	}
	
	public TypesPage selectLockTime(int index) {
		Source.SeleniumHelper().select(LockTimeDropDown, index);
		return this;
	}

	public String readDescriptionTitle() {
		return Source.SeleniumHelper().readElement(DescriptionTitle);
	}

	public TypesPage setDescription(String description, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, description, Clear);
		return this;
	}
	
	public String readAppAreaToConductTypeTitle() {
		return Source.SeleniumHelper().readElement(AppAreaToConductTypeTitle);
	}
	
	public TypesPage selectAppAreaToConductType(int index) {
		Source.SeleniumHelper().select(AppAreaToConductTypeDropDown, index);
		return this;
	}
	
	public String readAppAreaToConductTypeValue() {
		return Source.SeleniumHelper().getAttribute(AppAreaToConductTypeDropDown, "value");
	}
	
	public String readAppAreaToConductTypeValue(String attribute) {
		return Source.SeleniumHelper().getAttribute(AppAreaToConductTypeDropDown, attribute);
	}
	
	public String readMultipleAllowedTitle() {
		return Source.SeleniumHelper().readElement(MultipleAllowedTitle);
	}
	
	public String readMultipleAllowedToggle() {
		return	MultipleAllowedBtnAttribute.getAttribute("last-val");
	}
	
	public TypesPage clickMultipleAllowed() {
		Source.SeleniumHelper().clickElement(MultipleAllowedToggle);
		return this;
	}
	
	public String readPreviewBtn() {
		return Source.SeleniumHelper().readElement(PreviewBtn);
	}

	public TypesPage clickPreview() {
		Source.SeleniumHelper().clickElement(PreviewBtn);
		return this;
	}
	
	public String readTestFormBtn() {
		return Source.SeleniumHelper().readElement(TestFormBtn);
	}

	public TypesPage clickTestForm() {
		Source.SeleniumHelper().clickElement(TestFormBtn);
		Source.SeleniumHelper().sleep(3);
		return this;
	}
	
	public String readTestFormFirstPageBtn() {
		return Source.SeleniumHelper().readElement(TestFormFirstPageBtn);
	}
	
	public TypesPage clickTestFormFirstPage() {
		Source.SeleniumHelper().clickElement(TestFormFirstPageBtn);
		Source.SeleniumHelper().sleep(3);
		return this;
	}
	
	public String readTestFormFirstPageBtn2() {
		return Source.SeleniumHelper().readElement(TestFormFirstPageBtn2);
	}
	
	public TypesPage clickTestFormFirstPage2() {
		Source.SeleniumHelper().clickElement(TestFormFirstPageBtn2);
		Source.SeleniumHelper().sleep(3);
		return this;
	}

	public TypesPage clickTestFormContinueBtn(int page) {
		Source.SeleniumHelper().clickElement(By.xpath("(//button[contains(text(),'Continue')])[" + String.valueOf(page) + "]"));
		return this;
	}
	
	public String readPagesAvailableLinkTitle() {
		return Source.SeleniumHelper().readElement(PagesAvailableLink);
	}
	
	public PagesAvailableAccord clickPagesAvailableLink() {
		Source.SeleniumHelper().clickElement(PagesAvailableLink);
		return new PagesAvailableAccord(DriverFactory.getDriver());
	}
	
	public TypesPage clickSubmitExit() {
		Source.SeleniumHelper().clickElement(SubmitExitBtn);
		return this;
	}
	
	public String readSubmitExitBtn() {
		return Source.SeleniumHelper().readElement(SubmitExitBtn);
	}
	
	public TypesPage clickPrint() {
		Source.SeleniumHelper().clickElement(PrintBtn);
		return this;
	}
	
	public String readPrintBtn() {
		return Source.SeleniumHelper().readElement(PrintBtn);
	}
	
	public TypesPage clickBackToTypes() {
		Source.SeleniumHelper().clickElement(BackToTypesBtn);
		return this;
	}
	
	public String readBackToTypesBtn() {
		return Source.SeleniumHelper().readElement(BackToTypesBtn);
	}
	
	public TypesPage clickBackBtn() {
		Source.SeleniumHelper().clickElement(BackBtn);
		return this;
	}
	
	public TypesPage clickTestBackBtn() {
		Source.SeleniumHelper().clickElement(TestPreviewFormBackBtn);
		return this;
	}
	
	public TypesPage clickTestBackBtn2() {
		Source.SeleniumHelper().clickElement(TestPreviewFormBackBtn2);
		return this;
	}
	
	public String readBackBtn() {
		return Source.SeleniumHelper().readElement(BackBtn);
	}
	
	public TypesPage fillForm() {
		Source.SeleniumHelper().runJavascript(
				"! function() { " + 
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
				"        } else if ($.inArray(quesType, ['8136', '8135']) > -1) { " + 
				"            while ($(thing).parent().find('button').length == 0) { " + 
				"                console.log('waiting'); " + 
				"            } " + 
				"            $(thing).find('option:first').attr('selected', true); " + 
				"        } else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) { " + 
				"            $(thing).data('combobox').$target.val(1); " + 
				"        } " + 
				"    }); " + 
				"    return r; " + 
				"}(); ");
	return this;
}
	
	public TypesPage clearForm() {
		Source.SeleniumHelper().runJavascript("! function() { " + 
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
				"            $(thing).val(''); " + 
				"        } else if ($.inArray(quesType, ['8368']) > -1) { " + 
				"            $(thing).val(''); " + 
				"        } else if ($.inArray(quesType, ['8358']) > -1) { " + 
				"            $(thing).val(''); " + 
				"        } else if ($.inArray(quesType, ['579548']) > -1) { " + 
				"            setTime($(thing).parent(), ''); " + 
				"        } else if ($.inArray(quesType, ['8138']) > -1) { " + 
				"            $(thing).val(''); " + 
				"        } else if ($.inArray(quesType, ['8137']) > -1) { " + 
				"            $(thing).val(''); " + 
				"        } else if ($.inArray(quesType, ['8133', '8134']) > -1) { " + 
				"            $(thing).prop('checked', false); " + 
				"        } else if ($.inArray(quesType, ['8135']) > -1) { " + 
				"            $(thing).val($(thing).find('option:last-child').val()); " + 
				"        } else if ($.inArray(quesType, ['8136', '8135']) > -1) { " + 
				"            while ($(thing).parent().find('button').length == 0) { " + 
				"                console.log('waiting'); " + 
				"            } " + 
				"            $(thing).find('option:first').attr('selected', true); " + 
				"        } else if ($.inArray(quesType, ['13231', '13232', '579568']) > -1) { " + 
				"            $(thing).data('combobox').$target.val(0); " + 
				"        } " + 
				"    }); " + 
				"    return r; " + 
				"}(); ");
		return this;
	}
	
	public TypesPage addCompleteTypeUnlockedAndSubmit() {
		String TypeName = "TC_Types_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source	
			.AdministratorNavigator()
			.clickTypes()
			.clickAdd()
			.TypesPage()
			.selectAppModule(AppModule.NOTES.getIndex())
			.setName(TypeName)
			.selectLockTime(LockTime.NEVER.getIndex())
			.selectAppAreaToConductType(AppAreaConductType.BOTH.getIndex())
			.clickAdd()
			.PagesAvailableAccord()
			.setPage(DataFixForm)
			.setSortOrder(OneN)
			.GetSource()
			.RolesAvailableAccord()
			.clickRolesAdd()
			.selectRole(Roles.ALLAPPS.getIndex())
			.clickRolesComplete()
			.PagesAvailableAccord()
			.clickServicePopulationAvailableAccord()
			.clickSpAdd()
			.selectServicePopulation(ServicePopulations.CHILDRENS.getIndex())
			.clickSpComplete()
			.PagesAvailableAccord()
			.clickComplete()
			.DataTable()
			.clickPopupOk()
			.TypesPage()
			.clickSubmitExit()
			.GetSource()
			.SeleniumHelper()
			.sleep(5);
		return this;
	}
	
	public TypesPage addCompleteTypeUnlocked() {
		String TypeName = "TC_Types_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source	
			.AdministratorNavigator()
			.clickTypes()
			.clickAdd()
			.TypesPage()
			.selectAppModule(AppModule.NOTES.getIndex())
			.setName(TypeName)
			.selectLockTime(LockTime.NEVER.getIndex())
			.selectAppAreaToConductType(AppAreaConductType.BOTH.getIndex())
			.clickAdd()
			.PagesAvailableAccord()
			.setPage(DataFixForm)
			.setSortOrder(OneN)
			.GetSource()
			.RolesAvailableAccord()
			.clickRolesAdd()
			.selectRole(Roles.ALLAPPS.getIndex())
			.clickRolesComplete()
			.PagesAvailableAccord()
			.clickServicePopulationAvailableAccord()
			.clickSpAdd()
			.selectServicePopulation(ServicePopulations.CHILDRENS.getIndex())
			.clickSpComplete()
			.PagesAvailableAccord()
			.clickComplete()
			.DataTable()
			.clickPopupOk();
		return this;
	}
	
	public TypesPage addTypeUnlocked() {
		String TypeName = "TC_Types_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source	
			.AdministratorNavigator()
			.clickTypes()
			.clickAdd()
			.TypesPage()
			.selectAppModule(AppModule.NOTES.getIndex())
			.setName(TypeName)
			.selectLockTime(LockTime.NEVER.getIndex())
			.selectAppAreaToConductType(AppAreaConductType.BOTH.getIndex());
		return this;
	}
	
	public TypesPage addTypeUnlockedAndSubmit() {
		String TypeName = "TC_Types_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source	
			.AdministratorNavigator()
			.clickTypes()
			.clickAdd()
			.TypesPage()
			.selectAppModule(AppModule.NOTES.getIndex())
			.setName(TypeName)
			.selectLockTime(LockTime.NEVER.getIndex())
			.selectAppAreaToConductType(AppAreaConductType.BOTH.getIndex())
			.clickSubmitExit()
			.GetSource()
			.SeleniumHelper()
			.sleep(5);
		return this;
	}
	
	public String addCompleteTypeUnlockedGetNameAndSubmit() {
		String TypeName = "TC_Types_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source	
			.AdministratorNavigator()
			.clickTypes()
			.clickAdd()
			.TypesPage()
			.selectAppModule(AppModule.NOTES.getIndex())
			.setName(TypeName)
			.selectLockTime(LockTime.NEVER.getIndex())
			.selectAppAreaToConductType(AppAreaConductType.BOTH.getIndex())
			.clickAdd()
			.PagesAvailableAccord()
			.setPage(DataFixForm)
			.setSortOrder(OneN)
			.GetSource()
			.RolesAvailableAccord()
			.clickRolesAdd()
			.selectRole(Roles.ALLAPPS.getIndex())
			.clickRolesComplete()
			.PagesAvailableAccord()
			.clickServicePopulationAvailableAccord()
			.clickSpAdd()
			.selectServicePopulation(ServicePopulations.CHILDRENS.getIndex())
			.clickSpComplete()
			.PagesAvailableAccord()
			.clickComplete()
			.DataTable()
			.clickPopupOk()
			.TypesPage()
			.clickSubmitExit()
			.GetSource()
			.SeleniumHelper()
			.sleep(5);
		return TypeName;
	}
	
	public String addCompleteTypeUnlockedGetName() {
		String TypeName = "TC_Types_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source	
			.AdministratorNavigator()
			.clickTypes()
			.clickAdd()
			.TypesPage()
			.selectAppModule(AppModule.NOTES.getIndex())
			.setName(TypeName)
			.selectLockTime(LockTime.NEVER.getIndex())
			.selectAppAreaToConductType(AppAreaConductType.BOTH.getIndex())
			.clickAdd()
			.PagesAvailableAccord()
			.setPage(DataFixForm)
			.setSortOrder(OneN)
			.GetSource()
			.RolesAvailableAccord()
			.clickRolesAdd()
			.selectRole(Roles.ALLAPPS.getIndex())
			.clickRolesComplete()
			.PagesAvailableAccord()
			.clickServicePopulationAvailableAccord()
			.clickSpAdd()
			.selectServicePopulation(ServicePopulations.CHILDRENS.getIndex())
			.clickSpComplete()
			.PagesAvailableAccord()
			.clickComplete()
			.DataTable()
			.clickPopupOk();
		return TypeName;
	}
	
	public TypesPage addCompleteTypeAndSubmit(String name, String startDate, String endDate, int module, int lockTime, String description, boolean multiple,
			boolean lockForUse, int appArea, String page, int pageSortOrder, String triggeredByPage, String triggeredByQuestion, LinkedList<String> triggeredByAnswer, 
			boolean required, boolean active, String role, String roleStartDate, String roleEndDate, boolean add, boolean edit, boolean view, 
			String roleDescription, String servicePopulation, String spStartDate, String spEndDate, String servicePopulationDescription) {
		Source
			.AdministratorNavigator()
			.clickTypes()
			.clickAdd()
			.TypesPage()
			.selectAppModule(module)
			.setName(name == null ? TypeName : name)
			//.setStartDate(startDate == null ? Today : startDate, EmptyString)
			.setEndDate(endDate == null ? EmptyString : endDate)
			.setDescription(Description == null ? EmptyString : description)
			.GetSource()
			.TypesPage()
			.selectLockTime(lockTime)
			.selectAppAreaToConductType(appArea);

		if((multiple && MultipleAllowedFlag.getAttribute("last-val").equals("false"))
				|| (!multiple && MultipleAllowedFlag.getAttribute("last-val").equals("true")))
		Source.TypesPage().clickMultipleAllowed();
		
		Source.PagesAvailableAccord().addPage(page, pageSortOrder, triggeredByPage, triggeredByQuestion, triggeredByAnswer, required, active);	
		
		Source.RolesAvailableAccord().addRole(roleStartDate, roleEndDate, role, edit, add, view, roleDescription);

		Source.ServicePopulationsAvailableAccord().clickServicePopulationAvailableAccord().addServicePopulation(spStartDate, spEndDate, servicePopulation, servicePopulationDescription);
		
		Source	.PagesAvailableAccord()
				.clickComplete()
				.DataTable()
				.clickPopupOk();

		if((lockForUse && LockedForUseFlag.getAttribute("last-val").equals("false"))
				|| (!lockForUse && LockedForUseFlag.getAttribute("last-val").equals("true")))
			Source.TypesPage().clickLockForUseToggle().clickYes();
			
		Source.TypesPage()
			.clickSubmitExit()
			.GetSource()
			.SeleniumHelper()
			.sleep(5);
		return new TypesPage(DriverFactory.getDriver());
	}
	
	public TypesPage addCompleteTypeLockedAndSubmit() {
		String TypeName = "TC_Types_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source	
			.AdministratorNavigator()
			.clickTypes()
			.clickAdd()
			.TypesPage()
			.selectAppModule(AppModule.NOTES.getIndex())
			.setName(TypeName)
			.selectLockTime(LockTime.NEVER.getIndex())
			.selectAppAreaToConductType(AppAreaConductType.BOTH.getIndex())
			.clickAdd()
			.PagesAvailableAccord()
			.setPage(DataFixForm)
			.setSortOrder(OneN)
			.GetSource()
			.RolesAvailableAccord()
			.clickRolesAdd()
			.selectRole(Roles.ALLAPPS.getIndex())
			.clickRolesComplete()
			.PagesAvailableAccord()
			.clickServicePopulationAvailableAccord()
			.clickSpAdd()
			.selectServicePopulation(ServicePopulations.CHILDRENS.getIndex())
			.clickSpComplete()
			.PagesAvailableAccord()
			.clickComplete()
			.DataTable()
			.clickPopupOk()
			.TypesPage()
			.clickLockForUseToggle()
			.clickYes()
			.TypesPage()
			.clickSubmitExit()
			.GetSource()
			.SeleniumHelper()
			.sleep(5);
		return new TypesPage(DriverFactory.getDriver());
	}
	
	public String addCompleteTypeLockedGetNameAndSubmit() {
		String TypeName = "TC_Types_Selenium " + SeleniumHelper.generateRandomNumber(8);
		Source	
			.AdministratorNavigator()
			.clickTypes()
			.clickAdd()
			.TypesPage()
			.selectAppModule(AppModule.NOTES.getIndex())
			.setName(TypeName)
			.selectLockTime(LockTime.NEVER.getIndex())
			.selectAppAreaToConductType(AppAreaConductType.BOTH.getIndex())
			.clickAdd()
			.PagesAvailableAccord()
			.setPage(DataFixForm)
			.setSortOrder(OneN)
			.GetSource()
			.RolesAvailableAccord()
			.clickRolesAdd()
			.selectRole(Roles.ALLAPPS.getIndex())
			.clickRolesComplete()
			.PagesAvailableAccord()
			.clickServicePopulationAvailableAccord()
			.clickSpAdd()
			.selectServicePopulation(ServicePopulations.CHILDRENS.getIndex())
			.clickSpComplete()
			.PagesAvailableAccord()
			.clickComplete()
			.DataTable()
			.clickPopupOk()
			.TypesPage()
			.clickLockForUseToggle()
			.clickYes()
			.TypesPage()
			.clickSubmitExit()
			.GetSource()
			.SeleniumHelper()
			.sleep(5);
		return TypeName;
	}

	public TypesPage endDateType(String type) {
		String searchType = (type == null ? TypePrefix : type);
		Source
			.AdministratorNavigator()
			.clickTypes()
			.GetSource()
			.DataTable()
			.setSearch(searchType)
			.clickFirstRow()
			.clickEdit()
			.TypesPage()
			.setEndDate(Today, EmptyString)
			.GetSource()
			.TypesPage()
			.clickSubmitExit()
			.GetSource()
			.SeleniumHelper()
			.sleep(5);
		return this;
	}
		
	public TypesPage lockType(String type) {
		String searchType = (type == null ? TypePrefix : type);
		Source
			.AdministratorNavigator()
			.clickTypes()
			.GetSource()
			.DataTable()
			.setSearch(searchType)
			.clickFirstRow()
			.clickEdit()
			.TypesPage()
			.clickLockForUseToggle()
			.clickYes()
			.TypesPage()
			.clickSubmitExit()
			.GetSource()
			.SeleniumHelper()
			.sleep(5);
		return this;
	}

	public TypesPage addType(String name, String startDate, String endDate, int module, int lockTime, String description, boolean multiple,
			boolean lockForUse, int appArea) {
		Source
			.AdministratorNavigator()
			.clickTypes()
			.clickAdd()
			.TypesPage()
			.selectAppModule(module)
			.setName(name == null ? TypeName : name)
			//.setStartDate(startDate == null ? Today : startDate, EmptyString)
			.setEndDate(endDate == null ? EmptyString : endDate)
			.setDescription(Description == null ? EmptyString : description)
			.GetSource()
			.TypesPage()
			.selectLockTime(lockTime)
			.selectAppAreaToConductType(appArea);
	
		if((multiple && MultipleAllowedFlag.getAttribute("last-val").equals("false"))
				|| (!multiple && MultipleAllowedFlag.getAttribute("last-val").equals("true")))
		Source.TypesPage().clickMultipleAllowed();
		return this;
	}

	public String isTestFormEnabled() {
		return Boolean.toString(TestFormBtn.isEnabled());
	}

	public String isTypesPageContentDisplayed() {
		
		return Boolean.toString(Source.SeleniumHelper().checkWebElementExists(TestRenderTypePageActive) 
				 && TestRenderTypePageContent.isDisplayed());
	}
}
