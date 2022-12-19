package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtilclass;

public class YourPaymentPage extends TestBase{
	TestUtilclass Testutil;

	
	
	@FindBy(xpath="//h2[contains(text(),'Your Payments')]") WebElement YourPaymentModule;
	@FindBy(css=".a-button-input") WebElement AddaPaymentMethod_Button;

	@FindBy(xpath="//span[@class='a-button-inner']//input[@class='a-button-input' and @type='submit']") WebElement AddCrediOrDebitCard_Button;

	@FindBy(xpath="//input[@name='addCreditCardNumber']") WebElement CardNumber_Option;

	@FindBy(xpath="//input[@name='ppw-accountHolderName']") WebElement NameOfAccountHolder_Option;

	@FindBy(xpath="//select[@name='ppw-expirationDate_month']") WebElement MonthOfExp_DropDown;
	@FindBy(xpath="//select[@name='ppw-expirationDate_year']") WebElement YearOfExp_DropDown;
//	@FindBy(xpath="//input[@id='pp-2c3zHR-25']") WebElement SecurityCode_Option;

	@FindBy(xpath="//input[@name='ppw-widgetEvent:AddCreditCardEvent']") WebElement AddYourCard_Option;
	
	
	//initializing page objects
	
		public YourPaymentPage() {
			PageFactory.initElements(driver, this);
		}
		public String validatpagetitle() {
			return driver.getTitle();
		}
		
		public void clickOnYourPaymentModule() {
			YourPaymentModule.click();
		}
		public void clickOnAddPaymentButton() {
			AddaPaymentMethod_Button.click();
		}
		public void clickOnAddCreditOrDebitCard() {
			AddCrediOrDebitCard_Button.click();
		}
		

		
		
		
//Actions:

		public LoginSecurityPage clickonpaymentmethods(String cardnum, String name) throws InterruptedException {
			YourPaymentModule.click();
			Thread.sleep(2000);
			AddaPaymentMethod_Button.click();
			Thread.sleep(2000);

			AddCrediOrDebitCard_Button.click();
			Thread.sleep(2000);

			driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[2]/div/div/div[2]/div[3]/div/div[2]/div/iframe")));
			Thread.sleep(2000);
			
//			driver.switchTo().frame("ApxSecureIframe-pp-DN6Nly-5");
//			Thread.sleep(2000);
//
//			driver.findElement(By.name("addCreditCardNumber")).sendKeys(cardnum);
//			Thread.sleep(2000);
//
//			driver.findElement(By.name("ppw-accountHolderName")).sendKeys(name);
//			Thread.sleep(2000);
			
			
			CardNumber_Option.sendKeys(cardnum);
			NameOfAccountHolder_Option.sendKeys(name);

			Select monthofexpiration=new Select(MonthOfExp_DropDown);
			monthofexpiration.selectByValue("5");
			Thread.sleep(2000);

			Select yearofexpiration=new Select(YearOfExp_DropDown);
			yearofexpiration.selectByValue("2024");
			Thread.sleep(2000);
			Thread.sleep(2000);

			AddYourCard_Option.click();	
			Thread.sleep(2000);
			return new LoginSecurityPage();
			

		}



}
