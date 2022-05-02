package AccessManager;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage_AM extends BrowserFactory {
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Username'])[1]")
	WebElement Username_Btn;
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Password'])[1]")
	WebElement Password_Btn;
	@FindBy(how = How.XPATH, using = "//span[@class='button_label']")
	WebElement Login_Btn;

	public void loginToAM() {
		// Username_Btn.click();
		ut.click(Username_Btn);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Username_Btn.sendKeys("yasmin");
		ut.sendKeys(Username_Btn, "yasmin");
		logger.info("Username  : yasmin");
		ut.click(Password_Btn);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Password_Btn.sendKeys("Pass@123");
		ut.sendKeys(Password_Btn, "Pass@123");
		logger.info("Password  : Pass@123");
		ut.click(Login_Btn);
		logger.info("Click on the Login Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		logger.info("Implicit Wait for login");
	}

}
