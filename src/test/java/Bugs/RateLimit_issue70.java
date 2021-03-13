package Bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RateLimit_issue70 extends BaseClass {
	
	void testCluster() throws InterruptedException
	{
		Thread.sleep(2000);

		driver.findElement(By.xpath(dropdownSubMenureport)).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText(ThreatProtection)).click();
		driver.findElement(By.xpath(rateLimit)).click();
		
		Thread.sleep(3000);
		
		if(driver.findElement(By.id(clusterwidechk)).isEnabled())
		{
			System.out.println(driver.findElement(By.id(clusterwidechk)).isEnabled());

			System.out.println("Element is enabled");
		}
		else
		{
			System.out.println("Element is disabled");

		}
				
	}

	public static void main(String[] args) throws InterruptedException {
		
		new BaseClass().setup();
		new BaseClass().Login();
		new RateLimit_issue70().testCluster();
		driver.quit();
		
	}

}
