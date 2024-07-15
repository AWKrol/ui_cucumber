package steps;

import com.google.inject.Inject;
import components.CatalogCourseComponent;
import io.cucumber.java.ru.Тогда;
import java.io.IOException;

public class CatalogCourseComponentSteps {

  @Inject
  private CatalogCourseComponent catalogCourseComponent;

  @Тогда("Кликаем по курсу с названием {string}")
  public void clickCourseByName(String courseName) {
    catalogCourseComponent.clickCourseByName(courseName);
  }

  @Тогда("Проверяем, что название курса {string}")
  public void assertCourseName(String courseName) {
    catalogCourseComponent.assertCourseName(courseName);
  }

  @Тогда("Проверяем ранние и поздние курсы")
  public void assertEarlyLateCourse() throws IOException {
    catalogCourseComponent.assertEarlyLateCourse();
  }

}
