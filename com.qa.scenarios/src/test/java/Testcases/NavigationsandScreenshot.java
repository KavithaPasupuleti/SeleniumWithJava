package Testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigationsandScreenshot {
	public WebDriver driver;
	public String url1="https://www.spicejet.com/";
	public String url2="https://mail.rediff.com/cgi-bin/login.cgi";
	  @BeforeClass
	  public void setup() {
		  System.setProperty("webdriver.chrome.driver", "/home/easyway/Desktop/selnium jars/chromedriver_linux64/chromedriver");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
	  }

  @Test
  public void BrowserNavigations() throws IOException {
	  driver.get(url1);
      driver.get(url2);
	  driver.navigate().back();
	  Assert.assertEquals(driver.getTitle(), "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets","Failed to navigate back");
	  driver.navigate().forward();
	  Assert.assertEquals(driver.getTitle(), "Rediffmail","Failed to navigate Forward");
	  TakesScreenshot src = ((TakesScreenshot)driver);
	  File SrcFile =src.getScreenshotAs(OutputType.FILE);
	  File DestFile = new File("/home/easyway/Music/github/SeleniumWithJava/com.qa.scenarios/screenshot.png");
	  FileUtils.copyFile(SrcFile, DestFile);
	
 }
}
