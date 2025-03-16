package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    
    @Test
    public void testLoginWithValidCredentials() {
        // Enter username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        
        // Enter password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        
        // Click login button
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        
        // Verify successful login by checking the presence of the products title
        WebElement productsTitle = driver.findElement(By.className("title"));
        Assert.assertEquals(productsTitle.getText(), "Products", "Login failed: Products page not displayed");
    }
} 