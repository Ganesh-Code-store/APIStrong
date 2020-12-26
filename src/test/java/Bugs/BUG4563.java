package Bugs;

import org.openqa.selenium.By;

public class BUG4563 {
	//Bug 4563: API summary : message displayed when there is no run history for 
	//api "No API history found"
	
	void summary()
	{
		
	}
	public static void main(String args[])
	{
		new BaseClass().setup();
		new BaseClass().Register();
		BaseClass.driver.findElement(By.linkText(BaseClass.Skip)).click();
		new BaseClass().GETAPI();
		BaseClass.driver.findElement(By.linkText(BaseClass.repo)).click();

		


	}

}
