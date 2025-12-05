describe('Login Tests with Bad Locators', () => {
  it('should login using XPath', async () => {
    await browser.url('https://account.box.com');
    
    // BAD: Using XPath (should use data-testid or CSS)
    const emailField = await $('//input[@id="email"]');
    await emailField.setValue('user@example.com');
    
    // BAD: Using ID selector (should use data-testid)
    const passwordField = await $('#password');
    await passwordField.setValue('password123');
    
    // BAD: Using XPath for button
    const submitButton = await $('//button[@type="submit"]');
    await submitButton.click();
    
    // BAD: Using complex XPath
    const navLink = await $('//div[@class="nav"]/a[@href="/dashboard"]');
    await navLink.click();
  });
  
  it('should get text using bad selector', async () => {
    await browser.url('https://account.box.com');
    
    // BAD: Using button selector without data-testid
    const buttonText = await $('button').getText();
    expect(buttonText).toBe('Submit');
  });
});

