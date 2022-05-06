package scenario;

import pages.ViewAllOrdersPage;

public class TC_003 {
	ViewAllOrdersPage va = new ViewAllOrdersPage();

	public void verify() throws Exception {
		va.VerifyOrder();
	}
}
