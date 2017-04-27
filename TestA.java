package com.retailmenot.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.retailmenot.pages.DealsPage;
import com.retailmenot.pages.HomePage;

public class TestA {

	WebDriver driver;

	@Parameters({ "url", "browserType" })
	@BeforeTest
	public void invokeBrowser(String url, String browserType) {
		if (browserType.equals("FF")) {
			driver = new FirefoxDriver();
		} else if (browserType.equals("Chrome")) {
			System.setProperty("Webdriver.chrome.driver", "chromedriver.exe"); // doubt
			driver = new ChromeDriver();

		} else {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		}
		driver.get(url);

	}

	@Test(priority = 1)
	public void verifyTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "RetailMeNot: Coupon Codes, Coupons, Promo Codes, Free Shipping and Discounts for Thousands of Stores";
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Parameters({ "categoryName", "categoryCount" })
	@Test(priority = 2)
	public void verifycategoryItemCount(String categoryName,
			String categoryCount) {
		HomePage hPage = new HomePage(driver);
		hPage.BrowseDeals();
		
		DealsPage dealsPage = new DealsPage(driver);

		dealsPage.jumpsToSection(categoryName);

		int actualCount = dealsPage.getSectionalCountDeals(categoryName);

		int expectedCount = Integer.parseInt(categoryCount); // / doubt 42 sec

		Assert.assertEquals(actualCount, expectedCount);

	}
}
