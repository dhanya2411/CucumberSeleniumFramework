package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class PersonalInfoStepDefinition {
	
	public WebDriver driver;
	HomeStepDefinition hp = new HomeStepDefinition();	
	
	
//PersonalInfoTest - Scenario 1 starts here		
	
/*	@Before
	public void Login() throws InterruptedException {
		
		hp.lp.LoginPage();
		hp.lp.IDEntered();
		hp.lp.NextButtonClicked();
		hp.lp.PassworEntered();
		hp.lp.NextButtonClicked(); 
		
	} */
	
	
	@Given("Login and Land on Home Page")
	public void LoginAndNavigate() throws InterruptedException {
	    hp.lp.LoginPage();
		hp.lp.IDEntered();
		hp.lp.NextButtonClicked();
		hp.lp.PassworEntered();
		hp.lp.NextButtonClicked();  
		
		hp.lp.driver.getTitle();
	}
	
	@Then("Click on Personal Info")
	public void PersonalInfo() {
		hp.lp.driver.findElement(By.xpath("(//div[text()='Personal info'])[2]")).click();
				
	    }
	
	@Then("Personal Info Header texts are verified")
	public void HeaderTextVerification() throws InterruptedException {
		Thread.sleep(3000);
		
		String PersonalInfoHeader = hp.lp.driver.findElement(By.xpath("//header[@class='hrNQqb']/h1")).getText();
		Assert.assertEquals(PersonalInfoHeader, "Personal info");		
		String PersonalInfoHeaderText = hp.lp.driver.findElement(By.xpath("//div[@class='mPKYhd']")).getText();
		Assert.assertEquals(PersonalInfoHeaderText, "Info about you and your preferences across Google services");
		String PersonalInfoHeader2 = hp.lp.driver.findElement(By.xpath("(//h2[@class='PdgnBc'])[1]")).getText();
		Assert.assertEquals(PersonalInfoHeader2, "Your profile info in Google services");
		String PersonalInfoHeaderText2 = hp.lp.driver.findElement(By.xpath("(//p[@class='fyjRne'])[1]")).getText();
		Assert.assertEquals(PersonalInfoHeaderText2, "Personal info and options to manage it. You can make some of this info, like your contact details, visible to others so they can reach you easily. You can also see a summary of your profiles.");
		String PersonalInfoHeader3 = hp.lp.driver.findElement(By.xpath("//h2[text()='Basic info']")).getText();
		Assert.assertEquals(PersonalInfoHeader3, "Basic info");
		String PersonalInfoHeaderText3 = hp.lp.driver.findElement(By.xpath("(//div[@class='sieBfb']/div)[6]")).getText();
		Assert.assertEquals(PersonalInfoHeaderText3, "Some info may be visible to other people using Google services. Learn more");
			   
	}
	
	@And("Browser is closed for Personal Info Test") 
	public void CloseBrowser() {
		hp.lp.driver.quit();
	}  
	
/*	@After
	public void CloseBrowser() {
		hp.lp.driver.quit();
	} */
	
//PersonalInfoTest - Scenario 2 starts here		
	
	@Then("Verify Basic Info")
	public void VerifyBasicInfo() throws InterruptedException {
		Thread.sleep(8000);
		hp.lp.driver.findElement(By.xpath("(//div[@class='WzaSad'])[1]")).click();
		Thread.sleep(2000);
		hp.lp.driver.switchTo().frame(0);
		WebElement CloseButton = hp.lp.driver.findElement(By.xpath("//button[@aria-label='Close profile picture']"));
		((JavascriptExecutor) hp.lp.driver).executeScript("arguments[0].click", CloseButton);
		Thread.sleep(3000);
		hp.lp.driver.switchTo().defaultContent();
		
			}
	
//PersonalInfoTest - Scenario 3 starts here		
		
	@Then("Verify Contact Info")
	public void VerifyContactInfo() throws InterruptedException {
		Thread.sleep(3000);
		String ContactInfo = hp.lp.driver.findElement(By.xpath("//div[@class=\"wJpH8c\"]//h2[text()='Contact info']")).getText();
	    ((JavascriptExecutor) hp.lp.driver).executeScript("arguments[0].click", ContactInfo); //(JavascriptExecutor) driver) is used when 'WebDriver driver' is used
		Assert.assertEquals(ContactInfo, "Contact info");
	}


		
	}
	
	