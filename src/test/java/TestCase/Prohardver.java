package TestCase;
// esris alkalmazásoknál megjelennek e a térképek

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import org.openqa.selenium.JavascriptExecutor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.*;

import javax.imageio.ImageIO;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Prohardver {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeClass
	public void setUp() {
		// driver = new OperaDriver();
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void test1a() throws InterruptedException {
		driver.get("https://prohardver.hu/index.html");

		driver.findElement(By.xpath("//b[normalize-space()='Fórum']")).click();
		Thread.sleep(2000);
		

	}

	@Test(priority = 2)  
	public void test1b() throws InterruptedException {


		WebElement kiterkep = driver.findElement(By.xpath("//a[normalize-space()='Notebookok']"));

		Assert.assertEquals(true, kiterkep.isDisplayed());
		
		Thread.sleep(1000);
		

	}

	@Test(priority = 4)
	public void test1c() throws InterruptedException {

		


		WebElement kiterkep = driver.findElement(By.xpath("//span[@class='fas fa-user']"));

		Assert.assertEquals(true, kiterkep.isDisplayed());
		
         Thread.sleep(1000);
		
		

		

	}
	
	

	
	

	

	@AfterMethod
	public void tearDown(ITestResult result) {

		// Here will compare if test is failing then only it will enter into if
		// condition
		if (ITestResult.FAILURE == result.getStatus()) {
			try {
				// Create refernce of TakesScreenshot
				TakesScreenshot ts = (TakesScreenshot) driver;

				// Call method to capture screenshot
				File source = ts.getScreenshotAs(OutputType.FILE);

				// Copy files to specific location here it will save all screenshot in our
				// project home directory and
				// result.getName() will return name of test case so that screenshot name will
				// be same
				FileUtils.copyFile(source, new File(
						"D://oltvanyidavid//Teszt prog//Selenium//failscreenshots//PGR3_dev//Adatbetolto//PGR3_dev//"
								+ result.getName() + ".png"));

				System.out.println("Screenshot taken");
			} catch (Exception e) {

				System.out.println("Exception while taking screenshot " + e.getMessage());
			}

		}
		// close application

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();

	}
}
