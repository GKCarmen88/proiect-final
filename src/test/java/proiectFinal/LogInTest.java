package proiectFinal;

import modelObject.LogInModel;
import org.testng.annotations.Test;
import pageLocators.LogInTestLocators;
import pages.IndexPage;
import pages.LogInPage;
import sharedData.SharedData;
import suites.TestCaseSuites;
import suites.TestSuites;

public class LogInTest extends SharedData {

    @Test (groups = {TestSuites.REGRESSION_SUITE, TestSuites.LOGIN_SUITE,
            TestCaseSuites.TICKET_123, TestCaseSuites.TC_456, TestCaseSuites.TC_458})
    public void metodaTest()  {
        LogInPage logInPage = new LogInPage(getDriver());
        LogInModel testData = new LogInModel("src/test/resources/testData/logInData.json",2);
        LogInModel loginModel = new LogInModel("src/test/resources/testData/logInData.json", 2);
        // Dacă vrei, poți să apelezi și setter-ul ca să te asiguri (opțional)
        loginModel.setExpectedInputFieldCount(2);



        IndexPage indexPage = new IndexPage(getDriver());
        indexPage.acceptConsentPopup();
        indexPage.clickOnMyAccount();
        indexPage.waitForMyAccountPageToLoad();  // asta asigură că pagina s-a încărcat după click




        //  Validare conținut inițial al formularului
        logInPage.validateEntireLoginFormContent(testData);

        //  Validare checkbox "remember me"
        logInPage.validateRememberMeCheckbox(testData);

        //  Test login invalid
        logInPage.validateInvalidLoginMessage(testData);

        //  Test text link "Lost password"
        logInPage.checkLostPasswordText(testData.getLostPasswordText());

        //  Test login valid
        logInPage.validateValidLoginFlow(testData);

    }
}