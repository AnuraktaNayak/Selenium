package com.iformbuilder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assignment1 {
	WebDriver driver;
	String userName = "Anurakta.it@gmail.com";
	String expectedStoreName = "Walmart";
	String expectedCityName = "Quincy";
	int expectedZipCode = 12169;

	
	@BeforeTest
	public void loginiFormbuilder() {
		driver = new FirefoxDriver();
		String username = "Anurakta.it@gmail.com";
		driver.get("https://app.iformbuilder.com/exzact/dataViews.php");
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys(
				"Anurakta.it@gmail.com");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(
				"Sudhansu19@");
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		System.out.println("You logged in successfully");

		// Create a record
		driver.findElement(By.xpath("//a[text()=\"3639021\"]")).click();

		driver.findElement(By.xpath("//div[text()=\"Create New Record\"]"))
				.click();

		driver.findElement(By.id("p3639021_rec0_store_name")).sendKeys(
				"Wallmart");
		driver.findElement(By.id("p3639021_rec0_city_name")).sendKeys("Quincy");
		driver.findElement(By.id("p3639021_rec0_zipcode")).sendKeys("02169");
		driver.findElement(By.xpath("//a[text()=\"Save\"]")).click();
		// driver.navigate().back();

	}

	@Test
	public void confirmLoginUser(String userName) {
		String logintempid = driver.findElement(
				By.xpath("//ul[@id='header_rt']/li[1]")).getText();

		System.out.println(logintempid);
		String loginid = logintempid.substring(13);
		System.out.println("yourLoggedin stirng :" + loginid);

		Assert.assertEquals(loginid, userName);

	}

	@Test
	public void confirmRecord(String expectedStoreName, String expectedCityName, String expectedZipCode) {

		int rowCount = driver
				.findElements(
						By.xpath("//table[@summary=\"iFormBuilder Data Collection Data List\"]/tbody/tr"))
				.size();

		System.out.println(rowCount);
		if (rowCount > 0) {
			System.out.println("The No of records in the table are: "
					+ rowCount);
		} else {
			System.out.println("This table having no records");
			driver.quit();
		}

		String actualStoreName = driver
				.findElement(
						By.xpath("//table[@summary=\"iFormBuilder Data Collection Data List\"]/tbody/tr/td[3]/div"))
				.getText();
		System.out.println(actualStoreName);

		String actualCityName = driver
				.findElement(
						By.xpath("//table[@summary=\"iFormBuilder Data Collection Data List\"]/tbody/tr/td[4]/div"))
				.getText();
		System.out.println(actualCityName);

		String actualZipCode = driver
				.findElement(
						By.xpath("//table[@summary=\"iFormBuilder Data Collection Data List\"]/tbody/tr/td[5]/div"))
				.getText();
		System.out.println(actualZipCode);
		Assert.assertEquals(actualStoreName, expectedStoreName);
		Assert.assertEquals(actualCityName, expectedCityName);
		Assert.assertEquals(Integer.parseInt(actualZipCode), expectedZipCode);

	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
