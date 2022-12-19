package com.amazon.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.SigninPage;
import com.amazon.qa.pages.Ssfp_Page;
import com.amazon.qa.pages.YourAccountPage;
import com.amazon.qa.pages.YourAddressPage;
import com.amazon.qa.pages.YourOrdersPage;

public class YourOrdersPageTest extends TestBase {
	SigninPage SignIn;
	YourAccountPage YourAccount;
	YourOrdersPage YourOrders;
	YourAddressPage YourAddress;
	Ssfp_Page SsfpPage;
	
	public YourOrdersPageTest() {
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
	}
	
	@Test(priority=1)
	public void validateorderhistory_30daysdropdown() {
        YourOrders.clickonlast30daysdropdown();
	}
	
	@Test(priority=2)
	public void validateorderhistory_3monthsdropdown() throws InterruptedException {
  
		SsfpPage=YourOrders.clickonlast3monthsdropdown();
			Thread.sleep(2000);

	}
	
	@Test(priority=3)
	public void validateorderhistory_2022dropdown() throws InterruptedException {
			YourAddress=YourOrders.clickonyear2022dropdown();
			Thread.sleep(2000);

	}
	
	@Test(priority=4)
	public void validateorderhistory_archiveddropdown() throws InterruptedException {
			YourAddress=YourOrders.clickonarchiveddropdown();
			Thread.sleep(2000);

	}
	@Test(priority=5)
	public void validateorder_buyagain() throws InterruptedException {
			YourAddress=YourOrders.clickonBuyAgain_option();
			Thread.sleep(2000);

	}
	@Test(priority=6)
	public void validateorder_notyetshipped() throws InterruptedException {
			YourAddress=YourOrders.clickonCancelledOrders_option();
			Thread.sleep(2000);

	}
	@Test(priority=7)
	public void validateorderhistory_cancelledorder() throws InterruptedException {
			YourAddress=YourOrders.clickonNotYetShipped_option();
			Thread.sleep(2000);
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
