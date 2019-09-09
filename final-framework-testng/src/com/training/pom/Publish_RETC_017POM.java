package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Publish_RETC_017POM {
	private WebDriver driver; 
	
	public Publish_RETC_017POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//li[@id='menu-posts']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement addnewBtn; 
	
	
	@FindBy(xpath="//div//div//input[@id='title']")
	private WebElement posttitle; 
	
	@FindBy(id="content")
	private WebElement content;
	
	@FindBy(xpath="//input[@id='publish']")
	private WebElement publishBtn; 
	
	 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void sendPosttitle(String posttitle) {
		this.posttitle.clear();
		this.posttitle.sendKeys(posttitle);
	}
	
	public void sendContent(String content) {
		this.content.clear(); 
		this.content.sendKeys(content); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickAddnewBtn() {
		this.addnewBtn.click();
	}
	
	public void clickPublishBtn() {
		this.publishBtn.click();
	}	
	
}

