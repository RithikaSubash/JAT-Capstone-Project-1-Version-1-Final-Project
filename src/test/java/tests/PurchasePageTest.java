package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.ElementNotInteractableException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PurchasePageTest {

	public static void main(String[] args) {
		// Set up WebDriver with Chrome options
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // Ensure the browser is maximized
		WebDriver driver = new ChromeDriver(options);

		try {
			// Open the website
			driver.get("https://demoblaze.com");

			// Implicit wait to wait for elements to load
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement loginButton = driver.findElement(By.id("login2"));
			loginButton.click();

			// Wait for the login modal to appear (if using a modal for login)
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));

			// Enter username and password in the login form
			WebElement usernameInput = driver.findElement(By.id("loginusername"));
			usernameInput.sendKeys("RithikaSubash"); 

			WebElement passwordInput = driver.findElement(By.id("loginpassword"));
			passwordInput.sendKeys("Rithu2620!"); 

			// Click the login button to submit the form
			WebElement loginSubmitButton = driver.findElement(By.xpath("//button[text()='Log in']"));
			loginSubmitButton.click();

			// Wait for login to complete (e.g., verify if user is logged in)
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));

			// Add item to the cart
			// Locate an item to add to the cart, for example, an item with the name
			// "Samsung galaxy s6"
			WebElement item = driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']"));
			item.click();

			// Wait for the item page to load
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add to cart']")));

			// Add the item to the cart
			WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
			addToCartButton.click();

			// Confirm that the item was added to the cart (you might want to verify using a
			// message or cart icon)
			System.out.println("Item added to the cart.");

			// Optionally, navigate to the cart and proceed to purchase (next steps in your
			// test)
			WebElement cartButton = driver.findElement(By.id("cartur"));
			cartButton.click();

			// Wait for the cart page to load
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Place Order']")));

			// Locate the "Place Order" button using XPath
			WebElement placeOrderButton = driver.findElement(By.xpath("//button[text()='Place Order']"));

			// Wait until the button is clickable (explicit wait)
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait1.until(ExpectedConditions.elementToBeClickable(placeOrderButton));

			// Click the "Place Order" button
			placeOrderButton.click();

			// Handle the order form (if applicable)
			// Fill out the order form. Example:
			WebElement nameInput = driver.findElement(By.id("name"));
			nameInput.sendKeys("Test User"); // Enter name

			WebElement countryInput = driver.findElement(By.id("country"));
			countryInput.sendKeys("USA"); // Enter country

			WebElement cityInput = driver.findElement(By.id("city"));
			cityInput.sendKeys("New York"); // Enter city

			WebElement cardInput = driver.findElement(By.id("card"));
			cardInput.sendKeys("1234 5678 9876 5432"); // Enter card number

			WebElement monthInput = driver.findElement(By.id("month"));
			monthInput.sendKeys("12"); // Enter card expiry month

			WebElement yearInput = driver.findElement(By.id("year"));
			yearInput.sendKeys("2025"); // Enter card expiry year

			// Click the "Purchase" button after filling out the form
			WebElement purchaseButton = driver.findElement(By.xpath("//button[text()='Purchase']"));
			purchaseButton.click();

			// Optionally, add a validation step or confirmation message verification
			// Example:
			WebElement confirmationMessage = driver
					.findElement(By.xpath("//h2[contains(text(), 'Thank you for your purchase')]"));
			if (confirmationMessage.isDisplayed()) {
				System.out.println("Purchase successful!");
			} else {
				System.out.println("Purchase failed.");
			}

		} catch (ElementNotInteractableException e) {
			System.out.println("Element not interactable: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		} finally {
			// Close the driver after the test execution
			driver.quit();
		}
	}
}
