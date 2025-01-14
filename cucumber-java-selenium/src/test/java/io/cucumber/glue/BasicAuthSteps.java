package io.cucumber.glue;

import dev.failsafe.internal.util.Assert;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicAuthSteps extends Context {

    public BasicAuthSteps(Manager manager) {
        super(manager);
    }

    @And("user clicks Basic Auth link")
    public void user_clicks_link() throws Throwable {
        getDriver().findElement(By.linkText("Basic Auth")).click();
    }

    @When("user enters username and passwords")
    public void user_enter_username_and_password() {
        WebElement activeElement = getDriver().switchTo().activeElement();
        activeElement.sendKeys("admin");
        activeElement.sendKeys(Keys.ENTER);
        activeElement.sendKeys("admin");
        activeElement.sendKeys(Keys.ENTER);

//        Actions actions = new Actions(manager.getDriver());
//        actions.sendKeys("admin");
//        actions.sendKeys(Keys.ENTER).perform();
//        actions.sendKeys("admin");
//        Alert alert = manager.getDriver().switchTo().alert();
//        alert.sendKeys("admin");
//        alert.accept();
//        alert.sendKeys("admin");
    }

    @And("clicks sign in button")
    public void user_clicks_button() {
        Actions actions = new Actions(getDriver());
        actions.keyDown(Keys.ENTER);
    }

    @Then("the confirmation message should be {string}")
    public void the_confirmation_message_should_be(String expectedText) {
        WebElement actualElement = getDriver().findElement(By.id("#content"));
        String actualText = actualElement.getText();
        assertEquals(expectedText, actualText, "The expected message does not match");
    }
}

