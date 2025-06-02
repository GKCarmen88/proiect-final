package pages;

import helpMethod.SignUpHelper;
import loggerUtility.LoggerUtility;
import modelObject.SignUpModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.awt.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SignUpPage {

    private SignUpHelper helper;

    public SignUpPage(WebDriver driver) {
        this.helper = new SignUpHelper(driver);
    }

    public void validateInitialFormContent(SignUpModel data) {
        String emailValue = helper.getEmailFieldValue();
        String passwordValue = helper.getPasswordFieldValue();

        Assert.assertEquals(emailValue, "", "Email field ar trebui să fie gol la început.");
        Assert.assertEquals(passwordValue, "", "Password field ar trebui să fie gol la început.");
        // Adaugă alte validări inițiale dacă ai nevoie
    }

    public void submitEmptyForm() {
        helper.submitEmptyForm();
    }

    public void validateErrorMessage(String expectedMessage) {
        String actualMessage = helper.getErrorMessageText();
        Assert.assertEquals(actualMessage, expectedMessage, "Mesajul de eroare nu corespunde.");
    }
    public void fillEmail(String email) {
        helper.fillEmailField(email);
    }

    public void fillPassword(String password) {
        helper.fillPasswordField(password);
    }


    public void clickRegister() {
        helper.clickRegister();
    }
//pt a face registration
    public void changeEmail(String email) {
    helper.changeEmailField(email);
    }


    public void validateSuccessfulRegistration() {
        Assert.assertTrue(helper.isRedirectedToMyAccount(), "Nu s-a făcut redirect la pagina de cont după înregistrare.");
    }

    public void clickLogout() {
        helper.clickLogout();
    }
}
