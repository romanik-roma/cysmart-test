package com.cypress.cysmart.screens.ui;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

@AndroidFindBy(id = "com.cypress.cysmart:id/navigation_drawer")
public class NavigationDrawer extends AbstractWidget {

	@AndroidFindBy(id = "com.cypress.cysmart:id/title")
	private List<MobileElement> options;

	@AndroidFindBy(id = "com.cypress.cysmart:id/lblListItem")
	private List<MobileElement> cypressSubMunuOptions;

	public NavigationDrawer(MobileElement wrappedElement) {
		super(wrappedElement);
	}

	/**
	 * Checks if number of options is greater than 0 and all of them are
	 * visible.
	 * 
	 * @return true if there are some options and all of them visible
	 */
	public boolean areMenuOptionsShown() {
		return options.size() > 0 && options.stream().allMatch(o -> this.isElementShown(o));
	}

	/**
	 * Returns list of strings representing available options in
	 * NavigationDrawer.
	 * 
	 * @return list of options
	 */
	public List<String> getOptions() {
		return options.stream().map(MobileElement::getText).collect(Collectors.toList());
	}

	/**
	 * Checks if number of Cypress sub-menu options is greater than 0 and all of
	 * them are visible.
	 * 
	 * @return true if there are some sub-menu options for Cypress menu item,
	 *         and all of them visible
	 */
	public boolean areCypressSubMenuOptionsShown() {
		return cypressSubMunuOptions.size() > 0 && cypressSubMunuOptions.stream().allMatch(o -> this.isElementShown(o));
	}

	/**
	 * Returns list of strings representing available options under Cypress menu
	 * item.
	 * 
	 * @return list of Cypress sub-menu options
	 */
	public List<String> getCypressSubmenuOptions() {
		return cypressSubMunuOptions.stream().map(MobileElement::getText).collect(Collectors.toList());
	}

	public NavigationDrawer tapOnOption(String option) {
		Objects.requireNonNull(option, "\nOption to select must not be null\n");
		int index = getOptions().indexOf(option);
		if (index == -1)
			throw new IllegalArgumentException("There is no such option: '" + option + "'");

		options.get(index).tap(1, 100);

		return this;
	}
}
