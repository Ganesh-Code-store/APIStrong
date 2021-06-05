package Regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BUG4903 extends BaseClass {
	
	
	public void chekresponse() throws InterruptedException {
		    
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    WebElement responsetab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btn_response)));
	    responsetab.click();

	    
		String response = BaseClass.findElement(json, "id").getText();

		if (response.contains("Unauthorized")) {
			System.out.println("Response is 401 in case username/password is wrong");
		} else if (response.contains("true")) {
			System.out.println("Response is 200-OK in case username/password is correct");

		}
		else
		{
			System.out.println(response);
			
		}

	}
	

	public void BaseAuth() throws InterruptedException {
		BaseClass.findElement(btnCreateTest, "id").click();
		BaseClass.findElement(crapi, "id").click();

		BaseClass.findElement(urlText, "id").sendKeys("https://postman-echo.com/basic-auth");

		Select st = new Select(BaseClass.findElement(authdrop, "xpath"));

		st.selectByVisibleText("Basic Auth");

		BaseClass.findElement("username", "id").sendKeys("postman");
		BaseClass.findElement("pwd", "id").sendKeys("password");

		BaseClass.findElement(saveapi, "id").click();

		Thread.sleep(4000);
		BaseClass.findElement(TestsMenu, "id").click();
		Thread.sleep(4000);

		boolean run = BaseClass.findElement(runapi, "id").isEnabled();

		if (run == true) {
			BaseClass.clickElement(runapi, "id");
		} else {
			Thread.sleep(5000);
		}

		chekresponse();
		

	}



	public void wrongusername() throws InterruptedException {
		driver.navigate().refresh();
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		BaseClass.findElement("username", "id").clear();
		BaseClass.findElement("username", "id").sendKeys("postma");
		boolean run1 = BaseClass.findElement(runapi, "id").isEnabled();

		if (run1 == true) {
			BaseClass.clickElement(runapi, "id");
		} else {
			Thread.sleep(5000);
		}
		chekresponse();

	}

	
	public void wrongpass() throws InterruptedException {
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		BaseClass.findElement("username", "id").clear();
		BaseClass.findElement("pwd", "id").clear();
		
		BaseClass.findElement("username", "id").sendKeys("postman");
		BaseClass.findElement("pwd", "id").sendKeys("passwor");
		
		boolean run1 = BaseClass.findElement(runapi, "id").isEnabled();

		if (run1 == true) {
			BaseClass.clickElement(runapi, "id");
		} else {
			Thread.sleep(5000);
		}
		chekresponse();

	}

	
	
	public static void main(String[] args) throws InterruptedException {

		try
		{
		BaseClass.setup();
		BaseClass.Register();
		new BUG4903().BaseAuth();
		new BUG4903().wrongusername();
		new BUG4903().wrongpass();
		driver.quit();
		}
		catch(Exception e)
		{
			System.out.println(e);
			driver.quit();
		}
		// new BUG4903().editAndRun();

	}

}
