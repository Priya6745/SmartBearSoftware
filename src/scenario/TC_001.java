package scenario;

import pages.HomePage;
import pages.LoginPage;

public class TC_001 {

	LoginPage lp = new LoginPage();
	HomePage hp = new HomePage();

	public void loginToSmartBear() throws InterruptedException {
		lp.loginToApp();
		hp.verifyHomePage();
	}
}
