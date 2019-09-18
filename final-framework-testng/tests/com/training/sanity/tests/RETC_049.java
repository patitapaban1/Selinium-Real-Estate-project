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
import com.training.pom.RETC_049POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_049 {

	private static final String priorty = null;
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RETC_049POM RETC_049POM;
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
		RETC_049POM = new RETC_049POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//driver.quit();
	}
	
	@Test(priority=1)
	public void validblogTest() {
	
		// code for click on Blog
		
		RETC_049POM.clickBlogBtn();
				
		// code for  Click on Read More link of post added by admin
		
		RETC_049POM.clickReadmore();
		
		RETC_049POM.sendComment("good");
		RETC_049POM.sendName("Bulu");
		RETC_049POM.sendEmail("bu@gmail.com");
		RETC_049POM.clickPostcomment();
		
		driver.manage().timeouts().implicitlyWait(600000, TimeUnit.MILLISECONDS);
	}
	
	@Test(priority=2)
	public void validPropertiesTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn();
				
		driver.manage().window().maximize();
		

			
		//code to click on Comments
		
		RETC_049POM.clickComments();
		
		// code for mouse over  mouse over the comment
		
		Actions actions=new Actions(driver);
		WebElement menuOption=driver.findElement(By.xpath("//div[contains(text(),'Comments')]"));
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse over the comment");
		
		// code for cClick on Reply icon
		
		RETC_049POM.clickReply();
		
		// code for enter valid details in comments textbox
		
		RETC_049POM.sendReplycomments("thanks");
		
		// code for Click on Approve and Reply button
		
		RETC_049POM.clickreplyBtn();
				
		// code for Assert
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		String message = driver.findElement(By.xpath("//a[contains(text(),'Approved')]")).getText();
		Assert.assertTrue(message.contains("Approved"));
		System.out.println("The test case is passed");
		
				
		screenShot.captureScreenShot("Fourth");
	}
}
