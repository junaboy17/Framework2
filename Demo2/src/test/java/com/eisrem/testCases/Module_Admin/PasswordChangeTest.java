package com.eisrem.testCases.Module_Admin;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eisrem.AppUtils.Configuration;
import com.eisrem.AppUtils.SeleniumHelper;
import com.eisrem.Hooks.PasswordChange;

public class PasswordChangeTest extends PasswordChange{

	@Test(priority=1)
	public void passwordChangeTitle() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying Password Change title text");
		Expected = "Password Change";
		Actual = Source		.PasswordChangePage()
							.readPasswordChangeTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Current Password text");
		Expected = "Current Password";
		Actual = Source		.PasswordChangePage()
							.readCurrentPasswordTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying New Password text");
		Expected = "New Password";
		Actual = Source		.PasswordChangePage()
							.readNewPasswordTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying  Confirm New Password text");
		Expected = "Confirm New Password";
		Actual = Source		.PasswordChangePage()
							.readConfirmNewPasswordTitle();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Submit button text");
		Expected = "Submit";
		Actual = Source		.PasswordChangePage()
							.readSubmitBtn();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying Cancel button text");
		Expected = "Cancel";
		Actual = Source		.PasswordChangePage()
							.readCancelBtn();
		SoftAssert.assertEquals(Actual, Expected);

		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	@Test(priority=2)
	public void NegativePasswordChange() {
		SoftAssert = new SoftAssert();
		
		try{
		SeleniumHelper.log.info("Verifying change Password with blank current Password,blank new Password and blank confirm new Password");
		Expected = "Error Occurred while updating password: Current Password Cannot Be Empty";
		Actual = Source	.PasswordChangePage()
						.clickSubmit()
						.GetSource()
						.PasswordChangePage()
						.errorMessage();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying change Password with incorrect current Password,blank new Password and blank confirm new Password");
		Expected = "Error Occurred while updating password: Incorrect Current Password";
		Actual = Source	.PasswordChangePage()
						.setCurrentPassword("*#")
						.clickSubmit()
						.GetSource()
						.PasswordChangePage()
						.errorMessage();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying change Password with correct current Password,blank new Password and blank confirm new Password");		
		Expected ="Error Occurred while updating password: New Password Cannot Be Empty";
		Actual = Source		.PasswordChangePage()
							.setCurrentPassword(Pass, "y")
							.clickSubmit()
							.GetSource()
							.PasswordChangePage()
							.errorMessage();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying change Password with correct current Password, incorrect new Password and blank confirm new Password");
		Expected ="Error Occurred while updating password: Confirm New Password Cannot Be Empty";
		Actual = Source	.PasswordChangePage()	
						.setNewPassword("123", "y")
						.clickSubmit()
						.GetSource()
						.PasswordChangePage()
						.errorMessage();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying change Password with correct current Password,correct new Password and blank confirm new Password");
		Expected ="Error Occurred while updating password: Confirm New Password Cannot Be Empty";
		Actual = Source		.PasswordChangePage()
							.setNewPassword("Winter1!", "y")
							.clickSubmit()
							.GetSource()
							.PasswordChangePage()
							.errorMessage();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying change Password with correct current Password,correct new Password and incorrect confirm new Password");
		Source.PasswordChangePage()	.setConfirmNewPassword("sum")
									.clickSubmit()
									.GetSource()
									.PasswordChangePage()
									.errorMessage();
		
		Expected ="Error Occurred while updating password: New Password and Confirm New Password mismatched";
		Actual = Source	.PasswordChangePage()	
						.setConfirmNewPassword("sum")
						.clickSubmit()
						.GetSource()
						.PasswordChangePage()
						.errorMessage();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying change Password with erased current Password,correct new Password and correct confirm new Password");
		Expected ="Error Occurred while updating password: Current Password Cannot Be Empty";
		Actual = Source		.PasswordChangePage()
							.setCurrentPassword(EmptyString, "y")
							.setConfirmNewPassword("Winter1!")
							.clickSubmit()
							.GetSource()
							.PasswordChangePage()
							.errorMessage();
		SoftAssert.assertEquals(Actual, Expected);
		
		SeleniumHelper.log.info("Verifying change Password with erased current Password, erase new Password and correct confirm new Password");
		Expected ="Error Occurred while updating password: Current Password Cannot Be Empty";
		Actual = Source		.PasswordChangePage()
							.setNewPassword(EmptyString, "y")
							.clickSubmit()
							.GetSource()
							.PasswordChangePage()
							.errorMessage();
		SoftAssert.assertEquals(Actual, Expected);
		
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	//@Test(priority=3)
	public void successfulPasswordChange() {
		SoftAssert = new SoftAssert();

		try{
		SeleniumHelper.log.info("Verifying change Password with valid current Password, new Password and confirm new Password");
		Source.PasswordChangePage().setCurrentPassword("Summer10!")
									.setNewPassword("Winter1!")
									.setConfirmNewPassword("Winter1!")
									.clickSubmit();
		SoftAssert.assertAll();
		
	}catch(Exception e) {
		Source	.SeleniumHelper()
				.assertFail();
	}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
