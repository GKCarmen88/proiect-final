package proiectFinal;

import modelObject.HomePageModel;
import org.testng.annotations.Test;
import pages.HPTestPage;
import pages.IndexPage;
import sharedData.SharedData;
import suites.TestCaseSuites;
import suites.TestSuites;

public class HomePageTest extends SharedData {

        @Test (groups = {TestSuites.REGRESSION_SUITE, TestSuites.HOME_PAGE_SUITE,
                TestCaseSuites.TICKET_123, TestCaseSuites.TC_457, TestCaseSuites.TC_459})


        public void metodaTest() {
                HomePageModel testData = new HomePageModel("src/test/resources/testData/HomePageData.json");
                IndexPage indexPage = new IndexPage(getDriver());



                indexPage.acceptConsentPopup();
                indexPage.waitForBreadcrumbVisible();
                indexPage.clickOnShopMenu();
                indexPage.verifyNavigationTabIsVisible();

                indexPage.waitForMenuNavVisible();
                indexPage.waitForBreadcrumbVisible();
                indexPage.clickOnHomeBreadcrumb();

                HPTestPage homePage = new HPTestPage(getDriver());


                homePage.waitForOverlayToDisappear();
                homePage.verifyNumberOfSlides(testData.getExpectedSliderCount());
                homePage.verifyNumberOfArrivals(testData.getExpectedArrivalsCount());
                homePage.clickOnArrivalImage();

                homePage.waitForUrlToContain(testData.getProductURLFragment());
                homePage.verifyCurrentUrlContains(testData.getProductURLFragment());

                // Setează cantitatea o singură dată
                homePage.setProductQuantity(testData.getArrivalQuantity());

                // Click pe Add to Basket
                homePage.clickAddToBasket();

                // Așteaptă navigarea spre pagina basket
                homePage.waitForUrlToContainBasket();

                // Click pe View Basket (dacă este necesar)
                homePage.clickViewBasket();

                // Verifică redirecționarea
                homePage.verifyRedirectionToBasket();

                // Verifică mesajul de confirmare
                homePage.verifyConfirmationMessage(testData.getMessageText());

        }
}