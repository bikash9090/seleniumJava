package com.bksoft.seleniumwaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.bksoft.base.Base;

public class ExplicitWait extends Base {

	@Test
	public void explicitWaitTest() {
		driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");
		By byStartBtn = By.xpath("//button[@id=\"button00\"]");
		WebElement startBtn = waitForPresenceOfElementLocated(byStartBtn);
		WebElement oneBtn = driver.findElement(By.xpath("//button[@id=\"button01\"]"));
		WebElement twoBtn = driver.findElement(By.id("button02"));
		WebElement threeBtn = driver.findElement(By.id("button03"));

		startBtn.click();
		waitUntilClickableWithInterval(oneBtn, 1);
		oneBtn.click();

		waitUntilClickableWithInterval(twoBtn, 1);
		twoBtn.click();

		waitUntilClickableWithInterval(threeBtn, 1);
		threeBtn.click();

	}
}
