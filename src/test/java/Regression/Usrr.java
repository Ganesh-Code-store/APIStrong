package Regression;

import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Usrr extends BaseClass {
	
	
	void goog()
	{
		driver.get("https://dev.apistrong.com/");
		
		driver.findElement(By.id("kc-login")).click();
		
	}

	public static void main(String[] args) {
		
		
		new BaseClass().setup();

		
	}

}
