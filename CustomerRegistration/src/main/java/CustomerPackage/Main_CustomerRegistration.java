package CustomerPackage;

	import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.glass.ui.Window;


	

 public class Main_CustomerRegistration extends Login_Customer_Registration {
		
		private static final String Referencenumber = null;
		private static final String Result = null;
		private static CustomerRegClass CustomerRegClass;
        static int valueint;
        static String data;
        static String url ="httplk";
	    @BeforeMethod
	    public void setupTestMethod() throws InterruptedException 
	    {
	    	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
	    		driver = new ChromeDriver();
	    	driver.manage().window().maximize();
	           
	            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	            CustomerRegClass = new  CustomerRegClass(driver);  
	    	driver.get("http://symex.dyndns.org:9091");
	    	Thread.sleep(5000);
	    }

	    
	    @Test(dataProvider = "getTestDataFromExcel",priority = 0)
	    public void UpdateValidation(Map<String, String> scenarioMap) throws Exception {
	    	RegistrationScenarios(scenarioMap);
	    	
	    } 
   
	   @AfterMethod
	       public void logout2() throws IOException 
	       {
		  
						
			     driver.close();
		 
		
		    }
	  
		public  void RegistrationScenarios(Map<String, String> scenarioMap) throws Exception
		{ 
			Thread.sleep(100);
			CustomerRegClass.LoginScreen(scenarioMap.get("username"), scenarioMap.get("password"));
			CustomerRegClass.Customer_RemitterType(scenarioMap.get("Cust_RemitterType"));
			CustomerRegClass.Cusotmer_RiskCategory(scenarioMap.get("Cust_RiskCategory"));
			CustomerRegClass.Customer_Gender(scenarioMap.get("Cust_Gender"));
			CustomerRegClass.Cusotmer_ResidentType(scenarioMap.get("Cust_ResidentType"));
            CustomerRegClass.Customer_Salutation(scenarioMap.get("Cust_Salutation"));
            Thread.sleep(200);
            CustomerRegClass.Customer_FirstName(scenarioMap.get("Cust_FirstName"));
            CustomerRegClass.Customer_MiddleName(scenarioMap.get("Cust_MiddleName"));
            CustomerRegClass.Customer_LastName(scenarioMap.get("Cust_LastName"));
            CustomerRegClass.Customer_ArabicName(scenarioMap.get("Cust_ArabicFirstName"),scenarioMap.get("Cust_ArabicMiddleName"),scenarioMap.get("Cust_ArabicLastName"));
           CustomerRegClass.DOB(scenarioMap.get("Cust_Customer_DOB"));
           if("CORPORATE".equalsIgnoreCase(scenarioMap.get("Cust_RemitterType")))
			{   
        	   driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtVatRegistrationNo_I")).sendKeys(scenarioMap.get("VATRegNo"));
			}
           CustomerRegClass.Customer_Address(scenarioMap.get("Cust_Customer_Address"),scenarioMap.get("Cust_Customer_Address2"));
           CustomerRegClass.Customer_NonMandatoryDetails(scenarioMap.get("Cust_TaggedRemarks"),scenarioMap.get("Cust_CompanyAddress"),scenarioMap.get("Cust_Building"),scenarioMap.get("Cust_Street"),scenarioMap.get("Cust_City"),scenarioMap.get("Cust_State"));
           CustomerRegClass.Customer_MobileValidation(scenarioMap.get("Cust_MobileNumber"),scenarioMap.get("Cust_Phoneoffice"),scenarioMap.get("Cust_PhoneResident"));
           CustomerRegClass.Customer_Email_IDValidation(scenarioMap.get("Cust_Zipcode"),scenarioMap.get("Cust_Passport"),scenarioMap.get("Cust_Email"));
           CustomerRegClass.CustomerNationality(scenarioMap.get("Cust_Nationality"));
           Thread.sleep(100);
           CustomerRegClass.PurposeofTransfer(scenarioMap.get("Cust_Purpose")); 
           Thread.sleep(100);
           CustomerRegClass.EconomicActivity(scenarioMap.get("Cust_Economic_Activity")); 
           Thread.sleep(1000);
            
           if("CORPORATE".equalsIgnoreCase(scenarioMap.get("Cust_RemitterType")))
			{   
        	   CustomerRegClass.Customer_IDTYPE(scenarioMap.get("CorporateIDType"), scenarioMap.get("ID_NO"), scenarioMap.get("Iss_Place"), scenarioMap.get("Country_ID"), scenarioMap.get("ID_Iss_date"), scenarioMap.get("ID_Iss_Expiry"));
	           }
           else
           {
          CustomerRegClass.Customer_IDTYPE(scenarioMap.get("ID_Type"), scenarioMap.get("ID_NO"), scenarioMap.get("Iss_Place"), scenarioMap.get("Country_ID"), scenarioMap.get("ID_Iss_date"), scenarioMap.get("ID_Iss_Expiry"));
           }
          
           if("GCC ID".equalsIgnoreCase(scenarioMap.get("ID_Type1")))
			{   
       	   CustomerRegClass.Customer_IDTYPE(scenarioMap.get("ID_Type1"), scenarioMap.get("ID_NO1"), scenarioMap.get("Iss_Place1"), scenarioMap.get("Country_ID1"), scenarioMap.get("ID_Iss_date1"), scenarioMap.get("ID_Iss_Expiry1"));
	           }
           
	        CustomerRegClass.save();
	        verifyErrorMessage(scenarioMap.get("Expected_ErrorMessage"),scenarioMap);
          
           Thread.sleep(1000);
           if("CORPORATE".equalsIgnoreCase(scenarioMap.get("Cust_RemitterType")))
			{   
       	   CorporateRepDetails(scenarioMap.get("Rep_FirstName"),scenarioMap.get("Rep_MiddleName"),scenarioMap.get("Rep_LastName"),scenarioMap.get("Rep_ContactNum"),scenarioMap.get("Rep_Nationality"),scenarioMap.get("Rep_IdentityType"),scenarioMap.get("Rep_Identitynumber"),scenarioMap.get("RepID_Issuedate"),scenarioMap.get("RepID_Expirydate"),scenarioMap.get("Rep_City"),scenarioMap.get("Rep_Placeofissue"));    
			}
           verifyErrorMessage(scenarioMap.get("Expected_ErrorMessage"),scenarioMap);
			
		}
		
		

		  public static void verifyErrorMessage(String errorMessage,Map<String, String> scenarioMap) throws InterruptedException, AWTException, IOException {
				
			  if("NA".equalsIgnoreCase(errorMessage))
		
			   {

				   
			}
			else
			{
				
				String myWindowHandle9 = driver.getWindowHandle();
			  driver.switchTo().window(myWindowHandle9);
			  Thread.sleep(1000);
			  data = driver.findElement(By.id("popup_message")).getText();
			  XlsReader xlsRead = new XlsReader("C:\\Users\\shaziya.Cinque\\Documents\\workspace-sts-3.9.8.RELEASE\\CustomerRegistration\\TestData");
			// XlsReader xlsRead = new XlsReader("C:\\TestData\\");
			 // XlsReader xlsRead = new XlsReader("D:\\TestData\\TestData_CustomerRegistration.xlsx");
			   xlsRead.setCellData("RegisterData", "Result", 2 , data);
			  Thread.sleep(1000);
			  driver.findElement(By.id("popup_ok")).click();
			  Thread.sleep(1000);
			  driver.switchTo().frame(driver.findElement(By.name("panelContent")));	
					 
					
					}
			
				
	   }
	   
	  

		@DataProvider
	    private Object[][] getTestDataFromExcel() {
	        return loadData("RegisterData","TestData_CustomerRegistration");
	    }
		
		public static void CorporateRepDetails(String RepFirstname,String RepMiddlename,String RepLastname,String Contactnumber,String Nationality,String Identitytype,String IdentityNumber,String Issuedate,String Expirydate,String RegCity,String Issueplace ) throws InterruptedException, AWTException
		{
			
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_btnRepSearch")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_cbpRepresentative_ASPxPanel1_txtRepFName_I")).sendKeys(RepFirstname);
			driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_cbpRepresentative_ASPxPanel1_txtRepMName_I")).sendKeys(RepMiddlename);
			driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_cbpRepresentative_ASPxPanel1_txtRepLName_I")).sendKeys(RepLastname);
			driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_cbpRepresentative_ASPxPanel1_txtRepPhone_I")).sendKeys(Contactnumber);
			driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_cbpRepresentative_ASPxPanel1_btnRepNat")).click();
			Thread.sleep(500);
            driver.findElement(By.id("splRemitterDetails_GenSearch_pcGeneralSearch_Panel2_grdGeneralSearchID_DXFREditorcol2_I")).sendKeys(Nationality);
           
        
            Thread.sleep(2000);
            driver.findElement(By.id("splRemitterDetails_GenSearch_pcGeneralSearch_Panel2_btOK")).click();
            Thread.sleep(500);
            driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_cbpRepresentative_ASPxPanel1_btnRepID")).click();
            Thread.sleep(500);
            driver.findElement(By.id("splRemitterDetails_GenSearch_pcGeneralSearch_Panel2_grdGeneralSearchID_DXFREditorcol2_I")).sendKeys(Identitytype);
            Thread.sleep(2000);
        
         
            driver.findElement(By.id("splRemitterDetails_GenSearch_pcGeneralSearch_Panel2_btOK")).click();
            Thread.sleep(100);
            driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_cbpRepresentative_ASPxPanel1_txtRepIDNo_I")).sendKeys(IdentityNumber);
            WebElement Issuedat =  driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_cbpRepresentative_ASPxPanel1_dtpRepSrcRemIDIssDate_I"));
        	Thread.sleep(1000);
        	Issuedat.sendKeys(Keys.BACK_SPACE);
        	Issuedat.sendKeys(Keys.BACK_SPACE);
        	Issuedat.sendKeys(Keys.BACK_SPACE);
        	Issuedat.sendKeys(Keys.BACK_SPACE);
        	Issuedat.sendKeys(Keys.BACK_SPACE);
        	Issuedat.sendKeys(Keys.BACK_SPACE);
        	Issuedat.sendKeys(Keys.BACK_SPACE);
        	Issuedat.sendKeys(Keys.BACK_SPACE);
        	Issuedat.sendKeys(Keys.BACK_SPACE);
        	Issuedat.sendKeys(Keys.BACK_SPACE);
        	Thread.sleep(2000);
        	Issuedat.sendKeys(Issuedate);
        	WebElement Expirydat =  driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_cbpRepresentative_ASPxPanel1_dtpRepSrcRemIDExpDate_I"));
        	Thread.sleep(1000);
        	Expirydat.sendKeys(Keys.BACK_SPACE);
        	Expirydat.sendKeys(Keys.BACK_SPACE);
        	Expirydat.sendKeys(Keys.BACK_SPACE);
        	Expirydat.sendKeys(Keys.BACK_SPACE);
        	Expirydat.sendKeys(Keys.BACK_SPACE);
        	Expirydat.sendKeys(Keys.BACK_SPACE);
        	Expirydat.sendKeys(Keys.BACK_SPACE);
        	Expirydat.sendKeys(Keys.BACK_SPACE);
        	Expirydat.sendKeys(Keys.BACK_SPACE);
        	Expirydat.sendKeys(Keys.BACK_SPACE);
        	Thread.sleep(2000);
        	Expirydat.sendKeys(Expirydate);
        	Thread.sleep(500);
        	driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_cbpRepresentative_ASPxPanel1_btnRepSrcIDIssConSearch")).click();
        	Thread.sleep(500);
        	driver.findElement(By.id("splRemitterDetails_GenSearch_pcGeneralSearch_Panel2_grdGeneralSearchID_DXFREditorcol2_I")).sendKeys(RegCity);
             Thread.sleep(1000);
        	driver.findElement(By.id("splRemitterDetails_GenSearch_pcGeneralSearch_Panel2_btOK")).click();
        	driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_cbpRepresentative_ASPxPanel1_txtRepSrcIDIssPlace_I")).sendKeys(Issueplace);
        	Thread.sleep(100);
        	driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_cbpRepresentative_ASPxPanel1_btnAdd")).click();
        	Thread.sleep(100);
        	String myWindowHandle4 = driver.getWindowHandle();
        	driver.switchTo().window(myWindowHandle4);
			Thread.sleep(1000);
			 driver.findElement(By.id("popup_ok")).click();
			  Thread.sleep(1000);
			  driver.switchTo().frame(driver.findElement(By.name("panelContent")));
        	driver.findElement(By.id("splRemitterDetails_RepSearch_pcRepresentative_HCB-1")).click();
 
            
		}
		

	}


