import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAlert {
	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.rediff.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.findElement(By.xpath(".//*[@id='signin_info']/a[1]")).click();

		driver.findElement(By.xpath("//div[1]/input")).click();

		// driver.findElement(By.className("proceed")).click();
		Alert alertbox = driver.switchTo().alert();
		alertbox.accept();

	}
}
