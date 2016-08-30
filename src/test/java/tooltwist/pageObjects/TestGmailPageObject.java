package tooltwist.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import tooltwist.utils.ElementUtil;
import tooltwist.utils.ObjectReference;
import tooltwist.utils.TestInit;

public class TestGmailPageObject extends ObjectReference {
	private WebDriver driver = null;
	private ElementUtil elementUtil = null;
	private TestInit ti = null;
	private static final Logger logger = LoggerFactory.getLogger(TestGmailPageObject.class);

	public TestGmailPageObject(TestInit ti) {
		this.driver = ti.getDriver();
		this.elementUtil = ti.getElementUtil();
		this.ti = ti;
	}

	public void goToGoogle(String url) {
		String redirectTo = url.replace("{url}", ti.getEnvironmentUrl());
		driver.navigate().to(redirectTo);
		logger.info("Redirected to Google site");
	}

	public void checkLogo() throws InterruptedException {
		Assert.assertTrue("UNAVAILABLE Google Logo", elementUtil.isElementAvailabe(GOOGLE_LOGO));
		logger.info("Google logo is available");
	}
	
	public void enterEmail(String email) throws InterruptedException{
		String emailRep = email.replace("{email}", ti.getConfig().getConfig("email"));
		if(elementUtil.isElementAvailabe(EMAIL_FIELD_GMAIL)){
			WebElement emailField = driver.findElement(By.xpath(EMAIL_FIELD_GMAIL));
			emailField.sendKeys(emailRep);
			
			WebElement nextButton = driver.findElement(By.xpath(NEXT_BUTTON_GMAIL));
			nextButton.click();
		}
	}
	
	public void enterPassword(String password){
		String emailRep = password.replace("{password}", ti.getConfig().getConfig("password"));
		WebElement passwordField = driver.findElement(By.xpath(PASSWORD_FIELD_GMAIL));
		passwordField.sendKeys(emailRep);
		
		/*WebElement nextButton = driver.findElement(By.xpath(NEXT_BUTTON_GMAIL));
		nextButton.click();*/
	}
	
	public void clickSigninButton(){
		WebElement nextButton = driver.findElement(By.xpath(SIGNIN_BUTTON_GMAIL));
		nextButton.click();
	}
	
	public void checkURL() throws InterruptedException {
		elementUtil.waitForPageToLoad(driver, 7000);
		String currentURL = driver.getCurrentUrl();
		String finalURL = ti.getConfig().getConfig("finalURL");
		
		Assert.assertTrue(currentURL.equals(finalURL));
		
	}
}
