package proiectFinal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sharedData.SharedData;

import java.time.Duration;
import java.util.List;

public class HomePage extends SharedData {


    @Test
    public void metodaTest () {

            JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement menuNavElement = driver.findElement(By.id("main-nav"));
            js.executeScript("arguments[0].click();", menuNavElement);

            //WebElement consentPopupElement = driver.findElement(By.xpath("//button[@class='fc-button fc-cta-consent fc-primary-button']"));
            //js.executeScript("arguments[0].click();", consentPopupElement);


            WebElement shopElements = driver.findElement(By.id("menu-item-40"));
            shopElements.click();

            WebElement hpMenuElement = driver.findElement(By.xpath("//nav[@class='woocommerce-breadcrumb']/a[text()= 'Home']"));
            hpMenuElement.click();

            //WebElement hpSliderElement = driver.findElement(By.xpath("//div[@class='accordion-title']/a[@href='#']/i[@class='accordion-active-icon fa fa-close']"));
            //js.executeScript("arguments[0].click();", hpSliderElement);

            //Identificam numarul de Slider-uri
            List<WebElement> sliders = driver.findElements(By.className("n2-ss-slide-background"));
            int numarSlideuri = sliders.size(); // Salvăm numărul de slide-uri

            // Verificăm dacă sunt exact trei slide-uri
            if (numarSlideuri == 3) {
            System.out.println("Test PASSED: Pagina de home are exact trei slide-uri.");
            } else {
            System.out.println("Test FAILED: Pagina de home are " + numarSlideuri + " slide-uri.");
            }

            // Identificam numarul total de Arrivals de pe pagină
            List<WebElement> arrivals = driver.findElements(By.xpath("//div[@class = 'woocommerce']"));
            int numarArrivals = arrivals.size();

            // Verificăm că sunt EXACT 3 arrivals
            if (numarArrivals ==  3) {
                    System.out.println("Test PASSED: Pagina de home conține exact trei arrivels.");
            } else {
                    System.out.println("Test FAILED: Pagina de home are " + numarArrivals + " arrivels.");
            }


            // Verificam ca imaginea de pe Arrivals este clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement imageArrivel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='text-22-sub_row_1-0-2-1-0']/div/ul/li/a[1]/img")));
            //Facem scroll in pagina
            js.executeScript("arguments[0].scrollIntoView(true);", imageArrivel);
           //Se face click pe imagine
            js.executeScript("arguments[0].click();", imageArrivel);

            // Verificăm URL-ul paginii după click
            String currentUrl = driver.getCurrentUrl();
            System.out.println("URL curent: " + currentUrl);
            Assert.assertTrue(currentUrl.contains("thinking-in-html"), "FAILED: Nu s-a realizat navigarea către pagina produsului.");
            System.out.println("PASSED: Navigare corectă către pagina produsului.");



            // Verificăm dacă butonul "Add to basket" este afișat și activ
            WebElement addToBasketBtn = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
            Assert.assertTrue(addToBasketBtn.isDisplayed(), "'Add to basket' button is not displayed.");
            Assert.assertTrue(addToBasketBtn.isEnabled(), "'Add to basket' button is not enabled.");


            //Click pe Review tab
            WebElement reviewTab = driver.findElement(By.id("tab-reviews"));
            //Facem scroll in pagina
            js.executeScript("arguments[0].scrollIntoView(true);", reviewTab);
            js.executeScript("arguments[0].click();",reviewTab);

            //Editez valoarea si fac click pe add to cart
            WebElement cantitateInput = driver.findElement(By.name("quantity"));
            cantitateInput.clear();
            cantitateInput.sendKeys("2");

            // Apoi dăm click pe butonul de adăugare în coș
            WebElement addToBasket = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
            addToBasket.click();

            //Click pe View Basket
            WebElement viewBasket = driver.findElement(By.xpath("//a[@class='button wc-forward']"));
            js.executeScript("arguments[0].click();", viewBasket);

            //Check user ii redurectionat pe Basket page
            String paginaUrl = driver.getCurrentUrl();
            System.out.println("URL curent: " + paginaUrl);
            Assert.assertTrue(paginaUrl.contains("basket"), "FAILED: Utilizatorul NU a fost redirecționat către pagina Basket.");
            System.out.println("PASSED: Utilizatorul a fost redirecționat către pagina Basket.");


            // Închidem browserul
            driver.quit();








    }

}
