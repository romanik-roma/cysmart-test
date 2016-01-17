package com.cypress.cysmart.tools;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.VelocityContext;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.uncommons.reportng.HTMLReporter;

public class BaseHTMLReporter extends HTMLReporter implements ITestListener {

	private static final String UTILS_KEY = "utils";
	private static final ReportUtils REPORT_UTILS = new ReportUtils();

	protected VelocityContext createContext() {
		VelocityContext context = super.createContext();
		context.put(UTILS_KEY, REPORT_UTILS);
		return context;
	}

	private void createScreenshot(ITestResult result) {
		IMobileApp app;

		Object test = result.getInstance();
		if (test instanceof IMobileAppTest) {
			app = ((IMobileAppTest) test).getTestedAppInstance();
			if (app == null)
				return;
		} else {
			return;
		}

		File srcFile = app.getScreenshot();
		String baseFolder = "target/surefire-reports/";
		String screenFile = "html/" + LocalDate.now() + "/" + result.getName() + "_" + result.getEndMillis() + ".png";
		String relativePathToFile = baseFolder + screenFile;
		try {
			FileUtils.copyFile(srcFile, new File(relativePathToFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.setAttribute("screenshot", screenFile);
	}

	private void addDataInfo(ITestResult result) {
		Object test = result.getInstance();
		String logs = null;
		if (test instanceof IMobileAppTest) {
			logs = ((IMobileAppTest) test).getLogs();
		}
		if (logs != null && !logs.isEmpty() && !"null".equals(logs)) {
			result.setAttribute("data", logs);
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Start: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		createScreenshot(result);
		addDataInfo(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed: " + result.getInstanceName() + " : " + result.getName());
		createScreenshot(result);
		addDataInfo(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped: " + result.getInstanceName() + " : " + result.getName());
		createScreenshot(result);
		addDataInfo(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Start test: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finish: " + context.getName());
	}
}
