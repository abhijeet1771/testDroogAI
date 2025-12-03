# Quick Verification Guide

## ✅ Parsing Verify Kaise Karein?

### Method 1: Java Files Analyze Karo (Recommended)

DroogAI abhi Java files ke liye optimize hai. Test files analyze karo:

```bash
cd "D:\DROOG AI"

# Calculator.java analyze karo
npx tsx src/index.ts analyze --file "D:\testDroogAI\test-files\Calculator.java"

# UserService.java analyze karo  
npx tsx src/index.ts analyze --file "D:\testDroogAI\test-files\UserService.java"
```

**Expected Output:**
- ✅ Symbols extract honge (classes, methods)
- ✅ Symbol details dikhenge
- ✅ Tree-sitter ya regex fallback message

### Method 2: Index Command Run Karo

Main branch index karke verify karo:

```bash
cd "D:\DROOG AI"
npx tsx src/index.ts index --repo abhijeet1771/testDroogAI --branch main
```

**Success Indicators:**
- ✅ "Indexing complete!" message
- ✅ "Symbols indexed: X" (X > 0)
- ✅ ".droog-embeddings.json" file create hui

### Method 3: Index File Check

```powershell
cd "D:\DROOG AI"
Test-Path ".droog-embeddings.json"
```

Agar `True` aaye to parsing successful!

## 📝 Note

- `test-droogai.js` ek test script hai, DroogAI analyze karne ke liye nahi
- Actual test files: `Calculator.java` aur `UserService.java`
- DroogAI abhi Java files ke liye optimize hai

