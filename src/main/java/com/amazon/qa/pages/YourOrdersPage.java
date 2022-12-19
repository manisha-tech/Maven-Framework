package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class YourOrdersPage extends TestBase {
	
	@FindBy(xpath="//h2[contains(text(),'Your Orders')]") WebElement YourOrdersModule;	

	@FindBy(xpath="//select[@id='time-filter' and @name='orderFilter']") WebElement YourOrders_dropdown; 

	@FindBy(xpath="//a[@id='time-filter_1']") WebElement Past3months_dropdown;	 

	@FindBy(xpath="//a[@id='time-filter_2']") WebElement Year2022_dropdown ;	 

	@FindBy(xpath="//a[@id='time-filter_3']") WebElement ArchivedOrders_dropdown; 

	@FindBy(xpath="//ul[@role='tablist']//li[@class='page-tabs__tab']//a[@class='a-link-normal' and text()='Buy Again']")WebElement BuyAgain_option; 
	
	@FindBy(xpath="//ul[@role='tablist']//li[@class='page-tabs__tab']//a[@class='a-link-normal' and text()='Cancelled Orders']")WebElement CancelledOrders_option;  
	
	@FindBy(xpath="//ul[@role='tablist']//li[@class='page-tabs__tab']//a[@class='a-link-normal' and text()='Not Yet Shipped']")WebElement NotYetShipped_option;
	
	@FindBy(xpath="//h2[contains(text(),'Your Addresses')]") WebElement YourAddressesModule;	


	
	//initializing page objects	
	public YourOrdersPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatepagetitle() {
		return driver.getTitle();
	}
	public void clickonordersmodule() {
		YourOrdersModule.click();

	}

	public void clickonlast30daysdropdown(){
		YourOrdersModule.click();
		Select YourOrders_dropdownoption=new Select(YourOrders_dropdown);
		YourOrders_dropdownoption.selectByValue("last30");

		}
	public Ssfp_Page clickonlast3monthsdropdown(){
		YourOrdersModule.click();
		Select YourOrders_dropdown=new Select(driver.findElement(By.xpath("//span[@class='a-dropdown-container']//select[@id='time-filter' and @name='orderFilter']")));
		YourOrders_dropdown.selectByValue("months-3");
		return new Ssfp_Page();

	}
	public YourAddressPage clickonyear2022dropdown(){
		YourOrdersModule.click();
		Select YourOrders_dropdown=new Select(driver.findElement(By.xpath("//span[@class='a-dropdown-container']//select[@id='time-filter' and @name='orderFilter']")));
		YourOrders_dropdown.selectByValue("year-2022");
		return new YourAddressPage();

	}
	public YourAddressPage clickonarchiveddropdown(){
		YourOrdersModule.click();
		Select YourOrders_dropdown=new Select(driver.findElement(By.xpath("//span[@class='a-dropdown-container']//select[@id='time-filter' and @name='orderFilter']")));
		YourOrders_dropdown.selectByValue("archived");
		return new YourAddressPage();

	}
		
	public YourAddressPage clickonBuyAgain_option() {
		YourOrdersModule.click();
		BuyAgain_option.click();
		return new YourAddressPage();

	}

	public YourAddressPage clickonCancelledOrders_option() {
		YourOrdersModule.click();
		CancelledOrders_option.click();
		return new YourAddressPage();

	}
	
	public YourAddressPage clickonNotYetShipped_option() {
		YourOrdersModule.click();	
		NotYetShipped_option.click();
		return new YourAddressPage();
	}
	
	

	}
	
	


