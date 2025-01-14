package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Hooks;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.Home;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomeSteps extends Context {


  public HomeSteps(Manager manager) {
    super(manager);
  }
  private Home home;

  @When("I capture the list of links on homepage")
  public void I_capture_the_list_of_links_on_homepage() {
    home.clickLinkText();
    List<WebElement> listItems = getDriver().findElements(By.xpath("//*[@id='content']/ul"));
    listItems.forEach(links -> System.out.println(links.getText()));
  }

  @Then("I should see the list of links:")
  public void I_should_see_the_list_of_links(String links) {
    List<String> expecteItemList = Arrays.asList(links.split(","));
    List<WebElement> actualItemList = getDriver().findElements(By.xpath("//*[@id='content']/ul"));
    for (int i = 0; i < actualItemList.size(); i++) {
      String actualText = actualItemList.get(i).getText();
      //assertEquals(expecteItemList.get(i), actualText, "The actual links list does not match expected links list");
    }
  }
}