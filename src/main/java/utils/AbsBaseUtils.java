package utils;

import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import waiters.StandardWaiters;

public abstract class AbsBaseUtils {

  protected WebDriver driver;
  protected StandardWaiters waiter;
  protected Actions actions;

  @Inject
  public AbsBaseUtils(DIScope diScope) {
    this.driver = diScope.getDriver();
    this.waiter = diScope.getWaiter();
    this.actions = new Actions(driver);
  }

  public WebElement $(By locator) {
    return driver.findElement(locator);
  }

  public void click(WebElement element) {
    if (new StandardWaiters(driver).waitForElementClickable(element)) {
      actions.moveToElement(element).build().perform();
      element.click();
    } else {
      Assert.fail("element not clickable");
    }
  }

}
