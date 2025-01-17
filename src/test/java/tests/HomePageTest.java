package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePageTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        homePage = new HomePage(driver);
    }

    @Test
    public void testSignUpButtonVisibility() {
        Assert.assertTrue(homePage.isSignUpButtonVisible(), "Sign up button is not visible!");
    }

    @Test
    public void testLoginButtonVisibility() {
        Assert.assertTrue(homePage.isLoginButtonVisible(), "Login button is not visible!");
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
