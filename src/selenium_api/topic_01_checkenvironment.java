package selenium_api;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class topic_01_checkenvironment {
	WebDriver driver;
	
	
  @Test
  public void TC_01_CheckURLAndTitle() {
	  System.out.print("Check Homepage Title");
	  String homepageTitle = driver.getTitle();
	  Assert.assertEquals(homepageTitle, "Guru99 Bank Home Page");
	  
	  System.out.print("Check URL");
	  String homepageUrl = driver.getCurrentUrl();
	  Assert.assertEquals(homepageUrl, "http://www.demo.guru99.com/v4/");
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  driver.get("http://www.demo.guru99.com/v4/");
	  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	  driver.manage().window().maximize();

	  
  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
