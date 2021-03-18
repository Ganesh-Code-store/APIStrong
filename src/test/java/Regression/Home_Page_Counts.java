package Regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import Regression.BaseClass;

public class Home_Page_Counts extends BaseClass {
	int total_hits=0;
	int success=0;
	int Fail=0;
	int Total_usage=0;
	 void countChecks() throws InterruptedException
	{
		driver.findElement(By.xpath(Home)).click();
		Thread.sleep(5000);

		int totalhits=Integer.parseInt(driver.findElement(By.id(userRuns)).getText());
		int successful=Integer.parseInt(driver.findElement(By.id(userSuccessRuns)).getText());
		int Failure=Integer.parseInt(driver.findElement(By.id(userFailRuns)).getText());
		String str=driver.findElement(By.id(perUsage)).getText();
		int Totaluse=Character.getNumericValue(str.charAt(0));
		
		
		if(totalhits>total_hits && totalhits<(total_hits)+2)
		{
			System.out.println("Total hits count inreased by 1 :"+totalhits);

			if(successful>success && successful<(success)+2)
			{
				System.out.println("Success hits count inreased by 1 :"+successful);
				 
				if(Failure==0)
				{
					System.out.println("Failure count is 0 :"+Failure);
					
					if(Totaluse>Total_usage && Totaluse<(Total_usage)+2)
					{
						System.out.println("Total usage count inreased by 1 :"+Totaluse);

					}
					else
					{
						System.out.println("Total usage count not inreased by 1 "+Totaluse);

					}
				}
				else
				{
					System.out.println("Failure count is not 0 "+Failure);
	
				}
			}
			else
			{
				System.out.println("Success hits not count inreased by 1 :"+successful);
			}
		}
		else  
		{
			System.out.println("Total hits count not inreased by 1 :"+totalhits+" "+total_hits);

		}
		
		
		total_hits=Integer.parseInt(driver.findElement(By.id(userRuns)).getText());
		success=Integer.parseInt(driver.findElement(By.id(userSuccessRuns)).getText());
		Failure=Integer.parseInt(driver.findElement(By.id(userFailRuns)).getText());
		String str1=driver.findElement(By.id(perUsage)).getText();
		Total_usage=Character.getNumericValue(str1.charAt(0));
		

	}
	
	public static void main(String args[]) throws InterruptedException
	{
		try
		{
			new BaseClass().setup();
			new BaseClass().Register();
			
			new BaseClass().GETAPI();
			new BaseClass().RunAPI();

			new Home_Page_Counts().countChecks();

			new BaseClass().POSTAPI();

			new BaseClass().RunAPI();

			new Home_Page_Counts().countChecks();
			driver.quit();
		}
		catch(Exception e)
		{
			System.out.println(e);
			driver.quit();
		}
				
		
		
		
		
	}

}
