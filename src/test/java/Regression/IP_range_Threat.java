package Regression;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class IP_range_Threat extends BaseClass {
	public String myIP;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	String getIP() {
		driver.get("http://www.whatismyip.com/");
		myIP = driver.findElement(By.id("ipv4")).getText();
		System.out.println(myIP);
		return myIP;
	}

	void testIP(String ip) throws InterruptedException {
		driver.findElement(By.id(btn_api_threatprotection)).click();
		driver.findElement(By.xpath(ipcollapse)).click();
		Thread.sleep(3000);

		js.executeScript("window.scrollBy(0,1000)");

		driver.findElement(By.id(ip_range_from)).sendKeys(ip);
		Thread.sleep(3000);
		driver.findElement(By.id(saveipaddressrange)).click();
		driver.navigate().refresh();
	}

	void runExposed() throws InterruptedException {

		driver.findElement(By.id(btn_api_threatprotection)).click();
		Thread.sleep(3000);

		driver.findElement(By.id(callexposeapi)).click();
		Thread.sleep(7000);

		String resCode = driver.findElement(By.id(response_code)).getText();
		System.out.println("response code:" + resCode);

		if (resCode.contains("401") == true) {
			Thread.sleep(6000);
			driver.findElement(By.id(btn_response)).click();

			String APIResponse = driver.findElement(By.id(response_info)).getText();

			System.out.println("API response :" + APIResponse);

			if (APIResponse.contains("Message is failing because the request is coming from a banned IP range")) {
				System.out.println("IP threat working fine");
			} else {
				System.out.println("IP threat not working fine");
			}

		} else {
			System.out.println("Threat protection criteria not met");
		}
	}
	public static void main(String[] args) throws InterruptedException {
		try {
			new BaseClass().setup();
			String ip=new IP_range_Threat().getIP();
			new BaseClass().Register();
			new BaseClass().GETAPI();
			new BaseClass().RunAPI();
			new IP_range_Threat().testIP(ip);
			// new BaseClass().Login();
			new IP_range_Threat().runExposed();
			driver.quit();
		} catch (Exception e) {
			System.out.println(e);
			driver.quit();
		}

	}

}
