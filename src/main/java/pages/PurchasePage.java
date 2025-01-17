package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchasePage extends BasePage {

    // Elements for the purchase form
    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement creditCardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;

    @FindBy(xpath = "//button[text()='Close']")
    private WebElement closeButton;

    @FindBy(xpath = "//h2[contains(text(),'Thank you')]")
    private WebElement successMessage;

    public PurchasePage(WebDriver driver) {
        super(driver);
    }

    // Methods to interact with the form fields
    public void enterName(String name) {
        nameField.sendKeys(name);
    }

    public void enterCountry(String country) {
        countryField.sendKeys(country);
    }

    public void enterCity(String city) {
        cityField.sendKeys(city);
    }

    public void enterCreditCard(String creditCard) {
        creditCardField.sendKeys(creditCard);
    }

    public void enterMonth(String month) {
        monthField.sendKeys(month);
    }

    public void enterYear(String year) {
        yearField.sendKeys(year);
    }

    // Method to click the Purchase button
    public void clickPurchaseButton() {
        purchaseButton.click();
    }

    // Method to close the purchase dialog
    public void clickCloseButton() {
        closeButton.click();
    }

    // Method to verify if the purchase was successful
    public boolean isPurchaseSuccessful() {
        return successMessage.isDisplayed();
    }
}
