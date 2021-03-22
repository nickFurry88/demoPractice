package com.app.gethyphen.testPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class CreatePollPage extends BaseTestPage{
	
	WebDriver driver;
	
	//to get options under Settings menu
	private String setOptions = "div[class='item-popover-option']";
	
	// to get options for Group Select drop down
	private String groupOption = "//div[@role='option']";
	
	@FindBy(id="create-button")
	WebElement createBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Anonymous')]")
	WebElement radioBtnAnonymous;
	
	@FindBy(xpath = "//button[contains(text(),'OPEN')]")
	WebElement openBtn;
	
	// drop down to select
	@FindBy(className="Select-control")
	WebElement selInput;
	
	// Select button
	@FindBy(css = "button[type='submit']")
	WebElement selectBtn;
	
	//text field for post
	@FindBy(id="textAreaField")
	WebElement textArea;
	
	//Publish post
	@FindBy(css = "button[type='submit']")
	WebElement publishBtn;
	
	//Setting
	@FindBy(css = "span[id='settings-popover']")
	WebElement settings;
	
	//Setting menu
	@FindBy(css = "div[class^='popover-inner']")
	WebElement settingMenu;
	
	public CreatePollPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void createPoll() throws Exception{
		createBtn = wait(driver, 4, createBtn);
		
		//Verify that Create Button is present
		Assert.assertTrue(createBtn.isEnabled(), "Test Case 5: The Create new post button is disabled.");
		if(createBtn.isEnabled()) {
			createBtn.click();
			Reporter.log("Create new post button clicked");
		}
		
	}
	
	// select user type - Anonymous, Official or Named
	public void selectPollTypeUser(String type) throws Exception{
		
		// check what type of poll is passed and click on radio button
		if(type.equalsIgnoreCase("anonymous")) {
			radioBtnAnonymous = wait(driver, 4, radioBtnAnonymous);
			if(radioBtnAnonymous.isEnabled()) {
				radioBtnAnonymous.click();
				Reporter.log("The Anonymous type is selected");
			}
		}
	}
	
	// select poll choice of OPEN or Multiple Choice
	public void createPollType(String pollChoice) throws Exception{
		
		// check what type of poll is passed and click on radio button
		if(pollChoice.equalsIgnoreCase("OPEN")) {
			//openBtn = wait(driver, 4, openBtn);
			if(openBtn.isEnabled()) {
				openBtn.click();
				Reporter.log("The Open button is clicked");
			}
		}
	}
	
	//select Group value from drop down
	public void selectGroup(String group) throws Exception{
		// wait for drop down to be enabled
		selInput = wait(driver, 4, selInput);
		
		//verify that drop down is enabled
		Assert.assertTrue(selInput.isEnabled(), "Test Case 6: The drop down is disabled.");
		
		//select the value from drop down
		if(selInput.isEnabled()) {
			
			Reporter.log("Clicking the drop down to select group type");
			//click to open Select group drop down
			selInput.click();
			implicitWait(driver, 3);
			
			//get all options under drop down
			List<WebElement> groupOptions = driver.findElements(By.xpath(groupOption));
			
			// find the matching value of Group and click
			for(WebElement w : groupOptions) {
				String text = w.getText();
				if(text.equals(group)) {
					w.click();
					Reporter.log("Selected the group");
					break;
				}
			}
		}
	}
	
	// click Select button after setting group
	public void clickSelect() throws Exception{
		if(selectBtn.isEnabled()) {
			selectBtn.click();
			Reporter.log("Group selected, clicked on Select button");
		}
	}
	
	
	// enter the poll text
	public void enterText(String text) throws Exception{
		textArea = wait(driver, 4, textArea);
		
		//verify that text box is enabled
		Assert.assertTrue(textArea.isEnabled(), "Test Case 7: The text box is disabled.");
		
		if(textArea.isEnabled()) {
			textArea.click();
			textArea.sendKeys(text);
			Reporter.log("Text is entered in text box");
		}
	}
	
	//click Publish post
	public void publishPost() throws Exception{
		//verify that the Publish button is enabled
		Assert.assertTrue(publishBtn.isEnabled(), "Test Case 8: Publish button is disabled.");
		
		if(publishBtn.isEnabled()) {
			publishBtn.click();
			Reporter.log("Clicked on Publish button");
			
			//make sure the Create New Post button is visible again
			createBtn = wait(driver, 4, createBtn);
			Reporter.log("Poll is published");
		}
	}
	
	// this method click on Setting -> Logout
	public void logout() throws Exception{

		//wait for Setting button to be present
		settings = wait(driver, 4, settings);
		
		if(settings.isEnabled()) {
			settings.click();
			implicitWait(driver, 2);
			
			//get all the items from Setting menu
			List<WebElement> list = driver.findElements(By.cssSelector(setOptions));
			
			//check for Logout option and click
			for(WebElement ele : list) {
				
				String logout = ele.getText().toString().toLowerCase();
				
				if(logout.equalsIgnoreCase("logout")) {
					// click logout
					ele.click();
					Reporter.log("Logging out");
					break;
				}
			}
		}
	}
}
