package testpackBewkoof;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

public class ToVerifyHomePage extends Base {
	WebDriver driver;
	HomepageBewkoof homepagebewkoof;
	String testID;
	
	
	@Parameters ("browser")
	@BeforeTest
	 public void beforeTest(String browserName) {
		 
		if (browserName.equals("Chrome"))
		{
          driver = openChromeBrowser();
		}
		
		if (browserName.equals("Firefox"))
		{
          driver = openFirefoxBrowser();
		}
		
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
	@BeforeClass 
	public void launchBrowser() throws IOException, InterruptedException {
		
		System.out.println("Before Class");
		//driver.get("https://www.bewakoof.com/");
		Thread.sleep(5000);
		homepagebewkoof = new HomepageBewkoof(driver);
		
				
	}
	
	@BeforeMethod 
	public void openApplication() {
		System.out.println("Before Method");
		driver.get("https://www.bewakoof.com/");
		//homepagebewkoof = new HomepageBewkoof(driver);
				
	}
	
	@Test
	
	public void verifyLoginButtononHomePage() {
		testID="TestCase101";
		homepagebewkoof.clickonLoginButtnOnHomePage();
		String expectedTitle = "Online Fashion Shopping for Men, Women, Accessories - Bewakoof.com";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	
	
	@Test
	public void verifyMenSectionafterClickingMenTab() {
		testID="TestCase102";
		homepagebewkoof.clickOnMenSection();
		String expectedURL= "https://www.bewakoof.com/men-clothing";
		String actualURL = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);	
	}
	
	@Test 
	public void enterLoginDetail() throws InterruptedException, IOException {
		
		homepagebewkoof.clickonLoginButtnOnHomePage();
		Thread.sleep(5000);
		homepagebewkoof.loginToWebsite();
		Thread.sleep(5000);
		homepagebewkoof.sendUsername(Utility.getExceldata("sheete", 1, 0));
		homepagebewkoof.sendPassword(Utility.getExceldata("sheete", 1, 1));
		Thread.sleep(3000);
		homepagebewkoof.clickOnLoginButton();
						
		
	}
	@Test
	public void tempTest() {
		testID="TestCase10";
		String actualData= "ABC";
		String expectedData ="ABc";
		Assert.assertEquals(actualData, expectedData);
	}
	
	
		
	@AfterMethod
	 public void logOutBrowser(ITestResult result) throws IOException {
		if (ITestResult.FAILURE==result.getStatus())
		  {
			Utility.captureSceenshot(driver, testID);
		  }
		
		System.out.println("Logged Out");
	}
	
	@AfterClass
	 public void clearObject() {
		driver.quit();
		homepagebewkoof =null;
		System.gc();
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Helllo verifyLoginButtononHomePage After Test ");
	}
		
	}

