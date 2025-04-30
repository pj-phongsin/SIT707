package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private WebDriver setupDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/pj/chromedriver-mac-arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:8082/login.html");
		sleep(2);
		return driver;
	}
	
	private void login(WebDriver driver, String username, String password, String dob) {
		driver.findElement(By.id("username")).sendKeys(username);
	    driver.findElement(By.id("passwd")).sendKeys(password);
	    driver.findElement(By.id("dob")).sendKeys(dob);
	    driver.findElement(By.cssSelector("[type=submit]")).click();
	    sleep(2);
	}
	
	@Test
	public void TestValidLogin() {
		WebDriver driver = setupDriver();
		login(driver, "pj", "pj_pass", "09-10-1996");
		Assert.assertEquals("success", driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void testInvalidPassword() {
	    WebDriver driver = setupDriver();
	    login(driver, "pj", "wrong_pass", "09-10-1996");
	    Assert.assertEquals("fail", driver.getTitle());
	    driver.quit();
	}
	
	@Test
	public void testInvalidUsername() {
	    WebDriver driver = setupDriver();
	    login(driver, "wrong_user", "pj_pass", "09-10-1996");
	    Assert.assertEquals("fail", driver.getTitle());
	    driver.quit();
	}
	
	@Test
	public void testInvalidDOB() {
	    WebDriver driver = setupDriver();
	    login(driver, "pj", "pj_pass", "01-01-1999");
	    Assert.assertEquals("fail", driver.getTitle());
	    driver.quit();
	}
	
	@Test
	public void testEmptyFields() {
	    WebDriver driver = setupDriver();
	    login(driver, "", "", "");
	    Assert.assertEquals("fail", driver.getTitle());
	    driver.quit();
	}
	

}
