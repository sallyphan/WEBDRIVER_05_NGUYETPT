package selenium_api;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Topic_02_Xpath_Css_Locator {
	WebDriver driver;
  @BeforeClass
  public void beforeClass() {
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
		  
  }
  
  @Test
  public void TC_02_LoginWithUserPasswordEmpty() {
	  driver.get("http://live.guru99.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath("//*[@id='send2']")).click();
	  
	  String usernameEmptyMessage = driver.findElement(By.xpath("//*[@id='advice-required-entry-email']")).getText();
	  Assert.assertEquals("This is a required field.", usernameEmptyMessage);
	  
	  String passwordEmptyMessage = driver.findElement(By.xpath("//*[@id='advice-required-entry-pass']")).getText();
	  Assert.assertEquals("This is a required field.", passwordEmptyMessage);
	  
  }
  
  
  @Test
  public void TC_03_LoginWithEmailInvalid() {
	  driver.get("http://live.guru99.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	  
	  driver.findElement(By.cssSelector("#email")).sendKeys("123434234@12312.123123");
	  driver.findElement(By.xpath("//*[@id='send2']")).click();	  
	  String invalidEmailMessage = driver.findElement(By.xpath("//*[@id='advice-validate-email-email']")).getText();
	  Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", invalidEmailMessage);
	 
  }
  
  @Test
  public void TC_04_LoginWithPasswordLessThan6Characters(){
	  driver.get("http://live.guru99.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	  
	  driver.findElement(By.cssSelector("#email")).sendKeys("automation@gmail.com");
	  driver.findElement(By.xpath("//*[@id='pass']")).sendKeys("123");
	  driver.findElement(By.xpath("//*[@id='send2']")).click();	 
	  String InvalidPasswordMessage = driver.findElement(By.xpath("//*[@id='advice-validate-password-pass']")).getText();
	  Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.", InvalidPasswordMessage);
	 
  }

  
  @Test
  public void TC_05_CreateAnAccount(){
	  driver.get("http://live.guru99.com/");
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	  
	  driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	  
	  driver.findElement(By.xpath("//*[@id='login-form']//span[text()='Create an Account']")).click();
	  driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys("Sally");
	  driver.findElement(By.xpath("//*[@id='lastname']")).sendKeys("Phan");
	  driver.findElement(By.xpath("//*[@id='email_address']")).sendKeys("Automation05"+randomEmail()+"@gmail.com");
	  driver.findElement(By.xpath("//*[@id='password']")).sendKeys("abcde12345-");  
	  driver.findElement(By.xpath("//*[@id='confirmation']")).sendKeys("abcde12345-");  
	  driver.findElement(By.xpath("//*[@class='button' and @title='Register']")).click();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	  String RegistrationSuccessMessage = driver.findElement(By.xpath("//span[contains(text(),'Thank you')]")).getText();
	  Assert.assertEquals("Thank you for registering with Main Website Store.", RegistrationSuccessMessage);
	  driver.findElement(By.xpath("//*[@id='header']//span[text()='Account']")).click();
	  driver.findElement(By.xpath("//*[@id='header-account']//a[text()='Log Out']")).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.urlToBe("http://live.guru99.com/index.php/"));
	  	  
	  String homepageURL = driver.getCurrentUrl();
	  Assert.assertEquals("http://live.guru99.com/index.php/", homepageURL);
  }

  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int randomEmail() {
	  Random random = new Random();
	  int number = random.nextInt(99999999);
	  return number;
  }
  
}
