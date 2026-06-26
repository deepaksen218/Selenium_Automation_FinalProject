package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static final ExtentReports extentReports = new ExtentReports();
	// It is a  customized Detailed Extended Report 
	// A HTML report
	// Static instance of extented reports that can be shared accross the application,

	public synchronized static ExtentReports createExtentReports() {
		// a user defined method createExtentReports

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("7RMartSupermarketProject");
		extentReports.attachReporter(reporter);

		extentReports.setSystemInfo("Organization: ", "Obsqura");
		extentReports.setSystemInfo("Name :", "Aryan"); // provides context of the report
		extentReports.setSystemInfo("Team Members : ", "Alan, Arya, John, Leonie");
		return extentReports;

	}

}
