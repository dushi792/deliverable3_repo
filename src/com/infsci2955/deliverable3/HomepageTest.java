package com.infsci2955.deliverable3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a user,
 * I would like to see dealmoon logo at the page's top,
 * So that I can make sure I am in the dealmoon's page, not other sales' page
 * @author Jun
 *
 */

public class HomepageTest {

	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for dealmoon for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://www.dealmoon.com/");
	}

	// When I get into the homepage
	// Then I see that it has the dealmoon logo and title
	@Test
	public void testShowsCorrectTitle() {		
		// Simply check that the title contains the word "dealmoon"		
		try {
			WebElement e = driver.findElement(By.className("logo"));
			String elementText = e.getText();
			assertTrue(elementText.contains("Dealmoon"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	
	// Given that I am on the homepage
	// When I click "Coupons"
	// Then I jump to coupon page
	// But I still in the dealmoon web site
	// And I can see the dealmoon logo
	@Test
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