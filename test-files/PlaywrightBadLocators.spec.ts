import { test, expect } from '@playwright/test';

test.describe('Login Tests', () => {
  test('should login with bad locators', async ({ page }) => {
    await page.goto('https://account.box.com');
    
    // BAD: Using XPath (should use getByRole or getByTestId)
    await page.locator('xpath=//input[@id="login"]').fill('user@example.com');
    
    // BAD: Using CSS selector for button (should use getByRole)
    await page.locator('button.submit-btn').click();
    
    // BAD: Using ID selector (should use getByTestId if it's a test ID)
    await page.locator('#password-field').fill('password123');
    
    // BAD: Using text= selector (should use getByText)
    await page.locator('text=Submit').click();
    
    // BAD: Using complex CSS selector
    await page.locator('div.container > form > button[type="submit"]').click();
  });
  
  test('should navigate with bad selectors', async ({ page }) => {
    await page.goto('https://account.box.com');
    
    // BAD: XPath for link
    await page.locator('xpath=//a[@href="/dashboard"]').click();
    
    // BAD: CSS selector for link (should use getByRole)
    await page.locator('a.nav-link').click();
  });
});

