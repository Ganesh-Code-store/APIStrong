package Regression;

import org.testng.Assert;

public class BUG4951 extends BaseClass{
	
	
	public void integration()
	{
		BaseClass.clickElement(profilediv, "id");
		BaseClass.clickElement(slack, "xpath");
		//BaseClass.enterText(WebhookURL,"id",webhook);
		BaseClass.clickElement(saveintegration,"id");
		
		Assert.assertTrue(BaseClass.findElement(SuccessAlertMsg, "id").isDisplayed(), "Confirm message is not displayed after saving");
		System.out.println("Confirm message is displayed after saving");
	
	}

	public static void main(String[] args) {
		
		BaseClass.setup();
		BaseClass.Login("workflow@mailinator.com", "test12");		new BUG4951().integration();
		

	}

}
