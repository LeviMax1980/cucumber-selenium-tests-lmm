package io.cucumber.core;

import java.util.HashMap;

import io.cucumber.glue.HomeSteps;
import org.openqa.selenium.chrome.ChromeDriver;

public class Context {

  protected Manager manager;

  protected HomeSteps home;

  public Context(Manager manager) {
    this.manager = manager;
  }

  public ChromeDriver getDriver() {
    return manager.getDriver();
  }

  public HashMap<String, Object> getTestStash() {
    return manager.stash;
  }

  public <T> void stash(String key, T value) {
    System.out.println("Stashing : " + key);
    manager.stash.put(key, value);
  }
}