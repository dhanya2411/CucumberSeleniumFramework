package stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class HomeStepDefinition {
	
	
	public WebDriver driver;
	LoginStepDefinition lp = new LoginStepDefinition();
		
//HomeTest - Scenario 1 starts here		
	
	@Given("Login and Navigate to Home Page")
	public void HomePage() throws InterruptedException  {
		
		 lp.LoginPage();
		 lp.IDEntered();
		 lp.NextButtonClicked();
		 lp.PassworEntered();
		 lp.NextButtonClicked(); 
		 lp.driver.getTitle();
	}
		
	@Then("Home Page Welcome texts are verified")
	public void HomePageTextsVerification() throws InterruptedException {
		
    lp.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
	String WelcomeText = lp.driver.findElement(By.xpath("//h1[@class='XY0ASe']")).getText();
	Assert.assertEquals(WelcomeText, "Welcome, Dhanya Iyer");
	String ManageInforText = lp.driver.findElement(By.xpath("//div[@class='WXMuEd']")).getText();
	Assert.assertEquals(ManageInforText, "Manage your info, privacy, and security to make Google work better for you. Learn more");
		
	}  
	
	@And ("Browser is closed for Home Test")
	public void CloseBrowser() {
		
	lp.driver.quit();
	}
	
//HomeTest - Scenario 2 starts here		
	
	@Then ("Add Recovery Details as Phone Number equals to {string} and Address equals to {string}")
	public void AddRecoveryDetails(String Phone, String Address) throws InterruptedException {
		
		lp.driver.findElement(By.xpath("//a[@aria-label='Add recovery phone']")).click();
		lp.driver.findElement(By.xpath("//input[@aria-label='Your recovery phone']")).sendKeys(Phone);
		String RecoveryInfoText = lp.driver.findElement(By.xpath("(//div[@class='h0PAh'])[1]")).getText();
		Assert.assertEquals(RecoveryInfoText, "Enter a phone number to use for security purposes. This phone number can be used to help verify it’s really you signing into your account.");
		lp.driver.findElement(By.xpath("(//span[text()='Cancel'])[1]")).click();
		Thread.sleep(3000);
		lp.driver.findElement(By.xpath("(//div[@aria-label='Back'])[1]")).click();
		lp.driver.findElement(By.xpath("//a[@aria-label='Set home address']")).click();
		lp.driver.findElement(By.xpath("//input[@aria-label='Address input field']")).sendKeys(Address);
		Thread.sleep(3000);
		List<WebElement> list = lp.driver.findElements(By.xpath("//ul[@aria-label='Address input field']/li"));
		for(int i=0 ; i<list.size(); i++) {
		System.out.println(list.get(i).getText());
			
		}
		lp.driver.findElement(By.xpath("//ul[@aria-label='Address input field']/li[2]")).click();
		String RecoveryInfoText2 = lp.driver.findElement(By.xpath("//div[@class='btFaIb']/p[1]")).getText();
		Assert.assertEquals(RecoveryInfoText2, "Your home and work addresses are used to personalize your experiences across Google products, and for more relevant ads. You can remove them any time. Learn more");
		
	}
	
//HomeTest - Scenario 3 starts here	
	
	@Then ("Add Recovery Details using Examples as Phone Number equals to {string} and Address equals to {string}")
    public void AddRecoveryDetailsUsingExamples(String Phone, String Address) throws InterruptedException {
		
		lp.driver.findElement(By.xpath("//a[@aria-label='Add recovery phone']")).click();
		lp.driver.findElement(By.xpath("//input[@aria-label='Your recovery phone']")).sendKeys(Phone);
		String RecoveryInfoText = lp.driver.findElement(By.xpath("(//div[@class='h0PAh'])[1]")).getText();
		Assert.assertEquals(RecoveryInfoText, "Enter a phone number to use for security purposes. This phone number can be used to help verify it’s really you signing into your account.");
		lp.driver.findElement(By.xpath("(//span[text()='Cancel'])[1]")).click();
		Thread.sleep(3000);
		lp.driver.findElement(By.xpath("(//div[@aria-label='Back'])[1]")).click();
		lp.driver.findElement(By.xpath("//a[@aria-label='Set home address']")).click();
		lp.driver.findElement(By.xpath("//input[@aria-label='Address input field']")).sendKeys(Address);
		Thread.sleep(3000);
		List<WebElement> list = lp.driver.findElements(By.xpath("//ul[@aria-label='Address input field']/li"));
		for(int i=0 ; i<list.size(); i++) {
		System.out.println(list.get(i).getText());
			
		}
		lp.driver.findElement(By.xpath("//ul[@aria-label='Address input field']/li[2]")).click();
		String RecoveryInfoText2 = lp.driver.findElement(By.xpath("//div[@class='btFaIb']/p[1]")).getText();
		Assert.assertEquals(RecoveryInfoText2, "Your home and work addresses are used to personalize your experiences across Google products, and for more relevant ads. You can remove them any time. Learn more");
		
	}    
	
//HomeTest - Scenario 4 starts here		
	
	@Then("Add Recovery Details using Data Table")
	public void AddRecoveryDetailsUsingDataTable(DataTable RecoveryInputs) throws InterruptedException {
		
		List<List<String>> data =  RecoveryInputs.asLists();
		
//Data 1 -
		
		lp.driver.findElement(By.xpath("//a[@aria-label='Add recovery phone']")).click();
		//Enter Phone from data table
		lp.driver.findElement(By.xpath("//input[@aria-label='Your recovery phone']")).sendKeys(data.get(0).get(0));
		String RecoveryInfoText = lp.driver.findElement(By.xpath("(//div[@class='h0PAh'])[1]")).getText();
		Assert.assertEquals(RecoveryInfoText, "Enter a phone number to use for security purposes. This phone number can be used to help verify it’s really you signing into your account.");
		lp.driver.findElement(By.xpath("(//span[text()='Cancel'])[1]")).click();
		Thread.sleep(3000);
		lp.driver.findElement(By.xpath("(//div[@aria-label='Back'])[1]")).click();
		lp.driver.findElement(By.xpath("//a[@aria-label='Set home address']")).click();
		//Enter Address from data table
		lp.driver.findElement(By.xpath("//input[@aria-label='Address input field']")).sendKeys(data.get(0).get(1));
		Thread.sleep(3000);
		List<WebElement> list = lp.driver.findElements(By.xpath("//ul[@aria-label='Address input field']/li"));
		for(int i=0 ; i<list.size(); i++) {
		System.out.println(list.get(i).getText());
			
		}
		lp.driver.findElement(By.xpath("//ul[@aria-label='Address input field']/li[2]")).click();
		String RecoveryInfoText2 = lp.driver.findElement(By.xpath("//div[@class='btFaIb']/p[1]")).getText();
		Assert.assertEquals(RecoveryInfoText2, "Your home and work addresses are used to personalize your experiences across Google products, and for more relevant ads. You can remove them any time. Learn more");
		lp.driver.findElement(By.xpath("(//span[text()='Cancel'])[1]")).click();

//Data 2 -
		
		Thread.sleep(3000);
		lp.driver.findElement(By.xpath("//a[@aria-label='Add recovery phone']")).click();
		//Enter Phone from data table
		lp.driver.findElement(By.xpath("//input[@aria-label='Your recovery phone']")).sendKeys(data.get(1).get(0));
		lp.driver.findElement(By.xpath("(//span[text()='Cancel'])[1]")).click();
		Thread.sleep(3000);
		lp.driver.findElement(By.xpath("(//div[@aria-label='Back'])[1]")).click();
		lp.driver.findElement(By.xpath("//a[@aria-label='Set home address']")).click();
		//Enter Address from data table
		lp.driver.findElement(By.xpath("//input[@aria-label='Address input field']")).sendKeys(data.get(1).get(1));
		Thread.sleep(3000);
		List<WebElement> list2 = lp.driver.findElements(By.xpath("//ul[@aria-label='Address input field']/li"));
		for(int i=0 ; i<list2.size(); i++) {
		System.out.println(list2.get(i).getText());
			
		}
		lp.driver.findElement(By.xpath("//ul[@aria-label='Address input field']/li[2]")).click();
		lp.driver.findElement(By.xpath("(//span[text()='Cancel'])[1]")).click();

//Data 3 -
		Thread.sleep(3000);
	    lp.driver.findElement(By.xpath("//a[@aria-label='Add recovery phone']")).click();
		//Enter Phone from data table
	    lp.driver.findElement(By.xpath("//input[@aria-label='Your recovery phone']")).sendKeys(data.get(2).get(0));
		lp.driver.findElement(By.xpath("(//span[text()='Cancel'])[1]")).click();
		Thread.sleep(3000);
		lp.driver.findElement(By.xpath("(//div[@aria-label='Back'])[1]")).click();
		lp.driver.findElement(By.xpath("//a[@aria-label='Set home address']")).click();
		//Enter Address from data table
		lp.driver.findElement(By.xpath("//input[@aria-label='Address input field']")).sendKeys(data.get(2).get(1));
		Thread.sleep(3000);
		List<WebElement> list3 = lp.driver.findElements(By.xpath("//ul[@aria-label='Address input field']/li"));
		for(int i=0 ; i<list3.size(); i++) {
	    System.out.println(list3.get(i).getText());
					
			}
		lp.driver.findElement(By.xpath("//ul[@aria-label='Address input field']/li[2]")).click();
		lp.driver.findElement(By.xpath("(//span[text()='Cancel'])[1]")).click();
			}
	
//HomeTest - Scenario 5 starts here	
	
	@Then("Add Recovery Details using Maps")
	public void AddRecoveryDetailsUsingMaps(DataTable RecoveryInputs) throws InterruptedException {
		
		for(Map<String, String> data : RecoveryInputs.asMaps(String.class , String.class)) {
		
		Thread.sleep(3000);
	    lp.driver.findElement(By.xpath("//a[@aria-label='Add recovery phone']")).click();
		//Enter Phone from data table
	    lp.driver.findElement(By.xpath("//input[@aria-label='Your recovery phone']")).sendKeys(data.get("Phone"));
		lp.driver.findElement(By.xpath("(//span[text()='Cancel'])[1]")).click();
		Thread.sleep(3000);
		lp.driver.findElement(By.xpath("(//div[@aria-label='Back'])[1]")).click();
		lp.driver.findElement(By.xpath("//a[@aria-label='Set home address']")).click();
		//Enter Address from data table
		lp.driver.findElement(By.xpath("//input[@aria-label='Address input field']")).sendKeys(data.get("Address"));
		Thread.sleep(3000);
		List<WebElement> list3 = lp.driver.findElements(By.xpath("//ul[@aria-label='Address input field']/li"));
		for(int i=0 ; i<list3.size(); i++) {
	    System.out.println(list3.get(i).getText());
					
			}
		lp.driver.findElement(By.xpath("//ul[@aria-label='Address input field']/li[2]")).click();
		lp.driver.findElement(By.xpath("(//span[text()='Cancel'])[1]")).click();
			
	}
	}
		
	

}
	
	
