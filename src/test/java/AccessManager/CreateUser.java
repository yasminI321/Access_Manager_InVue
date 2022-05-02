package AccessManager;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUser extends BrowserFactory {

	@FindBy(how = How.XPATH, using = ("//a[@href='/app/users']//span[@class='nav__icon']//img[@class='light']"))
	WebElement user;
	@FindBy(how = How.XPATH, using = ("//button[@class='add-button']"))
	WebElement AddnewUser;
	// @FindBy (how=How.CSS,using =("#UserTypeId"))WebElement UserType;
	@FindBy(how = How.XPATH, using = ("//div[@class='SidebarOverlay']//div[3]//input[1]"))
	WebElement FirstName;
	@FindBy(how = How.XPATH, using = ("//div[5]//input[1]"))
	WebElement MiddleName;
	@FindBy(how = How.XPATH, using = ("//div[7]//input[1]"))
	WebElement LastName;
	@FindBy(how = How.XPATH, using = ("//div[9]//input[1]"))
	WebElement EmployId;
	@FindBy(how = How.XPATH, using = ("(//button[normalize-space()='Save'])[1]"))
	WebElement save_Btn;
	// @FindBy(how=How.XPATH,using=("//select[@id='UserTypeId']")) WebElement
	// drpUserType;
	@FindBy(how = How.XPATH, using = ("//div[@class='SelectList-container']//child::select[@id='UserTypeId']"))
	WebElement clickonuserTpye;
	// //select[@id='UserTypeId']
	@FindBy(how = How.LINK_TEXT, using = ("Security"))
	WebElement OptnSecurity;
	// @FindBy(how=How.XPATH,using=("(//img[@class='RemoveListItem-action-icon'])[1]"))WebElement
	// PlusSign;
	@FindBy(how = How.CSS, using = ("li[id='removeListItem-2298fc33-4c59-4ac8-9201-224ca033ee59'] img[class='RemoveListItem-action-icon']"))
	WebElement MobileRole;
	// @FindBy(how=How.XPATH,using=("//button[normalize-space()='Done']"))WebElement
	// Done_Btn;
	@FindBy(how = How.XPATH, using = ("//div[@class='Modal-buttons']//child::button[@class='button primary']"))
	WebElement Done_Btn;
	// @FindBy(how=How.LINK_TEXT,using=("Done"))WebElement Done_Btn;
	@FindBy(how = How.XPATH, using = ("//div[contains(@class,'AdminModal-input input')]//input[@type='text']"))
	WebElement CreateUsername;
	@FindBy(how = How.XPATH, using = ("//div[@id='modal-overlay']//div[3]//input[1]"))
	WebElement CreatePassword;
	@FindBy(how = How.XPATH, using = ("//div[4]//input[1]"))
	WebElement ConfirmPassword;
	@FindBy(how = How.XPATH, using = ("//div[@class='Modal-buttons']//child::button[@class='button primary']"))
	WebElement Create_Btn;
	@FindBy(how = How.XPATH, using = ("//img[@class='close']"))
	WebElement Close_Btn;
	@FindBy(how = How.XPATH, using = ("(//button[normalize-space()='Cancel'])[1]"))
	WebElement Cancel_Btn;
	// //img[@class='close']
	// (//img[@class='close'])[1]
	// css .close

	public void newUser() throws InterruptedException, AWTException {
		logger.info("Main window present");
		ut.click(user);
		logger.info("Click on the 'User' Tab");
		driver.navigate().refresh();
		logger.info("Refresh Page");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ut.click(AddnewUser);
		logger.info("Click on the 'Add New User' Tab");
		String MainWindow1 = driver.getWindowHandle();
		driver.switchTo().window(MainWindow1);
		logger.info("Switch to the window");
		try {

			Thread.sleep(2000);
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='UserTypeId']")));
			driver.findElement(By.xpath("//select[@id='UserTypeId']")).click();
			logger.info("Click on the User Type for selecting user type");

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait2.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector("option[value='13a8ff64-8916-421d-a6eb-8556ed6df871']")));
			driver.findElement(By.cssSelector("option[value='13a8ff64-8916-421d-a6eb-8556ed6df871']")).click();
			logger.info("Selected User type: Security");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		// FirstName.sendKeys("YasAuto");
		ut.sendKeys(FirstName, "yasAuto");
		logger.info("First Name  : yasAuto");
		// MiddleName.sendKeys("p");
		ut.sendKeys(MiddleName, "p");
		logger.info("Middle Name  : p");
		ut.sendKeys(LastName, "shaikh");
		logger.info("last Name : shaikh");
		ut.sendKeys(EmployId, "Yas@12345");
		logger.info("Employe Id : Yas@1234");
		try {
			Thread.sleep(2000);
			WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#manage_devices")));
			driver.findElement(By.cssSelector("select[id='manage_devices'] option[value='Yes']")).click();
			logger.info("Manage Device = Yes");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait4.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#remote_operations")));
			driver.findElement(By.cssSelector("select[id='remote_operations'] option[value='Yes']")).click();
			logger.info("Remote Operation=Yes");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		Thread.sleep(2000);
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait5.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='RemoveListItem-action-icon'])[1]")))
				.click(); // presenceOfElementLocated
		logger.info("'Access New Device' role get added");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		ut.click(MobileRole);
		logger.info("'Mobile Role' role get added");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait7.until(ExpectedConditions.elementToBeClickable(save_Btn)).click();
		logger.info("Click on the Save Button");
		Thread.sleep(3500);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dist = new File("/home/yasmin.shaikh/Desktop/Work/Access_Manager/Screenshot/Pin.png");
		try {
			FileUtils.copyFile(src, dist);
		} catch (IOException e) {

			e.printStackTrace();
		}

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		logger.info("Switch to the next window");
//		String MainWindow1 = driver.getWindowHandle();
//		driver.switchTo().window(MainWindow1);
		logger.info("Pin Generated");
		logger.info("A Screenshot of the Pin gets Captured");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));

		ut.waitTillClick(Done_Btn, 300);
		logger.info("Click on the Done Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		logger.info("Switch to the next window");
//		String MainWindow2 = driver.getWindowHandle();
//		driver.switchTo().window(MainWindow2);
		ut.waitTillClick(CreateUsername, 300);
		ut.sendKeys(CreateUsername, "AutoYasmin");
		logger.info("Create username  : AutoYasmin");
		ut.waitTillClick(CreatePassword, 300);
		ut.sendKeys(CreatePassword, "Yas@1234567");
		logger.info("Create Password  : Yas@1234567");
		ut.waitTillClick(ConfirmPassword, 300);
		ut.sendKeys(ConfirmPassword, "Yas@1234567");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		logger.info("Confirm Password");

		Actions actions1 = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		actions1.moveToElement(Create_Btn).click().build().perform();
		logger.info("Click on the Create Button to create User Account");
		logger.info("Account get Created Successfully");
		Thread.sleep(2000);

		String MainWindow2 = driver.getWindowHandle();
		driver.switchTo().window(MainWindow2);

		logger.info("Switch back to the window");
		Thread.sleep(1500);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
		WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait8.until(ExpectedConditions.elementToBeClickable(Close_Btn)).click();
		logger.info("Click on the Close Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
}

/*
 * JavascriptExecutor js = ((JavascriptExecutor) driver);
 * js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
 * 
 * WebElement PlusSign =
 * driver.findElement(By.xpath("(//img[@class='RemoveListItem-action-icon'])[1]"
 * )); Boolean displayed1 = PlusSign.isDisplayed();
 * System.out.print(displayed1);
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 * PlusSign.click();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 * MobileRole.click();
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 * 
 * 
 * Robot rb =new Robot(); rb.keyPress(KeyEvent. rb.keyRelease(KeyEvent);
 * System.out.println("Closed the windows popup"); Thread.sleep(1000);
 * 
 * Actions actions = new Actions(driver);
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 * actions.moveToElement(Done_Btn).click().build().perform();
 * 
 * 
 * WebDriverWait wait9 =new WebDriverWait (driver, Duration.ofSeconds(300));
 * wait9.until(ExpectedConditions.elementToBeClickable(Done_Btn)).click();
 * 
 * 
 * WebElement scroll =
 * driver.findElement(By.xpath("//button[normalize-space()='Create'] "));
 * scroll.sendKeys(Keys.PAGE_DOWN);
 * driver.findElement(By.xpath("//button[normalize-space()='Create'] ")).click()
 * ; //button[normalize-space()='Create'] // css - button[type='submit'] //
 * (//button[normalize-space()='Create'])[1]
 * 
 */

/*
 * Actions action = new Actions(driver); String parentWindowHandler =
 * driver.getWindowHandle(); // Store your parent window String subWindowHandler
 * = null; Set<String> handles = driver.getWindowHandles(); // get all window
 * handles Iterator<String> iterator = handles.iterator(); while
 * (iterator.hasNext()) { subWindowHandler = iterator.next(); }
 * driver.switchTo().window(subWindowHandler);
 * 
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 * action.moveToElement(CreateUsername).click().build().perform();
 * 
 * 
 * //String parent=driver.getWindowHandle();
 * //Set<String>s=driver.getWindowHandles(); //driver.switchTo().window(parent);
 * 
 * 
 * 
 * // WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(20));
 * // wait8.until( // ExpectedConditions.elementToBeClickable(By.xpath(
 * "//button[normalize-space()='Cancel']"))) // .click(); //
 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); //
 * logger.info("Click on cancel button");
 * 
 * // WebElement element =
 * driver.findElement(By.xpath("(//button[normalize-space()='Cancel'])[1]")); //
 * if (element.isDisplayed() && element.isEnabled()) { // element.click(); // }
 * 
 * // logger.info("Click on cancel button");
 * 
 * 
 * 
 * 
 * 
 * 
 */
