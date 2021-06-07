package Regression;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class BaseClass extends Locators {

	public static WebDriver driver;

	public static void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	public static void enterText(String locator, String locatorType, String value) {
		if (locatorType.contains("id")) {
			driver.findElement(By.id(locator)).sendKeys(value);
		} else if ((locatorType.contains("xpath"))) {
			driver.findElement(By.xpath(locator)).sendKeys(value);

		}
		else if ((locatorType.contains("name"))) {
			driver.findElement(By.name(locator)).sendKeys(value);

		}
		else if ((locatorType.contains("className"))) {
			driver.findElement(By.className(locator)).sendKeys(value);

		}
	}
	
	public static void clickElement(String locator, String locatorType) {
		if (locatorType.contains("id")) {
			driver.findElement(By.id(locator)).click();
		} else if ((locatorType.contains("xpath"))) {
			driver.findElement(By.xpath(locator)).click();

		}
		else if ((locatorType.contains("name"))) {
			driver.findElement(By.name(locator)).click();

		}
		else if ((locatorType.contains("className"))) {
			driver.findElement(By.className(locator)).click();

		}
		else if ((locatorType.contains("css"))) {
			driver.findElement(By.cssSelector(locator)).click();

		}
		
		
		
		
		
	}
	
	
	
	public static WebElement findElement(String locator, String locatorType) {
		if (locatorType.contains("id")) {
			return driver.findElement(By.id(locator));
		} else if ((locatorType.contains("xpath"))) {
			return driver.findElement(By.xpath(locator));

		}
		else if ((locatorType.contains("name"))) {
			return driver.findElement(By.name(locator));

		}
		else if ((locatorType.contains("className"))) {
			return driver.findElement(By.className(locator));

		}
		return null;
	
	}
	
	public static List<WebElement> findElements(String locator, String locatorType) {
		if (locatorType.contains("id")) {
			return driver.findElements(By.id(locator));
		} else if ((locatorType.contains("xpath"))) {
			return driver.findElements(By.xpath(locator));

		}
		else if ((locatorType.contains("name"))) {
			return driver.findElements(By.name(locator));

		}
		else if ((locatorType.contains("className"))) {
			return driver.findElements(By.className(locator));

		}
		return null;
	
	}
		
	
	
	
	
	
	
	public static String todaysDate()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		
		String Today=dtf.format(now);
		return Today;
		
	}
	
		
	
	
	public static void print(String message)
	{
		System.out.println(message);
	}
		


	public static String generateMail() {
		final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		int count = 10;
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		String email = builder.toString() + "@mailinator.com";
		System.out.println(email);
		return email;

	}

	void Screenshot(String fileName) throws IOException {
		driver.get("https://dev.apistrong.com/");
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File("E:\\eclipse-workspace\\APIStrong\\src\\test\\java\\snaps//" + fileName + ".jpg"));

	}

	public static void Register() {
		String email1 = generateMail();

		driver.get(reg);

		driver.findElement(By.id(txtRegEmail)).sendKeys(email1);

		driver.findElement(By.id(txtRegPassword)).sendKeys("test12");
		driver.findElement(By.id(txtConfirmPassword)).sendKeys("test12");
		driver.findElement(By.id(txtCompany)).sendKeys(email1.replace("@mailinator.com", "a"));
		driver.findElement(By.id(regklogin)).click();
		driver.findElement(By.xpath(Skip)).click();
		driver.findElement(By.xpath(Gotit)).click();

	}
	
	

	public void RunAPI() throws InterruptedException {
		Thread.sleep(4000);

		BaseClass.APiname = driver.findElement(By.id(apiName)).getAttribute("value");
		driver.findElement(By.id(TestsMenu)).click();
		Thread.sleep(2000);
		driver.findElement(By.id(txtSearch)).sendKeys(APiname);
		BaseClass.driver.findElement(By.xpath("//div[text()='" + this.APiname + "']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(4000);
		driver.findElement(By.id(runapi)).click();
	}

	public static void Login() {
		driver.get(url);
		driver.findElement(By.id(txtEmail)).sendKeys("workflow@mailinator.com");

		driver.findElement(By.id(txtPassword)).sendKeys("test12");
		driver.findElement(By.id(login)).click();


	}

	public static void GETAPI() {
		driver.findElement(By.id(btnCreateTest)).click();
		driver.findElement(By.id(crapi)).click();

		driver.findElement(By.name(urlText)).sendKeys(GETAPIUrl);
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

	public static void quitBrowser() {
		driver.quit();
	}

}
