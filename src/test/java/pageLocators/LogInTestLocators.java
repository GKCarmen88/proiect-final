package pageLocators;

import org.openqa.selenium.By;

public class LogInTestLocators {


    public static final By loginElements = By.cssSelector("form.login");
    public static final By rememberMeElements = By.cssSelector("input[type='checkbox']");
    public static final By lostPasswordLinkElements = By.linkText("Lost your password?");
    public static final By clickLoginElements = By.cssSelector("button[type='submit'], input[type='submit']");
    public static final By inputFieldsElements = By.cssSelector("input[type='text'], input[type='password']");
    public static final By errorMessageElements = By.className("woocommerce-error");
    public static final By emailFieldElements = By.id("username");
    public static final By passwordFieldElements = By.id("password");



}
