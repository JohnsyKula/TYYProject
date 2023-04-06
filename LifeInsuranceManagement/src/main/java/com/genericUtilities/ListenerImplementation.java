package com.genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	


	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		//Excution starts from here
		String methodName=result.getMethod().getMethodName();
		test = report.createTest(methodName);
		Reporter.log(methodName+"---->Test execution started");

	}
	public void onTestSuccess(ITestResult result) {
       String methodName=result.getMethod().getMethodName();
       test.log(Status.PASS, methodName+"------>passed"); //--->This is used to print in the extent report
       Reporter.log(methodName+"---->Testscript execution successful");
       
	}
	
	public void onTestFailure(ITestResult result) {
//		String FScript=result.getMethod().getMethodName();
//		String FS=FScript+new JavaUtility().getSystemDate();
//		EventFiringWebDriver edriver=new EventFiringWebDriver(Baseclass.sdriver);
//		File src=edriver.getScreenshotAs(OutputType.FILE);
//		File dst=new File("./Screenshot/"+FS+".png");
//		try {
//			FileUtils.copyFile(src, dst);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		try {
			String screenshotname=WebDriverUtility.getScreenShot(Baseclass.sdriver, result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotname);
		} catch (IOException e) {
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("Testscript execution failed",true);
		
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"----->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("Testscript Execution Skipped");

	}
	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		htmlreport.config().setDocumentTitle("SDET-47 Batch");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("INSURANCE");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser","chrome");
		report.setSystemInfo("OS", "windows");
		report.setSystemInfo("Base_URL", "https://localhost:8888");
		report.setSystemInfo("Reporter Name", "Johnsy");
		
	}

	public void onFinish(ITestContext context) {
    //consolidate the report
		report.flush();
		
	}
	
	
	
	

}
