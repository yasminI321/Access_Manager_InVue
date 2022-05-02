package AccessManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	public WebDriver driver;
	public static WebDriverWait wait;
	public static OS os = null;

	public Utils(WebDriver driver) {
		this.driver = driver;
	}

	public void click(WebElement elementBy) {
		elementBy.click();
	}

	public void MouseOver(WebElement element) {
		Actions actObj = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		actObj.moveToElement(element).build().perform();
	}

	public void sendKeys(WebElement elementBy, String value) {
		elementBy.sendKeys(value);
	}

	public void waitTillClick(WebElement element, int second) {
		WebDriverWait wait11 = new WebDriverWait(this.driver, Duration.ofSeconds(second));
		wait11.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public enum OS {
		WINDOWS, LINUX
	};// Operating systems.

	public static OS getOperatingSystem() {
		// detecting the operating system using `os.name` System property
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("win")) {
			return OS.WINDOWS;
		}

		else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
			return OS.LINUX;
		}

		return null;
	}

}
