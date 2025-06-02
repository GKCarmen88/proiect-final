package pages;

import helpMethod.HomePageTestHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageLocators.IndexLocators;

import java.time.Duration;
import java.util.List;

public class IndexPage extends BasePage {

    private HomePageTestHelper elementsHelper;

    public IndexPage(WebDriver driver) {
        super(driver);
        this.elementsHelper = new HomePageTestHelper(driver);

    }
    public void acceptConsentPopup() {
//        try {
//            List<WebElement> iframes = driver.findElements(IndexLocators.consentIframe);
//            if (!iframes.isEmpty()) {
//                driver.switchTo().frame(iframes.get(0));
//                elementsHelper.clickJSConsentPopup(IndexLocators.consentButton);
//                LoggerUtility.infoLog("User clicked on Consent button inside iframe.");
//                driver.switchTo().defaultContent();
//            } else {
//                LoggerUtility.infoLog("Consent iframe not found. Possibly already accepted.");
//            }
//        } catch (Exception e) {
//            LoggerUtility.errorLog("Error while trying to accept consent: " + e.getMessage());
//        }
        elementsHelper.clickJSConsentPopup(IndexLocators.consentButton);

    }

    public void waitForBreadcrumbVisible() {
        elementsHelper.waitForVisible(IndexLocators.hpMenuElements);
    }

    public void waitForMenuNavVisible() {
        elementsHelper.waitForVisible(IndexLocators.menuNavElement);
    }

    public Boolean isNavigationTabVisible() {
        return elementsHelper.isElementDisplayed(IndexLocators.menuNavElement);
    }

    public void clickOnShopMenu() {
        elementsHelper.clickSafe(IndexLocators.shopElements);  // robust + fallback
        LoggerUtility.infoLog("User clicked on: Shop Menu");
    }

    public void clickOnHomeBreadcrumb() {
        elementsHelper.clickJSlocator(IndexLocators.hpMenuElements);
        LoggerUtility.infoLog("User clicked on: Home breadcrumb");
    }


    public void verifyNavigationTabIsVisible() {
        if (!isNavigationTabVisible()) {
            throw new AssertionError("Navigation tab should be visible");
        }
    }

//    public void clickOnMyAccount(){
//        elementsHelper.clickJSlocator(IndexLocators.myAccountElements);
//        LoggerUtility.infoLog("User click on : My Account");
//    }

    public void clickOnMyAccount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement myAccount = wait.until(ExpectedConditions.elementToBeClickable(IndexLocators.myAccountElements));
        myAccount.click();
        LoggerUtility.infoLog("User clicked on: My Account");
    }




    // ** METODA PE CARE O ADĂUGĂM PENTRU A ASTEPTA PAGINA MY ACCOUNT SĂ SE ÎNCARCE **
    public void waitForMyAccountPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Înlocuiește cu un element clar din pagina My Account
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg_email")));
        LoggerUtility.infoLog("My Account page loaded");
    }
}

