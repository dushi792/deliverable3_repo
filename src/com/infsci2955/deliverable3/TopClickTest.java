package com.infsci2955.deliverable3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

	/**
	 * As a user,
	 * I would like to see top click deals,
	 * So that I won't miss popular and great deals.
	 * 
	 */

	public class TopClickTest {
		static WebDriver driver = new HtmlUnitDriver();
		
		// Start at the  page for dealmoon top clicks for each test
		@Before
		public void setUp() throws Exception {
			driver.get("http://www.dealmoon.com/");
		}

		// Given that I am on the main page
		// When I click the Top Clicks tag
		// Then I jump to Top Clicks page
		// And see that time tag bar contains the "2 Hour", "4 Hour", "8 Hour", "24 Hour" and "48 Hour".
		@Test
		public void testTimeBar() {
			// Simply click the Top Clicks tag on the main page
			driver.findElement(By.linkText("Top Clicks")).click();
			// Simply check that the tabs bar contains different hours link
			try{
				driver.findElement(By.linkText("2 Hour"));
				driver.findElement(By.linkText("4 Hour"));
				driver.findElement(By.linkText("8 Hour"));
				driver.findElement(By.linkText("24 Hour"));
				driver.findElement(By.linkText("48 Hour"));
			}catch (NoSuchElementException nsees){
				fail();
			}
		}
		
		// Given that I am on the main page
		// When I jump to Top Clicks page
		// Then I see that shows category list at the left of page.
		@Test
		public void testCategoryList() {
			driver.findElement(By.linkText("Top Clicks")).click();
			// Simply check that the pages contains different category link
			try{
				driver.findElement(By.linkText("Any Category"));
				driver.findElement(By.linkText("Clothing, Jewelry & Bags"));
				driver.findElement(By.linkText("Beauty"));
			}catch (NoSuchElementException nsees){
				fail();
			}
		}
		
		// Given that I am on the main page
		// When I jump to a deal page
		// Then I can see the top click box at right
		@Test
		public void testTopClickBox() {
			// Jump to Computers->iPad & Tablets category
			driver.findElement(By.linkText("Computers")).click();
			driver.findElement(By.linkText("iPad & Tablets")).click();
			// At right should have a box titled "Most Clicked Deals in Category"
			try {
				WebElement e = driver.findElement(By.cssSelector("h3"));
				String elementText = e.getText();
				assertTrue(elementText.contains("Most Clicked Deals in Category"));
			} catch (NoSuchElementException nseex) {
				fail();
			}
		}
}
