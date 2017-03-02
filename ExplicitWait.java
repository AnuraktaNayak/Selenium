import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExplicitWait {

	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://www.collegeweeklive.com/");
		driver.findElement(By.xpath("//div/div/div/ul[3]/li/button")).click();
		driver.findElement(By.xpath("//div/div/ul[3]/li/ul/li[3]/a/strong")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[3]/div/div/form/div/div[2]/div/div/select")));
		Select select = new Select(e);
		select.selectByVisibleText("other");
	
		
		
	}
}
