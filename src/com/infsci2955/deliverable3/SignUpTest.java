package com.infsci2955.deliverable3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * As a new user,
 * I would like to sign up successfully in the web site,
 * So that I can then sign in with my user name and password
 * 
 *
 */

public class SignUpTest {
	private WebDriver driver;

	// Start at the sign up page for stackoverflow for each test
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("https://sso.dealmoon.com/register?language=en");
	}

	//@Test
	public void testSignUpWithBadPassword() throws Exception {
		try {
			// Input register information
			driver.findElement(By.id("regName")).sendKeys("juz123");
		    driver.findElement(By.id("regMail")).sendKeys("juz123@pitt.edu");
		    driver.findElement(By.id("hidPassword")).sendKeys("1");

			// Click the "Agree and Sign Up" button to submit form
			WebElement submitButton = driver.findElement(By.id("reg_btn"));
			submitButton.click();
			
			// Since the password is less than 6 characters, it will get an error message
			WebElement e = driver.findElement(By.id("errorPassword"));
			String elementText = e.getText();
			assertTrue(elementText.contains("Password is too short. Password must be between 6 and 32 characters."));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	
	@Test
	public void testSignUpCorrectly() throws Exception {		
		try {
			// Generate a random number and add it to user name
			int radnum = (int)System.currentTimeMillis()/100000;
			// Input register information
			driver.findElement(By.id("regName")).sendKeys("abcd"+Integer.toString(radnum));
			driver.findElement(By.id("regMail")).sendKeys("abcd"+Integer.toString(radnum)+"@pitt.edu");
			driver.findElement(By.id("hidPassword")).sendKeys("1234567");
			driver.findElement(By.id("hidPass")).sendKeys("1234567");
			
			// Click the "Agree and Sign Up" button to submit form
			WebElement submitButton = driver.findElement(By.id("reg_btn"));
			submitButton.click();
			
			// Need to wait for page change to login
		    WebElement element = (new WebDriverWait(driver, 30))
		    		  .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.reg_ps")));

		    // If success it will show a email verification page
			WebElement e = driver.findElement(By.cssSelector("div.reg_ps"));
			String elementText = e.getText();
			assertTrue(elementText.contains("Please verify your email!"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	 @After
	 public void tearDown() throws Exception {
	    driver.quit();
	 }

}
