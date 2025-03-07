package com.bksoft.actionsprograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.bksoft.base.Base;

public class IframeTest extends Base {
	@FindBy(xpath = "//section//input[@type='text']")
	WebElement textBox;

	@Test
	public void singleIframe() {
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		WebElement mulIframe = driver.findElement(By.xpath("//a[@href=\"#Multiple\"]"));
		WebElement singleIframe = driver.findElement(By.xpath("//a[@href=\"#Single\"]"));
		PageFactory.initElements(driver, this);
		// WebElement textBox =
		// driver.findElement(By.xpath("//section//input[@type='text']"));

		driver.switchTo().frame("SingleFrame");

		textBox.sendKeys("hello");

	}

	@Test
	public void multipleIframe() {
		driver.get("https://demo.automationtesting.in/Frames.html");
		driver.manage().window().maximize();
		WebElement mulIframe = driver.findElement(By.xpath("//a[@href=\"#Multiple\"]"));

		By textBox = By.xpath("//div[@class=\"row\"]//input");
		By mulFrameText = By.xpath("/html/body/section/div/div/h5");

		mulIframe.click();

		WebElement fbook = driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div/div[2]/a[1]"));
		action.moveToElement(fbook).perform();
		mulIframe.click();
		
		driver.findElement(By.cssSelector(".col-xs-6.col-xs-offset-5 input[type='text']")).sendKeys("Hello");
	}
}
