package stepDefinition;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;

import Utilities.ReadConfig;
import pageObject.AddNewCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

/*Parent Class*/
public class BaseClass {
	public static WebDriver driver;
	public LoginPage lp;
	public SearchCustomerPage ch;
	public AddNewCustomerPage c;
	public ReadConfig po;
	
	/*unique email*/
	public String generateEmailId() {
		return(RandomStringUtils.randomAlphabetic(5));
		
	}

}
