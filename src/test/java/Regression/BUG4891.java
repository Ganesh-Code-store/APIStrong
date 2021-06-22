package Regression;

public class BUG4891 extends BaseClass {

	public void testRefresh() throws InterruptedException {
		driver.navigate().refresh();

		for (int i = 0; i <=10; i++) {

			Thread.sleep(6000);
			BaseClass.clickElement(WorkflowHistory, "xpath");

			String status=BaseClass.findElement(workflowStatus, "xpath").getText();
			
			if (status.contains("Pass")
					|| status.contains("Fail")) {
				System.out.println(
						"Workflow is " + BaseClass.findElement(workflowStatus, "xpath").getText() + " After refresh");
				break;

			} 
			else if (i == 10) {
				System.out.println("This workflow keeps on running not passed or failed");
				break;

			} 
			else {
				System.out.println("Workflow is runnning :" + BaseClass.findElement(workflowStatus, "xpath").getText());
		    }
		}
	}

	public static void main(String[] args) throws InterruptedException {

		BaseClass.setup();
		BaseClass.Login();
		new Workflow_Creation().CreateWorkFlow();
		new Workflow_Creation().AddAPIsToWorkflow(3);
		new Workflow_Creation().executeFlow();
		new BUG4891().testRefresh();

	}

}
