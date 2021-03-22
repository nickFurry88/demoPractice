package com.app.gethyphen.testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class VerificationPage extends BaseTestPage{
	
	WebDriver driver;
	
	@FindBy(css = "input[type='password']")
	WebElement otpBox;
	
	@FindBy(css = "button[type='submit']")
	WebElement loginBtn;
	
	public VerificationPage(WebDriver driver){
        this.driver = driver;
	}
	
	// Enter OTP
	public void enterOtp(String otp) throws Exception{
		otpBox = wait(driver, 4, otpBox);
		
		// verify OTP box is enabled
		Assert.assertTrue(otpBox.isEnabled(), "Test Case 3: OTP box is NOT enabled");
		
		if(otpBox != null) {
			otpBox.sendKeys(otp);
			Reporter.log("Entered the otp");
		}
		if(loginBtn.isEnabled()) {
			loginBtn.click();
			Reporter.log("Submitted the otp");
		}
	}

}
