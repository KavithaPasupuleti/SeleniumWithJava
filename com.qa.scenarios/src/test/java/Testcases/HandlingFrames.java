package Testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingFrames {
	public WebDriver driver;
	public String url="https://www.selenium.dev/selenium/docs/api/java/";
  @BeforeClass
  public void setup() {
	  System.setProperty("webdriver.chrome.driver", "/home/easyway/Desktop/selnium jars/chromedriver_linux64/chromedriver");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }
  @Test
  public void Handlingframes() {
	  driver.get(url);
	  Assert.assertEquals(driver.getTitle(), "Overview", "Title is not as expected");
	 List<WebElement>  frames=driver.findElements(By.tagName("frame"));
	 System.out.println("Total Number of frames in page"+frames.size()); 
	 //Navigate to frames by index
	 driver.switchTo().frame(1);
	 //navigating back to page
	 driver.switchTo().defaultContent();
	//Navigate to frames by name
	 driver.switchTo().frame("classFrame");
	 driver.switchTo().defaultContent();
	 
	 for(WebElement we: frames) {
		 //navigate to the frame with webelemnt
		 we.click();
		}
	 

  }

  @BeforeClass
  public void teardown() {
	  
  }
}
