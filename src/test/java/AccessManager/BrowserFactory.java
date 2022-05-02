package AccessManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import AccessManager.Utils.OS;

public class BrowserFactory {

	public static Properties prop = null;
	public static WebDriver driver = null;
	public static Utils ut = null;
	public static String path = System.getProperty("user.dir");

	public static Logger logger = LogManager.getLogger(BrowserFactory.class);

	public static void Setup(String browser) throws IOException

	{

		try {
			InputStream input = new FileInputStream("./Configuration/config.properties");
			prop = new Properties();
			// load a properties file
			prop.load(input);
			String b = prop.getProperty("browser");
			logger.info("Select Browser : " + b);

			switch (Utils.getOperatingSystem())
			{
			case WINDOWS:
				logger.info("Check the Operating System ");
				if (b.equalsIgnoreCase("chromeBrowser")) {
					logger.info("Operating System : Windows");
					System.setProperty("webdriver.chrome.driver", path + prop.getProperty("window_ChromDriver"));
					driver = new ChromeDriver();
					ut = new Utils(driver);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					logger.info("Implicit Wait for opening Browser");
				} else if (b.equalsIgnoreCase("firefoxBrowser")) {
					System.setProperty("webdriver.gecko.driver", path + prop.getProperty("window_firefoxDriver"));
					driver = new FirefoxDriver();
					ut = new Utils(driver);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					logger.info("Implicit Wait for opening Browser");

				}
				break;
			case LINUX:
				if (b.equalsIgnoreCase("chrome")) {
					logger.info("Operating System : linux");
					System.setProperty("webdriver.chrome.driver", path + prop.getProperty("linux_chromedriver"));
					driver = new ChromeDriver();
					ut = new Utils(driver);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					logger.info("Implicit Wait for opening Browser");
				} else if (b.equalsIgnoreCase("firefox")) {
//    			String linuxfirefoxPath=prop.getProperty("firefoxdriver");
//    			System.out.println(linuxfirefoxPath);
//    			System.out.println(path+linuxfirefoxPath);

					System.setProperty("webdriver.gecko.driver", path + prop.getProperty("linux_firefoxdriver"));
					driver = new FirefoxDriver();
					ut = new Utils(driver);
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					logger.info("Implicit Wait for opening Browser");

				}
			default:
				break;
			}
			
			String url = prop.getProperty("url");
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			LocalTime time = LocalTime.now();
			logger.info("Opened url" +" at " +time +" : " +url );
			driver.manage().window().maximize();
			logger.info("Maximize the Window");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

///home/yasmin.shaikh/Desktop/Work/Access_Manager/Driver/chromedriver
//home/yasmin.shaikh/Downloads/geckodriver