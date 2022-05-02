package AccessManager;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AuditPage extends BrowserFactory {

	@FindBy(how = How.XPATH, using = ("//a[@href='/app/audit']"))
	WebElement Audit;

	public void audit() {
		Audit.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

}
