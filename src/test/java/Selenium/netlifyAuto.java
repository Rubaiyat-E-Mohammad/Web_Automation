package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import org.testng.annotations.*;

public class netlifyAuto {

	WebDriver driver;
	
	@BeforeTest
	public void setBaseURL() throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://trytestingthis.netlify.app/");
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void urlCheck() {
		String ExpectedURL = "https://trytestingthis.netlify.app/";
		String ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL, "URL Doesn't Matched");
	}
	
	@Test(priority = 2)
	public void titleCheck() {
		String ExpectedTitle = "Try Testing This";
		String ActualTitle = driver.getTitle();
		Assert.assertEquals(ActualTitle, ExpectedTitle, "Title Doesn't Matched");
	}
	
	@Test(priority=3)
	public void alertButton() {
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/button")).click();
		driver.switchTo().alert().accept();
	}
	
	@Test(priority=4)
	public void doubleClickMe() {
		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(By.xpath("/html/body/div[3]/div[1]/button"))).perform();
	}
	
	@Test(priority=5)
	public void dragAndDrop() {
		WebElement from = driver.findElement(By.xpath("/html/body/div[3]/div[1]/img"));
		WebElement to = driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[4]"));
		Actions act = new Actions(driver);
		Action dnd = act.clickAndHold(from).moveToElement(to).release(to).build();
		//dnd.perform();
	}
	
	@Test(priority=6)
	public void loggingin() {
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/fieldset/form/div/input[1]")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/fieldset/form/div/input[2]")).sendKeys("test");
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/fieldset/form/div/input[3]")).click();
	}
	
	@Test(priority=7)
	public void backToHome() {
		driver.findElement(By.xpath("/html/body/div[3]/h4/a")).click();
	}
	
	@Test(priority=8)
	public void contactAndHome() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[2]/a[2]")).click();
	}
	
	@Test(priority=9)
	public void name() {
		driver.findElement(By.id("fname")).sendKeys("Rubaiyat E");
		driver.findElement(By.id("lname")).sendKeys("Mohammad");
	}
	
	@Test(priority=10)
	public void radioButton() {
		WebElement radioButton = driver.findElement(By.id("male"));
		radioButton.click();
		assert radioButton.isSelected();
		System.out.println(radioButton.isSelected());
		System.out.println(radioButton.isEnabled());
	}
	
	@Test(priority=11)
	public void dropDown() {
		WebElement testDropDown = driver.findElement(By.id("option"));
		Select dropDown = new Select(testDropDown);
		dropDown.selectByIndex(2);
		//dropDown.selectByValue("option 1");
		//dropDown.selectByVisibleText("Option 3");
		driver.findElement(By.cssSelector("input[name=option3]")).click();
		driver.findElement(By.cssSelector("input[list=datalists]")).sendKeys("Mint");
	}
	
	
	//@AfterTest
	public void endSession() {
		driver.close();
	}

}
