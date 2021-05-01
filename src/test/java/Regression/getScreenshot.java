package Regression;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

public class getScreenshot extends BaseClass{
	
	
	void Screenshot(String fileName) throws IOException
	{
		driver.get("https://dev.apistrong.com/");
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    Files.copy(file,new File("E:\\eclipse-workspace\\APIStrong\\src\\test\\java\\snaps//"+fileName+".jpg"));
	    
	}
	public static void main(String args[]) throws IOException
	{
		try
		{
			new BaseClass().setup();
		    new getScreenshot().Screenshot("APIStrong1");
		    driver.quit();
		}
		catch(Exception e)
		{
			driver.quit();
			System.out.println(e);
		}
			
	}

}
