package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class SigninPage extends TestBase {
	
	
	@FindBy(xpath="//a[@id='nav-link-accountList']") WebElement Hellosignin; 

	@FindBy(xpath="//input[@type='email' and @name='email'and @id='ap_email' and @class='a-input-text a-span12 auth-autofocus auth-required-field']") WebElement Emailaddress;	 

	@FindBy(xpath="//input[@type='submit'and @id='continue' and @class='a-button-input']") WebElement Continue;	 

	@FindBy(xpath="//input[@name='password'and @id='ap_password']")WebElement Password; 

	@FindBy(xpath="//input[@type='submit'and @id='signInSubmit']")WebElement Signinbutton;  
	@FindBy(xpath="//input[@name='rememberMe']") WebElement Checkbox;

	//initializing page objects
	
	public SigninPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatemainpagetitle() {
		return driver.getTitle();

	}
	
	public String validatesigninpagetitle() {
		return driver.getTitle();
	} 
	
	
	public YourAccountPage signin(String username, String pass)  {
		Hellosignin.click();
		Emailaddress.sendKeys(username);
		Continue.click();
		Password.sendKeys(pass);
		Checkbox.click();
		Signinbutton.click();	
		return new YourAccountPage();
	}


	

		

}
