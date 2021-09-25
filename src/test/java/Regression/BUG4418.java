package Regression;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

public class BUG4418 {
	//Bug 4418: UI\Create user: there are no placeholders for any field

	static void placeHolder() {
		BaseClass.Login("workflow@mailinator.com", "test12");
		BaseClass.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		BaseClass.driver.findElement(By.xpath(BaseClass.dropdownSubMenureport)).click();
		BaseClass.driver.findElement(By.xpath(BaseClass.useMgt)).click();
		BaseClass.driver.findElement(By.id(BaseClass.btnCreateNewUser)).click();

		if (BaseClass.driver.findElement(By.id(BaseClass.FirstName)).getAttribute("placeholder") != null) {
			if (BaseClass.driver.findElement(By.name(BaseClass.LastName)).getAttribute("placeholder") != null) {
				if (BaseClass.driver.findElement(By.id(BaseClass.EmailAddress)).getAttribute("placeholder") != null) {
					System.out.println("Bug-4418 should be closed");

				}
			}
		}
		else
		{
			System.out.println("Bug-4418 should be Reopened");

		}
		//BUG4450.textarea();
	}

	public static void main(String args[]) {
		new BaseClass().setup();
	 new BUG4418().placeHolder();
		BaseClass.driver.quit();

	}

}
