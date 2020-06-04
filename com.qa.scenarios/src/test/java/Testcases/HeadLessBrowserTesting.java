package Testcases;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadLessBrowserTesting {
  @Test
  public void f() {
	  HtmlUnitDriver driver = new HtmlUnitDriver();
	  driver.get("https://www.spicejet.com/");
	  System.out.println("Page title is: "+driver.getTitle());
	  Assert.assertEquals(driver.getTitle(), "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets","Title is not as expected");
	  driver.close(); 
  }
}
