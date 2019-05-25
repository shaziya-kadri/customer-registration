package CustomerPackage;

	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;

import CustomerPackage.LoginPageElements;

import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.fluentlenium.adapter.FluentTest;
	import org.fluentlenium.core.wait.FluentWait;
	import org.openqa.selenium.ElementNotVisibleException;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.StaleElementReferenceException;
	import org.openqa.selenium.TimeoutException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.support.PageFactory;
    import org.testng.annotations.BeforeClass;


	public class Login_Customer_Registration {
	   
		
		protected static WebDriver driver;
		private String screen;
		private String scenario;
		public static final int TIMEOUT_SECONDS = 20;
	    public static final long POLLING_INTERVAL_SECONDS = 1l;
	    

	  //  public void baseSetUp() throws Exception {
	    //	System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		//	driver = new ChromeDriver();
		//	driver.manage().window().maximize();
	       
	   //     this.initFluent(driver);
	   //     this.initTest();
	    //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //  }
	    
	 //   @AfterClass()
	   /* public void logout()
	    {
	    	
	    	CustomerRegClass.Logout();
	    }*/
	 

	   
		
		
		public  FluentWait letsWait() {
	        return letsWait().atMost(TIMEOUT_SECONDS, TimeUnit.SECONDS)
	                .pollingEvery(POLLING_INTERVAL_SECONDS, TimeUnit.SECONDS).ignoring(StaleElementReferenceException.class)
	                .ignoring(NoSuchElementException.class).ignoring(ElementNotVisibleException.class)
	                .ignoring(TimeoutException.class);
	    }
		protected void letsWaitUntilElementsWithTextIsDisplayed(String element, String elementText) {
	        letsWait().until(element).withText().contains(elementText).areDisplayed();
	    }

		protected  void letsWaitUntilElementsWithIdIsDisplayed(String element, String id) {
	        letsWait().until(element).withId().contains(id).areDisplayed();
	    }

		protected Object[][] loadDataForTestcase(String screen, String spreadSheet, String testCase) {
			this.screen = screen;
			this.scenario = testCase;
			Object[][] testDataResult = new Object[1][1];
			Object[][] testData = new XlsReader("TestData//" + spreadSheet + ".xlsx").getTestDataWithNoEmptyRows(screen);
			for (int i = 0; i < testData.length; i++) {
				Map<String, String> mapOfData = (Map<String, String>) testData[i][0];
				if (mapOfData.containsKey("testCase") && mapOfData.get("testCase").equals(testCase)) {
					testDataResult[0][0] = mapOfData;
					break;
				}
			}

			return testDataResult;
		}

		protected List<Map<String, String>> loadDataList(String screen, String testCase) {
			this.screen = screen;
			this.scenario = testCase;
			Object[][] testData = new XlsReader("TestData//" + testCase + ".xlsx").getTestDataWithNoEmptyRows(screen);
			List<Map<String, String>> testDataList = new ArrayList();
			for (int i = 0; i < testData.length; i++) {
				testDataList.add((Map<String, String>) testData[i][0]);
			}
			return testDataList;
		}

		protected static Object[][] loadData(String screen, String testCase, String environment) {
			return new XlsReader("TestData//" + environment + "//" + testCase + ".xlsx").getTestDataWithNoEmptyRows(screen);
		}

		protected static Object[][] loadData(String screen, String testCase) {
			return new XlsReader("TestData//" + testCase + ".xlsx").getTestDataWithNoEmptyRows(screen);
		}


	}


