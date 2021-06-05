package Regression;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BUG4902 extends BaseClass {


	public void takeAtour() throws InterruptedException {

		for (int i = 0; i < 15; i++) {
			if (BaseClass.findElement(next, "xpath").isDisplayed()) {
				
				BaseClass.clickElement(next, "xpath");
				Thread.sleep(1000);

			} else {
				BaseClass.clickElement(done, "xpath");
				break;

			}
	
		}

	}


	public void Company() throws InterruptedException {
		BaseClass.clickElement(profilediv, "id");
		BaseClass.clickElement(account, "xpath");
		BaseClass.clickElement(help, "xpath");
		BaseClass.findElement(tour, "xpath");

		takeAtour();
		
	}

	public void UserInvites() throws InterruptedException {
		driver.navigate().refresh();
		BaseClass.clickElement(invite, "id");
		BaseClass.clickElement(help, "xpath");
		BaseClass.findElement(tour, "xpath");

		takeAtour();
		

	}

	public void Plan() throws InterruptedException {
		driver.navigate().refresh();

		BaseClass.clickElement(plan, "id");
		BaseClass.clickElement(help, "xpath");
		BaseClass.findElement(tour, "xpath");

		takeAtour();
		

	}

	public void payment() throws InterruptedException {
		driver.navigate().refresh();

		BaseClass.clickElement(payment, "id");
		BaseClass.clickElement(help, "xpath");
		BaseClass.findElement(tour, "xpath");

		takeAtour();
		
	}

	public static void main(String args[]) {
		try {
			BaseClass.setup();
			BaseClass.Login();
			new BUG4902().Company();
			new BUG4902().UserInvites();
			new BUG4902().Plan();
			new BUG4902().payment();

			driver.quit();
		} catch (Exception e) {
			System.out.println(e);
			// driver.quit();
		}

	}
}
