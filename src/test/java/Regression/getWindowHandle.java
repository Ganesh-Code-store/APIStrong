package Regression;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.collections.Sets;

public class getWindowHandle extends BaseClass {

	void window() throws InterruptedException {
		driver.get("https://www.naukri.com/mnjuser/homepage?utmContent=google-one-tap");

		String parent = driver.getWindowHandle();

		driver.findElement(By.xpath("//div[text()='Recruiters'][1]")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()='Companies']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()='Tools']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()='Services']")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()='More']")).click();

		Thread.sleep(3000);

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());

		System.out.println("Set :" + newTb);

		driver.switchTo().window(newTb.get(3));

	}

	public static void main(String args[]) {
		try {
			// new BaseClass().setup();
			new getWindowHandle().window();

		} catch (Exception e) {
		}
	}
}
