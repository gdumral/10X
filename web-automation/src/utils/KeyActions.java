package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class KeyActions {
	
	public static void findAndClick(WebDriver driver, By elementLocator) throws InterruptedException {		
		try {
			driver.findElement(elementLocator).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			CommonFunc.tearDown(driver); 
			e.printStackTrace();
		}

	}
	
	public static void find(WebDriver driver, By elementLocator)  {
		try{
			driver.findElement(elementLocator);
		} catch (Exception e) {
			CommonFunc.tearDown(driver); 
			e.printStackTrace();
		}
	}
	
	public static void refresh(WebDriver driver)  {
		driver.navigate().refresh();
	}
	
	public static void findAndSendKey(WebDriver driver, By elementLocator, String key) throws InterruptedException {
		try{
			driver.findElement(elementLocator).sendKeys(key);
			Thread.sleep(2000);
		} catch (Exception e) {
			CommonFunc.tearDown(driver); 
			e.printStackTrace();
		}
		
	}

	public static void dragAndDrop(WebDriver driver, By elementLocator, int xOffset, int yOffset, int count )   {
		Actions action = new Actions(driver);		
		WebElement el = driver.findElement(elementLocator);
		for (int i = 0; i < count; i++) {	
			try {
				action.dragAndDropBy(el, xOffset, yOffset).pause(Duration.ofSeconds(1)).click().pause(Duration.ofSeconds(2)).build().perform();
			} catch (Exception e) {
				CommonFunc.tearDown(driver); 
				e.printStackTrace();
			}
		}
	}
}
