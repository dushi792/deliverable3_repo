package com.infsci2955.deliverable3;

import static org.junit.Assert.*;

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
 * @author Jun
 *
 */

public class SignInTest {

	static WebDriver driver = new FirefoxDriver();
	
	// Start at the home page for dealmoon for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://sso.dealmoon.com/login");
	}

	// Given that I am in the main page
	// When 
	// Then I 
	@Test
	public void testSignIn() {
		try {
		// Click sign in button
		//driver.findElement(By.id("sign_in_top")).click();
		
		// Enter user name "juz21@pitt.edu", password "123456", then click log button to sign in
		driver.findElement(By.id("logMail")).clear();
	    driver.findElement(By.id("logMail")).sendKeys("juz21@pitt.edu");
	    driver.findElement(By.id("hidPass")).clear();
	    driver.findElement(By.id("hidPass")).sendKeys("Password");
	    driver.findElement(By.id("logPass")).clear();
	    driver.findElement(By.id("logPass")).sendKeys("123456");
	    driver.findElement(By.id("log_btn")).click();
	    assertEquals("juz21pitt", driver.findElement(By.cssSelector("em.login_user_name")).getText());
	    driver.findElement(By.linkText("Log Out")).click();
		
		// Check if the page shows the user name "juz21pitt"
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	// Given that I am in the main page
	// When 
	// Then I
	//@Test
	public void testShowsCorrectTitle2() {		
		// Jump to coupons
		driver.findElement(By.linkText("Coupons")).click();
		try {
			WebElement e = driver.findElement(By.className("logo"));
			String elementText = e.getText();
			assertTrue(elementText.contains("Dealmoon"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}

}