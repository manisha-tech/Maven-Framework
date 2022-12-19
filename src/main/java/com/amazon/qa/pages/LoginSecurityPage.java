package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;

public class LoginSecurityPage extends TestBase {
	@FindBy(xpath="//h2[contains(text(),'Login & security')]") WebElement LoginandSecurityModule;
	
	@FindBy(xpath="//input[@id='auth-cnep-edit-name-button' and @type='submit']") WebElement EditName_Button;
	@FindBy(xpath="//input[@id='ap_customer_name' and @name='customerName']") WebElement EditName_Field;
	@FindBy(xpath="//input[@id='cnep_1C_submit_button' and @type='submit']") WebElement Save_Button;
	
//	
//	@FindBy(xpath="//input[@id='auth-cnep-edit-email-button' and @type='submit']") WebElement EditEmail_Button;
//	@FindBy(xpath="//input[@class='a-input-text a-span12 cvf-widget-input' and @type='text']") WebElement EditEmail_Field;
//	@FindBy(css=".a-button-input") WebElement Email_Continue_Button;
//
//
//	@FindBy(xpath="//input[@id='auth-cnep-add-phone-button' and @type='submit']") WebElement AddPhoneNum_Button;
//	@FindBy(xpath="//input[@id='ap_phone_number' and @name='newMobilePhoneNumber']") WebElement NewPhoneNum_Field;
//	@FindBy(xpath="//input[@id='auth-continue' and @name='addMobilePhone']") WebElement Phone_Continue_Button;
//	@FindBy(xpath="//a[@id='auth-change-phone-cancel' and @name='returnToButton']") WebElement Phone_cancel_Button;
	

	@FindBy(xpath="//input[@id='auth-cnep-edit-password-button' and @type='submit']") WebElement EditPassword_Button;
	@FindBy(xpath="//input[@id='ap_password' and @name='password']") WebElement Current_Password_Field;
	@FindBy(xpath="//input[@id='ap_password_new' and @name='passwordNew']") WebElement New_Password_Field;
	@FindBy(xpath="//input[@id='ap_password_new_check' and @name='passwordNewCheck']") WebElement ReEnter_Password_Field;
	@FindBy(xpath="//input[@id='cnep_1D_submit_button']") WebElement Save_Changes_Button;



	//initializing page objects	
	public LoginSecurityPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatepagetitle() {
		LoginandSecurityModule.click();
		return driver.getTitle();
	}


	public void NameEditField(String firstname, String lastname){
		LoginandSecurityModule.click();
		EditName_Button.click();
		EditName_Field.sendKeys(firstname, lastname);
		Save_Button.click();
		}
	
	public void PasswordEditField(){
		LoginandSecurityModule.click();
		EditPassword_Button.click();
		Current_Password_Field.sendKeys("amazonproject");
		New_Password_Field.sendKeys("aproject");
		ReEnter_Password_Field.sendKeys("aproject");
		Save_Changes_Button.click();
		}
	

	
	

}
