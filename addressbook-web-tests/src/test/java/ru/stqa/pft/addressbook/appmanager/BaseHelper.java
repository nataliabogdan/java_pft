package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


/**
 * Created by plopik on 30.11.2016.
 */
public class BaseHelper {
  public WebDriver wd;
  //private WebDriver wd;

  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    findElement(locator).click();
  }

  protected void type(By locator, String text) {
    WebElement element = findElement(locator);
    if (text != null) {
      String existingText = element.getAttribute("value");
      if (! text.equals(existingText)){
        element.clear();
        element.sendKeys(text);
      }
    }
  }

  protected void select(By locator, String value){
    if (isElementPresent(locator)) {
      WebElement element = findElement(locator);
      Select select = new Select(element);
      select.selectByVisibleText(value);
    }
  }

  protected WebElement findElement(By locator) {
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

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  protected void checkElementNotPresent(By locator) {
    Assert.assertFalse(isElementPresent(locator));
  }

  protected boolean isTextPresent(By locator, String text) {
    try {
      wd.findElement(locator).getText().equals(text);
      return true;
    } catch (NoSuchElementException ex){
      return false;
    }
  }

  protected int countOfGroups(By locator) {
    return wd.findElements(locator).size();
  }

  protected int countOfContacts(By locator) {
    return wd.findElements(locator).size();
  }

  protected void findElementByLocator(By locator) {
    wd.findElement(locator).click();
  }

  protected void findElementByIndex(By locator, int index) {
    wd.findElements(locator).get(index).click();
  }

  protected List<WebElement> findElements(By locator) {
    return wd.findElements(locator);
  }
}
