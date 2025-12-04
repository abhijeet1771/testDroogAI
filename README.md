# testDroogAI - Demo Project

Demo project setup for testing DroogAI features with Playwright.

## Setup

```bash
cd D:\testDroogAI
npm install
npx playwright install chromium
```

## Dependencies

- **Playwright** - For browser automation tests
- **DroogAI** - Installed as local dependency from `D:\DROOG AI`

## Project Structure

```
testDroogAI/
├── package.json
├── playwright.config.js
├── setup.ps1
└── tests/          # Test scripts will be added in a branch
```

## Requirements

- Node.js installed
- DroogAI source code at `D:\DROOG AI` (linked as dependency)
- Playwright browsers installed (`npx playwright install chromium`)

## Index Command (Main Branch Parse)

Pehle main branch ko index karo:

```bash
cd "D:\DROOG AI"
npx tsx src/index.ts index --repo abhijeet1771/testDroogAI --branch main
```

Yeh command:
- Repository se saare files fetch karega
- Code parse karega
- Symbols extract karega
- `.droog-embeddings.json` file create karega

Details: `INDEX_COMMAND.md` dekho

## Test Files

Test files `test-files/` folder mein hain:
- `Calculator.java` - Simple calculator with potential issues
- `UserService.java` - Service class with missing validations

## 🤖 Automatic PR Review with DroogAI

DroogAI automatically reviews PRs when they're created or updated!

### Setup (One Time)

1. **Add GitHub Secrets:**
   - Go to: Settings → Secrets and variables → Actions
   - Add `GEMINI_API_KEY` (your Gemini API key)
   - `GITHUB_TOKEN` is auto-provided by GitHub Actions

2. **First PR:**
   - Workflow will automatically index main branch
   - Then review the PR
   - Post comments automatically

3. **Subsequent PRs:**
   - Just create PR, DroogAI will review automatically!

### Manual Trigger

You can also manually trigger review:
- Go to Actions tab
- Select "Droog AI Code Review"
- Click "Run workflow"
- Enter PR number

## Note

Test scripts will be added in a separate branch.

