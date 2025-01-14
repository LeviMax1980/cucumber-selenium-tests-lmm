package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortableDataSteps extends Context {

    public SortableDataSteps(Manager manager) {
        super(manager);
    }

    @And("data tables are displayed")
    public void data_tables_are_displayed() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        getDriver().findElements(By.id("table1"));
        getDriver().findElements(By.id("table2"));
    }

    @Then("user should see the following in table 1:")
    public void user_should_see_the_following_in_table1(DataTable dataTable) {
        // Convert the DataTable to a List of Maps
        List<Map<String, String>> expectedTable = dataTable.asMaps(String.class, String.class);

        // Find the table on the page
        WebElement actualTable = getDriver().findElement(By.id("table1"));

        // Get all rows from the table
        List<WebElement> rows = actualTable.findElements(By.tagName("tr"));

        // Loop through each row and assert the cell values
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

            // Loop through each cell and assert the value
            for (int j = 0; j < cells.size(); j++) {
                String header = "Header" + (j + 1);
                String expectedValue = expectedTable.get(i).get(header);
                String actualValue = cells.get(j).getText();
                assertEquals(expectedValue, actualValue);
            }
        }
    }
}