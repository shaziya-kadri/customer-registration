package CustomerPackage;
//package Customer.CustomerRegistrationModule;
import static org.testng.AssertJUnit.assertTrue;
import static org.junit.Assert.assertThat;
import static org.testng.AssertJUnit.assertEquals;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
	import java.awt.AWTException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
	import org.fluentlenium.adapter.FluentTest;
    import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;


     public class CustomerRegClass extends FluentTest  {
		
		
		private  static WebDriver driver;
		private LoginPageElements pageElements;

	    public CustomerRegClass(WebDriver driver) {
	        this.driver = driver;
	        pageElements = PageFactory.initElements(driver, LoginPageElements.class);
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
		
		
		public static void Masters()
		{
			//driver.findElement(By.id("ctl00_splRoot_Content_HMenuSplitter_aspmMain_DXI0_T")).click();
			driver.findElement(By.id("ctl00_splRoot_Content_SubMenu_cbpSubMenu_navbSubMenus_I0i11_T")).click();
		}

		
		public static void FrameDetails() throws InterruptedException
		{
			Thread.sleep(500);
			java.util.List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
			System.out.println("The total number of iframes are " + iframeElements.size());
			Thread.sleep(2000);
			driver.switchTo().frame(driver.findElement(By.name("panelContent")));
			Thread.sleep(2000);
		}
		
		
		
		public static void Customer_RemitterType(String RemitterType) throws InterruptedException, AWTException
		{   
			Masters();
			FrameDetails();
			
			if("NA".equalsIgnoreCase(RemitterType)){
			   System.out.println("No IdType is given ");
	      
		}
		else
		{
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_cboCatagory_B-1")).click();
	        Thread.sleep(100);
			select(RemitterType);
		}
			
			
		}
		
		public static void Cusotmer_RiskCategory(String RiskCategory) throws InterruptedException, AWTException
		{
			
			if("NA".equalsIgnoreCase(RiskCategory)){
				   System.out.println("No IdType is given ");
		      
			}
			else
			{
				driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_cboRiskCat_B-1")).click();
				Thread.sleep(300);
				select(RiskCategory);
			}
			
		}
		public static void Customer_Gender(String Gender) throws InterruptedException, AWTException
		{
			
			if("NA".equalsIgnoreCase(Gender)){
				   System.out.println("No IdType is given ");
		      
			}
			else
			{
				driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_cboGender_B-1")).click();
				Thread.sleep(100);
	            select(Gender);	
			}
			
		}
		public static  void Cusotmer_ResidentType(String ResidentType) throws InterruptedException, AWTException 
		{

			if("NA".equalsIgnoreCase(ResidentType)){
				   System.out.println("No ResidentType is given ");
		      
			}
			else
			{
			
				driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_cboRemResType11_B-1")).click();
				Thread.sleep(100);
				select(ResidentType);
				}
			
		}
		
		public static  void  Customer_Salutation(String Salutation) throws InterruptedException, AWTException
		{
			if("NA".equalsIgnoreCase(Salutation)){
				   System.out.println("No ResidentType is given ");
		      
			}
			else
			{
				driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_cboSalutaion_B-1")).click();
				Thread.sleep(100);
				select(Salutation);
			}
			
			
		}
		public void Customer_FirstName(String FirstName) throws InterruptedException
		{
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtFirstName_I")).sendKeys(FirstName);
			Thread.sleep(100);
		}
		public void Customer_MiddleName(String MiddleName) throws InterruptedException
		{
			
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtMiddleName_I")).sendKeys(MiddleName);
			Thread.sleep(100);
		}
		public void Customer_LastName(String LastName) throws InterruptedException
		{
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtLastName_I")).sendKeys(LastName);
			Thread.sleep(100);
			
		}
		public void Customer_ArabicName(String ArabicFirstName,String ArabicMiddleName,String ArabicLastName) throws InterruptedException
		{
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtFirstAName_I")).sendKeys(ArabicFirstName);
			Thread.sleep(100);
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtMiddleAName_I")).sendKeys(ArabicMiddleName);
			Thread.sleep(100);
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtLastAName_I")).sendKeys(ArabicLastName);
			Thread.sleep(100);
		}
		
			public void Customer_Address(String Customer_Address,String Customer_Address2) throws InterruptedException
			{
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtAddress1_I")).sendKeys(Customer_Address);
		    Thread.sleep(100);
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtAddress2_I")).sendKeys(Customer_Address2); 
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_chkTagged_S_D")).click();
		    
			}
			public void Customer_NonMandatoryDetails(String TaggedRemarks,String CompanyAddress,String Building,String Street,String City,String State) throws InterruptedException
			{
				
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtTaggedRmrks_I")).sendKeys(TaggedRemarks);
		    Thread.sleep(100);
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtCompanyAdd_I")).sendKeys(CompanyAddress);
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtBuliding_I")).sendKeys(Building);
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtStreet_I")).sendKeys(Street);
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtCity_I")).sendKeys(City);
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtState_I")).sendKeys(State);
			}
			public void Customer_MobileValidation(String MobileNumber,String Phoneoffice,String PhoneResident)
			{
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtMobile_I")).sendKeys(MobileNumber);
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtPhone_I")).sendKeys(Phoneoffice);
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtPhoneRes_I")).sendKeys(PhoneResident);
			}
		   public void Customer_Email_IDValidation(String Zipcode,String Passport,String Email)
			{
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtZip_I")).sendKeys(Zipcode);
		     driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtPassport_I")).sendKeys(Passport);
		    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_txtEmail_I")).sendKeys(Email);
		    
			}
		    public static void CustomerIdType() throws InterruptedException
		    {
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_col0")).click();
			Thread.sleep(500);
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_efnew_btnIDTypeSearch")).click();
			
		    } 
		public static void CustomerNationality(String CustNationlity) throws InterruptedException, AWTException
		{
			if("NA".equalsIgnoreCase(CustNationlity)){
				
		         System.out.println("No EconomicActivity");
				}
			
			
				else
				{
					
					Thread.sleep(2000);
				    driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_btnNationSearch")).click();
					Thread.sleep(1000);
					driver.findElement(By.id("splRemitterDetails_GenSearch_pcGeneralSearch_Panel2_grdGeneralSearchID_DXFREditorcol2_I")).sendKeys(CustNationlity);
					Thread.sleep(1000);
		            select(CustNationlity);
		            Select_button();
				}  
	
		}
		public static void EconomicActivity(String CustEconomicActivity) throws InterruptedException, AWTException
		{	
				 if("NA".equalsIgnoreCase(CustEconomicActivity)){
						
			         System.out.println("No EconomicActivity");
					}
					else
					{
						
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_btnEcnomicActivity")).click();
			Thread.sleep(1000);
			//driver.findElement(By.id("splRemitterDetails_GenSearch_pcGeneralSearch_Panel2_grdGeneralSearchID_DXFREditorcol2_I")).sendKeys(CustEconomicActivity);
			
             //select(CustEconomicActivity);
            //driver.findElement(By.id("splRemitterDetails_GenSearch_pcGeneralSearch_Panel2_btOK_CD")).click();
            //Thread.sleep(1000);
			  Select_button();
			 Thread.sleep(1000);
		}
				
		}
		
		public static void PurposeofTransfer(String CustPurposeofTransfer) throws InterruptedException, AWTException
		{
		  if("NA".equalsIgnoreCase(CustPurposeofTransfer)){
					
		         System.out.println("No Purposeoftransfer");
				}
				else
				{
					
					driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_btnPurpose")).click();
					Thread.sleep(500);
		            select(CustPurposeofTransfer);
		            Select_button();
				}
			 Thread.sleep(1000);	
		}
		
		public static void DOB(String DateofBirth) throws InterruptedException
		{
			
			
			if("NA".equalsIgnoreCase(DateofBirth)){
				   System.out.println("No DateofBirth is given ");
		      
			}
			else
			{
				 WebElement dat =  driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_dtpDOB_I"));
				 Thread.sleep(2000);
				 dat.sendKeys(Keys.BACK_SPACE);
				 dat.sendKeys(Keys.BACK_SPACE);
				 dat.sendKeys(Keys.BACK_SPACE);
				 dat.sendKeys(Keys.BACK_SPACE);
				 dat.sendKeys(Keys.BACK_SPACE);
				 dat.sendKeys(Keys.BACK_SPACE);
				 dat.sendKeys(Keys.BACK_SPACE);
				 dat.sendKeys(Keys.BACK_SPACE);
				 dat.sendKeys(Keys.BACK_SPACE);
				 dat.sendKeys(Keys.BACK_SPACE);
				 Thread.sleep(2000);
				  dat.sendKeys(DateofBirth);
			}
		  
		}
		
	public void Customer_IDTYPE(String IdType,String Idnumber,String placeofissues,String Countryofissue,String IDIssuesdate,String ExpiryIDdate) throws InterruptedException, AWTException
		{   driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_header0_btnIDNew")).click();
		
		if("NA".equalsIgnoreCase(IdType)){
			
	         System.out.println("No EconomicActivity");
			}
			else
			{
				driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_efnew_btnIDTypeSearch")).click();
				Thread.sleep(5000);
				driver.findElement(By.id("splRemitterDetails_GenSearch_pcGeneralSearch_Panel2_grdGeneralSearchID_DXFREditorcol2_I")).sendKeys(IdType);
				select(IdType);
				
				driver.findElement(By.id("splRemitterDetails_GenSearch_pcGeneralSearch_Panel2_btOK")).click();
				Thread.sleep(100);
			}  
			
		driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_efnew_txtIDNo_I")).sendKeys(Idnumber);
		Thread.sleep(10000);
		driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_efnew_txtIssPlace_I")).sendKeys(placeofissues);
		Thread.sleep(5000);
		
		if("NA".equalsIgnoreCase(Countryofissue)){
			   System.out.println("No ResidentType is given ");
	      
		}
		else
		{
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_efnew_btnIssCountry")).click();
			Thread.sleep(5000);
		
			driver.findElement(By.id("splRemitterDetails_ConSearch_cbpCountrySearchEdit_pcCountrySearch_Panel2_grdCountrySearchID_DXFREditorcol2_I")).sendKeys(Countryofissue);
			Thread.sleep(3000);
			select(Countryofissue);
			Thread.sleep(3000);
			driver.findElement(By.id("splRemitterDetails_ConSearch_cbpCountrySearchEdit_pcCountrySearch_Panel2_btnOK_CD")).click();
		}
		ID_IssuesDate(IDIssuesdate);
		IDExpiryDate(ExpiryIDdate);
		
		Thread.sleep(1000);
		Customer_IdUpdate();
		}
	public  static void  Customer_IdUpdate() throws InterruptedException
		{	
		
		 //Actions action = new Actions(driver);
		 //Find the targeted element
		 Thread.sleep(2000);
		 WebElement elem = driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_efnew_lnkUpdate"));
		 /*Point locate_ele=elem.getLocation();
		 int x=locate_ele.getX();
		 int y=locate_ele.getY();
		 System.out.println(x+" "+y);
		 action.moveToElement(elem,x,y).click().build().perform();
		*/ 
		 Thread.sleep(2000);
		 elem.click();
		 Thread.sleep(2000);
		 System.out.println("Updated");
		 Thread.sleep(5000);
		//System.out.println(driver.findElement(By.cssSelector("#splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_DXDataRow0 > td:nth-child(6)")).getText());
		// driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_DXDataRow0")).
		// splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_DXDataRow0
		// #splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_efnew_lnkUpdate
          /*  WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement Update = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Cancel")));
			Update.
			Thread.sleep(5000);
			driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_DXCBtn0")).click();*/
				
	     //driver.findElement(By.id("//*[@id=\"splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_efnew_lnkUpdate\"]")).click();
		//driver.findElement(By.xpath("//*[@id=\"splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_efnew_lnkUpdate\"]")).click();
	   //driver.findElement(By.partialLinkText("Update")).click();
	 // driver.findElement(By.cssSelector("#splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_ef0_lnkUpdate")).click();
	 //driver.findElement(By.linkText("Update")).click();
	//driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_efnew_lnkUpdate")).click();
		}
		
	public static void ID_IssuesDate(String dateofissues) throws InterruptedException
	{
		if("NA".equalsIgnoreCase(dateofissues)){
			   System.out.println("No dateofissues is given ");
	      
		}
		else
		{
			WebElement dat =  driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_efnew_dtpIDIssueDt_I"));
			 Thread.sleep(1000);
			 dat.sendKeys(Keys.BACK_SPACE);
			 dat.sendKeys(Keys.BACK_SPACE);
			 dat.sendKeys(Keys.BACK_SPACE);
			 dat.sendKeys(Keys.BACK_SPACE);
			 dat.sendKeys(Keys.BACK_SPACE);
			 dat.sendKeys(Keys.BACK_SPACE);
			 dat.sendKeys(Keys.BACK_SPACE);
			 dat.sendKeys(Keys.BACK_SPACE);
			 dat.sendKeys(Keys.BACK_SPACE);
			 dat.sendKeys(Keys.BACK_SPACE);
			 Thread.sleep(2000);
			  dat.sendKeys(dateofissues);
		}
		
		
		
	
		}
	public void IDExpiryDate(String dateofexpiry) throws InterruptedException
		{
		
		if("NA".equalsIgnoreCase(dateofexpiry)){
			   System.out.println("No dateofissues is given ");
	      
		}
		else
		{
			 WebElement dat =  driver.findElement(By.id("splRemitterDetails_PageRemitter_cbpRemitterEdit_grdIdTypes_efnew_dtpIDExpDt_I"));
				Thread.sleep(1000);
				dat.sendKeys(Keys.BACK_SPACE);
				dat.sendKeys(Keys.BACK_SPACE);
				dat.sendKeys(Keys.BACK_SPACE);
				dat.sendKeys(Keys.BACK_SPACE);
				dat.sendKeys(Keys.BACK_SPACE);
				dat.sendKeys(Keys.BACK_SPACE);
				dat.sendKeys(Keys.BACK_SPACE);
				dat.sendKeys(Keys.BACK_SPACE);
				dat.sendKeys(Keys.BACK_SPACE);
				dat.sendKeys(Keys.BACK_SPACE);
				Thread.sleep(2000);
				 dat.sendKeys(dateofexpiry);
				 dat.sendKeys(Keys.TAB);
		}
			
	
				}
		 
		public void RemitterIDDetails(String place, String country, String nation) throws InterruptedException, AWTException
		{   Thread.sleep(500);
		
			driver.findElement(By.id("splFCPurchaseSaleDetails_rndPanel_cbpFCPurchaseSaleEdit_cpbFCRemitter_txtIDIssPlace_I")).sendKeys(place);
			Thread.sleep(500);
			if("NA".equalsIgnoreCase(country)){
				   System.out.println("No IdType is given ");
		      
			}
			else
			{
				driver.findElement(By.id("btnIDIssueCountry")).click();
				Thread.sleep(500);
				driver.findElement(By.id("splFCPurchaseSaleDetails_CountrySearches_cbpCountrySearchEdit_pcCountrySearch_Panel2_grdCountrySearchID_DXFREditorcol2_I")).sendKeys(country);
				Thread.sleep(1000);
			    select(country);
				driver.findElement(By.id("splFCPurchaseSaleDetails_CountrySearches_cbpCountrySearchEdit_pcCountrySearch_Panel2_btnOK_CD")).click();
				Thread.sleep(1000);
			}
			
			if("NA".equalsIgnoreCase(country)){
				   System.out.println("No IdType is given ");
		      
			}
			else
			{
				driver.findElement(By.id("btnCountrySearch")).click();
				Thread.sleep(500);
				driver.findElement(By.id("splFCPurchaseSaleDetails_CountrySearches_cbpCountrySearchEdit_pcCountrySearch_Panel2_grdCountrySearchID_DXFREditorcol2_I")).sendKeys(nation);
				Thread.sleep(1000);
				select(nation);
				driver.findElement(By.id("splFCPurchaseSaleDetails_CountrySearches_cbpCountrySearchEdit_pcCountrySearch_Panel2_btnOK_CD")).click();
			}
			
			
		
		}
		public void RemitterPhonePurpose(String mobile, String purpose) throws InterruptedException, AWTException
		{   	driver.findElement(By.id("splFCPurchaseSaleDetails_rndPanel_cbpFCPurchaseSaleEdit_cpbFCRemitter_txtPhoneNo_I")).clear();
			driver.findElement(By.id("splFCPurchaseSaleDetails_rndPanel_cbpFCPurchaseSaleEdit_cpbFCRemitter_txtPhoneNo_I")).sendKeys(mobile);
			Thread.sleep(500);
			if("NA".equalsIgnoreCase(purpose)){
				   System.out.println("No IdType is given ");
		      
			}
			else
			{
				driver.findElement(By.id("btnPurpose")).click();
				Thread.sleep(1000);
				select(purpose);
				 Select_button();
			}
			
			 	 	
		}
		public void save() throws InterruptedException
		{
			Thread.sleep(500);
			driver.findElement(By.id("splRemitterDetails_mnuButtons_DXI1_T")).click();
			  
		
		}
		public void updatecard() throws InterruptedException
		{      
		driver.findElement(By.id("splFCPurchaseSaleDetails_mnuButtons_DXI3_T")).click();
			   windowhandle();
			   Thread.sleep(200);
       driver.switchTo().frame(driver.findElement(By.name("panelContent")));
			 driver.findElement(By.id("splFCPurchaseSaleDetails_mnuButtons_DXI7_T")).click();
				Thread.sleep(500);		
		}
		
		public void approve() throws InterruptedException
		{
            driver.switchTo().frame(driver.findElement(By.name("panelContent")));
			Thread.sleep(500);
			driver.findElement(By.id("splFCPurchaseSaleDetails_mnuButtons_DXI4_T")).click();
				Thread.sleep(1000);
				windowhandle();
			//driver.switchTo().frame(driver.findElement(By.name("panelContent")));
			//Thread.sleep(1000);
			//cashierScreen();
			//driver.navigate().back();		
		}
		
		public static void Logout()
		{
		        driver.findElement(By.linkText("Log Out")).click();		
	    }
	  
	    public static void select(String element) throws InterruptedException, AWTException {
			Thread.sleep(500);
			WebElement s2= driver.findElement(By.xpath("//td[contains(text(),\""+element+"\")]"));
			Thread.sleep(500);
			s2.click();
	    }
	    public static void Select_button() throws InterruptedException {
			Thread.sleep(100);
			driver.findElement(By
					.id("splRemitterDetails_GenSearch_pcGeneralSearch_Panel2_btOK"))
					.click();
		}
		public  void selectFromList(String element) throws InterruptedException {
			WebElement s1 = driver.findElement(By.xpath("//ul/li/span[contains(text(),\"" + element + "\")]"));
			Thread.sleep(1000);
			s1.click();
			}
        public  void homePage() throws Exception 
	    {
	       Thread.sleep(500);
			driver.findElement(By.id("ctl00_splLoginMaster_Content_splMain_btnContinue_CD")).click();
	    	
	    }
		
       public void windowhandle() throws InterruptedException
		{
			Thread.sleep(1000);
			String myWindowHandle = driver.getWindowHandle();
			driver.switchTo().window(myWindowHandle);
			WebElement accept = driver.findElement(By.xpath("//*[@id=\"popup_ok\"]"));
			accept.click();
			Thread.sleep(500);
		}
		}



