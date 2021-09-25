package Regression;

import java.util.List;

import org.openqa.selenium.WebElement;

public class DatePicker extends BaseClass {
	
	
	
	public void iteratDates() throws InterruptedException
	{
		BaseClass.clickElement(btnPicker, "id");
		
		List<WebElement> ls=BaseClass.findElements(dates, "xpath");
		
		
		for(WebElement ls1:ls)
		{
			System.out.println(ls1.getText());
			
		
			try {
				ls1.click();
				Thread.sleep(5000);
				BaseClass.clickElement(btnPicker, "id");				

			}
			catch(Exception e)
			{
				
			}

		}

	}
	
	
	public static void main(String args[]) throws InterruptedException
	{
		BaseClass.setup();
		BaseClass.Login("workflow@mailinator.com", "test12");		new DatePicker().iteratDates();
	}

}
