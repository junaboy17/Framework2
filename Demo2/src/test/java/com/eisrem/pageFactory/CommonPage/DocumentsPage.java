package com.eisrem.pageFactory.CommonPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * This page is used by both people and organizations
 */
public class DocumentsPage extends DataTable{

	public DocumentsPage(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='title']")
	public WebElement TitleTextbox;
	
	@FindBy(xpath="//a[@id='downloadLink']")
	public WebElement DocumentLink;
	
	@FindBy(xpath="//input[@id='documentFile']")
	public WebElement DocumentChooseFileBtn;
	
	@FindBy(xpath="//label[contains(text(),'PDF Document')]")
	public WebElement DocumentLabel;
	
	public DocumentsPage clickDocumentLink() {
		Source.SeleniumHelper().clickElement(DocumentLink);
		return this;
	}
	
	public String readDocumentLabel() {
		return Source.SeleniumHelper().readElement(DocumentLabel);
	}
	
	public DocumentsPage setTitle(String value, String... Clear) {
		Source.SeleniumHelper().setText(TitleTextbox, value, Clear);
		return this;
	}

	public DocumentsPage endDatePeopleDocument(String personSearchTerm, String documentSearchTerm) {
		Source	.NavigationMenuBar()
				.clickPeople()
				.setSearch(personSearchTerm == null ? FullName : personSearchTerm)
				.clickFirstRow()
				.clickAnchor()
				.PeopleNavigator()
				.clickDocumentsTab()
				.setSearch(documentSearchTerm == null ? DocumentPrefix : documentSearchTerm)
				.clickFirstRow()
				.clickEdit()
				.DocumentsPage()
				.setEndDate(Today, Clear)
				.clickYes()
				.Pagefactory()
				.clickSubmit()
				.clickPopupOk();
				
		return this;
	}
	
	public DocumentsPage endDateOrganizationDocument(String orgSearchTerm, String documentSearchTerm) {
		Source	.NavigationMenuBar()
				.clickOrganization()
				.setSearch(orgSearchTerm == null ? OrganizationPrefix : orgSearchTerm)
				.clickFirstRow()
				.clickAnchor()
				.OrganizationNavigator()
				.clickDocuments()
				.setSearch(documentSearchTerm == null ? DocumentPrefix : documentSearchTerm)
				.clickFirstRow()
				.clickEdit()
				.DocumentsPage()
				.setEndDate(Today, Clear)
				.clickYes()
				.Pagefactory()
				.clickSubmit()
				.clickPopupOk();
				
		return this;
	}

	public DocumentsPage setDocumentFile(String documentPath, String documentFile) {
		Source.SeleniumHelper().uploadFile(DocumentChooseFileBtn, documentPath, documentFile);
		return this;
	}



}
