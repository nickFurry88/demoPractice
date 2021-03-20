package com.app.gethyphen.tests;

import com.app.gethyphen.config.Config;
import com.app.gethyphen.testPages.LoginPage;
import com.app.gethyphen.testPages.VerificationPage;
import com.app.gethyphen.testbase.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginOtp extends TestBase{
	
	@Test(priority=0, groups={"login"})
	public void openLoginPage() {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.openLoginPage();
		
		try{
			loginPage.login(Config.email);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test (priority=1, dependsOnMethods = {"openLoginPage"}, groups={"login"})
	public void otpLoginPage() {
		VerificationPage verifyPage = PageFactory.initElements(driver, VerificationPage.class);
		try {
			verifyPage.enterOtp(Config.otp);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*@Test (dependsOnMethods= {"otpLoginPage"})
	public void logout() {
		HomePage homepage = PageFactory.initElements(driver, HomePage.class);
		try {
			homepage.logout();
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.verifyLoginPage();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/

}
