# Selenium Automation Project

This project demonstrates various web automation tasks using Selenium WebDriver with Java. It includes examples of Google search automation, navigating between pages, filling out a registration form, selecting options from dropdown menus, interacting with checkboxes and radio buttons, reading and validating data from a web table, and uploading a file.

## Prerequisites

- Java Development Kit (JDK)
- Maven
- Firefox Browser
- WebDriverManager

## Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/yourusername/selenium-automation.git
    cd selenium-automation
    ```

2. Install dependencies:
    ```sh
    mvn clean install
    ```

3. Set up WebDriverManager to manage browser drivers.

## Examples

### Google Search Automation

This example demonstrates how to perform a Google search and print the page title and URL.

```java
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearchAutomation {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Selenium Java");
        searchInput.sendKeys(Keys.ENTER);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        String url = driver.getCurrentUrl();
        System.out.println("URL: " + url);

        Thread.sleep(2000);
        driver.quit();
    }
}
