package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.SigninPage;
import com.amazon.qa.pages.YourAccountPage;
import com.amazon.qa.pages.YourAddressPage;

public class YourAccountPageTest extends TestBase {
	SigninPage SignIn;
	YourAccountPage YourAccount;
	YourAddressPage YourAddress;
	public YourAccountPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		SignIn=new SigninPage();
		YourAccount=SignIn.signin(prop.getProperty("Emailaddress"), prop.getProperty("Password"));
		YourAddress=new YourAddressPage();
	}
	
	@Test(priority=1)
	public void verifyusernameTest() {
		YourAccount.verifyusername();
	}
	
	@Test(priority=2)
	public void validateuseraccount() throws InterruptedException  {
		YourAddress=YourAccount.youraccount();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
