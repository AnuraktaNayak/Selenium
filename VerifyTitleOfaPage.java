import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class VerifyTitleOfaPage {

	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("http:/www.facebook.com");
			String expectedTitle = driver.getTitle();
			String actualTitle = "Facebook - Log In or Sign Up";
			
			if(expectedTitle.equals(actualTitle)){
				System.out.println("Test case passed");
			}
			else{
				System.out.println("Test case failed");
			}
			
		}
	}

