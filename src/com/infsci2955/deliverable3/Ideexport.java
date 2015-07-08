package com.infsci2955.deliverable3;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Ideexport {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://stackoverflow.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testIdeexport() throws Exception {
    driver.get(baseUrl + "/users/signup");
    driver.findElement(By.id("display-name")).clear();
    driver.findElement(By.id("display-name")).sendKeys("juz21");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("juz21@pitt.edu");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("123456");
    driver.findElement(By.name("password2")).clear();
    driver.findElement(By.name("password2")).sendKeys("123456");
    assertEquals("Please add one of the following things to make your password stronger:", driver.findElement(By.cssSelector("span > p")).getText());
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
