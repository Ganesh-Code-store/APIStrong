package Regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Maintenance_Mode_Issue6 extends BaseClass {
	
	void testColor() throws InterruptedException
	{
		Thread.sleep(2000);
		//for(int i=0;i<50;i++)
		//{

		String colorName1="rgba(129, 209, 53, 1)";
		

		driver.findElement(By.xpath(dropdownSubMenureport)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(AlarmMaintanceWindow)).click();
		driver.findElement(By.id(newMaintennaceMode)).click();
		WebElement element=driver.findElement(By.id(addAlarmMaintenancePanel));
		
		String colorName=element.getCssValue("background-color");
		System.out.println("Color name :"+colorName);
		
		if(colorName1.contains(colorName))
		{
			System.out.println("Both colors are same ! No issue...");

		}
		else
		{
			System.out.println("Both colors are not same ! issue is there report to Pooja...");

		}
		
		
		//}
		
	}

	public static void main(String[] args) throws InterruptedException {

		new BaseClass().setup();
		new BaseClass().Login();
		new Maintenance_Mode_Issue6().testColor();
		driver.quit();
		
	}

}
