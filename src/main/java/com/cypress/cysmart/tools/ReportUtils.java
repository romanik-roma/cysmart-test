package com.cypress.cysmart.tools;

import java.util.List;

import org.testng.ITestResult;
import org.uncommons.reportng.ReportNGUtils;

public class ReportUtils extends ReportNGUtils {

	@Override
	public List<String> getTestOutput(ITestResult result) {
		List<String> output = super.getTestOutput(result);

		String screenshot = (String) result.getAttribute("screenshot");
		if (screenshot != null) {
			output.add("<a href=\"../" + screenshot + "\">Screenshot</a>");
		}

		String user = (String) result.getAttribute("data");
		if (user != null) {
			output.add("<br>Test Data: " + user);
		}
		return output;
	}
}