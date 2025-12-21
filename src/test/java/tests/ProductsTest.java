package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    @Owner("Vladimir example@email.com")
    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Adding products to cart")
    public void checkGoodsAdded() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage.isPageLoaded("Products");
        productsPage
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Onesie")
                .addToCart(3);

        assertEquals(productsPage.checkGoodsQuantity(), "3");
    }
}
