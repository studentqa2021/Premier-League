package com.webtable;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PremierLeagaueTable {

	@Test
	public void getDataFromWebTable() {
		// open browser
		WebDriver driver = new ChromeDriver();
		// go to application
		driver.get("https://www.premierleague.com/tables");
		// maximize
		driver.manage().window().maximize();
		// implicit wait = HTML , slow automation
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		// page load = wait graphics load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
		// accept cookies
		driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
		// wait for table= explicit wait
		WebElement table = driver.findElement(By.xpath("(//table)[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(table));
		// read table data
		List<WebElement> rows = driver.findElements(By.xpath("(//table)[1]/tbody/tr"));// 40
//		System.out.println("Row count = "+rows.size());
//		System.out.println("1st Row value = "+rows.get(0).getText());
//		System.out.println("Last Row value = "+rows.get(rows.size()-1).getText());
		// multiple rows read =looping (need 5 rows)
		// validation = need to store application data into java collection
		// row no=1to 5, data
		Map<Integer, String> rowDataMap = new LinkedHashMap<>();
		for (int i = 0; i < rows.size(); i++) {
			if (i <= 9) {// 9 means 5th row
				// System.out.println("each Row value = "+rows.get(i).getText());
				rowDataMap.put(i, rows.get(i).getText().replaceAll("\n", ","));
				// optional
				((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid green'", rows.get(i));
			}
		}//loop end
		System.out.println("Map Test data = " + rowDataMap);

	}

}
