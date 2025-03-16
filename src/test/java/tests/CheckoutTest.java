package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {
    
    @Test
    public void testCheckoutProcess() {
        // Login first
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");
        
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        
        // Add the first product to cart
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        
        // Go to cart
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
        
        // Click checkout button
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        
        // Fill in checkout information
        WebElement firstNameField = driver.findElement(By.id("first-name"));
        firstNameField.sendKeys("John");
        
        WebElement lastNameField = driver.findElement(By.id("last-name"));
        lastNameField.sendKeys("Doe");
        
        WebElement postalCodeField = driver.findElement(By.id("postal-code"));
        postalCodeField.sendKeys("12345");
        
        // Click continue button
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
        
        // Click finish button
        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
        
        // Verify order confirmation
        WebElement confirmationMessage = driver.findElement(By.className("complete-header"));
        Assert.assertEquals(confirmationMessage.getText(), "Thank you for your order!", 
                "Order confirmation message not displayed");
    }
} 