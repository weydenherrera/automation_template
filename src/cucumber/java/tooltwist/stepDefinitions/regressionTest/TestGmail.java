package tooltwist.stepDefinitions.regressionTest;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import tooltwist.pageObjects.TestGmailPageObject;
import tooltwist.utils.ElementUtil;
import tooltwist.utils.TestInit;

public class TestGmail {
	
	public WebDriver driver =  null;
	public ElementUtil elementUtil = null;
	public TestGmailPageObject testGmailPageObject = null;
	
	public TestGmail(TestInit ti) {
		this.driver = ti.getDriver();
		this.elementUtil = ti.getElementUtil();
		this.testGmailPageObject = new TestGmailPageObject(ti);
	}
	
	@Given("I access gmail site, (.*)")
	public void i_access_gmail_site_url(String urlStart) throws Throwable {
		testGmailPageObject.goToGoogle(urlStart);
	}

	@When("a valid email is entered, (.*)")
	public void a_valid_email_is_entered_email(String email) throws Throwable {
		testGmailPageObject.enterEmail(email);
	}

	@When("a valid password entered, (.*)")
	public void a_valid_password_entered_password(String password) throws Throwable {
		testGmailPageObject.enterPassword(password);
	}

	@When("login button is clicked")
	public void login_button_is_clicked() throws Throwable {
		testGmailPageObject.clickSigninButton();
	}

	@Then("I should be logged in to gmail site, (.*)")
	public void i_should_be_logged_in_to_gmail_site_finalURL(String urlFinal) throws Throwable {
		testGmailPageObject.checkURL();
	}
}
