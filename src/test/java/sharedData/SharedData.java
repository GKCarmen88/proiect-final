package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {

    private WebDriver driver;
    private String testName;

    @BeforeMethod (alwaysRun = true)
    public void testEnv(){
        testName = this.getClass().getSimpleName();

        String remoteEnv = System.getProperty("remote");
        if (Boolean.parseBoolean(remoteEnv)){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        }

        //Accesam pagina Web
        driver.get("https://practice.automationtesting.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LoggerUtility.startTest(testName);
    }

    @AfterMethod
    public void clearEnv(){
        driver.quit();
        LoggerUtility.finishTest(testName);
    }

    public WebDriver getDriver(){
        return driver;
    }

}
