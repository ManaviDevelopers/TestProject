/*
 * 
 */
package demo;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

// TODO: Auto-generated Javadoc
/**
 * The Class NewTest.
 */
public class NewTest {

	/**
	 * F.
	 */
	@Test(enabled = true, invocationCount = 2)
	public void f() {

		ExtentReports reports = new ExtentReports("./Report/report.html");
		ExtentTest test = reports.startTest("This Test");
		test.setStartedTime(Date.from(Instant.now()));
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://www.google.co.in");
		System.out.println(driver.getTitle());
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName());
		Assert.assertEquals(true, true);
		test.log(LogStatus.PASS, "Details");
		test.setEndedTime(Date.from(Instant.now()));
		reports.flush();
		driver.close();
		driver.quit();
	}

	/**
	 * F 1.
	 */
	@Test(invocationCount = 2)
	public void f1() {

		ExtentReports reports = new ExtentReports("./Report/report.html");
		ExtentTest test = reports.startTest("This Test1");
		test.setStartedTime(Date.from(Instant.now()));
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(new Object() {
		}.getClass().getEnclosingMethod().getName());
		Assert.assertEquals(true, true);
		test.log(LogStatus.PASS, "Details");
		test.setEndedTime(Date.from(Instant.now()));
		reports.flush();
		driver.close();
		// driver.quit();
	}

}
