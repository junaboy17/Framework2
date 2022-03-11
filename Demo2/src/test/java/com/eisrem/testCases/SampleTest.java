package com.eisrem.testCases;

import java.io.File;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.Data;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.AppUtils.Exceptions.SeleniumExceptions;
import com.eisrem.Hooks.AdministratorPage;
import com.eisrem.Hooks.MyHomePage;
import com.eisrem.Hooks.OrganizationPage;
import com.eisrem.Hooks.PeoplePage;

import edu.emory.mathcs.backport.java.util.Arrays;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleTest extends Data{

	//	@Test(priority=1)
	//	public void usernameCheck() {
	//		sa = new SoftAssert();
	//
	//		//User name TitleTextbox Check
	//		Expected = "Username";
	//		Actual = Source.logInPage().usernameTitleText();
	//		sa.assertEquals(Actual, Expected);
	//
	//		//User name test with only User name and blank Password
	//		Source.logInPage()	.enterUserName("usernameonly")
	//							.clickSignIn();
	//
	//		Expected = "Please Enter UserName and Password";
	//		Actual = Source.logInPage().errorMessage();
	//		sa.assertEquals(Actual, Expected);
	//
	//		//User name test with correct Password and bad User name
	//		Source.logInPage()	.resetUserName("baduser")
	//							.resetPassword(basePass)
	//							.clickSignIn();
	//
	//		Expected = "Invalid username and Password. Did you try the Forgotten Password link below? Please contact:\n" + 
	//				"Childrens: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n" + 
	//				"OBH: EIS.OBH@maine.gov";
	//		Actual = Source.logInPage().errorMessage();
	//		sa.assertEquals(Actual, Expected);
	//
	//		sa.assertAll();
	//	}
	//
	//	@Test(priority=2)
	//	public void passwordCheck() {
	//		sa = new SoftAssert();
	//
	//		//Password title check
	//		Expected = "Password";
	//		Actual = Source.logInPage().passwordTitleText();
	//		sa.assertEquals(Actual, Expected);
	//
	//		//Password test with only Password and blank User name
	//		Source.logInPage()	.enterPassword("passwordonly")
	//							.clickSignIn();
	//
	//		Expected = "Please Enter UserName and Password";
	//		Actual = Source.logInPage().errorMessage.getText();
	//		sa.assertEquals(Actual, Expected);
	//
	//		//Password test with valid User name and bad Password
	//		Source.logInPage()	.enterUserName(baseUser)
	//							.resetPassword("badpassword")
	//							.clickSignIn();
	//
	//		Expected = "Invalid username and Password. Did you try the Forgotten Password link below? Please contact:\n" + 
	//				"Childrens: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n" + 
	//				"OBH: EIS.OBH@maine.gov";
	//		Actual = Source.logInPage().errorMessage();
	//		sa.assertEquals(Actual, Expected);
	//
	//		sa.assertAll();
	//	}
	//
	//	@Test(priority=3)
	//	public void logInTest() {
	//		By by = By.xpath("//@[()]");
	//		
	//		try {
	//			Source.PeoplePage()
	//					.clickFirstRow()
	//					.clickAnchor()
	//					.PeopleNavigator()
	//					.clickDocumentsTab()
	//					.clickAdd()
	//					.DocumentsPage()
	//					.setTitle("Test")
	//					.setDocumentFile(DocumentPath, DocumentFile);
	//					
	//			Source.SeleniumHelper().sleep(5);
	//		}catch(NoSuchElementException e){
	//			e.printStackTrace();
	//			throw SeleniumExceptions.NoSuchElementException(by);
	//		}
	//
	//	}
	//	
	//	@Test(priority=6)
	//	public void usernameCheckF() {
	//		sa = new SoftAssert();
	//
	//		//User name TitleTextbox Check
	//		Expected = "Username";
	//		Actual = Source.logInPage().usernameTitleText();
	//		sa.assertEquals(Actual, Expected);
	//
	//		//User name test with only User name and blank Password
	//		Source.logInPage()	.enterUserName("usernameonly")
	//							.clickSignIn();
	//
	//		Expected = "Please Enter UserName and Passwor";
	//		Actual = Source.logInPage().errorMessage();
	//		sa.assertEquals(Actual, Expected);
	//
	//		//User name test with correct Password and bad User name
	//		Source.logInPage()	.resetUserName("baduser")
	//							.resetPassword(basePass)
	//							.clickSignIn();
	//
	//		Expected = "Invalid username and Password. Did you try the Forgotten Password link below? Please contact:\n" + 
	//				"Childrens: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n" + 
	//				"OBH: EIS.OBH@maine.go";
	//		Actual = Source.logInPage().errorMessage();
	//		sa.assertEquals(Actual, Expected);
	//
	//		sa.assertAll();
	//	}


	//@Test(priority=5)
	//	public void sampleTest() {
	//		SoftAssert = new SoftAssert();
	//
	//		try {
	//		SeleniumHelper.log.info("Verifying username title");
	//		Expected = "Usernam";
	//		Actual = Source.LogInPage().readUsernameTitle();
	//		SoftAssert.assertEquals(Actual, Expected);

	//		SeleniumHelper.log.info("Verifying username with valid User and blank Password");
	//		Source.LogInPage()	.setUserName(User)
	//							.clickSignIn();
	//
	//		Expected = "Please Enter UserName and Password";
	//		Actual = Source.LogInPage().readTopErrorMessage2();
	//		SoftAssert.assertEquals(Actual, Expected);
	//
	//		SeleniumHelper.log.info("Verifying username with invalid User and valid Password");
	//		Source.LogInPage()	.setUserName("baduser")
	//							.setPassword(Pass)
	//							.clickSignIn();
	//
	//		Expected = "Invalid username and password. Did you try the Forgotten Password link below? Please contact:\n" + 
	//				"Childrens: Jeanne.tondreau@maine.gov and Lynn.dorso@maine.gov\n" + 
	//				"OBH: EIS.OBH@maine.gov";
	//		Actual = Source.LogInPage().readTopErrorMessage2();
	//		SoftAssert.assertEquals(Actual, Expected);

	//		SoftAssert.assertAll();
	//		
	//		}catch(Exception e) {
	//			Source	.SeleniumHelper()
	//					.assertFail();
	//		}
	//		
	//	}

	//@Test(priority=6)
	//	public void sampleTest2() {
	//		ObjectSource Source = new ObjectSource();
	//		SoftAssert softAssert = new SoftAssert();
	//		String expected;
	//		String actual;
	//		String data = Source.seleniumHelper().getCellData("C:\\Users\\Miah.Arif\\Documents\\Data\\Sample Data.xlsx", "Sheet1", 1, 1);
	//		int row = Source.seleniumHelper().getRowCount("C:\\Users\\Miah.Arif\\Documents\\Data\\Sample Data.xlsx", "Sheet1");
	//		System.out.println(data);
	//		System.out.println(row);
	//System.out.println(Source.dbConnect().getData("select * from EISPH.city_town", "CTY_NME"));
	//		this.errorType = -1;
	//		this.errorMessage = "This is an unknown error! Please be more descriptive!";
	//		this.exception = new IllegalArgumentException(this.errorMessage);
	//		SeleniumHelper.log.info("\n -------------- \n Error Type: [" + this.errorType + "] \n Error Message: ["
	//				+ this.errorMessage + "] \n Exception: [" + this.exception.getMessage() + "] \n --------------");

	//System.out.println(Source.seleniumHelper().generateRandomNumber(2));

	//Source.dbConnect().getAmountOfColumn("select * from eisph.adrs_rec where adrs_id BETWEEN 100000 and 150000");

	//		Source.MyHomePage().clickMyClientsExcelButton();
	//		File file = new File("download");
	//		String files = System.getProperty("User.dir") + "\\download";
	//		System.out.println(file);
	//		System.out.println(f);
	//		try {
	//			int randomID = Source.SeleniumHelper().generateRandomNumber(10000000, 99999999);
	//			System.out.println(randomID);
	//			Source.DriverFactory().getBrowser(Configuration.Browser.baseBrowser);
	//			Source.SeleniumHelper().goToUrl(Configuration.Url.basePortal);
	//			Source	.LogInPage()
	//					.setUserName(Configuration.User.baseUser)
	//					.setPassword(Configuration.Password.basePassword)
	//					.clickSignIn()
	//					.clickAdministrator();
	//			SoftAssert = new SoftAssert();
	//			
	//			SeleniumHelper.log.info("Verifying 'Lookups'tab title");
	//			Expected = "Lookups";
	//			Actual = Source   	.AdministratorMainPage()
	//								.clickLookups()
	//								.readLookupsTab();
	//								
	//			SoftAssert.assertEquals(Actual, Expected);
	//			
	//			SeleniumHelper.log.info("Verifying 'Lookups' tab is selected");
	//			Source		.LookupsPage()
	//						.clickLookups();
	//			Expected = "active";
	//			Actual = Source.SeleniumHelper().getAttribute(Source.LookupsPage().LookupsTab, "class");
	//			SoftAssert.assertEquals(Actual, Expected);
	//			
	//			SeleniumHelper.log.info("Verifying 'Show entries' title");
	//			Expected ="Show\n"
	//					+ "10\n"
	//					+ "25\n"
	//					+ "50\n"
	//					+ "100\n"
	//					+ "entries";
	//			Actual = Source		.DataTable()
	//								.readShowEntriesTitle();
	//			SoftAssert.assertEquals(Actual, Expected);
	//
	//			SeleniumHelper.log.info("Verifying 'Add'  title");
	//			Expected = "Add";
	//			Actual = Source		.DataTable()
	//								.readAddBtn();
	//			SoftAssert.assertEquals(Actual, Expected);
	//
	//			SeleniumHelper.log.info("Verifying 'Edit'  title");
	//			Expected = "Edit";
	//			Actual = Source		.DataTable()
	//								.readEditBtn();
	//			SoftAssert.assertEquals(Actual, Expected);
	//
	//
	//			SoftAssert.assertAll();
	//			Source.SeleniumHelper().quitBrowser();
	//			SoftAssert.assertAll();
	//		}catch(Exception e) {
	//			Source	.SeleniumHelper()
	//					.quitBrowser()
	//					.assertFail();
	//		}
	//		
	//		
	//	}

	//	@AfterMethod
	//	public void testing(ITestResult result) {
	//		result.getThrowable().printStackTrace();
	//		StackTraceElement[] s = result.getThrowable().getStackTrace();
	//		System.out.println();
	//		SeleniumHelper.log.info(s[2]);
	//		SeleniumHelper.log.info(s[3]);
	//		System.out.println(EmptyString);
	//		
	//	}

	//@Test
	//	public void SavePDF() {
	//		ObjectSource Source = new ObjectSource();
	//		SoftAssert sa = new SoftAssert();
	//		String date = "04/06/2021 11";
	//		String dates = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
	//		boolean b = date.matches(dates);
	//		sa.assertTrue(b);
	//		sa.assertAll();
	//		SoftAssert SoftAssert = new SoftAssert();
	//		Source.DriverFactory().getBrowser(Configuration.Browser.baseBrowser);
	//		Source.SeleniumHelper().goToUrl("https://portal.testlb.state.me.us/eis/ControlServlet");
	//		Source.SeleniumHelper().sleep(1);
	//		Source.DriverFactory().getDriver().findElement(By.xpath("//a[@id='btnLogOn']")).click();
	//		Source.SeleniumHelper().sleep(5);
	//		Actions action = new Actions(DriverFactory.getDriver());
	//		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("s").build().perform();

	//		java.awt.Robot robot = new java.awt.Robot();
	//		Source.SeleniumHelper().sleep(3);
	//	    robot.keyPress(KeyEvent.VK_CONTROL);
	//	    robot.keyPress(KeyEvent.VK_SHIFT);
	//	    robot.keyPress(KeyEvent.VK_S);
	//	    robot.keyRelease(KeyEvent.VK_S);
	//	    robot.keyRelease(KeyEvent.VK_SHIFT);
	//	    robot.keyRelease(KeyEvent.VK_CONTROL);
	//	    Source.SeleniumHelper().sleep(3);
	//	    robot.keyPress(KeyEvent.VK_ENTER);
	//	    Source.SeleniumHelper().sleep(3);    
	//	    robot.keyPress(KeyEvent.VK_TAB);   
	//	    Source.SeleniumHelper().sleep(3);
	//	    robot.keyPress(KeyEvent.VK_ENTER);
	//		Source.SeleniumHelper().quitBrowser();
	//	}

	//	//@Test
	//	public void functionTest() {
	//		ObjectSource Source = new ObjectSource();
	//		SoftAssert sa = new SoftAssert();
	//		ArrayList<String> data = new ArrayList<String>();
	//		data.add("Art");
	//		data.add("Xeee");
	//		data.add("Ret");
	//		data.add("Bat");
	//		System.out.println(data);
	//		Source.SeleniumHelper().sortData(data);
	//		System.out.println(data);
	//	}
	//

	//Retrieve data for enums
	//	@Test(priority=1)
	//	public void Uppercase_MECare_Identifiers_Tab() {	
	//
	//		SoftAssert = new SoftAssert();
	//
	//		try{
	//			//Action before reaching dropdown
	//			Source	.DataTable()
	//					.clickFirstRow()
	//					.clickAnchor()
	//					.PeopleNavigator()
	//					.clickAddressTab()
	//					.clickAdd()
	////					.GetSource()
	//					.SeleniumHelper()
	//					.Wait(2);
	//			
	//			//Drop down element
	//			Select select = new Select(Source.AddressPage().CityTownDropDown);
	//			List<WebElement> count = select.getOptions();
	//
	//			int counter = 0;
	//
	//			//Format to print
	//			
	//			for(WebElement c: count) {
	//				System.out.println(c.getText().replace(" ", "_").replace(",", "").replace("[^a-zA-Z_0-9]", "").replace("(", "").replace(")", "").replace(".", "") + " (\"" + c.getText() 
	//				+ "\", " + counter + ", new BigInteger(\"" + c.getAttribute("value") + "\"))," );
	//				counter++;
	//			}
	//
	//		}catch(Exception e) {
	//			Source	.SeleniumHelper()
	//			.assertFail();
	//		}
	//
	//	}

//	@Test
//	public void test() throws UnknownHostException {
//		String ip = InetAddress.getLocalHost().getHostAddress();
//		System.out.println(ip);
//		String date = 	SeleniumHelper.dateCustom("EE MMM dd yyyy h:mm:ss a");
//		System.out.println(date);
//		System.out.println(FutureDate6);
//		System.out.println(PastDate3);
//		System.out.println(Today);

//	}
	
	@Test(priority=1)
	public void TC_Page_Sections_Row_Q_Start_Date() {		
		String page = "p";
		String section = "1";
		String row = "2";
		String QuestionLabel= "TC_Question_Selenium " + SeleniumHelper.generateRandomNumber(8);
		String searchPage = (page == null ? PagePrefix : page);
		String searchSection = (page == null ? SectionPrefix : section);
		String searchRow = (page == null ? RowPrefix : row);
	
		System.out.println(searchRow);
		}
	
}