package steps;

import com.google.inject.Inject;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import pages.MainPage;

public class MainPageSteps {

  @Inject
  private MainPage mainPage;

  @Пусть("Открыта главная страница курсов")
  public void openPage() {

    mainPage.open();
  }

  @Тогда("Кликаем по кнопке больше курсов")
  public void clickMoreCourses() {
    mainPage.clickMoreCourses();
  }

  @Тогда("Выбираем случайную категорию курсов")
  public void selectRandomCourseCategory() throws InterruptedException {

    mainPage.selectRandomCourseCategory();
  }

}
