package com.app.gethyphen.testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VerificationPage extends BaseTestPage{
	
	WebDriver driver;
	
	@FindBy(css = "input[type='password']")
	WebElement otpBox;
	
	@FindBy(css = "button[type='submit']")
	WebElement loginBtn;
	
	public VerificationPage(WebDriver driver){
        this.driver = driver;
	}
	
	public void enterOtp(String otp) throws Exception{
		otpBox = wait(driver, 4, otpBox);
		if(otpBox != null) {
			otpBox.sendKeys(otp);
		}
		if(loginBtn.isEnabled()) {
			loginBtn.click();
		}
	}

}
