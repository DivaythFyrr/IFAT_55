import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkIncorrectLogin() {
        loginPage.open();
        loginPage.login("locked_out_user","secret_sauce");

        assertTrue(loginPage.isErrorMsgAppear(), "Error message is not appear");
        assertEquals(loginPage.errorMsgText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");

        assertTrue(productsPage.isPageLoaded(), "Incorrect login");
    }
}
