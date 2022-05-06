package scenario;

import pages.DeletePage;

public class TC_004 {
	DeletePage dp = new DeletePage();

	public void delete() throws Exception {
		dp.DeleteOrder();
	}
}
