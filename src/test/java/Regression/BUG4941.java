package Regression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BUG4941 extends BaseClass {
	
	public static void CreateStep() throws InterruptedException
	{
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id(ExecFlow)));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(AddNewStep))).click();

		Thread.sleep(3000);
		BaseClass.enterText(urlTextStep, "name","https://gorest.co.in/public-api/users");
		BaseClass.findElement(apiName, "name").clear();
		BaseClass.enterText(apiName, "name","step");
		BaseClass.clickElement(saveapi, "id");


		Thread.sleep(5000);
		boolean flag=BaseClass.findElement(stepidentify, "xpath").isDisplayed();
		
		if(flag==true)
		{
			System.out.println("Step is created");
			
		}
		else
		{
			System.out.println("Step is not created");
		}
		
		
	}
	
	

	public static void main(String[] args) throws InterruptedException {
		
		try
		{
			BaseClass.setup();
			BaseClass.Register();
			for(int i=0;i<5;i++)
			{
				BaseClass.GETAPI();
					
			}
			
			new Workflow_Creation().CreateWorkFlow();
			new Workflow_Creation().AddAPIsToWorkflow();
			
			new BUG4941().CreateStep();
			BaseClass.quitBrowser();
				
		}
		catch(Exception e)
		{
			System.out.println(e);
			BaseClass.quitBrowser();
		}
		

	}

}