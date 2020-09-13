
package com.renato.selenium.cap1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SamplePageTest {

	
	
	private WebDriver driver;
	
	@Before
	public void setUp() {

		System.setProperty("webdriver.gecko.driver", "/home/renato/geckodriver");
        this.driver = new FirefoxDriver();
        driver.get("https://www.testandquiz.com/selenium/testing.html");
		
	}
	@Test
	public void findElementByLinkText() {
		driver.findElement(By.linkText("This is a link")).click();
		Assert.assertEquals("https://www.javatpoint.com/", driver.getCurrentUrl());
	}
	@Test 
	public void findSubmitButtonAndClickOnIt() {
		driver.findElement(By.id("fname")).sendKeys("Fluminense");
		driver.findElement(By.id("idOfButton")).click();
		
	}

	@Test
	public void findingRadioButtonAndCheckingMale() {
		driver.findElement(By.id("male")).click();
	}
	
	//scrollingDown and using Select
	@Test
	public void ScrollingDownAndUsingSelectToFindVisibleText() {
		Select scroll = new Select(driver.findElement(By.id("testingDropdown")));
		scroll.selectByVisibleText("Automation Testing");
	}
	
	//usando css selector pra achar a CheckBox e marcar
	
	public void usingCssSelectorToFindCheckBoxAndCheckIt() {
		driver.findElement(By.cssSelector("input.Automation")).click();
	}
	
	
	@After
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}
}
