package Script;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pompage.LoginPage;
import Utility.BaseTest;
import Utility.Lib;

public class TestLogin extends BaseTest{
	@Test
	public void testLogin(){
	LoginPage l = new LoginPage(driver);
	String un = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 0);
	String pw = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 1);
	l.setUsername(un);

	l.setPassword(pw);
	l.clickLogin();
	String actualtitle = driver.getTitle();
	SoftAssert s = new SoftAssert();
	s.assertEquals(actualtitle, "Facebook");
	s.assertAll();
	}
}
