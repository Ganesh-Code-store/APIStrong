package Regression;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WorkFlow_Report extends BaseClass {
	
	void Workflow() throws InterruptedException
	{
		driver.findElement(By.xpath(dropdownSubMenureport)).click();
		driver.findElement(By.xpath(Workflows)).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(links)).click();
		repoVerif();
		
	}
	
	void repoVerif()
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath(WorkflowHistory)).click();
		driver.findElement(By.xpath(firstLink)).click();
		
		try
		{
			driver.findElement(By.xpath(strong));
			driver.findElement(By.xpath(last24hr));	
			driver.findElement(By.xpath(last7days));	
			driver.findElement(By.xpath(Last30days));	
			driver.findElement(By.id(lnkResult)).click();
			driver.findElement(By.xpath(total));	


			System.out.println("Test succeed");

			
		}
		catch(Exception e)
		{
			System.out.println("Test Failed");
		}

	}
	
	public static void main(String args[])
	{
		try
		{
			new BaseClass().setup();
			BaseClass.Login("workflow@mailinator.com", "test12");			new WorkFlow_Report().Workflow();
			driver.quit();

				
		}
		catch(Exception e)
		{
			System.out.println(e);
			driver.quit();
		}
	
		
	}
}
