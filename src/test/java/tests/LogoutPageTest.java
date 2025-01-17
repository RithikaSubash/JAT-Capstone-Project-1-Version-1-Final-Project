package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class LogoutPageTest {

    public static void main(String[] args) {
        // Set up WebDriver with Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); 
        WebDriver driver = new ChromeDriver(options);

        try {
            // Open the website
            driver.get("https://demoblaze.com");

            // Implicit wait to wait for elements to load
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Locate the logout button
            WebElement logoutButton = driver.findElement(By.id("logout2"));

            // Wait until the element is clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(logoutButton));

            // Scroll the logout button into view (if needed)
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logoutButton);

            // Use Actions class to click (helps with complex elements or overlays)
            Actions actions = new Actions(driver);
            actions.moveToElement(logoutButton).click().perform();

            // Add assertion or verification here if necessary (e.g., check if logout was successful)
            System.out.println("Logout clicked successfully");

        } catch (ElementNotInteractableException e) {
            System.out.println("Element not interactable: " + e.getMessage());
            // Handle exception if necessary (retry logic, etc.)
        } finally {
            // Close the driver after test execution
            driver.quit();
        }
    }
}
