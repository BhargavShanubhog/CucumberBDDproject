package stepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AddNewCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

/*Child class of BaseClass*/
public class StepDef extends BaseClass{
	
	@Before("@Sanity")
	public void setUp() {
		po=new ReadConfig();
		
		String browser=po.getBrowser();
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
			
		default:
			driver=null;
			break;
			
			
			
		}
		
		
	}
	@Before("@regression")
	public void setUp1() {
		WebDriverManager.chromedriver().setup();
		System.out.println("setUp1  method executed");
		driver=new ChromeDriver();
		
	}
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		
		lp=new LoginPage(driver);
		c=new AddNewCustomerPage(driver);
		ch=new SearchCustomerPage(driver);
	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String string) {
		driver.get(string);
	    
	}

	@When("User enters Email as {string} and Password {string}")
	public void user_enters_email_as_and_password(String emailadd, String passwd) {
		lp.enterEmail(emailadd);
		lp.enterPassword(passwd);
	    
	}

	@When("click on Login")
	public void click_on_login() {
		lp.ClickLogIn();
	   
	}
	
	////////////Login Feature//////////////////////////////////

	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		String actualTitle=driver.getTitle();
		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);//pass
		}
		else {
			Assert.assertTrue(false);//fail
			
		}
	    
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() {
		lp.ClickLogOut();
	   
	}

	
	
	//////Add a new customer details/////////
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		String actualTitle=c.getPageTitle();
		String expectedTitle="Dashboard / nopCommerce administration";
		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	   
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		c.ClickonCustomersmenu();
	    
	}

	@When("click on customres Menu Item")
	public void click_on_customres_menu_item() {
		c.ClickonCustomersmenuItem();
	    
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		c.ClickonAddNew();
	    
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle=c.getPageTitle();
		String expectedTitle="Add a new customer / nopCommerce administration";
		if(actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	  
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		//c.enterEmail("bhargavshanubhog@gmail.com");
		c.enterEmail(generateEmailId()+"@gmail.com");
		c.enterPassword("SoftwareTest@123");
		c.enterFirstName("Bhargav");
		c.enterLastName("Shanubhog");
		c.enterRole("Guests");
	   
	}

	@When("click on Save button")
	public void click_on_save_button() {
		c.clickSaveButton();
	    
	}

	@Then("User can view confirmation message\"The new customer has been added successfully.\"")
	public void user_can_view_confirmation_message_the_new_customer_has_been_added_successfully() {
		String h=driver.findElement(By.xpath("//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--focus']//ul[@class='select2-selection__rendered']")).getText();
		if(h.contains("The new customer has been added successfully.")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
	    
	}
	
	
	
	/////////Search Customer///////////////
	@When("Enter customer email")
	public void enter_customer_email() {
		ch.enterEmailAddress("victoria_victoria@nopCommerce.com");
		
		
		
	    
	}

	@When("Click on search button")
	public void click_on_search_button() {
		ch.clickOnSerachButton();
	    
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedemail="victoria_victoria@nopCommerce.com";
		Assert.assertTrue(ch.searchCustmerByEmail(expectedemail));
		/*if(ch.searchCustmerByEmail(expectedemail)==true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
			
		}*/
	    
	}
	
	////////search customer by name//////////////////////////////////////////////////////
	@When("Enter customer Firstname")
	public void enter_customer_firstname() {
		ch.enterFirstName("Victoria");
		
	    
	}

	@When("Enter customer Lastname")
	public void enter_customer_lastname() {
		ch.enterLastName("Terces");
	    
	}

	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName="Victoria Terces";
		Assert.assertTrue(ch.searchCustmerByName(expectedName));
	    
	}
	
	//@After
	public void teardown(Scenario sc) throws IOException {
		System.out.println("Tear Down method executed");
		if(sc.isFailed()==true) {
			String Filepath="C:\\Users\\HP\\eclipse-workspace\\BDDCUCUMBER\\Screenshot\\failedtest1.png";
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourcefile=ts.getScreenshotAs(OutputType.FILE);
			File DestFile=new File(Filepath);
			FileUtils.copyFile(sourcefile, DestFile);
		}
		driver.quit();
	}
	
	@BeforeStep
	public void beforeStep() {
		System.out.println("This is before method");
		
	}
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			final byte[]screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		
		
	}



}
