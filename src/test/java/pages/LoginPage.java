package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    By userField = By.cssSelector("[placeholder='Username']");
    By passwordField = By.cssSelector("[placeholder='Password']");
    By loginBtn = By.id("login-button");
    By errorWindow = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(final String userName, final String passwordName) {
        enterLoginName(userName);
        driver.findElement(passwordField).sendKeys(passwordName);
        driver.findElement(loginBtn).click();
    }

    public void enterLoginName(final String userName) {

        driver.findElement(userField).sendKeys(userName);
    }

    public boolean isErrorMsgAppear() {
        return driver.findElement(errorWindow).isDisplayed();
    }

    public String errorMsgText() {
        return driver.findElement(errorWindow).getText();
    }
}
