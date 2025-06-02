package pageLocators;

import org.openqa.selenium.By;

public class HomePageTestLocators {



        public static final By slidersElements = By.className("n2-ss-slide-background");
        public static final By arrivalsElements = By.cssSelector(".products .product");
        public static final By imageArrivelElements = By.xpath("//*[@id='text-22-sub_row_1-0-2-1-0']/div/ul/li/a[1]/img");
        public static final By addToBasketBtnElements = By.cssSelector("button.single_add_to_cart_button");
        public static final By viewBasketElements = By.cssSelector("div.woocommerce-message a.button.wc-forward");

        public static final By cantitateInputElements =  By.xpath("//div[contains(@class, 'quantity')]//input[@name='quantity']");
        public static final By addToBasketElements = By.cssSelector("button.single_add_to_cart_button.alt");
        public static final By confirmMessage = By.cssSelector(".woocommerce-message");



}

