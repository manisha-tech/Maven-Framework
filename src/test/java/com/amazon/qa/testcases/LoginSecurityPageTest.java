package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LoginSecurityPage;
import com.amazon.qa.pages.SigninPage;
import com.amazon.qa.pages.Ssfp_Page;
import com.amazon.qa.pages.YourAccountPage;
import com.amazon.qa.pages.YourAddressPage;
import com.amazon.qa.pages.YourOrdersPage;

public class LoginSecurityPageTest extends TestBase{
	SigninPage SignIn;
	YourAccountPage YourAccount;
	YourOrdersPage YourOrders;
	YourAddressPage YourAddress;
	Ssfp_Page SsfpPage;
	LoginSecurityPage LoginandSecurity;
	
	public LoginSecurityPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		SignIn=new SigninPage();
		YourAccount=SignIn.signin(prop.getProperty("Emailaddress"), prop.getProperty("Password"));
		YourAccount=new YourAccountPage();
		YourAddress=YourAccount.youraccount();	
		YourOrders=new YourOrdersPage();
		LoginandSecurity=new LoginSecurityPage();
	}
	
	@Test(priority=1)
	public void validatePageTitle() {		
		String actualTitle=LoginandSecurity.validatepagetitle();
		Assert.assertEquals(actualTitle,"Amazon Change Name, E-mail, Password" );
	}
	
	@Test(priority=2)
	public void validateNameChangeTest()throws InterruptedException  {	
		LoginandSecurity.NameEditField(prop.getProperty("firstname"), prop.getProperty("lastname"));
	}
	
	@Test(priority=3)
	public void validatePasswordChangeTest() {	
		LoginandSecurity.PasswordEditField();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
