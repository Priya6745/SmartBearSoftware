package scenario;

import pages.CreateOrderPage;

public class TC_002 {
	CreateOrderPage cop = new CreateOrderPage();

	public void create() throws InterruptedException {
		cop.CreateOrder();
	}

}
