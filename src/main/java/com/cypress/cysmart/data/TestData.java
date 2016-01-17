package com.cypress.cysmart.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class TestData {
	
	public static final String EXPECTED_HOME_SCREEN_TITLE = "BLE Devices";

	public static final List<String> EXPECTED_OPTIONS_IN_NAVIGATION_DRAWER;

	public static final List<String> EXPECTED_SUBMENU_OPTIONS_FOR_CYPRESS;

	static {
		EXPECTED_OPTIONS_IN_NAVIGATION_DRAWER = Collections
				.unmodifiableList(Arrays.asList("BLE Devices", "Cypress", "About"));

		EXPECTED_SUBMENU_OPTIONS_FOR_CYPRESS = Collections
				.unmodifiableList(Arrays.asList("Home", "BLE Products", "CySmart Mobile", "Contact Us"));
	}

	private TestData() {
	}
}
