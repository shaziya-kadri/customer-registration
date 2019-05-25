package com.customerregister.testing.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CustomerRegistrationPage {
	
	public WebDriver driver;
	private LoginPageElements pageElements;
	
	public class LoginPageElements {
		
		@FindBy(id="cbpLogin_txtUserName_I")
		public WebElement userNameElement;	
	}
	
	public  void LoginScreen(String username, String pass) throws Exception {
		pageElements.userNameElement.isDisplayed();
		pageElements.userNameElement.click();
		pageElements.userNameElement.sendKeys(username);
		pageElements.userNameElement.sendKeys(Keys.TAB);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@tabindex='2']")));
		password.click();
		password.clear();
		password.sendKeys(pass);
		driver.findElement(By.id("btnUserLogin")).click();
		homePage();
		
	}

	
	 public  void homePage() throws Exception 
	    {
	       Thread.sleep(500);
			driver.findElement(By.id("ctl00_splLoginMaster_Content_splMain_btnContinue_CD")).click();
	    	
	    }
}
