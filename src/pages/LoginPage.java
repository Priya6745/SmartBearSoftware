package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import pages.Xls_Reader;

public class LoginPage extends BasePage {

	static Xls_Reader reader = new Xls_Reader(".\\datafiles\\TD_001.xlsx");
	public static String Username = reader.getCellData("sheet", "Username", 2);
	public static String Password = reader.getCellData("sheet", "Password", 2);
	public static String LoginButton = reader.getCellData("sheet", "LoginButton", 2);

	public void loginToApp() throws InterruptedException {
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index1.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Report Smart Bear Software");
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("Login Page"); // create a test node in report

		// UserName
		setText("//input[@id = 'ctl00_MainContent_username']", Username);
		test.log(Status.PASS, "Entering UserName");

		// Password
		setText("//input[@id = 'ctl00_MainContent_password']", Password);
		test.log(Status.PASS, "Entering Password");

		// Login button
		Click("//input[@id = 'ctl00_MainContent_login_button']", LoginButton);
		test.log(Status.PASS, "Clicking Login Button");
		
		extent.flush();
	}
	

}
