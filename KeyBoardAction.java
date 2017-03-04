import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
// capital letter typing using keyboard//

public class KeyBoardAction {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Actions action = new Actions(driver);

		action.keyDown(Keys.SHIFT);
		action.sendKeys(driver.findElement(By.id("login1")), "abc@gmail.com");
		action.sendKeys(driver.findElement(By.id("password")), "slenium");
		action.keyUp(Keys.SHIFT);
		action.perform();

		action.click(driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div[1]/div/form/div/div[6]/div[1]/input")));
		action.perform();

	}

}
