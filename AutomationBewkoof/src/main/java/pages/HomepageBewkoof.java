package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageBewkoof {

	@FindBy (xpath = "//span[text()='MEN']")
	private WebElement men;
	
	@FindBy (xpath = "//a[@id='loginLink']")
	private WebElement login;
	
	@FindBy (xpath = "//button[@id='web_email_login']")
	private WebElement loginByEmailButton;
	
	@FindBy (xpath = "//input[@id='email_input']")
	private WebElement mailID;
	
	@FindBy (xpath = "//input[@id='mob_password']")
	private WebElement password;
	
	@FindBy (xpath ="//button[@id='mob_login_password_submit']")
	private WebElement loginButton;
	
	
	// constructor call
	public HomepageBewkoof (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMenSection() {
		men.click();
	}
	public void clickonLoginButtnOnHomePage () {
		login.click();
	}
	//changes
	public void loginToWebsite () {
		loginByEmailButton.click();
//		mailID.sendKeys("randhepankaj@gmail.com");
//		password.sendKeys("Pankaj@123");
//		loginButton.click();		
	}
	
	public void sendUsername(String user) {
		mailID.sendKeys(user);
	}
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	 
	
	
}
