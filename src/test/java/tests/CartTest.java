package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    
    @Test
    public void testAddItemToCart() {
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
        
        // Verify that the cart badge shows 1 item
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge.getText(), "1", "Cart badge does not show correct item count");
        
        // Click on cart icon
        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();
        
        // Verify that the item is in the cart
        WebElement cartItem = driver.findElement(By.className("inventory_item_name"));
        Assert.assertEquals(cartItem.getText(), "Sauce Labs Backpack", "Item not found in cart");
    }
} 