import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http:www.kmart.com/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//body/div[1]/div[2]/div[2]/div/nav/ul/li[4]/span/a")));
		action.perform();
		Thread.sleep(2000);

		action.moveToElement(driver.findElement(By.xpath("//body/div[1]/div[2]/div[2]/div/nav/ul/li[4]/ul/li[3]/ul/li[1]/span/a")));
		action.click();
		action.perform();
		
	}

}
