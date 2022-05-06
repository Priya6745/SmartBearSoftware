package pages;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pages.Xls_Reader;

public class HomePage extends BasePage {

	static Xls_Reader reader = new Xls_Reader(".\\datafiles\\TD_001.xlsx");
	public static String Title = reader.getCellData("sheet", "Title", 2);

	public void verifyHomePage() {
		
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index1.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Report Smart Bear Software");
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("Login Verification"); // create a test node in report

		
		// Validate Landing page
		String AppTitle = GetTitle();

		if (AppTitle.equals(Title)) {
			test.log(Status.PASS, "Login Successful - actual and expected title matched");
			// create a test step node in report
		} else {
			test.log(Status.FAIL, "Login Failed - actual and expected title Mismatch");
			// create a test step node in report
		}
		
		extent.flush();
	}
}
