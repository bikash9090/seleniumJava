package com.bksoft.actionsprograms;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bksoft.base.Base;
import com.bksoft.utility.ScreenshotsUtility;

public class ActionsOnWebpage extends Base {

	@Test
	public void keyboardActions() {

	}

	@Test
	public void cssSelectorTest() {
		driver.get("https://demoqa.com/automation-practice-form");
		driver.findElement(By.cssSelector("[placeholder=\"First Name\"]")).sendKeys("Bikash");

	}

	@Test
	public void navigateTest() throws InterruptedException {
		driver.navigate().to("https://demoqa.com/automation-practice-form");
		driver.findElement(By.cssSelector("[placeholder=\"First Name\"]")).sendKeys("Bikash");
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
		driver.navigate().refresh();
	}

	@Test
	public void navigateToTest() throws URISyntaxException, MalformedURLException {
		URI uri = new URI("https://google.com");
		URL url = uri.toURL();
		ScreenshotsUtility scrObj = new ScreenshotsUtility(driver);

		driver.navigate().to(url);
		scrObj.captureScreenshot();

	}

	@Test
	public void handleWindowsTest() {
		driver.get("file:///C:/Users/bikashs/Desktop/html/New%20Text%20Document.html");
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		String parentWindow = driver.getWindowHandle();
		for(WebElement element:links) {
			element.click();
			driver.switchTo().window(parentWindow);
		}
		
	}

}
