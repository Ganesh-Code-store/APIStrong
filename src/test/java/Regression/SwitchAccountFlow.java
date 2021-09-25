package Regression;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SwitchAccountFlow extends BaseClass{
	
	public static final String mail=BaseClass.generateMail();
	
	void inviteUser() throws InterruptedException
	{
		driver.findElement(By.id(profilediv)).click();
		
		driver.findElement(By.xpath(account)).click();
		
		driver.findElement(By.id(invite)).click();
		
		driver.findElement(By.id(txtInviteEmail)).sendKeys(mail);
		
		driver.findElement(By.id(btnsendinvite)).click();
		Thread.sleep(3000);

		new BaseClass().Logout();
	}
	
	void acceptInvite() throws InterruptedException
	{
		
	    driver.navigate().to("https://www.mailinator.com/");
		driver.findElement(By.id(addOverlay)).sendKeys(this.mail);
		driver.findElement(By.id(gotopublic)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(supportmail)).click();
		Thread.sleep(3000);

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		List<WebElement> ls=driver.findElements(By.tagName("a"));
		
		for(WebElement f:ls)
		{
			System.out.println(f.getText());
		}
		
		driver.findElement(By.xpath(acceptInvite)).click();

		 
		driver.findElement(By.id(txtRegEmail)).sendKeys(this.mail);

		driver.findElement(By.id(txtRegPassword)).sendKeys("test12");
		driver.findElement(By.id(txtConfirmPassword)).sendKeys("test12");
		driver.findElement(By.id(txtCompany)).sendKeys(this.mail.replace("@mailinator.com", "a"));
		driver.findElement(By.id(regklogin)).click();
		driver.findElement(By.xpath(Skip)).click();
		
	
	}
	
	
	void switchAcc()
	{
		driver.findElement(By.xpath(switchit)).click();

	}

	
	
	public static void main(String args[])
	{
		try {
			new BaseClass().setup();
			BaseClass.Login("workflow@mailinator.com", "test12");			new SwitchAccountFlow().inviteUser();
			new SwitchAccountFlow().acceptInvite();
			new SwitchAccountFlow().switchAcc();
			driver.quit();
		}
		catch(Exception e)
		{
			driver.quit();
			System.out.println(e);
		}
		
		
		//new BaseClass().Register();
		
	}

}
