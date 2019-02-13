package SampleCodes;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestClass {

	@Test
	public void f() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("window-size=1200x600");
		WebDriver driver = new ChromeDriver(chromeOptions);
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Launch the application
		driver.get("https://www.moneycontrol.com/stocks/marketstats/nse-gainer/all-companies_-2/");
		// driver.manage().window().maximize();
		// Find element by link text and store in variable "Element"
		System.out.println(LocalDateTime.now() + "Should wait 5 sec here...");
		WebDriverWait wait = new WebDriverWait(driver, 4000l);
		driver.findElement(By.className("opsb15_bk")).click();
		System.out.println(LocalDateTime.now() + "Resuming...");
		List<WebElement> col = driver.findElements(
				By.xpath("//*[@id=\"mc_content\"]/section/section/div[1]/div[2]/div/div/div[2]/table/thead/tr/th"));
		System.out.println(col.size());

		List<WebElement> rows = driver.findElements(
				By.xpath("//*[@id=\"mc_content\"]/section/section/div[1]/div[2]/div/div/div[2]/table/tbody/tr"));
		System.out.println("No of rows are : " + rows.size());

		HashMap<String, Double> map = new HashMap<String, Double>();
		double preVal = 0.0;
		double currVal = 0.0;

		for (int i = 1; i <= rows.size(); i++) {

			WebElement company = driver.findElement(
					By.xpath("//*[@id=\"mc_content\"]/section/section/div[1]/div[2]/div/div/div[2]/table/tbody/tr[" + i
							+ "]/td[1]"));

			WebElement perCentChange = driver.findElement(
					By.xpath("//*[@id=\"mc_content\"]/section/section/div[1]/div[2]/div/div/div[2]/table/tbody/tr[" + i
							+ "]/td[7]"));

			currVal = Double.parseDouble(perCentChange.getText());
			if (preVal > currVal) {
				preVal = currVal;
				map.put(company.getText(), preVal);
			}
			System.out.println(company.getText() + ":\t" + perCentChange.getText() + "// %");

		}
		System.out.println(map.toString());
		File destination = new File(
				"D://screenshots//" + String.join("_", LocalDateTime.now().toString().split("[^A-Za-z0-9]")) + ".jpg");
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
				.takeScreenshot(driver);

		try {
			ImageIO.write(fpScreenshot.getImage(), "JPG", destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();
		driver.quit();
	}
}
