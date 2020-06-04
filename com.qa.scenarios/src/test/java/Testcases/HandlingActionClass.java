package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/*
 * Action class is used handle to mouse actions like-drag and drop,move to 
 * element, Double click, clickandhold and KeyBoard actions like-Key up,key-down
 */
public class HandlingActionClass {
	public WebDriver driver;
  @BeforeTest
  public void setup() {
	  System.setProperty("webdriver.chrome.driver", "/home/easyway/Desktop/selnium jars/chromedriver_linux64/chromedriver");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize(); 
  }
  @Test(priority=0)
  public void mousemovents() {
	  driver.get("https://www.spicejet.com/");
	  Actions act = new Actions(driver);
	  act.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
	  act.moveToElement(driver.findElement(By.xpath("//*[@id=\"header-addons\"]/ul/li[2]/a"))).click();
   }
 
  public void draganddrop() throws InterruptedException {
	  driver.get("https://jqueryui.com/droppable/");
	  Thread.sleep(1800);
	  Actions act=new Actions(driver);
	  act.dragAndDrop(driver.findElement(By.cssSelector("#draggable")), driver.findElement(By.cssSelector("#droppable"))).build().perform();
	  //  act.dragAndDrop(driver.findElement(By.className("ui-widget-content ui-draggable ui-draggable-handle")), driver.findElement(By.className("ui-widget-header ui-droppable"))).build().perform();
 
  }
  public void explicitwait(WebDriver driver,WebElement element ,  int timeout) {
	  WebDriverWait wait = new WebDriverWait(driver, timeout);
	  wait.until(ExpectedConditions.visibilityOf(element));
  }
  @AfterTest
  public void teardown() {
	 driver.close(); 
  }
}
