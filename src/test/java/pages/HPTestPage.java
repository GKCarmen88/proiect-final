package pages;

import helpMethod.HomePageTestHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageLocators.HomePageTestLocators;

import java.time.Duration;
import java.util.List;

public class HPTestPage extends BasePage {
    private HomePageTestHelper elementsHelper;

    public HPTestPage(WebDriver driver) {
        super(driver);
        elementsHelper = new HomePageTestHelper(driver);
    }

    public void waitForOverlayToDisappear() {
        elementsHelper.waitForOverlayToDisappear();
    }



    public void clickViewBasket() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(HomePageTestLocators.viewBasketElements));
        elementsHelper.clickSmart(HomePageTestLocators.viewBasketElements);
        LoggerUtility.infoLog("User clicked on 'View Basket' button.");
    }



    public void clickAddToBasket() {
        elementsHelper.isAddToBasketElementVisible(HomePageTestLocators.addToBasketBtnElements);
        elementsHelper.clickElement(HomePageTestLocators.addToBasketBtnElements);
        LoggerUtility.infoLog("Action: Clicked on the 'Add to Basket' button.");
    }

    public void verifyNumberOfSlides(int expected) {
        LoggerUtility.infoLog("Verification: Expecting " + expected + " slides on the Home Page.");
        int actual = elementsHelper.getSizeList(HomePageTestLocators.slidersElements);
        LoggerUtility.infoLog("Number of slides found: " + actual);
        Assert.assertEquals(actual, expected, "Expected " + expected + " slides.");
        LoggerUtility.infoLog("PASSED: The number of slides is correct.");
    }

    public void verifyNumberOfArrivals(int expected) {
        LoggerUtility.infoLog("Verification: Expecting " + expected + " products in the 'Arrivals' section.");
        int actual = elementsHelper.getNumberOfArrivals();
        LoggerUtility.infoLog("Number of Arrivals found: " + actual);
        Assert.assertEquals(actual, expected, "Expected " + expected + " arrivals.");
        LoggerUtility.infoLog("PASSED: The correct number of arrivals is displayed.");
    }


    public void clickOnArrivalImage() {
        elementsHelper.scrollToElement(HomePageTestLocators.imageArrivelElements);
        elementsHelper.clickJSlocator(HomePageTestLocators.imageArrivelElements);
        LoggerUtility.infoLog("Action: Clicked on an Arrival image.");
    }

    public void waitForUrlToContain(String partialUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    public void verifyCurrentUrlContains(String expectedSubstring) {
        String url = driver.getCurrentUrl();
        LoggerUtility.infoLog("Current URL: " + url);
        Assert.assertTrue(url.contains(expectedSubstring), "FAILED: Navigation to the expected page did not occur.");
        LoggerUtility.infoLog("PASSED: Successfully navigated to the product page.");
    }


    public void verifyRedirectionToBasket() {
        String currentUrl = elementsHelper.fetchCurrentPageUrl();
        Assert.assertTrue(currentUrl.contains("basket"), "FAILED: Redirection to the Basket page did not occur.");
        LoggerUtility.infoLog("PASSED: Successfully redirected to the Basket page.");
    }

    public void clearAndFillInput(By locator, String value) {
        elementsHelper.waitForVisibleAndEnabled(locator);
        WebElement input = driver.findElement(locator);
        input.clear();
        input.sendKeys(value);
    }

    public void setProductQuantity(String quantityValue) {
        elementsHelper.clearAndFillInput(HomePageTestLocators.cantitateInputElements, quantityValue);
        try {
            Thread.sleep(500);  // 0.5 sec pentru așteptare mică
        } catch (InterruptedException e) {
            // ignoră
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(HomePageTestLocators.cantitateInputElements));
        String actualValue = input.getAttribute("value");
        Assert.assertEquals(actualValue, quantityValue, "Quantity input value does not match the expected value.");
        LoggerUtility.infoLog("Action: User selected quantity: " + quantityValue);
    }

    public void verifyConfirmationMessage(String expectedMessagePart) {
        String actual = elementsHelper.confirmMessage();
        LoggerUtility.infoLog("Confirm message actual: " + actual);
        LoggerUtility.infoLog("Confirm message expected part: " + expectedMessagePart);
        Assert.assertTrue(actual.contains(expectedMessagePart),
                "FAILED: The confirmation message does not contain the expected text.");
        ;
        LoggerUtility.infoLog("PASSED: The confirmation message contains the expected part.");
    }

    public void proceedToCheckout() {
        elementsHelper.clickProceedToCheckout();

        String currentUrl = driver.getCurrentUrl();
        LoggerUtility.infoLog("Current URL after clicking 'Proceed to Checkout': " + currentUrl);

        Assert.assertTrue(currentUrl.contains("/checkout/"),
                "FAILED: User was not redirected to the checkout page.");

        LoggerUtility.infoLog("PASSED: User successfully navigated to the checkout page.");
    }


}








