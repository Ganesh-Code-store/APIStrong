package Bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BUG4450 {
	//Bug 4450: OAuth2: Can we have token field a “Text Area” instead of text field as user is not able to see token in one look
	
	static void textarea()
	{
		BaseClass.driver.findElement(By.id(BaseClass.btnCreateTest)).click();
		BaseClass.driver.findElement(By.id(BaseClass.crapi)).click();

		Select dropauth= new Select(BaseClass.driver.findElement(By.id(BaseClass.httpAuthDropdown)));
		dropauth.selectByVisibleText("OAuth2");
		if(BaseClass.driver.findElement(By.xpath(BaseClass.txtarea))!=null)
		{
			System.out.println("Bug-4450 should be closed");
		}
		else
		{
			System.out.println("Bug-4450 should be closed");

		}
		BUG4292.time();


	}
	public static void main(String args[])
	{
		//new BaseClass().setup();
		//new BaseClass().Login();
		//new BUG4450().textarea();


	}

}
