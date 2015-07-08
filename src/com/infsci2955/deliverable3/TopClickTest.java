package com.infsci2955.deliverable3;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

	/**
	 * As a user,
	 * I would like to see what deals are top clicked,
	 * So that I can easily find popular and great deals.
	 * 
	 *
	 */

	public class TopClickTest {

		static WebDriver driver = new HtmlUnitDriver();
		
		// Start at the  page for dealmoon top clicks for each test
		
		@Before
		public void setUp() throws Exception {
			driver.get("http://www.dealmoon.com/Most-Clicked-Deals");
		}

		// Given that I am on the top-clicked page
		// When I view the time tabs bar
		// Then I see that it contains the "2 Hour", "4 Hour", "8 Hour", "24 Hour" and "48 Hour".
		@Test
		public void testTimeBar() {
			
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
		
		
		// Given that I am on the top-clicked page
		// When I view the left of page
		// Then I see that it shows category list.
		@Test
		public void testCategoryList() {
			

			// Simply check that the pages contains different category link
			try{
				driver.findElement(By.linkText("Any Category"));
				driver.findElement(By.linkText("Clothing, Jewelry & Bags"));
				driver.findElement(By.linkText("Beauty"));
			}catch (NoSuchElementException nsees){
			
				fail();
			}
		}
		

}
