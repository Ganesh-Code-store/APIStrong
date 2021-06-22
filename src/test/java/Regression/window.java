package Regression;

import java.awt.Window;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class window extends BaseClass {
	
	
	void test()
	{
		driver.get("https://dev.apistrong.com/");
		

		
		driver.findElement(By.id("loginForgotPasswordlink")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		
		List sls=(List) driver.getWindowHandles();
		
		
		driver.switchTo().window((String) sls.get(1));
		
		
		
	
	}

	public static void main(String[] args) {

		BaseClass.setup();
		new window().test();
		
	}

}
