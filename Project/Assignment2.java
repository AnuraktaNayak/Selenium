package com.iformbuilder;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment2 {
	String userName = "Anurakta.it@gmail.com";
	// String UserName = "SonySingh";
	String newExpectedUserName = "HonySingh";
	WebDriver driver;

	@BeforeTest
	public void loginiFormbuilder() {
		driver = new FirefoxDriver();
		// login in into iform builder
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://app.iformbuilder.com/exzact/dataViews.php");
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys(
				"Anurakta.it@gmail.com");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(
				"Sudhansu19@");
		driver.findElement(By.xpath("//input[@value='submit']")).click();

		System.out.println("You logged in successfully");

		String logintempid = driver.findElement(
				By.xpath("//ul[@id='header_rt']/li[1]")).getText();

		System.out.println(logintempid);
		String loginid = logintempid.substring(13);
		System.out.println("yourLoggedin stirng :" + loginid);

		Assert.assertEquals(loginid, userName);

	}

	@Test
	public void newUserValidation() {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By
				.xpath(".//*[@id='iform-header']/div/div/div[3]/div/ul[3]/li/a")));
		action.perform();

		action.moveToElement(
				driver.findElement(By.xpath("//a[text()=\"Add/Edit Users\"]")))
				.click();
		action.perform();

		// creating a new user
		driver.findElement(By.xpath("//div[text()=\"New\"]")).click();
		driver.findElement(By.name("newUsername")).sendKeys("HonySingh");
		driver.findElement(By.name("newFirstname")).sendKeys("Hony");
		driver.findElement(By.name("newLastname")).sendKeys("Singh");
		driver.findElement(By.name("newEmail")).sendKeys(
				"pr06.anurakta@gmail.com");
		driver.findElement(By.id("passwordText")).sendKeys("Sudhansu20@");
		driver.findElement(By.name("newPasswordAgain")).sendKeys("Sudhansu20@");

		driver.findElement(By.name("newCreateRight")).click();
		driver.findElement(By.name("newAdminRight")).click();
		driver.findElement(By.name("newSyncRight")).click();

		driver.findElement(By.xpath("//a[text()=\"Create User\"]")).click();

		String actualUserName = driver
				.findElement(
						By.xpath("//table[@summary=\"iFormBuilder Data Collection User List\"]/tbody/tr[2]/td[1]/div/a"))
				.getText();
		System.out.println("the actual use name is: " + actualUserName);
		Assert.assertEquals(actualUserName, newExpectedUserName);

		// logout of the iformbuilder
		//driver.findElement(By.xpath("//img[@alt=\"logout\"]")).click();
		driver.findElement(By.xpath("//img[@src='https://iform-artwork.s3.amazonaws.com/iformbuilder.com/logout.png']")).click();
	}

	@AfterTest
	public void loginNewUSer() {

		// lonin into new user

		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys(
				"HonySingh");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys(
				"Sudhansu20@");
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		System.out.println("You logged in successfully");

		String newUserName = driver.findElement(
				By.xpath("//ul[@id='header_rt']/li[1]")).getText();

		System.out.println(newUserName);
		String newUserlogin = newUserName.substring(13);
		System.out.println("yourLoggedin stirng :" + newUserlogin);

		Assert.assertEquals(newUserlogin, newExpectedUserName);

		driver.quit();

	}

}
