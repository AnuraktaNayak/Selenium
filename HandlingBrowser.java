import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingBrowser {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.rediff.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.switchTo().frame("moneyiframe");
		driver.findElement(By.id("query")).sendKeys("CTS");
		driver.findElement(By.className("mw001-widget-getquote-btn")).click();

		driver.switchTo().defaultContent();

		String parentWname = driver.getWindowHandle();

		Set<String> allWindow = driver.getWindowHandles();
		for (String nb : allWindow) {
			if (!(nb.equals(parentWname))) {

				driver.switchTo().window(nb);

			}
			driver.switchTo().window(parentWname);
		}

	}

}
