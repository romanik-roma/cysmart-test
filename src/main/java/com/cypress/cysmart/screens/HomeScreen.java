package com.cypress.cysmart.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cypress.cysmart.screens.ui.ActionBar;
import com.cypress.cysmart.screens.ui.NavigationDrawer;
import com.google.common.base.Predicate;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * PageObjec class representing Home Screen of CySmart mobile application.
 *
 */
public class HomeScreen {

	private AppiumDriver<MobileElement> driver;

	@AndroidFindBy(id = "android:id/action_bar")
	private MobileElement actionBar;

	private NavigationDrawer navigationDrawer;

	HomeScreen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		waitUntilLoaded();
	}

	public boolean isActionBarShown() {
		return actionBar.isDisplayed();
	}

	public boolean isNavigationDrawerShown() {
		return navigationDrawer.isShown();
	}

	/**
	 * Provides access to action bar of this screen.
	 * 
	 * @return action bar
	 */
	public ActionBar actionBar() {
		return new ActionBar(actionBar);
	}

	/**
	 * Clicks on 'Hamburger' icon and provide access to 'Navigation Drawer'
	 * menu.
	 * 
	 * @return navigation drawer
	 */
	public NavigationDrawer getNavigationDrawer() {
		actionBar().tapOnHamburgerIcon();
		return this.navigationDrawer;
	}

	/**
	 * APP_ACTIVITY for this screen (Android specific).
	 */
	private static final String homePageActivity = ".HomePageActivity";

	/**
	 * Waits for this screen to load.
	 */
	private void waitUntilLoaded() {
		if (this.driver instanceof AndroidDriver<?>) {
			Predicate<WebDriver> p = d -> ((AndroidDriver<?>) d).currentActivity().equals(homePageActivity);
			new WebDriverWait(this.driver, 30).until(p);
		}
	}
}
