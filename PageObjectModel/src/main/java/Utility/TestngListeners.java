package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestngListeners extends BaseTest implements ITestListener{
	BaseTest b = new BaseTest();
	public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	}
	public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	}
	public void onTestFailure(ITestResult result) {

	String testmethodName = result.getName();
	b.takeScreenshot("TestValidLogin");
	}
	public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	}
	public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	}
	public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	}
}
