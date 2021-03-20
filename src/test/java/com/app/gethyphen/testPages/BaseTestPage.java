package com.app.gethyphen.testPages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTestPage {

	protected WebElement wait(WebDriver driver, int time, WebElement ele ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
        return element;
    }
	
	protected void implicitWait(WebDriver driver , int seconds){
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

}