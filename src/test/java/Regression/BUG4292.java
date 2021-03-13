package Regression;

import org.openqa.selenium.By;

public class BUG4292 {
	
	//Bug 4292: API\History: duration displayed as “0 Sec”
	
	static void time() throws InterruptedException
	{
		new BaseClass().GETAPI();
		new BaseClass().RunAPI();
		
		BaseClass.driver.findElement(By.id(Locators.btnhistory)).click();
		String Dur=BaseClass.driver.findElement(By.xpath(Locators.duration)).getText();
		//System.out.println("Duration :"+Dur);
		if(Dur.contains("0"))
		{
			System.out.println("Bug-4292 should be Reopened");
		}
		else
		{

			System.out.println("Bug-4292 should be Closed");
		}
	}
	
	public static void main(String args[]) throws InterruptedException
	{
		new BaseClass().setup();
		new BaseClass().Register();
		new BUG4292().time();
		BaseClass.driver.quit();
	
	}

}
