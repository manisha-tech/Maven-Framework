package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class GuestUserPage extends TestBase {
	
	SigninPage SignIn;
	YourAccountPage YourAccount;
	YourAddressPage YourAddress;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	
	@FindBy(xpath="//a[@id='nav-cart']") WebElement CartModule;	
	@FindBy(xpath="//input[@id='twotabsearchtextbox' and @type='text']") WebElement Search_box;	
	@FindBy(xpath="//input[@id='nav-search-submit-button' and @type='submit']") WebElement Search_button;
	@FindBy(xpath="//*[@id=\"sw-gtc\"]/span/a") WebElement GoToCart;
	@FindBy(xpath="//input[@id='add-to-cart-button']")WebElement AddToCart;
	@FindBy(xpath=" //span[contains(text(),'Added to Cart')]") WebElement AddedToCart;
	@FindBy(xpath="//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap sc-product-price a-text-bold']")WebElement ProductValue;
	@FindBy(xpath="//span[@id='sc-subtotal-amount-activecart'] //span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap']") WebElement CartValue;
    @FindBy(xpath="//a[@id='deselect-all']") WebElement EmptyCart;
    @FindBy(xpath="//*[@id=\"sc-buy-box-ptc-button\"]/span/input") WebElement ProceedToCheckout_Button;
	@FindBy(xpath="//input[@type='email' and @name='email'and @id='ap_email' and @class='a-input-text a-span12 auth-autofocus auth-required-field']") WebElement Emailaddress;	 
	@FindBy(xpath="//input[@type='submit'and @id='continue' and @class='a-button-input']") WebElement Continue;	 
	@FindBy(xpath="//input[@name='password'and @id='ap_password']")WebElement Password; 
	@FindBy(xpath="//input[@type='submit'and @id='signInSubmit']")WebElement Signinbutton;    
	@FindBy(xpath="//span[@class='a-button-text a-declarative']//span[@class='a-dropdown-prompt' and text()='Canada']") WebElement AutoSelectCountry;	
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressFullName']") WebElement Address_FullName;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPhoneNumber']") WebElement Address_phonenumber;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine1']") WebElement Address_Line1;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressLine2']") WebElement Address_Line2;
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressCity']") WebElement Address_City;   
    @FindBy(xpath="//input[@id='address-ui-widgets-enterAddressPostalCode']") WebElement Address_PostalCode;  
    @FindBy(xpath="//input[@id='address-ui-widgets-use-as-my-default'and @type='checkbox']") WebElement DefaultAddress_Checkbox;  
    @FindBy(xpath="//span[contains(text(),'Add address')]//preceding-sibling::input[@class='a-button-input' and @type='submit']") WebElement AddAddress_Button;
    @FindBy(xpath="//input[@id='address-ui-widgets-original-address-block_id-input' and @type='radio']") WebElement OriginalAddress_RadioButton;
    @FindBy(xpath="//span[contains(text(),'Save Address')]//preceding-sibling::input[@class='a-button-input' and @type='submit']") WebElement SaveAddress_Button;  
    @FindBy(xpath="//*[@id=\"address-ui-widgets-form-submit-button\"]") WebElement UseThisAddress_Button;   
	@FindBy(xpath="//span[@class='a-button-inner']//input[@class='a-button-input' and @type='submit']") WebElement AddCrediOrDebitCard_Button;
	@FindBy(xpath="//input[@name='addCreditCardNumber']") WebElement CardNumber_Option;
	@FindBy(xpath="//input[@name='ppw-accountHolderName']") WebElement NameOfAccountHolder_Option;
	@FindBy(xpath="//select[@name='ppw-expirationDate_month']") WebElement MonthOfExp_DropDown;
	@FindBy(xpath="//select[@name='ppw-expirationDate_year']") WebElement YearOfExp_DropDown;

	@FindBy(xpath="//input[@name='ppw-widgetEvent:AddCreditCardEvent']") WebElement AddYourCard_Option;
	
	public GuestUserPage() {
		PageFactory.initElements(driver, this);
	}
	
    //Actions

	public String validatepagetitle() {
		return driver.getTitle();
	}
	
		
	public void checkoutasguestuser(String fullname, String phonenum, String firstline, String secondline, String city, String zip )throws InterruptedException {
		Search_box.sendKeys("earring");
		Search_button.click();
		Thread.sleep(4000);
	try {
			WebElement Element=driver.findElement(By.xpath("//h2//a//span[text()='14K Gold Plated 925 Sterling Silver Cubic Zirconia Hoop Earrings']"));
			js.executeScript("arguments[0].scrollIntoView();", Element);
			Element.click();
			Thread.sleep(4000);
			AddToCart.click();	
			Thread.sleep(4000);
			System.out.println( AddedToCart.getText());
			GoToCart.click();
			Thread.sleep(4000);
			ProceedToCheckout_Button.click();
			Thread.sleep(5000);
			
			Emailaddress.sendKeys("manisha_choudhary@hotmail.com");
			Continue.click();
			Password.sendKeys("aproject");
			Signinbutton.click();

	        Thread.sleep(6000);  
	        
    		AutoSelectCountry.isDisplayed();
    		Address_FullName.sendKeys(fullname);
    		Address_phonenumber.sendKeys(phonenum);
    		Address_Line1.sendKeys(secondline);
    		Address_City.sendKeys(city);			
    		Select obj=new Select(driver.findElement(By.xpath("//select[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId']")));
    		obj.selectByValue("Ontario");
    		Address_PostalCode.sendKeys(zip);
    		Thread.sleep(3000);
    		UseThisAddress_Button.click();
    		Thread.sleep(3000);

    		OriginalAddress_RadioButton.click();
    		Thread.sleep(3000);

    		SaveAddress_Button.click();
    		System.out.println("Successfully checked out as a guest customer");
    		Thread.sleep(3000);
    		driver.findElement(By.xpath("//*[@id=\"orderSummaryPrimaryActionBtn\"]/span/input")).click();

    		Thread.sleep(5000);

    		driver.findElement(By.xpath("//*[@id=\"pp-LNpA1H-57\"]")).click();
    		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[2]/div/div/div[2]/div[3]/div/div[2]/div/iframe")));
			Thread.sleep(2000);
			CardNumber_Option.sendKeys("5123456789012340");
			NameOfAccountHolder_Option.sendKeys("Bakey john");

			Select monthofexpiration=new Select(MonthOfExp_DropDown);
			monthofexpiration.selectByValue("5");
			Thread.sleep(2000);

			Select yearofexpiration=new Select(YearOfExp_DropDown);
			yearofexpiration.selectByValue("2024");
			Thread.sleep(2000);
			Thread.sleep(2000);

			AddYourCard_Option.click();	
			Thread.sleep(2000);
	}catch(Exception NoSuchElement) {System.out.println("Wasn't able to buy due to creditcard number. Message displayed as invalid credit card");	}

}}
