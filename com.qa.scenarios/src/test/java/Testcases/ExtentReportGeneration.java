package Testcases;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportGeneration {
	public WebDriver driver;
	public String url1="https://www.spicejet.com/";
	public String url2="https://mail.rediff.com/cgi-bin/login.cgi";
	public ExtentReports report;
	public ExtentTest test;
	  @BeforeClass
	  public void setup() {
		  System.setProperty("webdriver.chrome.driver", "/home/easyway/Desktop/selnium jars/chromedriver_linux64/chromedriver");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  report = new ExtentReports("/home/easyway/Music/github/SeleniumWithJava/com.qa.scenarios/ExtentReportResults.html");
		  test = report.startTest("ExtentDemo");
	  }

  @Test
  public void ExtentDemo() throws IOException {
	  driver.get(url1);
	  test.log(LogStatus.INFO, "Navigating to Browser");
 	  Assert.assertEquals(driver.getTitle(), "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets","Failed to navigate back");
	  test.log(LogStatus.PASS, driver.getTitle());
 	  
  }
 @AfterClass
 public void teardown() {
	 report.endTest(test);
	 report.flush();
	 driver.quit();
	 
 }
}
