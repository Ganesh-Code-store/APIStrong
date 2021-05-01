package Regression;

import org.openqa.selenium.By;

public class forgotPassword extends BaseClass {
	
	void forgot()
	{
		driver.get("https://dev.apistrong.com/");
		driver.findElement(By.id(loginForgotPasswordlink)).click();
		driver.findElement(By.id(txtEmail)).sendKeys("testqa@mailinator.com");
	}
	
	void getTempCode()
	{
		driver.navigate().to("mailinator.com");
		driver.findElement(By.id(addOverlay)).sendKeys("testqa@mailinator.com");
		driver.findElement(By.id(gotopublic)).click();
		driver.findElement(By.id(gotopublic)).click();

	}
	
	
	public static void main(String args[])
	{
		new BaseClass().setup();
		new forgotPassword().forgot();
		new forgotPassword().getTempCode();
		
	}

}
