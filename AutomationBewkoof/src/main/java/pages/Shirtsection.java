package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shirtsection {
	
	@FindBy (xpath ="(//div//img)[22]")
	private WebElement shirt;
	
	@FindBy (xpath ="(//div//h1)[1]")
	private WebElement pageTitle;
	
	//constructor call
	public Shirtsection(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnShirt() {
		shirt.click();
		
	}
	
	public String pageTitle() {
		String str = pageTitle.getText();
				return str;
	}
	  
	
	

}
