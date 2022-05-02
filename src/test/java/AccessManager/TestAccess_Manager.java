package AccessManager;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestAccess_Manager extends BrowserFactory {
	LoginPage_AM login;
	CreateUser newuser;
	AuditPage auditPage;
	DevicePage devicePage;

	public TestAccess_Manager() throws IOException {
		Setup("chrome");
	}

	@Test(priority = 1)
	private void Test_Login() {
		login = PageFactory.initElements(driver, LoginPage_AM.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		login.loginToAM();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@Test(priority = 2)
	private void Test_NewUser() throws InterruptedException, AWTException {
		newuser = PageFactory.initElements(driver, CreateUser.class);
		newuser.newUser();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

//	@Test (priority = 3)
//	private void Check_AduitPage() {
//		auditPage = PageFactory.initElements(driver, AuditPage.class);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		auditPage.audit();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
//		
//	}
	@Test(priority = 3)
	private void Test_Device() {
		devicePage = PageFactory.initElements(driver, DevicePage.class);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		devicePage.searchUser();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

}
