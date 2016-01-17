package cysmart.tests;

import static com.cypress.cysmart.data.TestData.EXPECTED_HOME_SCREEN_TITLE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cypress.cysmart.screens.HomeScreen;
import com.cypress.cysmart.tools.AbstractTest;

public class ActionBarOnHomePageTest extends AbstractTest {
	private HomeScreen homeScreen;

	@BeforeClass
	public void setUp() {
		homeScreen = cySmartApp.openOnHomeScreen();
	}

	@Test(priority = 1)
	public void testHomeScreenActionBarTitle() {
		assertTrue(homeScreen.isActionBarShown(), "\nAction bar is not shown on Home page.\n");
		assertEquals(homeScreen.actionBar().getTitle(), EXPECTED_HOME_SCREEN_TITLE, "\nIncorrect action bar title.\n");
	}

	@Test(priority = 2)
	public void testHomeScreenActionBarHamburgerIcon() {
		assertTrue(homeScreen.actionBar().isHamburgerIconShown(),
				"\n'Hamburger' icon is not shown on the action bar.\n");

		homeScreen.actionBar().tapOnHamburgerIcon();

		assertTrue(homeScreen.isNavigationDrawerShown(),
				"\n'Navigation Drawer' menu is not shown after tapping 'Hamburger' icon.\n");
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		cySmartApp.close();
	}
}
