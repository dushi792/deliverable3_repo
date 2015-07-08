package com.infsci2955.deliverable3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a new user,
 * I would like to sign up	 in the web site,
 * So that I can use some function 
 * @author jun
 *
 */

public class SignUpTest {
	private StringBuffer verificationErrors = new StringBuffer();
	private WebDriver driver;

	// Start at the sign up page for stackoverflow for each test
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("https://stackoverflow.com/users/signup");
	}

	@Test
	public void testSignUpWithBadPassword() throws Exception {		
		try {			
			driver.findElement(By.id("display-name")).sendKeys("juz21");
			driver.findElement(By.name("email")).sendKeys("juz21@pitt.edu");
			driver.findElement(By.name("password")).sendKeys("1234567");
			driver.findElement(By.name("password2")).sendKeys("1234567");
			//driver.findElement(By.id("submit-button")).click();
			
			// Check that there is a link to reset password and it is visible
			//WebElement submitButton = driver.findElement(By.id("submit-button"));
			//submitButton.click();
			
			WebElement e = driver.findElement(By.xpath("//span/p"));
			String elementText = e.getText();
			assertTrue(elementText.contains("Please add one of the following things to make your password stronger"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
//	@Test
//	public void testPasswordNotMatch() throws Exception {
//		try {
//			driver.findElement(By.id("display-name")).sendKeys("juz21");
//			driver.findElement(By.name("email")).sendKeys("juz21@pitt.edu");
//			driver.findElement(By.name("password")).sendKeys("Dushi792");
//			driver.findElement(By.name("password2")).sendKeys("Dushi7922");
//			//driver.findElement(By.id("submit-button")).click();
//			
//			// Check that there is a link to reset password and it is visible
//			//WebElement submitButton = driver.findElement(By.id("submit-button"));
//			//submitButton.click();
//			
//			assertEquals("The passwords do not match.", driver.findElement(By.xpath("//div[8]/div/div")).getText());
//		} catch (NoSuchElementException nseex) {
//			fail();
//		}
//	}
	
	@Test
	public void testSignUpCorrectly() throws Exception {		
		try {
			int radnum = (int)System.currentTimeMillis();
			driver.findElement(By.id("display-name")).sendKeys("juz"+Integer.toString(radnum));
			driver.findElement(By.name("email")).sendKeys("juz"+Integer.toString(radnum)+"@pitt.edu");
			driver.findElement(By.name("password")).sendKeys("Dushi792");
			driver.findElement(By.name("password2")).sendKeys("Dushi792");
			
			// Check that there is a link to reset password and it is visible
			WebElement submitButton = driver.findElement(By.id("submit-button"));
			submitButton.click();
			
			WebElement e = driver.findElement(By.xpath("//div[@id='mainbar-full']/div[2]/div/p[2]"));
			String elementText = e.getText();
			assertTrue(elementText.contains("Open this email to finish signup."));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	 @After
	 public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	 }

}
