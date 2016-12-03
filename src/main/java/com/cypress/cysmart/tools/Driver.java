package com.cypress.cysmart.tools;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * An abstraction to represent mobile driver.
 *
 */
public class Driver {
	private final static String fileSeparator = System.getProperty("file.separator");
	private final static String userDir = System.getProperty("user.dir");
	private final static String platformName = System.getProperty("platform", "android").toLowerCase();

	/**
	 * Returns a new instance of {@link AppiumDriver}
	 * 
	 * @return new appium driver instance
	 */
	public static synchronized AppiumDriver<MobileElement> startNewInstance() {
		AppiumDriver<MobileElement> driver = null;

		switch (platformName) {
		case "android":
			driver = startAndroidDriver();
			break;
		case "ios":
			driver = startIosDriver();
			break;
		default:
			throw new IllegalArgumentException("Unknown platform: " + platformName);
		}

		return driver;
	}

	/**
	 * Helper method to initialize new instance of {@link AndroidDriver}
	 * 
	 * @return instance of android driver
	 */
	private static AndroidDriver<MobileElement> startAndroidDriver() {
		AndroidDriver<MobileElement> driver = null;
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), androidCapabilities());
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
		return driver;
	}

	/**
	 * TODO: to implement for iOS platform
	 * 
	 * @return
	 */
	private static IOSDriver<MobileElement> startIosDriver() {
		throw new NotImplementedException("Not yet implemented for iOS platform");
	}

	/**
	 * Construct and returns instance of {@link DesiredCapabilities} for
	 * Android.
	 * 
	 * @return DesiredCapabilities object for Android platform
	 */
	private static DesiredCapabilities androidCapabilities() {
		DesiredCapabilities caps = new DesiredCapabilities();

		String pathToApk = userDir + fileSeparator + "apk" + fileSeparator + "CySmart_1.1.1.68_8.apk";
		File app = new File(pathToApk);
		caps.setCapability(MobileCapabilityType.APP, app);

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.0.2");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy A3");
		// caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android
		// Emulator");
		// caps.setCapability(AndroidMobileCapabilityType.AVD, "Nexus_api_21");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.cypress.cysmart");
		// caps.setCapability(MobileCapabilityType.APP_PACKAGE,
		// "com.cypress.cysmart");
		return caps;
	}
}
