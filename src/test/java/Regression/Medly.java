package Regression;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Medly extends BaseClass{
	
	
	void testExe() throws InterruptedException
	{
		driver.get("https://www.linkedin.com/developers/");
		Thread.sleep(3000);
		
		List ls=driver.findElements(By.tagName("a"));
		
		System.out.println("No of links on page :"+ls.size());
		
	}
	
	void menus() throws InterruptedException
	{

		String ParentTitle=this.driver.getTitle();
		
		String parent=driver.getWindowHandle();
		 
		driver.findElement(By.linkText("About")).click();
		
		String child=driver.getWindowHandle();
		Thread.sleep(5000);
		
		String Childtitle=driver.switchTo().window(child).getTitle();
		//s=this.driver.getTitle();
		
		
	
		driver.switchTo().window(parent);
		
		System.out.println(ParentTitle);
		System.out.println(Childtitle);

		
		Assert.assertEquals(ParentTitle, Childtitle);
		
		System.out.println("Titles are not correct");
	}
	
	public static void main(String args[]) throws InterruptedException
	{
		
		new BaseClass().setup();
		new Medly().testExe();
		new Medly().menus();
		
		
	}

}
