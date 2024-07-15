package pages;

import annotations.PageValidation;
import com.google.inject.Inject;
import constants.CoursesType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import utils.DIScope;

@PageValidation("//h1")
public class CoursesPage extends AnyPageAbs<CoursesPage> {

  private final DIScope diScope;

  @Inject
  public CoursesPage(DIScope diScope) {
    super(diScope);
    this.diScope = diScope;
  }

  private String checkboxCoursesType = "//label[text()='%s']/parent::div";

  public void assertCheckboxCoursesType() {

    String coursesTypeNameExpected = diScope.getCourseName();
    SoftAssert softAssert = new SoftAssert();
    WebElement element = driver.findElement(By.xpath(String.format(checkboxCoursesType, coursesTypeNameExpected)));
    boolean statusActual = Boolean.parseBoolean(element.getAttribute("value"));
    String coursesTypeNameActual = element.getText();
    softAssert.assertTrue(statusActual);
    softAssert.assertEquals(coursesTypeNameActual, coursesTypeNameExpected);
    softAssert.assertAll();
  }

  public void clickCheckboxCoursesType(CoursesType name, boolean status) {

    WebElement element = driver.findElement(By.xpath(String.format("//label[text()='%s']/parent::div", name.getName())));
    boolean statusActual = Boolean.parseBoolean(element.getAttribute("value"));
    if (status != statusActual) element.click();
  }

}
