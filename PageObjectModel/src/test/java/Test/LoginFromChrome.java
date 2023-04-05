package Test;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFromChrome {
  
	static WebDriver driver;
	static FileInputStream file;
	static Properties prop;
	
	static {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
	}
	
	@Test
	@Parameters("browser")
	public void chromeLogin(@Optional("abc") String browser){
		try {
			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else {
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}
			
			file = new FileInputStream(System.setProperty("webdriver.chrome.driver","/Users/praveenanbu/eclipse-workspace/PageObjectModel/Driver/chromedriver"));
		    prop = new Properties();
			prop.load(file);
			
//			String url = prop.getProperty("baseURL");
			driver.get("https://www.facebook.com/");
			
			Thread.sleep(3000);
			driver.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
