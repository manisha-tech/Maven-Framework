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

public class Ssfp_PageTest extends TestBase {
	
	SigninPage SignIn;
	YourAccountPage YourAccount;
	YourOrdersPage YourOrders;
	YourAddressPage YourAddress;
	YourPaymentPage YourPayment;
	Ssfp_Page SsfpPage;
	LoginSecurityPage LoginSecurity;
	AddtocartPage Addtocart;

	
	public Ssfp_PageTest() {
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
		
		
		}
	
	@Test(priority=1)
	public void validatepagetitle() {
	String actualTitle=SsfpPage.validatepagetitle();
	Assert.assertEquals(actualTitle,"Amazon.ca: Low Prices – Fast Shipping – Millions of Items" );
	}
	
	
	@Test(priority=2)
	public void validateproductinfoTest() throws InterruptedException {
	SsfpPage.productinfo(prop.getProperty("product"));
	}
	
	@Test(priority=3)
	public void validatesearchandaddtocartTest() throws InterruptedException {
	SsfpPage.searchandaddtocart(prop.getProperty("product"));
	}
	
	@Test(priority=4)
	public void validatesearchandsortbyhightolowTestTest() throws InterruptedException {
	SsfpPage.searchandsortbyhightolow(prop.getProperty("product"));
	}
	
	@Test(priority=5)
	public void validatesearchandsortbylowtohighTest() throws InterruptedException {
	SsfpPage.searchandsortbylowtohigh(prop.getProperty("product"));
	}
	
	@Test(priority=6)
	public void validatesearchandsortbyfeaturedTest() throws InterruptedException {
	SsfpPage.searchandsortbyfeatured(prop.getProperty("product"));
	}
	
	@Test(priority=7)
	public void validatesearchandsortbyavgcustomerreviewsTest() throws InterruptedException {
	SsfpPage.searchandsortbyavgcustomerreviews(prop.getProperty("product"));
	}
	
	@Test(priority=8)
	public void validatesearchandsortbynewestarrivalTest() throws InterruptedException {
	SsfpPage.searchandsortbynewestarrival(prop.getProperty("product"));
	}
	
	@Test(priority=9)
	public void validatesearchandfilter_PriceUnder$25Test() throws InterruptedException {
	SsfpPage.searchandfilter_PriceUnder$25(prop.getProperty("clothing"));
	}
	
	@Test(priority=10)
	public void validatesearchandfilter_Price$50to$100Test() throws InterruptedException {
	SsfpPage.searchandfilter_$50to$100(prop.getProperty("clothing"));
	}
	
	@Test(priority=11)
	public void validatesearchandfilter_Price$100to$200Test() throws InterruptedException {
	SsfpPage.searchandfilter_$100to$200(prop.getProperty("clothing"));
	}
	
	@Test(priority=12)
	public void validatesearchandfilter_Price$200andAboveTest() throws InterruptedException {
	SsfpPage.searchandfilter_$200andAbove(prop.getProperty("clothing"));
	}
	
	@Test(priority=13)
	public void validatesearchandfilter_byBrand_MichaelKorsTest() throws InterruptedException {
	SsfpPage.searchandfilter_byBrand_MichaelKors(prop.getProperty("product"));
	}
	@Test(priority=14)
	public void validatesearchandfilter_byBrand_AmazonCollectionTest() throws InterruptedException {
	SsfpPage.searchandfilter_byBrand_AmazonCollection(prop.getProperty("product"));
	}
	@Test(priority=15)
	public void validatesearchandfilter_byBrand_PavoiTest() throws InterruptedException {
	SsfpPage.searchandfilter_byBrand_Pavoi(prop.getProperty("product"));
	}
	@Test(priority=16)
	public void validatesearchandfilter_SwarovskiTest() throws InterruptedException {
	SsfpPage.searchandfilter_Swarovski(prop.getProperty("product"));
	}
	
	@Test(priority=17)
	public void validatesearchandfilter_bynewestarrivalTest() throws InterruptedException {
	SsfpPage.searchandfilter_bynewestarrival(prop.getProperty("product"));
	}
	
	@Test(priority=18)
	public void validatesearchandfilter_CustRating_4starsandupTest() throws InterruptedException {
	SsfpPage.searchandfilter_CustRating_4starsandup(prop.getProperty("product"));
	}
	
	@Test(priority=19)
	public void validatesearchandfilter_CustRating_3starsandupTest() throws InterruptedException {
	SsfpPage.searchandfilter_CustRating_3starsandup(prop.getProperty("product"));
	}
	
	@Test(priority=20)
	public void validatesearchandfilter_CustRating_2starsandupTest() throws InterruptedException {
	SsfpPage.searchandfilter_CustRating_2starsandup(prop.getProperty("product"));
	}
	
	@Test(priority=21)
	public void validatesearchandfilter_CustRating_1starandupTest() throws InterruptedException {
	SsfpPage.searchandfilter_CustRating_1starandup(prop.getProperty("product"));
	}
	
	
	@Test(priority=22)
	public void validatesearchandsortfunctioanlityTest() throws InterruptedException {
		Addtocart=SsfpPage.searchandsortfunctionality(prop.getProperty("clothing"));
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
