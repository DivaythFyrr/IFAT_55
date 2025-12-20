package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static enums.TitleNaming.CARTS;
import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {
    @Owner("Vladimir example@email.com")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Availability of goods in the cart")
    public void checkGoodsInCart() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.isPageLoaded("Products");
        productsPage
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Onesie")
                .switchToCart();

        cartPage.isPageLoaded(CARTS.getDisplayName());
        assertEquals(cartPage.getProductsNames().size(), 2);
        assertFalse(cartPage.getProductsNames().isEmpty());
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Onesie"));
    }
}
