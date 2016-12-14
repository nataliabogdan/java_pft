package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by plopik on 30.11.2016.
 */
public class BaseHelper {
  private WebDriver wd;

  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    findElement(locator).click();
  }

  protected void type(By locator, String text) {
    WebElement element = findElement(locator);
    if (text != null) {
      element.clear();
      element.sendKeys(text);
    }
  }

  private WebElement findElement(By locator) {
    return wd.findElement(locator);
  }

  protected void alertAccept(){
    wd.switchTo().alert().accept();
  }


  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
