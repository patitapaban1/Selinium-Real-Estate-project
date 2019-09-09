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
import com.training.pom.Trash_RETC_016POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Trash_RETC_016 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Trash_RETC_016POM Trash_RETC_016POM;
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
		Trash_RETC_016POM = new Trash_RETC_016POM(driver);
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
	public void validTrashTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn();
				
		driver.manage().window().maximize();
		

		// code for mouse over in posts
		
		Actions actions=new Actions(driver);
		WebElement menuOption=driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse over on posts from menu");
		
		//code to click on All posts
		
		Trash_RETC_016POM.clickAllpostsBtn();
		
		// code on mouse over to particular post
		
		Actions actions1=new Actions(driver);
		WebElement menuOption1=driver.findElement(By.xpath("//tr[@id='post-5595']//a[@class='row-title'][contains(text(),'ram')]"));
		actions1.moveToElement(menuOption1).perform();
		System.out.println("Done Mouse over on 'particular posts' from menu");
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		// Code on click on Trash link
		
		Trash_RETC_016POM.clickSubmitTrashBtn();
		System.out.println("The selected item moved to trash");
		
		// code for Assert
		
		
		String message = driver.findElement(By.xpath("//div[@id='message']")).getText();
		Assert.assertTrue(message.contains("1 post moved to the Trash"));
		System.out.println("The test case is passed");
		
		screenShot.captureScreenShot("Second");
	}
		
	}



