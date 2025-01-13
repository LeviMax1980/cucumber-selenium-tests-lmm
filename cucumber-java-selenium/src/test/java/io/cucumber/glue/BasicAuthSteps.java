package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicAuthSteps extends Context {

    public BasicAuthSteps(Manager manager) {
        super(manager);
    }

    @And("user clicks Basic Auth link")
    public void user_clicks_link() {
        manager.getDriver().findElement(By.linkText("Basic Auth")).click();
    }

    @When("user enters username and passwords")
    public void user_enter_username_and_password() {
        Alert alert = manager.getDriver().switchTo().alert();
        alert.sendKeys("admin");
        alert.accept();
        alert.sendKeys("admin");
    }

    @And("clicks sign in button")
    public void user_clicks_button() {
        Alert alert = manager.getDriver().switchTo().alert();
        alert.accept();
    }

    @Then("the confirmation message should be {string}")
    public void the_confirmation_message_should_be(String expectedText) {
        WebElement actualText = manager.getDriver().findElement(By.id("#content"));
        assertEquals(expectedText, actualText);
    }
}

