package com.infsci2955.deliverable3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * As a user,
 * I would like to sign in with user name and password, and reset password when I forget,
 * So that I can sign in whether I remember the correct password.
 * 
 */

public class SignInTest {
	private WebDriver driver;
	
	// Start at the log in page for dealmoon for each test
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("https://sso.dealmoon.com/login");
	}

	// Given that I am in the login page
	// When I input correct user name and password
	// Then I should login successfully
	@Test
	public void testSignIn() {
		try {				
			// Enter user name "juz21@pitt.edu", password "123456", then click log button to sign in
		    driver.findElement(By.id("logMail")).sendKeys("juz21@pitt.edu");
		    driver.findElement(By.id("hidPass")).sendKeys("123456");
		    driver.findElement(By.id("log_btn")).click();
		    
		    // Need to wait for page change to login
		    WebElement element = (new WebDriverWait(driver, 10))
		    		  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("strong")));
		    
		    // Check if the page title changes to "bookmarks", which means log in successfully.
		    String title = driver.getTitle();
			assertTrue(title.contains("Bookmarks"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	// Given that I am in the login page
	// When I click "Forgot Password?"
	// And input my correct email
	// Then I should get a successful message
	@Test
	public void testForgetPassword() {		
		try {
			driver.findElement(By.linkText("Forgot Password?")).click();
			driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("juz21@pitt.edu");
		    driver.findElement(By.id("yz_btn")).click();
		    // Need to wait for page change to login
		    WebElement element = (new WebDriverWait(driver, 10))
		    		  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.reg_ps")));
		    WebElement e = driver.findElement(By.cssSelector("div.reg_ps"));
			String elementText = e.getText();
			assertTrue(elementText.contains("Successful£¡"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	@After
	 public void tearDown() throws Exception {
	    driver.quit();
	 }
}