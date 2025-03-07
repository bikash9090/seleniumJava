package com.bksoft.actionsprograms;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.bksoft.base.Base;

public class MouseActions extends Base {
	@Test
	public void contextClick() {
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement btn = driver.findElement(By.cssSelector(".context-menu-one.btn.btn-neutral"));
		action.contextClick(btn).perform();
	}

	@Test
	public void contextClickAndPopUp() {
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo/disabled.html");
		WebElement btn = driver.findElement(By.cssSelector(".context-menu-one.btn.btn-neutral"));
		action.contextClick(btn).perform();
		driver.switchTo().alert().accept();
	}

	@Test
	public void fileUploadUsingRobot() {

		driver.get("https://the-internet.herokuapp.com/upload");
		WebElement uploadBtn = driver.findElement(By.xpath("//input[@id=\"file-upload\"]"));
		action.click(uploadBtn).perform();
		String path = "C:\\Users\\bikashs\\Downloads\\All_Manual_Questions.pdf";
		StringSelection selection = new StringSelection(path);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		try {
			Robot robot = new Robot();
			robot.delay(20);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(invocationCount = 3, description = "testing 'invocationCount' attribute")
	public void invocationCountTest() {
		System.out.println("Shiv");
	}

	@Test(timeOut = 500)
	public void failTest() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test()
	public void parentTest() {
		Assert.fail("Intentionally failling the test method.");
		System.out.println("Dependent method parent.");
	}

	@Test(dependsOnMethods = { "parentTest" }, alwaysRun = true)
	public void alwaysRunTest() {
		System.out.print("child method.");
	}

	@Test()
	public void scrollDownUsingJavaScript() {
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
	}

	@Test
	public void setSizeOfBrowser() {

		Dimension winSize = new Dimension(1300, 550);
		driver.manage().window().setSize(winSize);
		driver.get("https://google.com");
	}

	@Test
	public void handleAuthenticationPopUp() throws AWTException {
		driver.get("http://httpbin.org/basic-auth/user/pass");
		StringSelection username = new StringSelection("bikash");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
		
		Robot robot = new Robot();
		robot.delay(20);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
		StringSelection password = new StringSelection("shiv9090090000090");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(password, null);
		robot.keyPress(KeyEvent.VK_TAB);
		
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		
		
	}

}
