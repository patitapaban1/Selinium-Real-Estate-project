package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Apply_RETC_019POM {
	private WebDriver driver; 
	
	public Apply_RETC_019POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//li[@id='menu-posts']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Categories')]")
	private WebElement categoriesBtn;  
	
	@FindBy(xpath="//select[@id='bulk-action-selector-top']//option[contains(text(),'Delete')]")
	private WebElement deleteBtn;  
	
	@FindBy(xpath="//input[@id='doaction']")
	private WebElement applyBtn; 
	
	
	
	 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickCategoriesBtn() {
		this.categoriesBtn.click();
	}
	
	public void clickDeleteBtn() {
		this.deleteBtn.click();
	}
	
	public void clickApplyBtn() {
		this.applyBtn.click();
	}
}

