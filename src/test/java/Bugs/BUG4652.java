package Bugs;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BUG4652 extends BaseClass {
	// Bug 4651: Import: cannot delete project with all api’s are deleted

	void importcoll() throws InterruptedException {
		int ind = 0;
		String[] apinames = new String[ind];

		driver.findElement(By.id(btnImport)).click();
		driver.findElement(By.id(UploadFolderFiles)).sendKeys(pkgstr);
		WebDriverWait wait=new WebDriverWait(driver, 20);

		WebElement projectlink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(ProjectMenu)));
		projectlink.click();

		//driver.findElement(By.id(ProjectMenu)).click();

		try {
			driver.findElement(By.xpath(collUrl)).click();
			String cnt = driver.findElement(By.xpath(APIcnt)).getText();

			for (int i = 0; i < cnt.length(); i++) {
				if (Character.isDigit(cnt.charAt(i))) {
					ind = Character.getNumericValue(cnt.charAt(i));

				}
			}
			System.out.println("Package imported:" + ind);

		} catch (Exception e) {
			System.out.println("Package not imported");
		}
		
		
		

		for(int i=0;i<ind;i++)
		{
			//Thread.sleep(3000);
			deleteAPI();
			Thread.sleep(2000);

			driver.findElement(By.id(ProjectMenu)).click();
			driver.findElement(By.xpath(collUrl)).click();

			
		}
		
	}
void deleteAPI() throws InterruptedException
{
	Thread.sleep(2000);

	String absuri=driver.findElement(By.xpath(absurilink)).getText();
	driver.findElement(By.id(TestsMenu)).click();
	driver.findElement(By.id(txtSearch)).sendKeys(absuri);
	BaseClass.driver.findElement(By.xpath(clickonapi)).click();
	Thread.sleep(2000);
	driver.findElement(By.id(testactionsdropdowntoggle)).click();
	driver.findElement(By.xpath(DeleteAPI)).click();
	
}

	void deleteColl() {
		driver.findElement(By.id(ProjectMenu)).click();
		driver.findElement(By.id(txtProjectSearch)).sendKeys("TestColl");
		
		driver.findElement(By.xpath(deleteproject)).click();
		driver.switchTo().alert().accept();
		
		try
		{
			driver.findElement(By.id(txtProjectSearch)).sendKeys("TestColl");
	
		driver.findElement(By.xpath(projectnotfound));
		System.out.println("BUG 4651 should be closed");
		}
		catch(Exception e)
		{
			System.out.println("BUG 4651 should be reopened");

		}

	}

	public static void main(String args[]) throws InterruptedException {
		new BaseClass().setup();
		new BaseClass().Login();
		new BUG4652().importcoll();
		new BUG4652().deleteColl();
		// BaseClass.driver.quit();

	}

}
