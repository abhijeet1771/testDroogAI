/**
 * Box.com Dashboard Page Object
 * Contains locators and methods for Box dashboard
 */

class BoxDashboardPage {
  constructor(page) {
    this.page = page;
    
    // Locators
    this.userMenu = page.locator('[aria-label*="Account"], [data-testid*="user"], button:has-text("Account")');
    this.uploadButton = page.locator('button:has-text("Upload"), [aria-label*="Upload"]');
    this.newButton = page.locator('button:has-text("New"), [aria-label*="New"]');
    this.filesList = page.locator('[data-testid*="file"], .file-item, [role="row"]');
    this.searchInput = page.locator('input[type="search"], input[placeholder*="Search"]');
    this.logoutButton = page.locator('button:has-text("Log Out"), a:has-text("Log Out")');
  }

  async waitForDashboard() {
    await this.page.waitForLoadState('networkidle');
    // Wait for any dashboard element to be visible
    await Promise.race([
      this.userMenu.waitFor({ state: 'visible', timeout: 10000 }).catch(() => {}),
      this.uploadButton.waitFor({ state: 'visible', timeout: 10000 }).catch(() => {}),
      this.page.waitForTimeout(2000)
    ]);
  }

  async isLoggedIn() {
    try {
      const userMenuVisible = await this.userMenu.isVisible({ timeout: 5000 });
      return userMenuVisible;
    } catch {
      return false;
    }
  }

  async searchFiles(query) {
    await this.searchInput.fill(query);
    await this.page.keyboard.press('Enter');
    await this.page.waitForTimeout(1000);
  }

  async getFileCount() {
    const files = await this.filesList.all();
    return files.length;
  }

  async logout() {
    try {
      await this.userMenu.click();
      await this.page.waitForTimeout(500);
      await this.logoutButton.click();
    } catch {
      // Try alternative logout method
      await this.page.goto('https://account.box.com/logout');
    }
  }
}

module.exports = { BoxDashboardPage };


