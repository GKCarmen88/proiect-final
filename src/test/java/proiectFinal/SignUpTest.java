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

public class SignUpTest extends SharedData {

    @Test
    public void metodaTest() {

        String emailValue  = "carmentest" + System.currentTimeMillis() + "@gmail.com";
        String passwordValue = "T3st1234!2025";

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement menuNavElement = driver.findElement(By.id("main-nav"));
        js.executeScript("arguments[0].click();", menuNavElement);

        //WebElement consentPopupElement = driver.findElement(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']"));
        //js.executeScript("arguments[0].click();", consentPopupElement);


        WebElement myAccountElements = driver.findElement(By.id("menu-item-50"));
        myAccountElements.click();


        //Inspectare de fielduri de pe form-ul de Sign-up
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg_email")));

        List<WebElement> inputFields = driver.findElements(By.cssSelector("form.register input[type='email'], form.register input[type='password']"));
        Assert.assertEquals(inputFields.size(), 2, "Verificam ca Form-ul de Sign-Up are exact 2 fielduri (email și parolă) si buttonul de Register.");
        for (WebElement field : inputFields) {
            System.out.println("Input field: " + field.getAttribute("type") + field.getAttribute("placeholder"));

        }
        // Verificăm existența butonului REGISTER (care e de tip input, nu button)
        WebElement registerButton = driver.findElement(By.cssSelector("form.register input[name='register']"));
        System.out.println("Butonul REGISTER: " + registerButton.getAttribute("type"));


        //verificam functionalitatea butonului "Register"
        WebElement clickRegister = driver.findElement(By.cssSelector("form.register input[name='register']"));
        js.executeScript("arguments[0].click();",clickRegister);


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("ul.woocommerce-error li")));

        //Verific mesajul de eroare pt required fields
        String errorText = errorMessage.getText();
        System.out.println("Mesaj de eroare este: " + errorText);

        Assert.assertEquals(errorText.trim(), "Error: Please provide a valid email address.",
                "Verificăm dacă mesajul de eroare este cel corect când nu completăm emailul.");

        //Verificam validarea pt email deja folosit
        WebElement emailField = driver.findElement(By.id("reg_email"));
        emailField.clear();
        emailField.sendKeys("carmentest@gmail.com");

        WebElement passwordField = driver.findElement(By.id("reg_password"));
        passwordField.clear();
        passwordField.sendKeys("T3st1234!2025");

        WebElement registerButtonAgain = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("form.register input[name='register']")));
        js.executeScript("arguments[0].click();", registerButtonAgain);

        WebElement secondEmailError = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("ul.woocommerce-error li")));
        String secondErrorText = secondEmailError.getText();
        System.out.println("Mesaj de eroare la email deja folosit: " + secondErrorText);

        Assert.assertEquals(secondErrorText.trim(),
                "Error: An account is already registered with your email address. Please login.",
                "Verificăm mesajul pentru email deja înregistrat.");



        //Stergem fielduriile de email si passwords, pt a continua testul cu date valide

        WebElement emailFieldReg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg_email")));
        emailFieldReg.clear();
        emailFieldReg.sendKeys(emailValue);
        System.out.println("Completat email: " + emailValue);


        WebElement passwordFieldReg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reg_password")));
        passwordFieldReg.clear();
        passwordFieldReg.sendKeys(passwordValue);
        System.out.println("Completat password field: " + passwordValue);


        // Click pe butonul Register
        WebElement clickRegisterButton = driver.findElement(By.cssSelector("form.register input[name='register']"));
        js.executeScript("arguments[0].click();", clickRegisterButton);


        //Logout din app
        WebElement clickLogOut = driver.findElement(By.xpath("//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout']"));
        js.executeScript("arguments[0].click();",clickLogOut);



    }
}
