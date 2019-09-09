package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewTag_RETC_020POM {
	private WebDriver driver; 
	
	public AddNewTag_RETC_020POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//li[@id='menu-posts']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Tags')]")
	private WebElement tagsBtn; 
	
	@FindBy(id="tag-name")
	private WebElement tagName; 
	
	@FindBy(id="tag-slug")
	private WebElement tagslugName; 
	
	@FindBy(id="tag-description")
	private WebElement tagdescriptionName; 
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement submitBtn; 
	
			
	 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void sendTagName(String tagName) {
		this.tagName.clear(); 
		this.tagName.sendKeys(tagName); 
	}
	
	public void sendTagslugName(String tagslugName) {
		this.tagslugName.clear(); 
		this.tagslugName.sendKeys(tagslugName); 
	}
	
	public void sendTagdescriptionName(String tagdescriptionName) {
		this.tagdescriptionName.clear(); 
		this.tagdescriptionName.sendKeys(tagdescriptionName); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickTagsBtn() {
		this.tagsBtn.click();
	}
	
	public void clickSubmitBtn() {
		this.submitBtn.click();
	}
}

