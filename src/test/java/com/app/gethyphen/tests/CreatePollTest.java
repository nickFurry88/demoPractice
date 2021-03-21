package com.app.gethyphen.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.app.gethyphen.testPages.CreatePollPage;
import com.app.gethyphen.testPages.LoginPage;
import com.app.gethyphen.testbase.TestBase;
import com.app.gethyphen.utils.DataReaders;

public class CreatePollTest extends TestBase{
	
	/*private String userType = "Anonymous";
	private String pollType = "OPEN";
	private String groupType = "SF Bay Area";
	private String pollText = "Test 102";*/
	
	@Test(groups={"createPoll"}, dependsOnGroups = {"login"}, dataProvider = "PollTypes", dataProviderClass = DataReaders.class)
	public void startPoll(String userType, String pollType, String groupType, String pollText) {
		
		CreatePollPage poll = PageFactory.initElements(getDriver(), CreatePollPage.class);
		//LoginPage loginPage = PageFactory.initElements(getDriver(), LoginPage.class);
		
		try {
			poll.createPoll();
			poll.selectPollTypeUser(userType);
			poll.createPollType(pollType);
			poll.selectGroup(groupType);
			poll.clickSelect();
			poll.enterText(pollText);
			poll.publishPost();
			Thread.sleep(5000);
			/*poll.logout();
			loginPage.verifyLoginPage();*/
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	//("createPoll")
	/*@AfterGroups(groups={"logout"}, dependsOnGroups = {"createPoll"})
	public void logout() {
		CreatePollPage homepage = PageFactory.initElements(driver, CreatePollPage.class);
		try {
			homepage.logout();
			LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.verifyLoginPage();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	

}
