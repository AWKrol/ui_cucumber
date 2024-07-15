package steps;

import com.google.inject.Inject;
import io.cucumber.java.ru.Тогда;
import pages.CoursesPage;

public class CoursesPageSteps {

  @Inject
  private CoursesPage coursePage;

  @Тогда("Проверяем, что чекбокс проставлен в выбранной категории")
  public void assertCheckboxCoursesType() {
    coursePage.assertCheckboxCoursesType();
  }

}
