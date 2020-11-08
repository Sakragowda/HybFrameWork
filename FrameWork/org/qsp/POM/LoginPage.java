package org.qsp.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(name = "username")
	private WebElement userName;
	@FindBy(name = "pwd")
	private WebElement password;
	@FindBy(id = "loginButton")
	private WebElement login;
	@FindBy(xpath = "//a[text()='Forgot your password")
	private WebElement forgotpassword;
    
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
//	public void Login_page(WebDriver driver) {
//		PageFactory.initElements(driver, this);
//	}
	public void sentusername(String user) {
		userName.sendKeys(user);
	}
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	public void loginClick() {
		login.click();
	}
	public void clickForgotPassword() {
		forgotpassword.click();
	}

}
