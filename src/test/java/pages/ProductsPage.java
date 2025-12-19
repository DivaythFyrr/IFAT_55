package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART_BUTTON_PATTERN = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    By cartBadge = By.xpath("//*[@data-test='shopping-cart-badge']");

    public ProductsPage(WebDriver driver) {

        super(driver);
    }

    @Step("Add product '{goodsName}' to cart")
    public ProductsPage addToCart(final String goodsName) {
        By addGoodsToCart = By.xpath(ADD_TO_CART_BUTTON_PATTERN.formatted(goodsName));
        driver.findElement(addGoodsToCart).click();
        return this;
    }

    @Step("Add '{goodsOrder}' product(s) to cart")
    public ProductsPage addToCart(final int goodsOrder) {
        driver.findElements(By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"))).get(goodsOrder).click();
        return this;
    }

    @Step("Get current number of items in the cart")
    public String checkGoodsQuantity() {
        return driver.findElement(cartBadge).getText();
    }

    @Step("Open the Cart page")
    public ProductsPage switchToCart() {
        driver.findElement(cartBadge).click();
        return this;
    }
}
