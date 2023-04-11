package testpackBewkoof;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utils.Utility;
import browserSetup.Base;
import pages.HomepageBewkoof;
import pages.Shirtsection;

public class ToVerifyShirtSection extends Base{
	WebDriver driver;
	HomepageBewkoof homepagebewkoof;
	Shirtsection shirtsection;
	String testID;

	@Parameters ("browser")
	@BeforeTest
	public void beforeTest (String browserName) {
	
		if (browserName.equals("Chrome"))
		{
	      driver = openChromeBrowser();
		}
		
		if (browserName.equals("Firefox"))
		{
	     driver= openFirefoxBrowser();
		}		

		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	@BeforeClass 
	public void launchBrowser() {
		System.out.println("Hiii");
		
				
	}
	
	@BeforeMethod 
	public void openApplication() {
		driver.get("https://www.bewakoof.com/");
		homepagebewkoof = new HomepageBewkoof(driver);
		homepagebewkoof.clickOnMenSection();
		shirtsection = new Shirtsection(driver);		
	}
	
	
	
  @Test
   public void veriftShirtDetailsAfterClicking() {
	    testID= "105";
	   shirtsection.clickOnShirt();
	   String expectedURL = "https://www.bewakoof.com/p/mens-red-groovin-graphic-printed-oversized-t-shirt";
	   String actualURL= driver.getCurrentUrl();
	   Assert.assertEquals(actualURL, expectedURL);
	   
  }
  
  @Test
   public void verifyTitleofShirtSectionPage() {
	  testID = "104";
	 String A = "Men Clothing";
	 String B = shirtsection.pageTitle();
	Assert.assertEquals(B, A);
  }
  
  
  
  @AfterMethod
   public void afterMethod(ITestResult result) throws IOException {
	  if (ITestResult.FAILURE==result.getStatus())
	  {
		Utility.captureSceenshot(driver, testID);
	  }
	
	System.out.println("Logged Out");
	  System.out.println("Logged Out Application");
  }
  
  @AfterClass
   public void clearObject() {
	   driver.quit();
	   homepagebewkoof=null;
	   shirtsection = null;
	   System.gc();
	   
   }
  
  @AfterTest 
  public void afterTest () {
		
		System.out.println("Helllo After Test ");		
}
}
