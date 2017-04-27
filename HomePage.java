package com.retailmenot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
	
		this.driver = driver;
	}

	

	public void BrowseDeals() {
		driver.findElement(By.xpath(".//*[@id='top']/div/nav/ul/li/div/div/a"))
				.click();
		driver.findElement(
				By.xpath("(//a[contains(text(),'Product Deals')])[2]")).click();

	}

}
