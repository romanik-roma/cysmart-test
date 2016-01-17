package com.cypress.cysmart.screens.ui;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.Widget;

public abstract class AbstractWidget extends Widget {

	AbstractWidget(WebElement wrappedElement) {
		super(wrappedElement);
		PageFactory.initElements(new AppiumFieldDecorator(wrappedElement), this);
	}

	public boolean isShown() {
		return getWrappedElement().isDisplayed();
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
