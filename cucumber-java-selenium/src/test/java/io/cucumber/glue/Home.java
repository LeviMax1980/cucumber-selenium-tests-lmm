package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Home extends Context {

  public Home(Manager manager) {
    super(manager);
  }

  @When("I capture the list of links on homepage")
  public void I_capture_the_list_of_links_on_homepage() {
    List<WebElement> listItems = manager.getDriver().findElements(By.xpath("//*[@id='content']/ul"));
    listItems.forEach(links -> System.out.println(links.getText()));
  }

  @Then("I should see the list of links:")
  public void I_should_see_the_list_of_links(String links) {
    List<String> expecteItemList = Arrays.asList(links.split(","));
    List<WebElement> actualItemList = manager.getDriver().findElements(By.xpath("//*[@id='content']/ul"));
    for (int i = 0; i < actualItemList.size(); i++) {
      String actualText = actualItemList.get(i).getText();
      assertEquals(expecteItemList.get(i), actualText, "The actual links list does not match expected links list");
    }
  }
}