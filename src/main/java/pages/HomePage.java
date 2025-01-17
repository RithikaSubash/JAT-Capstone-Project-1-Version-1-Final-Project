package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "signin2")
    private WebElement signUpButton;

    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(id = "nameofuser")
    private WebElement welcomeUser;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSignUpButtonVisible() {
        return signUpButton.isDisplayed();
    }

    public boolean isLoginButtonVisible() {
        return loginButton.isDisplayed();
    }

    public void clickSignUp() {
        signUpButton.click();
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isWelcomeUserDisplayed() {
        return welcomeUser.isDisplayed();
    }
}
