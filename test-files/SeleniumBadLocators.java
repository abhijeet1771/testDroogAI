import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumBadLocators {
    private WebDriver driver;
    
    public void loginWithBadLocators() {
        driver.get("https://account.box.com");
        
        // BAD: Using XPath (should use By.id or By.cssSelector with data-testid)
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
        emailField.sendKeys("user@example.com");
        
        // BAD: Using CSS selector for ID (should use By.id)
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys("password123");
        
        // BAD: Using className (should use data-testid)
        WebElement submitButton = driver.findElement(By.className("submit-button"));
        submitButton.click();
        
        // BAD: Complex XPath
        WebElement navLink = driver.findElement(By.xpath("//div[@class='nav']//a[contains(@href, 'dashboard')]"));
        navLink.click();
    }
    
    public void findElementWithXPath() {
        // BAD: XPath for text search
        WebElement element = driver.findElement(By.xpath("//button[text()='Submit']"));
        element.click();
    }
}

