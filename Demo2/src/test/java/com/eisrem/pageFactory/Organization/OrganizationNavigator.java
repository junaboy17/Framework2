package com.eisrem.pageFactory.Organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.ObjectSource;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.pageFactory.CommonPage.AddressPage;
import com.eisrem.pageFactory.CommonPage.DataTable;
import com.eisrem.pageFactory.CommonPage.DocumentsPage;
import com.eisrem.pageFactory.CommonPage.IdentifiersPage;

public class OrganizationNavigator extends DataTable{


	public OrganizationNavigator(WebDriver driver) {
		super (driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@id='1_Organization_tab']")
	public WebElement OrganizationsTab;

	@FindBy(xpath="//li[@id='2_Location_tab']")
	public WebElement LocationsTab;

	@FindBy(xpath="//li[@id='4_User_tab']")
	public WebElement UsersStaffTab;

	@FindBy(xpath="//li[@id='6_ServicesSpecialties_tab']")
	public WebElement ServicesSpecialtiesTab;

	@FindBy(xpath="//li[@id='3_Address_tab']")
	public WebElement AddressTab;

	@FindBy(xpath="//li[@id='13_Identifier_tab']")
	public WebElement IdentifierTab;

	@FindBy(xpath="//li[@id='5_Status_tab']")
	public WebElement StatusTab;

	@FindBy(xpath="//li[@id='46_Documents_tab']")
	public WebElement DocumentsTab;


	public String readOrganizationsTab() {
		return Source.SeleniumHelper().readElement(OrganizationsTab);
	}

	public OrganizationPage clickOrganizations() {
		Source.SeleniumHelper().clickElement(OrganizationsTab);
		return new OrganizationPage(DriverFactory.getDriver());
	}

	public String readLocationsTab() {
		return Source.SeleniumHelper().readElement(LocationsTab);
	}

	public LocationsPage clickLocations() {
		Source.SeleniumHelper().clickElement(LocationsTab);
		return new LocationsPage(DriverFactory.getDriver());
	}

	public String readUsersStaffTab() {
		return Source.SeleniumHelper().readElement(UsersStaffTab);
	}

	public UserStaffPage clickUsersStaff() {
		Source.SeleniumHelper().clickElement(UsersStaffTab);
		return new UserStaffPage(DriverFactory.getDriver());
	}

	public String readServicesSpecialtiesTab() {
		return Source.SeleniumHelper().readElement(ServicesSpecialtiesTab);
	}

	public ObjectSource clickServicesSpecialties() {
		Source.SeleniumHelper().clickElement(ServicesSpecialtiesTab);
		return new ObjectSource();
	}

	public String readAddressTab() {
		return Source.SeleniumHelper().readElement(AddressTab);
	}

	public AddressPage clickAddress() {
		Source.SeleniumHelper().clickElement(AddressTab);
		return new AddressPage(DriverFactory.getDriver());
	}

	public String readIdentifierTab() {
		return Source.SeleniumHelper().readElement(IdentifierTab);
	}

	public IdentifiersPage clickIdentifier() {
		Source.SeleniumHelper().clickElement(IdentifierTab);
		return new IdentifiersPage(DriverFactory.getDriver());
	}

	public String readStatusTab() {
		return Source.SeleniumHelper().readElement(StatusTab);
	}

	public ObjectSource clickStatus() {
		Source.SeleniumHelper().clickElement(StatusTab);
		return new ObjectSource();
	}

	public String readDocumentsTab() {
		return Source.SeleniumHelper().readElement(DocumentsTab);
	}

	public DocumentsPage clickDocuments() {
		Source.SeleniumHelper().clickElement(DocumentsTab);
		return new DocumentsPage(DriverFactory.getDriver());
	}

	public boolean isActiveTab(String Tab) {
		if(Tab.equalsIgnoreCase("Organizations")) {
			if(OrganizationsTab.getAttribute("class").equalsIgnoreCase("active")) {
				return true;
			}else {
				return false;
			}

		}
		else if(Tab.equalsIgnoreCase("Locations")) {
			if(LocationsTab.getAttribute("class").equalsIgnoreCase("active")) {
				return true;
			}else {
				return false;
			}
		}
		else if(Tab.equalsIgnoreCase("Users/Staff")) {
			if(UsersStaffTab.getAttribute("class").equalsIgnoreCase("active")) {
				return true;
			}else {
				return false;
			}
		}
		else if(Tab.equalsIgnoreCase("Services/Specialties")) {
			if(ServicesSpecialtiesTab.getAttribute("class").equalsIgnoreCase("active")) {
				return true;
			}else {
				return false;
			}
		}
		else if(Tab.equalsIgnoreCase("Address")) {
			if(AddressTab.getAttribute("class").equalsIgnoreCase("active")) {
				return true;
			}else {
				return false;
			}
		}
		else if(Tab.equalsIgnoreCase("Identifier")) {
			if(IdentifierTab.getAttribute("class").equalsIgnoreCase("active")) {
				return true;
			}else {
				return false;
			}
		}
		else if(Tab.equalsIgnoreCase("Status")) {
			if(StatusTab.getAttribute("class").equalsIgnoreCase("active")) {
				return true;
			}else {
				return false;
			}
		}
		else if(Tab.equalsIgnoreCase("Documents")) {
			if(DocumentsTab.getAttribute("class").equalsIgnoreCase("active")) {
				return true;
			}else {
				return false;
			}
		}else {
			SeleniumHelper.log.info("Incorrect Tab. Please enter a valid tab");
			return false;
		}
	
	}

}
