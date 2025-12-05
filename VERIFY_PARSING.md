# Parsing Verification Guide

## 🔍 Parsing Verify Kaise Karein?

### Method 1: Index File Check

Index command run karne ke baad check karo:

```bash
cd "D:\DROOG AI"
dir .droog-embeddings.json
```

Agar file hai to parsing successful hai!

### Method 2: Analyze Command Test

Specific file analyze karke verify karo:

```bash
cd "D:\DROOG AI"
npx tsx src/index.ts analyze --file "D:\testDroogAI\test-files\Calculator.java"
```

**Expected Output:**
- ✅ Symbols extract honge (classes, methods)
- ✅ Tree-sitter ya regex fallback use hoga
- ✅ Symbol details dikhenge

### Method 3: Verification Script

Quick verification script run karo:

```powershell
cd D:\testDroogAI
.\verify-parsing.ps1
```

Yeh script automatically check karega:
- ✅ Index file exists ya nahi
- ✅ Analyze command kaam kar raha hai ya nahi
- ✅ Symbols extract ho rahe hain ya nahi

### Method 4: Index Command Output

Index command run karte waqt output dekho:

```bash
cd "D:\DROOG AI"
npx tsx src/index.ts index --repo abhijeet1771/testDroogAI --branch main
```

**Success Indicators:**
- ✅ "Indexing complete!" message
- ✅ "Symbols indexed: X" (X > 0)
- ✅ "Files processed: X"
- ✅ No errors

### Method 5: Check Index Content

Index file ka content check karo:

```bash
cd "D:\DROOG AI"
type .droog-embeddings.json | findstr "symbols"
```

Ya PowerShell mein:
```powershell
$index = Get-Content "D:\DROOG AI\.droog-embeddings.json" | ConvertFrom-Json
$index.symbols.Count
```

## ✅ Success Criteria

Parsing successful hai agar:
- ✅ `.droog-embeddings.json` file create hui
- ✅ File size > 0 bytes
- ✅ Analyze command symbols extract kar raha hai
- ✅ Index command "Symbols indexed: X" dikhata hai (X > 0)

## ⚠️ Common Issues

1. **No symbols found**
   - Check karo ki repository mein code files hain
   - GitHub token valid hai ya nahi

2. **Index file not created**
   - Index command properly run hui ya nahi
   - Permissions check karo

3. **Tree-sitter fallback warning**
   - Normal hai - regex fallback bhi kaam karta hai
   - Parsing still successful hai

