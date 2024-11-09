package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
   WebDriver driver;
	
	public SearchCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='SearchEmail']")
	WebElement emailaddress;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement searchbtn;
	
	@FindBy(xpath="//th[contains(text(),'Email')]")
	WebElement searchbtnt;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody//tr")
	List<WebElement>tableRows;
	
	/*@FindBy(xpath="//table[@id='customers-grid']//tbody//tr[1]//td")
	List<WebElement>tableCols;*/
	
	@FindBy(xpath="//input[@id='SearchFirstName']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='SearchLastName']")
	WebElement lastname;
	
	//action method to enter email address
	public void enterEmailAddress(String email) {
		emailaddress.sendKeys(email);
		
	}
	
	//action method to perform click action on search button
	public void clickOnSerachButton() {
		searchbtn.click();
		
	}
	
	public boolean searchCustmerByEmail(String Email) {
		boolean found=false;
		//total no. of rows in a grid
		int tr=tableRows.size();
		
		
		for(int i=1;i<=tr;i++) {
			WebElement actualemail=driver.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr["+ i +"]//td[2]"));
			String actualEA=actualemail.getText();
			if(actualemail.equals(actualEA)) {
				found=true;
			}
			
			
			
		}
		return found;
		
		
	}
//////////////////////////Search customer by Name/////////////////////////////////////////////////////////////////////
	//action method to enter first name
		public void enterFirstName(String fn) {
			firstname.sendKeys(fn);
			
		}
		
	//action method to enter first name
		public void enterLastName(String ln) {
			lastname.sendKeys(ln);
					
					
		}
		public boolean searchCustmerByName(String Name) {
			boolean found=false;
			//total no. of rows in a grid
			int tr=tableRows.size();
			
			
			for(int i=1;i<=tr;i++) {
				WebElement aName=driver.findElement(By.xpath("//table[@id='customers-grid']//tbody//tr["+ i +"]//td[3]"));
				String actualName=aName.getText();
				if(actualName.equals(Name)) {
					found=true;
					break;
				}
				
				
				
			}
			return found;
				
	

}
}
