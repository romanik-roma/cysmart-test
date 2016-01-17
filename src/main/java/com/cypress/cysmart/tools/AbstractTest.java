package com.cypress.cysmart.tools;

import com.cypress.cysmart.screens.CySmart;

public class AbstractTest implements IMobileAppTest {

	protected StringBuilder logger = new StringBuilder();
	protected CySmart cySmartApp = new CySmart();

	protected AbstractTest() {
	}

	@Override
	public IMobileApp getTestedAppInstance() {
		return this.cySmartApp;
	}

	public String getLogs() {
		return String.valueOf(logger);
	}
}