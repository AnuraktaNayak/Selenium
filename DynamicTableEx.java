package Practise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DynamicTableEx {

	WebDriver driver = new FirefoxDriver();

	@BeforeTest
	public void normalSteps() {
		driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);

	}

	@Test
	public void testingCase() {
		WebElement tName = driver.findElement(By.tagName("table"));
		List<WebElement> trows = tName.findElements(By.tagName("tr"));
		// List<WebElement> trows = t.findElements(By.tagName("tr"));

		int noOfRows = trows.size();

		System.out.println("The no. of rows in the table are " + noOfRows);
		for (int row = 0; row < noOfRows; row++) {
			List<WebElement> tcols = trows.get(row).findElements(
					By.tagName("td"));
			int noOfCols = tcols.size();
			System.out.println("No of columns for the " + row + "row"
					+ noOfCols);
			for (int col = 0; col < noOfCols; col++) {
				String colData = tcols.get(col).getText();
				System.out.println("The text in the column is " + colData);

			}
		}

	}

}
