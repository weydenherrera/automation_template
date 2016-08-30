package tooltwist.stepDefinitions.regressionTest;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import tooltwist.pageObjects.TestGooglePageObject;
import tooltwist.utils.ElementUtil;
import tooltwist.utils.TestInit;

public class TestGoogle {
	public WebDriver driver =  null;
	public ElementUtil elementUtil = null;
	public TestGooglePageObject testGooglePageObject = null;
	
	public TestGoogle(TestInit ti) {
		this.driver = ti.getDriver();
		this.elementUtil = ti.getElementUtil();
		this.testGooglePageObject = new TestGooglePageObject(ti);
	}
	
	@Given("I access Google site, (.*)")
	public void i_access_Google_site_www_google_com_ph(String url) throws Throwable {
		testGooglePageObject.goToGoogle(url);
		
		
	}

	@Then("I should be navigated to Google site")
	public void i_should_be_navigated_to_Google_site() throws Throwable {
		testGooglePageObject.checkLogo();
	}

	
}
