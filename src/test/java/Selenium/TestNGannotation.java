package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.*;
import org.testng.annotations.*;

public class TestNGannotation {

	WebDriver driver;
	
	@BeforeTest
	public void setBaseURL() throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test(priority = 1)
	public void urlCheck() {
		String ExpectedURL = "https://www.saucedemo.com/";
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL, "URL Doesn't Matched");
	}
	
	@Test(priority = 2)
	public void titleCheck() {
		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle, "Title Doesn't Matched");
	}
	
	@Test(priority = 3)
	public void loggingIn() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}
	
	@Test(priority = 4)
	public void addRemoveCart() {
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();
	}
	
	@Test(priority = 5)
	public void openCart() {
		driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click(); 
		driver.findElement(By.cssSelector("#shopping_cart_container > a > span")).click();
	}
	
	@Test(priority = 6)
	public void checkOut() {
		driver.findElement(By.className("checkout_button")).click();
	}
	
	@Test(priority = 7)
	public void orderInfo() {
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys("Rubaiyat E");
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys("Mohammad");
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input")).sendKeys("1230");
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input")).click();
	}
	
	@Test(priority = 8)
	public void finishToHome() {
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[2]")).click();
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/button")).click();
	}
	
	@AfterTest
	public void endSession() {
		driver.close();
	}

}
