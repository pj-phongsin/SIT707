package web.service;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FunctionalTest {
	
	private WebDriver driver;
	private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/pj/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testFullMathQuizFlow() {
        // Step 1: Login
        driver.get("http://localhost:8081/login");
        driver.findElement(By.name("username")).sendKeys("pj");
        driver.findElement(By.name("passwd")).sendKeys("pj_pass");
        driver.findElement(By.name("dob")).sendKeys("09-10-1996");
        driver.findElement(By.tagName("form")).submit();

        // Step 2: Q1
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("number1")));
        driver.findElement(By.name("number1")).clear();
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).clear();
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("7");
        driver.findElement(By.tagName("form")).submit();

        // Step 3: Q2
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("number1")));
        driver.findElement(By.name("number1")).clear();
        driver.findElement(By.name("number1")).sendKeys("10");
        driver.findElement(By.name("number2")).clear();
        driver.findElement(By.name("number2")).sendKeys("3");
        driver.findElement(By.name("result")).sendKeys("7");
        driver.findElement(By.tagName("form")).submit();

        // Step 4: Q3
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("number1")));
        driver.findElement(By.name("number1")).clear();
        driver.findElement(By.name("number1")).sendKeys("3");
        driver.findElement(By.name("number2")).clear();
        driver.findElement(By.name("number2")).sendKeys("4");
        driver.findElement(By.name("result")).sendKeys("12");
        driver.findElement(By.tagName("form")).submit();

        // Final Step: Completion
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        WebElement body = driver.findElement(By.tagName("body"));
        assertTrue(body.getText().contains("Well Done!"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}