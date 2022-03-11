package com.eisrem.pageFactory.CommonPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.Hooks.MainPage;
import com.eisrem.pageFactory.Admin.LogInPage;

public class Pagefactory extends MainPage{

	public Pagefactory(WebDriver driver) {
		driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}

	public ObjectSource GetSource() {
		return new ObjectSource();
	}

	public DataTable DataTable() {
		return new DataTable(DriverFactory.getDriver());
	}
	
	//User Menu---------------------------------------------------------------------------------
	
	@FindBy(xpath="//a[@data-aria-label='User menu']")
	public WebElement UserMenu;
	
	@FindBy(xpath="//a[contains(@href,'changePassword')]")
	public WebElement ChangePassword;
	
	@FindBy(xpath="//a[contains(@href,'formSubmit')]")
	public WebElement Logout;
	
	//Common Msg -------------------------------------------------------------------------------
	
	@FindBy(xpath="//div[@id='infoBar']")
	public WebElement AnchoredInfo;
		
	//------------------------------------------------------------------------------------------

	//Pop Up Function --------------------------------------------------------------------------
	@FindBy(xpath="//h4[@id='commonPopupLabel']")
	public WebElement PopUpTitle;

	@FindBy(xpath="//div[@id='commonPopupBody']")
	public WebElement PopUpMessage;

	@FindBy(xpath="//button[contains(text(),'OK')] | //button[contains(text(),'Ok')]")
	public WebElement OkBtn;

	@FindBy(xpath="//button[contains(text(),'Save')]")
	public WebElement SaveBtn;

	@FindBy(xpath="//button[contains(text(),'Yes')]")
	public WebElement YesBtn;

	@FindBy(xpath="//button[contains(text(),'No')]")
	public WebElement NoBtn;

	@FindBy(xpath="//button[contains(text(),'Discard')]")
	public WebElement DiscardBtn;

	@FindBy(xpath="//div[@id='commonPopup']//button[contains(text(),'Continue')]")
	public WebElement PopUpContinue;
	
	@FindBy(xpath="//button[contains(text(),'Go back to List')]")
	public WebElement GoBackToListBtn;
	
	@FindBy(xpath="//button[contains(text(),'Back To Inbox')]")
	public WebElement GoBackToInboxBtn;

	@FindBy(xpath="//button[@onclick='resetIdleTime()']")
	public WebElement KeepLoggedInBtn;

	@FindBy(xpath="//a[contains(@href,'formSubmit') ]")
	public WebElement LogoutLink;
	
	@FindBy(xpath="//button[@onclick='formSubmit()']")
	public WebElement LogMeOffBtn;
		
	//---------------------------------------- ---------------------------------------------------

	//Common Text Box ----------------------------------------------------------------------------

	@FindBy(xpath="//label[contains(text(),'Description')]")
	public WebElement DescriptionTitle;

	@FindBy(xpath="//textarea[contains(@id,'Desc')] | //textarea[contains(@id,'desc')]")
	public WebElement DescriptionTextBox;
	
	@FindBy(xpath="//textarea[contains(@id,'ReviewCompletedDate')] | //textarea[contains(@id,'ReviewCompletedDate')]")
	public WebElement ReviewCompletedDate;
	
	@FindBy(xpath="//label[contains(text(),'Notes')]")
	public WebElement NotesTitle;

	//---------------------------------------- ---------------------------------------------------

	//Common Button Function ---------------------------------------------------------------------

	@FindBy(xpath="//button[contains(text(),'Print')]")
	public WebElement PrintBtn;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement SubmitBtn;
	
	@FindBy(xpath="//button[contains(text(),'Complete')]")
	public WebElement CompleteBtn;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	public WebElement ContinueBtn;
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	public WebElement CancelBtn;
	
	@FindBy(xpath="//button[contains(text(),'Back To List')] | //button[contains(text(),'back to List')]")
	public WebElement BackToListBtn;
	
	@FindBy(xpath="//button[contains(text(),'Back To')]")
	public WebElement BackToBtn;
		
	@FindBy(xpath="//button[contains(text(),'Back')]")
	public WebElement BackBtn;
	
	@FindBy(xpath="//a[contains(@id,'releaseAnchor')]")
	public WebElement clearAnchor;

	//-------------------------------------------------------------------------------------------

	//-----------------------------------------------------------------------------------------

	@FindBy(xpath="//td[contains(@aria-label,'End Date')]")
	public List<WebElement> AllEndDate;

	//Dates Function --------------------------------------------------------------------------

	@FindBy(xpath="//label[contains(@for,'startDate')]")
	public WebElement StartDateTitle;

	@FindBy(xpath="//input[contains(@id,'startDate')]")
	public WebElement StartDateTextBox;
	
	@FindBy(xpath="//input[contains(@id,'startDate')]/..//span")
	public WebElement StartDateIcon;

	@FindBy(xpath="//label[contains(@for,'endDate')]")
	public WebElement EndDateTitle;

	@FindBy(xpath="//input[contains(@id,'endDate')]")
	public WebElement EndDateTextBox;
	
	@FindBy(xpath="//input[contains(@id,'endDate')]/..//span")
	public WebElement EndDateIcon;
		
	@FindBy(xpath="//div[contains(@class, 'datepicker-dropdown')]")
	public WebElement DatePickerTable;

	//---------------------------------------- ---------------------------------------------------

	//Common Toggles ---------------------------------------------------------------------------

	@FindBy(xpath="//label[contains(text(),'Active')]")
	public WebElement ActiveBtnTitle;

	@FindBy(xpath="//label[contains(text(),'Active')]/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement ActiveToggle;

	@FindBy(xpath="//label[contains(text(),'Active')]/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement ActiveToggleAttribute;

	@FindBy(xpath="//label[contains(text(),'Lock For Use')]")
	public WebElement LockForUseTitle;

	@FindBy(xpath="//label[contains(text(),'Lock For Use')]/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement LockForUseToggle;

	@FindBy(xpath="//label[contains(text(),'Lock For Use')]/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement LockForUseToggleAttribute;


	//Error Message---------------------------------------- ---------------------------------------------------
	
	@FindBy(xpath="//li[@class='list-group-item list-group-item-danger']")
	public WebElement ErrorMessage;
	
	//Common Msg -------------------------------------------------------------------------------
	
	public String readAnchoredInfo() {
		return Source.SeleniumHelper().readElement(AnchoredInfo);
	}
	
	//------------------------------------------------------------------------------------------

	//Pop Up Function --------------------------------------------------------------------------
	public String readPopUpTitle() {
		return Source.SeleniumHelper().readElement(PopUpTitle);
	}

	public ObjectSource clickPopupOk() {
		Source.SeleniumHelper().clickElement(OkBtn);
		return new ObjectSource();
	}
	
	public ObjectSource clickPopupOkIfExist() {
		if(Source.SeleniumHelper().ifWebElementExists(OkBtn)) {
			OkBtn.click();
		}
		return new ObjectSource();
	}
	
	public String isPopupPresent(int seconds) {
		Source.SeleniumHelper().sleep(seconds);
		return Boolean.toString(Source.SeleniumHelper().ifWebElementExists(OkBtn));
	}
	
	public String isSaveDiscardPopupPresent(int seconds) {
		Source.SeleniumHelper().sleep(seconds);
		return Boolean.toString(Source.SeleniumHelper().ifWebElementExists(DiscardBtn));
	}
	
	public Boolean isReadOnly() {
		//return Source.SeleniumHelper().readElement(ReviewCompletedDate);
	//	String readOnly =
				WebElement elemnet= Source.SeleniumHelper().getWebElement(ReviewCompletedDate);
				String readOnly =elemnet.getAttribute("readOnly");
				return readOnly ==null;
	}

	public String readDiscardBtn() {
		return Source.SeleniumHelper().readElement(DiscardBtn);
	}

	public ObjectSource clickDiscard() {
		Source.SeleniumHelper().clickElement(DiscardBtn);
		return new ObjectSource();
	}

	public ObjectSource clickSave() {
		Source.SeleniumHelper().clickElement(SaveBtn);
		return new ObjectSource();
	}

	public ObjectSource clickYes() {
		Source.SeleniumHelper().clickElement(YesBtn);
		return new ObjectSource();
	}

	public ObjectSource clickNo() {
		Source.SeleniumHelper().clickElement(NoBtn);
		return new ObjectSource();
	}

	public ObjectSource clickPopUpContinue() {
		Source.SeleniumHelper().clickElement(PopUpContinue);
		return new ObjectSource();
	}
	
	public String readPopUpContinueBtn() {
		return Source.SeleniumHelper().readElement(PopUpContinue);
	}
	
	public ObjectSource clickGoBackToList() {
		Source.SeleniumHelper().clickElement(GoBackToListBtn);
		return new ObjectSource();
	}
	
	public String readGoBackToListBtn() {
		return Source.SeleniumHelper().readElement(GoBackToListBtn);
	}
	
	public ObjectSource clickGoBackToInbox() {
		Source.SeleniumHelper().clickElement(GoBackToInboxBtn);
		return new ObjectSource();
	}

	public String readPopUpMessage() {
		return Source.SeleniumHelper().readElement(PopUpMessage);
	}

	public ObjectSource clickKeepMeLoggedIn() {
		Source.SeleniumHelper().clickElement(KeepLoggedInBtn);
		return new ObjectSource();
	}

	public LogInPage clickLogout() {
		Source.SeleniumHelper().clickElement(LogoutLink);
		return new LogInPage(DriverFactory.getDriver());
	}
	
	public LogInPage clickLogMeOff() {
		Source.SeleniumHelper().clickElement(LogMeOffBtn);
		return new LogInPage(DriverFactory.getDriver());
	}

		
	//--------------------------------------------------------------------------------------------

	//Common Text Box ----------------------------------------------------------------------------

	public String readDescriptionTitle() {
		return Source.SeleniumHelper().readElement(DescriptionTitle);
	}
	
	public Pagefactory setDescription(String description, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, description + Keys.TAB, Clear);
		return new Pagefactory(DriverFactory.getDriver());
	}
	
	public String readDescriptionTextBoxValue() {
		return Source.SeleniumHelper().readElement(DescriptionTextBox);
	}

	public String readNotesTitle() {
		return Source.SeleniumHelper().readElement(NotesTitle);
	}
	
	public Pagefactory setNotes(String note, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, note + Keys.TAB, Clear);
		return new Pagefactory(DriverFactory.getDriver());
	}
	
	public Pagefactory setMessages(String message, String... Clear) {
		Source.SeleniumHelper().setText(DescriptionTextBox, message + Keys.TAB, Clear);
		return new Pagefactory(DriverFactory.getDriver());
	}

	//---------------------------------------- ---------------------------------------------------

	//Common Button Function ---------------------------------------------------------------------

	public ObjectSource clickComplete() {
		Source.SeleniumHelper().clickElement(CompleteBtn);
		return new ObjectSource();
	}
	
	public ObjectSource clickCompleteAndOk() {
		Source.SeleniumHelper().clickElement(CompleteBtn).GetSource().DataTable().clickPopupOk();
		return new ObjectSource();
	}
	
	public String readCompleteBtn() {
		return Source.SeleniumHelper().readElement(CompleteBtn);
	}
	
	public ObjectSource clickContinue() {
		Source.SeleniumHelper().clickElement(ContinueBtn);
		return new ObjectSource();
	}
	
	public String readContinueBtn() {
		return Source.SeleniumHelper().readElement(ContinueBtn);
	}
	
	public ObjectSource clickCancel() {
		Source.SeleniumHelper().clickElement(CancelBtn);
		return new ObjectSource();
	}
	
	public String readCancelBtn() {
		return Source.SeleniumHelper().readElement(CancelBtn);
	}
	
	public Pagefactory clickPrint() {
		Source.SeleniumHelper().clickElement(PrintBtn);
		return this;
	}
	
	public String readPrintBtn() {
		return Source.SeleniumHelper().readElement(PrintBtn);
	}
	
	public Pagefactory clickSubmit() {
		Source.SeleniumHelper().clickElement(SubmitBtn);
		return this;
	}
	
	public Pagefactory clickSubmit(int sec) {
		Source	.SeleniumHelper()
				.clickElement(SubmitBtn)
				.Wait(sec);
		return this;
	}
	
	public String readSubmitBtn() {
		return Source.SeleniumHelper().readElement(SubmitBtn);
	}
	
	public String readBackToListBtn() {
		return Source.SeleniumHelper().readElement(BackToListBtn);
	}
	
	public String readBackToBtn() {
		return Source.SeleniumHelper().readElement(BackToBtn);
	}
	
	public ObjectSource clickBackToList() {
		Source.SeleniumHelper().clickElement(BackToListBtn);
		return new ObjectSource();
	}
	
	public ObjectSource clickBack() {
		Source.SeleniumHelper().clickElement(BackBtn);
		return new ObjectSource();
	}
	
	public ObjectSource clickBackTo() {
		Source.SeleniumHelper().clickElement(BackToBtn);
		return new ObjectSource();
	}
	
	public Pagefactory releaseAnchor() {
		Source.SeleniumHelper().clickElement(clearAnchor);
		this.clickSave();
		return this;
	}
	

	//-------------------------------------------------------------------------------------------

	//Dates Function --------------------------------------------------------------------------
	public String readStartDateTitle() {
		return Source.SeleniumHelper().readElement(StartDateTitle);
	}

	public DataTable setStartDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(StartDateTextBox, date, true, Clear);
		return new DataTable(DriverFactory.getDriver());
	}

	public String readStartDateValue() {
		return Source.SeleniumHelper().getWebElement(StartDateTextBox).getAttribute("original-val");
	}
	
	public DataTable clickStartDateIcon() {
		Source.SeleniumHelper().clickElement(StartDateIcon);
		return new DataTable(DriverFactory.getDriver());
	}

	public String readEndDateTitle() {
		return Source.SeleniumHelper().readElement(EndDateTitle);
	}

	public Pagefactory setEndDate(String date, String... Clear) {
		Source.SeleniumHelper().setText(EndDateTextBox, date + Keys.TAB, Clear);
		return new Pagefactory(DriverFactory.getDriver());
	}
	
	public String readEndDateValue() {
		return Source.SeleniumHelper().getWebElement(EndDateTextBox).getAttribute("last-val");
	}
	
	public DataTable clickEndDateIcon() {
		Source.SeleniumHelper().clickElement(EndDateIcon);
		return new DataTable(DriverFactory.getDriver());
	}
	
	public String readOriginalEndDateValue() {
		return Source.SeleniumHelper().getWebElement(EndDateTextBox).getAttribute("original-val");
	}
	//---------------------------------------- ---------------------------------------------------


	//Menu Functions----------------------------------------------------------------------------
	
	public Pagefactory expandUserMenu() {
		Source.SeleniumHelper().clickElement(UserMenu);
		return this;
	}
	
	public Pagefactory selectChangePassword() {
		Source.SeleniumHelper().clickElement(ChangePassword);
		return this;
	}
	
	public Pagefactory selectLogout() {
		Source.SeleniumHelper().clickElement(Logout);
		return this;
	}

	//------------------------------------------------------------------------------------------


	//Common Toggles ---------------------------------------------------------------------------

	public String readActiveTitle() {
		return Source.SeleniumHelper().readElement(ActiveBtnTitle);
	}

	public Pagefactory clickActiveToggle() {
		Source.SeleniumHelper().clickElement(ActiveToggle);
		return this;
	}

	public String readActiveToggle() {
		return ActiveToggleAttribute.getAttribute("last-val");
	}
	
	public String readIfActiveToggleDisabled() {
		return ActiveToggleAttribute.getAttribute("disabled");
	}
	
	public Pagefactory clickActiveToggle(String value) {
		String active = readActiveToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickActiveToggle();
		}
		return this;
	}

	public String readLockForUseTitle() {
		return Source.SeleniumHelper().readElement(LockForUseTitle);
	}

	public String readLockforUseToggle() {
		return LockForUseToggleAttribute.getAttribute("last-val");
	}

	public Pagefactory clickLockForUseToggle() {
		Source.SeleniumHelper().clickElement(LockForUseToggle);
		return this;
	}

	public Pagefactory clickLockForUseToggle(String value) {
		String lock = readLockforUseToggle();

		if(value.equalsIgnoreCase(lock)) {

		}
		else {
			clickLockForUseToggle();
		}
		return this;
	}

	//------------------------------------------------------------------------------------------

	//Error Message ----------------------------------------------------------------------------

	//Will read top error message with given num

	public String readTopErrorMessage(int Num) {
		By data = By.xpath("//li[@class='list-group-item list-group-item-danger'][" + Num + "]");
		return Source.SeleniumHelper().readElement(data);
	}
	

	//------------------------------------------------------------------------------------------
	

	public String isPopupExist() {
		return Boolean.toString(Source.SeleniumHelper().checkWebElementExists(PopUpTitle));
	}
}
