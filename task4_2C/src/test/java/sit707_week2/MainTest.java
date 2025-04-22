package sit707_week2;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Ahsan Habib
 */
public class MainTest {
	
	/*
	@Test
	public void testStudentIdentity() {
		String studentId = "224588035";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Phongsin";
		Assert.assertNotNull("Student name is null", studentName);
	}
	*/
	
	public MainTest() {
		System.out.println("MainTest");
	}
	
	private WebDriver driver;
	
	@Before
	public void setup() {
		System.out.println("Before...");
		System.setProperty("webdriver.chrome.driver", "/Users/pj/chromedriver-mac-arm64/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.bunnings.com.au/login");
		
	}
	
	private void login(String email, String password) {
		WebElement emailInput = driver.findElement(By.id("username"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement loginButton = driver.findElement(By.id("login-submit"));
		
		emailInput.clear();
		emailInput.sendKeys(email);
		passwordInput.clear();
		passwordInput.sendKeys(password);loginButton.click();
	}
	
	@Test
	public void testValidEmailAndPassword()
	{
		login("validEmail@email.com", "validPassword");
		assertTrue(driver.getCurrentUrl().contains("account") || driver.getPageSource().contains("My Account"));
	}
	
	@Test
	public void testInvalidEmailAndPassword()
	{
		login("invalidEmail@email.com", "invalidPassword");
		assertTrue(driver.getPageSource().contains("Your email address or password is incorrect"));
	}
	
	@Test
	public void testInvalidEmail()
	{
		login("invalidEmail@email.com", "validPassword");
		assertTrue(driver.getPageSource().contains("Your email address or password is incorrect"));
	}
	
	@Test 
	public void testInvalidPassword()
	{
		login("validEmai@email.com", "invalidPassword");
		assertTrue(driver.getPageSource().contains("Your email address or password is incorrect"));
	}
	
	@Test
	public void testEmptyEmail()
	{
		login("", "validPassword");
		assertTrue(driver.getPageSource().contains("This field is required"));
	}
	
	@Test
	public void testEmptyPassword()
	{
		login("validEmai@email.com", "");
		assertTrue(driver.getPageSource().contains("This field is required"));
	}
	
	@Test
	public void testEmptyEmailAndPassword()
	{
		login("validEmai@email.com", "");
		assertTrue(driver.getPageSource().contains("This field is required"));
	}
}
