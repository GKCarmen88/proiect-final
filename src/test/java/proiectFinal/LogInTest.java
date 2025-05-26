package proiectFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;
import java.util.List;

public class LogInTest extends SharedData {

    @Test

    public void metodaTest() {

        String usernameName = "username";
        String passwordName = "password";
        String checkboxName = "rememberme";
        String lostPasswordText = "Lost your password?";




        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement menuNavElement = driver.findElement(By.id("main-nav"));
        js.executeScript("arguments[0].click();", menuNavElement);

        //WebElement consentPopupElement = driver.findElement(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']"));
        //js.executeScript("arguments[0].click();", consentPopupElement);


        WebElement myAccountElements = driver.findElement(By.id("menu-item-50"));
        myAccountElements.click();


        //Inspectam formul de login cu toate elementele si verificare ca are doar 2 fielduri
        WebElement loginElements = driver.findElement(By.cssSelector("form.login"));
        List<WebElement> inputFields = loginElements.findElements(By.cssSelector("input[type='text'], input[type='password']"));
        Assert.assertEquals(inputFields.size(), 2, "Formularul ar trebui să aibă 2 input-uri (email și parolă)");

        for (WebElement field : inputFields) {
            System.out.println("Input field: " + field.getAttribute("name"));
        }

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit'], input[type='submit']"));
        Assert.assertTrue(loginButton.isDisplayed(), "Butonul de Login trebuie să fie vizibil");

        String buttonText = loginButton.getAttribute("value");
        if (buttonText != null && !buttonText.isEmpty()) {
            System.out.println("Buton de login găsit: " + buttonText);
        } else {
            System.out.println("Buton de login este: " + loginButton.getText());
        }

        WebElement rememberMeCheckbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertTrue(rememberMeCheckbox.isDisplayed(), "Checkbox-ul Remember Me trebuie să fie vizibil");
        System.out.println("Checkbox este: " + rememberMeCheckbox.getAttribute("name"));


        // Verificăm linkul „Lost your password?”
        WebElement lostPasswordLink = loginElements.findElement(By.linkText(lostPasswordText));
        Assert.assertTrue(lostPasswordLink.isDisplayed(), "Linkul de resetare parolă trebuie să fie vizibil");
        System.out.println("Link textul face redirect catre :  " + lostPasswordLink.getAttribute("href"));


        // Error Handling test

        WebElement clickLoginButton = driver.findElement(By.cssSelector("button[type='submit'], input[type='submit']"));
        js.executeScript("arguments[0].click();", clickLoginButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("woocommerce-error")));
        String errorText = errorMessage.getText();
        System.out.println("Mesaj de eroare este: " + errorText);

        //eroare messaje pt invalid username
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.clear();
        emailField.sendKeys("carmentestz@gmail.com");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys("T3st1234!2025");

        WebElement loginButtonAgain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
        js.executeScript("arguments[0].click();", loginButtonAgain);

        WebElement secondError = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='woocommerce']//ul[@class='woocommerce-error']")));
        String secondErrorText = secondError.getText();
        System.out.println("Mesaj de eroare la email neexistent este: " + secondErrorText);

//stergem datele din fielduri
        WebElement emailFieldLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        emailFieldLog.clear();
        emailFieldLog.sendKeys(usernameName);
        System.out.println("Completat email: " + usernameName);


        WebElement passFieldLog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passFieldLog.clear();
        passFieldLog.sendKeys(passwordName);
        System.out.println("Completat password field: " + passwordName);

        //eroare messaje pt incorect password
        WebElement typeEmail = driver.findElement(By.id("username"));
        typeEmail.clear();
        typeEmail.sendKeys("carmentest@gmail.com");

        WebElement incorectPassword = driver.findElement(By.id("password"));
        incorectPassword.clear();
        incorectPassword.sendKeys("T3st1234!202");

        WebElement clickLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']")));
        js.executeScript("arguments[0].click();", clickLogin);

        // Sa vb cu Alex cum fac aici ca ii dinamic mesajul de eroare !!!!!!
        WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(
               By.xpath("//ul[contains(@class, 'woocommerce-error')]/li")));
        String passwordErrorText = passwordError.getText();
        System.out.println("Mesaj de eroare la email neexistent este: " + passwordErrorText);


        //Sterg datele initiale si adaug date valide pt a face login
        WebElement userLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        userLogin.clear();
        userLogin.sendKeys("carmentest@gmail.com");
        System.out.println("Completat email: carmentest@gmail.com");

        WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passField.clear();
        passField.sendKeys("T3st1234!2025");
        System.out.println("Completat password field: T3st1234!2025");


        // Apăsăm butonul de login
        WebElement loginFlow = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@type='submit']")));
        js.executeScript("arguments[0].click();", loginFlow);

    }
}

