package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.AddtocartPage;
import com.amazon.qa.pages.GuestUserPage;
import com.amazon.qa.pages.LoginSecurityPage;
import com.amazon.qa.pages.SigninPage;
import com.amazon.qa.pages.Ssfp_Page;
import com.amazon.qa.pages.YourAccountPage;
import com.amazon.qa.pages.YourAddressPage;
import com.amazon.qa.pages.YourOrdersPage;
import com.amazon.qa.pages.YourPaymentPage;
import com.amazon.qa.util.TestUtilclass;

public class GuestUserPageTest extends TestBase {
	
	

	SigninPage SignIn;
	YourAccountPage YourAccount;
	YourOrdersPage YourOrders;
	YourAddressPage YourAddress;
	YourPaymentPage YourPayment;
	Ssfp_Page SsfpPage;
	LoginSecurityPage LoginSecurity;
	AddtocartPage Addtocart;
	GuestUserPage GuestUser;
	String sheetName= "addressbook";

	
	public GuestUserPageTest () {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();		
		SsfpPage=new Ssfp_Page();
		LoginSecurity=new LoginSecurityPage();
		YourPayment=new YourPaymentPage();	
		Addtocart=new AddtocartPage();
		YourOrders=new YourOrdersPage(); 
		GuestUser=new GuestUserPage();
		}
	
	
	@DataProvider
	public Object[][] getAddressTestDataforGuest() {
		Object data[][]=TestUtilclass.getTestData(sheetName);
		return data;		
	}
	
	@Test(dataProvider="getAddressTestDataforGuest")
	public void validateGuestCheckoutTest(String fullname, String phonenum, String firstline, String secondline, String city, String zip) throws InterruptedException {
		GuestUser.checkoutasguestuser(fullname, phonenum, firstline, secondline, city, zip);
		

	Thread.sleep(2000);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	

}
