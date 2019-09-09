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
import com.training.pom.AddNewCategory_RETC_018POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddNewCategory_RETC_018 {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private AddNewCategory_RETC_018POM AddNewCategory_RETC_018POM;
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
		AddNewCategory_RETC_018POM = new AddNewCategory_RETC_018POM(driver);
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
	public void validCategoryTest() {
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("adminuser@123");
		loginPOM.clickLoginBtn();
				
		driver.manage().window().maximize();
		

		// code for mouse over in posts
		
		Actions actions=new Actions(driver);
		WebElement menuOption=driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		actions.moveToElement(menuOption).perform();
		System.out.println("Done Mouse over on posts from menu");
		
		//code to click on Categories posts
		
		AddNewCategory_RETC_018POM.clickCategoriesBtn();
		
		
		// code for launched the application by entering valid URL
		
		AddNewCategory_RETC_018POM.sendCategoriesName("ram");
		AddNewCategory_RETC_018POM.sendCategoriesslugName("dam");
		AddNewCategory_RETC_018POM.sendCategoriesdescriptionName("madhu");
		AddNewCategory_RETC_018POM.clickSubmitBtn();
			
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	
		// code for Assert
		
		String message = driver.findElement(By.xpath("//div[@class='tablenav top']//span[@class='displaying-num'][contains(text(),'17 items')]")).getText();
		Assert.assertTrue(message.contains("18 items"));
		System.out.println("The test case is passed");
				
		screenShot.captureScreenShot("fourth");
	}

		
	}


