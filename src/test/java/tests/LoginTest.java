package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class LoginTest extends BaseTest {
    @DataProvider(name = "invalidData")
    public Object[][] loginData() {
        return new Object[][]{
                {UserFactory.withLockedUserPermission(),
                        "Epic sadface: Sorry, this user has been locked out."},

                {UserFactory.withPasswordOnly(""),
                        "Epic sadface: Password is required"},

                {UserFactory.withUsernameOnly(""),
                        "Epic sadface: Username is required"},

                {new User("Locked_out_user", "secret_sauce"),
                        "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Severity(SeverityLevel.BLOCKER)
    @Owner("Vladimir example@email.com")
    @Issue("IFAT_55")
    @TmsLink("IFAT_55")
    @Test(description = "Check incorrect login", priority = 1, dataProvider = "invalidData")
    public void checkIncorrectLogin(User user, String errorMsg) {
        loginPage
                .open()
                .login(user);

        assertTrue(loginPage.isErrorMsgAppear(), "Error message is not appear");
        assertEquals(loginPage.errorMsgText(), errorMsg);
    }

    @Severity(SeverityLevel.BLOCKER)
    @Test(description = "Check correct login", priority = 2)
    public void checkCorrectLogin() {
        loginPage
                .open()
                .login(withAdminPermission());

        assertTrue(productsPage.isPageLoaded(PRODUCTS.getDisplayName()), "Incorrect login");
    }
}
