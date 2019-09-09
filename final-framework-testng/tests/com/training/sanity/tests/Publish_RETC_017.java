package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import com.training.pom.Publish_RETC_017POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Publish_RETC_017 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Publish_RETC_017POM Publish_RETC_017POM;
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
		Publish_RETC_017POM = new Publish_RETC_017POM(driver);
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
	public void validPublishTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn();
				
		driver.manage().window().maximize();
		

		// code for mouse over in posts
		
		Actions actions=new Actions(driver);
		WebElement menuOption=driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		actions.moveToElement(menuOption).perform();
		//System.out.println("Done Mouse over on posts from menu");
		
		//code to click on Add New posts
		
		Publish_RETC_017POM.clickAddnewBtn();
		
		// code for launched the application by entering valid URL
		
		Publish_RETC_017POM.sendPosttitle("ram");
		Publish_RETC_017POM.sendContent("dam");
		Publish_RETC_017POM.clickPublishBtn();
		System.out.println("Publish button clicked");
		
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
		
		// code for Assert
		
		
		String message = driver.findElement(By.xpath("//p[contains(text(),'Post published.')]")).getText();
		Assert.assertTrue(message.contains("Post published"));
		System.out.println("The test case is passed");
		
		
		screenShot.captureScreenShot("Third");
	}
}
