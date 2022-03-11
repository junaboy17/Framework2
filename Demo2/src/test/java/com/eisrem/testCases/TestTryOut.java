package com.eisrem.testCases;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.xmlbeans.xml.stream.Space;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Data;
import com.eisrem.AppUtils.DriverFactory;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.MyHomePage;
import com.eisrem.Hooks.PeoplePage;

public class TestTryOut extends MyHomePage{

	//	@BeforeMethod
	//	public void BeforeMethodOne() {
	//		System.out.println("Before Method 1");
	//	}
	//	
	//	@BeforeMethod
	//	public void BeforeMethodOne2() {
	//		System.out.println("Before Method 2");
	//	}

	@Test
	public void Test1() {
		SoftAssert = new SoftAssert();

		List<String> m = new ArrayList<String>();
		m.add("something");
		m.add("something");
		m.add("something");
		m.add("something");
		System.out.println(m.size());


		Source		.SeleniumHelper()
		.clearElement(Source.AddressPage().Address1TextBox)
		.GetSource()
		.AddressPage()
		.setAddress1TextBox(Address);	


		System.out.println(Actual);
	}

	@Test
	public void Test2() {
		SoftAssert = new SoftAssert();

		List<String> m = new ArrayList<String>();
		m.add("something1");
		m.add("something2");
		m.add("something3");
		m.add("something4");
		System.out.println(m.size());

		for(String s:m) {
			System.out.println(s);

		}
	}

	@Test
	public void Test3() {
		List<String> l1 = new ArrayList<String>();

		l1.add("4 abc");
		l1.add("2 def");
		l1.add("8 z");

		Source.SeleniumHelper().sortData(l1);
		System.out.println(l1);
	}

	@Test(priority=1)
	public void Assessment_Add_Print() {

		SoftAssert = new SoftAssert();

		try{
			SeleniumHelper.log.info("");

			int typeId = 1000075416;

			Source		.DataTable()
			.setSearch(TestClient2)
			.clickFirstRow()
			.clickAnchor()

			.NavigationMenuBar()
			.clickAssessmentForms()
			//						.DataTable()	
			//						.clickAdd()
			//						.Assessment_FormsPage()
			//						.selectAssessmentTypeById(String.valueOf(typeId))
			//						.setTitle("TC_Conducted_Types_Print_002")
			//						.setDescription(String.valueOf(typeId))
			//						.GetSource()
			//						.Assessment_FormsPage()
			//						.clickStartAssessment()
			//						.fillForm()
			//						.clickSubmitAllPages()
			//						.clickGoBackToList()

			// Select created type for viewing
			//						.NavigationMenuBar()
			//						.DataTable()
			.clickFirstRow()
			.clickView()
			.Assessment_FormsPage()
			.clickAssessmentsFormsTab()
			.clickPrint()
			.GetSource()						
			.SeleniumHelper()
			//						.log(Source.SeleniumHelper().getWindowHandle())
			//						.switchWindow()
			.sleep(5)
			//						.log(Source.SeleniumHelper().getWindowHandle())
			;
			//			Set <String> Actual = 	DriverFactory
			//						.getDriver()
			//						.getWindowHandles();
			//			String handle = null;
			//			for(String i: Actual) {
			//				handle = i;
			//			}
			//			
			//			DriverFactory
			//			.getDriver().switchTo().window(handle);
			//						
			//					;
			//
			//					System.out.println(Source.SeleniumHelper().getWindowHandle());
			Source.SeleniumHelper().Actions().sendKeys(Keys.ESCAPE);
			//					DriverFactory.getDriver().findElement(By.className("cancel")).click();

			//			String print = DriverFactory
			//							.getDriver()
			//							.findElement(By.xpath("//head//title")).getText();
			System.out.println(Source.SeleniumHelper().getWindowHandle());


			Source.SeleniumHelper().sleep(10);
			//			System.out.println(print);
			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}

	}

	@Test(priority=1)
	public void UsernameCheck() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Verifying username title");
			Expected = "Username";
			Actual = Source.LogInPage().readUsernameTitle();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying username with valid User and blank Password");
			Source.LogInPage()	.setUserName(User)
			.clickSignIn();

			Expected = "Please Enter UserName and Password";
			Actual = Source.LogInPage().readErrorMessage();
			SoftAssert.assertEquals(Actual, Expected);

			SeleniumHelper.log.info("Verifying username with invalid User and valid Password");
			Source.LogInPage()	.setUserName("baduser")
			.setPassword(Pass)
			.clickSignIn();

			Expected = "Invalid username or password. Click Here for instructions for log in assistance.";
			Actual = Source.LogInPage().readErrorMessage();
			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}

	@Test(priority=1)
	public void test2() {
		SoftAssert = new SoftAssert();

		try {
			SeleniumHelper.log.info("Verifying username title");
			//		Expected = null;
			Source		

			.SeleniumHelper()
			.cleanDownloadDirectory();

			String HeaderData = Source.SeleniumHelper().readElement(Source.MyHomePage().MyClientsAllHeader);				
			Source				.MyHomePage()
			.clickMyClientsExcel()
			.GetSource()
			.SeleniumHelper()
			.verifyExcelHeader(HeaderData, "download/MyClients_export.xlsx", "Data" , 4);

//			SoftAssert.assertEquals(Actual, Expected);

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}

}
