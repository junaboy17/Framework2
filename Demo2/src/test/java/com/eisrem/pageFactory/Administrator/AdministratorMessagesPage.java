package com.eisrem.pageFactory.Administrator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.pageFactory.CommonPage.RolesAvailableAccord;
import com.eisrem.pageFactory.CommonPage.ServicePopulationsAvailableAccord;

public class AdministratorMessagesPage extends AdministratorNavigator{

	public AdministratorMessagesPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h3[contains(text(),'Add Administrator Message')]")
	public WebElement AddAdministratorMessageTitle;

	@FindBy(xpath="//p[@class='required-note']")
	public WebElement NoteTitle;

	@FindBy(xpath="//a[contains(text(),'Administrator Message:')]")
	public WebElement AdministratorMessageLink;
	
	@FindBy(xpath="//li[@id='message-tab']")
	public WebElement MessageTab;

	@FindBy(xpath="//label[@for='messageType']")
	public WebElement MessageTypeTitle;

	@FindBy(xpath="//select[@id='messageType']")
	public WebElement MessageTypeDropDown;

	@FindBy(xpath="//label[contains(text(),'Message:')]")
	public WebElement MessageTitle;

	@FindBy(xpath="//textarea[@id='desc']")
	public WebElement MessageTextBox;

	@FindBy(xpath="//label[contains(text(),'Internal?')]")
	public WebElement InternalToggleTitle;

	@FindBy(xpath="//label[contains(text(),'Internal')]/..//div[contains(@class,'bootstrap-switch bootstrap')]")
	public WebElement InternalToggle;

	@FindBy(xpath="//label[contains(text(),'Internal')]/..//div[contains(@class,'bootstrap-switch bootstrap')]//input")
	public WebElement InternalToggleAttribute;

	@FindBy(xpath="//a[contains(text(),'Roles Available:')]")
	public WebElement RolesAvailableAccord;
	
	
	@FindBy(xpath="//a[contains(text(),'Service Population')]")
	public WebElement ServicePopulationsAvailableAccord;

	@FindBy(xpath="//button[contains(text(),'Submit & Exit')]")
	public WebElement SubmitExitBtn;

	@FindBy(xpath="//button[contains(text(),'Back To Administrator Messages')]")
	public WebElement BackToAdministratorMessagesBtn;

	public String readAddAdministratorMessagePageTitle() {
		return Source.SeleniumHelper().readElement(AddAdministratorMessageTitle);
	}

	public String readNoteTitle() {
		return Source.SeleniumHelper().readElement(NoteTitle);
	}

	public AdministratorMessagesPage selectMessagesType(int index) {
		Source.SeleniumHelper().select(MessageTypeDropDown, index);
		return this;
	}

	public String readAdministratorMessagelinkTitle() {
		return Source.SeleniumHelper().readElement(AdministratorMessageLink);
	}

	public AdministratorMessagesPage clickAdministratorMessageLinkTitle() {
		Source.SeleniumHelper().clickElement(AdministratorMessageLink);
		return this;
	}

	public String readAdministratorMessageMessageTabTitle() {
		return Source.SeleniumHelper().readElement(MessageTab);
	}

	public String readMessageTypeTitle() {
		return Source.SeleniumHelper().readElement(MessageTypeTitle);
	}

	public String readMessageTitle() {
		return Source.SeleniumHelper().readElement(MessageTitle);
	}



	public String readInternalToggleTitle() {
		return Source.SeleniumHelper().readElement(InternalToggleTitle);
	}

	public AdministratorMessagesPage clickInternalToggle() {
		Source.SeleniumHelper().clickElement(InternalToggle);
		return this;
	}

	public String readInternalToggle() {
		return InternalToggleAttribute.getAttribute("last-val");
	}

	public AdministratorMessagesPage clickInternalToggle(String value) {
		String active = readInternalToggle();

		if(value.equalsIgnoreCase(active)) {

		}
		else {
			clickInternalToggle();
		}
		return this;
	}

	public String readRolesAvailablelinkTitle() {
		return Source.SeleniumHelper().readElement(RolesAvailableAccord);
	}

	public RolesAvailableAccord clickRolesAvailableLink() {
		Source.SeleniumHelper().clickElement(RolesAvailableAccord);
		return new RolesAvailableAccord(DriverFactory.getDriver());
	}
	
	public ServicePopulationsAvailableAccord clickServicePopulationAvailableAccord() {
		Source.SeleniumHelper().clickElement(ServicePopulationsAvailableAccord);
		return new ServicePopulationsAvailableAccord(DriverFactory.getDriver());
	}

	public String readSubmitExitBtn() {
		return Source.SeleniumHelper().readElement(SubmitExitBtn);
	}

	public AdministratorMessagesPage clickSubmitExit() {
		Source.SeleniumHelper().clickElement(SubmitExitBtn);
		return this;
	}

	public String readBackToAdministratorMessagesBtn() {
		return Source.SeleniumHelper().readElement(BackToAdministratorMessagesBtn);
	}

	public AdministratorMessagesPage clickBackToAdministratorMessages() {
		Source.SeleniumHelper().clickElement(BackToAdministratorMessagesBtn);
		return this;
	}
	
	public AdministratorMessagesPage AddAdministratorMessage(String endDate, int Index, String Message, String Internal, String AMActive) {
		Source		.DataTable()
					.clickAdd()
					.AdministratorMessagesPage()
					.setEndDate(endDate, Clear)
					.GetSource()
					.AdministratorMessagesPage()
					.selectMessagesType(Index)
					.clickInternalToggle(Internal)
					.clickActiveToggle(AMActive)
					.setMessages(Message, Clear)
					.clickSubmit()
					.clickPopupOk();
		return this;
	}
	
	public AdministratorMessagesPage FillAdministratorMessage(int Index, String Message, String Internal, String AMActive) {
		Source		.DataTable()
					.clickAdd()	
					.AdministratorMessagesPage()
					.GetSource()
					.AdministratorMessagesPage()
					.selectMessagesType(Index)
					.clickInternalToggle(Internal)
					.clickActiveToggle(AMActive)
					.setMessages(Message, Clear);
		return this;
	}
	
	public AdministratorMessagesPage AddAdministratorMessageAndRolesAvailable(String startDate, int messageType, String Message, String Internal, String AMActive, String roleName, String roleActive, String description) {
		Source		.AdministratorMessagesPage()
					.FillAdministratorMessage(messageType, Message, Internal, AMActive)
					.GetSource()
					.RolesAvailableAccord()
					.addRole(startDate, roleName, description, roleActive)
					.clickSubmit()
					.clickPopupOk();
		return this;
	}
	
	public AdministratorMessagesPage AddAdministratorMessageAndSP(String startDate, String endDate, int messageType, String Message, String Internal, String AMActive, String description, String SPName) {
		Source		.AdministratorMessagesPage()
					.FillAdministratorMessage(messageType, Message, Internal, AMActive)
					.GetSource()
					.ServicePopulationsAvailableAccord()
					.addServicePopulation(startDate, endDate, SPName, description)
					.clickSubmit()
					.clickPopupOk();
		return this;
	}
	
	public AdministratorMessagesPage AddAdministratorMessageAndRolesAvailableAndSP(int messageType, String Message, String Internal, String AMActive, String roleName, String roleActive, String description, int SPName, String SPActive) {
		Source		.AdministratorMessagesPage()
					.FillAdministratorMessage(messageType, Message, Internal, AMActive)
					.GetSource()
					.RolesAvailableAccord()
					.addRole(roleName, description, roleActive)
					.GetSource()
					.ServicePopulationsAvailableAccord()
					.addServicePopulation(SPName, description, SPActive)
					.clickSubmit()
					.clickPopupOk();
		return this;
	}

}
