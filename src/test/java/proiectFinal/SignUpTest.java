package proiectFinal;

import modelObject.SignUpModel;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.SignUpPage;
import sharedData.SharedData;
import suites.TestCaseSuites;
import suites.TestSuites;

public class SignUpTest extends SharedData {

    @Test (groups = {TestSuites.REGRESSION_SUITE, TestSuites.SIGNUP_SUITE,
            TestCaseSuites.TICKET_321, TestCaseSuites.TC_467, TestCaseSuites.TC_468})
    public void metodaTest() {
        SignUpPage signUpPage = new SignUpPage(getDriver());
        SignUpModel testData = new SignUpModel("src/test/resources/testData/signUpData.json");

        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.acceptConsentPopup();
        indexPage.clickOnMyAccount();


        // Validare conținut inițial al formularului (ex: câmpuri, erori implicite)
        signUpPage.validateInitialFormContent(testData);

        // Test înscriere cu formular gol - verificare mesaj eroare
        signUpPage.submitEmptyForm();
        signUpPage.validateErrorMessage(testData.getExpectedEmptyFormError());


        // Test înscriere cu date valide (email nou din emailValue)
        signUpPage.fillEmail(testData.getRegisteredEmail()); //am schimbat getEmailValue
        signUpPage.fillPassword(testData.getRegisteredPassword()); //am schimbat getPasswordValue
        signUpPage.clickRegister();
        signUpPage.validateErrorMessage(testData.getExpectedAlreadyRegisteredError());

//Inregistrare cu email dinamic
        String newEmail = testData.getEmailValue();
        System.out.println("Email generat: " + testData.getEmailValue());
        signUpPage.fillEmail(newEmail);
        signUpPage.fillPassword(testData.getPasswordValue());

        signUpPage.clickRegister();


        // Poți adăuga validări pentru succes (ex: mesaj de confirmare, redirect)
        signUpPage.validateSuccessfulRegistration();

        // Eventual, test logout după înregistrare
        signUpPage.clickLogout();
    }

}