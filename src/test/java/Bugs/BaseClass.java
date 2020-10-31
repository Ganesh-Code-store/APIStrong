package Bugs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass extends Locators {

	public static  WebDriver driver;

	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\urank\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	
	public void Register()
	{
		int num=(int) Math.ceil(Math.random()*10000);
		String email="qa"+num+"@mailinator.com";
		driver.get(reg);
		
		driver.findElement(By.id(txtRegEmail)).sendKeys(email);
		driver.findElement(By.id(txtRegPassword)).sendKeys("test12");
		driver.findElement(By.id(txtConfirmPassword)).sendKeys("test12");
		driver.findElement(By.id(txtCompany)).sendKeys("qa"+num);
		driver.findElement(By.id(regklogin)).click();


		
		
	}

	public void RunAPI() {

		BaseClass.APiname = driver.findElement(By.id(apiName)).getAttribute("value");
		driver.findElement(By.id(TestsMenu)).click();

		driver.findElement(By.id(txtSearch)).sendKeys(APiname);
		BaseClass.driver.findElement(By.xpath("//div[text()='"+this.APiname+"']")).click();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseClass.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.findElement(By.id(runapi)).click();
	}

	public void Login() {
		driver.get(url);
		driver.findElement(By.id(txtPassword)).sendKeys("test12");
		driver.findElement(By.id(login)).click();

	}

	public void GETAPI() {
		driver.findElement(By.id(btnCreateTest)).click();
		driver.findElement(By.id(crapi)).click();
		
		driver.findElement(By.id(urlText)).sendKeys(GETAPIUrl);
		driver.findElement(By.id(saveapi)).click();

	}

	public void POSTAPI() {
		driver.findElement(By.id(btnCreateTest)).click();

		Select drp = new Select(driver.findElement(By.id(httpMethodDropdown)));
		drp.selectByVisibleText("POST");
		driver.findElement(By.id(urlText)).sendKeys(POSTAPIUrl);
		driver.findElement(By.id(saveapi)).click();

	}

	public static void Logout() {
		driver.findElement(By.id(profilediv)).click();
		driver.findElement(By.linkText("Logout")).click();
	}

	public void quitBrowser() {
		driver.quit();
	}

	}
