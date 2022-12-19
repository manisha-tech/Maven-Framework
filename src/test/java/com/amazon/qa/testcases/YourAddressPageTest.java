package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.SigninPage;
import com.amazon.qa.pages.Ssfp_Page;
import com.amazon.qa.pages.YourAccountPage;
import com.amazon.qa.pages.YourAddressPage;
import com.amazon.qa.pages.YourOrdersPage;
import com.amazon.qa.util.TestUtilclass;


public class YourAddressPageTest extends TestBase {
	
	SigninPage SignIn;
	YourAccountPage YourAccount;
	YourOrdersPage YourOrders;
	YourAddressPage YourAddress;
	Ssfp_Page SsfpPage;
	String sheetName= "addressbook";
	
	public YourAddressPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		SignIn=new SigninPage();
		YourAccount=SignIn.signin(prop.getProperty("Emailaddress"), prop.getProperty("Password"));		
		YourAccount=new YourAccountPage();
		YourAddress=YourAccount.youraccount();	
		SsfpPage=new Ssfp_Page();
		

}
		
	@Test(priority=1)
	public void validatepagetitle() {
	YourAddress.clickOnYourAddressModule();	
	String actualTitle=YourAddress.validatpagetitle();
	Assert.assertEquals(actualTitle,"Your Addresses" );
	}
	
	@DataProvider
	public Object[][] getAddressTestData() {
		Object data[][]=TestUtilclass.getTestData(sheetName);
		return data;		
	}
	
	@Test(priority=2, dataProvider="getAddressTestData")
	public void validateaddresspageTest(String fullname, String phonenum, String firstline, String secondline, String city, String zip) throws InterruptedException {
		SsfpPage=YourAddress.typefulladress(fullname, phonenum, firstline, secondline, city, zip);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
