# Local Testing Guide - testDroogAI

## 🚀 Local Testing Steps

### Step 1: Install Dependencies

```powershell
cd D:\testDroogAI
npm install
```

### Step 2: Install Playwright Browsers

```powershell
npx playwright install chromium
```

### Step 3: Run Tests

#### Option A: Run All Tests
```powershell
npm test
```

#### Option B: Run Specific Tests

**Box Login Test:**
```powershell
npm run test:box
```

**DroogAI Tests:**
```powershell
npm run test:droog
```

---

## 📋 Test Files

### 1. Box Login Test
- **File:** `tests/box-login.spec.js`
- **What it does:** Opens Box login page and checks title/URL
- **Run:** `npm run test:box`

### 2. DroogAI Tests
- **File:** `tests/test-droogai.js`
- **What it does:** Tests DroogAI index and analyze commands
- **Run:** `npm run test:droog`
- **Note:** Requires DroogAI to be installed locally

---

## 🔧 DroogAI Local Setup

### Install DroogAI Locally

```powershell
# Option 1: Using npm link (if DroogAI is built)
cd "D:\DROOG AI"
npm link

cd D:\testDroogAI
npm link droog-ai
```

### Or Use Local File Dependency

`package.json` mein already hai:
```json
"droog-ai": "file:D:/DROOG AI"
```

Just run:
```powershell
npm install
```

---

## ✅ Quick Test Commands

```powershell
# 1. Install everything
cd D:\testDroogAI
npm install
npx playwright install chromium

# 2. Test Box login
npm run test:box

# 3. Test DroogAI (if installed)
npm run test:droog

# 4. Run all tests
npm test
```

---

## 🐛 Troubleshooting

### Issue: DroogAI not found
**Solution:** Make sure DroogAI is built:
```powershell
cd "D:\DROOG AI"
npm install
npm run build
```

### Issue: Playwright browsers not installed
**Solution:**
```powershell
npx playwright install chromium
```

### Issue: Tests failing
**Solution:** Check if all dependencies are installed:
```powershell
npm install
```

---

## 📝 Expected Output

### Box Login Test:
```
✓ Box Login Page - Title and URL (X ms)
  Page Title: Sign In | Box
  Current URL: https://account.box.com/login
```

### DroogAI Tests:
```
🚀 DroogAI Feature Tests
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
📦 Repository: abhijeet1771/testDroogAI
🌿 Branch: main

📋 Test 1: Index GitHub Repository
...
```



