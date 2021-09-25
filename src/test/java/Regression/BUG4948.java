package Regression;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BUG4948 extends BaseClass {
	String frq = "";
	String pageNo = "";

	@Test(priority = 1)
	public void setBrowser() {
		BaseClass.setup();
	}

	@Test(priority = 2)
	public void LoginToApp() {
		BaseClass.Login("sch@mailinator.com", "test12");
	}

	@Test(priority = 3)
	public void TestLogic() throws InterruptedException {

		BaseClass.clickElement(repo, "id");
		BaseClass.clickElement(schedules, "xpath");
		Thread.sleep(3000);
		BaseClass.clickElement(page, "xpath");
		pageNo = BaseClass.findElement(page, "xpath").getText();

		System.out.println("Page no :" + pageNo);

		BaseClass.clickElement(apirowedit, "xpath");

		// driver.switchTo().alert();
		Thread.sleep(3000);
		if (BaseClass.findElement(minCheck, "xpath").isSelected()) {
			BaseClass.clickElement(hrCheck, "xpath");
			Thread.sleep(2000);

			frq = BaseClass.findElement("//div[@id='next-run-dates']//div[1]", "xpath").getText();
			System.out.println(frq);

		} else {
			BaseClass.clickElement(minCheck, "xpath");
			Thread.sleep(2000);

			frq = BaseClass.findElement("//div[@id='next-run-dates']//div[1]", "xpath").getText();
			System.out.println(frq);

		}
		BaseClass.clickElement(saveSch, "id");
	}

	@Test(priority = 4)
	public void assertions() {
		Assert.assertTrue(
				BaseClass.findElement("//div[@id='next-run-dates']//div[1]", "xpath").getText().contains(frq));

		Assert.assertEquals(BaseClass.findElement(page, "xpath").getText(), pageNo);

		System.out.println("BUGG4948 should be closed");

	}

}
