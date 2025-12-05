/**
 * Box.com Login Page Object
 * Contains locators and methods for Box login page
 */

class BoxLoginPage {
  constructor(page) {
    this.page = page;
    
    // Locators
    this.emailInput = page.locator('input[type="email"], input[name="login"], input[id*="login"]');
    this.passwordInput = page.locator('input[type="password"], input[name="password"]');
    this.loginButton = page.locator('button[type="submit"], button:has-text("Log In"), button:has-text("Sign In")');
    this.errorMessage = page.locator('.error, .alert, [role="alert"]');
    this.forgotPasswordLink = page.locator('a:has-text("Forgot"), a:has-text("Reset")');
  }

  async navigate() {
    await this.page.goto('https://account.box.com/login');
    await this.page.waitForLoadState('networkidle');
  }

  async enterEmail(email) {
    await this.emailInput.fill(email);
  }

  async enterPassword(password) {
    await this.passwordInput.fill(password);
  }

  async clickLogin() {
    await this.loginButton.click();
  }

  async login(email, password) {
    await this.navigate();
    await this.enterEmail(email);
    await this.enterPassword(password);
    await this.clickLogin();
  }

  async isErrorVisible() {
    return await this.errorMessage.isVisible();
  }

  async getErrorMessage() {
    return await this.errorMessage.textContent();
  }
}

module.exports = { BoxLoginPage };

