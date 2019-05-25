package com.customerregister.testing.steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.annotations.*;

import com.customerregister.testing.steps.CustomerRegistrationPage.LoginPageElements;



public class StepDefinations {
	//private static WebDriver driver = new ChromeDriver();
	
	//private static WebDriver driver = null;
   // WebDriverWait wait = new WebDriverWait(driver, 60);
// WebDriver driver;
//	driver = new ChromeDriver();
    private LoginPageElements pageElements;
//	driver = new ChromeDriver();
	 @Test
	 @Given("^User is on Home Page$")
	    public void setupTestMethod() throws InterruptedException 
	    {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
	    	 WebDriver driver;
	    	driver = new ChromeDriver();
	    	driver.manage().window().maximize();
	           
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	driver.get("http://symex.dyndns.org:9091");
	    	Thread.sleep(5000);
	    }

	// @Test(dataProvider = "getTestDataFromExcel",priority = 0)
	 @Test
	 @When("^User enters UserName and Password$")
		public void user_enters_UserName_and_Password(String username, String pass) throws Throwable {
		 WebDriver driver;
	    	driver = new ChromeDriver();
		//	driver.findElement(By.id("log")).sendKeys("testuser_1"); 	 
		  //  driver.findElement(By.id("pwd")).sendKeys("Test@123");
		  //  driver.findElement(By.id("login")).click();
	    	Thread.sleep(1000);
		 pageElements.userNameElement.isDisplayed();
			//pageElements.userNameElement.click();
		//	pageElements.userNameElement.sendKeys(username);
			pageElements.userNameElement.sendKeys(Keys.TAB);

			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@tabindex='2']")));
			//password.click();
			//password.clear();
		//	password.sendKeys(pass);
		//	driver.findElement(By.id("btnUserLogin")).click();
			//homePage();
			}
	 
	 public class LoginPageElements {
			
			@FindBy(id="cbpLogin_txtUserName_I")
			public WebElement userNameElement;	
		}
	 public  void homePage() throws Exception 
	    {
	       Thread.sleep(500);
	       WebDriver driver;
	    	driver = new ChromeDriver();
			driver.findElement(By.id("ctl00_splLoginMaster_Content_splMain_btnContinue_CD")).click();
	    	
	    }
}
