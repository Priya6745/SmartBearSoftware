package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class LogoutPage extends BasePage{
	public void Logout() {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index5.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Report Smart Bear Software");
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("Logout Verification"); // create a test node in report
		String Title = "Web Orders Login";
		// Logout button
		Click("//a[@id = 'ctl00_logout']", "yes");
		
		// Validate Title
		String AppTitle = GetTitle();
		test.log(Status.INFO, "Actual title  :" + AppTitle);
		test.log(Status.INFO, "Expected title  :" + Title);

		if (AppTitle.equals(Title)) {
			test.log(Status.PASS, "Logout Successful - actual and expected title matched");
			// create a test step node in report
		} else {
			test.log(Status.FAIL, "Logout Failed - actual and expected title Mismatch");
			// create a test step node in report
		}
		extent.flush();
	}
}
