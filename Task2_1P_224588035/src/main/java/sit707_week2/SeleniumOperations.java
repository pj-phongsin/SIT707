package sit707_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


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
	
	
	public static void officeworks_registration_page(String url) {
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
		
		// Find first input field which is firstname
		WebElement element1 = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element1);
		// Send first name
		element1.sendKeys("Phongsin");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
		WebElement element2 = driver.findElement(By.id("lastname"));
		System.out.println("Found element: " + element2);
		element2.sendKeys("Jirapipattanaporn");
		
		WebElement element3 = driver.findElement(By.id("phoneNumber"));
		System.out.println("Found element: " + element3);
		element3.sendKeys("0431079695");
		
		WebElement element4 = driver.findElement(By.id("email"));
		System.out.println("Found element: " + element4);
		element4.sendKeys("s224588035@deakin.edu.au");
		
		WebElement element5 = driver.findElement(By.id("password"));
		System.out.println("Found element: " + element5);
		element5.sendKeys("555");
		
		WebElement element6 = driver.findElement(By.id("confirmPassword"));
		System.out.println("Found element: " + element6);
		element6.sendKeys("555");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		// Write code
		WebElement element7 = driver.findElement(By.cssSelector("button[data-testid='account-action-btn']"));
		System.out.println("Found element: " + element7);
		element7.click();
		
	
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
		takeScreenshot(driver, "screenshots/registration_page.png");
		
		// Sleep a while
		sleep(3);
		
		// close chrome driver
		driver.close();	
	}
	


	public static void takeScreenshot(WebDriver driver, String filePath) {
		// Cast the driver to TakesScreenshot
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		// Capture the screenshot as a file
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

		// Create the destination file
		File destFile = new File(filePath);
		
		// Ensure the directory exists
		destFile.getParentFile().mkdirs();

		// Copy the screenshot file to the destination
		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot saved to: " + filePath);
		} catch (IOException e) {
			System.out.println("Failed to save screenshot: " + e.getMessage());
		}
	}
	
	
	public static void footLocker_registration_page(String url) {
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
		
		WebElement element8 = driver.findElement(By.id("AccountCreate_text_firstName"));
		System.out.println("Found element: " + element8);
		element8.sendKeys("Phongsin");
		
		WebElement element9 = driver.findElement(By.id("AccountCreate_text_lastName"));
		System.out.println("Found element: " + element9);
		element9.sendKeys("Jirapipattanaporn");
		
		WebElement element10 = driver.findElement(By.id("AccountCreate_email_uid"));
		System.out.println("Found element: " + element10);
		element10.sendKeys("s224588035@deakin.edu.au");
		
		WebElement element11 = driver.findElement(By.id("AccountCreate_password_password"));
		System.out.println("Found element: " + element11);
		element11.sendKeys("12345");
		
		WebElement element12 = driver.findElement(By.id("AccountCreate_tel_dateofbirthday"));
		System.out.println("Found element: " + element12);
		element12.sendKeys("00");
		
		WebElement element13 = driver.findElement(By.id("AccountCreate_tel_dateofbirthmonth"));
		System.out.println("Found element: " + element13);
		element13.sendKeys("00");
		
		WebElement element14 = driver.findElement(By.id("AccountCreate_tel_dateofbirthyear"));
		System.out.println("Found element: " + element14);
		element14.sendKeys("00");
		
		//Wait until the cookie pop up come up
		sleep(3);
		
		WebElement element15 = driver.findElement(By.id("onetrust-accept-btn-handler"));
		System.out.println("Found element: " + element15);
		element15.click();
		
		sleep(2);
		
		takeScreenshot(driver, "screenshots/registration_page2.png");
		
		// Sleep a while
		sleep(3);
				
		// close chrome driver
		driver.close();	
	}
		
}

