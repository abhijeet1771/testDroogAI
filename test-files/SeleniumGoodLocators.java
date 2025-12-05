import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumGoodLocators {
    private WebDriver driver;
    
    public void loginWithGoodLocators() {
        driver.get("https://account.box.com");
        
        // GOOD: Using By.id for ID selectors
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("user@example.com");
        
        // GOOD: Using By.id for password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("password123");
        
        // GOOD: Using By.cssSelector with data-testid
        WebElement submitButton = driver.findElement(By.cssSelector("[data-testid='submit-button']"));
        submitButton.click();
        
        // GOOD: Using By.cssSelector with data-testid for links
        WebElement navLink = driver.findElement(By.cssSelector("[data-testid='dashboard-link']"));
        navLink.click();
    }
    
    public void findElementWithBestPractices() {
        // GOOD: Using data-testid
        WebElement element = driver.findElement(By.cssSelector("[data-testid='submit-button']"));
        element.click();
    }
}

