package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {
    public WebDriver driver;

    @BeforeMethod
    public void testEnv(){
        driver = new ChromeDriver();

        //Accesam o pagina Web
        driver.get("https://practice.automationtesting.in");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void clearEnv(){
        driver.quit();
    }
}
