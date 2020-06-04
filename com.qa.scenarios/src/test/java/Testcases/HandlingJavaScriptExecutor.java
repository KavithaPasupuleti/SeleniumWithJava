package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class HandlingJavaScriptExecutor {
public WebDriver driver;
 	@BeforeTest
	public void setup() {
 		System.setProperty("webdriver.chrome.driver", "/home/easyway/Desktop/selnium jars/chromedriver_linux64/chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize(); 
		
	  }
  @Test
  public void HandlingJavaScriptExecutor() {
	  driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	 //to send a text with out using sendkeys method
	  js.executeScript("document.getElementById('login1').value='sampleid';");
      //to click on button
	  js.executeScript("arguments[0].click();", driver.findElement(By.name("proceed")));
	  driver.switchTo().alert().accept();
	  //To get the page title
	  String title=js.executeScript("return document.title;").toString();
	  System.out.println(title);
	  //to get current url
	  String currenturl=js.executeScript("return document.URL").toString();
	  System.out.println(currenturl);
	  //to generate alert in a page
	  js.executeScript("alert('Generated Alert');");
	  driver.switchTo().alert().accept();
	  //to scroll a page and to scroll down
	  js.executeScript("window.scrollBy(0,500);");
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  //to refresh a browser
	  js.executeScript("history.go(0)");
	  //To highlight the element 
	  js.executeScript("arguments[0].style.border='6px solid red'", driver.findElement(By.name("proceed")));

  }
  @AfterClass
  public void teardown() {
	  driver.close();
  }
  
}
