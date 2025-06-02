package helpMethod;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;



public class LogInHelper {

    private WebDriver driver;


    public LogInHelper(WebDriver driver) {
        this.driver = driver;

    }

    // ---------- WAIT METHODS ----------
    public void waitForVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            LoggerUtility.infoLog("Elementul este vizibil: " + locator.toString());
        } catch (TimeoutException e) {
            LoggerUtility.errorLog("Timeout! Elementul NU a devenit vizibil: " + locator.toString());
            throw e;
        }
    }




    public void waitForVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForPresenceList(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    // ---------- FORM ACTIONS ----------
    public void fillEmailVariant(By locator, String value) {
        waitForVisible(locator);
        WebElement emailField = driver.findElement(locator);
        emailField.clear();
        emailField.sendKeys(value);
    }

    public void fillPasswordVariant(By locator, String value) {
        waitForVisible(locator);
        WebElement passwordField = driver.findElement(locator);
        passwordField.clear();
        passwordField.sendKeys(value);
    }

    public void clickLoginButtonVariant(By locator) {
        waitForVisible(locator);
        WebElement loginButton = driver.findElement(locator);
        loginButton.click();
    }

    public List<WebElement> getLoginFormFields(By formLocator, By inputLocator) {
        waitForVisible(formLocator);
        WebElement form = driver.findElement(formLocator);
        return form.findElements(inputLocator);
    }

    // ---------- VALIDATIONS ----------
    public void validateElementText(By locator, String expectedText) {
        waitForVisible(locator);
        String actualText = driver.findElement(locator).getText();
        Assert.assertEquals(actualText, expectedText,
                "Textul elementului nu corespunde. Așteptat: " + expectedText + ", Găsit: " + actualText);
    }

    public void validateElementContainsText(By locator, String expectedPartialText) {
        waitForVisible(locator);
        String actualText = driver.findElement(locator).getText();
        Assert.assertTrue(actualText.contains(expectedPartialText),
                "Textul elementului nu conține valoarea așteptată: " + expectedPartialText);
    }

    // ---------- GETTERS ----------
    public String getElementAttribute(By locator, String attribute) {
        waitForVisible(locator);
        return driver.findElement(locator).getAttribute(attribute);
    }

    public String getElementText(By locator) {
        waitForVisible(locator);
        return driver.findElement(locator).getText();
    }




}





