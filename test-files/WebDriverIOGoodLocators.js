describe('Login Tests with Good Locators', () => {
  it('should login using best practices', async () => {
    await browser.url('https://account.box.com');
    
    // GOOD: Using data-testid
    const emailField = await $('[data-testid="email-input"]');
    await emailField.setValue('user@example.com');
    
    // GOOD: Using data-testid for password
    const passwordField = await $('[data-testid="password-input"]');
    await passwordField.setValue('password123');
    
    // GOOD: Using data-testid for button
    const submitButton = await $('[data-testid="submit-button"]');
    await submitButton.click();
    
    // GOOD: Using CSS selector with data-testid
    const navLink = await $('[data-testid="dashboard-link"]');
    await navLink.click();
  });
  
  it('should use semantic selectors', async () => {
    await browser.url('https://account.box.com');
    
    // GOOD: Using data-testid for test selectors
    const welcomeMessage = await $('[data-testid="welcome-message"]').getText();
    expect(welcomeMessage).toContain('Welcome');
  });
});

