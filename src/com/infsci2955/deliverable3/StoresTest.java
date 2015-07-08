package com.infsci2955.deliverable3;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * As a user,
 * I would like to see deals on different stores,
 * So that I can easily find deals on some store.
 * 
 *
 */

public class StoresTest {

	static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for dealmoon for each test
	
	@Before
	public void setUp() throws Exception {
		driver.get("http://www.dealmoon.com");
	}

	// Given that I am on the main page
	// When I view the main tabs bar
	// Then I see that it contains the "Stores" link
	@Test
	public void testStoresLink() {
		
		// Simply check that the tabs bar contains the "Stores" link
		try{
			driver.findElement(By.linkText("Stores"));
		}catch (NoSuchElementException nsees){
		
			fail();
		}
		
	}
	
	
	// Given that I am on the main page
	// When I click on the "Stores" link
	// Then I should be redirected to the "Deals and coupons from top retailers" page
	@Test
	public void testStoresLinkTitle() {
		
		// find the "Stores" link and click on it
		// The page you go to should include "Deals and coupons from top retailers"
		// in the title
		
		driver.findElement(By.linkText("Stores")).click();
		String stroresPageTitle = driver.getTitle();
		assertTrue(stroresPageTitle.contains("Deals and coupons from top online retailers"));
	}
	
	
	
	// Given that I am on the Stores page
	// When I try to search "apple store"
	// Then I am given the deals and coupons from Apple Store
	@Test
	public void testSearchAppleStore() {
		
		driver.get("http://www.dealmoon.com/Online-Stores");
		
		// Enter store name "apple store"
		
		driver.findElement(By.xpath("//input[@id='store_name']")).sendKeys("apple store");
		
		// Look for the search button and click
		// to attempt to search 
		
		WebElement searthBtn = driver.findElement(By.className("search_btn"));
		assertNotNull(searthBtn);
		searthBtn.click();
		
		// Check that the page shows deals and coupons from Apple Store
		
		try {
			driver.findElement(By.xpath("//div[@class='mlist']"));
		} catch (NoSuchElementException nseex) {
			fail();
		}

	}

}
