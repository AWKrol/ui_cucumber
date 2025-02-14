package pages;

import actions.CommonActions;
import annotations.PageValidation;
import annotations.UrlPrefix;
import com.google.inject.Inject;
import io.cucumber.java.ru.Пусть;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.AbsBaseUtils;
import utils.DIScope;
import waiters.StandardWaiters;

public abstract class AnyPageAbs<T> extends AbsBaseUtils {

  private final DIScope diScope;

  @Inject
  protected AnyPageAbs(DIScope diScope) {
    super(diScope);
    this.diScope = diScope;
  }

  @FindBy(xpath = "//span/following-sibling::div/button")
  private WebElement buttonCookieOk;

  private String getBaseUrl() {
    return StringUtils.stripEnd(System.getProperty("base.url"), "/");
  }


  public T pageValidation(String strForValidation) {
    if (getClass().isAnnotationPresent(PageValidation.class)) {
      PageValidation pageValidation = getClass().getAnnotation(PageValidation.class);
      String value = pageValidation.value();
      if (new StandardWaiters(driver).waitForElementVisible($(By.xpath(value)))) {
        Assert.assertEquals($(By.xpath(value)).getText(), strForValidation, "Error validation page");
      } else {
        Assert.fail("Element not visible for validation page");
      }
    }
    return (T)this;
  }

  private String getUrlPrefix() {
    UrlPrefix urlAnnotation = getClass().getAnnotation(UrlPrefix.class);
    if (urlAnnotation != null) {
      return urlAnnotation.value();
    }

    return "";
  }

  public T open() {
    driver.get(getBaseUrl() + getUrlPrefix());
    return (T)this;
  }

  public T cookieOk(T t) {
    if (new StandardWaiters(driver).waitForElementClickable(buttonCookieOk))
      click(buttonCookieOk);

    return t;
  }

}
