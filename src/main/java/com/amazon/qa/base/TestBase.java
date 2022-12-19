package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.qa.util.TestUtilclass;

public class TestBase {
	public static Properties prop= new Properties();

	public static WebDriver driver;
	FileInputStream file;                     
	
	public TestBase() {	
		FileInputStream file;                     //using FileInputStream class to base class read data from any file
		try {
			file = new FileInputStream("C:\\Users\\manis\\eclipse-workspace\\Amazon_Framework\\src\\main\\java\\environment_variables\\Config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException a) {
			a.printStackTrace();
		}
	}
	
	
	

	public static void initialization() throws InterruptedException {
		String browserName=	prop.getProperty("browser");
		
		if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
			
		} else if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtilclass.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtilclass.IMPLICIT_WAIT,TimeUnit.SECONDS);


	

		driver.get(prop.getProperty("url"));			
	}
}


