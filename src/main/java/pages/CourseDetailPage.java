package pages;

import annotations.PageValidation;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import utils.DIScope;

@PageValidation("//h1")
public class CourseDetailPage extends AnyPageAbs<CourseDetailPage> {

  private final DIScope diScope;

  @Inject
  public CourseDetailPage(DIScope diScope) {
    super(diScope);
    this.diScope = diScope;
  }

}

