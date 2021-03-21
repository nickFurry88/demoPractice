package com.app.gethyphen.testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.app.gethyphen.config.Config;

public class LoginPage extends BaseTestPage{
	
	WebDriver driver;
	
	//get Sign Up/Log In heading
	@FindBy(xpath = "//h3[text()='Sign up / Log back in']")
	WebElement signUpText;
	
	//get email edit box
	@FindBy(name="email")
	WebElement emailBox;
	
	//get otp submit button
	@FindBy(className="ladda-label")
	WebElement otpSubmitBtn;

	
	public LoginPage(WebDriver driver){
        this.driver = driver;
	}	
	
	// navigate to Sign Up/Log In page
	public void openLoginPage(){
		driver.navigate().to(Config.url);
		
		Reporter.log("Opening the Sign Up/Log In page");
		
		//wait for Sign up/Log In message to be displayed
		signUpText = wait(driver, 4, signUpText);
        
        //Verify that Sign up/Login message is displayed
        Assert.assertTrue(signUpText.isEnabled(), "Test Case 1: Login page is opened.");
	}
	
	// enter Email id
	public void login(String email) throws Exception{
		emailBox = wait(driver, 4, emailBox);
		
		Assert.assertTrue(emailBox.isEnabled(), "Test Case 2: Email box is editable.");
		
		if(emailBox != null) {
			emailBox.sendKeys(email);
			Reporter.log("Entered email id");
		}
		if(otpSubmitBtn.isEnabled()) {
			otpSubmitBtn.click();
			Reporter.log("Submitted the email id");
		}
	}
	
	public void verifyLoginPage() throws Exception{
		emailBox = wait(driver, 4, emailBox);
		
		Assert.assertTrue(emailBox.isEnabled(), "Test Case 4: LogOut option is working.");
		
		if(emailBox != null) {
			Reporter.log("Logged out successfully");
		}
	}
}
