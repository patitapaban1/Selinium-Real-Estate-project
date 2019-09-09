package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCategory_RETC_018POM {
	private WebDriver driver; 
	
	public AddNewCategory_RETC_018POM(WebDriver driver) {
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
	
	@FindBy(xpath="//input[@id='tag-name']")
	private WebElement categoriesName; 
	
	@FindBy(xpath="//input[@id='tag-slug']")
	private WebElement categoriesslugName; 
	
	@FindBy(id="tag-description")
	private WebElement categoriesdescriptionName; 
	
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
	
	public void sendCategoriesName(String categoriesName) {
		this.categoriesName.clear(); 
		this.categoriesName.sendKeys(categoriesName); 
	}
	
	public void sendCategoriesslugName(String categoriesslugName) {
		this.categoriesslugName.clear(); 
		this.categoriesslugName.sendKeys(categoriesslugName); 
	}
	
	public void sendCategoriesdescriptionName(String categoriesdescriptionName) {
		this.categoriesdescriptionName.clear(); 
		this.categoriesdescriptionName.sendKeys(categoriesdescriptionName); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickCategoriesBtn() {
		this.categoriesBtn.click();
	}
	
	public void clickSubmitBtn() {
		this.submitBtn.click();
	}
	
}

