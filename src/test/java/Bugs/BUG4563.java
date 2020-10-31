package Bugs;

import org.openqa.selenium.By;

public class BUG4563 {
	
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
