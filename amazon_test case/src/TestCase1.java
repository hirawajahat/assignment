import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.amazon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testcase1() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("twotabsearchtextbox")).click();
    driver.findElement(By.id("twotabsearchtextbox")).clear();
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung TV");
    driver.findElement(By.cssSelector("input.nav-input")).click();
    driver.findElement(By.xpath("//li[@id='result_0']/div/div[3]/div/a/h2")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("add-to-cart-button")).click();
    Thread.sleep(5000);
    driver.findElement(By.id ("ap_email")).click();
    driver.findElement(By.id("ap_email")).sendKeys("hirawajahat@gmail.com");

    driver.findElement(By.id ("ap_password")).click();
    driver.findElement(By.id("ap_password")).sendKeys("maaz2009");

    driver.findElement(By.id ("signInSubmit")).click();
    
    driver.findElement(By.id ("hlb-ptc-btn-native")).click();
  }
    
    
    @Test
    public void deletecart() throws Exception {
      driver.get(baseUrl + "/");
     
      driver.findElement(By.cssSelector("nav-line-1")).click();
   
      driver.findElement(By.id ("ap_email")).click();
      driver.findElement(By.id("ap_email")).sendKeys("hirawajahat@gmail.com");

      driver.findElement(By.id ("ap_password")).click();
      driver.findElement(By.id("ap_password")).sendKeys("maaz2009");

      driver.findElement(By.id ("signInSubmit")).click();
      
      
//    try {
//      assertEquals("$9.93", driver.findElement(By.id("priceblock_ourprice")).getText());
//    } catch (Error e) {
//      verificationErrors.append(e.toString());
//    }
//    driver.findElement(By.cssSelector("span.nav-logo-base.nav-sprite")).click();
//    driver.findElement(By.id("twotabsearchtextbox")).clear();
//    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("kindle fire");
//    driver.findElement(By.cssSelector("input.nav-input")).click();
//    driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div[2]/a/h2")).click();
//    driver.findElement(By.id("priceblock_dealprice")).click();
//    try {
//      assertEquals("$39.99", driver.findElement(By.id("priceblock_dealprice")).getText());
//    } catch (Error e) {
//      verificationErrors.append(e.toString());
//    }
//    driver.findElement(By.id("dp")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
