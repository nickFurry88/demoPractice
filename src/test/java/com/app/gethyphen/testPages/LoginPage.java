package com.app.gethyphen.testPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.app.gethyphen.config.Config;

public class LoginPage extends BaseTestPage{
	
	WebDriver driver;
	
	@FindBy(name="email")
	WebElement emailBox;
	
	@FindBy(className="ladda-label")
	WebElement otpSubmitBtn;
	
	@FindBy(id="inputGroupField")
	WebElement typeMailBox;
	
	public LoginPage(WebDriver driver){
        this.driver = driver;
	}	
	
	public void openLoginPage(){
		driver.navigate().to(Config.url);
	}
	
	public void login(String email) throws Exception{
		emailBox = wait(driver, 4, emailBox);
		if(emailBox != null) {
			emailBox.sendKeys(email);
		}
		if(otpSubmitBtn.isEnabled()) {
			otpSubmitBtn.click();
		}
	}
	
	public void verifyLoginPage() throws Exception{
		emailBox = wait(driver, 4, emailBox);
		if(emailBox != null) {
			System.out.println("Logged out successfully");;
		}
	}
}
