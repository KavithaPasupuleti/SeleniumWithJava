package Testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandlingJSAlertandPopup {
	public WebDriver driver;
	public String url="https://mail.rediff.com/cgi-bin/login.cgi";
	
  @BeforeClass
  public void setup() {
		System.setProperty("webdriver.chrome.driver", "/home/easyway/Desktop/selnium jars/chromedriver_linux64/chromedriver");
		driver=new ChromeDriver();
	}
  @Test
  public void HandlingAlertsPopups() {
	  driver.get(url);	
	  driver.manage().window().maximize();
	  //Verifying the page title 
	  Assert.assertEquals(driver.getTitle(), "Rediffmail", "Title is not as expected");
	  driver.findElement(By.name("proceed")).submit();
	  Alert alert=driver.switchTo().alert();
	  Assert.assertEquals(alert.getText(), "Please enter a valid user name", "Alert Message is not as expected");
	  alert.accept();  	  
  }
  @AfterClass
  public void teardown() {
	  driver.quit();
  }

}
