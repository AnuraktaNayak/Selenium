import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class HandlingFrames {
	public static void main(String[] args){
		
		WebDriver driver= new FirefoxDriver();
		driver.get("http://seleniumhq.github.io/selenium/docs/api/java/index.html");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.switchTo().frame("classFrame");
		driver.findElement(By.linkText("DEPRECATED")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("html/body/div[1]/ul/li[7]/a/span")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//body/div[2]/ul/li[1]/a")).click();
		
	}

}
