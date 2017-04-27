package com.retailmenot.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DealsPage {
	WebDriver driver;
	public DealsPage(WebDriver driver){
		this.driver = driver;
	}
		
	public void jumpsToSection(String categoryName) {
		driver.findElement(
				By.xpath("(//a[contains(text(),'"+categoryName+"')])[2]"))
				.click();

	}

	public int getSectionalCountDeals(String categoryName) {
		List<WebElement> dealList = driver.findElements(By.xpath(".//*[@id='"+categoryName+"']/div/div"));
		return dealList.size();
	}
}
