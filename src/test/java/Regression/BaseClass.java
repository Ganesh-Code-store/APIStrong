package Regression;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass extends Locators {

	public static  WebDriver driver;

	public void setup() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\User\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}
	
	public String generateMail()
	{
		final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";		
	    int count=10;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
		int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
		builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		String email=builder.toString()+"@mailinator.com";
		System.out.println(email);
		return email;

	}
	
	public void Register()
	{
		String email1=generateMail();
		

      	driver.get(reg);
		
		driver.findElement(By.id(txtRegEmail)).sendKeys(email1);

		driver.findElement(By.id(txtRegPassword)).sendKeys("test12");
		driver.findElement(By.id(txtConfirmPassword)).sendKeys("test12");
		driver.findElement(By.id(txtCompany)).sendKeys(email1.replace("@mailinator.com", "a"));
		driver.findElement(By.id(regklogin)).click();
		driver.findElement(By.xpath(Skip)).click();
		
	}
	

	private WebElement findElement(By id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void RunAPI() throws InterruptedException {

		BaseClass.APiname = driver.findElement(By.id(apiName)).getAttribute("value");
		driver.findElement(By.id(TestsMenu)).click();
        Thread.sleep(2000);
		driver.findElement(By.id(txtSearch)).sendKeys(APiname);
		BaseClass.driver.findElement(By.xpath("//div[text()='"+this.APiname+"']")).click();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(4000);
		driver.findElement(By.id(runapi)).click();
	}

	public void Login() {
		driver.get(url);
		driver.findElement(By.id(txtEmail)).sendKeys("workflow@mailinator.com");

		
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
		driver.findElement(By.id(crapi)).click();

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
