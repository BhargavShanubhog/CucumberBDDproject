package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement pwd;
	
	@FindBy(xpath="//button[normalize-space()='Log in']")
	WebElement btn;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	public void enterEmail(String Email) {
		email.clear();
		email.sendKeys(Email);
	}
	
	public void enterPassword(String Psd) {
		pwd.clear();
		pwd.sendKeys(Psd);
	}
	
	public void ClickLogIn() {
		btn.click();
	}
	
	public void ClickLogOut() {
		logout.click();
	}
	
	

}
