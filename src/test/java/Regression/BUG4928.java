package Regression;

import org.testng.Assert;

public class BUG4928 extends BaseClass {

	String Home;
	String apis;

	public void VerifyOnHome() {
		Home = BaseClass.findElement(upgrade, "id").getCssValue("color");

	}

	public void VerifyOnAPI() {
		BaseClass.findElement(TestsMenu, "id").click();
		apis = BaseClass.findElement(upgrade, "id").getCssValue("color");

	}

	public void validateColor() {
		Assert.assertEquals(Home, apis);
		System.out.println("upgrade button color is blue");
	}

	public static void main(String[] args) {

		try {
			BaseClass.setup();
			BaseClass.Register();
			new BUG4928().VerifyOnHome();
			BaseClass.GETAPI();
			new BUG4928().VerifyOnAPI();
			new BUG4928().validateColor();
			driver.quit();

		} catch (Exception e) {
			System.out.println(e);
			driver.quit();
		}
	}

}
