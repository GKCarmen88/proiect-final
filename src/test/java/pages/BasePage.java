package pages;

import helpMethod.HomePageTestHelper;
import helpMethod.LogInHelper;
import helpMethod.SignUpHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    public WebDriver driver;

    public HomePageTestHelper elementsHelper;
    public LogInHelper logInHelper;
    public SignUpHelper signUpHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        elementsHelper = new HomePageTestHelper(driver);
        logInHelper = new LogInHelper(driver);
        signUpHelper = new SignUpHelper(driver);
    }

}
