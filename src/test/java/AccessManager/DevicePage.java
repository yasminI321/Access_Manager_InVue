package AccessManager;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DevicePage extends BrowserFactory{
	@FindBy(how = How.XPATH, using = ("//a[@href='/app/locks']//span[@class='nav__icon']//img[@class='light']"))
	WebElement device; //  (//img[@class='light'])[6]
	@FindBy(how=How.XPATH,using =("//input[@type='search']"))WebElement searchtab;
	
	public void searchUser()
	{	
		String MainWindow3 = driver.getWindowHandle();
		driver.switchTo().window(MainWindow3);
		logger.info("Switch to the main window");
		driver.navigate().refresh();
		logger.info("Refresh Page");
		ut.click(device);
		logger.info("Click on the 'Device Page' ");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ut.sendKeys(searchtab, "yas");
		logger.info("Click on the 'Search Tab' to search for 'yas'");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		
		
	}
}
