package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.AddtocartPage;
import com.amazon.qa.pages.LoginSecurityPage;
import com.amazon.qa.pages.SigninPage;
import com.amazon.qa.pages.Ssfp_Page;
import com.amazon.qa.pages.YourAccountPage;
import com.amazon.qa.pages.YourAddressPage;
import com.amazon.qa.pages.YourOrdersPage;
import com.amazon.qa.pages.YourPaymentPage;

public class AddToCartPageTest extends TestBase {

	SigninPage SignIn;
	YourAccountPage YourAccount;
	YourOrdersPage YourOrders;
	YourAddressPage YourAddress;
	YourPaymentPage YourPayment;
	Ssfp_Page SsfpPage;
	LoginSecurityPage LoginSecurity;
	AddtocartPage Addtocart;
	String sheetName="paymentbook";
	
	public AddToCartPageTest () {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		SignIn=new SigninPage();
		YourAccount=SignIn.signin(prop.getProperty("Emailaddress"), prop.getProperty("Password"));
		
		SsfpPage=new Ssfp_Page();
		LoginSecurity=new LoginSecurityPage();
		YourPayment=new YourPaymentPage();	
		Addtocart=new AddtocartPage();
		YourOrders=new YourOrdersPage(); 
		}
	
	@Test(priority=1)
	public void validatepagetitle() {
	String actualTitle=Addtocart.validatepagetitle();
	Assert.assertEquals(actualTitle,"Amazon.ca Shopping Cart" );
	}
	
	@Test(priority=2)
	public void validateaddtocartTest() throws InterruptedException {
		Addtocart.addproducttocart(prop.getProperty("product"));
	
	}
	
	@Test(priority=3)
	public void validateincquantityfromcartTest() throws InterruptedException {
		Addtocart.incquantityfromcart(prop.getProperty("product"));	
	}
	
	@Test(priority=4)
	public void validateaddSameItemultipletimesTest() throws InterruptedException {
		Addtocart.addSameItemultipletimes(prop.getProperty("product"));	
	}
	
	@Test(priority=5)
	public void validateaddDiffItemultipleitimesTest() throws InterruptedException {
		Addtocart.addDiffItemMultipletimes(prop.getProperty("product"));	
	}
	
	@Test(priority=6)
	public void validateremoveSomeItemFromCartTest() throws InterruptedException {
		Addtocart.removeSomeItemFromCart(prop.getProperty("product"));	
	}
	
	@Test(priority=7)
	public void validateremoveAllItemFromCartTest() throws InterruptedException {
		Addtocart.removeAllItemFromCart(prop.getProperty("product"));	
	}
	
	@Test(priority=8)
	public void validateclickOnAnItemInCartTest() throws InterruptedException {
		Addtocart.clickOnAnItemInCart(prop.getProperty("product"));	
	}
	
	@Test(priority=9)
	public void validateclosebrowserandgetbackTest() throws InterruptedException {
		Addtocart.closebrowserandgetback(prop.getProperty("product"));	
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
