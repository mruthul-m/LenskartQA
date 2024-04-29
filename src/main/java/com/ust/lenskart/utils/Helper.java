package com.ust.lenskart.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ust.lenskart.pages.HomePage;

public class Helper extends HomePage {
	public static void clickSuggestion(String option) {
		driver.findElement(By.xpath("//div[text()='"+option+"']")).click();
	}
	public static String checkAssertionText(String text) {
		WebElement element = driver.findElement(By.xpath("//*[text()='"+text+"' and not(@data-testid='sr-brand-msg')]"));
		return element.getText();
}
}
