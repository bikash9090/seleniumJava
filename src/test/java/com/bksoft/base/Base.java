package com.bksoft.base;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	protected WebDriver driver;
	protected WebDriverWait wait;
	FluentWait<WebDriver> fwait;
	protected Actions action;

	@BeforeMethod
	public void initBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		fwait = new FluentWait<WebDriver>(driver);
		action = new Actions(driver);

	}

	@AfterMethod
	public void closeBrowser() {
		// driver.quit();
	}

	protected void waitUntilClickableOf(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void waitUntilClickableOf(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	protected void waitUntilVisibilityOf(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void waitUntilVisibilityOf(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	protected WebElement waitForPresenceOfElementLocated(By locator) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	protected void waitUntilClickableWithInterval(WebElement element, int poolingtime) {
		fwait.withTimeout(Duration.ofSeconds(30))
		.pollingEvery(Duration.ofSeconds(poolingtime))
		.ignoring(NoSuchElementException.class)
		.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void scrollToElement(WebElement element) {
		action.moveToElement(element).build().perform();
	}
}
