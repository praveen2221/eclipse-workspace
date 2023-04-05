package LoginPojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDTO {

	@FindBy(id ="email")
	WebElement emailID;
	
	@FindBy(name ="pass")
	WebElement password;
	
	@FindBy(name ="login")
	WebElement loginBtn;
	
	public LoginDTO(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setEmailID(String em) {
		emailID.sendKeys(em);
	}
	
	public void setpassword(String pw) {
		emailID.sendKeys(pw);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
}
