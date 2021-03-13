package Regression;

import java.awt.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class file_upload extends BaseClass {

	void upload() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id(body)).click();
		driver.findElement(By.xpath(form_data)).click();
		Thread.sleep(2000);

		for (int i = 1; i <= 5; i++) {
			String str = "btype_" + Integer.toString(i);
			String str1 = "bname_" + Integer.toString(i);
			String str2 = "bvalue_" + Integer.toString(i);	

			new Select(driver.findElement(By.id(str))).selectByVisibleText("File");

			driver.findElement(By.id(str1)).sendKeys("test" + Integer.toString(i));

			driver.findElement(By.id(str2)).sendKeys("E:\\CPP\\even.cpp");
			Thread.sleep(4000);
			driver.findElement(By.id(saveapi)).click();
			Thread.sleep(4000);
			driver.findElement(By.id(body)).click();
			driver.findElement(By.xpath(form_data)).click();

		}
		Thread.sleep(2000);

		java.util.List<WebElement> links = driver.findElements(By.tagName("a"));

		if (links.size() > 3) {
			System.out.println("File upload working fine");
		} else {
			System.out.println("There is error in file upload");

		}

	}

	public static void main(String args[]) throws InterruptedException {
		new BaseClass().setup();
		new BaseClass().Register();
		new BaseClass().GETAPI();
		Thread.sleep(3000);
		new file_upload().upload();

	}

}
