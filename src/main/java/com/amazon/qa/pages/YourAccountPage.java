package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class YourAccountPage extends TestBase {
	
	
	//PageFactory--ObjectRepo--
	@FindBy(xpath="//div[@class='nav-line-1-container' ]//span[@id='nav-link-accountList-nav-line-1' and text()='Hello, Manisha']") WebElement HelloUser;
	@FindBy(xpath="//h2[contains(text(),'Your Orders')]") WebElement YourOrdersModule;	
	@FindBy(xpath="//div[@class='a-column a-span9 a-span-last']//h2[contains(text(),'Your Addresses')]") WebElement YourAddressesModule;	

	//initializing page objects
	
	public YourAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions  
	public String validatepagetitle() {
		return driver.getTitle();
	}
	
	public void verifyusername() {
		System.out.println( HelloUser.getText());
	}

	public YourAddressPage youraccount() {
		HelloUser.click();		
		return new YourAddressPage();
	}
	
	public Ssfp_Page youraccountfororders() {
		HelloUser.click();
		YourOrdersModule.click();
		return new Ssfp_Page();
		
	}

	
	

}
