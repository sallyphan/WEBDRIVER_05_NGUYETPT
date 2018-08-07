package selenium_api;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_WebElement_Browser {
WebDriver driver;
	
@BeforeClass
public void beforeClass() {
	
	System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	 driver = new ChromeDriver();
	// driver = new FirefoxDriver();
	 driver.manage().window().maximize();
	 driver.get("http://daominhdam.890m.com/");
	 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}

  @Test
  public void TC_01_isDisplayed() throws Exception {
	  WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='mail']"));
	  WebElement educationTextarea = driver.findElement(By.xpath("//textarea[@id='edu']"));
	  WebElement ageRadioButton = driver.findElement(By.xpath("//input[@id='under_18']"));
	  
	  Assert.assertTrue(isControlDisplayed(emailTextbox));
	  Assert.assertTrue(isControlDisplayed(educationTextarea));
	  Assert.assertTrue(isControlDisplayed(ageRadioButton));
	  
	  if (isControlDisplayed(emailTextbox)&&isControlDisplayed(educationTextarea)) {
		 emailTextbox.sendKeys("Automation Testing");
		 educationTextarea.sendKeys("Automation Testing");
	  }
	  
	  Thread.sleep(5000);
  }
  
  @Test
  public void TC_02_isEnabled() {
	  //Enabled controls
	  WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='mail']"));
	  WebElement educationTextarea = driver.findElement(By.xpath("//textarea[@id='edu']"));
	  WebElement ageRadioButton = driver.findElement(By.xpath("//input[@id='under_18']"));
	  WebElement job1Select = driver.findElement(By.xpath("//select[@id='job1']"));
	  WebElement developmentCheckbox = driver.findElement(By.xpath("//label[@for='development']"));
	  WebElement enabledSlider1 = driver.findElement(By.xpath("//input[@id='slider-1']"));
	  WebElement enabledButton = driver.findElement(By.xpath("//button[@id='button-enabled']"));
	  
	  isControlEnabled(emailTextbox);
	  isControlEnabled(educationTextarea);
	  isControlEnabled(ageRadioButton);
	  isControlEnabled(job1Select);
	  isControlEnabled(developmentCheckbox);
	  isControlEnabled(enabledSlider1);
	  isControlEnabled(enabledButton);
	  
	  //Disabed controls
	  WebElement passwordTextbox = driver.findElement(By.xpath("//input[@id='password']"));
	  WebElement disabledRadioButton = driver.findElement(By.xpath("//input[@id='radio-disabled']"));
	  WebElement biographyTextarea = driver.findElement(By.xpath("//textarea[@id='bio']"));
	  WebElement disabledSlider2 = driver.findElement(By.xpath("//input[@id='slider-2']"));

	  isControlEnabled(passwordTextbox);
	  isControlEnabled(disabledRadioButton);
	  isControlEnabled(biographyTextarea);
	  isControlEnabled(disabledSlider2);
	 
  }
  
  @Test
  public void TC_03_isSelected() {
	  
	  WebElement ageRadioButton = driver.findElement(By.xpath("//input[@id='under_18']"));
	  WebElement developmentCheckbox = driver.findElement(By.xpath("//label[@for='development']"));
	  
	  isControlSelected(ageRadioButton);
	  isControlSelected(developmentCheckbox);
  }
  
  public boolean isControlDisplayed(WebElement element) {
	  
	  return element.isDisplayed();
  }
  
  public void isControlSelected(WebElement element) {
	  if (!element.isSelected()) {
		  
		  element.click();
	  }	 
  }
  
  
  public void isControlEnabled(WebElement element) {
	  if (element.isEnabled()) {
		  System.out.println("Element is enabled");
	  }else {
		  System.out.println("Element is disabled");
	  }
  }
  @AfterClass
  public void afterClass() {
	//  driver.quit();
  }

}
	