package com.ust.lenskart.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ust.lenskart.pages.HomePage;

public class Helper extends HomePage {
	
	//method to click elements located using the specified string in the dynamic xpath
	public static void clickSuggestion(String option) {
		driver.findElement(By.xpath("//div[text()='"+option+"']")).click();
	}
	
	//method to return inner text of elements located using the specified string in the dynamic xpath
	public static String checkAssertionText(String text) {
		WebElement element = driver.findElement(By.xpath("//*[text()='"+text+"' and not(@data-testid='sr-brand-msg')]"));
		return element.getText();
}
	
	//method to perform scrolling on the webpage and in the specified webelement
	public static void scrollThePage(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -500);");
		js.executeScript("window.scrollBy(0, 200);");
		js.executeScript("arguments[0].scrollTop = arguments[1];", element, 800);
	}
}
