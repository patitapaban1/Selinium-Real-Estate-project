package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RETC_049POM {
	private WebDriver driver; 
	
	public RETC_049POM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@id='menu-item-617']//a[contains(text(),'Blog')]")
	private WebElement blog; 
	
	@FindBy(xpath="//div[@id='post-5832']//a[@class='read-more'][contains(text(),'Read More')]")
	private WebElement readmore;
	
	@FindBy(xpath="//textarea[@id='comment']")
	private WebElement comment;
	
	@FindBy(xpath="//input[@id='author']")
	private WebElement name;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='submit']")
	private WebElement postcomment;
	
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement loginBtn; 
	
	
	@FindBy(xpath="//div[contains(text(),'Comments')]")
	private WebElement comments;
	
	@FindBy(xpath="//tr[@id='comment-1943']//a[@class='vim-r comment-inline'][contains(text(),'Reply')]")
	private WebElement reply;
	
	@FindBy(xpath="//textarea[@id='replycontent']")
	private WebElement replycomments;
	
	@FindBy(xpath=" //span[@id='replybtn']")
	private WebElement replybtn;
	
	
	public void clickBlogBtn() {
		this.blog.click(); 
	} 
	
	public void clickReadmore() {
		this.readmore.click(); 
	} 
	
	
	
	public void sendComment(String comment) {
		this.comment.clear();
		this.comment.sendKeys(comment);
	}
	
	public void sendName(String name) {
		this.name.clear();
		this.name.sendKeys(name);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void clickPostcomment() {
		this.postcomment.click(); 
	} 
	
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
	
	public void clickComments() {
		this.comments.click(); 
	}
	
	public void clickReply() {
		this.reply.click(); 
	}
	
	public void sendReplycomments(String replycomments) {
		this.replycomments.clear();
		this.replycomments.sendKeys(replycomments);
	}
	
	public void clickreplyBtn() {
		this.replybtn.click(); 
	}
}


