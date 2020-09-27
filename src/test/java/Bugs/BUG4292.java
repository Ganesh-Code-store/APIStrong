package Bugs;

import org.openqa.selenium.By;

public class BUG4292 {
	
	static void time()
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
	
	public static void main(String args[])
	{
		//new BaseClass().setup();
		//new BaseClass().Login();
		//new BUG4292().time();
	
	}

}
