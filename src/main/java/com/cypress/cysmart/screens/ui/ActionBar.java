package com.cypress.cysmart.screens.ui;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * PageObject for Action Bar widget of CySmart mobile application.
 *
 */
public class ActionBar extends AbstractWidget {

	@AndroidFindBy(id = "android:id/up")
	private MobileElement hamburgerIcon;

	@AndroidFindBy(id = "android:id/action_bar_title")
	private MobileElement actionBarTitle;

	public ActionBar(MobileElement wrappedElement) {
		super(wrappedElement);
	}

	public boolean isHamburgerIconShown() {
		return hamburgerIcon.isDisplayed();
	}

	/**
	 * Returns title of this action bar
	 * 
	 * @return title
	 */
	public String getTitle() {
		return this.actionBarTitle.getText();
	}

	/**
	 * Performs tap on 'Hamburger' icon of this action bar.
	 */
	public void tapOnHamburgerIcon() {
		this.hamburgerIcon.tap(1, 100);
	}
}
