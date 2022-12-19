package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.qa.base.TestBase;

public class Ssfp_Page extends TestBase {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox' and @type='text']") WebElement Search_box;	
	@FindBy(xpath="//input[@id='nav-search-submit-button' and @type='submit']") WebElement Search_button;
	@FindBy(xpath="//select[@id='s-result-sort-select' and @name='s']") WebElement SortBy_DropDownMenu;
	
	
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[5]/ul[1]/li[1]/span/a/span") WebElement PriceUnder$25_Filter;
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[5]/ul[1]/li[2]/span/a/span") WebElement $25to$50_Filter; 
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[5]/ul[1]/li[3]/span/a/span") WebElement $50to$100_Filter; 
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[5]/ul[1]/li[4]/span/a/span") WebElement $100to$200_Filter; 
	@FindBy(xpath="/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[5]/ul[1]/li[5]/span/a/span") WebElement $200andAbove_Filter; 

	@FindBy(xpath="//parent::li[@id='p_89/Michael Kors']//i[@class='a-icon a-icon-checkbox']") WebElement MichaelKors_Filter; 
    @FindBy(xpath="//parent::li[@id='p_89/Amazon Collection']//i[@class='a-icon a-icon-checkbox']") WebElement AmazonCollection_Filter;
	@FindBy(xpath="//parent::li[@id='p_89/PAVOI']//i[@class='a-icon a-icon-checkbox']") WebElement Pavoi_Filter;
	@FindBy(xpath="//parent::li[@id='p_89/SWAROVSKI']//i[@class='a-icon a-icon-checkbox']") WebElement Swarovski_filter;
	
	@FindBy(xpath="/html/body/div[1]/header/div/div[4]/div[2]/div[2]/div/a[3]") WebElement BestSeller_Filter;
	@FindBy(xpath="//parent::a//span[text()='Last 30 days']") WebElement NewArrival_Filter;
	
	@FindBy(xpath="//parent::a//i[@class='a-icon a-icon-star-medium a-star-medium-4']") WebElement CustRating_4starsandup;
	@FindBy(xpath="//parent::a//i[@class='a-icon a-icon-star-medium a-star-medium-3']") WebElement CustRating_3starsandup;
	@FindBy(xpath="//parent::a//i[@class='a-icon a-icon-star-medium a-star-medium-2']") WebElement CustRating_2starsandup;
	@FindBy(xpath="//parent::a//i[@class='a-icon a-icon-star-medium a-star-medium-1']") WebElement CustRating_1starandup;



	//select[@id='s-result-sort-select' and @name='s']
	@FindBy(xpath="//select[@name='dropdown_selected_size_name']") WebElement Size_dropdown ;
	@FindBy(xpath="//input[@id='add-to-cart-button']")WebElement AddToCart;
	@FindBy(xpath="//*[@id=\"sw-gtc\"]/span/a") WebElement GoToCart;
	@FindBy(xpath=" //span[contains(text(),'Added to Cart')]") WebElement AddedToCart;

	
	//initializing page objects	
	public Ssfp_Page() {
		PageFactory.initElements(driver, this);
	}
	
    //Actions
	public String validatepagetitle() {
		return driver.getTitle();
	}

	
	//Methods
	public void productinfo(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(4000);
		try {
        	WebElement Element=driver.findElement(By.xpath("//span[text()='15 Pairs Black Earrings for Men Mens Earrings Stainless Steel Black Stud Earrings for Men Women Jewelry Piercing Hoop Men Earrings Set']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();          
            Thread.sleep(2000);
            System.out.println(driver.findElement(By.xpath("//h1//span[text()='        ONESING 15 Pairs Black Earrings for Men Mens Earrings Stainless Steel Black Stud Earrings for Men Women Jewelry Piercing Hoop Men Earrings Set       ']")));
            System.out.println(driver.findElement(By.xpath("//div[@id='averageCustomerReviews']//span//span[@id='acrPopover']//a//i//span[text()='4.3 out of 5 stars']")).getText());
            System.out.println(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[5]/div[1]/div[1]/div[2]/div[2]/div/div/div[1]/div[5]/div/span[3]/a/span")).getText());
            System.out.println(driver.findElement(By.xpath("//img[@alt='ONESING 15 Pairs Black Earrings for Men Mens Earrings Stainless Steel Black Stud Earrings for Men Women Jewelry Piercing Hoop Men Earrings Set']")).isDisplayed());
       }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	public void searchandaddtocart(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(4000);
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='14K Gold Plated 925 Sterling Silver Cubic Zirconia Hoop Earrings']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(4000);
            AddToCart.click();	
            Thread.sleep(4000);
            AddedToCart.getText();
       }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	public void searchandsortbyhightolow(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(4000);
		Select sortby=new Select(SortBy_DropDownMenu);
		sortby.selectByValue("price-desc-rank");
		Thread.sleep(4000);
		try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='14K Gold Plated 925 Sterling Silver Cubic Zirconia Hoop Earrings']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(4000);
           AddToCart.click();	
       }catch (Exception NoSuchElementException) { 
		} try {		
        WebElement Element=driver.findElement(By.xpath("//span[text()='IGI-Certified 14k White Gold Round-Cut Diamond Stud Earrings (1/4 - 3 cttw, H-I Color, I1 Clarity)']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.click();
        Thread.sleep(2000);
        AddToCart.click();	
        System.out.println("Successfully Sorted product by high to low");
        }catch (Exception NoSuchElementException) { 
 	   System.out.println("Product is sold");
 	   }}
		
	
	public void searchandsortbylowtohigh(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(4000);
		Select sortby=new Select(SortBy_DropDownMenu);
		sortby.selectByValue("price-asc-rank");
		Thread.sleep(4000);
       try { WebElement Element=driver.findElement(By.xpath("//span[text()='Earrings for Women Girls,1 Pair Women All-Match Rose Flower Shape Cubic Zirconia Long Dangle Earring Jewelry Accessory - Yellow']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.click();
        Thread.sleep(4000);
		AddToCart.click();
        System.out.println("Successfully Sorted product by low to high");
		}	catch (Exception e) { 
		 	   System.out.println("Product is sold");}
		}
	
	
	public  void searchandsortbyfeatured(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(2000);
       try { WebElement Element=driver.findElement(By.xpath("//span[text()='14K Gold Plated 925 Sterling Silver Cubic Zirconia Hoop Earrings']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
       }catch (Exception e) { 
		 	   System.out.println("Product is sold");}
		}
	
	public void searchandsortbyavgcustomerreviews(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(2000);
		Select sortby=new Select(SortBy_DropDownMenu);
		sortby.selectByValue("review-rank");
        Thread.sleep(3000);
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='Bangtan Boy Album BTS SUGA Stud Punk Earrings for Women Men']"));
           js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		}	catch (Exception e) { 
		 	   System.out.println("Product is sold");
		 	   }
	}	
	
	public void searchandsortbynewestarrival(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(4000);
		Select sortby=new Select(SortBy_DropDownMenu);
		sortby.selectByValue("date-desc-rank");
        Thread.sleep(4000);
       try { 
    	   WebElement Element=driver.findElement(By.xpath("//span[text()='IceCarats® Designer Jewelry 14K Madi K Polished Rhodium Horseshoe Post Earrings']"));
       
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.click();
        Thread.sleep(4000);
		AddToCart.click();	
       }catch (Exception e) { 
	 	   System.out.println("Product is sold");
	 	   }
	}
	
	////search and filter by price and then add to cart
	public void searchandfilter_PriceUnder$25(String clothing) throws InterruptedException {
		Search_box.sendKeys(clothing);
		Search_button.click();
		Thread.sleep(2000);   
   		PriceUnder$25_Filter.click();
   		try{
   			WebElement Element=driver.findElement(By.xpath("//span[text()='Baby Boy 1st Birthday T-Shirt - I’m Wild and 1 Jungle Animals Birthday Top Tee']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
         Select size=new Select(Size_dropdown);
         size.selectByVisibleText("2T");
         Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
       }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	public void searchandfilter_$50to$100(String clothing) throws InterruptedException {
		Search_box.sendKeys(clothing);
		Search_button.click();
		Thread.sleep(2000);
		$50to$100_Filter.click();
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='Baby-Boys 3-Pack Short-Sleeve Pocket Henley Tee Shirt']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
         Select size=new Select(Size_dropdown);
         size.selectByVisibleText("18 Months");
         Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
       }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	public void searchandfilter_$100to$200(String clothing) throws InterruptedException {
		Search_box.sendKeys(clothing);
		Search_button.click();
		Thread.sleep(2000);
		$100to$200_Filter.click();
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='Baby-Boys Short Sleeve Tee and Pant Set']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
         Select size=new Select(Size_dropdown);
         size.selectByVisibleText("12 Months");
         Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
       }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	public void searchandfilter_$200andAbove(String clothing) throws InterruptedException {
		Search_box.sendKeys(clothing);
		Search_button.click();
		Thread.sleep(2000);
		$200andAbove_Filter.click();
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='Baby-Boys Triblend Short Sleeve Crewneck T-Shirt']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
            Select size=new Select(Size_dropdown);
            size.selectByVisibleText("18-24 Months");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
            }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	///	////search and filter by brand and then add to cart

	public void searchandfilter_byBrand_MichaelKors(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(2000);
		MichaelKors_Filter.click();
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='Stainless Steel Stud Earrings With Crystal Accents']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
            }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	public void searchandfilter_byBrand_AmazonCollection(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(5000);
		AmazonCollection_Filter.click();
		Thread.sleep(3000);

        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='Sterling Silver Cubic Zirconia Round-Cut Halo Drop Leverback Earrings (3 cttw)']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
            }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	public void searchandfilter_byBrand_Pavoi(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(2000);
		Pavoi_Filter.click();
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='14K Gold Plated Minimalist Suspender Earring CZ Ear Lobe Cuff Stud Earrings']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
            }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	public void searchandfilter_Swarovski(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(2000);
		Swarovski_filter.click();
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='Women's Angelic Jewelry Collection, Rhodium Finish, Blue Crystals, Clear Crystals']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
            }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	
	//filter by newest arrival
	public void searchandfilter_bynewestarrival(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(5000);
		NewArrival_Filter.click();
		Thread.sleep(4000);
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='Carved Flower Medallion & Crystal Gem Drop Earrings, One Size, Glass']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
            }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	//filtration by customer rating

	public void searchandfilter_CustRating_4starsandup(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(5000);
		CustRating_4starsandup.click();
		Thread.sleep(4000);
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='Chunky Gold Hoop Earrings for Women Cute Fashion Hypoallergenic earrings Minimalist Jewelry Gift…']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
            }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	public void searchandfilter_CustRating_3starsandup(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(5000);
		CustRating_3starsandup.click();
		Thread.sleep(4000);
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='Butterfly Hoop Earrings 18k Gold Plated Hoop Earrings Trendy Hypoallergenic Studs with Cubic Zirconia Earrings for Women']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
            }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	public void searchandfilter_CustRating_2starsandup(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(5000);
		CustRating_2starsandup.click();
		Thread.sleep(4000);
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='925 Sterling Silver Cubic Zirconia Halo Stud Earrings for Women Round & Square Cut CZ Earrings Set']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
            }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
	public void searchandfilter_CustRating_1starandup(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(5000);
		CustRating_1starandup.click();
		Thread.sleep(4000);
        try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='14K Gold Plated Hoop Earring Small Square Huggies Hoops For Women, Minimalist Cute Earrings for Women Girls Gift,Gold and Silver…']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
            }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
	}
	
//searchingandsorting
	public AddtocartPage searchandsortfunctionality(String clothing) throws InterruptedException {
		Search_box.sendKeys(clothing);
		Search_button.click();
		Thread.sleep(4000);
		$200andAbove_Filter.click();
		Thread.sleep(5000);
		Actions action=new Actions(driver);
		//to implement action required, we must end with build().perform()
		action.moveToElement(driver.findElement(By.xpath("//span[@class='a-dropdown-container']//label[text()='Sort by:']"))).build().perform();
		driver.findElement(By.cssSelector("#s-result-sort-select > option:nth-child(4)")).click();
        Thread.sleep(4000);
		try{
        	WebElement Element=driver.findElement(By.xpath("//span[text()='Henry POW Check Occasion Wear, Boys Gray Wedding Slim Fit Suit with Shirt and Vest, X-Large - 20']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(2000);
            Select size=new Select(Size_dropdown);
            size.selectByVisibleText("2T");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();	
       }catch (Exception NoSuchElementException) { 
    	   System.out.println("Product is sold");
		}
		return new AddtocartPage();}
	
	//
	
}
