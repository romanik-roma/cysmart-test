package com.cypress.cysmart.screens.ui;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.Widget;

/**
 * Abstract Class to represent Widget (compound UI element) for a mobile
 * application. It supports the PageObject extension in Appium added in version
 * 3.3.0 of appium java-client.
 *
 */
public abstract class AbstractWidget extends Widget {

	AbstractWidget(WebElement wrappedElement) {
		super(wrappedElement);
		PageFactory.initElements(new AppiumFieldDecorator(wrappedElement), this);
	}

	/**
	 * Check if this widget is shown.
	 * 
	 * @return true if root element of this Widget is shown on screen
	 */
	public boolean isShown() {
		return this.isElementShown(getWrappedElement());
	}

	/**
	 * Returns true if and only if this element is present in DOM and is
	 * displayed.
	 * 
	 * @param element
	 *            WebElement to check for visibility
	 * @return true if and only if this element is present in DOM and is
	 *         displayed
	 */
	protected boolean isElementShown(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		} catch (StaleElementReferenceException e) {
			return isElementShown(element);
		}
	}
}
