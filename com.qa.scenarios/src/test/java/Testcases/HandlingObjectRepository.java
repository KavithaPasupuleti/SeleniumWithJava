package Testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandlingObjectRepository {
	public WebDriver driver;
	public Properties prop =new Properties();
	  @BeforeTest
	  public void setup() throws IOException {
		  FileInputStream fis = new FileInputStream("/home/easyway/Music/github/SeleniumWithJava/com.qa.scenarios/src/test/resources/config.properties");
		  prop.load(fis);
		  System.setProperty("webdriver.chrome.driver", "/home/easyway/Desktop/selnium jars/chromedriver_linux64/chromedriver");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
	  }
  @Test
  public void HandlingObjectRepository() {	
		  driver.get(prop.getProperty("url"));
		  Assert.assertEquals(driver.getTitle(), prop.getProperty("title"),"title is not as expected");
  }
  @BeforeClass
  public void teardown() {
	 driver.close();
  }
  
}
