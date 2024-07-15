package utils;

import com.github.javafaker.Faker;
import factory.WebDriverFactory;
import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import waiters.StandardWaiters;
import java.util.Random;

@ScenarioScoped
public class DIScope {


  private final WebDriver driver = new WebDriverFactory().getDriver();
  private final Random random = new Random();
  private final StandardWaiters waiter = new StandardWaiters(driver);
  private final Actions actions = new Actions(driver);
  private final Faker faker = new Faker();
  private String courseName = null;

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public WebDriver getDriver() {
    return driver;
  }

  public Random getRandom() {
    return random;
  }

  public StandardWaiters getWaiter() {
    return waiter;
  }

  public Actions getActions() {
    return actions;
  }

  public Faker getFaker() {
    return faker;
  }
}
