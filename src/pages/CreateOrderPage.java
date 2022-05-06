package pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CreateOrderPage extends BasePage{
	static Xls_Reader reader = new Xls_Reader(".\\datafiles\\TD_002.xlsx");
	public static String Order = reader.getCellData("sheet", "Order", 2);
	public static String Product = reader.getCellData("sheet", "Product", 2);
	public static String Quantity = reader.getCellData("sheet", "Quantity", 2);
	public static String CustomerName = reader.getCellData("sheet", "CustomerName", 2);
	public static String Street = reader.getCellData("sheet", "Street", 2);
	public static String City = reader.getCellData("sheet", "City", 2);
	public static String State = reader.getCellData("sheet", "State", 2);
	public static String Zip = reader.getCellData("sheet", "Zip", 2);
	public static String Card = reader.getCellData("sheet", "Card", 2);
	public static String CardNr = reader.getCellData("sheet", "CardNr", 2);
	public static String Expiredate = reader.getCellData("sheet", "Expiredate", 2);
	public static String Process = reader.getCellData("sheet", "Process", 2);
	public static String Message1 = reader.getCellData("sheet", "Message1", 2);

	public void CreateOrder() throws InterruptedException 
	{
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("index2.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Extent Report Smart Bear Software");
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("Order Verification"); // create a test node in report

		// Order
		Click("//a[text() = 'Order']", Order);

		
		// Product
		Dropdown("//select[@id = 'ctl00_MainContent_fmwOrder_ddlProduct']", Product);
		test.log(Status.PASS, "Selecting dropdown");

		// Quantity
		setText("//input[@id = 'ctl00_MainContent_fmwOrder_txtQuantity']", Quantity);
		test.log(Status.PASS, "Entering Quantity");

		// Customer name
		setText("//input[@id = 'ctl00_MainContent_fmwOrder_txtName']", CustomerName);
		test.log(Status.PASS, "Entering Customer name");

		// Street
		setText("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox2']", Street);
		test.log(Status.PASS, "Entering Street");

		// City
		setText("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox3']", City);
		test.log(Status.PASS, "Entering City");

		// State
		setText("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox4']", State);
		test.log(Status.PASS, "Entering State");

		// Zip
		setText("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox5']", Zip);
		test.log(Status.PASS, "Entering Zip");

		// Card
		radioButton("//table[@id = 'ctl00_MainContent_fmwOrder_cardList']//td", Card);

		// Card Nr:
		setText("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox6']", CardNr);
		test.log(Status.PASS, "Card Nr");

		// Expire date (mm/yy):
		setText("//input[@id = 'ctl00_MainContent_fmwOrder_TextBox1']", Expiredate);
		test.log(Status.PASS, "Entering Zip");

		// Process
		Click("//a[@id = 'ctl00_MainContent_fmwOrder_InsertButton']", Process);

		test.log(Status.PASS, "Clicking Process button");

		// Validate Success message
		try {
			String Message = GetText("//a[@id = 'ctl00_MainContent_fmwOrder_InsertButton']/following-sibling::strong");
			test.log(Status.INFO, "Actual title  :" + Message);
			test.log(Status.INFO, "Expected Message  :" + Message1);

			if (Message.contains(Message1)) {
				test.log(Status.PASS, "Order successfully added");
				// create a test step node in report
			} else {
				test.log(Status.FAIL, "Order failed");
				// create a test step node in report
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Order failed");
		}
		extent.flush();
	}

	

}
