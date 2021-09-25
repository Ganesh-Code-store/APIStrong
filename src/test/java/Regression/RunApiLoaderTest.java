package Regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class RunApiLoaderTest extends BaseClass{

	
	public void runAPILoader() throws InterruptedException
	{
		BaseClass.clickElement(TestsMenu, "id");
		Thread.sleep(5000);
		BaseClass.clickElement(runapi, "css");
		
		String margin=BaseClass.findElement(apirunLoader, "id").getAttribute("margin");
		
		
		
		Assert.assertNotNull(margin, "Loader is not centralized to see");
		
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		
		try
		{
			BaseClass.setup();
			BaseClass.Login("workflow@mailinator.com", "test12");			new RunApiLoaderTest().runAPILoader();
			driver.quit();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			driver.quit();
		}



	}

}
