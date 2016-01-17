package com.cypress.cysmart.screens;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cypress.cysmart.tools.Driver;
import com.cypress.cysmart.tools.IMobileApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CySmart implements IMobileApp {

	private AppiumDriver<MobileElement> driver;

	public HomeScreen openOnHomeScreen() {
		this.driver = Driver.startNewInstance();
		return new HomeScreen(this.driver);
	}

	public File getScreenshot() {
		if (driver == null)
			return null;

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		return takesScreenshot.getScreenshotAs(OutputType.FILE);
	}

	/**
	 * Closes the application and quits.
	 */
	public void close() {
		driver.closeApp();
		driver.quit();
	}
}
