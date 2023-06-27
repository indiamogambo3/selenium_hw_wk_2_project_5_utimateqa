package testsuite;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully
 * * click on the ‘Sign In’ link
 * * Verify the text ‘Welcome Back!’
 * 2. verifyTheErrorMessage
 * * click on the ‘Sign In’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Invalid email
 * or password.’
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUpUrl() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        //Find 'Sign In' element and click on 'Sign In' link
        driver.findElement(By.partialLinkText("Sign ")).click();
        //Verify the text 'Welcome Back'
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class = 'page__heading']")).getText();
        Assert.assertEquals("'Welcome Back!' text error", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {

        //Find 'Sign In' element and click on 'Sign In' link
        driver.findElement(By.partialLinkText("Sign ")).click();
        //Find 'Email' element and enter invalid email in 'Email' field
        driver.findElement(By.id("user[email]")).sendKeys("mukz123@gmail.com");
        //Find 'Password' element and enter invalid password in 'Password' field
        driver.findElement(By.id("user[password]")).sendKeys("ghdgf");
        //Find 'Sign in' button element and click on 'Sign in' button
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        //Verify the error message 'Invalid email or password.'
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class = 'form-error__list-item']")).getText();
        Assert.assertEquals("'Invalid email or password.'", expectedText, actualText);
    }

    @After
    public void tearDown() {

        closeBrowser();
    }

}
