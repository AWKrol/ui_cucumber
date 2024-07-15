package pages;

import annotations.UrlPrefix;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import steps.CoursesPageSteps;
import utils.DIScope;
import java.util.List;

@UrlPrefix("/")
public class MainPage extends AnyPageAbs<MainPage> {

  private final DIScope diScope;

  @Inject
  public MainPage(DIScope diScope) {
    super(diScope);
    this.diScope = diScope;
  }

  public CoursesPage clickMoreCourses() {
    click($(moreCourses));

    return new CoursesPage(diScope);
  }

  private final By moreCourses = By.xpath("//section/a/button");
  private final By coursesType = By.xpath("//nav/div[2]");

  public CoursesPage selectRandomCourseCategory() throws InterruptedException {
    String valueClassInitial = $(coursesType).getAttribute("class");

    actions.moveToElement($(coursesType)).build().perform();
    String valueClassFinal = $(coursesType).getAttribute("class");

    for (int i = 0; i < 8; i++) {
      if (!valueClassInitial.equals(valueClassFinal)){
        List<WebElement> listCourses = driver.findElements(By.xpath("//p[text()='Все курсы']/following-sibling::div/a"));
        WebElement selectCourseType = diScope.getFaker().options().nextElement(listCourses);
        diScope.setCourseName(selectCourseType.getText().split(" \\(")[0]);
        selectCourseType.click();

        return new CoursesPage(diScope);
      }
      Thread.sleep(200);
    }

    return null;
  }

}
