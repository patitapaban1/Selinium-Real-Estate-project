package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_048POM {
	private WebDriver driver; 
	
	public RETC_048POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//li[@id='menu-posts-property']//ul[@class='wp-submenu wp-submenu-wrap']//li//a[contains(text(),'Add New')]")
	private WebElement addnewBtn; 
	
	@FindBy(xpath="//a[@id='region-add-toggle']")
	private WebElement addnewlnk;
	

	@FindBy(xpath="//input[@id='newregion']")
	private WebElement textvalue;
	
	@FindBy(xpath="//input[@id='region-add-submit']")
	private WebElement addnewregion; 
	
	@FindBy(id="title")
	private WebElement title; 
	
	@FindBy(id="content")
	private WebElement content; 
	
	@FindBy(xpath ="//input[@id='publish']")
	private WebElement publishBtn;
	
	
	
	 
	
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
	
	public void clickAddnewBtn() {
		this.addnewBtn.click(); 
	}
	public void clickAddnewLnk() {
		this.addnewlnk.click(); 
	}
	
	public void sendTextvalue(String textvalue) {
		this.textvalue.clear(); 
		this.textvalue.sendKeys(textvalue); 
	}
	
	public void clickaAdnewRegion() {
		this.addnewregion.click(); 
	}
	
	public void sendTitle(String title){
		this.title.clear(); 
		this.title.sendKeys(title); 
	}
	
	public void sendContent(String content) {
		this.content.clear(); 
		this.content.sendKeys(content); 
	}
	
	public void clickPublishBtn() {
		this.publishBtn.click(); 
	} 
	
	
	
}


