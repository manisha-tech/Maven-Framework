package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;


import com.amazon.qa.base.TestBase;

public class AddtocartPage extends TestBase {

	SigninPage SignIn;
	YourAccountPage YourAccount;
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
	
	public AddtocartPage() {
		PageFactory.initElements(driver, this);
	}
	
    //Actions
	public String validatepagetitle() {
		CartModule.click();
		return driver.getTitle();
	}
	
	
	
	public void addproducttocart(String product) throws InterruptedException {
		Search_box.sendKeys(product);
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
            System.out.println( driver.findElement(By.xpath("//img[@alt='PAVOI 14K Gold Plated 925 Sterling Silver Cubic Zirconia Hoop Earrings | Yellow Gold Hoops, Opens in a new tab']")).getText());
            System.out.println( driver.findElement(By.xpath("//span[@class='a-truncate-cut' and text()='PAVOI 14K Gold Plated 925 Sterling Silver Cubic Zirconia Hoop Earrings | Yellow Gold Hoops']")).getText());
			System.out.println( driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/p/span")).getText());
			Thread.sleep(4000);
			EmptyCart.click();
			}catch (Exception NoSuchElementException) { 
				System.out.println("Product is sold");
				}
		}
	
	public void incquantityfromcart(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(4000);
     try {
        	WebElement Element=driver.findElement(By.xpath("//h2//a//span[text()='Earrings Set for Women Girls, Funtopia 61 Pairs Fashion Tassel Earrings Acrylic Hoop Stud Drop Dangle Earrings for Birthday Party Gift, Assorted Styles and Colors']"));
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(4000);
            AddToCart.click();	
            Thread.sleep(4000);
            System.out.println(AddedToCart.getText());
            Thread.sleep(4000);
            GoToCart.click();
            Thread.sleep(4000);
		    Actions action=new Actions(driver);
	     	action.moveToElement(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[1]/span/span[1]/span/select"))).build().perform();
		    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[1]/span/span[1]/span/select/option[5]")).click();
            Thread.sleep(4000);
            System.out.println(ProductValue.getText());
            Thread.sleep(4000);
            System.out.println( CartValue.getText());
            Thread.sleep(4000);
            EmptyCart.click();
            }catch (Exception NoSuchElementException) { 
         	   System.out.println("Product is sold");
        	}
	}
	
	public void addSameItemultipletimes(String product) throws InterruptedException {	
	Search_box.sendKeys(product);
	Search_button.click();
	Thread.sleep(4000);
try {
    	WebElement Element=driver.findElement(By.xpath("//h2//a//span[text()='18Pairs 316L Stainless Steel Star Moon Stud Earrings for Women Men Cute CZ Inlaid Stud Earring Set Huggie Hoop Cuff Earrings Ear Piercing Set']"));
        js.executeScript("arguments[0].scrollIntoView();", Element);
        Element.click();
        Thread.sleep(5000);
        AddToCart.click();	
        Thread.sleep(5000);
        System.out.println(AddedToCart.getText());
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        AddToCart.click();	
        Thread.sleep(5000);
        System.out.println(AddedToCart.getText());
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        AddToCart.click();	
        Thread.sleep(5000);
        System.out.println(AddedToCart.getText());       
        Thread.sleep(5000);
        GoToCart.click();
        Thread.sleep(5000);
        System.out.println(ProductValue.getText());
        Thread.sleep(5000);
        System.out.println(CartValue.getText());
        Thread.sleep(4000);
        EmptyCart.click();

   }catch (Exception NoSuchElementException) { 
	   System.out.println("Product is sold");
	}
   }

	public void addDiffItemMultipletimes(String product) throws InterruptedException {	
	Search_box.sendKeys(product);
	Search_button.click();
	Thread.sleep(2000);
 try {
    	WebElement Element1=driver.findElement(By.xpath("//h2//a//span[text()='Sterling Silver Tree of Life Earrings']"));
        js.executeScript("arguments[0].scrollIntoView();", Element1);
        Element1.click();
        Thread.sleep(4000);
        AddToCart.click();	
        Thread.sleep(4000);
        System.out.println(AddedToCart.getText());
        Thread.sleep(4000);
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(4000);
    	WebElement Element2=driver.findElement(By.xpath("//h2//a//span[text()='Stainless Steel Flattened Hoop Earrings']"));
        js.executeScript("arguments[0].scrollIntoView();", Element2);
        Element2.click();
        AddToCart.click();	
        Thread.sleep(4000);
        System.out.println(AddedToCart.getText());
        Thread.sleep(4000);
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(4000);
    	WebElement Element3=driver.findElement(By.xpath("//h2//a//span[text()='Stainless Steel Rounded Hoops Earrings']"));
        js.executeScript("arguments[0].scrollIntoView();", Element3);
        Element3.click();
        AddToCart.click();	
        Thread.sleep(4000);
        System.out.println(AddedToCart.getText());
        Thread.sleep(4000);
        GoToCart.click();
        Thread.sleep(4000);       
        System.out.println(driver.findElement(By.xpath("//a//img[@alt='Sterling Silver Tree of Life Earrings, Opens in a new tab']")).getText());
        Thread.sleep(4000);

        System.out.println(driver.findElement(By.xpath("//span[@class='a-truncate-cut' and text()='Sterling Silver Tree of Life Earrings']")).getText());
        Thread.sleep(4000);

        System.out.println(driver.findElement(By.xpath("//*[@id=\"sc-active-C1c7585d8-8643-44e6-9499-28bb99e1d920\"]/div[4]/div/div[2]/p/span")).getText());
        Thread.sleep(4000);

        Thread.sleep(4000);
        System.out.println(driver.findElement(By.xpath("//a//img[@alt='Amazon Essentials Stainless Steel Flattened Hoop Earrings (40mm), Opens in a new tab']")).getText());
        Thread.sleep(4000);

        System.out.println(driver.findElement(By.xpath("//span[@class='a-truncate-cut' and text()='Amazon Essentials Stainless Steel Flattened Hoop Earrings (40mm)']")).getText());
        Thread.sleep(4000);

        System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[4]/div[4]/div/div[2]/p/span")).getText());
        Thread.sleep(4000);

        Thread.sleep(4000);
        System.out.println(driver.findElement(By.xpath("//a//img[@alt='Amazon Essentials Stainless Steel Flattened Hoop Earrings (45mm), Opens in a new tab']")).getText());
        Thread.sleep(4000);

        System.out.println(driver.findElement(By.xpath("//span[@class='a-truncate-cut' and text()='Amazon Essentials Stainless Steel Flattened Hoop Earrings (45mm)']")).getText());
        Thread.sleep(4000);

        System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/p/span")).getText());
        Thread.sleep(4000);
        System.out.println(CartValue.getText());
        Thread.sleep(4000);  
        EmptyCart.click();

 }
    catch (Exception e) { 
	   System.out.println("Product is sold");
	}
    }
	
	
	public void removeSomeItemFromCart(String product) throws InterruptedException {	
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(4000);
	    try {
	    	WebElement Element1=driver.findElement(By.xpath("//h2//a//span[text()='36 Pairs Fashion Drop Dangle Earrings Set for Women Girls Vintage Bronze Statement Bohemian Stud Earrings with Pearl Hollow Leaf Dreamcatcher Turquoise Inlay Jewelry for Gifts']"));
	        js.executeScript("arguments[0].scrollIntoView();", Element1);
	        Element1.click();
	        Thread.sleep(4000);
	        AddToCart.click();	
	        Thread.sleep(4000);
	        System.out.println(AddedToCart.getText());
	        Thread.sleep(4000);
	        driver.navigate().back();
	        driver.navigate().back();
	        Thread.sleep(4000);
	    	WebElement Element2=driver.findElement(By.xpath("//h2//a//span[text()='Stainless Steel Stud Earrings Set Hypoallergenic Cubic Zirconia 18K White Gold 316L CZ Earring 6 Pairs 3-8mm']"));
	        js.executeScript("arguments[0].scrollIntoView();", Element2);
	        Element2.click();
	        AddToCart.click();	
	        Thread.sleep(4000);
	        System.out.println(AddedToCart.getText());
	        Thread.sleep(4000);
	        driver.navigate().back();
	        driver.navigate().back();
	        Thread.sleep(4000);
	    	WebElement Element3=driver.findElement(By.xpath("//h2//a//span[text()='24 Pairs Weird Cute Earrings Drop Dangle Earrings for Women Girls Planet Astronaut Moon and Stars Face Dinosaur Bear Lollipop Fish Strawberry Mushroom Flowers Egg and Many More']"));
	        js.executeScript("arguments[0].scrollIntoView();", Element3);
	        Element3.click();
	        AddToCart.click();	
	        Thread.sleep(4000);
	        System.out.println(AddedToCart.getText());
	        Thread.sleep(4000);
	        GoToCart.click();
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("//*[@id=\"sc-active-C545babae-8bd8-4e53-9989-2590616214bb\"]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span/input")).click();
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("//*[@id=\"sc-active-Cc2280db7-e68f-4341-93a1-606eea2eceb3\"]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span/input")).click();
	        Thread.sleep(4000);
	        System.out.println(CartValue.getText());
	        Thread.sleep(4000);
	        EmptyCart.click();

	    }
	    catch (Exception e) { 
		   System.out.println("Product is sold");
		}
	}
		
	
	public void removeAllItemFromCart(String product) throws InterruptedException {	
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(4000);
try {
	    	WebElement Element1=driver.findElement(By.xpath("//h2//a//span[text()='36 Pairs Fashion Drop Dangle Earrings Set for Women Girls Vintage Bronze Statement Bohemian Stud Earrings with Pearl Hollow Leaf Dreamcatcher Turquoise Inlay Jewelry for Gifts']"));
	        js.executeScript("arguments[0].scrollIntoView();", Element1);
	        Element1.click();
	        Thread.sleep(4000);
	        AddToCart.click();	
	        Thread.sleep(4000);
	        System.out.println(AddedToCart.getText());
	        Thread.sleep(4000);
	        driver.navigate().back();
	        driver.navigate().back();
	        Thread.sleep(4000);
	    	WebElement Element2=driver.findElement(By.xpath("//h2//a//span[text()='Stainless Steel Stud Earrings Set Hypoallergenic Cubic Zirconia 18K White Gold 316L CZ Earring 6 Pairs 3-8mm']"));
	        js.executeScript("arguments[0].scrollIntoView();", Element2);
	        Element2.click();
	        AddToCart.click();	
	        Thread.sleep(4000);
	        System.out.println(AddedToCart.getText());
	        Thread.sleep(3000);
	        GoToCart.click();
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("//*[@id=\"sc-active-C7be39ebd-56ce-4ecb-97bc-a41d170424db\"]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span/input")).click();
	        Thread.sleep(4000);

	        driver.findElement(By.xpath("//*[@id=\"sc-active-C65b229f6-0f0c-4889-9a5c-4ae5aee91e54\"]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span/input")).click();
	        Thread.sleep(4000);
	       System.out.println("Your Amazon Cart is empty.");
	        Thread.sleep(4000);
	        EmptyCart.click();
}

catch (Exception NoSuchElementException) { 
	   System.out.println("Product is sold");
	}
	    }
	
	public void clickOnAnItemInCart(String product) throws InterruptedException {	
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(4000);
	 try {
	    	WebElement Element1=driver.findElement(By.xpath("//h2//a//span[text()='925 Sterling Silver Cubic Zirconia Halo Stud Earrings for Women Round & Square Cut CZ Earrings Set']"));
	        js.executeScript("arguments[0].scrollIntoView();", Element1);
	        Element1.click();
	        Thread.sleep(4000);
	        AddToCart.click();	
	        Thread.sleep(4000);
	        System.out.println(AddedToCart.getText());
	        Thread.sleep(4000);
	        GoToCart.click();
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("//a//img[@alt='Sllaiss 925 Sterling Silver Cubic Zirconia Halo Stud Earrings for Women Round & Square Cut CZ Earrings Set, Sterling Silver Plastic Cubic Zirconia Platinum, Opens in a new tab']")).click();
	        Thread.sleep(4000);
	        driver.navigate().to("https://www.amazon.ca/gp/product/B07DD5PWC8/ref=ox_sc_act_image_1?smid=A239IL9HCNZCMZ&psc=1");
	        Thread.sleep(4000);
	        String URL = driver.getCurrentUrl();
	        Thread.sleep(4000);
	        Assert.assertEquals(URL, "https://www.amazon.ca/gp/product/B07DD5PWC8/ref=ox_sc_act_image_1?smid=A239IL9HCNZCMZ&psc=1" );
	        Thread.sleep(4000);
	        System.out.println("Successfully redirected to the product info page.");
	    }
	 catch (Exception NoSuchElementException) { 
	 	   System.out.println("Product is sold");
		}
	 }	    
	
	public void closebrowserandgetback(String product) throws InterruptedException {
		Search_box.sendKeys(product);
		Search_button.click();
		Thread.sleep(4000);
      	try{
      		WebElement Element=driver.findElement(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal' and text()='Sterling Silver Hoop Earrings | Sterling Silver Stud Earrings for Women - 6 Pairs Hypoallergenic Tiny Cubic Zirconia Stud Earrings Set & Cartilage Earring Hoops for Girl']"));
      	
        	Thread.sleep(4000);
            js.executeScript("arguments[0].scrollIntoView();", Element);
            Element.click();
            Thread.sleep(4000);
            AddToCart.click();	
            Thread.sleep(4000);
            System.out.println(AddedToCart.getText());
            Thread.sleep(4000);
            GoToCart.click();
            Thread.sleep(4000);
            driver.close();
            initialization();
            Thread.sleep(4000);
            SignIn=new SigninPage();
    		YourAccount=SignIn.signin(prop.getProperty("Emailaddress"), prop.getProperty("Password"));
            Thread.sleep(6000);       
    		driver.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
            Thread.sleep(6000);       
    		System.out.println(driver.findElement(By.xpath("//img[@alt='Sterling Silver Hoop Earrings | Sterling Silver Stud Earrings for Women - 6 Pairs Hypoallergenic Tiny Cubic Zirconia Stud Earrings Set & Cartilage Earring Hoops for Girl, Opens in a new tab']")).getText());
    		Thread.sleep(3000);
    		System.out.println("Sterling Silver Hoop Earrings | Sterling Silver Stud Earrings for Women - 6 Pairs Hypoallergenic Tiny Cubic Zirconia Stud Earrings Set & Cartilage Earring Hoops for Girl");
	
  }catch(Exception e) { 
	   System.out.println("Product is sold");
	}
      	}
	}

