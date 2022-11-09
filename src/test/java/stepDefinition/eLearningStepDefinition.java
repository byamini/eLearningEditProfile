package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class eLearningStepDefinition {
	
public static WebDriver driver;
public static WebElement firstName;
public static WebElement lastName;
	
	@Given("elearning website is launched")
	public void elearning_website_is_launched() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\003QHN744\\OneDrive\\Training\\Day3\\src\\test\\chromedriver.exe");
	    driver =new ChromeDriver();
	    driver.get("http://elearningm1.upskills.in/");	
	}
	    
	@When("signup button is visible")
	public void signup_button_is_visible() {
	   driver.findElement(By.xpath("//a[contains(text(),' Sign up! ')]")).isDisplayed();   
	}

	@Then("user clicked on signup")
	public void user_clicked_on_signup() {
		driver.findElement(By.xpath("//a[contains(text(),' Sign up! ')]")).click();
	}
	
	@Given("Registration page is loaded") 
	  public void registration_page_is_loaded() {
	  //this.driver=driver;
	  driver.findElement(By.xpath("//label[@for='firstname']")).isDisplayed();
	  }
	 

	@When("Fill all details in registration page")
	public void fill_all_details_in_registration_page() {
		firstName=driver.findElement(By.name("firstname"));
		firstName.sendKeys("Baratam");
	    lastName=driver.findElement(By.name("lastname"));
		lastName.sendKeys("Yamini");
		driver.findElement(By.name("email")).sendKeys("baratamyamini222@gmail.com");
		//update user name before executing the script
		driver.findElement(By.name("username")).sendKeys("byamini301");
		driver.findElement(By.name("pass1")).sendKeys("Yamini@123");
		driver.findElement(By.name("pass2")).sendKeys("Yamini@123");
	}

	@Then("click on register and check next button is visible")
	public void click_on_register_and_check_next_button_is_visible() {
	    driver.findElement(By.xpath("//button[@name='submit']")).click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//button[@name='next']")).isDisplayed();
	}
	
	@Then("click on next after successful registration")
	public void click_on_next_after_successful_registration() {
	   driver.findElement(By.xpath("//button[@name='next']")).click();
	   driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
	   driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

		@Given("user clicked on edit profile")
		public void user_clicked_on_edit_profile() {
			driver.findElement(By.xpath("//a[@class='btn btn-link btn-sm btn-block']")).click();
						
		}
		    

		@When("Fill all details")
		public void fill_all_details() {
			try {
			firstName.clear();
			firstName.sendKeys("testing");
			lastName.clear();
			lastName.sendKeys("edit");
		}
			catch (org.openqa.selenium.StaleElementReferenceException ex) 
			{
				driver.findElement(By.name("firstname")).clear();
				driver.findElement(By.name("firstname")).sendKeys("testing");
				driver.findElement(By.name("lastname")).clear();
				driver.findElement(By.name("lastname")).sendKeys("edit");
				
			}
		}

		@Then("save settings")
		public void save_settings() {
		    driver.findElement(By.xpath("//button[@name='apply_change']")).click();
		    driver.close();
		}


}
