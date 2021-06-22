package Regression;

import org.openqa.selenium.By;

public class Assertion extends BaseClass{
	
	
	public void test() throws InterruptedException
	{
		
		for(int i=0;i<3;i++)
		{
			
			try
			{
				Thread.sleep(3000);
				
				driver.get("https://www.google1.com/");
				
				if(driver.findElement(By.id("reload-button")).isDisplayed())
				{
					System.out.println("Website is not responding");
				}
				else
				{
					System.out.println("Website is responding");

				}
				
			}
			catch(Exception e)
			{
				System.out.println("Web site is not responding");
			}
		}
		
		
		
		
		
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		BaseClass.setup();
		new Assertion().test();

		
	}

}
