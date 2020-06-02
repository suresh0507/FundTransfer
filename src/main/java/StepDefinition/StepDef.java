package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
	
	
	public WebDriver driver;
	
	@Given("^Launch Browser and Get the Base URL$")
	public void launch_Browser_and_Get_the_Base_URL() {
		System.out.println("launch_Browser_and_Get_the_Base_URL()");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://elastic.rapidtestpro.com:8086/index");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("^User Inputs the username and password$")
	public void user_Inputs_the_username_and_password() throws InterruptedException {
		System.out.println("user_Inputs_the_username_and_password()");
		driver.findElement(By.xpath("//input@name='username']")).sendKeys("SureshS");
		driver.findElement(By.xpath("//input@name='password']")).sendKeys("abcde");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input@name='submit']")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("^User clicks on Login button$")
	public void user_clicks_on_Login_button() {
		System.out.println("user_clicks_on_Login_Button()");
		driver.findElement(By.xpath("//div[@class='login']//input@class='button']")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("^Able to Successfuly login$")
	public void able_to_Successfuly_login() {
		System.out.println("able_to_Successfuly_login()");
		String str = driver.findElement(By.xpath("//h1[@class='title']")).getText();
        Assert.assertEquals(str,"Sucessful login!");
        driver.quit();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Given("^the user is on Fund Transfer Page$")
	public void the_user_is_on_Fund_Transfer_Page() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='dropdown-toggle'])[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'To Someone Else')]")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("^he enters \"([^\"]*)\" as recipient name$")
	public void he_enters_name_as_recipient_name() {
		driver.findElement(By.id("payee")).sendKeys ("Test");
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("^he enters \"([^\"]*)\" as amount$")
	public void he_enters_amount_as_amount() {
		driver.findElement(By.id("amount")).sendKeys ("100");
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("^he Submits request for Fund Transfer$")
	public void he_Submits_request_for_Fund_Transfer() {
		driver.findElement(By.id("transfer")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("^ensure the fund transfer is complete with \"([^\"]*)\" message$")
	public void ensure_the_fund_transfer_is_complete_with_message(String string) {
		WebElement message = driver.findElement(By.id("message"));
		//assertEquals(message.getText(),msg);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	
	}


}
