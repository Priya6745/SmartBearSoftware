package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	public static WebDriver driver;
	public static String browser = "chrome";

	// Launch Browser
	@SuppressWarnings("deprecation")
	public static void BrowserLaunch() {
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"D:\\Official\\Training\\SetupFile\\Chromedriver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/Login.aspx?ReturnUrl=%252fsamples%252ftestcomplete10%252fweborders%252f");
	}

	// Click
	public static void Click(String Value, String Data) {
		if (Data != "" && Data.toLowerCase().equals("yes")) {
			driver.findElement(By.xpath(Value)).isDisplayed();
			driver.findElement(By.xpath(Value)).click();
		}
	}

	// Text input
	public static void setText(String Value, String Data) throws InterruptedException {
		Thread.sleep(2000);
		if (Data != "") {
			driver.findElement(By.xpath(Value)).sendKeys(Data);
		}
	}

	// Element Found
	public static boolean elementDisplayed(String Value) {
		boolean result = true;
		try {
			result = driver.findElement(By.xpath(Value)).isDisplayed();
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	// RadioButton
	public static void radioButton(String Value, String Data) {
		if (Data != "") {
			List<WebElement> Radiobutton_Count = driver.findElements(By.xpath(Value));
			for (int i = 1; i <= Radiobutton_Count.size(); i++) {
				String val = driver.findElement(By.xpath(Value + "[" + i + "]/label")).getText();
				if (val.toLowerCase().equals(Data.toLowerCase())) {
					driver.findElement(By.xpath(Value + "[" + i + "]/input")).click();
					break;
				}
			}
		}
	}

	// ListBox
	public static void ListBox(String Data) {
		if (Data != "") {
			String[] Data_Split = Data.split(",");
			for (int k = 0; k <= Data_Split.length - 1; k++) {
				List<WebElement> ListBox_Count = driver
						.findElements(By.xpath("//*[@id='exampleFormControlSelect2']/option"));
				for (int i = 1; i <= ListBox_Count.size(); i++) {
					String val = driver
							.findElement(By.xpath("(//*[@id='exampleFormControlSelect2']/option)[" + i + "]"))
							.getText();
					if (val.toLowerCase().equals(Data_Split[k].toLowerCase())) {
						Actions action = new Actions(driver);
						action.sendKeys(Keys.CONTROL).build().perform();
						driver.findElement(By.xpath("(//*[@id='exampleFormControlSelect2']/option)[" + i + "]"))
								.click();
						break;
					}
				}
			}
		}
	}

	// DropDown
	public static void Dropdown(String Value, String Data) {
		if (Data != "") {
			Select select = new Select(driver.findElement(By.xpath(Value)));
			select.selectByVisibleText(Data);
		}
	}

	// GetText
	public static String GetText(String Value) {
		String data = driver.findElement(By.xpath(Value)).getText();
		return data;
	}

	// GetTitle
	public static String GetTitle() {
		return driver.getTitle();

	}

	// GetText
	public static void quit() {
		driver.quit();
	}

	public static String AssertTable(String data) throws Exception {
		String status;
		String text = driver.findElement(By.xpath("//table[@class = 'SampleTable']//tr[2]//td[2]")).getText();
		if (text.toLowerCase().equals(data.toLowerCase())) {
			status = "true";
		} else {
			status = "false";
		}

		return status;
	}

	public static void DeleteOrder(String data) {
		String text = driver.findElement(By.xpath("//table[@class = 'SampleTable']//tr[2]//td[2]")).getText();
		if (text.toLowerCase().equals(data.toLowerCase())) {

			driver.findElement(By.xpath("//table[@class = 'SampleTable']//tr[2]//td[1]")).click();

		}
	}

	public static String VerifyTable(String data) {
		String status = "true";
		List<WebElement> count = driver.findElements(By.xpath("//table[@class = 'SampleTable']//tr//td[2]"));
		for (int i = 1; i <= count.size(); i++) {
			String text = driver.findElement(By.xpath("//table[@class = 'SampleTable']//tr[" + i + "]//td[2]"))
					.getText();
			if (text.toLowerCase().equals(data.toLowerCase())) {

				status = "false";
				break;
			}

		}
		return status;
	}

}
