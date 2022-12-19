package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class YourAddressPage extends TestBase {
	
	//PageFactory--ObjectRepo--
	
	//AddressForm
	@FindBy(xpath="//div[@class='a-column a-span9 a-span-last']//h2[contains(text(),'Your Addresses')]") WebElement YourAddressesModule;	
	@FindBy(xpath="//h2[@class='a-color-tertiary' and text()='Add Address']") WebElement AddAddress_PlusButton;
	@FindBy(xpath="//span[@class='a-button-text a-declarative']//span[@class='a-dropdown-prompt' and text()='Canada']") WebElement AutoSelectCountry;	
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressFullName']") WebElement Address_FullName;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']") WebElement Address_phonenumber;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine1']") WebElement Address_Line1;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine2']") WebElement Address_Line2;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressCity']") WebElement Address_City;   
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']") WebElement Address_PostalCode;  
    @FindBy(xpath="//input[@id='address-ui-widgets-use-as-my-default'and @type='checkbox']") WebElement DefaultAddress_Checkbox;
    
    //Optional Delivery for weekend
    @FindBy(xpath="//span[contains(text(),'Add preferences, notes, access codes and more')]") WebElement DeliveryPreference_Option;
    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[5]/div[2]/a/span/div/div[1]/span") WebElement AddressOpenForDelivery_ToggleOption;
    @FindBy(xpath="//input[@id='business_hours_open_weekend_delivery-instructions-cdpViewId_OTHER']") WebElement Open24hrs_Checkbox;
    @FindBy(xpath="//input[@id='business_hours_closed_weekend_delivery-instructions-cdpViewId_OTHER']") WebElement Closedfordeliveries_Checkbox;
    
    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[5]/div[3]/a") WebElement ToEnterBuilding_ToggleOption;
    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[5]/div[3]/div/div[2]/span/input") WebElement SecurityCode_field;

    @FindBy(xpath="/html/body/div[1]/div[2]/div/div[2]/form/span/div/div[4]/div/div/div/div/div/div[1]/div[5]/div[3]/div/div[3]/div[2]/span/input") WebElement CallBox_field;
    @FindBy(xpath="//span[contains(text(),'Add address')]//preceding-sibling::input[@class='a-button-input' and @type='submit']") WebElement AddAddress_Button;
    @FindBy(xpath="//input[@id='address-ui-widgets-original-address-block_id-input' and @type='radio']") WebElement OriginalAddress_RadioButton;
    @FindBy(xpath="//span[contains(text(),'Save Address')]//preceding-sibling::input[@class='a-button-input' and @type='submit']") WebElement SaveAddress_Button;
	//initializing page objects
	
	public YourAddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions  
	public String validatpagetitle() {
		return driver.getTitle();
	}
	
	public Ssfp_Page clickOnYourAddressModule() {
		YourAddressesModule.click();
		return new Ssfp_Page();

	}
	
	
	public Ssfp_Page clickonAddAddress_PlusButton() {
		AddAddress_PlusButton.click();
		return new Ssfp_Page();

	}
	public Ssfp_Page  validatecountryname() {
		AutoSelectCountry.isDisplayed();
		return new Ssfp_Page();

	}
	public Ssfp_Page typeAddress_FullName(String fullname) {
		Address_FullName.sendKeys(fullname);
		return new Ssfp_Page();

	}
	public Ssfp_Page typeAddress_phonenumber(String phonenum) {
		Address_phonenumber.sendKeys(phonenum);
		return new Ssfp_Page();

	}
	public Ssfp_Page typeAddress_Line1(String firstline) {
		Address_Line1.sendKeys(firstline);
		return new Ssfp_Page();

	}
	public Ssfp_Page typeAddress_Line2(String secondline) {
		Address_Line1.sendKeys(secondline);
		return new Ssfp_Page();

	}
	public Ssfp_Page typeAddress_City(String city) {
		Address_City.sendKeys(city);
		return new Ssfp_Page();

	}
	
	public Ssfp_Page selectprovince(String province) {
		Select obj=new Select(driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']//span[@class='a-dropdown-prompt' and text()='Select']")));
		obj.selectByValue("Ontario");
		return new Ssfp_Page();

	}	
	public Ssfp_Page typeAddress_PostalCode(String zip) {
		Address_PostalCode.sendKeys(zip);
		return new Ssfp_Page();

	}
	
	public Ssfp_Page typefulladress(String fullname, String phonenum, String firstline, String secondline, String city, String zip ) throws InterruptedException {
		YourAddressesModule.click();
		AddAddress_PlusButton.click();
		AutoSelectCountry.isDisplayed();
		Address_FullName.sendKeys(fullname);
		Address_phonenumber.sendKeys(phonenum);
		Address_Line1.sendKeys(secondline);
		Address_City.sendKeys(city);	
		Thread.sleep(6000);
		Select obj=new Select(driver.findElement(By.xpath("//select[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId']")));
		obj.selectByValue("Ontario");
		Thread.sleep(4000);

		Address_PostalCode.sendKeys(zip);
		DefaultAddress_Checkbox.click();
		DeliveryPreference_Option.click();
		Thread.sleep(2000);
		AddressOpenForDelivery_ToggleOption.click();
		Thread.sleep(2000);

		Select Start_at_time=new Select(driver.findElement(By.id("business_hours_start_weekend_delivery-instructions-cdpViewId_OTHER")));
		Start_at_time.selectByValue("7:00");
		Thread.sleep(2000);

		Select Stop_at_time=new Select(driver.findElement(By.id("business_hours_stop_weekend_delivery-instructions-cdpViewId_OTHER")));
		Stop_at_time.selectByValue("9:00");
//		Open24hrs_Checkbox.click();
//		Closedfordeliveries_Checkbox.click();
		ToEnterBuilding_ToggleOption.click();
		SecurityCode_field.sendKeys("123");
		CallBox_field.sendKeys("manisha");
		AddAddress_Button.click();
		OriginalAddress_RadioButton.click();	
		SaveAddress_Button.click();
//		clickOnSWebElement(SaveAddress_Button);
		return new Ssfp_Page();
			}


	






}
