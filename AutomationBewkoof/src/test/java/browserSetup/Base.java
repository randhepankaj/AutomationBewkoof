package browserSetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {
	
	public static WebDriver openChromeBrowser() {
	      System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\browserFile\\chromedriver.exe");
	      ChromeOptions option = new ChromeOptions();
		  option.addArguments("--disable-notifications", "--remote-allow-origins=*");
          WebDriver driver = new ChromeDriver(option);
          return driver;
		}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\browserFile\\geckodriver.exe");
	    FirefoxOptions option = new FirefoxOptions();
		WebDriver driver = new FirefoxDriver(option);
	    return driver;
	}
	
	
	
	

}
