package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenerclass implements ITestListener
{
 
   public void onStart(ITestContext context) {
		    System.out.println("test getting executed");
		  }
	 
	public void onTestStart(ITestResult result) 
	{
	    System.out.println("test started");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("test success");
	  }
	
	public void onTestFailure(ITestResult result) {
		System.out.println("test fail");
	  }
	
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }
	public void onFinish(ITestContext context) {
		System.out.println("test skipped");
	  }
	
	
	
	
	
	
}
