package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage {
	public WebDriver driver;
	
	public AddNewCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Find web elements on the web page
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement lnkCustomers_menu;
	//(//a[@class='nav-link active'])[1]
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	WebElement lnkCustomers_menuitem;
	
	@FindBy(xpath="//a[normalize-space()='Add new']")
	WebElement btnAddnew;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement lastname;
	
	@FindBy(xpath="[//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--focus']//ul[@class='select2-selection__rendered']]")
	WebElement role;
	
	@FindBy(xpath="button[name='save']")
	WebElement savebtn;
	
	
	//////Actions Methods foe web elements
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void ClickonCustomersmenu() {
		lnkCustomers_menu.click();
		
	}
	public void ClickonCustomersmenuItem() {
		lnkCustomers_menuitem.click();
		
	}
	public void ClickonAddNew() {
		btnAddnew.click();
		
	}
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
		
	}
	
	public void enterPassword(String pass) {
		txtPassword.sendKeys(pass);
		
	}
	public void enterFirstName(String fn) {
		firstname.sendKeys(fn);
		
	}
	
	public void enterLastName(String ln) {
		lastname.sendKeys(ln);
		
	}
	public void enterRole(String r) {
		role.sendKeys(r);
		
	}
	public void clickSaveButton() {
		savebtn.click();
		
	}
	

}
