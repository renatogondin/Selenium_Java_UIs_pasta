package com.renato.selenium.cap1;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleSearchTest {

	
	
	private WebDriver driver;
	@Before
	public void setUp() {

		System.setProperty("webdriver.gecko.driver", "/home/renato/geckodriver");
        this.driver = new FirefoxDriver();
		
	}
	@Test
	public void testGoogleSearch() {
		
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.get("http://google.com");  
        
        WebElement element = driver.findElement(By.name("q"));
        
        element.clear();
        
        element.sendKeys("Fluminense Football Club");
		
        element.submit();
		
        Assert.assertEquals("Google", driver.getTitle());
		
	}
	@Test
	public void testGoogleClicking() {
		
		
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        
        driver.get("http://google.com");  
        
        
        driver.findElement(By.name("q")).sendKeys("Gentle Giant");  
        
        
        driver.findElement(By.name("btnK")).click();  
        
		
		
	}
	@Test
	public void testingNumberOfLinksElements() {
		driver.get("http://google.com"); 
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		Assert.assertEquals(19, links.size());
		
		for(WebElement link : links) {
			System.out.println(link.getAttribute("href"));
		}
		
		
	}
	
	
	@After
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}
}
