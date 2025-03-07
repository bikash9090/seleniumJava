package com.bksoft.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotsUtility {
	private WebDriver driver;

	public ScreenshotsUtility(WebDriver driver) {
		this.driver = driver;
	}

	public void captureScreenshot(){
		TakesScreenshot tksObj = (TakesScreenshot) driver;
		File source = tksObj.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "\\screenshots\\abc.png");
		
		try {
			FileUtils.copyFile(source,destination);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
