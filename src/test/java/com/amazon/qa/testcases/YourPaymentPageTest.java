package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LoginSecurityPage;
import com.amazon.qa.pages.SigninPage;
import com.amazon.qa.pages.Ssfp_Page;
import com.amazon.qa.pages.YourAccountPage;
import com.amazon.qa.pages.YourAddressPage;
import com.amazon.qa.pages.YourOrdersPage;
import com.amazon.qa.pages.YourPaymentPage;
import com.amazon.qa.util.TestUtilclass;

public class YourPaymentPageTest extends TestBase{
	
	SigninPage SignIn;
	YourAccountPage YourAccount;
	YourOrdersPage YourOrders;
	YourAddressPage YourAddress;
	YourPaymentPage YourPayment;
	Ssfp_Page SsfpPage;
	LoginSecurityPage LoginSecurity;
	String sheetName="paymentbook";
	
	public YourPaymentPageTest() {
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
		LoginSecurity=new LoginSecurityPage();
		YourPayment=new YourPaymentPage();	
		
		
		}
	
	@Test(priority=1)
	public void validatepagetitle() {
		YourPayment.clickOnYourPaymentModule();
	String actualTitle=YourPayment.validatpagetitle();
	Assert.assertEquals(actualTitle,"Your Payments" );
	}
	
	@DataProvider
	public Object[][] getPaymentTestData() {
		Object data[][]=TestUtilclass.getTestData(sheetName);
		return data;		
	}
	
	
	@Test(priority=2, dataProvider="getPaymentTestData")
	public void validatePaymentmoduletest(String cardnum, String name) throws InterruptedException {
    YourPayment.clickonpaymentmethods( cardnum, name);
}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
