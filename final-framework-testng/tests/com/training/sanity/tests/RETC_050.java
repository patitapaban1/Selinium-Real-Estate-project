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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.RETC_050POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_050 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_050POM RETC_050POM;
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
		RETC_050POM = new RETC_050POM(driver);
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
	public void validPropertiesTest() throws InterruptedException {
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
		
		RETC_050POM.clickAddnewBtn();
		
		 //Enter valid credentials in Enter Title Here textbox
		
		RETC_050POM.sendTitle("prestige");
					
	//Enter valid credentials in textbox
		
		RETC_050POM.sendContent("home town");
		
	//Click on checkbox beside added Feature of Features section
		
		WebElement checkBox = driver.findElement(By.xpath("//input[@id='in-property_feature-426']"));
		checkBox.click();
		
				
	//Click on checkbox beside added Region of Regions section
		
		WebElement checkBox1 = driver.findElement(By.xpath("//input[@id='in-region-422']"));
		checkBox1.click();
		
		// code for scroll bar up
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-300)");
		
		//Click on Move to Trash link
		Thread.sleep(5000);
		RETC_050POM.clickMovetotrashBtn();
		
		// Click on Leave button
		
		driver.switchTo().alert().accept();	
		
		
		// code for Assert
		
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			String message = driver.findElement(By.xpath("//div[@id='message']")).getText();
			Assert.assertTrue(message.contains("1 post moved to the Trash"));
			System.out.println("The test case is passed");
		
		//code for Click on Trash icon
			RETC_050POM.clickTrashlnk();		
		
				
		screenShot.captureScreenShot("Fifth");
	}
}
