package Regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class BUG4250{
	// Bug 4250: Report: Source displayed blank for test in reports

	public boolean findSource() {

		try {
			BaseClass.driver.findElement(By.id(Locators.btnhistory)).click();
			Thread.sleep(4000);
			
			BaseClass.driver.findElement(By.xpath(Locators.ifsourceAPI));
			try {
				BaseClass.driver.findElement(By.linkText(BaseClass.APiname)).click();

				BaseClass.driver.findElement(By.xpath(Locators.Results)).click();
				BaseClass.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


				BaseClass.driver.findElement(By.xpath(Locators.ifsourceAPI));
				return true;

			} catch (Exception e2) {
				System.out.println("Source is not present in report");
				return false;
			}

		} catch (Exception e1) {
			System.out.println("Source is not present in history");
			System.out.println(e1);

		}

		return false;

	}

	public static void main(String args[]) throws InterruptedException {
		new BaseClass().setup();
		new BaseClass().Register();
		new BaseClass().GETAPI();
		new BaseClass().RunAPI();

		if (new BUG4250().findSource()) {
			System.out.println("BUG-4250 should be closed");
		} else {
			System.out.println("BUG-4250 should be Reopened");

		}
		BaseClass.driver.quit();

		
		//BUG4364.dailyCheckBox();


	}

}
