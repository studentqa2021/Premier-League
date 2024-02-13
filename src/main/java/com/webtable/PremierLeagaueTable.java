package com.webtable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PremierLeagaueTable {
	
	public void getDataFromWebTable() throws Exception {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.premierleague.com/tables");
		driver.manage().window().maximize();
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//page load
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
		//accept cookies
		driver.findElement(By.xpath("//*[text()='Accept All Cookies']")).click();
		//handle web table
		//rows =(//table)[1]/tbody/tr ==> 40 rows
		//(//table)[1]/tbody//*[@class='tableMid' or @class='tableDark']
		Thread.sleep(3000);
		
		List<WebElement> tableRows =driver.findElements(By.xpath("(//table)[1]/tbody/tr"));
		
		//System.out.println(tableRows.get(0).getText());
		
		for(int i=0;i<tableRows.size();i++) {//40
			if(tableRows.get(i).getText() !=null  && i<=9) {//5 rows
				  ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", tableRows.get(i));
				System.out.println("Index = "+i);
				  System.out.println(tableRows.get(i).getText());
			}
			
		}
	
	}

}
