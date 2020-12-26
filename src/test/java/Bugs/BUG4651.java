package Bugs;

import org.openqa.selenium.By;

public class BUG4651 extends BaseClass{
	//Bug 4651: Import: cannot delete project with all api’s are deleted
	
	
	void importcoll() throws InterruptedException
	{
		int ind=0;
		driver.findElement(By.id(btnImport)).click();
		driver.findElement(By.id(UploadFolderFiles)).sendKeys(pkgstr);
		
		Thread.sleep(3000);
		driver.findElement(By.id(ProjectMenu)).click();
		
		try
		{
			driver.findElement(By.xpath("//a[Contains("+this.pkgstr+",'@title=CollectionForTesting')]")).click();
			String cnt=driver.findElement(By.xpath(APIcnt)).getText();
			
			for(int i=0;i<cnt.length();i++)
			{
				if(Character.isDigit(cnt.charAt(i)))
				{
					ind=Character.getNumericValue(cnt.charAt(i));
					
				}
			}
			
			for(int i=0;i<ind;i++)
			{
				driver.findElement(By.xpath(apilist)).click();
				driver.findElement(By.id(testactionsdropdowntoggle)).click();
				driver.findElement(By.id(DeleteAPI)).click();	
				driver.findElement(By.id(ProjectMenu)).click();
				driver.findElement(By.xpath("//a[Contains("+this.pkgstr+",'@title=CollectionForTesting')]")).click();


	
			}


		}
		catch(Exception e)
		{
			System.out.println("Package not imported");
		}
		
		


	}
	
	void deleteColl()
	{
		driver.findElement(By.id(ProjectMenu)).click();
		driver.findElement(By.id(txtProjectSearch)).sendKeys();


		

	}
	
	
	public static void main(String args[]) throws InterruptedException
	{
		new BaseClass().setup();
		new BaseClass().Login();
		new BUG4651().importcoll();
		new BUG4651().deleteColl();
		BaseClass.driver.quit();
		
			
	
	}

}
