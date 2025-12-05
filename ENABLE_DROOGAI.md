# Enable DroogAI Auto Review - Simple Steps

## ✅ Already Implemented!

DroogAI mein already GitHub Actions workflow implementation hai. Sirf enable karna hai!

---

## 🚀 Quick Enable Steps

### Step 1: Workflow Already Created ✅

Workflow file already hai:
- `.github/workflows/droog-review.yml` ✅

### Step 2: Add GitHub Secrets

1. Go to: https://github.com/abhijeet1771/testDroogAI/settings/secrets/actions
2. Click: **"New repository secret"**
3. Add:
   - **Name:** `GEMINI_API_KEY`
   - **Value:** Your Gemini API key
   - Click: **"Add secret"**

### Step 3: Done! 🎉

Ab PR create karo, DroogAI automatically:
- ✅ Review karega
- ✅ Comments post karega

---

## 📋 What's Already There

### Workflow Features:
- ✅ Auto-trigger on PR open/update
- ✅ Auto-install DroogAI from GitHub
- ✅ Auto-index main branch (first time)
- ✅ Auto-review with enterprise features
- ✅ Auto-post comments to PR
- ✅ Upload review report

### Workflow File:
- ✅ `.github/workflows/droog-review.yml` - Already created

---

## 🔧 Using DroogAI's Built-in Command

Agar kisi aur project mein enable karna hai:

```bash
cd "your-project"
npx tsx "D:\DROOG AI\src\integration\setup-github.ts"
```

Ya:

```bash
cd "D:\DROOG AI"
npx tsx src/index.ts setup-github
```

Yeh automatically create karega:
- `.github/workflows/droog-review.yml`
- `.github/workflows/droog-index.yml`

---

## ✅ Summary

**For testDroogAI:**
- ✅ Workflow already created
- ⚠️  Just add `GEMINI_API_KEY` secret
- ✅ Ready to use!

**For other projects:**
- Run `setup-github` command
- Add secrets
- Done!

---

## 🎯 Next Steps

1. Add `GEMINI_API_KEY` secret
2. Create a test PR
3. Watch DroogAI automatically review! 🚀

