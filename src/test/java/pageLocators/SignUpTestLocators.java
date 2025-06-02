package pageLocators;

import org.openqa.selenium.By;

public class SignUpTestLocators {

    public static final By emailFieldElements = By.id("reg_email");
    public static final By inputFieldsElements = By.cssSelector("form.register input[type='email'], form.register input[type='password']");
    public static final By registerButtonElements = By.cssSelector("form.register input[name='register']");
    public static final By errorMessageElements = By.cssSelector("ul.woocommerce-error li");
    public static final By passwordFieldElements = By.id("reg_password");
    public static final By clickLogOutElements = By.cssSelector(".woocommerce-MyAccount-navigation-link--customer-logout");

    }
