package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class CartPage extends BasePage {
    By cartProduct = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get list of products names from the cart")
    public ArrayList<String> getProductsNames() {
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : driver.findElements(cartProduct)) {
            names.add(product.getText());
        }

        return names;
    }
}
