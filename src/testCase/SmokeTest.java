package testCase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BasePage;
import scenario.TC_001;
import scenario.TC_002;
import scenario.TC_003;
import scenario.TC_004;
import scenario.TC_005;

public class SmokeTest {

	@BeforeTest
	public void LaunchBrowser() {
		BasePage.BrowserLaunch();
	}

	@Test(priority = 0)
	public void LoginSmartbear() throws InterruptedException {
		TC_001 tc1 = new TC_001();
		tc1.loginToSmartBear();
	}

	@Test(priority = 1)
	public void OrderSmartbear() throws InterruptedException {
		TC_002 tc2 = new TC_002();
		tc2.create();
	}

	@Test(priority = 2)
	public void VerifyOrderSmartbear() throws Exception {
		TC_003 tc3 = new TC_003();
		tc3.verify();
	}

	@Test(priority = 3)
	public void DeleteOrderSmartbear() throws Exception {
		TC_004 tc4 = new TC_004();
		tc4.delete();
	}

	@Test(priority = 4)
	public void LogoutSmartbear() throws Exception {
		TC_005 tc5 = new TC_005();
		tc5.logout();
	}

	@AfterTest
	public void CloseDriver() {
		//BasePage.quit();

	}
}
