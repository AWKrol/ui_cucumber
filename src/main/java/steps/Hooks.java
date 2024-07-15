package steps;

import com.google.inject.Inject;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utils.DIScope;

public class Hooks {

  @Inject
  private DIScope diScope;

  @After
  public void close() {
    WebDriver driver = diScope.getDriver();
    if (driver != null) {
      driver.quit();
    }
  }

}
