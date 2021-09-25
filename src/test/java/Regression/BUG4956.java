package Regression;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BUG4956 extends BaseClass {
	
	static int count=0;

	static List<WebElement> ls;

	public static void GetAPIlist() throws InterruptedException {
		BaseClass.clickElement(TestsMenu, "id");

		ls = BaseClass.findElements(apislist, "xpath");

		//Thread.sleep(3000);

	}

	public static void TestSearch() throws InterruptedException
	{
		for(int i=0;i<ls.size();i++)
		{
			System.out.println(ls.get(i).getText());
			BaseClass.enterText("txtSearch", "id", ls.get(i).getText());

			WebDriverWait wait=new WebDriverWait(driver,20);
			BaseClass.findElement("//div[text()='" +ls.get(i).getText()+ "']","xpath").click();

			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(apislist))).click();
			//String wb=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(apislist))).getText();
			
			String wb=BaseClass.findElement("//div[text()='" +ls.get(i).getText()+ "']","xpath").getText();
			System.out.println("Wb element :"+wb);

			Assert.assertEquals(wb,ls.get(i).getText(),"Search text and found text is not matching");
			
			//Thread.sleep(5000);

			for(int j=0;j<ls.get(i).getText().length();j++)
			{
				BaseClass.findElement("txtSearch", "id").sendKeys(Keys.BACK_SPACE);
				
			}
			count++;


			}
		System.out.println("Search is working fine, searched the "+count+" records");

		
		
	}

	public static void main(String[] args) throws InterruptedException {
		try {
			BaseClass.setup();
			BaseClass.Login("workflow@mailinator.com", "test12");			new BUG4956().GetAPIlist();
			new BUG4956().TestSearch();
			BaseClass.quitBrowser();
		} catch (Exception e) {
			System.out.println(e);
			BaseClass.quitBrowser();
		}
	}

}
