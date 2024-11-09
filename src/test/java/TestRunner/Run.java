package TestRunner;

import org.junit.runner.RunWith;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features={".//Features/Customers.feature",".//Features/LoginFeature.feature"},
		//features=".//Features/",
		glue="stepDefinition",
		dryRun=false,
		monochrome=true,
		tags="@regression",//scenarios under @regression will only execute
		//plugin= {"pretty","html:target/cucumber-reports/reports1.html"}
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
//"pretty","html:target/cucumber-reports/reports1.html"
//"pretty","json:target/cucumber-reports/reports_json.json"
//"junit:target/cucumber-reports/reports_xml.xml",
public class Run extends AbstractTestNGCucumberTests{
	

}
