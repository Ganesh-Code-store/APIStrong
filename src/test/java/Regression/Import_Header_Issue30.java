package Regression;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Import_Header_Issue30 extends BaseClass{
	
	void import_coll()
	{
		driver.findElement(By.id(btnImport)).click();
		driver.findElement(By.id(UploadFolderFiles)).sendKeys(pkgstr);
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

	}
	
	void verifyHeader() throws InterruptedException
	{
		popup();
	    //Thread.sleep(150000); //2minss
		driver.findElement(By.id(TestsMenu)).click();
		driver.findElement(By.id(txtSearch)).sendKeys("API with Header");
		driver.findElement(By.xpath("//div[text()='API with Header']")).click();
	    driver.findElement(By.id(btnparams)).click();
		String keyname=driver.findElement(By.name("keyName")).getAttribute("value");
		String keyvalue=driver.findElement(By.name("values")).getAttribute("value");
		
		if(keyname.contains("User-Agent")&&keyvalue.contains("Awesome-Octocat-App"))
		{
			System.out.println("Header key and value is not encrypted");
		}
		else
		{
			System.out.println("Header key and value are encrypted");
			System.out.println("Key:"+keyname+"value :"+keyvalue);
		}
	}
	
	void popup() throws InterruptedException
	{
		WebElement li=driver.findElement(By.id("Form-UploadFile"));
		int cnt=10;
		
		while(li.isDisplayed()==true &&cnt<10)
		{
			Thread.sleep(10000);
			cnt++;
		}
	}
	

	public static void main(String[] args) {

		try
		{
			new BaseClass().setup();
			new BaseClass().Register();
			new Import_Header_Issue30().import_coll();
			//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			new Import_Header_Issue30().verifyHeader();
			driver.quit();
		}
		catch(Exception e)
		{
			System.out.println(e);
			driver.quit();
		}
	}

}
