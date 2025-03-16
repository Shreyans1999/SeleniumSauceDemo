package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    
    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable you downloaded
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver-win64\\chromedriver.exe");
        
        // Create Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        
        // Initialize the Chrome Driver with options
        driver = new ChromeDriver(options);
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Navigate to the SauceDemo website
        driver.get("https://www.saucedemo.com/");
    }
    
    @AfterMethod
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
} 