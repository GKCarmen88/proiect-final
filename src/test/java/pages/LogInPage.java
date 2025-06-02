package pages;

import loggerUtility.LoggerUtility;
import modelObject.LogInModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageLocators.LogInTestLocators;

import java.util.List;

public class LogInPage extends BasePage {



    public LogInPage(WebDriver driver) {
        super(driver);


    }
    public void validateEntireLoginFormContent(LogInModel testData) {
        logInHelper.waitForVisible(LogInTestLocators.loginElements);
        logInHelper.waitForVisible(By.cssSelector("form.login"));

        List<WebElement> loginFormFields = logInHelper.getLoginFormFields(
                LogInTestLocators.loginElements,
                LogInTestLocators.inputFieldsElements
        );

        Assert.assertEquals(loginFormFields.size(), testData.getExpectedInputFieldCount(),
                "Formularul trebuie să aibă exact " + testData.getExpectedInputFieldCount() + " input-uri.");
        LoggerUtility.infoLog("Numărul de input-uri din formular este corect: " + loginFormFields.size());

        String emailInputName = logInHelper.getElementAttribute(LogInTestLocators.emailFieldElements, "name");
        Assert.assertEquals(emailInputName, testData.getUsernameName(), "Primul câmp ar trebui să fie pentru email.");
        LoggerUtility.infoLog("Câmpul de email are atributul 'name' corect: " + emailInputName);

        String passwordInputName = logInHelper.getElementAttribute(LogInTestLocators.passwordFieldElements, "name");
        Assert.assertEquals(passwordInputName, testData.getPasswordName(), "Al doilea câmp ar trebui să fie pentru parolă.");
        LoggerUtility.infoLog("Câmpul de parolă are atributul 'name' corect: " + passwordInputName);

        String checkboxName = logInHelper.getElementAttribute(LogInTestLocators.rememberMeElements, "name");
        Assert.assertEquals(checkboxName, testData.getCheckboxName(), "Checkbox-ul trebuie să aibă numele corect.");
        LoggerUtility.infoLog("Checkbox-ul 'remember me' are numele: " + checkboxName);

        String lostPasswordText = logInHelper.getElementText(LogInTestLocators.lostPasswordLinkElements);
        Assert.assertEquals(lostPasswordText, testData.getLostPasswordText(), "Textul linkului nu este corect.");
        LoggerUtility.infoLog("Textul linkului pentru recuperare parolă este: " + lostPasswordText);
    }

    public void validateInvalidLoginMessage(LogInModel testData) {
        logInHelper.fillEmailVariant(LogInTestLocators.emailFieldElements, testData.getInvalidEmail());
        logInHelper.fillPasswordVariant(LogInTestLocators.passwordFieldElements, testData.getInvalidPassword());
        logInHelper.clickLoginButtonVariant(LogInTestLocators.clickLoginElements);

        // Folosește un mesaj de eroare așteptat corect
        String expectedErrorMessageFragment = "The password you entered for the username";
        logInHelper.validateElementText(LogInTestLocators.errorMessageElements, expectedErrorMessageFragment);

        LoggerUtility.infoLog("Mesajul de eroare a fost afișat corect pentru credentiale invalide.");
    }

//    public void validateInvalidLoginMessage(LogInModel testData) {
//        logInHelper.fillEmailVariant(LogInTestLocators.emailFieldElements, testData.getInvalidEmail());
//        logInHelper.fillPasswordVariant(LogInTestLocators.passwordFieldElements, testData.getInvalidPassword());
//        logInHelper.clickLoginButtonVariant(LogInTestLocators.clickLoginElements);
//
//        logInHelper.validateElementText(LogInTestLocators.errorMessageElements, testData.getInvalidPassword());
//        LoggerUtility.infoLog("Mesajul de eroare a fost afișat corect pentru credentiale invalide.");
//    }

    public void validateValidLoginFlow(LogInModel testData) {
        logInHelper.fillEmailVariant(LogInTestLocators.emailFieldElements, testData.getValidEmail());
        logInHelper.fillPasswordVariant(LogInTestLocators.passwordFieldElements, testData.getValidPassword());
        logInHelper.clickLoginButtonVariant(LogInTestLocators.clickLoginElements);

        // Aici adaugă eventual validări pentru un element vizibil post-login, dacă aplicația o permite
        LoggerUtility.infoLog("Login-ul cu credentiale valide s-a efectuat cu succes.");
    }

    public void validateRememberMeCheckbox(LogInModel testData) {
        String actualCheckboxName = logInHelper.getElementAttribute(LogInTestLocators.rememberMeElements, "name");
        Assert.assertEquals(actualCheckboxName, testData.getCheckboxName(), "Checkbox-ul trebuie să aibă numele corect.");
        LoggerUtility.infoLog("Checkbox-ul are numele corect: " + actualCheckboxName);
    }
    public void checkLostPasswordText(String expectedText) {
        logInHelper.validateElementContainsText(LogInTestLocators.lostPasswordLinkElements, expectedText);
    }


}