package com.eisrem.testCases.CommonTest;

import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Data;
import com.eisrem.AppUtils.SeleniumHelper;

public class DataTableTabTest extends Data{

	public void TabTest() {

		SoftAssert = new SoftAssert();
		int totalTab;

		try{

			totalTab =	Source	.DataTable()
								.getSizePageTabAll();

			if(totalTab == 3) {
				SeleniumHelper.log.info("Verifying 'Previous'  is disabled when Tab 1 is selected");
				Expected = "paginate_button previous disabled";
						Source		.DataTable()
									.clickPageTab1();	
				Actual = Source	.SeleniumHelper()
								.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'next'  is disabled when Tab 1 is selected");
				Expected = "paginate_button next disabled";
				Actual = Source		.SeleniumHelper()
									.getAttribute(Source.DataTable().nextBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SizeExpected = 3;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);

			}else if(totalTab == 4) {
				SeleniumHelper.log.info("Verifying 'Previous'  is disabled when Tab 1 is selected");
				Expected = "paginate_button previous disabled";
							Source	.DataTable()
									.clickPageTab1();	
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'next'  is enabled when Tab 1 is selected");
				Expected = "paginate_button next";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().nextBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'Previous' is enabled when next is clicked");
							Source	.DataTable()
									.clickNext()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Expected = "paginate_button previous";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'next'  is disabled when last tab is selected");
				Expected = "paginate_button next disabled";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().nextBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying Page Tab '2' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab2()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab2, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 11 to";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SizeExpected = 4;		
				SizeActual =  Source .DataTable()
									 .getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);

			}else if(totalTab == 5) {
				SeleniumHelper.log.info("Verifying 'Previous'  is disabled when Tab 1 is selected");
				Expected = "paginate_button previous disabled";
							Source	.DataTable()
									.clickPageTab1();	
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'next'  is enabled when Tab 1 is selected");
				Expected = "paginate_button next";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().nextBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'Previous' is enabled when next is clicked");
							Source	.DataTable()
									.clickNext()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Expected = "paginate_button previous";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying Page Tab '2' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab2()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab2, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 11 to 20 of";		
				Actual = 	Source	.DataTable().readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SeleniumHelper.log.info("Verifying Page Tab '3' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab3()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab3, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 21 to";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SizeExpected = 5;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);

			}else if(totalTab == 6) {
				SeleniumHelper.log.info("Verifying 'Previous'  is disabled when Tab 1 is selected");
				Expected = "paginate_button previous disabled";
							Source	.DataTable()
									.clickPageTab1();	
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'next'  is enabled when Tab 1 is selected");
				Expected = "paginate_button next";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().nextBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'Previous' is enabled when next is clicked");
							Source	.DataTable()
									.clickNext()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Expected = "paginate_button previous";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying Page Tab '2' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab2()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab2, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 11 to 20 of";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SeleniumHelper.log.info("Verifying Page Tab '3' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab3()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual =	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab3, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 21 to 30 of";		
				Actual =	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SeleniumHelper.log.info("Verifying Page Tab '4' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab4()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab4, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 31 to";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));

				SizeExpected = 6;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);

			}else if(totalTab == 7) {
				SeleniumHelper.log.info("Verifying 'Previous'  is disabled when Tab 1 is selected");
				Expected = "paginate_button previous disabled";
							Source	.DataTable()
									.clickPageTab1();	
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'next' is enabled when Tab 1 is selected");
				Expected = "paginate_button next";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().nextBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'Previous' is enabled when next is clicked");
							Source	.DataTable()
									.clickNext()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Expected = "paginate_button previous";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying Page Tab '2' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab2()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab2, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 11 to 20 of";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SeleniumHelper.log.info("Verifying Page Tab '3' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab3()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab3, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 21 to 30 of";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SeleniumHelper.log.info("Verifying Page Tab '4' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab4()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab4, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 31 to 40 of";		
				Actual =	 Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SeleniumHelper.log.info("Verifying Page Tab '5' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab5()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab5, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 41 to";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SizeExpected = 7;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);

			}else if(totalTab == 8) {
				Integer pageNum = Integer.valueOf(Source.DataTable().readPageTab6());
				
				SeleniumHelper.log.info("Verifying 'Previous'  is disabled when Tab 1 is selected");
				Expected = "paginate_button previous disabled";
							Source	.DataTable()
									.clickPageTab1();	
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'next'  is enabled when Tab 1 is selected");
				Expected = "paginate_button next";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().nextBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'Previous' is enabled when next is clicked");
							Source	.DataTable()
									.clickNext()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Expected = "paginate_button previous";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying Page Tab '2' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab2()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab2, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 11 to 20 of";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SizeExpected = 8;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);

				SeleniumHelper.log.info("Verifying Page Tab '3' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab3()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab3, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 21 to 30 of";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SizeExpected = 8;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);

				SeleniumHelper.log.info("Verifying Page Tab '4' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab4()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab4, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 31 to 40 of";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SizeExpected = 8;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);
				
				if(pageNum < 7) {
					SeleniumHelper.log.info("Verifying Page Tab '5' function");
					Expected = "paginate_button current";
								Source	.DataTable()
										.clickPageTab5()
										.GetSource()
										.SeleniumHelper()
										.sleep(SleepSec);
					Actual = 	Source.SeleniumHelper()
										.getAttribute(Source.DataTable().pageTab5, "class");
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected = "Showing 41 to";		
					Actual = 	Source	.DataTable()
										.readShowNoOfEntries();
					SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

					SizeExpected = 8;		
					SizeActual = Source	.DataTable()
										.getSizePageTabAll();
					SoftAssert.assertEquals(SizeActual, SizeExpected);
		
					SeleniumHelper.log.info("Verifying Last Page Tab function");
					Expected = "paginate_button current";
								Source	.DataTable()
										.clickPageTab6()
										.GetSource()
										.SeleniumHelper()
										.sleep(SleepSec);
					Actual = 	Source	.SeleniumHelper()
										.getAttribute(Source.DataTable().pageTab6, "class");
					SoftAssert.assertEquals(Actual, Expected);
				}else {
					SeleniumHelper.log.info("Verifying Page Tab '5' function");
					Expected = "paginate_button current";
								Source	.DataTable()
										.clickPageTab5()
										.GetSource()
										.SeleniumHelper()
										.sleep(SleepSec);
					Actual = 	Source.SeleniumHelper()
										.getAttribute(Source.DataTable().pageTab3, "class");
					SoftAssert.assertEquals(Actual, Expected);
					
					Expected = "Showing 41 to";		
					Actual = 	Source	.DataTable()
										.readShowNoOfEntries();
					SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

					SizeExpected = 7;		
					SizeActual = Source	.DataTable()
										.getSizePageTabAll();
					SoftAssert.assertEquals(SizeActual, SizeExpected);
		
					SeleniumHelper.log.info("Verifying Last Page Tab function");
					Expected = "paginate_button current";
								Source	.DataTable()
										.clickPageTab5()
										.GetSource()
										.SeleniumHelper()
										.sleep(SleepSec);
					Actual = 	Source	.SeleniumHelper()
										.getAttribute(Source.DataTable().pageTab6, "class");
					SoftAssert.assertEquals(Actual, Expected);
				}
			
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab1()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec)
									.GetSource()
									.DataTable()
									.clickPageTab6()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab6, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SizeExpected = 8;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);
			}else if(totalTab == 9) {
				SeleniumHelper.log.info("Verifying 'Previous'  is disabled when Tab 1 is selected");
				Expected = "paginate_button previous disabled";
							Source	.DataTable()
									.clickPageTab1();	
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'next'  is enabled when Tab 1 is selected");
				Expected = "paginate_button next";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().nextBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying 'Previous' is enabled when next is clicked");
							Source	 .DataTable()
									.clickNext()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Expected = "paginate_button previous";
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().PreviousBtn, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SeleniumHelper.log.info("Verifying Page Tab '2' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab2()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab2, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 11 to 20 of";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SizeExpected = 9;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);

				SeleniumHelper.log.info("Verifying Page Tab '3' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab3()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab3, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 21 to 30 of";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SizeExpected = 9;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);

				SeleniumHelper.log.info("Verifying Page Tab '4' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab4()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab4, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 31 to 40 of";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SizeExpected = 9;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);

				SeleniumHelper.log.info("Verifying Page Tab '5' function");
				Expected = "paginate_button current";
							Source	 .DataTable()
									.clickPageTab5()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab5, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 41 to 50 of";		
				Actual =	 Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SizeExpected = 9;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);

				SeleniumHelper.log.info("Verifying Page Tab '6' function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab6()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab6, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 51 to 60 of";		
				Actual =	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				SizeExpected = 9;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);
				
				SeleniumHelper.log.info("Verifying Last Page Tab function");
				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab7()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab7, "class");
				SoftAssert.assertEquals(Actual, Expected);

				Expected = "Showing 61 to";		
				Actual = 	Source	.DataTable()
									.readShowNoOfEntries();
				SoftAssert.assertTrue(Source.SeleniumHelper().containsText(Actual, Expected));	

				Expected = "paginate_button current";
							Source	.DataTable()
									.clickPageTab1()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec)
									.GetSource()
									.DataTable()
									.clickPageTab7()
									.GetSource()
									.SeleniumHelper()
									.sleep(SleepSec);
				Actual = 	Source	.SeleniumHelper()
									.getAttribute(Source.DataTable().pageTab7, "class");
				SoftAssert.assertEquals(Actual, Expected);

				SizeExpected = 9;		
				SizeActual = Source	.DataTable()
									.getSizePageTabAll();
				SoftAssert.assertEquals(SizeActual, SizeExpected);
			}else {
				Source	.SeleniumHelper()
				.assertFail();
			}

			SoftAssert.assertAll();

		}catch(Exception e) {
			Source	.SeleniumHelper()
			.assertFail();
		}
	}
}

