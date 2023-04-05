package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	static WebDriver driver;
	static WebElement element;
	
	static {
		WebDriverManager.chromedriver().setup();
	}
}
