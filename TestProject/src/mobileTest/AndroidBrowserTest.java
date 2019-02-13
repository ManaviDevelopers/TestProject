package mobileTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidBrowserTest {
	public static void main(String[] args) {
		String deviceID = "emulator-5554"; // emulator-5554
		// System.setProperty("webdriver.chrome.driver",
		// "D:\\Downloads\\chromedriver.exe");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "My Phone");
		caps.setCapability(MobileCapabilityType.UDID, deviceID); // Give Device ID of your mobile phone
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		caps.setCapability(MobileCapabilityType.VERSION, "8.1");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
		// caps.setCapability("appPackage", "com.android.vending");
		// caps.setCapability("appActivity",
		// "com.google.android.finsky.activities.MainActivity");

		// caps.setCapability("appPackage", "com.android.chrome");
		// caps.setCapability("appActivity",
		// "com.google.android.apps.chrome.ChromeTabbedActivity");
		caps.setCapability("noReset", true);

		AppiumDriver<WebElement> driver = null;

		try {
			driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:5000/wd/hub"), caps);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		driver.get("http://www.msn.com");

	}
}
