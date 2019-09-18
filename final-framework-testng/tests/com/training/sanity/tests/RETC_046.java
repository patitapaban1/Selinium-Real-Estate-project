package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RETC_046POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_046 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_046POM RETC_046POM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		RETC_046POM = new RETC_046POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validPropertiesTest() throws InterruptedException    {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn();
				
		driver.manage().window().maximize();
		

		// code for mouse over in posts
		
		Actions actions=new Actions(driver);
		WebElement menuOption=driver.findElement(By.xpath("//div[contains(text(),'Properties')]"));
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse over on posts from menu");
		
		//code to click on Add New posts
		
		RETC_046POM.clickAddnewBtn();
		
		//Enter valid credentials in Enter Title Here textbox
		
		RETC_046POM.sendTitle("prestige");
					
		//Enter valid credentials in textbox
		
		RETC_046POM.sendContent("home town");
		
				
		//Click on checkbox beside added Feature of Features section
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='in-property_feature-416']"));
		checkBox.click();
		
		//Click on checkbox beside added Region of Regions section
		
		WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='in-region-429']"));
		checkBox1.click();
		System.out.println("Input value accepted");
		
				
		// code for scroll bar up
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-300)");
		
		//Click on Publish button
		
		
		Thread.sleep(5000);
		//WebDriverWait wait=new WebDriverWait(driver,3000);
		//WebElement publish=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='publish']")));
		//boolean checkpublish=driver.findElement(By.xpath("//input[@id='publish']")).isEnabled();
		//if(checkpublish==true){
		RETC_046POM.clickPublishBtn();
		
		
		
		//WebDriverWait wait=new WebDriverWait(driver,5000);
		//WebElement publish=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='publish']")));
		//publish.click();
				
		//RETC_046POM.clickPublishBtn();
		
		// code for Assert
	
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		String message = driver.findElement(By.xpath("//p[contains(text(),'Post published.')]")).getText();
		Assert.assertTrue(message.contains("Post published"));
		System.out.println("The test case is passed");
				
						
		screenShot.captureScreenShot("First");
	}
}
