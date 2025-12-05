# Test Branch: Locator & Gherkin Improvements

This branch tests DroogAI's new features:
1. **Locator Suggestions** for Playwright, WebDriverIO, and Selenium
2. **Gherkin/Feature File Improvements**

## Test Files

### Negative Scenarios (Should Trigger Suggestions)

#### Playwright
- `PlaywrightBadLocators.spec.ts` - Contains:
  - XPath usage (should suggest getByRole/getByTestId)
  - CSS selectors for buttons (should suggest getByRole)
  - ID selectors (should suggest getByTestId)
  - text= selectors (should suggest getByText)

#### WebDriverIO
- `WebDriverIOBadLocators.js` - Contains:
  - XPath usage (should suggest data-testid)
  - ID selectors (should suggest data-testid)
  - Complex XPath (should suggest simpler selectors)

#### Selenium
- `SeleniumBadLocators.java` - Contains:
  - XPath usage (should suggest By.id or By.cssSelector)
  - CSS selector for IDs (should suggest By.id)
  - className selectors (should suggest data-testid)

#### Gherkin
- `BadFeatureFile.feature` - Contains:
  - Feature title with "Test" (should suggest business value)
  - Scenario titles with "Test" (should suggest user behavior)
  - Steps with implementation details (click, type, fill)
  - Vague language ("something", "stuff")

- `BadStepDefinitions.js` - Contains:
  - Regex instead of Cucumber expressions
  - Hardcoded values in step definitions

### Positive Scenarios (Should NOT Trigger Suggestions)

#### Playwright
- `PlaywrightGoodLocators.spec.ts` - Contains:
  - getByRole() for buttons and links
  - getByTestId() for test selectors
  - getByLabel() for form fields
  - getByText() for text content

#### WebDriverIO
- `WebDriverIOGoodLocators.js` - Contains:
  - data-testid attributes
  - Semantic CSS selectors

#### Selenium
- `SeleniumGoodLocators.java` - Contains:
  - By.id() for ID selectors
  - By.cssSelector() with data-testid

#### Gherkin
- `GoodFeatureFile.feature` - Contains:
  - Business value in feature title
  - User behavior in scenario titles
  - Given-When-Then structure
  - Clear, specific language

- `GoodStepDefinitions.js` - Contains:
  - Cucumber expressions instead of regex
  - Parameterized step definitions

## Expected Results

When running DroogAI review on this PR, you should see:

1. **Locator Suggestions Section:**
   - Framework detection (Playwright/WebDriverIO/Selenium)
   - Suggestions for bad locators in negative scenario files
   - No suggestions for good locator files

2. **Gherkin Improvements Section:**
   - Readability score
   - Suggestions for bad feature files and step definitions
   - No suggestions for good feature files

## How to Test

```bash
# From DroogAI directory
npx tsx src/index.ts review --repo abhijeet1771/testDroogAI --pr <PR_NUMBER> --enterprise --post
```

Replace `<PR_NUMBER>` with the PR number created from this branch.

