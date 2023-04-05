package Test;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("beforeMethod",true);
	}
	
	@AfterMethod
	public void afterMethod() {
		Reporter.log("afterMethod",true);
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("beforeClass",true);
	}
	
	@AfterClass
	public void afterClass() {
		Reporter.log("afterClass",true);
	}
	
	@BeforeTest
	public void beforeTest() {
		Reporter.log("beforeTest",true);
	}
	
	@AfterTest
	public void afterTest() {
		Reporter.log("afterTest",true);
	}
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("beforeSuite",true);
	}
	
	@AfterSuite
	public void afterSuite() {
		Reporter.log("afterSuite",true);
	}
	
	@Test(priority = 0)
	public void test() {
		System.out.println("Test Started....");
		Reporter.log("test",true);
	}
	
	@Test(groups = {"module1"})
	public void test2() {
		System.out.println("Test2");
		Reporter.log("test2",true);
	}
	
	@Test(invocationCount = 2, enabled = false)
	public void test3() {
		System.out.println("Test3");
		Reporter.log("test3",true);
	}
}
