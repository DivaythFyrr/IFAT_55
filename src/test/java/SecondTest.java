import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SecondTest {
    @Test
    public void checkZipCodeInput() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.cssSelector("[name='zip_code']")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@type='submit' and contains(@value,'Continue')]")).click();

        boolean isErrorAppear = driver.findElement(By.cssSelector(".error_message")).isDisplayed();
        assertTrue(isErrorAppear, "Error message is not appear");

        String errorMessageText = driver.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorMessageText, "Oops, error on page. ZIP code should have 5 digits");
        driver.quit();


    }

    @Test
    public void checkZipCodeFiveDigitInput() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.cssSelector("[name='zip_code']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@type='submit' and contains(@value,'Continue')]")).click();

        boolean isRegistryBtnExist = driver.findElement(By.cssSelector("[value='Register']")).isDisplayed();
        assertTrue(isRegistryBtnExist, "Registry btn is not visible");

        driver.quit();


    }
}
