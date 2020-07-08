package Testcases;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingMultipleWindows {
	public WebDriver driver;
	public String url="http://www.popuptest.com/";

	  @BeforeClass
	  public void setup() {
		  System.setProperty("webdriver.chrome.driver", "/home/easyway/Desktop/selnium jars/chromedriver_linux64/chromedriver");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
	   }
	  @Test
	  public void HandlingMutipleWindows(){
		  driver.get(url);
		  String Parentwindow = driver.getWindowHandle();
		  driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font[2]/b/a")).click();
  
		  Set<String> windows = driver.getWindowHandles();
		  //removing parentwindow id from set to switch it back after closing the pop ups
		  windows.remove(Parentwindow);
		  for(String wn: windows) {
			  driver.switchTo().window(wn);
			  driver.close();
			  }
	  driver.switchTo().window(Parentwindow);	 
	 
	
  }
	  @AfterTest
	  public void teardown() {
		  driver.close();
	  }
}
