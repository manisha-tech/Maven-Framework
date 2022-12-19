package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.SigninPage;
import com.amazon.qa.pages.YourAccountPage;

public class SigninPageTest extends TestBase {
	SigninPage SignIn;
	YourAccountPage YourAccount;
	
	public SigninPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		SignIn=new SigninPage();
	}
	
	@Test(priority=1)
	public void validatepagetitle() throws InterruptedException {
	String actualTitle=SignIn.validatemainpagetitle();
	Assert.assertEquals(actualTitle,"Amazon.ca: Low Prices – Fast Shipping – Millions of Items" );
	Thread.sleep(2000);
	}
	
	@Test(priority=2)
	public void signinTest() throws InterruptedException {
		YourAccount=SignIn.signin(prop.getProperty("Emailaddress"), prop.getProperty("Password"));
	}

	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
