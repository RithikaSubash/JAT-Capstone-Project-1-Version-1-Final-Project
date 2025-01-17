package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

    // Web elements for the logout functionality
    @FindBy(id = "logout2")
    private WebElement logoutButton;

    @FindBy(id = "login2")
    private WebElement loginButton;

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    // Method to click the "Log out" button
    public void clickLogoutButton() {
        logoutButton.click();
    }

    // Method to verify if the user is redirected to the home page
    public boolean isUserRedirectedToHomePage() {
        return loginButton.isDisplayed();
    }
}
