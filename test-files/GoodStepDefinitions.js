const { Given, When, Then } = require('@cucumber/cucumber');

// GOOD: Using Cucumber expressions
Given('I am on the {string} page', async (pageName) => {
  // Implementation
});

// GOOD: Using Cucumber expressions with parameters
When('I enter my email address {string}', async (email) => {
  // Implementation with semantic locator
  await page.getByLabel('Email').fill(email);
});

// GOOD: Using Cucumber expressions
Then('I should see {string}', async (expectedText) => {
  // Implementation
});

// GOOD: Parameterized step definition
Given('I am logged in as {string}', async (userType) => {
  const credentials = getCredentialsForUserType(userType);
  await page.getByLabel('Email').fill(credentials.email);
  await page.getByLabel('Password').fill(credentials.password);
  await page.getByRole('button', { name: 'Sign In' }).click();
});

function getCredentialsForUserType(userType) {
  const credentials = {
    admin: { email: 'admin@example.com', password: 'admin123' },
    user: { email: 'user@example.com', password: 'user123' }
  };
  return credentials[userType];
}

