const { Given, When, Then } = require('@cucumber/cucumber');

// BAD: Using regex instead of Cucumber expressions
Given(/^I am on (.*) page$/, async (pageName) => {
  // Implementation
});

// BAD: Using regex with hardcoded values
When(/^I type "([^"]*)" in email field$/, async (email) => {
  // Implementation with hardcoded selector
  await page.locator('#email').fill(email);
});

// BAD: Using regex for step definition
Then(/^I should see (.*)$/, async (expectedText) => {
  // Implementation
});

// BAD: Hardcoded values in step definition
Given(/^I am logged in as admin$/, async () => {
  await page.locator('#email').fill('admin@example.com');
  await page.locator('#password').fill('admin123');
  await page.locator('button[type="submit"]').click();
});

