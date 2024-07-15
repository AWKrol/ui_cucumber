package components;

import annotations.Component;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.AbsBaseUtils;
import utils.DIScope;
import java.util.HashMap;
import java.util.Map;

public abstract class AnyComponentAbs<T> extends AbsBaseUtils {

  @Inject
  public AnyComponentAbs(DIScope diScope) {
    super(diScope);
  }

  protected Actions actions;

  public WebElement getComponentEntity() {
    return $(getComponentLocator());
  }

  private By getComponentLocator() {
    Component component = getClass().getAnnotation(Component.class);

    if (component != null) {
      String value = component.value();
      String searchStrategy = value.split(":")[0];
      String path = value.replace(String.format("%s:", searchStrategy), "").trim();

      switch (searchStrategy) {
        case "xpath":
          return By.xpath(path);
        case "id":
          return By.id(path);
        case "css":
          return By.cssSelector(path);
      }
    }

    return null;
  }

  protected Map<String, String> getComponentData() {

    Map<String, String> result = new HashMap<>();
    Component component = getClass().getAnnotation(Component.class);

    if (component != null) {
      String value = component.value();
      String searchStrategy = value.split(":")[0];
      String path = value.replace(String.format("%s:", searchStrategy), "").trim();

      result.put("searchStrategy", searchStrategy);
      result.put("path", path);
      return result;
    }

    return null;
  }

}
