package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//td[4]/a")
    private List<WebElement> deleteButtons;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickPlaceOrder() {
        placeOrderButton.click();
    }

    public void deleteItemFromCart() {
        if (!deleteButtons.isEmpty()) {
            deleteButtons.get(0).click();
        }
    }
}
