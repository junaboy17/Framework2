package com.eisrem.Hooks;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.eisrem.AppUtils.Data;
import com.eisrem.AppUtils.SeleniumHelper;

public class MainPage extends Data{

	@BeforeSuite
	public void testSuiteSetUp() {
		Source.SeleniumHelper().cleanScreenShotDirectory();
		Source.SeleniumHelper().cleanReportsDirectory();
		Source.SeleniumHelper().cleanDownloadDirectory();
	}

	@BeforeClass
	public void testClassSetUp() {
		SeleniumHelper.log.info("Begin Test Class: " + this.getClass().getSimpleName());
		SeleniumHelper.log.info(Source.SeleniumHelper().date());
		System.out.println(Data.EmptyString);
	}



}
