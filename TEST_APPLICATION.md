# Application Testing Guide - DroogAI

## 🎯 Goal
Test karna hai ki DroogAI properly kaam kar raha hai ya nahi.

---

## 📋 Step-by-Step Testing

### Step 1: Check DroogAI Installation

```powershell
cd "D:\DROOG AI"
npm install
npm run build
```

**Expected:** Build successful, no errors

---

### Step 2: Test Basic Commands

#### Test 1: Check if DroogAI CLI works
```powershell
cd "D:\DROOG AI"
npx tsx src/index.ts --help
```

**Expected:** Commands list dikhe (review, index, analyze, etc.)

---

### Step 3: Test Index Command (First Time Setup)

```powershell
cd "D:\DROOG AI"

# Set environment variables (if not in .env)
$env:GITHUB_TOKEN = "your_github_token"
$env:GEMINI_API_KEY = "your_gemini_key"

# Index main branch
npx tsx src/index.ts index --repo abhijeet1771/testDroogAI --branch main
```

**Expected:**
- ✅ Repository files fetch honge
- ✅ Code parse hoga
- ✅ `.droog-embeddings.json` file create hogi
- ✅ "Indexing complete!" message

**Check:**
```powershell
Test-Path "D:\DROOG AI\.droog-embeddings.json"
# Should return: True
```

---

### Step 4: Test Analyze Command

```powershell
cd "D:\DROOG AI"
npx tsx src/index.ts analyze --file "D:\testDroogAI\test-files\Calculator.java"
```

**Expected:**
- ✅ Symbols extract honge
- ✅ Symbol details dikhenge
- ✅ Analysis complete message

---

### Step 5: Test Review Command (Main Feature)

#### Option A: Test with existing PR
```powershell
cd "D:\DROOG AI"
npx tsx src/index.ts review --repo abhijeet1771/testDroogAI --pr 1
```

#### Option B: Test with AI-reviewer repo
```powershell
cd "D:\DROOG AI"
npx tsx src/index.ts review --repo abhijeet1771/AI-reviewer --pr <pr_number> --enterprise
```

**Expected:**
- ✅ PR files fetch honge
- ✅ Code analysis hoga
- ✅ Issues find honge
- ✅ Review report generate hoga
- ✅ `report.json` file create hogi

**Check:**
```powershell
Test-Path "D:\DROOG AI\report.json"
# Should return: True
```

---

## ✅ Quick Test Checklist

- [ ] DroogAI builds successfully
- [ ] CLI commands work (`--help` shows commands)
- [ ] Index command works (creates `.droog-embeddings.json`)
- [ ] Analyze command works (extracts symbols)
- [ ] Review command works (creates `report.json`)

---

## 🐛 Common Issues

### Issue 1: GitHub Token Missing
**Error:** `❌ GitHub token required`

**Solution:**
```powershell
$env:GITHUB_TOKEN = "your_token_here"
```

### Issue 2: Gemini API Key Missing
**Error:** `❌ Gemini API key required`

**Solution:**
```powershell
$env:GEMINI_API_KEY = "your_key_here"
```

### Issue 3: Tree-sitter Fallback Warning
**Warning:** `⚠️ Tree-sitter not available, using regex fallback`

**Solution:** Normal hai, regex fallback bhi kaam karta hai. But better parsing ke liye:
```powershell
cd "D:\DROOG AI"
npm install tree-sitter tree-sitter-java
```

---

## 📝 Test Results Template

```
✅ Build: PASS/FAIL
✅ CLI Help: PASS/FAIL
✅ Index Command: PASS/FAIL
✅ Analyze Command: PASS/FAIL
✅ Review Command: PASS/FAIL

Notes:
- [Any issues found]
- [Any warnings]
```

---

## 🚀 Next Steps After Testing

1. If all tests pass → Implement Option C (GitHub Actions) + Option 1 (Setup wizard)
2. If tests fail → Fix issues first
3. Document any problems found

