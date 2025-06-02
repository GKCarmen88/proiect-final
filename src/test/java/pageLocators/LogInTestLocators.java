package pageLocators;

import org.openqa.selenium.By;

public class LogInTestLocators {


    public static final By loginElements = By.cssSelector("form.login");
    public static final By loginButtonElements = By.cssSelector("button[type='submit'], input[type='submit']");
    public static final By rememberMeElements = By.cssSelector("input[type='checkbox']");
    public static final By lostPasswordLinkElements = By.linkText("Lost your password?");
    public static final By clickLoginElements = By.cssSelector("button[type='submit'], input[type='submit']");
    public static final By inputFieldsElements = By.cssSelector("input[type='text'], input[type='password']");
    public static final By errorMessageElements = By.className("woocommerce-error");
    public static final By emailFieldElements = By.id("username");
    public static final By passwordFieldElements = By.id("password");
    public static final By secondErrorElements = By.xpath("//div[@class='woocommerce']//ul[@class='woocommerce-error']");
    public static final By passwordErrorElements = By.xpath("//ul[contains(@class, 'woocommerce-error')]/li");

    public static final By clickAgainLoginElements = By.xpath("//input[@type='submit']");
    public static final By emailFieldLogElements = By.id("username");
    public static final By passFieldLogElements = By.id("password");
    public static final By typeEmailElements = By.id("username");
    public static final By incorectPasswordElements = By.id("password");

    public static final By clickLogElements = By.xpath("//input[@type='submit']");
    public static final By userLoginElements = By.id("username");
    public static final By passFieldElements = By.id("password");
    public static final By loginFlowElements = By.xpath("//input[@type='submit']");

}
