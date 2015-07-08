package com.infsci2955.deliverable3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

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
	 * I would like to follow the web site on SNS or RSS,
	 * So that I can get the newest information.
	 *
	 */

	public class FollowUsTest {
		static WebDriver driver = new HtmlUnitDriver();
		
		// Start at the  page for dealmoon for each test
		@Before
		public void setUp() throws Exception {
			driver.get("http://www.dealmoon.com/");
		}

		// Given that I am on the main page
		// When I view the navigation bar
		// Then I see that it contains the SNS logo like "wechat", "facebook" "google" and "weibo".
		@Test
		public void testFollowUsBar() {
			// Simply check that the navigation bar contains different follow us links.
			try{
				driver.findElement(By.className("wechat"));
				driver.findElement(By.className("facebook"));
				driver.findElement(By.className("google"));
				driver.findElement(By.xpath("//a[@href='http://e.weibo.com/dealmoon']"));
			}catch (NoSuchElementException nsees){
				fail();
			}
		}
		
		// Given that I am on the main page
		// When I click facebook link
		// Then the browser opens a new tab page of dealmoon on the Facebook
		@Test
		public void testFacebookLink() {
			// Get current window handle
			String old = driver.getWindowHandle();
			driver.findElement(By.className("facebook")).click();;
			// Get all window handles
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			// Considering that there is only one tab opened in that point.
			tabs.remove(old);
			driver.switchTo().window(tabs.get(0));			
			// Get new tab page title
			String ftitle=driver.getTitle();
			assertEquals(ftitle,"Dealmoon | Facebook");
		}
		
		// Given that I am on the main page
		// When I click RSS Feed link on the footer
		// Then the browser opens a new tab page of RSS Feed which shows subscribe options
		// THE RSS WEB SITE COST TOO MUCH TIME TO LOAD, NOT RECOMMAND TO RUN THIS TEST
		//@Test
		public void testRssFeed() {
			driver.findElement(By.linkText("RSS Feed")).click();
			
			// Waiting for page responding
		    WebElement element = (new WebDriverWait(driver, 1000))
		    		  .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Dealmoon.com")));
		    //If the page change to RSS, the title should change
			String title = driver.getTitle();
			assertTrue(title.contains("Dealmoon.com - powered by FeedBurner"));
		}
		

}
