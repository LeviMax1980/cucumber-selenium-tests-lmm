package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home extends Page {

  public Home(ChromeDriver driver) {
    super(driver);

    //Initializing the Page Object:
    PageFactory.initElements(driver, this);
    System.setProperty("webdriver.chrome.driver", "C://BuildTools//chromedriver-win64/chromedriver");
    System.out.println("Homepage title is : " + getTitle().getText());
  }

  // Page elements and methods
  @FindBy(xpath = "//*[@id='content']/ul")
  private WebElement listItems;



  @FindBy(linkText = "Basic Auth")
  private WebElement basicAuthLink;

  @FindBy(id = "#content")
  private WebElement confirmMessage;

  @FindBy(id = "table1")
  private WebElement table1;

  @FindBy(css = "h1")
  private WebElement title;

  public WebElement getTitle() {
    return title;
  }

  public void refresh() {
    driver.navigate().refresh();
    System.out.println("Refreshed page");
  }

  public void clickLinkText() {
    basicAuthLink.click();
  }

  public void getConfirmation() {
    confirmMessage.getText();
  }

  public void getTableContents() {
    table1.getText();
  }

}
