package stepdefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	public WebDriver driver;
			
	//LoginTest - Scenario 1 starts here	
			
		@Given("User is able to navigate to Google Login Page URL")
		public void LoginPage() {
			driver = new FirefoxDriver();
		 	driver.navigate().to("https://accounts.google.com/v3/signin/identifier?checkedDomains=youtube&continue=https%3A%2F%2Faccounts.google.com%2F&ddm=0&flowEntry=ServiceLogin&flowName=GlifWebSignIn&followup=https%3A%2F%2Faccounts.google.com%2F&ifkv=ARpgrqc7q10n5VZBFdezmlebpcKGgKJ0eyg31thw52rFC72yTocQVmPPFzHxbwpvPSi0I1MVsH0bLw&pstMsg=1&dsh=S1814949855%3A1727214382603899");
		    driver.getTitle();
		}

		@When("Title is Sign in - Google Accounts")
		public void VerifyTitle() {
		    String Title = driver.getTitle();
		    Assert.assertEquals(Title, "Sign in - Google Accounts");
		    
		}

		@Then("User enters ID")
		public void IDEntered() throws InterruptedException {
		    Thread.sleep(3000);
		    driver.findElement(By.id("identifierId")).sendKeys("dhanyaautomationpractice@gmail.com");  
		}

		@Then("User clicks on Next button")
		public void NextButtonClicked() throws InterruptedException {
		    driver.findElement(By.xpath("//span[text()='Next']")).click();
		   	Thread.sleep(8000);
		}

		@Then("User enters Password")
		public void PassworEntered() throws InterruptedException  {
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Dhanya@12");
			Thread.sleep(3000);
		}

		@Then("User is on Home Page")
		public void HomePageOpened() {
			String Title = driver.getTitle();
			Assert.assertEquals(Title, "Google Account");
		    
		}
		
		@And("Browser is closed for Login Test")
		public void CloseBrowser() {
			driver.quit();     
		} 
		
	//LoginTest - Scenario 2 starts here	
		
		@Then("Click on Forgot Email link")
		public void ForgotEmailLink() throws InterruptedException {
		    driver.findElement(By.xpath("//button[text()='Forgot email?']")).click();
		    Thread.sleep(3000);
		}

		@Then("Enter Recovery Email")
		public void RecoveryEmail() throws InterruptedException {
			driver.findElement(By.xpath("//input[@id='recoveryIdentifierId']")).sendKeys("dhanyaiyer1993@gmail.com");
			Thread.sleep(3000);
		    
		}

		@Then("Enter Recovery Email Details")
		public void RecoveryEmailDetails() {
		   driver.findElement(By.id("firstName")).sendKeys("Dhanya");
		   driver.findElement(By.id("lastName")).sendKeys("Iyer");
		}
		
	//LoginTest - Scenario 3 starts here
		
		@Then("Verify Learn More link text")
		public void VerifyLearnMoreLinkText() {
		  String a =driver.findElement(By.xpath("(//div[@class='dMNVAe'])[3]")).getText();
		  Assert.assertEquals(a, "Not your computer? Use a Private Window to sign in. Learn more about using Guest mode");
		}

		@Then("Click on Learn more about using Guest mode link")
		public void LearnMoreLink() throws InterruptedException {
		  driver.findElement(By.xpath("//a[text()='Learn more about using Guest mode']")).click();
		  Set<String> allWindows = driver.getWindowHandles();
		  Iterator<String> iter = allWindows.iterator();
		  iter.next();
		  String ChildWindow = iter.next();
		  driver.switchTo().window(ChildWindow);
		  Thread.sleep(3000);
		  String a = driver.getTitle();
		  Assert.assertEquals(a, "Sign in on a device that's not yours - Computer - Google Account Help");
		}

		
	}   



