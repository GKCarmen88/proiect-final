package helpMethod;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageLocators.HomePageTestLocators;
import pageLocators.IndexLocators;
import pageLocators.LogInTestLocators;
import pages.IndexPage;

import java.time.Duration;
import java.util.List;

public class HomePageTestHelper{
    private WebDriver driver;
    private JavascriptExecutor js;

    public HomePageTestHelper(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
    }


    public void waitForBreadcrumbToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(IndexLocators.hpMenuElements));
    }

    public void clickJSConsentPopup(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (TimeoutException e) {
            LoggerUtility.infoLog("Consent popup not visible, skipping click.");
        }
    }


    public void clickSafe(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (Exception e) {
            System.out.println("Fallback to JS click for locator: " + locator);
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }

    public void clickSmart(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            LoggerUtility.infoLog("Standard click succeeded for locator: " + locator.toString());
        } catch (Exception e) {
            LoggerUtility.infoLog("Fallback to JS click for locator: " + locator.toString());
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }



    public void waitForVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            LoggerUtility.infoLog("Element not visible: " + locator.toString());
        }
    }

    public void clickElement(By locator) {
        waitForVisible(locator);
        driver.findElement(locator).click();
    }



    public void clickJSlocator(By locator) {
        try {
            waitForVisible(locator);  // Make sure element is visible in DOM
            WebElement element = driver.findElement(locator);

            if (element.isDisplayed() && element.isEnabled()) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
                System.out.println("JS click performed on: " + locator);
            } else {
                System.out.println("Element not clickable (not displayed/enabled): " + locator);
            }
        } catch (Exception e) {
            System.out.println("Failed to JS click on: " + locator + "n" + e.getMessage());
        }
    }



    public int getSizeList(By locator) {
        List<WebElement> list = getListElements(locator);
        return list.size();
    }

    public int getNumberOfArrivals() {
        return countElements(HomePageTestLocators.arrivalsElements);
    }



    public void waitForOverlayToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(IndexLocators.waitForOverlayToDisappear));
    }

    public void scrollToElement(By locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(locator));
    }


    public void clearAndFillInput(By locator, String value) {
        waitForVisibleAndEnabled(locator);
        WebElement input = driver.findElement(locator);
        // Setează valoarea via JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + value + "';", input);
        // Trigger event de schimbare (uneori necesar)
        js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", input);
    }

    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public List<WebElement> getListElements(By locator) {
        return driver.findElements(locator);
    }



    public void isAddToBasketElementVisible(By locator){
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed(), "Element is not displayed: " + locator);
        Assert.assertTrue(element.isEnabled(), "Element is not enabled: " + locator);
    }

    public int countElements(By locator) {
        return driver.findElements(locator).size();
    }



    public String confirmMessage() {
        By locator = HomePageTestLocators.confirmMessage;
        // Așteaptă până când mesajul este vizibil (max 10 secunde)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String messageText = messageElement.getText();
        LoggerUtility.infoLog("Mesajul confirmării este: " + messageText);
        return messageText;
    }

    public String fetchCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void waitForVisibleAndEnabled(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickProceedToCheckout() {
        WebElement checkoutButton = driver.findElement(HomePageTestLocators.proceedToCheckoutButton);
        waitForVisible(HomePageTestLocators.proceedToCheckoutButton);
        checkoutButton.click();
        LoggerUtility.infoLog("User clicked on 'Proceed to Checkout' button.");
    }


}

