package Bugs;

import org.openqa.selenium.By;

public class practical extends Locators {
	
	public static void main(String args[])
	{
		new BaseClass().setup();

		int num=(int) Math.ceil(Math.random()*10000);
		String email="qa"+num+"@mailinator.com";
		BaseClass.driver.get(reg);
		
		BaseClass.driver.findElement(By.id(txtRegEmail)).sendKeys(email);
		BaseClass.driver.findElement(By.id(txtRegPassword)).sendKeys("test12");
		BaseClass.driver.findElement(By.id(txtConfirmPassword)).sendKeys("test12");
		BaseClass.driver.findElement(By.id(txtCompany)).sendKeys("qa"+num);
		BaseClass.driver.findElement(By.id(regklogin)).click();

	}

}
