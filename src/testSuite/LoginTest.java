package testSuite;

import browserFactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void browserSetUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
        String expected = "Welcome Back!";
        String actual = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();

        Assert.assertEquals("Actual and expected are equal", expected, actual);

    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("abc123");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("abc");
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        String expected = " Invalid email or password.";
        String actual = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();

       // Assert.assertEquals("Actual and expected message are equal", expected, actual);

    }


    @After
    public void Teardownbrowser() {
        closeBrowser();
    }
}
