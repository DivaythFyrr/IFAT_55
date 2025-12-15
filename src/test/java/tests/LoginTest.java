package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @DataProvider(name = "invalidData")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"Locked_out_user", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(description = "Incorrect login", priority = 1, dataProvider = "invalidData")

    public void checkIncorrectLogin(String user, String password, String errorMsg) {
        loginPage.open();
        loginPage.login(user, password);
        assertTrue(loginPage.isErrorMsgAppear(), "Error message is not appear");
        assertEquals(loginPage.errorMsgText(), errorMsg);
    }

    @Test(description = "Standard user", priority = 2)
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertTrue(productsPage.isPageLoaded("Products"), "Incorrect login");
    }
}
