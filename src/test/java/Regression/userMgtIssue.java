package Regression;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class userMgtIssue extends BaseClass {
	void user(String emailOfUser2) throws InterruptedException {
		driver.findElement(By.xpath(dropdownSubMenureport)).click();
		driver.findElement(By.xpath(useMgt)).click();
		driver.findElement(By.id(btnCreateNewUser)).click();

		driver.findElement(By.id(FirstNamein)).sendKeys(emailOfUser2.replace("@mailinator.com", "a"));
		driver.findElement(By.id(LastNamein)).sendKeys(emailOfUser2.replace("@mailinator.com", "a"));
		driver.findElement(By.id(EmailAddressin)).sendKeys(emailOfUser2);
		driver.findElement(By.id(SaveUser)).click();
	}

	void forgotUser(String emailOfUser2) throws InterruptedException {
		driver.findElement(By.id(loginForgotPasswordlink)).click();
		driver.findElement(By.id(txtEmail)).sendKeys(emailOfUser2);
		driver.findElement(By.id(regklogin)).click();

		Thread.sleep(2000);
		String validMsg = driver.findElement(By.xpath(forgotValid)).getText();
		System.out.println(validMsg);

		if (validMsg.contains("Please verify email address first.")) {
			System.out.println("User mgt flow is working fine");
		} else {
			System.out.println("User mgt flow is not working fine");

		}

	}

	public static void main(String args[]) {
		String emailOfUser;

		try {
			new BaseClass().setup();
			new BaseClass().Register();
			emailOfUser = new BaseClass().generateMail();

			new userMgtIssue().user(emailOfUser);
			new BaseClass().Logout();
			new userMgtIssue().forgotUser(emailOfUser);

			driver.quit();
		} catch (Exception e) {
			System.out.println(e);
			driver.quit();
		}
		{

		}
	}

}
