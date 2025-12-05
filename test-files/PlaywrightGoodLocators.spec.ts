import { test, expect } from '@playwright/test';

test.describe('Login Tests - Best Practices', () => {
  test('should login with good locators', async ({ page }) => {
    await page.goto('https://account.box.com');
    
    // GOOD: Using getByLabel for form fields
    await page.getByLabel('Email').fill('user@example.com');
    
    // GOOD: Using getByRole for buttons
    await page.getByRole('button', { name: 'Continue' }).click();
    
    // GOOD: Using getByTestId for test-specific selectors
    await page.getByTestId('password-input').fill('password123');
    
    // GOOD: Using getByText for text content
    await page.getByText('Sign In').click();
    
    // GOOD: Using getByRole with name
    await page.getByRole('link', { name: 'Dashboard' }).click();
  });
  
  test('should navigate with semantic locators', async ({ page }) => {
    await page.goto('https://account.box.com');
    
    // GOOD: Using getByRole for navigation
    await page.getByRole('link', { name: 'Files' }).click();
    
    // GOOD: Using getByLabel for form elements
    await page.getByLabel('Search files').fill('test document');
  });
});

