package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DeletePage extends BasePage {
	static Xls_Reader reader = new Xls_Reader(".\\datafiles\\TD_002.xlsx");
	public static String Username = reader.getCellData("sheet", "CustomerName", 2);
	public void DeleteOrder() throws Exception {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index4.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Report Smart Bear Software");
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("Delete created order"); // create a test node in report

		// validate created order		
		DeleteOrder(Username);
		test.log(Status.PASS, "Order deleted successfully");
		
		extent.flush();
	}

}
