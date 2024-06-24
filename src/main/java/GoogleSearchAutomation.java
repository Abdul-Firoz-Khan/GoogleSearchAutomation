import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class GoogleSearchAutomation {

    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // Implicit wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Locate the search input box by its name attribute
            WebElement searchInput = driver.findElement(By.name("q"));

            // Enter the search keyword "Selenium Java"
            searchInput.sendKeys("Selenium Java");

            // Simulate hitting the ENTER key to perform the search
            searchInput.sendKeys(Keys.ENTER);

            // Get the title of the search results page
            String title = driver.getTitle();
            System.out.println("Title: " + title);

            // Get the current URL of the search results page
            String url = driver.getCurrentUrl();
            System.out.println("URL: " + url);
        } finally {
            // Pause for 2 seconds to allow observation of the browser before it closes
            Thread.sleep(2000);

            // Close the browser
            driver.quit();
        }
    }
}
