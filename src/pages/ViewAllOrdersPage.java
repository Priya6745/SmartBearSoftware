package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ViewAllOrdersPage extends BasePage {
	static Xls_Reader reader = new Xls_Reader(".\\datafiles\\TD_002.xlsx");
	public static String Username = reader.getCellData("sheet", "CustomerName", 2);
	
	public void VerifyOrder() throws Exception  {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index3.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Report Smart Bear Software");
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("Verify created order in view all orders"); // create a test node in report

		//Click View All orders
		Click("//a[text() = 'View all orders']", "yes");
		
		// validate created order
		String text = AssertTable(Username);
			
		if (text.equals("false")) {
			test.log(Status.FAIL, "Failure - Created order not deleted");
			// create a test step node in report
		} else {
			test.log(Status.PASS, "Success! Created order found in table");
			// create a test step node in report
		}
		extent.flush();
	}

	
	

}
