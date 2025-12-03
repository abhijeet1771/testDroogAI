const { test, expect } = require('@playwright/test');

test('Box Login Page - Title and URL', async ({ page }) => {
  await page.goto('https://account.box.com/login');
  await page.waitForLoadState('networkidle');
  const title = await page.title();
  const url = page.url();
  console.log('\n Box Login Page Test Results:');
  console.log('');
  console.log( Page Title: );
  console.log( Current URL: );
  console.log('\n');
  expect(title).toMatch(/Box|Sign In|Login/i);
  expect(url).toContain('account.box.com/login');
  await expect(page.locator('input[type="email"], input[name="login"]')).toBeVisible();
});
