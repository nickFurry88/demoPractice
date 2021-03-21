package com.app.gethyphen.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.app.gethyphen.testPages.CreatePollPage;
import com.app.gethyphen.testPages.LoginPage;
import com.app.gethyphen.testbase.TestBase;

public class Logout extends TestBase {
	
	@Test(groups={"logout"}, dependsOnGroups = {"createPoll"})
	public void logout() {
		CreatePollPage homepage = PageFactory.initElements(driver, CreatePollPage.class);
		try {
			homepage.logout();
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.verifyLoginPage();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
