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
import com.training.pom.AddNewTag_RETC_020POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddNewTag_RETC_020 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddNewTag_RETC_020POM AddNewTag_RETC_020POM;
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
		AddNewTag_RETC_020POM = new AddNewTag_RETC_020POM(driver);
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
	public void validAddnewTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@123");
		loginPOM.clickLoginBtn();
		
				
		driver.manage().window().maximize();
		

		// code for mouse over in posts
		
		Actions actions=new Actions(driver);
		WebElement menuOption=driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse over on posts from menu");
		
		//code to click on Tags posts
		
		AddNewTag_RETC_020POM.clickTagsBtn();
		
		// code for application allows admin to add new tag
		
		AddNewTag_RETC_020POM.sendTagName("ram");
		AddNewTag_RETC_020POM.sendTagslugName("dam");
		AddNewTag_RETC_020POM.sendTagdescriptionName("madhu");
		AddNewTag_RETC_020POM.clickSubmitBtn();
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		// code for Assert
	
		
		String message = driver.findElement(By.xpath("//div[@class='tablenav top']//span[@class='displaying-num'][contains(text(),'6 items')]")).getText();
		Assert.assertTrue(message.contains("7 items"));
		System.out.println("The test case is passed");
		
		screenShot.captureScreenShot("sixth");
	}
}
