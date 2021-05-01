package Regression;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Action extends BaseClass{
	
	public static void act()
	{
		Actions acti=new Actions(driver);
		
		
		
		driver.get(url);
		
		
		acti.sendKeys(driver.findElement(By.id(txtEmail)),"workflow@mailinator.com").perform();	
		acti.click(driver.findElement(By.id(login))).perform();	
		
	}

	public static void main(String args[]) {
		
		
		new BaseClass().setup();
		new Action().act();
		

	}

}
