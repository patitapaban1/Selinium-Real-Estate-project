package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.Apply_RETC_019POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Apply_RETC_019 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Apply_RETC_019POM Apply_RETC_019POM;
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
		Apply_RETC_019POM = new Apply_RETC_019POM(driver);
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
	public void validApplyTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@12345");
		loginPOM.clickLoginBtn();
				
		driver.manage().window().maximize();
		

		// code for mouse over in posts
		
		Actions actions=new Actions(driver);
		WebElement menuOption=driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse over on posts from menu");
		
		//code to click on Categories posts
		
		Apply_RETC_019POM.clickCategoriesBtn();
		
		//code for check box  selected
		
		WebElement ocheckbox = driver.findElement(By.xpath("//input[@id='cb-select-505']"));
		ocheckbox.click();
		
		
		//code for click on Bulk Action list box
		
				
		Actions actions1=new Actions(driver);
		WebElement listOption=driver.findElement(By.xpath("//select[@id='bulk-action-selector-top']"));
		actions1.moveToElement(listOption).perform();
		
		// code for Select Delete in Bulk Action links
		
		Apply_RETC_019POM.clickDeleteBtn();
		
		// code for Apply button
		
		Apply_RETC_019POM.clickApplyBtn();
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		// code for Assert
		
		
		String message = driver.findElement(By.xpath("//p[contains(text(),'Categories deleted.')]")).getText();
		Assert.assertTrue(message.contains("Categories deleted."));
		System.out.println("The test case is passed");
				
		
		
		screenShot.captureScreenShot("fifth");
	}
}
