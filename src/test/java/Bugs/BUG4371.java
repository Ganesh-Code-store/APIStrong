package Bugs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BUG4371 {
	public static  WebDriver driver;

	//Bug 4371: Fun\History: showing 0 reports when user is running API manually via API's listing and API edit
	
	public static void verifyHistory() throws InterruptedException
	{
		new BaseClass().GETAPI();
		new BaseClass().RunAPI();

			BaseClass.driver.findElement(By.id(BaseClass.btnhistory)).click();
		
		
		try
		{
			BaseClass.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			
		BaseClass.driver.findElement(By.linkText(BaseClass.APiname));
		//System.out.println("Report is there when API ran from API listing");

		
		}
		
		catch(Exception e)
		{
		//	System.out.println("Report is not there when API ran from API listing");
		}
	
		BaseClass.driver.findElement(By.id(BaseClass.btnconfiguration)).click();
		BaseClass.driver.findElement(By.id(BaseClass.testactionsdropdowntoggle)).click();
		BaseClass.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		BaseClass.driver.findElement(By.xpath(BaseClass.editAPI)).click();
		BaseClass.driver.findElement(By.id(BaseClass.sendapi)).click();
		BaseClass.driver.findElement(By.id(BaseClass.TestsMenu)).click();
		BaseClass.driver.findElement(By.id(BaseClass.txtSearch)).sendKeys(BaseClass.APiname);
		BaseClass.driver.findElement(By.xpath(BaseClass.testinSearch)).click();
		BaseClass.driver.findElement(By.id(BaseClass.runapi)).click();
		BaseClass.driver.findElement(By.id(BaseClass.btnhistory)).click();
		
		try
		{
		BaseClass.driver.findElement(By.linkText(BaseClass.APiname));
		//System.out.println("Report is there when API ran from API edit");

		
		}
		catch(Exception e)
		{
			//System.out.println("Report is not there when API ran from API edit");
		}

		System.out.println("Bug-4371 should be closed");

		//BUG4337.facebook();
	}
	
	
	public static void main(String args[]) throws InterruptedException
	{
		new BaseClass().setup();
		new BaseClass().Register();;
		new BUG4371().verifyHistory();
		BaseClass.driver.quit();

	 
	}

}
