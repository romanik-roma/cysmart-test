package com.cypress.cysmart.screens;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cypress.cysmart.tools.Driver;
import com.cypress.cysmart.tools.IMobileApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

/**
 * Abstraction to represent CySmart app as a mobile app for testing
 *
 */
public class CySmart implements IMobileApp {

	private AppiumDriver<MobileElement> driver;

	/**
	 * Opens app on a real device and returns an instance to {@link HomeScreen}.
	 * Provides access to home screen
	 * 
	 * @return home screen
	 */
	public HomeScreen openOnHomeScreen() {
		this.driver = Driver.startNewInstance();
		return new HomeScreen(this.driver);
	}

	/**
	 * Returns screenshot of the current view of the application as a file.
	 * 
	 * @return a file representing screenshot of the app, or {@code null} if
	 *         underlying driver is null
	 */
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
