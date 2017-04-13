package com.demoaut.newtours.TestScripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ListEx {

	public static void main(String[] args) {

		WebDriver driver;
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement days = driver.findElement(By.id("day"));
		Select select = new Select(days);
		List<WebElement> lists = select.getOptions();

		for (int i = 0; i < lists.size(); i++) {			
			lists.get(i).click();
		}
		System.out.println("The no of days are: " + lists.size());

		WebElement months = driver.findElement(By.id("month"));
		select = new Select(months);
		List<WebElement> month = select.getOptions();

	}
}
