package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void bunning_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/Users/pj/chromedriver-mac-arm64/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is email
		WebElement element = driver.findElement(By.id("username"));
		System.out.println("Found element: " + element);
		// Send email
		element.sendKeys("example@email.com");
		sleep(3);
		
		// Find password element
		WebElement element2 = driver.findElement(By.id("password"));
		System.out.println("Found element: " + element2);
		element2.sendKeys("password123");
		sleep(3);
		
		// Find Sign in button
		WebElement element3 = driver.findElement(By.id("login-submit"));
		System.out.println("Found element: " + element3);
		element3.click();
		
		// Sleep a while
		sleep(3);
		
		// close chrome driver
		driver.close();	
	}
	
	
}
