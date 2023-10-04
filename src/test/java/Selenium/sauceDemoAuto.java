package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.*;

public class sauceDemoAuto {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.edgedriver().setup();//setting browser
		WebDriver driver = new EdgeDriver();//setting object
		
		
		driver.get("https://www.saucedemo.com/"); //accesing the url
		driver.manage().window().maximize(); //maximising the window
//		driver.navigate().refresh(); //refreshing window
		
//		driver.navigate().to("https://www.saucedemo.com/");//accesing the URL
//		driver.navigate().forward();//next page
//		driver.navigate().back();//previous page
		
		Thread.sleep(3000);
//		driver.manage().wait(5000);
		
		//URL Checking
		String ExpectedURL = "https://www.saucedemo.com/";
		String ActualURL = driver.getCurrentUrl();
//		if(ActualURL.equals(ExpectedURL)){
//			System.out.println("URL Matched");
//		}else {
//			System.out.println("URL Doesn't Matched");
//		}
		Assert.assertEquals(ActualURL, ExpectedURL, "URL Doesn't Matched");
		
		
		
		//Title Checking
		String ExpectedTitle = "Swag Labs";
		String ActualTitle = driver.getTitle();
//		if(ActualTitle.equals(ExpectedTitle)){
//			System.out.println("Title Matched");
//		}else {
//			System.out.println("Title Doesn't Matched");
//		}
		Assert.assertEquals(ActualTitle, ExpectedTitle, "Title Doesn't Matched");
		
		
		//logging in
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//xpath
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();//adding_to_cart
		driver.findElement(By.xpath("//button[@id='remove-sauce-labs-backpack']")).click();//removing_from_cart
		
		//css Selector
		driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();//adding_to_cart 
		
		//driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();//opening cart
		driver.findElement(By.cssSelector("#shopping_cart_container > a > span")).click();//opening cart
		
		//checkout
		driver.findElement(By.className("checkout_button")).click();
		
		//checkout info
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys("Rubaiyat E");//first_name
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys("Mohammad");//last_name
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input")).sendKeys("1230");//zip_code
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[2]/input")).click();//continue_button
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[9]/button[2]")).click();//finish_button
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/button")).click();//go_home_button
		
		Thread.sleep(5000);
		driver.close();//closing browser
//		driver.quit();//quiting browser
		
		

	}

}
