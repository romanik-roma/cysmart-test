package cysmart.tests;

import static com.cypress.cysmart.data.TestData.EXPECTED_OPTIONS_IN_NAVIGATION_DRAWER;
import static com.cypress.cysmart.data.TestData.EXPECTED_SUBMENU_OPTIONS_FOR_CYPRESS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cypress.cysmart.screens.ui.NavigationDrawer;
import com.cypress.cysmart.tools.AbstractTest;

public class NavigationDrawerMenuTest extends AbstractTest {
	private NavigationDrawer navigationDrawer;

	@BeforeClass
	public void setUp() {
		navigationDrawer = cySmartApp.openOnHomeScreen().getNavigationDrawer();
	}

	@Test(priority = 1)
	public void testAvailableOptionsOnNavigationDrawerMenu() {
		assertTrue(navigationDrawer.isShown(), "\n'Navigation Drawer' is not shown.\n");
		assertEquals(navigationDrawer.getOptions(), EXPECTED_OPTIONS_IN_NAVIGATION_DRAWER,
				"\nIncorrect list of options in 'Navigation Drawer'.\n");
	}

	@Test(priority = 2)
	public void testAvailableSubmenuOptionsForCypress() {
		assertTrue(navigationDrawer.areCypressSubMenuOptionsShown(),
				"\nThere are no options shown under 'Cypress' menu item by default.\n");
		assertEquals(navigationDrawer.getCypressSubmenuOptions(), EXPECTED_SUBMENU_OPTIONS_FOR_CYPRESS,
				"\nIncorrect list of 'Cypress' sub-menu options.\n");
	}

	@Test(priority = 3)
	public void testHidingCypressSubmenuOptions() {
		navigationDrawer.tapOnOption("Cypress");

		assertFalse(navigationDrawer.areCypressSubMenuOptionsShown(),
				"\n'Cypress' submenu options remains displayed after tapping on 'Cypress'.\n");
	}

	@Test(priority = 4)
	public void testOpeningCypressSubmenuOptioins() {
		navigationDrawer.tapOnOption("Cypress");

		assertTrue(navigationDrawer.areCypressSubMenuOptionsShown(),
				"\n'Cypress' submenu options remains hidden after tapping on 'Cypress'.\n");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		cySmartApp.close();
	}
}
