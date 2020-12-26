package Bugs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class BUG4364 {
	//Bug 4364: UI\Maintenance\Recurrence: Radio button is not checked for default option “Daily”

	public static void dailyCheckBox() {

		BaseClass.driver.findElement(By.id(BaseClass.TestsMenu)).click();
		BaseClass.driver.findElement(By.id(BaseClass.txtSearch)).sendKeys(BaseClass.APiname);
		BaseClass.driver.findElement(By.xpath(BaseClass.testinSearch)).click();
		BaseClass.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		BaseClass.driver.findElement(By.id(BaseClass.testactionsdropdowntoggle)).click();
		BaseClass.driver.findElement(By.xpath(BaseClass.editAPI)).click();
		BaseClass.driver.findElement(By.id(BaseClass.btnmaitancewindow)).click();
		BaseClass.driver.findElement(By.id(BaseClass.addAlarmMaintenancePanel)).click();
		BaseClass.driver.findElement(By.id(BaseClass.recurrenceIcon)).click();
		WebElement ch = BaseClass.driver.findElement(By.xpath(BaseClass.dailyCheck));
		if (ch.isSelected()) {
			System.out.println("BUG-4364 should be closed");
		} else {
			System.out.println("BUG-4364 should be Reopened");
		}
		BaseClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	public static void main(String args[])
	{
		new BaseClass().setup();
		new BaseClass().Login();
		new BUG4364().dailyCheckBox();
		BaseClass.driver.quit();


	}


}
