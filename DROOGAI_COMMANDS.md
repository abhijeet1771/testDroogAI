# DroogAI Commands for testDroogAI Project

## 📦 Repository Info
- **Repository:** `abhijeet1771/testDroogAI`
- **Main Branch:** `main`
- **GitHub URL:** https://github.com/abhijeet1771/testDroogAI.git

---

## 🚀 Step 1: Index Main Branch (First Time Setup)

### Command:
```powershell
cd "D:\DROOG AI"
npx tsx src/index.ts index --repo abhijeet1771/testDroogAI --branch main
```

### What it does:
- ✅ Fetches all files from main branch
- ✅ Parses code and extracts symbols
- ✅ Creates `.droog-embeddings.json` file
- ✅ Builds index for duplicate detection

### Expected Output:
```
📦 Indexing repository: abhijeet1771/testDroogAI (branch: main)
📥 Fetching repository tree...
✓ Found X files to index
📄 Filtered to X code files
Progress: X/X files (X symbols)
✅ Indexing complete!
```

---

## 🔍 Step 2: Review PR

### Command:
```powershell
cd "D:\DROOG AI"
npx tsx src/index.ts review --repo abhijeet1771/testDroogAI --pr <pr_number> --enterprise
```

### Replace `<pr_number>` with actual PR number:
```powershell
# Example: For PR #1
npx tsx src/index.ts review --repo abhijeet1771/testDroogAI --pr 1 --enterprise

# Example: For PR #2
npx tsx src/index.ts review --repo abhijeet1771/testDroogAI --pr 2 --enterprise
```

### What it does:
- ✅ Fetches PR files and changes
- ✅ Analyzes code for issues
- ✅ Generates review report
- ✅ Creates `report.json` file

### Expected Output:
```
🚀 Reviewing PR #1 for abhijeet1771/testDroogAI
📥 Fetching PR details...
📋 Analyzing X files...
🔍 Found X issues
✅ Review complete!
📄 Report saved to: report.json
```

---

## ⚙️ Environment Variables (Required)

### Set before running commands:
```powershell
# GitHub Token (Required)
$env:GITHUB_TOKEN = "your_github_token_here"

# Gemini API Key (Required for enterprise review)
$env:GEMINI_API_KEY = "your_gemini_api_key_here"
```

### Or create `.env` file in `D:\DROOG AI`:
```
GITHUB_TOKEN=your_github_token_here
GEMINI_API_KEY=your_gemini_api_key_here
```

---

## 📋 Quick Reference

### Index Command:
```powershell
cd "D:\DROOG AI"
npx tsx src/index.ts index --repo abhijeet1771/testDroogAI --branch main
```

### Review Command:
```powershell
cd "D:\DROOG AI"
npx tsx src/index.ts review --repo abhijeet1771/testDroogAI --pr <pr_number> --enterprise
```

---

## ✅ Checklist

- [ ] Environment variables set (GITHUB_TOKEN, GEMINI_API_KEY)
- [ ] DroogAI built (`npm run build`)
- [ ] Index command run (first time only)
- [ ] Review command run (for each PR)

---

## 🔄 Workflow

1. **First Time:**
   ```powershell
   # Index main branch
   npx tsx src/index.ts index --repo abhijeet1771/testDroogAI --branch main
   ```

2. **For Each PR:**
   ```powershell
   # Review PR
   npx tsx src/index.ts review --repo abhijeet1771/testDroogAI --pr <number> --enterprise
   ```

---

## 📝 Notes

- Index command needs to run **only once** per repository
- Review command can run **multiple times** for different PRs
- Use `--enterprise` flag for full feature review
- Review report is saved in `report.json`

