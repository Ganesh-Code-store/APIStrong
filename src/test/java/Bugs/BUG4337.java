package Bugs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BUG4337 {
	public static WebDriver driver;

	// Bug 4337: Login/Register: Facebook word is displayed on button as “facebook”

	static void facebook() {
		BaseClass.driver.get(BaseClass.url);
		BaseClass.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		String Fac=BaseClass.driver.findElement(By.xpath(BaseClass.face)).getText();
		
		if(Fac.contains("F"))
		{
			System.out.println("BUG-4337 should be closed");
		}
		else
		{
			System.out.println("BUG-4337 should be Reopened");
	
		}
		
		//BUG4418.placeHolder();
	}

	public static void main(String args[]) {
		new BaseClass().setup();
		new BUG4337().facebook();
		BaseClass.driver.quit();

	}

}
