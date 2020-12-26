package Bugs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BUG4622 extends BaseClass{
	//Bug 4622: API Summary: showing Fail status for api which returns 201 response
	
	void creatAPI() throws InterruptedException
	{
		try
		{
		driver.findElement(By.xpath(Skip)).click();
		}
		catch(Exception e)
		{

		driver.findElement(By.id(btnCreateTest)).click();
		driver.findElement(By.id(crapi)).click();
		
		driver.findElement(By.id(urlText)).sendKeys("https://reqres.in/api/users");
		
		WebElement drp=driver.findElement(By.id(httpMethodDropdown));
		Select dropdown=new Select(drp);
		dropdown.selectByValue("POST");
		driver.findElement(By.id(saveapi)).click();
		Thread.sleep(3000);

		driver.findElement(By.id(sendapi)).click();
		Thread.sleep(3000);


		
	}
	}
	
	
	void Report() throws InterruptedException
	{
		driver.findElement(By.xpath(reports)).click();
		driver.findElement(By.xpath(APISum)).click();
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//span[@title='Success']")) != null)
		{
			System.out.println("Bug 4622 should be closed");
			
		}
		else
		{
			System.out.println("Bug 4622 should be Reponed");

		}
		driver.quit();

		
	}
	
	
	
	
	
	public static void main(String args[]) throws InterruptedException
	{
		new BaseClass().setup();
		new BaseClass().Register();
		new BUG4622().creatAPI();
		new BUG4622().Report();
		BaseClass.driver.quit();

		

	}

}
