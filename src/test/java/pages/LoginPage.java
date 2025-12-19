package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    By userField = By.cssSelector("[placeholder='Username']");
    By passwordField = By.cssSelector("[placeholder='Password']");
    By loginBtn = By.id("login-button");
    By errorWindow = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening a page")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Authorization under user credentials: login = {user.email}, password = ******")
    public void login(User user) {
        enterLoginName(user.getEmail());
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(loginBtn).click();
    }

    @Step("Enter login")
    public void enterLoginName(final String userName) {

        driver.findElement(userField).sendKeys(userName);
    }

    @Step("Error message is displayed")
    public boolean isErrorMsgAppear() {
        return driver.findElement(errorWindow).isDisplayed();
    }

    @Step("Get text from error message")
    public String errorMsgText() {
        return driver.findElement(errorWindow).getText();
    }
}
