package helpMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageLocators.IndexLocators;
import pageLocators.SignUpTestLocators;

import java.time.Duration;
import java.util.List;
public class SignUpHelper {

    private WebDriver driver;

    public SignUpHelper(WebDriver driver) {
        this.driver = driver;
    }

    // ---------- WAIT METHODS ----------
    public void waitForVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // ---------- FORM ACTIONS ----------
    public void fillEmailField(String email) {
        waitForVisible(SignUpTestLocators.emailFieldElements);
        WebElement emailField = driver.findElement(SignUpTestLocators.emailFieldElements);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void fillPasswordField(String password) {
        waitForVisible(SignUpTestLocators.passwordFieldElements);
        WebElement passwordField = driver.findElement(SignUpTestLocators.passwordFieldElements);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickRegister() {
        waitForVisible(SignUpTestLocators.registerButtonElements);
        WebElement registerBtn = driver.findElement(SignUpTestLocators.registerButtonElements);
        registerBtn.click();
    }

    public void submitEmptyForm() {
        clickRegister();
    }

    public String getErrorMessageText() {
        waitForVisible(SignUpTestLocators.errorMessageElements);
        return driver.findElement(SignUpTestLocators.errorMessageElements).getText();
    }

//    public String getExpectedAlreadyRegisteredError(){
//        waitForVisible(SignUpTestLocators.secondEmailErrorElements);
//        return driver.findElement(SignUpTestLocators.secondEmailErrorElements).getText();
//    }

//    public void waitForVisibleEmail(By locator, String "value"){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//
//    }

    public String getEmailFieldValue() {
        waitForVisible(SignUpTestLocators.emailFieldElements);
        return driver.findElement(SignUpTestLocators.emailFieldElements).getAttribute("value");
    }

    public String getPasswordFieldValue() {
        waitForVisible(SignUpTestLocators.passwordFieldElements);
        return driver.findElement(SignUpTestLocators.passwordFieldElements).getAttribute("value");
    }


    public void changeEmailField(String value) {
        changeValue(SignUpTestLocators.emailFieldElements, value);
    }

    public void changeValue(By locator, String value) {
        waitForVisible(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }


    public boolean isRedirectedToMyAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.urlContains("my-account"));
    }



    public void clickLogout() {
        waitForVisible(SignUpTestLocators.clickLogOutElements);
        WebElement logoutBtn = driver.findElement(SignUpTestLocators.clickLogOutElements);
        logoutBtn.click();
    }
}