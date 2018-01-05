package jenkin_ci_config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoCi {
  

	  

	 
	    
	  	  
	  	  WebDriver driver;

	  		@Parameters("browser")

	  		@BeforeTest

	  		public void setup(String browser) throws Exception {
	  			// Check if parameter passed from TestNG is 'Chrome'
	  			if (browser.equalsIgnoreCase("chrome")) {
	  				// set path to Chromedrive.exe
	  				System.setProperty("webdriver.chrome.driver", "F:\\chhotu\\chromedriver_win32\\chromedriver.exe");
	  				driver = new ChromeDriver();
	  				driver.manage().window().maximize();
	  				driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	  			}
	  			// Check if parameter passed as 'firefox'
	  			else if (browser.equalsIgnoreCase("firefox")) {
	  				// set path to firefoxdriver.exe
	  				System.setProperty("webdriver.gecko.driver", "F:\\driver browser\\geckodriver-v0.19.1-win64\\geckodriver.exe");
	  				driver = new FirefoxDriver();

	  			}
	  		

	  			
	  			// Check if parameter passed as 'IE'
	  			else if (browser.equalsIgnoreCase("edge")) {
	  				// set path of edgedriver.exe
	  				System.setProperty("webdriver.edge.driver","F:\\driver browser\\MicrosoftWebDriver.exe");
	  				driver = new EdgeDriver();
	  			}


	  			else {
	  				// If no browser passed throw exception
	  				System.out.println("Browser is not correct");
	  			}
	  			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  		}

	  		@Test
	  		public void login() throws InterruptedException {
	  			driver.get("https://accounts.google.com/signin");
	  			//WebElement wb = 
	  					driver.findElement(By.id("identifierId")).sendKeys("amw.chhotusingh");
	  			//Actions ac = new Actions(driver);
	  			//ac.sendKeys("amw.chhotusingh").build().perform();
	  			Thread.sleep(2000);
	  			driver.findElement(By.cssSelector(".RveJvd.snByac")).click();
	  			Thread.sleep(2000);
	  			driver.findElement(By.name("password")).sendKeys("amchhotu");
	  			Thread.sleep(2000);
	  			driver.findElement(By.cssSelector(".CwaK9")).click();
	  			Thread.sleep(2000);
	  		}

	  		@AfterClass
	  		public void afterTest() {

	  			driver.quit();
	  		}

	  }

	  
  

