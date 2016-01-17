package com.cypress.cysmart.screens.ui;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.Widget;

public class ActionBar extends Widget {

	@AndroidFindBy(id = "android:id/up")
	private MobileElement hamburgerIcon;

	@AndroidFindBy(id = "android:id/action_bar_title")
	private MobileElement actionBarTitle;

	public ActionBar(MobileElement wrappedElement) {
		super(wrappedElement);
		PageFactory.initElements(new AppiumFieldDecorator(wrappedElement), this);
	}

	public boolean isHamburgerIconShown() {
		return hamburgerIcon.isDisplayed();
	}

	public String getTitle() {
		return this.actionBarTitle.getText();
	}

	public void tapOnHamburgerIcon() {
		this.hamburgerIcon.tap(1, 100);
	}
}
